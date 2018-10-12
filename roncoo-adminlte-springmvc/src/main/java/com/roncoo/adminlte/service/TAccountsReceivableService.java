package com.roncoo.adminlte.service;

import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TAccountsReceivable;
import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.util.base.Page;
import org.apache.poi.ss.usermodel.Workbook;

import java.math.BigDecimal;
import java.util.List;

public interface TAccountsReceivableService {

    JSONObject importAccounts(Workbook wb, String sheetName, String companyNumber, String yearMonth, RcUser rcUser);

    Result<Page<TAccountsReceivable>> listForPage(int start, int pageSize, List<BigDecimal> headId);

    List<TAccountsReceivable> queryByExmple(List<BigDecimal> headIds);

    List<TAccountsReceivable> fillNull();
}
