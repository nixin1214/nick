package com.roncoo.adminlte.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.FinanceMainBusinessMonth;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessMDiff;
import com.roncoo.adminlte.service.BalanceMainBusinessMonthDiffService;
import com.roncoo.adminlte.service.TFinanceMainService;
import com.roncoo.adminlte.service.impl.dao.BalanceMainBusinessMonthDiffDao;
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
 * 解析主营业务收支总(本月)
 * Created by lx on 2017/11/14.
 */
@Service
public class BalanceMainBusinessMonthDiffServiceImpl implements BalanceMainBusinessMonthDiffService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BalanceMainBusinessMonthDiffDao dao;
    @Autowired
    private TFinanceMainService mainService;

    @Override
    public int insert(TFinanceMainBusinessMDiff obj) {
        return dao.insert(obj);
    }

    @Override
    public int insertBatch(@Param("list") List<TFinanceMainBusinessMDiff> list) {
        return dao.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public int deleteByProperty(Long tfheadid) {
        TFinanceMainBusinessMDiff obj = new TFinanceMainBusinessMDiff();
        obj.setFheadId(tfheadid);
        return dao.deleteByProperty(obj);
    }

    @Override
    public List<TFinanceMainBusinessMDiff> queryByProperty(Long tfheadid) {
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
                System.out.println("模板为空");
            }else{
                List<TFinanceMainBusinessMDiff> bslist = new ArrayList<>();
                int size = rowCount;
                for (int r = 5; r < size; r++) {
                    Row row = sheet.getRow(r);
                    if(row!=null){
                        String rowNum = Tools.getCellValue(row.getCell(0), wb);
                        if (rowNum!=null && rowNum.contains("单位负责人")){
                            break;
                        }
                        String fproject = Tools.getCellValue(row.getCell(1), wb);
                        if (fproject!=null && fproject.contains("单位负责人")){
                            break;
                        }
                        logger.debug("row index: {}", r);
                        TFinanceMainBusinessMDiff bc = new TFinanceMainBusinessMDiff();
                        BigDecimal c2 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(2), wb));
                        BigDecimal c3 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(3), wb));
                        BigDecimal c4 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(4), wb));
                        BigDecimal c5 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(5), wb));
                        BigDecimal c6 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(6), wb));
                        BigDecimal c7 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(7), wb));
                        BigDecimal c8 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(8), wb));
                        BigDecimal c9 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(9), wb));
                        BigDecimal c10 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(10), wb));
                        BigDecimal c11 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(11), wb));
                        BigDecimal c12 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(12), wb));
                        BigDecimal c13 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(13), wb));
                        BigDecimal c14 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(14), wb));

//                        System.out.println("rowNum="+rowNum+" / fproject="+fproject+" / c2="+c2+" / "+c3+" / "+c4+" / "+c5+" / "+c6+" / "+c7+" / "+c8+" / "+
//                                c9+" / "+c10+" / "+c11+" / "+c12+" / "+c13+" / "+c14);

                        bc.setFrowNum(Tools.getRowNumIntString(rowNum));
                        bc.setFproject(fproject);
                        bc.setSaleBudget(c2);
                        bc.setSaleActual(c3);
                        bc.setIncomeBudget(c4);
                        bc.setIncomeActual(c5);
                        bc.setIncomeTotal(c6);
                        bc.setCostBudget(c7);
                        bc.setCostActual(c8);
                        bc.setCostTotal(c9);
                        bc.setSaleProfitBudget(c10);
                        bc.setSaleProfitActual(c11);
                        bc.setSaleProfitBudgetRatio(c12);
                        bc.setSaleProfitActualRatio(c13);
                        bc.setSaleTotal(c14);
                        bc.setFrowIndex(new Long(r));
                        if (Tools.isRowStrong(9,r)){
                            bc.setFstrong(new Long(1));
                        }
                        bslist.add(bc);
                    }
                    System.out.println();
                }
                Long tfheadId =  mainService.getOrAddFinanceMainId(companyNumber,sheetName,period,rcUser);
                if(tfheadId!=0){
                    for (TFinanceMainBusinessMDiff bc : bslist) { bc.setFheadId(tfheadId); }
                    int row = deleteByProperty(tfheadId);
                    System.out.println("删除"+sheetName+"记录表数据：row="+row);
                    int row1 = insertBatch(bslist);
                    System.out.println("批量插入"+sheetName+"模板数据，影响行数 row1="+row1);
                    //查询主列表并返回页面
                    object = queryByHeadId(tfheadId);
                }else{
                    object.put("error","导入记录新增失败");
                    object.put("stateCode",0);
                }
            }
        }
        return object;
    }

    @Override
    public JSONObject queryByHeadId(Long fheadid) {
        JSONObject object = new JSONObject();
        List<TFinanceMainBusinessMDiff> list = queryByProperty(fheadid);
        if(list==null || list.isEmpty()){
            object.put("error","暂无数据");
            object.put("stateCode", 0);
        }else{
            JSONArray array = IndicesTool.balanceMainBusinessMonthToArray2(list);
            object.put("datas",array);
            object.put("stateCode", 200);
        }
        return object;
    }
}
