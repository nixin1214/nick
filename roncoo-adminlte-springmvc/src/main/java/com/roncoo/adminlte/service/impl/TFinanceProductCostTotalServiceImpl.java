package com.roncoo.adminlte.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TFinanceMain;
import com.roncoo.adminlte.bean.entity.TFinanceProductCostTotal;
import com.roncoo.adminlte.service.TFinanceMainService;
import com.roncoo.adminlte.service.TFinanceProductCostTotalService;
import com.roncoo.adminlte.service.impl.dao.TFinanceProductCostTotalDao;
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
public class TFinanceProductCostTotalServiceImpl implements TFinanceProductCostTotalService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TFinanceProductCostTotalDao dao;
    @Autowired
    private TFinanceMainService mainService;

    /**
     * sheet页，需要写入数据的行号,{开始，结束}
     * 从0下标开始计数，包含首尾两行
     */
    private final int[] sheetCellArr = {5,40};

    @Override
    public int insert(TFinanceProductCostTotal empSalary) {
        return dao.insert(empSalary);
    }

    @Override
    public int insertBatch(List<TFinanceProductCostTotal> list) {
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
        List<TFinanceProductCostTotal> list = dao.queryByHeadId(fheadid);

        JSONObject object = new JSONObject();
        if(list==null || list.isEmpty()){
            object.put("error","暂无数据");
            object.put("stateCode", 0);
        }else{
            for (int i = 0; i <list.size(); i++) {
                list.get(i).setFyield(list.get(i).getFyield().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFmaterialBudget(list.get(i).getFmaterialBudget().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFmaterialActual(list.get(i).getFmaterialActual().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFpackageBudget(list.get(i).getFpackageBudget().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFpackageActual(list.get(i).getFpackageActual().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFlaborCostBudget(list.get(i).getFlaborCostBudget().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFlaborCostActual(list.get(i).getFlaborCostActual().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFpowerCostBudget(list.get(i).getFpowerCostBudget().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFpowerCostActual(list.get(i).getFpowerCostActual().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFmanufCostBudget(list.get(i).getFmanufCostBudget().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFmanufCostActual(list.get(i).getFmanufCostActual().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFproductionCostBudget(list.get(i).getFproductionCostBudget().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFproductionCostActual(list.get(i).getFproductionCostActual().divide(new BigDecimal(1),0,BigDecimal.ROUND_FLOOR));
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
        List<TFinanceProductCostTotal> indiceList = new ArrayList<>();
        JSONObject object = new JSONObject();
        logger.debug("行数 rowCount={}", rowCount);
        if(rowCount<20){
            object.put("stateCode", 0);
            object.put("error", "导入的模板数据有误");
            logger.error("导入的模板数据有误");
        }else{
            for (int r = sheetCellArr[0]; r <= sheetCellArr[1]; r++) { //遍历有数据的行
                Row row = sheet.getRow(r);
                if(row!=null){
                    logger.debug("row index: {}", r);
                    String seq = Tools.getCellValue(row.getCell(0), wb);
                    String projectName = Tools.getCellValue(row.getCell(1), wb);
                    if (seq != null && seq.contains("单位负责人")) {
                        break;
                    } else if (projectName != null && projectName.contains("单位负责人")) {
                        break;
                    }
                    TFinanceProductCostTotal productCostTotal = new TFinanceProductCostTotal();
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

                    productCostTotal.setFrowIndex(r);
                    productCostTotal.setFseq(seq);
                    productCostTotal.setFprojectName(projectName);
                    productCostTotal.setFyield(c2);
                    productCostTotal.setFmaterialBudget(c3);
                    productCostTotal.setFmaterialActual(c4);
                    productCostTotal.setFpackageBudget(c5);
                    productCostTotal.setFpackageActual(c6);
                    productCostTotal.setFlaborCostBudget(c7);
                    productCostTotal.setFlaborCostActual(c8);
                    productCostTotal.setFpowerCostBudget(c9);
                    productCostTotal.setFpowerCostActual(c10);
                    productCostTotal.setFmanufCostBudget(c11);
                    productCostTotal.setFmanufCostActual(c12);
                    productCostTotal.setFproductionCostBudget(c13);
                    productCostTotal.setFproductionCostActual(c14);
                    productCostTotal.setFproductionCostTotal(c15);

                    indiceList.add(productCostTotal);
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
                for (TFinanceProductCostTotal fixedAssetsChange : indiceList) {
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
    public List<TFinanceProductCostTotal> queryByPropertyAll(List<Long> tfheadids) {
        return dao.queryByPropertyAll(tfheadids);
    }

    @Override
    public void exportHandler(Sheet sheet, List<Long> tfheadids){
        List<TFinanceProductCostTotal> indices = queryByPropertyAll(tfheadids);
        if (indices.size() == 0) {
            return;
        }
        //按组织分解结果集
        Map<Long,List<TFinanceProductCostTotal>> resultMap = new HashMap<>();
        for (Long fheadid : tfheadids) {
            List<TFinanceProductCostTotal> item = new ArrayList<>();
            for (TFinanceProductCostTotal balance : indices) {
                if (balance.getFheadId().equals(fheadid)) {
                    item.add(balance);
                }
            }
            resultMap.put(fheadid,item);
        }
        //将数据写入sheet页
        for (int j = sheetCellArr[0]; j <= sheetCellArr[1]; j++) {//遍历sheet页中的指定行
            Row row = sheet.getRow(j);///获取行对象
            Cell cell_c = row.getCell(2);//获取 C 列对象
            Cell cell_d = row.getCell(3);//获取 D 列对象
            Cell cell_e = row.getCell(4);//获取 E 列对象
            Cell cell_f = row.getCell(5);//获取 F 列对象
            Cell cell_g = row.getCell(6);//获取 G 列对象
            Cell cell_h = row.getCell(7);//获取 H 列对象
            Cell cell_i = row.getCell(8);//获取 I 列对象
            Cell cell_j = row.getCell(9);//获取 J 列对象
            Cell cell_k = row.getCell(10);//获取 K 列对象
            Cell cell_l = row.getCell(11);//获取 L 列对象
            Cell cell_m = row.getCell(12);//获取 M 列对象
            Cell cell_n = row.getCell(13);//获取 N 列对象
            Cell cell_o = row.getCell(14);//获取 O 列对象
            Cell cell_p = row.getCell(15);//获取 P 列对象
            BigDecimal item_c = new BigDecimal("0");
            BigDecimal item_d = new BigDecimal("0");
            BigDecimal item_e = new BigDecimal("0");
            BigDecimal item_f = new BigDecimal("0");
            BigDecimal item_g = new BigDecimal("0");
            BigDecimal item_h = new BigDecimal("0");
            BigDecimal item_i = new BigDecimal("0");
            BigDecimal item_j = new BigDecimal("0");
            BigDecimal item_k = new BigDecimal("0");
            BigDecimal item_l = new BigDecimal("0");
            BigDecimal item_m = new BigDecimal("0");
            BigDecimal item_n = new BigDecimal("0");
            BigDecimal item_o = new BigDecimal("0");
            BigDecimal item_p = new BigDecimal("0");
            for (Long fheadid : tfheadids) {//累加
                if (resultMap.get(fheadid).size() > 0) {
                    TFinanceProductCostTotal bal = resultMap.get(fheadid).get(j - sheetCellArr[0]);//从0下标开始读取
                    item_c = item_c.add(bal.getFyield());//产量
                    item_d = item_d.add(bal.getFmaterialBudget());//原材料单位成本-预算
                    item_e = item_e.add(bal.getFmaterialActual());//原材料单位成本-实际
                    item_f = item_f.add(bal.getFpackageBudget());//包装物单位成本-预算
                    item_g = item_g.add(bal.getFpackageActual());//包装物单位成本-实际
                    item_h = item_h.add(bal.getFlaborCostBudget());//单位直接人工成本-预算
                    item_i = item_i.add(bal.getFlaborCostActual());//单位直接人工成本-实际
                    item_j = item_j.add(bal.getFpowerCostBudget());//单位燃料及动力成本-预算
                    item_k = item_k.add(bal.getFpowerCostActual());//单位燃料及动力成本-实际
                    item_l = item_l.add(bal.getFmanufCostBudget());//单位制造费用成本-预算
                    item_m = item_m.add(bal.getFmanufCostActual());//单位制造费用成本-实际
                    item_n = item_n.add(bal.getFproductionCostBudget());//生产成本合计-预算
                    item_o = item_o.add(bal.getFproductionCostActual());//生产成本合计-实际
                    item_p = item_p.add(bal.getFproductionCostTotal());//生产成本合计-总额
                }
            }
            if(j == 5||j == 6||j == 14||j == 22||j == 29){
                cell_c.setCellValue(item_c.doubleValue());//写入值
                cell_e.setCellValue(item_e.doubleValue());//写入值
                cell_g.setCellValue(item_g.doubleValue());//写入值
                cell_i.setCellValue(item_i.doubleValue());//写入值
                cell_k.setCellValue(item_k.doubleValue());//写入值
                cell_m.setCellValue(item_m.doubleValue());//写入值
                cell_o.setCellValue(item_o.doubleValue());//写入值
                cell_p.setCellValue(item_p.doubleValue());//写入值
            }else {
                cell_c.setCellValue(item_c.doubleValue());//写入值
                cell_d.setCellValue(item_d.doubleValue());//写入值
                cell_e.setCellValue(item_e.doubleValue());//写入值
                cell_f.setCellValue(item_f.doubleValue());//写入值
                cell_g.setCellValue(item_g.doubleValue());//写入值
                cell_h.setCellValue(item_h.doubleValue());//写入值
                cell_i.setCellValue(item_i.doubleValue());//写入值
                cell_j.setCellValue(item_j.doubleValue());//写入值
                cell_k.setCellValue(item_k.doubleValue());//写入值
                cell_l.setCellValue(item_l.doubleValue());//写入值
                cell_m.setCellValue(item_m.doubleValue());//写入值
                cell_n.setCellValue(item_n.doubleValue());//写入值
                cell_o.setCellValue(item_o.doubleValue());//写入值
                cell_p.setCellValue(item_p.doubleValue());//写入值
            }
        }
    }
}
