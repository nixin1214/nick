package com.roncoo.adminlte.service;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.ss.usermodel.Workbook;

public interface HsmryProductListBudgetService {

    public JSONObject importHsmryDailyReport(Workbook wb);

}
