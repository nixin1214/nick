package com.roncoo.adminlte.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.BalanceProfit;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TFinanceProfitDiff;
import com.roncoo.adminlte.service.BalanceProfitDiffService;
import com.roncoo.adminlte.service.TFinanceMainService;
import com.roncoo.adminlte.service.impl.dao.BalanceProfitDiffDao;
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
 * 利润表
 * Created by lx on 2017/11/11.
 */
@Service
public class BalanceProfitServiceDiffImpl implements BalanceProfitDiffService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BalanceProfitDiffDao dao;
    @Autowired
    private TFinanceMainService mainService;

    @Override
    public int insert(TFinanceProfitDiff obj) {
        return dao.insert(obj);
    }

    @Override
    public int insertBatch(@Param("list") List<TFinanceProfitDiff> list) {
        return dao.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public int deleteByProperty(Long tfheadid) {
        TFinanceProfitDiff obj = new TFinanceProfitDiff();
        obj.setFheadId(tfheadid);
        return dao.deleteByProperty(obj);
    }

    @Override
    public List<TFinanceProfitDiff> queryByProperty(Long tfheadid) {
        Map map = new HashMap();
        map.put("fhead_id",tfheadid);
        return dao.queryByProperty(map);
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
            if(rowCount==0){
                object.put("stateCode", 0);
                object.put("error", "模板为空");
            }else{
                List<TFinanceProfitDiff> bslist = new ArrayList<>();
                int size = rowCount;
                for (int r = 5; r < 32; r++) {
                    Row row = sheet.getRow(r);
                    if(row!=null){
                        TFinanceProfitDiff bs = new TFinanceProfitDiff();
                        String fproject = Tools.getCellValue(row.getCell(0), wb);
                        if (fproject!=null && fproject.contains("单位负责人")){
                            break;
                        }
                        String cellValue1 = Tools.getCellValue(row.getCell(1), wb);
                        Integer c1;
                        if(Tools.isEmpty(cellValue1)){
                            c1=0;
                        }else{
                            c1 = Integer.parseInt(Tools.getRowNumIntString(cellValue1));
                        }
                        logger.debug("row index: {}", r);
                        String cellValue2 = Tools.getCellValue(row.getCell(2), wb);
                        BigDecimal c2 = Tools.getDecimalCellValue(cellValue2);
                        String cellValue3 = Tools.getCellValue(row.getCell(3), wb);
                        BigDecimal c3 = Tools.getDecimalCellValue(cellValue3);
                        String cellValue4 = Tools.getCellValue(row.getCell(4), wb);
                        BigDecimal c4 = Tools.getDecimalCellValue(cellValue4);
                        String cellValue5 = Tools.getCellValue(row.getCell(5), wb);
                        BigDecimal c5 = Tools.getDecimalCellValue(cellValue5);
                        String cellValue6 = Tools.getCellValue(row.getCell(6), wb);
                        BigDecimal c6 = Tools.getDecimalCellValue(cellValue6);
                        String cellValue7 = Tools.getCellValue(row.getCell(7), wb);
                        BigDecimal c7 = Tools.getDecimalCellValue(cellValue7);

//                        System.out.println(fproject+" / "+c1+" / "+c2+" / "+c3+" / "+c4+" / "+c5+" / "+c6+" / "+c7);

                        bs.setFproject(fproject);
                        bs.setFrowNum(Long.parseLong(c1 + ""));
                        bs.setLastYearActual(c2);
                        bs.setLastYearTotal(c3);
                        bs.setThisYearBudget(c4);
                        bs.setThisYearBudgetTotal(c5);
                        bs.setThisYearActual(c6);
                        bs.setThisYearActualTotal(c7);
                        bs.setFrowIndex(Long.parseLong(r + ""));
                        if (Tools.isRowStrong(7, bs.getFrowIndex().intValue())) {
                            bs.setFstrong(new Long(1));
                        } else {
                            bs.setFstrong(new Long(0));
                        }
                        bslist.add(bs);
                    }
                    System.out.println();
                }

                Long tfheadId =  mainService.getOrAddFinanceMainId(companyNumber,sheetName,period,rcUser);
                if(tfheadId!=0){
                    for (TFinanceProfitDiff bs : bslist) {
                        bs.setFheadId(tfheadId);
                    }
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
        List<TFinanceProfitDiff> indices = queryByProperty(fheadid);
        if(indices==null || indices.isEmpty()){
            object.put("error","暂无数据");
            object.put("stateCode", 0);
        }else{
            JSONArray array = IndicesTool.balanceProfitListToJsonArray2(indices);
            object.put("datas",array);
            object.put("stateCode", 200);
        }
        return object;
    }
}
