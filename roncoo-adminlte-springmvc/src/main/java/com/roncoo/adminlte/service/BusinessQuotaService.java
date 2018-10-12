package com.roncoo.adminlte.service;

import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TBusinessQuota;
import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.util.base.Page;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;
import java.util.Map;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 业务指标服务类接口
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/10/31 12:12
 */
public interface BusinessQuotaService {

    /**
     * 执行动态SQL
     * @param sql
     * @return 结果集
     */
    public List<Map<String, Object>> dynamicSql(String sql);

    /**
     * 分页查询
     * @param pageCurrent
     * @param pageSize
     * @param orgCode
     * @param yearMonth
     * @param quotaName
     * @return
     */
    Result<Page<TBusinessQuota>> listForPage(int pageCurrent, int pageSize, String orgCode, String yearMonth, List<String> quotaName);

    /**
     * 分页查询,根据用户权限限定范围
     * @param pageCurrent
     * @param pageSize
     * @param orgCode
     * @param yearMonth
     * @param quotaName
     * @param companyList 用户所能管理的组织
     * @return
     */
    Result<Page<TBusinessQuota>> listForPage(int pageCurrent, int pageSize, String orgCode, String yearMonth, String quotaName, List<String> companyList);

    /**
     * 更新
     * @param quota 指标对象
     * @return 返回修改的条数
     */
    Result<Integer> update(TBusinessQuota quota, RcUser rcUser);

    /**
     * 查询详细
     * @param id 指标ID
     * @return 返回指标对象
     */
    Result<TBusinessQuota> query(long id);

    /**
     * 新增
     * @param quota 指标对象
     * @return 新增条数
     */
    Result<Integer> addNew(TBusinessQuota quota);

    Result<Integer> delete(TBusinessQuota quota);

    JSONObject importMilkIndexData(RcUser rcUser, String companyNumber, String period, Workbook wb);

    /**
     *  杨北平    2018-02-26
     * @param orgCode
     * @param fnameEn
     * @return
     */
    public List<TBusinessQuota> queryQuota(String orgCode,String fnameEn,String fyearMonth,String fsmallClass);

    /**
     * 根据公司查询对应的指标项  杨北平   2018-02-26
     * @param orgCode
     * @return
     */
    JSONObject queryIndex(String orgCode,String fnameEn);

    /**
     * 查询出指标对应的细分类 杨北平   2018-02-26
     */
    public JSONObject queryListOption(String orgCode,String fnameEn);
    /**
     * 数据导入
     * @param wb excel对象
     * @param sheetName sheet页名称
     * @param companyNumber 公司编码
     * @param rcUser 操作用户
     * @return JSON格式表格数据
     */
    JSONObject ranchBudget(Workbook wb, String sheetName, String companyNumber, RcUser rcUser);

    /**
     * 华山牧乳业预算数据导入
     * @param wb
     * @param sheetName
     * @param companyNumber
     * @param rcUser
     * @return
     */
    JSONObject ranchBudgets(Workbook wb, String sheetName, String companyNumber, RcUser rcUser);



}
