package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TDailyReport;
import com.roncoo.adminlte.bean.entity.TDailyReportExample;

import java.math.BigDecimal;
import java.util.List;

public interface TDailyReportDao {
    int deleteByExample(String yearMonth, BigDecimal difference);

    int insertBatch(List<TDailyReport> tDailyReports);

    List<TDailyReport> selectByExample(TDailyReportExample example);

    List<TDailyReport> listForPage(int pageCurrent, int pageSize, String yearMonth,int type);

}


