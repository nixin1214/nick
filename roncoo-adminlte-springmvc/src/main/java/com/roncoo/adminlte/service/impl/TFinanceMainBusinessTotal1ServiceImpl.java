package com.roncoo.adminlte.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TFinanceMain;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessTotal1;
import com.roncoo.adminlte.bean.entity.TFinanceProductCostThis;
import com.roncoo.adminlte.service.TFinanceMainBusinessTotal1Service;
import com.roncoo.adminlte.service.TFinanceMainService;
import com.roncoo.adminlte.service.TFinanceProductCostThisService;
import com.roncoo.adminlte.service.impl.dao.TFinanceMainBusinessTotal1Dao;
import com.roncoo.adminlte.service.impl.dao.TFinanceProductCostThisDao;
import com.roncoo.adminlte.util.Tools;
import org.apache.poi.ss.usermodel.Cell;
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
 * roncoo-adminlte-springmvc
 *
 * @Description: 产品成本汇总表(累计)
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 12:01
 */
@Service
public class TFinanceMainBusinessTotal1ServiceImpl implements TFinanceMainBusinessTotal1Service {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TFinanceMainBusinessTotal1Dao dao;
    @Autowired
    private TFinanceMainService mainService;

    /**
     * sheet页，需要写入数据的行号,{开始，结束}
     * 从0下标开始计数，包含首尾两行
     */
    private final int[] sheetCellArr = {5,40};

    @Override
    public int insert(TFinanceMainBusinessTotal1 empSalary) {
        return dao.insert(empSalary);
    }

    @Override
    public int insertBatch(List<TFinanceMainBusinessTotal1> list) {
        return dao.insertBatch(list);
    }

    @Override
    public int deleteById(BigDecimal id) {
        return dao.deleteById(id);
    }

    @Override
    public int deleteByHeadId(Long tfheadid) {
        return dao.deleteByHeadId(tfheadid);
    }

    @Override
    public JSONObject queryByHeadId(Long fheadid) {
        List<TFinanceMainBusinessTotal1> list = dao.queryByHeadId(fheadid);

        JSONObject object = new JSONObject();
        if(list==null || list.isEmpty()){
            object.put("error","暂无数据");
            object.put("stateCode", 0);
        }else {
            String text = JSON.toJSONString(list);
            object.put("datas", JSONArray.parseArray(text));
            object.put("stateCode", 200);
        }
        return object;
    }

