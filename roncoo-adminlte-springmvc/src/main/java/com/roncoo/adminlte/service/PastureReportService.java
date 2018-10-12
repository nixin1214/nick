package com.roncoo.adminlte.service;

import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.TBusinessQuota;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 牧场指标业务处理类
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/7 10:11
 */
public interface PastureReportService {

    /**
     * 获取牛群死淘数据
     * @param orgCode 组织编码
     * @param beginYearMonth 开始期间
     * @param endYearMonth 结束期间
     * @param quotaNames 指标名称
     * @return 结果集
     */
    public Map<String, Object> getOutCattleData(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);

    /**
     *每天牧场chart数据
     * createUser 杨北平 to 2017-11-8
     * @param orgCode 组织编码
     * @param beginYearMonth 开始期间
     * @param endYearMonth 结束期间
     * @param quotaNames 指标名称
     * @return 结果集
     */
    public JSONObject charEveryData(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);
    /**
     *牧场chart数据
     * createUser 杨北平 to 2017-11-8
     * @param orgCode 组织编码
     * @param beginYearMonth 开始期间
     * @param endYearMonth 结束期间
     * @param quotaNames 指标名称
     * @return 结果集
     */
    public JSONObject charData(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);

    /**
     * 销售毛利率数据
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public JSONObject grossMarginData(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames,List<String> grossMargin);
    /*
     * 牧场牛群结构chart数据
     * createUser:杨北平 to 2017-11-9
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public JSONObject chartData(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);

    /**
     * 每日产奶量
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public JSONObject chartDayData(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);

    /**
     * 首页病情分析查已有数据
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public Map<String, List<BigDecimal>> indexIll(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);
    /**
     * 首页病情分析数据
     * createUser:杨北平 to 2017-11-9
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public Map<String, List<BigDecimal>> indexIllness(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);


    /**
     * 从数据库中查询出牧场的各项数据
     * createUser:杨北平 to 2017-11-8
     * @param orgCode 牧场代码
     * @param beginYearMonth 开始时间
     * @param endYearMonth 结束时间
     * @param quotaNames 查询的数据类型
     * @return 结果集
     */
    public List<TBusinessQuota> quotaData(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);

    /**
     * 华山牧乳业销售分析数据
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public Map<String,Object> saleChart(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);
    /**
     * 牛奶产量与理化指标分析table数据
     * createUser:杨北平 to 2017-11-10
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public Map<String,Object> yieldTableData(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);

    /**
     * 牧场chart数据
     * createUser:杨北平 to 2017-11-11
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public JSONObject yieldcharData(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);

    /**
     * 犊牛损失数据
     * createUser:杨北平 to 2017-11-11
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public JSONObject calfLossRateData(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);

    /**
     * 牛群数量结构查询
     * createUser:李沁壕 to 2017-11-10
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public Map<String,Object> getCattleData(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);

    /**
     * 牛群数量charts数据
     * createUser:李沁壕 to 2017-11-10
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public JSONObject getCattleDataJSON(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);

    /**
     * 平均饲料成本charts数据
     * createUser:李沁壕 to 2017-11-13
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public JSONObject getAvgFeedCostJSON(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);

    /**
     * 平均饲料成本集合数据
     * createUser:李沁壕 to 2017-11-13
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public Map<String,Object> getAvgFeedCost(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);




    public JSONObject loopQueryMapData(String orgCode, String yearMonth,int num, List<String> quotaNames);

    /**
     * 财务评价指标charts数据
     * createUser:李沁壕 to 2017-11-14
     * @param orgCodes
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public JSONObject getFinancialEvaluationJSON(List<String> orgCodes, String beginYearMonth, String endYearMonth, List<String> quotaNames,String layout_x,String layout_y);

    /**
     * 产品成本对比charts数据
     * createUser:李沁壕 to 2017-11-14
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public JSONObject getProductCostJSON(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames,String layout_x,String layout_y);

    /**
     * 综合指标-前一月-总和-数据
     * createUser:李沁壕 to 2017-11-15
     * @param orgCodes 牧场代码
     * @param num 结束时间
     * @param quotaNames 查询的数据类型
     * @return 结果集
     */
    public Map<String,Object> getComprehensiveIndex(int num,List<String> orgCodes, List<String> quotaNames,String monthOrDay);


