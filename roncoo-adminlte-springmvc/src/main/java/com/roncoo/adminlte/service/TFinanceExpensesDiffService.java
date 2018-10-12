package com.roncoo.adminlte.service;

import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TFinanceExpenses;
import com.roncoo.adminlte.bean.entity.TFinanceExpensesDiff;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 财务费用
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:50
 */
public interface TFinanceExpensesDiffService {

    int insert(TFinanceExpensesDiff empSalary);

    int insertBatch(List<TFinanceExpensesDiff> list);

    int deleteById(Long id);

    int deleteByHeadId(Long tfheadid);
    /**
     * 根据表头查询表格数据
     * @param fheadid 表头ID
     * @return JSON格式TABLE数据及状态
     */
    JSONObject queryByHeadId(Long fheadid);

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
}
