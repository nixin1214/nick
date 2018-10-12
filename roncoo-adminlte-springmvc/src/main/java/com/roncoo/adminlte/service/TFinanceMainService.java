package com.roncoo.adminlte.service;

import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TFinanceMain;
import com.roncoo.adminlte.bean.entity.TFinanceMainExample;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by lx on 2017/11/1.
 */
public interface TFinanceMainService {

    List<TFinanceMain> selectByExample(TFinanceMainExample tFinanceMainExample);

    List<BigDecimal> selectHeadId(String orgCode, String yearMonth);

    TFinanceMain selectByPrimaryKey(Long id);

    int deleteByPrimaryKey(Long id);

    int deleteByExample(TFinanceMainExample tFinanceMainExample);

    int insert(TFinanceMain tFinanceMain);

    int insertSelective(TFinanceMain tFinanceMain);

    int countByExample(TFinanceMainExample tFinanceMainExample);

    int updateByExampleSelective(Map map);

    int updateByExample(Map map);

    int updateByPrimaryKeySelective(TFinanceMain tFinanceMain);

    int updateByPrimaryKey(TFinanceMain tFinanceMain);

    TFinanceMain selectByProperty(String fcompany_number,String fyear_month,String freport);

    /**
     * 新增公司期间记录
     *
     * @param companyNumber 公司编码
     * @param sheetName sheet页名称
     * @param period 期间
     * @param rcUser 操作用户
     * @return 记录ID
     */
    Long addFinanceMain(String companyNumber,String sheetName,String period,RcUser rcUser);

    /**
     * 获取主表ID，如果主表不存在则新增
     * @param companyNumber 公司编码
     * @param sheetName
     * @param period 期间
     * @param rcUser 操作用户
     * @return 主表ID
     */
    Long getOrAddFinanceMainId(String companyNumber,String sheetName,String period,RcUser rcUser);

    /**
     * 导出合并报表
     * @param rcUser 操作人
     * @param period 期间
     * @param request 请求对象
     * @param wb 模板对象
     */
    void exportUnionReport(RcUser rcUser, String period, HttpServletRequest request, Workbook wb);

    /**
     * createUser 杨北平 to 2017-12-6
     * 根据月份查询出所有公司的报表数据（合并导出）
     * @param year_month
     * @return
     */
    JSONObject selectByMonth(String year_month);
}