    public Map<String,Object> loopQueryData(int beginTime,int endTime,String orgCode, List<String> quotaNames);
    public JSONObject RatioQuotaDatas(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);
    public JSONObject revenueRatioQuotaDatas(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);
    public JSONObject revenueRatios(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);
    public JSONObject revenuequarter(String orgCode,List<String> yearMonths, List<String> quotaNames);

    /**
     * 从数据库中查询出所有牧场的营收数据
     * createUser:杨北平 to 2017-11-15
     *
     * @param beginYearMonth 开始时间
     * @param endYearMonth 结束时间
     * @param quotaName 查询的数据类型
     * @return 结果集
     */
    public Map<String,Map<String,BigDecimal>> revenueRatioQuotaData(String orgCodes, String beginYearMonth, String endYearMonth, List<String> quotaName);



    public JSONObject unitCostChart(String orgCode, String beginYearMonth, List<String> quotaNames);
    /**
     * 单位完全成本明细
     * createUser:杨北平 to 2017-11-15
     *@param orgCode 牧场代码
     * @param beginYearMonth 开始时间
     * @param quotaNames 查询的数据类型
     * @return 结果集
     */
    public JSONObject unitCostList(String orgCode, String beginYearMonth, List<String> quotaNames);



    /**
     * 乳制品销量明细-年度营收趋势图-charts数据
     * createUser:李沁壕 to 2017-11-15
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public JSONObject getRevenueTrendsJSON(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames, String layout_x, String layout_y);


    public JSONObject getJsonChart(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames, String layout_x, String layout_y);

    public JSONObject getJsonMilkCharts(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);

    public JSONObject getJsonMilkChart(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);
    /**
     * 根据指定参数，动态组装结果集，返回Json对象
     * 只适用于对折线图中某一条数据进行查询
     * createUser:李沁壕 to 2017-11-16
     * @param orgCode 单一公司条件查询
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @param layout_x 定义x轴的值类型 month(按月份排列) or parameter(按查询的参数排列)
     * @param layout_y 定义x轴的值类型 sum(求和) or value(取值)
     * @return
     */
    public JSONObject getJsonObject(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames, String layout_x, String layout_y);

    public JSONObject getSaleCharts(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);

    public JSONObject getSaleChart(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);
    /**
     * 根据指定参数，动态组装结果集，返回Json对象
     * 只适用于对折线图中某一条数据进行查询
     * createUser:江林 to 2017-12-25
     * @param orgCode 单一公司条件查询
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public JSONObject getarea(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);

    /**
     * 获取每天华山牧乳业区域分析
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public JSONObject getareas(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);
    /**
     * 根据指定参数，动态组装结果集，返回Json对象
     * 只适用于对折线图中某一条数据进行查询
     * createUser:李沁壕 to 2017-11-16
     * @param orgCodes 多个公司条件查询
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @param layout_x 定义x轴的值类型 month(按月份排列) or parameter(按查询的参数排列)
     * @param layout_y 定义x轴的值类型 sum(求和) or value(取值)
     * @return
     */
    public JSONObject getJsonObject(List<String> orgCodes, String beginYearMonth, String endYearMonth, List<String> quotaNames, String layout_x, String layout_y);

    /**
     * 从数据库中查询出牧场的各项数据
     * createUser:李沁壕 to 2017-11-15
     * @param orgCodes 牧场集合代码
     * @param yearMonth 时间条件
     * @param quotaNames 查询的数据类型
     * @return 结果集
     */
    public List<TBusinessQuota> quotaData(List<String> orgCodes, String yearMonth, List<String> quotaNames);

    /**
     * 查询已有数据产品销量
     * @param orgCodes
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public Map<String, Object> productSales(List<String> orgCodes, String beginYearMonth, String endYearMonth, List<String> quotaNames);

    public JSONObject productFiveSale(List<String> orgCodes, String beginYearMonth, String endYearMonth, List<String> quotaNames);

    /**
     *查询产品销量
     * @param orgCodes 牧场代码
     * @param beginYearMonth 开始时间
     * @param endYearMonth 结束时间
     * @param quotaNames 查询的数据类型
     * @return 结果集
     */
    public Map<String,Object> productSalesVolume(List<String> orgCodes, String beginYearMonth, String endYearMonth, List<String> quotaNames);

    /**
     * 年度成本走势图-charts数据
     * createUser:杨北平 to 2017-11-17
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public JSONObject costTrendAjax(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);

    /**
     * 查询主营业务收支汇总表
     * createUser 杨北平 to 2017-11-19
     * @param yearMonth 查询月份
     */
    public JSONObject searchSummaryData(String conpanyNumber,String yearMonth,List<Integer> rowNum);

