package com.roncoo.adminlte.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TFinanceEmpSalary;
import com.roncoo.adminlte.bean.entity.TFinanceMain;
import com.roncoo.adminlte.service.TFinanceEmpSalaryService;
import com.roncoo.adminlte.service.TFinanceMainService;
import com.roncoo.adminlte.service.impl.dao.TFinanceEmpSalaryDao;
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
 * @Description: 员工薪酬
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:54
 */
@Service
public class TFinanceEmpSalaryServiceImpl implements TFinanceEmpSalaryService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TFinanceEmpSalaryDao dao;
    @Autowired
    private TFinanceMainService mainService;

    /**
     * sheet页，需要写入数据的行号,{开始，结束}
     * 从0下标开始计数，包含首尾两行
     */
    private final int[] sheetCellArr = {5,17};

    @Override
    public int insert(TFinanceEmpSalary empSalary) {
        return dao.insert(empSalary);
    }

    @Override
    public int insertBatch(List<TFinanceEmpSalary> list) {
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
        List<TFinanceEmpSalary> list = dao.queryByHeadId(fheadid);

        JSONObject object = new JSONObject();
        if(list==null || list.isEmpty()){
            object.put("error","暂无数据");
            object.put("stateCode", 0);
        }else{
            for (int i = 0; i <list.size(); i++) {
                list.get(i).setFthisBeginPeriodAmount(list.get(i).getFthisBeginPeriodAmount().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFthisPeriodAmount(list.get(i).getFthisPeriodAmount().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFthisPeriodPaidAmount(list.get(i).getFthisPeriodPaidAmount().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFthisPeriodEndAmount(list.get(i).getFthisPeriodEndAmount().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFtotalBeginPeriodAmount(list.get(i).getFtotalBeginPeriodAmount().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFtotalPeriodAmount(list.get(i).getFtotalPeriodAmount().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFtotalPeriodPaidAmount(list.get(i).getFtotalPeriodPaidAmount().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFtotalPeriodEndAmount(list.get(i).getFtotalPeriodEndAmount().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFthisBudget(list.get(i).getFthisBudget().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFtotalBudget(list.get(i).getFtotalBudget().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
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
        List<TFinanceEmpSalary> indiceList = new ArrayList<TFinanceEmpSalary>();
        JSONObject object = new JSONObject();
        logger.debug("行数 rowCount={}", rowCount);
        if(rowCount<20){
            object.put("stateCode", 0);
            object.put("error", "导入的模板数据有误");
            logger.error("导入的模板数据有误");
        }else{
            for (int r = sheetCellArr[0]; r <= sheetCellArr[1]; r++) { //遍历有数据的行
                logger.debug("row index: {}", r);
                Row row = sheet.getRow(r);
                if(row!=null){
                    TFinanceEmpSalary fixedAssetsChange = new TFinanceEmpSalary();
                    String projectName = Tools.getCellValue(row.getCell(0), wb);
                    BigDecimal c1 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(1), wb));
                    BigDecimal c2 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(2), wb));
                    BigDecimal c3 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(3), wb));
                    BigDecimal c4 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(4), wb));
                    BigDecimal c5 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(5), wb));
                    BigDecimal c6 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(6), wb));
                    BigDecimal c7 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(7), wb));
                    BigDecimal c8 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(8), wb));
                    BigDecimal c9 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(9), wb));
                    BigDecimal c10 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(10), wb));

                    fixedAssetsChange.setFrowIndex(r);
                    fixedAssetsChange.setFprojectName(projectName);
                    fixedAssetsChange.setFthisBudget(c1);
                    fixedAssetsChange.setFtotalBudget(c2);
                    fixedAssetsChange.setFthisBeginPeriodAmount(c3);
                    fixedAssetsChange.setFthisPeriodAmount(c4);
                    fixedAssetsChange.setFthisPeriodPaidAmount(c5);
                    fixedAssetsChange.setFthisPeriodEndAmount(c6);
                    fixedAssetsChange.setFtotalBeginPeriodAmount(c7);
                    fixedAssetsChange.setFtotalPeriodAmount(c8);
                    fixedAssetsChange.setFtotalPeriodPaidAmount(c9);
                    fixedAssetsChange.setFtotalPeriodEndAmount(c10);

                    indiceList.add(fixedAssetsChange);
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
                for (TFinanceEmpSalary fixedAssetsChange : indiceList) {
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
    public List<TFinanceEmpSalary> queryByPropertyAll(List<Long> tfheadids) {
        return dao.queryByPropertyAll(tfheadids);
    }

    @Override
    public void exportHandler(Sheet sheet, List<Long> tfheadids){
        List<TFinanceEmpSalary> indices = queryByPropertyAll(tfheadids);
        if (indices.size() == 0) {
            return;
        }
        //按组织分解结果集
        Map<Long,List<TFinanceEmpSalary>> resultMap = new HashMap<>();
        for (Long fheadid : tfheadids) {
            List<TFinanceEmpSalary> item = new ArrayList<>();
            for (TFinanceEmpSalary balance : indices) {
                if (balance.getFheadId().equals(fheadid)) {
                    item.add(balance);
                }
            }
            resultMap.put(fheadid,item);
        }
        //将数据写入sheet页
        for (int j = sheetCellArr[0]; j <= sheetCellArr[1]; j++) {//遍历sheet页中的指定行
            Row row = sheet.getRow(j);///获取行对象
            Cell cell_b = row.getCell(1);//获取 B 列对象
            Cell cell_c = row.getCell(2);//获取 C 列对象
            Cell cell_d = row.getCell(3);//获取 D 列对象
            Cell cell_e = row.getCell(4);//获取 E 列对象
            Cell cell_f = row.getCell(5);//获取 F 列对象
            Cell cell_g = row.getCell(6);//获取 G 列对象
            Cell cell_h = row.getCell(7);//获取 H 列对象
            Cell cell_i = row.getCell(8);//获取 I 列对象
            Cell cell_j = row.getCell(9);//获取 j 列对象
            Cell cell_k = row.getCell(10);//获取 k 列对象
            BigDecimal item_b = new BigDecimal("0");
            BigDecimal item_c = new BigDecimal("0");
            BigDecimal item_d = new BigDecimal("0");
            BigDecimal item_e = new BigDecimal("0");
            BigDecimal item_f = new BigDecimal("0");
            BigDecimal item_g = new BigDecimal("0");
            BigDecimal item_h = new BigDecimal("0");
            BigDecimal item_i = new BigDecimal("0");
            BigDecimal item_j = new BigDecimal("0");
            BigDecimal item_k = new BigDecimal("0");
            for (Long fheadid : tfheadids) {//累加
                if (resultMap.get(fheadid).size() > 0) {
                    TFinanceEmpSalary bal = resultMap.get(fheadid).get(j - sheetCellArr[0]);//从0下标开始读取
                    item_b = item_b.add(bal.getFthisBudget());//本期数-期初未交
                    item_c = item_c.add(bal.getFtotalBudget());//本期数-本期计提
                    item_d = item_d.add(bal.getFthisBeginPeriodAmount());//本期数-期初未交
                    item_e = item_e.add(bal.getFthisPeriodAmount());//本期数-本期计提
                    item_f = item_f.add(bal.getFthisPeriodPaidAmount());//本期数-本期支出
                    item_g = item_g.add(bal.getFthisPeriodEndAmount());//本期数-期末余额
                    item_h = item_h.add(bal.getFtotalBeginPeriodAmount());//累计数-期初余额
                    item_i = item_i.add(bal.getFtotalPeriodAmount());//累计数-本期计提
                    item_j = item_j.add(bal.getFtotalPeriodPaidAmount());//累计数-本期支出
                    item_k = item_k.add(bal.getFtotalPeriodEndAmount());//累计数-期末余额
                }
            }
            cell_b.setCellValue(item_b.doubleValue());//写入值
            cell_c.setCellValue(item_c.doubleValue());//写入值
            cell_d.setCellValue(item_d.doubleValue());//写入值
            cell_e.setCellValue(item_e.doubleValue());//写入值
            cell_f.setCellValue(item_f.doubleValue());//写入值
            cell_g.setCellValue(item_g.doubleValue());//写入值
            cell_h.setCellValue(item_h.doubleValue());//写入值
            cell_i.setCellValue(item_i.doubleValue());//写入值
            cell_j.setCellValue(item_j.doubleValue());//写入值
            cell_k.setCellValue(item_k.doubleValue());//写入值
        }
    }
}
