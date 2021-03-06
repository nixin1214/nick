package com.roncoo.adminlte.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TFinanceMain;
import com.roncoo.adminlte.bean.entity.TFinanceMilkCostTotal;
import com.roncoo.adminlte.service.TFinanceMainService;
import com.roncoo.adminlte.service.TFinanceMilkCostTotalService;
import com.roncoo.adminlte.service.impl.dao.TFinanceMilkCostTotalDao;
import com.roncoo.adminlte.util.Tools;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 乳制品成本明细表(本月)
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 12:01
 */
@Service
public class TFinanceMilkCostTotalServiceImpl implements TFinanceMilkCostTotalService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TFinanceMilkCostTotalDao dao;
    @Autowired
    private TFinanceMainService mainService;

    @Override
    public int insert(TFinanceMilkCostTotal empSalary) {
        return dao.insert(empSalary);
    }

    @Override
    public int insertBatch(List<TFinanceMilkCostTotal> list) {
        return dao.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public int deleteByHeadId(Long tfheadid) {
        return dao.deleteByHeadId(tfheadid);
    }

    @Override
    public JSONObject queryByHeadId(Long fheadid) {
        List<TFinanceMilkCostTotal> list = dao.queryByHeadId(fheadid);

        JSONObject object = new JSONObject();
        if(list==null || list.isEmpty()){
            object.put("error","暂无数据");
            object.put("stateCode", 0);
        }else{
            for (int i = 0; i <list.size(); i++) {
                list.get(i).setFyieldLast(list.get(i).getFyieldLast().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFyield(list.get(i).getFyield().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFmaterialYield(list.get(i).getFmaterialYield().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFmaterialLast(list.get(i).getFmaterialLast().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFmaterialAmount(list.get(i).getFmaterialAmount().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFpackageYield(list.get(i).getFpackageYield().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFpackageLast(list.get(i).getFpackageLast().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFpackageAmount(list.get(i).getFpackageAmount().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFlaborCostYield(list.get(i).getFlaborCostYield().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFlaborCostLast(list.get(i).getFlaborCostLast().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFlaborCostAmount(list.get(i).getFlaborCostAmount().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFpowerCostYield(list.get(i).getFpowerCostYield().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFpowerCostLast(list.get(i).getFpowerCostLast().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFpowerCostAmount(list.get(i).getFpowerCostAmount().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFmanufCostYield(list.get(i).getFmanufCostYield().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFmanufCostLast(list.get(i).getFmanufCostLast().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFmanufCostAmount(list.get(i).getFmanufCostAmount().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFproductionCostYield(list.get(i).getFproductionCostYield().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFproductionCostAmount(list.get(i).getFproductionCostAmount().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));

            }
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
        List<TFinanceMilkCostTotal> indiceList = new ArrayList<TFinanceMilkCostTotal>();
        JSONObject object = new JSONObject();
        logger.debug("行数 rowCount={}", rowCount);
        if(rowCount<8){
            object.put("stateCode", 0);
            object.put("error", "导入的模板数据有误");
            logger.error("导入的模板数据有误");
        }else{
            for (int r = 5; r < rowCount; r++) { //遍历有数据的行
                Row row = sheet.getRow(r);
                if(row!=null){
                    logger.debug("row index: {}", r);
                    String seq = Tools.getCellValue(row.getCell(0), wb);
                    String projectName = Tools.getCellValue(row.getCell(1), wb);
                    //读取到财务负责人时表示已读完
                    if (seq != null && seq.contains("单位负责人")) {
                        break;
                    } else if (projectName != null && projectName.contains("单位负责人")) {
                        break;
                    }
                    BigDecimal c2 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(2), wb));
                    BigDecimal c3 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(3), wb));
                    BigDecimal c4 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(4), wb));
                    BigDecimal c5 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(5), wb));
                    BigDecimal c6 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(6), wb));
                    BigDecimal c7 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(7), wb));
                    BigDecimal c8 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(8), wb));
                    BigDecimal c9 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(9), wb));
                    BigDecimal c10 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(10), wb));
                    BigDecimal c11 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(11), wb));
                    BigDecimal c12 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(12), wb));
                    BigDecimal c13 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(13), wb));
                    BigDecimal c14 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(14), wb));
                    BigDecimal c15 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(15), wb));
                    BigDecimal c16 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(16), wb));
                    BigDecimal c17 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(17), wb));
                    BigDecimal c18 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(18), wb));
                    BigDecimal c19 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(19), wb));
                    BigDecimal c20 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(20), wb));

                    TFinanceMilkCostTotal milkCostTotal = new TFinanceMilkCostTotal();
                    milkCostTotal.setFrowIndex(r);
                    milkCostTotal.setFseq(seq);
                    milkCostTotal.setFprojectName(projectName);
                    milkCostTotal.setFyieldLast(c2);
                    milkCostTotal.setFyield(c3);
                    milkCostTotal.setFmaterialYield(c4);
                    milkCostTotal.setFmaterialLast(c5);
                    milkCostTotal.setFmaterialAmount(c6);
                    milkCostTotal.setFpackageYield(c7);
                    milkCostTotal.setFpackageLast(c8);
                    milkCostTotal.setFpackageAmount(c9);
                    milkCostTotal.setFlaborCostYield(c10);
                    milkCostTotal.setFlaborCostLast(c11);
                    milkCostTotal.setFlaborCostAmount(c12);
                    milkCostTotal.setFpowerCostYield(c13);
                    milkCostTotal.setFpowerCostLast(c14);
                    milkCostTotal.setFpowerCostAmount(c15);
                    milkCostTotal.setFmanufCostYield(c16);
                    milkCostTotal.setFmanufCostLast(c17);
                    milkCostTotal.setFmanufCostAmount(c18);
                    milkCostTotal.setFproductionCostYield(c19);
                    milkCostTotal.setFproductionCostAmount(c20);

                    indiceList.add(milkCostTotal);
                }
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
                for (TFinanceMilkCostTotal fixedAssetsChange : indiceList) {
                    fixedAssetsChange.setFheadId(tfheadId);
                }
                int row = dao.deleteByHeadId(tfheadId);
                logger.debug("删除{}记录表数据：row={}, headId: {}", sheetName, row, tfheadId);
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
}