    /**
     * 查询光明乳业的指标数据
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @param layout_x 定义x轴的值类型 month(按月份排列) or parameter(按查询的参数排列)
     * @param layout_y 定义x轴的值类型 sum(求和) or value(取值)
     * @return
     */
    public JSONObject getJsonObjectOfGMRY(String beginYearMonth, String endYearMonth, List<String> quotaNames, String layout_x, String layout_y);

    /**
     * 查询首页应收账款明细数据
     * createUser:杨北平 to 2017-12-21
     * @param orgCode 单一公司条件查询
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */

    /**
     * 查询乳业应收账款明细数据
     * createUser:江林 to 2017-12-23
     * @param orgCode 单一公司条件查询
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public List<Object> getDairyAmount(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);



    /**
     * 单位成本数据
     * createUser 杨北平 to 2017-11-19
     * @param yearMonth 查询月份
     * @param rowNum 数据库Frow_index字段
     */
    public JSONObject searchCostData(String companyNumber,String yearMonth,List<Integer> rowNum);

    /**
     * 从数据库中查询出所有牧场的营收数据
     * createUser:杨北平 to 2017-12-23
     * @param orgCodes 牧场代码
     * @param beginYearMonth 开始时间
     * @param endYearMonth 结束时间
     * @param quotaNames 查询的数据类型
     * @return 结果集
     */
    public Map<String,Object> revenueQuotaData(String orgCodes, String beginYearMonth, String endYearMonth, List<String> quotaNames);



    public JSONObject queryHSMRY(String beginYearMonth,String endYearMonth);


    //public List<BigDecimal> queryOperatingProfit(String company,String beginYearMonth,String endYearMonth,List<String> quotaNames);

    /**
     * create User 杨北平  2018-1-4
     * 查询财务评价指标对比数据
     * @return
     */
    public JSONObject queryFinancialEvaluationIndex(String yearMonth,List<String> quotaNames);

    /**
     * 查询回款率数据
     * 杨北平   2017-12-27
     *
     * @param company
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public List<Object> queryReimbursementRate(String company, String beginYearMonth, String endYearMonth, List<String> quotaNames);

    /**
     *查询乳业营业收入明细数据
     * @param company
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public List<Object> queryReimbursement(String company, String beginYearMonth, String endYearMonth, List<String> quotaNames);


    /**
     * create User 杨北平  2018-01-18
     * 查询牛群发病前5大病种数据
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     */
    public List<TBusinessQuota> dairyCowsMorbidityFiveMaxAjax(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);


    /**
     * 查询单位利润数据
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public JSONObject queryUnitData(String orgCode,String beginYearMonth,String endYearMonth,List<String> quotaNames);

    /**
     * 查询每日产奶量
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public JSONObject dailyYieldAjax(String orgCode,String beginYearMonth,String endYearMonth,List<String> quotaNames);
    /**
     * 查询每日产奶量
     * @param orgCode 组织编码
     * @param beginYearMonth 开始期间
     * @param endYearMonth 结束期间
     * @param quotaNames 指标名称
     * @return 结果集
     */
    public Map<String,Object> getProductionData(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);
    /**
     * 查询每日产奶量
     * @param orgCode 组织编码
     * @param beginYearMonth 开始期间
     * @param endYearMonth 结束期间
     * @param quotaNames 指标名称
     * @return 结果集
     */
    public Map<String, Object>  getProductionChart(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);

    public Map<String, Object>  getSummilkChart(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);

    public List<TBusinessQuota> loopQuery(int numb,List<String> orgCodes,List<String> quotaNames);

    /**
     * 华山牧乳业销售分析数据
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public Map<String, Object>  getsaleChart(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames);


    /**
     * 查询华山牧乳业每日快报主表数据
     * @param orgCode
     * @param num
     * @param quotaNames1
     */
    public Map<String,Object> queryDailyData(String orgCode,int num,List<String> quotaNames1,List<String> quotaNames2);

    public Map<String,Object> queryDailyDatas(String orgCode,int num,List<String> quotaNames1,List<String> quotaNames2);

    /**
     * 组装品类分析数据
     * @param orgCode
     * @param num
     * @param quotaNames
     * @param category
     * @return
     */
    public Map<String,Object> returnCategoryData(String orgCode,String yearMonth,int num,List<String> quotaNames,String category);

}
