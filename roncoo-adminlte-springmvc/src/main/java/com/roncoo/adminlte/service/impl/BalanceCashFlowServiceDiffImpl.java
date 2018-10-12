package com.roncoo.adminlte.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TFinanceCashFlowDiff;
import com.roncoo.adminlte.service.BalanceCashFlowDiffService;
import com.roncoo.adminlte.service.TFinanceMainService;
import com.roncoo.adminlte.service.impl.dao.BalanceCashFlowDiffDao;
import com.roncoo.adminlte.util.IndicesTool;
import com.roncoo.adminlte.util.Tools;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 解析现金流量表差额表
 * Created by andrew on 2017/11/27.
 */
@Service
public class BalanceCashFlowServiceDiffImpl implements BalanceCashFlowDiffService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BalanceCashFlowDiffDao balanceCashFlowDao;
    @Autowired
    private TFinanceMainService mainService;

    @Override
    public int insert(TFinanceCashFlowDiff obj) {
        return balanceCashFlowDao.insert(obj);
    }

    @Override
    public int insertBatch(@Param("list") List<TFinanceCashFlowDiff> list) {
        return balanceCashFlowDao.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return balanceCashFlowDao.deleteById(id);
    }

    @Override
    public int deleteByProperty(Long tfheadid) {
        TFinanceCashFlowDiff obj = new TFinanceCashFlowDiff();
        obj.setFheadId(tfheadid);
        return balanceCashFlowDao.deleteByProperty(obj);
    }

    @Override
    public List<TFinanceCashFlowDiff> queryByProperty(Long tfheadid) {
        Map map = new HashMap();
        map.put("fhead_id",tfheadid);
        return balanceCashFlowDao.queryByProperty(map);
    }

    @Override
    public JSONObject importHandler(Workbook wb, String sheetName, String companyNumber, String period, RcUser rcUser) {
        Sheet sheet = wb.getSheet(sheetName);
        JSONObject object = new JSONObject();
        if (sheet==null){
            object.put("stateCode", 0);
            object.put("error", "模板为空");
        }else{
            int rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("行数 rowCount="+rowCount);
            if(rowCount==0 ){
                object.put("stateCode", 0);
                object.put("error", "模板为空");
                System.out.println("模板为空");
            }else{
                List<TFinanceCashFlowDiff> bslist = new ArrayList<>();
                int size = rowCount;
                for (int r = 4; r < 49; r++) {
                    Row row = sheet.getRow(r);
                    if(row!=null){
                        TFinanceCashFlowDiff bc = new TFinanceCashFlowDiff();
                        String fproject = Tools.getCellValue(row.getCell(0), wb);
                        if (fproject!=null && fproject.contains("单位负责人")){
                            break;
                        }
                        logger.debug("row index: {}", r);
                        String cellValue1 = Tools.getCellValue(row.getCell(1), wb);
                        BigDecimal c1 = Tools.getDecimalCellValue(cellValue1);
                        String cellValue2 = Tools.getCellValue(row.getCell(2), wb);
                        BigDecimal c2 = Tools.getDecimalCellValue(cellValue2);
                        String c3 = Tools.getCellValue(row.getCell(3), wb);
                        String cellValue4 = Tools.getCellValue(row.getCell(4), wb);
                        BigDecimal c4 = Tools.getDecimalCellValue(cellValue4);
                        String cellValue5 = Tools.getCellValue(row.getCell(5), wb);
                        BigDecimal c5 = Tools.getDecimalCellValue(cellValue5);
                        //System.out.println(fproject+" / "+c1+" / "+c2+" / "+c3+" / "+c4+" / "+c5);
                        bc.setFproject(fproject);
                        bc.setFthisPeriodCum(c1);
                        bc.setFlastYearCum(c2);
                        bc.setFotherData(c3);
                        bc.setFthisPeriodCum2(c4);
                        bc.setFlastYearCum2(c5);
                        bc.setFsheetRowIndex(Long.parseLong(r+""));
                        if(Tools.isRowStrong(8,bc.getFsheetRowIndex().intValue())){
                            bc.setFisStrong(new Long(1));
                        } else {
                            bc.setFisStrong(new Long(0));
                        }
                        bslist.add(bc);
                    }
                    System.out.println();
                }
                Long tfheadId = mainService.getOrAddFinanceMainId(companyNumber,sheetName,period,rcUser);
                if(tfheadId!=0){
                    for (TFinanceCashFlowDiff bc : bslist) { bc.setFheadId(tfheadId); }
                    int row = deleteByProperty(tfheadId);
                    System.out.println("删除"+sheetName+"记录表数据：row="+row);
                    int row1 = insertBatch(bslist);
                    System.out.println("批量插入"+sheetName+"模板数据，影响行数 row1="+row1);
                    //查询主列表并返回页面
                    object = queryByHeadId(tfheadId);
                }else{
                    System.out.println("新增导入记录失败");
                    object.put("error","新增导入记录失败");
                    object.put("stateCode",0);
                }
            }
        }
        return object;
    }

    @Override
    public JSONObject queryByHeadId(Long fheadid) {
        JSONObject object = new JSONObject();
        List<TFinanceCashFlowDiff> list = queryByProperty(fheadid);
        if(list==null || list.isEmpty()){
            object.put("error","暂无数据");
            object.put("stateCode", 0);
        }else{
            JSONArray array = IndicesTool.balanceCashFlowToArray2(list);
            object.put("datas",array);
            object.put("stateCode", 200);
        }
        return object;
    }
}
