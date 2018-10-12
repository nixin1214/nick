package com.roncoo.adminlte.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.HsmryProductListBudget;
import com.roncoo.adminlte.service.HsmryProductListBudgetService;
import com.roncoo.adminlte.service.impl.dao.HsmryProductListBudgetDao;
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
@Service
public class HsmryProductListBudgetServiceImpl implements HsmryProductListBudgetService{
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HsmryProductListBudgetDao budgetDao;

    @Override
    public JSONObject importHsmryDailyReport(Workbook wb) {
        JSONObject object = new JSONObject();
        String yearMonth = "";
        Sheet sheet = wb.getSheet("产销量预算明细表");
        int rowCount = sheet.getPhysicalNumberOfRows();
        logger.debug("行数 rowCount={}", rowCount);
        if(rowCount<3){
            object.put("stateCode", 1);
            object.put("error", "导入的模板数据有误");
            logger.error("导入的模板数据有误");
        }else {
            if (sheet.getRow(2).getCell(0).equals("填表人:")){
                object.put("stateCode",1);
                object.put("error","无数据导入");
                logger.error("无数据导入");
                return object;
            }
            List<HsmryProductListBudget> budgetList = new ArrayList<>();
            //读取导入数据
            for (int r=2;r<rowCount-1;r++){
                Row row = sheet.getRow(r);
                if (row.getCell(0).equals("填表人:")){
                    break;
                }
                budgetList.addAll(addBeans(wb,sheet,row,yearMonth));
            }
            //删除数据库中原有数据
            for(int r=2;r<rowCount-1;r++){
                Row row = sheet.getRow(r);
                for(HsmryProductListBudget budget:addBeans(wb,sheet,row,yearMonth)){
                    budgetDao.deleteByExample(budget);
                }
            }

            this.budgetDao.insertBatch(budgetList);
            object.put("stateCode", 0);
            object.put("error", "导入成功");
        }
        return object;
    }

    public List<HsmryProductListBudget> addBeans(Workbook wb,Sheet sheet,Row row,String yearMonth){
        List<HsmryProductListBudget> budgetList = new ArrayList<>();
        for(int c=0;c<25;c++){
            String productName = Tools.getCellValue(row.getCell(0),wb);//取得产品名
            if(c%2==1) {
                yearMonth = Tools.getCellValue(sheet.getRow(0).getCell(c), wb).substring(0,6);//取得时间
                BigDecimal value1 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(c),wb));
                BigDecimal value2 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(c+1),wb));
                HsmryProductListBudget budget = new HsmryProductListBudget();
                budget.setProductname(productName);
                budget.setYearmonth(yearMonth);
                budget.setSalesvolume(value1);
                budget.setSalesamount(value2);
                budgetList.add(budget);
            }
        }
        return budgetList;
    }


}
