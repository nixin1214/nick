package com.roncoo.adminlte.service;

import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessMDiff;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;


public interface BalanceMainBusinessMonthDiffService {

    int insert(TFinanceMainBusinessMDiff obj);

    int insertBatch(@Param("list") List<TFinanceMainBusinessMDiff> list);

    int deleteById(Long id);

    int deleteByProperty(Long tfheadid);

    List<TFinanceMainBusinessMDiff> queryByProperty(Long tfheadid);

    /**
     * 数据导入
     * @param wb excel对象
     * @param sheetName sheet页名称
     * @param companyNumber 公司编码
     * @param period 期间
     * @param rcUser 操作用户
     * @return JSON格式表格数据
     */
    JSONObject importHandler(Workbook wb, String sheetName, String companyNumber, String period, RcUser rcUser);

    /**
     * 根据表头查询表格数据
     * @param fheadid 表头ID
     * @return JSON格式TABLE数据及状态
     */
    JSONObject queryByHeadId(Long fheadid);
}