    @Override
    public JSONObject importHandler(Workbook wb, String sheetName, String companyNumber, String period, RcUser rcUser) {
        Sheet sheet = wb.getSheet(sheetName);
        int rowCount = sheet.getPhysicalNumberOfRows();

        JSONObject object = new JSONObject();
        logger.debug("行数 rowCount={}", rowCount);
        if(rowCount==0){
            object.put("stateCode", 0);
            object.put("error", "模板为空");
            System.out.println("模板为空");
        }else{
            List<TFinanceMainBusinessTotal1> indiceList = new ArrayList<TFinanceMainBusinessTotal1>();
            int size = rowCount;
            for (int r = 5; r < size; r++) { //遍历有数据的行
                Row row = sheet.getRow(r);
                if(row!=null){
                    logger.debug("row index: {}", r);
                    String rowNum = Tools.getCellValue(row.getCell(0), wb);
                    String fproject = Tools.getCellValue(row.getCell(1), wb);
                    if (rowNum != null && rowNum.contains("单位负责人")) {
                        break;
                    } else if (fproject != null && fproject.contains("单位负责人")) {
                        break;
                    }
                    TFinanceMainBusinessTotal1 bc = new TFinanceMainBusinessTotal1();
                    BigDecimal c2 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(2), wb));
                    BigDecimal c3 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(3), wb));
                    BigDecimal c4 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(4), wb));
                    BigDecimal c5 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(5), wb));
                    BigDecimal c6 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(6), wb));
                    BigDecimal c7 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(7), wb));
                    BigDecimal c8 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(8), wb));
                    BigDecimal c9 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(9), wb));
                    BigDecimal c10 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(10), wb));
                    BigDecimal c11 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(11), wb));
                    BigDecimal c12 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(12), wb));
                    BigDecimal c13 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(13), wb));
                    BigDecimal c14 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(14), wb));
                    BigDecimal c15 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(15), wb));
                    BigDecimal c16 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(16), wb));
                    BigDecimal c17 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(17), wb));
                    BigDecimal c18 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(18), wb));
                    BigDecimal c19 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(19), wb));
                    BigDecimal c20 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(20), wb));
                    BigDecimal c21 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(21), wb));
                    BigDecimal c22 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(22), wb));
                    BigDecimal c23 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(23), wb));
                    BigDecimal c24 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(24), wb));
                    BigDecimal c25 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(25), wb));
                    BigDecimal c26 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(26), wb));
                    BigDecimal c27 = Tools.getDecimalCellValue( Tools.getCellValue(row.getCell(27), wb));

                    bc.setFrowNum(Tools.getRowNumIntString(rowNum));
                    bc.setFrowIndex(r);
                    bc.setFproject(fproject);
                    bc.setSaleBudget(c2);
                    bc.setSaleActual(c3);
                    bc.setBudgetProportion(c4);
                    bc.setActualProportion(c5);
                    bc.setBudgetPrice(c6);
                    bc.setActualPrice(c7);
                    bc.setBudgetSalePrice(c8);
                    bc.setActualSalePrice(c9);
                    bc.setBudgetUnitCost(c10);
                    bc.setActualUnitCost(c11);
                    bc.setBudgetSaleCost(c12);
                    bc.setActualSaleCost(c13);
                    bc.setBudgetUnitLevel(c14);
                    bc.setActualUnitLevel(c15);
                    bc.setBudgetGrossProfit(c16);
                    bc.setActualGrossProfit(c17);
                    bc.setBudgetGrossInterest(c18);
                    bc.setActualGrossInterest(c19);
                    bc.setBudgetXscb(c20);
                    bc.setActualXscb(c21);
                    bc.setBudgetDwsp(c22);
                    bc.setActualDwsp(c23);
                    bc.setBudgetYsml(c24);
                    bc.setActualYsml(c25);
                    bc.setBudgetYsll(c26);
                    bc.setActualYsll(c27);
                    if (Tools.isRowStrong(11,r)){ bc.setFstrong(new Long(1)); }
                    indiceList.add(bc);
                }
                System.out.println();
            }

            TFinanceMain mainIndic = mainService.selectByProperty(companyNumber,period,sheetName);
            Long tfheadId = 0L;
            if(mainIndic!=null && mainIndic.getFid()!=0){
                logger.info("主要记录表有导入记录");
                tfheadId = mainIndic.getFid();
            }else{
                logger.info("主要记录表没有导入记录");
                tfheadId =  mainService.addFinanceMain(companyNumber,sheetName,period,rcUser);
            }
            if(tfheadId!=0){
                for (TFinanceMainBusinessTotal1 fixedAssetsChange : indiceList) {
                    fixedAssetsChange.setFheadId(tfheadId);
                }
                int row = dao.deleteByHeadId(tfheadId);
                logger.debug("删除{}记录表数据：row={}", sheetName, row);
                int row1 = dao.insertBatch(indiceList);
                logger.debug("删除{}记录表数据：row1={}", sheetName, row1);
                //查询主列表并返回页面
                object = queryByHeadId(tfheadId);
            }else{
                logger.info("主导入记录新增失败");
                object.put("error","主导入记录新增失败");
                object.put("stateCode",0);
            }
        }
        return object;
    }

    @Override
    public List<TFinanceMainBusinessTotal1> queryByPropertyAll(List<Long> tfheadids) {
        return dao.queryByPropertyAll(tfheadids);
    }

    @Override
    public void exportHandler(Sheet sheet, List<Long> tfheadids){
        List<TFinanceMainBusinessTotal1> indices = queryByPropertyAll(tfheadids);
        if (indices.size() == 0) {
            return;
        }
        //按组织分解结果集
        Map<Long,List<TFinanceMainBusinessTotal1>> resultMap = new HashMap<>();
        for (Long fheadid : tfheadids) {
            List<TFinanceMainBusinessTotal1> item = new ArrayList<>();
            for (TFinanceMainBusinessTotal1 balance : indices) {
                if (balance.getFheadId().equals(fheadid)) {
                    item.add(balance);
                }
            }
            resultMap.put(fheadid,item);
        }

    }
}