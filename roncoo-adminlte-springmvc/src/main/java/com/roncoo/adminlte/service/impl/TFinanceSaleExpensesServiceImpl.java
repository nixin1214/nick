package com.roncoo.adminlte.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TFinanceMain;
import com.roncoo.adminlte.bean.entity.TFinanceSaleExpenses;
import com.roncoo.adminlte.service.TFinanceMainService;
import com.roncoo.adminlte.service.TFinanceSaleExpensesService;
import com.roncoo.adminlte.service.impl.dao.TFinanceSaleExpensesDao;
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
 * @Description: 销售费用
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 12:05
 */
@Service
public class TFinanceSaleExpensesServiceImpl implements TFinanceSaleExpensesService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TFinanceMainService mainService;

    @Autowired
    private TFinanceSaleExpensesDao dao;

    /**
     * sheet页，需要写入数据的行号,{开始，结束}
     * 从0下标开始计数，包含首尾两行
     */
    private final int[] sheetCellArr = {6,47};

    @Override
    public int insert(TFinanceSaleExpenses empSalary) {
        return dao.insert(empSalary);
    }

    @Override
    public int insertBatch(List<TFinanceSaleExpenses> list) {
        return dao.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public int deleteByHeadId(Long headId) {
        return dao.deleteByHeadId(headId);
    }

    @Override
    public JSONObject queryByHeadId(Long fheadid) {
        List<TFinanceSaleExpenses> list = dao.queryByHeadId(fheadid);

        JSONObject object = new JSONObject();
        if(list==null || list.isEmpty()){
            object.put("error","暂无数据");
            object.put("stateCode", 0);
        }else{
            for(int i =0;i<list.size();i++){
                list.get(i).setFafterYearThis(list.get(i).getFafterYearThis().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFafterYearTotal(list.get(i).getFafterYearTotal().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFthisYearBudgetThis(list.get(i).getFthisYearBudgetThis().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFthisYearBudgetTotal(list.get(i).getFthisYearBudgetTotal().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFthisYearActualThis(list.get(i).getFthisYearActualThis().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
                list.get(i).setFthisYearActualTotal(list.get(i).getFthisYearActualTotal().divide(new BigDecimal(10000),0,BigDecimal.ROUND_FLOOR));
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
        List<TFinanceSaleExpenses> indiceList = new ArrayList<TFinanceSaleExpenses>();
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
                    TFinanceSaleExpenses fixedAssetsChange = new TFinanceSaleExpenses();
                    String seq = Tools.getCellValue(row.getCell(0), wb);
                    logger.debug("row index: {}, seq:{}", r, seq);
                    String projectName = Tools.getCellValue(row.getCell(1), wb);
                    BigDecimal c2 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(2), wb));
                    BigDecimal c3 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(3), wb));
                    BigDecimal c4 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(4), wb));
                    BigDecimal c5 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(5), wb));
                    BigDecimal c6 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(6), wb));
                    BigDecimal c7 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(7), wb));

                    fixedAssetsChange.setFrowIndex(r);
                    fixedAssetsChange.setFseq(seq);
                    fixedAssetsChange.setFprojectName(projectName);
                    fixedAssetsChange.setFafterYearThis(c2);
                    fixedAssetsChange.setFafterYearTotal(c3);
                    fixedAssetsChange.setFthisYearBudgetThis(c4);
                    fixedAssetsChange.setFthisYearBudgetTotal(c5);
                    fixedAssetsChange.setFthisYearActualThis(c6);
                    fixedAssetsChange.setFthisYearActualTotal(c7);

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
                for (TFinanceSaleExpenses fixedAssetsChange : indiceList) {
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
    public List<TFinanceSaleExpenses> queryByPropertyAll(List<Long> tfheadids) {
        return dao.queryByPropertyAll(tfheadids);
    }

    @Override
    public void exportHandler(Sheet sheet, List<Long> tfheadids){
        List<TFinanceSaleExpenses> indices = queryByPropertyAll(tfheadids);
        if (indices.size() == 0) {
            return;
        }
        //按组织分解结果集
        Map<Long,List<TFinanceSaleExpenses>> resultMap = new HashMap<>();
        for (Long fheadid : tfheadids) {
            List<TFinanceSaleExpenses> item = new ArrayList<>();
            for (TFinanceSaleExpenses balance : indices) {
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
            BigDecimal item_c = new BigDecimal("0");
            BigDecimal item_d = new BigDecimal("0");
            BigDecimal item_e = new BigDecimal("0");
            BigDecimal item_f = new BigDecimal("0");
            BigDecimal item_g = new BigDecimal("0");
            BigDecimal item_h = new BigDecimal("0");
            for (Long fheadid : tfheadids) {//累加
                if (resultMap.get(fheadid).size() > 0) {
                    TFinanceSaleExpenses bal = resultMap.get(fheadid).get(j - sheetCellArr[0]);//从0下标开始读取
                    item_c = item_c.add(bal.getFafterYearThis());//上年同期-本期
                    item_d = item_d.add(bal.getFafterYearTotal());//上年同期-累计
                    item_e = item_e.add(bal.getFthisYearBudgetThis());//本年预算-本期
                    item_f = item_f.add(bal.getFthisYearBudgetTotal());//本年预算-累计
                    item_g = item_g.add(bal.getFthisYearActualThis());//本年实际-本期
                    item_h = item_h.add(bal.getFthisYearActualTotal());//本年实际-累计
                }
            }
            cell_c.setCellValue(item_c.doubleValue());//写入值
            cell_d.setCellValue(item_d.doubleValue());//写入值
            cell_e.setCellValue(item_e.doubleValue());//写入值
            cell_f.setCellValue(item_f.doubleValue());//写入值
            cell_g.setCellValue(item_g.doubleValue());//写入值
            cell_h.setCellValue(item_h.doubleValue());//写入值
        }
    }
}
