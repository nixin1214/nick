package com.roncoo.adminlte.service;

import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TDailyReport;
import org.apache.poi.ss.usermodel.Workbook;

import java.math.BigDecimal;
import java.util.List;

public interface TDailyReportService {

    /**
     * 导入每日报表数据
     */
    public JSONObject importDailyReport(Workbook wb, String sheetName, String companyNumber, String period, RcUser rcUser);

    /**
     * 分页查询
     * @param pageCurrent
     * @param pageSize
     * @param yearMonth
     * @param type
     * @return
     */
    public JSONObject listForPage(int pageCurrent, int pageSize, String yearMonth,int type);

    /**
     * 条件查询
     * @param yearMonth
     * @param difference
     * @param distributionChannel
     * @return
     */
    public List<TDailyReport> selectByExample(String yearMonth, BigDecimal difference, List<BigDecimal> distributionChannel);

}
