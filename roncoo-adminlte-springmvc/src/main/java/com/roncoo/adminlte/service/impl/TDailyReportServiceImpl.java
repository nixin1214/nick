package com.roncoo.adminlte.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TDailyReport;
import com.roncoo.adminlte.bean.entity.TDailyReportExample;
import com.roncoo.adminlte.service.TDailyReportService;
import com.roncoo.adminlte.service.impl.dao.TDailyReportDao;
import com.roncoo.adminlte.util.IndicesTool;
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
public class TDailyReportServiceImpl implements TDailyReportService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TDailyReportDao tDailyReportDao;


    /**
     * 导入供应链每日报表数据
     */
    @Override
    public JSONObject importDailyReport(Workbook wb, String sheetName, String companyNumber, String period, RcUser rcUser) {
        JSONObject object = importData1(wb,sheetName,period,rcUser);
        return object;
    }

    public JSONObject importData1(Workbook wb,String sheetName,String yearMonth,RcUser rcUser){
        JSONObject object = new JSONObject();
        Sheet sheet = wb.getSheet(sheetName);
        BigDecimal difference = null;
        int rowCounts = 0;
        if (sheetName.equals("供应链总表")) {
            difference = new BigDecimal(0);
            rowCounts = 45;
        }else {
            difference = new BigDecimal(1);
            rowCounts = 107;
        }
        int rowCount = sheet.getPhysicalNumberOfRows();
        logger.debug("行数 rowCount={}", rowCount);
        if (rowCount!=rowCounts){
            object.put("stateCode", 1);
            object.put("error", "导入的模板数据有误");
            logger.error("导入的模板数据有误");
        }else {
            List<TDailyReport> tDailyReports = new ArrayList<>();
            int size = rowCount;
            for (int i = 4; i < size; i++) {
                Row row = sheet.getRow(i);
                if (row!=null){
                    String c1 = Tools.getCellValue(row.getCell(1),wb);
                    if (c1!=null&&c1.contains("单位负责人：")){
                        break;
                    }
                    String c2 = Tools.getCellValue(row.getCell(2),wb);
                    String c3 = Tools.getCellValue(row.getCell(3),wb);
                    BigDecimal c4 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(4),wb));
                    BigDecimal c5 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(5),wb));
                    BigDecimal c6 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(6),wb));
                    BigDecimal c7 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(7),wb));
                    BigDecimal c8 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(8),wb));
                    BigDecimal c9 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(9),wb));
                    BigDecimal c10 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(10),wb));

                    TDailyReport tDailyReport = new TDailyReport();
                    tDailyReport.setFsheetRowIndex(new BigDecimal(i));
                    tDailyReport.setYearMonth(yearMonth);
                    tDailyReport.setFdifference(difference);
                    tDailyReport.setDistributionChannel(c1);
                    tDailyReport.setSalesArea(c2);
                    tDailyReport.setAreaList(c3);
                    tDailyReport.setDailyPractice(c4);
                    tDailyReport.setDailyTotalAvg(c5);
                    tDailyReport.setDailyAvgBudget(c6);
                    tDailyReport.setCompletionRate(c7);
                    tDailyReport.setThisMonthBudget(c8);
                    tDailyReport.setThisMonthTotal(c9);
                    tDailyReport.setThisMonthCompletionRate(c10);
                    tDailyReports.add(tDailyReport);
                }
            }

            List<TDailyReport> prot = selectByExample(yearMonth,difference,null);
            if (prot!=null&&prot.size()!=0){
                //清除原有数据
                this.tDailyReportDao.deleteByExample(yearMonth,difference);
            }

            //导入数据
            int rows = this.tDailyReportDao.insertBatch(tDailyReports);
            System.out.println("添加数据成功  rows="+rows);

            List<TDailyReport> tDailyReports1 = selectByExample(yearMonth,difference,null);
            if (tDailyReports1==null||tDailyReports1.isEmpty()){
                object.put("error","暂无数据");
                object.put("stateCode", 0);
            }else {
                JSONObject json = new JSONObject();
                for(TDailyReport report1:tDailyReports1){
                    JSONObject obj = new JSONObject();
                    obj.put("channel",report1.getDistributionChannel());
                    obj.put("salesArea",report1.getSalesArea());
                    obj.put("areaList",report1.getAreaList());
                    obj.put("dailyPractice",report1.getDailyPractice());
                    obj.put("dailyTotalAvg",report1.getDailyTotalAvg());
                    obj.put("dailyAvgBudget",report1.getDailyAvgBudget());
                    obj.put("completionRate",report1.getCompletionRate());
                    obj.put("thisMonthBudget",report1.getThisMonthBudget());
                    obj.put("thisMonthTotal",report1.getThisMonthTotal());
                    obj.put("thisMonthCompletionRate",report1.getThisMonthCompletionRate());
                    json.put("datas",obj);
                }
                object = json;
                object.put("stateCode", 200);
            }
        }
        return object;
    }


    public List<TDailyReport> selectByExample(String yearMonth,BigDecimal difference,List<BigDecimal> distributionChannel){
        TDailyReportExample example = new TDailyReportExample();
        TDailyReportExample.Criteria criteria = example.createCriteria();
        criteria.andYearMonthEqualTo(yearMonth);
        criteria.andFdifferenceEqualTo(difference);
        if(distributionChannel!=null) {
            criteria.andFsheetRowIndexIn(distributionChannel);
        }
        List<TDailyReport> tDailyReports = this.tDailyReportDao.selectByExample(example);
        return tDailyReports;
    }

    @Override
    public JSONObject listForPage(int pageCurrent, int pageSize, String yearMonth,int type) {
        JSONObject json = new JSONObject();
        List<TDailyReport> list = this.tDailyReportDao.listForPage(pageCurrent, pageSize, yearMonth,type);
        if(list==null || list.isEmpty()){
            json.put("error","暂无数据");
            json.put("stateCode", 0);
        }else{
            JSONArray array = IndicesTool.dailyReportListToJsonArray(list);
            json.put("datas",array);
            json.put("stateCode", 200);
        }
        return json;
    }




}
