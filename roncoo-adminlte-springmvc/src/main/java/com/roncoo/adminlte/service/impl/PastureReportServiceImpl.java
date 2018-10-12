package com.roncoo.adminlte.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.*;
import com.roncoo.adminlte.service.PastureReportService;
import com.roncoo.adminlte.service.impl.dao.BalanceMainBusinessMonthDao;
import com.roncoo.adminlte.service.impl.dao.DataDictionaryListDao;
import com.roncoo.adminlte.service.impl.dao.TFinaceMainDao;
import com.roncoo.adminlte.service.impl.dao.TFinanceOtherDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.*;
import com.roncoo.adminlte.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 牧场指标业务实现类
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/7 10:17
 */
@Service
public class PastureReportServiceImpl implements PastureReportService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TBusinessQuotaMapper businessQuotaMapper;

    @Autowired
    private TFinaceMainDao tFinaceMainDao;

    @Autowired
    private BalanceMainBusinessMonthDao balanceMainBusinessMonthDao;

    @Autowired
    private DataDictionaryListDao dataDictionaryListDao;

    @Autowired
    private TFinanceOtherDao tFinanceOtherDao;

    @Autowired
    private TFinanceMainBusinessListMMapper tfinancemainbusinesslistmMapper;

    @Autowired
    private TFinanceProductCostThisMapper tFinanceProductCostThisMapper;

    @Autowired
    private HSMRYSALEREPORTMapper hsmrysalereportMapper;

    @Autowired
    private RcCompanyMapper rcCompanyMapper;

    @Override
    public Map<String, Object> getOutCattleData(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        //此方法可查询出所有病种，后期可考虑通过病种关联
        List<RcDataDictionaryList> dictList = dataDictionaryListDao.listByFieldCode("MC_BZ");
        //根据开始、结束期间获取期间列表
        List<String> yearMonths = DateUtil.getYearArr(beginYearMonth, endYearMonth);

        List<TBusinessQuota> quotaList = quotaData(orgCode, beginYearMonth, endYearMonth, quotaNames);

        //按“{病种:{期间:数据、数据}}”格式存放数据
        Map<String, Map<String, Map<String, BigDecimal>>> quotaMap = new HashMap<>();
        for (TBusinessQuota quota : quotaList) {
            Map<String, Map<String, BigDecimal>> lineMap = null;
            if (quotaMap.containsKey(quota.getFsmallClass())) {
                lineMap = quotaMap.get(quota.getFsmallClass());
            } else {
                if (quotaMap.containsKey("饲养头日数") && quota.getFsmallClass() == null) {
                    lineMap = quotaMap.get("饲养头日数");
                } else {
                    //此处使用TreeMap是为了防止期间排序错乱
                    lineMap = initLineMap(quotaNames, yearMonths);
                    quotaMap.put(quota.getFsmallClass() == null ? "饲养头日数" : quota.getFsmallClass(), lineMap);
                }
            }
            lineMap.get(quota.getFyearMonth()).put(quota.getFnameEn(), quota.getFvalue());
        }

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("yearMonths", yearMonths);
        resultMap.put("data", quotaMap);
        return resultMap;
    }

    /**
     * 初始化空行数据
     *
     * @param quotaNames 指标列表
     * @param yearMonths 期间列表
     * @return 结果集
     * Created by andrew 2017-11-07
     */
    private Map<String, Map<String, BigDecimal>> initLineMap(List<String> quotaNames, List<String> yearMonths) {
        Map<String, Map<String, BigDecimal>> lineMap;
        lineMap = new TreeMap<>();
        for (String yearMonth : yearMonths) {
            Map<String, BigDecimal> valMap = new HashMap<>();
            //此处默认取两个指标：死亡、淘汰，其它情况不兼容
            for (String quotaName : quotaNames) {
                valMap.put(quotaName, new BigDecimal(0));
            }
            lineMap.put(yearMonth, valMap);
        }
        return lineMap;
    }

    /**
     * 从数据库中查询出牧场的各项数据
     * createUser:杨北平 to 2017-11-8
     *
     * @param orgCode        牧场代码
     * @param beginYearMonth 开始时间
     * @param endYearMonth   结束时间
     * @param quotaNames     查询的数据类型
     * @return 结果集
     */
    public List<TBusinessQuota> quotaData(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        //查询牛群损失指标
        TBusinessQuotaExample example = new TBusinessQuotaExample();
        TBusinessQuotaExample.Criteria criteria = example.createCriteria();
        if (orgCode != null&&orgCode!="") {
            criteria.andForgCodeEqualTo(orgCode);
        }
        criteria.andFyearMonthBetween(beginYearMonth, endYearMonth);
        criteria.andFnameEnIn(quotaNames);
        example.setOrderByClause("fyear_month asc");//排序字段填写数据库表中的字段名
        List<TBusinessQuota> quotaList = businessQuotaMapper.selectByExample(example);
        return quotaList;
    }

    public List<TBusinessQuota> quarter(String orgCode,List<String> yearMonths, List<String> quotaNames) {
        //查询牛群损失指标
        TBusinessQuotaExample example = new TBusinessQuotaExample();
        TBusinessQuotaExample.Criteria criteria = example.createCriteria();
        if (orgCode != null&&orgCode!="") {
            criteria.andForgCodeEqualTo(orgCode);
        }
        criteria.andFyearMonthIn(yearMonths);
        criteria.andFnameEnIn(quotaNames);
        example.setOrderByClause("fyear_month asc");//排序字段填写数据库表中的字段名
        List<TBusinessQuota> quotaList = businessQuotaMapper.selectByExample(example);
        return quotaList;
    }

    /**
     * 从数据库中查询出销售毛利率的各项数据
     *
     * @param orgCode        牧场代码
     * @param beginYearMonth 开始时间
     * @param endYearMonth   结束时间
     * @param quotaNames     查询的数据类型
     * @param grossMargin    查询的数据类型
     * @return 结果集
     */
    public List<TBusinessQuota> quotaMarginData(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames, List<String> grossMargin) {
        //查询各种销售毛利率
        TBusinessQuotaExample example = new TBusinessQuotaExample();
        TBusinessQuotaExample.Criteria criteria = example.createCriteria();
        if (orgCode != null) {
            criteria.andForgCodeEqualTo(orgCode);
        }
        criteria.andFyearMonthBetween(beginYearMonth, endYearMonth);
        criteria.andFnameEnIn(quotaNames);
        criteria.andFsmallClassIn(grossMargin);
        example.setOrderByClause("fyear_month asc");//排序字段填写数据库表中的字段名
        List<TBusinessQuota> quotaList = businessQuotaMapper.selectByExample(example);
        return quotaList;
    }

    /**
     * 从数据库中查询出牧场的各项数据
     * createUser:李沁壕 to 2017-11-15
     *
     * @param orgCodes       牧场集合代码
     * @param beginYearMonth 开始时间
     * @param endYearMonth   结束时间
     * @param quotaNames     查询的数据类型
     * @return 结果集
     */
    public List<TBusinessQuota> quotaData(List<String> orgCodes, String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        //查询牛群损失指标
        TBusinessQuotaExample example = new TBusinessQuotaExample();
        TBusinessQuotaExample.Criteria criteria = example.createCriteria();
        if (orgCodes != null) {
            criteria.andForgCodeIn(orgCodes);
        }
        criteria.andFyearMonthBetween(beginYearMonth, endYearMonth);
        criteria.andFnameEnIn(quotaNames);
        example.setOrderByClause("fyear_month asc");//排序字段填写数据库表中的字段名
        List<TBusinessQuota> quotaList = businessQuotaMapper.selectByExample(example);
        return quotaList;
    }

    /**
     * 从数据库中查询出牧场的各项数据
     * createUser:李沁壕 to 2017-11-15
     *
     * @param orgCodes   牧场集合代码
     * @param yearMonth  时间条件
     * @param quotaNames 查询的数据类型
     * @return 结果集
     */
    public List<TBusinessQuota> quotaData(List<String> orgCodes, String yearMonth, List<String> quotaNames) {
        //查询牛群损失指标
        TBusinessQuotaExample example = new TBusinessQuotaExample();
        TBusinessQuotaExample.Criteria criteria = example.createCriteria();
        if (orgCodes != null) {
            criteria.andForgCodeIn(orgCodes);
        }
        criteria.andFyearMonthEqualTo(yearMonth);
        criteria.andFnameEnIn(quotaNames);
        List<TBusinessQuota> quotaList = businessQuotaMapper.selectByExample(example);
        return quotaList;
    }

    /**
     * 查询光明乳业的指标数据
     *
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @param layout_x       定义x轴的值类型 month(按月份排列) or parameter(按查询的参数排列)
     * @param layout_y       定义x轴的值类型 sum(求和) or value(取值)
     * @return
     */
    public JSONObject getJsonObjectOfGMRY(String beginYearMonth, String endYearMonth, List<String> quotaNames, String layout_x, String layout_y) {
        List<TFinanceOther> quotaList = quotaDataOfGMRY(beginYearMonth, endYearMonth, quotaNames);
        return getJsonObjectBaseOfGMRY(beginYearMonth, endYearMonth, quotaNames, layout_x, layout_y, quotaList);
    }

    /**
     * 根据指定参数，动态组装结果集，返回Json对象
     * 只适用于对折线图中某一条数据进行查询
     * createUser:李沁壕 to 2017-11-30
     *
     * @param beginYearMonth 开始月份
     * @param endYearMonth   结束月份
     * @param quotaNames     查询参数
     * @param quotaList      结果集
     * @param layout_x       定义x轴的值类型 month(按月份排列) or parameter(按查询的参数排列)
     * @param layout_y       定义x轴的值类型 sum(求和) or value(取值)
     * @return
     */
    private JSONObject getJsonObjectBaseOfGMRY(String beginYearMonth, String endYearMonth, List<String> quotaNames, String layout_x, String layout_y, List<TFinanceOther> quotaList) {
        //根据开始、结束期间获取期间列表
        List<String> yearMonths = DateUtil.getYearMonthArr(beginYearMonth, endYearMonth);
        JSONObject json = new JSONObject();
        int length = 0;
        if (layout_x.equals("parameter")) {//x轴以参数列表排列
            length = quotaNames.size();
        } else if (layout_x.equals("month")) {//x轴以月份列表排列
            json.put("axisx", yearMonths);
            length = yearMonths.size();
        }
        String[] arr_x = new String[length];//X轴节点集
        BigDecimal[] arr_y = new BigDecimal[length];//y轴上值
        for (int i = 0; i < length; i++) {
            arr_y[i] = new BigDecimal(0);
        }
        Boolean flag_y = true;//y轴值数组是否在循环中组装
        for (TFinanceOther quota : quotaList) {//遍历结果集
            int item = length;//y轴应组装次数
            for (int i = 0; i < item; i++) {//遍历组装折线数列
                Boolean flag_x = false;
                if (layout_x.equals("month")) {//x轴以时间列表排列
                    flag_x = quota.getFyearmonth().equals(yearMonths.get(i));
                } else if (layout_x.equals("parameter")) {//x轴以参数列表排列
                    flag_x = quota.getFquotaName().equals(quotaNames.get(i));
                }
                if (flag_x) {//x轴以参数列表排列
                    if (layout_y.equals("sum")) {//y轴值-累加
                        arr_y[i] = arr_y[i].add(quota.getFquotaValue().setScale(2, BigDecimal.ROUND_DOWN));
                    } else if (layout_y.equals("value")) {//y轴值-直接取值
                        arr_y[i] = quota.getFquotaValue().setScale(2, BigDecimal.ROUND_DOWN);
                    }
                    if (flag_y) {//组装y轴值数组
                        if (arr_x[i] == null) {//判断值是否已写入
                            arr_x[i] = quota.getFremark();
                            item--;
                            if (item == 0) {//已组装完毕
                                flag_y = false;
                            }
                        }
                    }
                }
            }
        }
        if (layout_x.equals("parameter")) {//x轴以参数列表排列
            json.put("axisx", arr_x);
        }
        json.put("axisy", arr_y);
        return json;
    }

    /**
     * 从数据库中查询出光明乳业的数据
     * createUser:李沁壕 to 2017-11-30
     *
     * @param beginYearMonth 开始时间
     * @param endYearMonth   结束时间
     * @param quotaNames     查询的数据类型
     * @return 结果集
     */
    public List<TFinanceOther> quotaDataOfGMRY(String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        //查询光明乳业指标
        TFinanceOtherExample example = new TFinanceOtherExample();
        TFinanceOtherExample.Criteria criteria = example.createCriteria();
        criteria.andFyearmonthBetween(beginYearMonth, endYearMonth);//时间范围
        criteria.andFquotaNameIn(quotaNames);//指标名-过滤
        example.setOrderByClause("fyearmonth asc");//排序字段填写数据库表中的字段名
        List<TFinanceOther> quotaList = tFinanceOtherDao.selectByExample(example);
        return quotaList;
    }

    /**
     * 牧场chart数据
     * createUser:杨北平 to 2017-11-8
     *
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public JSONObject charData(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        //根据开始、结束期间获取期间列表
        List<String> yearMonths = DateUtil.getYearArr(beginYearMonth, endYearMonth);
        List<TBusinessQuota> quotaList = quotaData(orgCode, beginYearMonth, endYearMonth, quotaNames);
        JSONObject json = new JSONObject();
        json.put("yearMonths", yearMonths);
        List<BigDecimal> swFvalues = new ArrayList<>();
        List<BigDecimal> ttFvalues = new ArrayList<>();
        for (String yearMonth : yearMonths) {
            BigDecimal swFvalue = BigDecimal.ZERO;
            BigDecimal ttFvalue = BigDecimal.ZERO;
            for (TBusinessQuota tbq : quotaList) {
                if (yearMonth.equals(tbq.getFyearMonth())) {
                    if (tbq.getFnameEn().equals(quotaNames.get(0))) {
                        swFvalue = swFvalue.add(tbq.getFvalue());
                    } else {
                        ttFvalue = ttFvalue.add(tbq.getFvalue());
                    }
                }
            }
            swFvalues.add(swFvalue);
            ttFvalues.add(ttFvalue);
        }
        json.put("swFvalues", swFvalues);
        json.put("ttFvalues", ttFvalues);
        return json;
    }
    /**
     * 每天牧场chart数据
     * createUser:倪鑫 to 2017-11-8
     *
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public JSONObject charEveryData(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames){
        List<String> list = DateUtil.getYearMonthDayArr(beginYearMonth,endYearMonth);
        List<TBusinessQuota> quotaList = quotaData(orgCode, beginYearMonth, endYearMonth, quotaNames);
        JSONObject json = new JSONObject();
        json.put("yearMonths", list);
        List<BigDecimal> swFvalues = new ArrayList<>();
        List<BigDecimal> ttFvalues = new ArrayList<>();
        for (String yearMonth : list) {
            BigDecimal swFvalue = BigDecimal.ZERO;
            BigDecimal ttFvalue = BigDecimal.ZERO;
            for (TBusinessQuota tbq : quotaList) {
                if (yearMonth.equals(tbq.getFyearMonth())) {
                    if (tbq.getFnameEn().equals(quotaNames.get(0))) {
                        swFvalue = swFvalue.add(tbq.getFvalue());
                    } else {
                        ttFvalue = ttFvalue.add(tbq.getFvalue());
                    }
                }
            }
            swFvalues.add(swFvalue);
            ttFvalues.add(ttFvalue);
        }
        json.put("swFvalues", swFvalues);
        json.put("ttFvalues", ttFvalues);
        return json;
    }

    /**
     * 牧场牛群结构chart数据
     * createUser:杨北平 to 2017-11-9
     *
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public JSONObject chartData(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        //根据开始、结束期间获取期间列表
        List<String> yearMonths = DateUtil.getYearMonthArr(beginYearMonth, endYearMonth);
        List<TBusinessQuota> quotaList = quotaData(orgCode, beginYearMonth, endYearMonth, quotaNames);
        JSONObject json = new JSONObject();
        for (TBusinessQuota quota : quotaList) {
            json.put(quota.getFnameZh().split("-")[1], quota.getFvalue());
        }
        return json;
    }
    public JSONObject getSaleCharts(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames){
        List<String> yearMonths = DateUtil.getYearArr(beginYearMonth, endYearMonth);
        List<TBusinessQuota> quotaList = quotaData(orgCode, beginYearMonth, endYearMonth, quotaNames);
        JSONObject json = new JSONObject();
        for (String quotaName:quotaNames){
            List<BigDecimal> resultList = new ArrayList<>();
            for (int i = 0; i < yearMonths.size(); i++) {
                resultList.add(BigDecimal.ZERO);
            }
            for(int j=0;j<yearMonths.size();j++){
                BigDecimal value = BigDecimal.ZERO;
                for(TBusinessQuota quota:quotaList){
                    if (quota.getFnameEn().equals(quotaName)&&quota.getFyearMonth().equals(yearMonths.get(j))){
                        value = value.add(quota.getFvalue());
                    }
                }
                resultList.set(j,value);
            }
            json.put(quotaName,resultList);
        }
        json.put("yearMonth",yearMonths);
        return json;
    }

    public JSONObject getSaleChart(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames){
        List<String> list = DateUtil.getYearMonthDayArr(beginYearMonth,endYearMonth);
        List<TBusinessQuota> quotaList = quotaData(orgCode, beginYearMonth, endYearMonth, quotaNames);
        JSONObject json = new JSONObject();
        for (String quotaName:quotaNames){
            List<BigDecimal> resultList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                resultList.add(BigDecimal.ZERO);
            }
            for(int j=0;j<list.size();j++){
                BigDecimal value = BigDecimal.ZERO;
                for(TBusinessQuota quota:quotaList){
                    if (quota.getFnameEn().equals(quotaName)&&quota.getFyearMonth().equals(list.get(j))){
                        value = value.add(quota.getFvalue());
                    }
                }
                resultList.set(j,value);
            }
            json.put(quotaName,resultList);
        }
        json.put("yearMonth",list);
        return json;
    }
    /**
     * 每日产奶量数据
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public JSONObject chartDayData(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames){
        List<TBusinessQuota> quotaList = quotaData(orgCode, beginYearMonth, endYearMonth, quotaNames);
        JSONObject json = new JSONObject();
        List<String> list = getDateArr(quotaList);
            for (String quotaName:quotaNames){
                List<BigDecimal> resultList = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    resultList.add(BigDecimal.ZERO);
                }
                for(int j=0;j<list.size();j++){
                    for(TBusinessQuota quota:quotaList){
                        if (quota.getFnameEn().equals(quotaName)&&quota.getFyearMonth().equals(list.get(j))){
                            resultList.set(j,quota.getFvalue());
                        }
                    }
                }
                json.put(quotaName,resultList);
            }
            json.put("yearMonth",list);
            return json;
    }

    /**
     * 获取日期列表
     * @param quotaList
     * @return
     */
    public List<String> getDateArr(List<TBusinessQuota> quotaList){
        List<String> list = new ArrayList<>();
        for (TBusinessQuota quota:quotaList){
            if (!list.contains(quota.getFyearMonth())){
                list.add(quota.getFyearMonth());
            }
        }
        return list;
    }



    /**
     * 销售毛利率数据
     *
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public JSONObject grossMarginData(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames, List<String> grossMargin) {
        return getMarginDataJsonObject(orgCode, beginYearMonth, endYearMonth, quotaNames, grossMargin);
    }

    /**
     * 首页病情分析查已有数据
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public Map<String, List<BigDecimal>> indexIll(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames){
        //endYearMonth =  DateUtil.getBeginMonth(endYearMonth,1)[0];
        Map<String, List<BigDecimal>> structureData = indexIllness(orgCode,beginYearMonth,endYearMonth,quotaNames);
        List<BigDecimal> list = new ArrayList<>();
        BigDecimal yearMonth = new BigDecimal(endYearMonth);
        list.add(yearMonth);
        structureData.put("yearMonth",list);
        return structureData;
    }
    /**
     * 首页病情分析数据
     * createUser:杨北平 to 2017-11-9
     *
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public Map<String, List<BigDecimal>> indexIllness(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        //根据开始、结束期间获取期间列表
        List<TBusinessQuota> quotaList = quotaData(orgCode, beginYearMonth, endYearMonth, quotaNames);
        Map<String, List<BigDecimal>> structureData = new HashMap<>();
        List<String> fnameEn = new ArrayList<>();
        List<String> typeName = new ArrayList<>();
        for (TBusinessQuota quota : quotaList) {
            boolean boo = true;
            for (String type : typeName) {
                if (quota.getFnameEn().contains(type)) {
                    boo = false;
                }
            }
            if (boo && quota.getFnameEn().contains("FBN")) {
                typeName.add(quota.getFnameEn().substring(5, 7));
                fnameEn.add(quota.getFnameEn());
            }
        }
        for (int i = 0; i < typeName.size(); i++) {
            List<BigDecimal> ratios = new ArrayList<BigDecimal>() {{
                add(BigDecimal.ZERO);
                add(BigDecimal.ZERO);
                add(BigDecimal.ZERO);
                add(BigDecimal.ZERO);
            }};
            BigDecimal ratio1 = BigDecimal.ZERO;
            BigDecimal ratio2 = BigDecimal.ZERO;
            for (TBusinessQuota quota : quotaList) {
                if (quota.getFnameEn().contains(typeName.get(i))) {
                    if (quota.getFnameEn().equals(fnameEn.get(i))) {
                        if (!quota.getFyearMonth().equals(beginYearMonth)) {
                            ratios.set(0, quota.getFvalue());
                        } else {
                            ratio1 = quota.getFvalue();
                        }
                    } else {
                        if (!quota.getFyearMonth().equals(beginYearMonth)) {
                            ratios.set(2, quota.getFvalue());
                        } else {
                            ratio2 = quota.getFvalue();
                        }
                    }
                }
            }
            ratios.set(1, (ratios.get(0).subtract(ratio1)));
            ratios.set(3, (ratios.get(2).subtract(ratio2)));
            structureData.put(typeName.get(i), ratios);
        }
        return structureData;
    }

    /**
     * 牛奶产量与理化指标分析table数据
     * createUser:杨北平 to 2017-11-10
     *
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public Map<String, Object> yieldTableData(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        //根据开始、结束期间获取期间列表
        List<String> yearMonths = DateUtil.getYearArr(beginYearMonth, endYearMonth);
        List<TBusinessQuota> quotaList = quotaData(orgCode, beginYearMonth, endYearMonth, quotaNames);
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, BigDecimal> crnNum = new TreeMap<>();
        Map<String, BigDecimal> mrnNum = new TreeMap<>();
        resultMap.put("yearMonths", yearMonths);
        for (String quotaName : quotaNames) {
            Map<String, BigDecimal> resultList = new TreeMap<>();
            for (String yearMonth : yearMonths) {
                resultList.put(yearMonth, new BigDecimal(0));
            }
            for (TBusinessQuota quota : quotaList) {
                if (quotaName.equals(quota.getFnameEn())) {
                    resultList.put(quota.getFyearMonth(), quota.getFvalue());
                }
            }
            switch (quotaName) {
                case "PJRCNL-MRN-QK":
                    resultMap.put("泌乳牛", resultList);
                    break;
                case "PJRCNL-CRN-QK":
                    resultMap.put("成乳牛", resultList);
                    break;
                case "SYTR-MRN":
                    resultMap.put("泌乳牛饲养头日", resultList);
                    mrnNum.putAll(resultList);
                    break;
                case "SYTR-CRN":
                    resultMap.put("成乳牛饲养头日", resultList);
                    crnNum.putAll(resultList);
                    break;
                case "PJRCNL-QK":
                    resultMap.put("月总产奶量", resultList);
                    break;
                case "PJRCNL-PJMRTS-DAY":
                    resultMap.put("平均泌乳天数", resultList);
                    break;
                default:
                    resultMap.put(quotaName, resultList);
            }
        }
        List<BigDecimal> ratio = new ArrayList<>();
        for (Object crnKey : crnNum.keySet()) {
            for (Object mrnKey : mrnNum.keySet()) {
                if (crnKey.equals(mrnKey)) {
                    if (crnNum.get(crnKey).equals(BigDecimal.ZERO)) {
                        ratio.add(BigDecimal.ZERO);
                    } else {
                        ratio.add((crnNum.get(crnKey).subtract(mrnNum.get(mrnKey))).divide(crnNum.get(crnKey), 2, BigDecimal.ROUND_HALF_UP));
                    }
                }
            }
        }
        resultMap.put("ratio", ratio);
        return resultMap;
    }

    /**
     * 牧场chart数据
     * createUser:杨北平 to 2017-11-11
     *
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public JSONObject yieldcharData(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        //根据开始、结束期间获取期间列表
        List<String> yearMonths = DateUtil.getYearArr(beginYearMonth, endYearMonth);
        List<TBusinessQuota> quotaList = quotaData(orgCode, beginYearMonth, endYearMonth, quotaNames);
        JSONObject json = new JSONObject();
        json.put("yearMonths", yearMonths);
        for (String quotaName : quotaNames) {
            List<BigDecimal> resultList = new ArrayList<>();
            for (int i = 0; i < yearMonths.size(); i++) {
                resultList.add(BigDecimal.ZERO);
            }
            for (TBusinessQuota quota : quotaList) {
                if (quotaName.equals(quota.getFnameEn())) {
                    for (int i = 0; i < yearMonths.size(); i++) {
                        if (quota.getFyearMonth().equals(yearMonths.get(i))) {
                            resultList.set(i, quota.getFvalue());
                        }
                    }
                }
            }
            json.put(quotaName, resultList);
        }
        return json;
    }

    /**
     * 犊牛损失数据
     * createUser:杨北平 to 2017-11-11
     *
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public JSONObject calfLossRateData(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        //根据开始、结束期间获取期间列表
        List<String> yearMonths = DateUtil.getYearArr(beginYearMonth, endYearMonth);
        List<TBusinessQuota> quotaList = quotaData(orgCode, beginYearMonth, endYearMonth, quotaNames);
        JSONObject json = new JSONObject();
        json.put("yearMonths", yearMonths);
        Map<String, List<Object>> PZSBDTTT = new HashMap<>();
        for (int i = 0; i < quotaNames.size(); i++) {
            List<Object> resultList = new ArrayList<>();
            for (String yearMonth : yearMonths) {
                resultList.add(BigDecimal.ZERO);
            }
            BigDecimal sum = BigDecimal.ZERO;
            for (TBusinessQuota quota : quotaList) {
                if (quotaNames.get(i).equals(quota.getFnameEn())) {
                    for (int j = 0; j < yearMonths.size(); j++) {
                        if (quota.getFyearMonth().equals(yearMonths.get(j))) {
                            resultList.set(j, quota.getFvalue());
                        }
                    }
                    sum = sum.add(quota.getFvalue());
                }
            }
            resultList.add(sum);
            PZSBDTTT.put(quotaNames.get(i), resultList);
        }
        json.put("quota", PZSBDTTT);
        json.put("companyNumber", orgCode);
        return json;
    }


    /**
     * 牛群数量结构查询
     * createUser:李沁壕 to 2017-11-10
     *
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public Map<String, Object> getCattleData(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        //根据开始、结束期间获取期间列表
        List<String> yearMonths = DateUtil.getYearMonthArr(beginYearMonth, endYearMonth);
        List<TBusinessQuota> quotaList = quotaData(orgCode, beginYearMonth, endYearMonth, quotaNames);

        Map<String, Object> data = new HashMap<>();
        for (String fNameEn : quotaNames) {
            List<TBusinessQuota> numberOfCattle = new ArrayList<>();
            TBusinessQuota item = new TBusinessQuota();
            item.setFvalue(BigDecimal.ZERO);
            for (int i = 0; i < 12; i++) {
                numberOfCattle.add(item);
            }
            String fNameZh = new String();
            for (TBusinessQuota quota : quotaList) {
                if (quota.getFnameEn().equals(fNameEn)) {
                    fNameZh = quota.getFnameZh();
                    numberOfCattle.set(yearMonths.indexOf(quota.getFyearMonth()), quota);
                }
            }
            if (fNameZh.split("-").length > 1) {
                data.put(fNameZh.split("-")[1], numberOfCattle);
            }
        }

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("yearMonths", yearMonths);
        resultMap.put("data", data);
        return resultMap;
    }

    /**
     * 牛群数量chart数据
     * createUser:李沁壕 to 2017-11-10
     *
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public JSONObject getCattleDataJSON(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        return getTypeOfDataJsonObject(orgCode, beginYearMonth, endYearMonth, quotaNames);
    }

    /**
     * 平均饲料成本charts数据
     * createUser:李沁壕 to 2017-11-13
     *
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public JSONObject getAvgFeedCostJSON(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        return getTypeOfDataJsonObject(orgCode, beginYearMonth, endYearMonth, quotaNames);
    }

    /**
     * 根据查询参数集，获取折线图数据
     * createUser:李沁壕 to 2017-11-13
     *
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    private JSONObject getTypeOfDataJsonObject(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        //根据开始、结束期间获取期间列表，X轴节点
        List<String> yearMonths = DateUtil.getYearArr(beginYearMonth, endYearMonth);
        List<TBusinessQuota> quotaList = quotaData(orgCode, beginYearMonth, endYearMonth, quotaNames);

        JSONObject json = new JSONObject();
        //遍历Y轴节点
        for (String fNameEn : quotaNames) {
            String[] arr = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
            String fNameZh = new String();
            for (TBusinessQuota quota : quotaList) {
                if (quota.getFnameEn().equals(fNameEn)) {
                    fNameZh = quota.getFnameZh();
                    arr[yearMonths.indexOf(quota.getFyearMonth())] = quota.getFvalue().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
                }
            }
            if (fNameZh.split("-").length > 1) {
                json.put(fNameZh.split("-")[1], arr);
            }
        }
        json.put("yearMonths", yearMonths);

        return json;
    }

    /**
     * 销售毛利率chart数据
     *
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @param grossMargin
     * @return
     */
    private JSONObject getMarginDataJsonObject(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames, List<String> grossMargin) {
        //根据开始、结束期间获取期间列表，X轴节点
        List<String> yearMonths = DateUtil.getYearMonthArr(beginYearMonth, endYearMonth);
        List<TBusinessQuota> quotaList = quotaMarginData(orgCode, beginYearMonth, endYearMonth, quotaNames, grossMargin);
        String[] gross = {"常温奶毛利率", "低温奶毛利率", "固定奶粉毛利率"};
        BigDecimal[] CWN = new BigDecimal[yearMonths.size()];
        BigDecimal[] DWN = new BigDecimal[yearMonths.size()];
        BigDecimal[] GTNF = new BigDecimal[yearMonths.size()];
        List<BigDecimal[]> NFList = new ArrayList<>();
        NFList.add(CWN);
        NFList.add(DWN);
        NFList.add(GTNF);
        JSONObject json = new JSONObject();
        //遍历Y轴节点
        for (String fNameEn : quotaNames) {
            String fNameZh = new String();
            for (TBusinessQuota quota : quotaList) {
                for (int i = 0; i < gross.length; i++) {
                    if (quota.getFsmallClass().equals(gross[i])) {
                        NFList.get(i)[yearMonths.indexOf(quota.getFyearMonth())] = quota.getFvalue();
                    }
                }
            }
        }
        json.put("yearMonths", yearMonths);
        json.put("CWN", NFList.get(0));
        json.put("DWN", NFList.get(1));
        json.put("GTNF", NFList.get(2));
        return json;
    }

    /**
     * 平均饲料成本集合数据
     * createUser:李沁壕 to 2017-11-13
     *
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public Map<String, Object> getAvgFeedCost(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        //根据开始、结束期间获取期间列表
        List<String> yearMonths = DateUtil.getYearMonthArr(beginYearMonth, endYearMonth);
        List<TBusinessQuota> quotaList = quotaData(orgCode, beginYearMonth, endYearMonth, quotaNames);

        Map<String, Object> data = new HashMap<>();//存放所有数据
        Set<String> filterOfNames = new HashSet<>();
        for (String fNameEn_repeat : quotaNames) {//截取，去重
            filterOfNames.add(fNameEn_repeat.split("-")[1]);
        }
        for (String fNameEn_only : filterOfNames) {//按种类遍历
            Map<String, Object> typeQuota = new HashMap<>();//存放每种牛的数据
            List<TBusinessQuota> quota_PJMRSLCB = new ArrayList<>();//平均每日饲料成本
            List<TBusinessQuota> quota_SYTR = new ArrayList<>();//饲养头日
            List<TBusinessQuota> quota_YSLCB = new ArrayList<>();//月饲料成本
            TBusinessQuota item = new TBusinessQuota();
            item.setFvalue(BigDecimal.ZERO);
            for (int i = 0; i < 12; i++) {
                quota_PJMRSLCB.add(item);
                quota_SYTR.add(item);
                quota_YSLCB.add(item);
            }
            String fNameZh = new String();
            boolean flag = true;
            for (TBusinessQuota quota : quotaList) {
                if (quota.getFnameEn().split("-")[1].equals(fNameEn_only)) {
                    String aaa = quota.getFnameEn().split("-")[0];
                    String bbb = quota.getFnameEn().split("-")[1];
                    String ccc = fNameEn_only;
                    if (quota.getFnameEn().split("-")[0].equals("PJMRSLCB")) {
                        quota_PJMRSLCB.set(yearMonths.indexOf(quota.getFyearMonth()), quota);
                    } else if (quota.getFnameEn().split("-")[0].equals("SYTR")) {
                        quota_SYTR.set(yearMonths.indexOf(quota.getFyearMonth()), quota);
                    } else if (quota.getFnameEn().split("-")[0].equals("YSLCB")) {
                        quota_YSLCB.set(yearMonths.indexOf(quota.getFyearMonth()), quota);
                    }
                    if (flag) {//获取种类的中文名
                        fNameZh = quota.getFnameZh().split("-")[1];
                    }
                    flag = false;
                }
            }
            typeQuota.put("PJMRSLCB", quota_PJMRSLCB);
            typeQuota.put("SYTR", quota_SYTR);
            typeQuota.put("YSLCB", quota_YSLCB);
            data.put(fNameZh, typeQuota);
        }

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("yearMonths", yearMonths);
        resultMap.put("data", data);
        return resultMap;
    }

    public JSONObject loopQueryMapData(String orgCode, String yearMonth,int num, List<String> quotaNames){
        List<TBusinessQuota> quotaList = null;
        JSONObject json = new JSONObject();
        String[] yearMonthArr = null;
        List<Map<String,Object>> resultList = new ArrayList<>();
        if (yearMonth!="") {
            if (yearMonth.length() == 6 && !yearMonth.contains("Q")) {
                yearMonthArr = DateUtil.getBeginMonth(yearMonth, num);
            } else if (yearMonth.contains("Q")) {
                yearMonthArr = seasonTransMonths(yearMonth);
            } else {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                try {
                    Date date = dateFormat.parse(yearMonth);
                    Date date1 = DateUtil.addDate(date, -num);
                    String endYearMonth = dateFormat.format(date);
                    String beginYearMonth = dateFormat.format(date1);
                    yearMonthArr = new String[2];
                    yearMonthArr[0] = beginYearMonth;
                    yearMonthArr[1] = endYearMonth;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            quotaList = quotaData(orgCode, yearMonthArr[0], yearMonthArr[1], quotaNames);
            for(int i = 0;i < 2;i++){
                resultList.add(getMapData(yearMonthArr[i]));
            }
            for (TBusinessQuota quota:quotaList){
                if (quota.getFyearMonth().equals(yearMonthArr[0])) {
                    resultList.get(0).put("name", quota.getFsmallClass());
                    resultList.get(0).put("value", quota.getFvalue());
                    resultList.get(0).put("yearMonth", quota.getFyearMonth());
                }else {
                    resultList.get(1).put("name", quota.getFsmallClass());
                    resultList.get(1).put("value", quota.getFvalue());
                    resultList.get(1).put("yearMonth", quota.getFyearMonth());
                }
            }
            json.put("yearMonth",yearMonthArr[1]);
        }else {
            String date=null;
            if (orgCode.equals("ZKRY")) {
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
                date = format.format(new Date());
            }else {
                date = DateUtil.getOldMonth(new Date());
            }
            quotaList = quotaData(orgCode, date, quotaNames);
            resultList.add(getMapData(date));
            for (TBusinessQuota quota:quotaList){
                resultList.get(0).put("name", quota.getFsmallClass());
                resultList.get(0).put("value", quota.getFvalue());
                resultList.get(0).put("yearMonth", quota.getFyearMonth());
            }
            json.put("yearMonth",date);
        }
        json.put("result",resultList);
        return json;
    }

    //组装地图数据(填充空Map)
    public Map<String,Object> getMapData(String yearMonth){
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("name", "");
        resultMap.put("value", 0);
        resultMap.put("yearMonth", yearMonth);
        return resultMap;
    }


    //得到每个季度的月份
    public String[] seasonTransMonths(String yearMonth){
        String seasonYear = yearMonth.substring(0,4);
        String seasonQ = yearMonth.substring(4);
        String yearMonthArr[] = new String[2];
        String seasonOldYear = DateUtil.getOldYear(seasonYear);

        switch (seasonQ){
            case "Q1":
                yearMonthArr[0] = seasonOldYear+"Q4";
                yearMonthArr[1] = seasonYear+"Q1";
                break;
            case "Q2":
                yearMonthArr[0] = seasonYear+"Q1";
                yearMonthArr[1] = seasonYear+"Q2";
                break;
            case "Q3":
                yearMonthArr[0] = seasonYear+"Q2";
                yearMonthArr[1] = seasonYear+"Q3";
                break;
            case "Q4":
                yearMonthArr[0] = seasonYear+"Q3";
                yearMonthArr[1] = seasonYear+"Q4";
                break;
        }
        return yearMonthArr;
    }

    /**
     *
     * @param orgCode
     * @param yearMonth
     * @param quotaNames
     * @return
     */
    public List<TBusinessQuota> quotaData(String orgCode, String yearMonth, List<String> quotaNames) {

        TBusinessQuotaExample example = new TBusinessQuotaExample();
        TBusinessQuotaExample.Criteria criteria = example.createCriteria();
        if (orgCode != null&&orgCode!="") {
            criteria.andForgCodeEqualTo(orgCode);
        }
        criteria.andFyearMonthLike(yearMonth);
        criteria.andFnameEnIn(quotaNames);
        example.setOrderByClause("fyear_month asc");//排序字段填写数据库表中的字段名
        List<TBusinessQuota> quotaList = businessQuotaMapper.selectByExample(example);
        return quotaList;
    }


    /**
     * 首页中<对比分析>板块，财务评价指标charts数据
     * createUser:李沁壕 to 2017-11-14
     *
     * @param orgCodes
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public JSONObject getFinancialEvaluationJSON(List<String> orgCodes, String beginYearMonth, String endYearMonth, List<String> quotaNames, String layout_x, String layout_y) {
        return getJsonObject(orgCodes, beginYearMonth, endYearMonth, quotaNames, layout_x, layout_y);
    }

    /**
     * 首页中<对比分析>板块，产品成本对比charts数据
     * createUser:李沁壕 to 2017-11-14
     *
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public JSONObject getProductCostJSON(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames, String layout_x, String layout_y) {
        return getJsonObject(orgCode, beginYearMonth, endYearMonth, quotaNames, layout_x, layout_y);
    }
    public JSONObject getJsonChart(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames, String layout_x, String layout_y) {
        JSONObject resultList = getJsonObject(orgCode,beginYearMonth,endYearMonth,quotaNames,layout_x,layout_y);
        BigDecimal result = (BigDecimal)(resultList.getJSONArray("axisy").get(0));
            while (result.equals(BigDecimal.ZERO)||result.equals(new BigDecimal("0.00"))){
                beginYearMonth = DateUtil.getBeginMonth(beginYearMonth, 1)[0];
                endYearMonth = DateUtil.getBeginMonth(endYearMonth, 1)[0];
                resultList = getJsonObject(orgCode,beginYearMonth,endYearMonth,quotaNames,layout_x,layout_y);
                result =  (BigDecimal)(resultList.getJSONArray("axisy").get(0));
            }
        resultList.put("beginTime",beginYearMonth);
        return resultList;
    }
    /**
     * 根据指定参数，动态组装结果集，返回Json对象
     * 只适用于对折线图中某一条数据进行查询
     * createUser:李沁壕 to 2017-11-16
     *
     * @param orgCode        单一公司条件查询
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @param layout_x       定义x轴的值类型 month(按月份排列) or parameter(按查询的参数排列)
     * @param layout_y       定义x轴的值类型 sum(求和) or value(取值)
     * @return
     */
    public JSONObject getJsonObject(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames, String layout_x, String layout_y) {
        List<TBusinessQuota> quotaList = quotaData(orgCode, beginYearMonth, endYearMonth, quotaNames);
        return getJsonObjectBase(beginYearMonth, endYearMonth, quotaNames, layout_x, layout_y, quotaList);
    }


    /**
     * 区域分析
     * 根据指定参数，动态组装结果集，返回Json对象
     * 只适用于区域分析
     * createUser:江林 to 2017-12-25
     *
     * @param orgCode        单一公司条件查询
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public JSONObject getarea(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        //根据开始、结束期间获取期间列表
        List<String> yearMonths = DateUtil.getYearArr(beginYearMonth, endYearMonth);
        List<TBusinessQuota> quotaList = quotaData(orgCode, beginYearMonth, endYearMonth, quotaNames);
        List<String> list = new ArrayList<String>();
        for (TBusinessQuota tbq : quotaList) {
            if (list.contains(tbq.getFsmallClass())||tbq.getFsmallClass()==null) {
                continue;
            } else {
                list.add(tbq.getFsmallClass());
            }
        }
        JSONObject lineMap = new JSONObject();
        for (String smallClass : list) {
                List<BigDecimal> lineList = new ArrayList<>();
                for (int i = 0; i < yearMonths.size(); i++) {
                    lineList.add(new BigDecimal("0"));
                }
                for (TBusinessQuota tbq : quotaList) {
                    if (smallClass.equals(tbq.getFsmallClass())) {
                        for (int j = 0; j < yearMonths.size(); j++) {
                            if (tbq.getFyearMonth().equals(yearMonths.get(j))) {
                                lineList.set(j, tbq.getFvalue());
                            }
                        }
                    }
                }
                lineMap.put(smallClass, lineList);
        }
        lineMap.put("yearMonth", yearMonths);
        return lineMap;
    }
    public JSONObject getareas(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        //根据开始、结束期间获取期间列表
        List<String> yearMonths = DateUtil.getYearMonthDayArr(beginYearMonth,endYearMonth);
        List<TBusinessQuota> quotaList = quotaData(orgCode, beginYearMonth, endYearMonth, quotaNames);
        List<String> list = new ArrayList<String>();
        for (TBusinessQuota tbq : quotaList) {
            if (list.contains(tbq.getFsmallClass())||tbq.getFsmallClass()==null) {
                continue;
            } else {
                list.add(tbq.getFsmallClass());
            }
        }
        JSONObject lineMap = new JSONObject();
        for (String smallClass : list) {
            List<BigDecimal> lineList = new ArrayList<>();
            for (int i = 0; i < yearMonths.size(); i++) {
                lineList.add(new BigDecimal("0"));
            }
            for (TBusinessQuota tbq : quotaList) {
                if (smallClass.equals(tbq.getFsmallClass())) {
                    for (int j = 0; j < yearMonths.size(); j++) {
                        if (tbq.getFyearMonth().equals(yearMonths.get(j))) {
                            lineList.set(j, tbq.getFvalue());
                        }
                    }
                }
            }
            lineMap.put(smallClass, lineList);
        }
        lineMap.put("yearMonth", yearMonths);
        return lineMap;
    }


    /**
     * 查询乳业应收账款明细数据
     * createUser:江林 to 2017-12-23
     *
     * @param orgCode        单一公司条件查询
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public List<Object> getDairyAmount(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        //根据开始、结束期间获取期间列表
        List<String> yearMonths = DateUtil.getYearMonthArr(beginYearMonth, endYearMonth);
        List<TBusinessQuota> quotaList = quotaData(orgCode, beginYearMonth, endYearMonth, quotaNames);
        BigDecimal newYear = new BigDecimal("0");//年初金额
        BigDecimal finalYear = new BigDecimal("0");//期末金额
        BigDecimal lastMonth = new BigDecimal("0");//上月金额
        BigDecimal lastYearMonth = new BigDecimal("0");//去年同月金额
        BigDecimal ComparedLastMonth = new BigDecimal("0");//上月同比
        BigDecimal ComparedLastYear = new BigDecimal("0");//去年同比
        BigDecimal bd = new BigDecimal("0");//两个月份的值相减

        for (TBusinessQuota quota : quotaList) {
            if (quota.getFyearMonth().equals(yearMonths.get(12)) && quota.getFnameEn().equals("ZHZB-YSZK-WY-QM")) {
                finalYear = finalYear.add(quota.getFvalue());
            }
            if (quota.getFyearMonth().equals(yearMonths.get(11)) && quota.getFnameEn().equals("ZHZB-YSZK-WY-QM")) {
                lastMonth = lastMonth.add(quota.getFvalue());
            }
            if (quota.getFyearMonth().equals(yearMonths.get(0)) && quota.getFnameEn().equals("ZHZB-YSZK-WY-QM")) {
                lastYearMonth = lastYearMonth.add(quota.getFvalue());
            }
            if (quota.getFyearMonth().equals(yearMonths.get(12)) && quota.getFnameEn().equals("ZHZB-YSZK-WY-NC")) {
                newYear = newYear.add(quota.getFvalue());
            }
        }
        if (lastMonth.equals(new BigDecimal("0"))) {
            ComparedLastMonth = new BigDecimal("0");
        } else {
            bd = finalYear.subtract(lastMonth);
            ComparedLastMonth = bd.divide(lastMonth, 2, BigDecimal.ROUND_HALF_UP);
        }
        if (ComparedLastYear.equals(new BigDecimal("0"))) {
            ComparedLastYear = new BigDecimal("0");
        } else {
            bd = finalYear.subtract(ComparedLastYear);
            ComparedLastYear = bd.divide(lastYearMonth, 2, BigDecimal.ROUND_HALF_UP);
        }

        List<Object> resultList = new ArrayList<>();
        resultList.add(newYear);
        resultList.add(finalYear);
        resultList.add(ComparedLastMonth);
        resultList.add(ComparedLastYear);

        return resultList;
    }


    /**
     * 根据指定参数，动态组装结果集，返回Json对象
     * 只适用于对折线图中某一条数据进行查询
     * createUser:李沁壕 to 2017-11-16
     *
     * @param orgCodes       多个公司条件查询
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @param layout_x       定义x轴的值类型 month(按月份排列) or parameter(按查询的参数排列)
     * @param layout_y       定义x轴的值类型 sum(求和) or value(取值)
     * @return
     */
    public JSONObject getJsonObject(List<String> orgCodes, String beginYearMonth, String endYearMonth, List<String> quotaNames, String layout_x, String layout_y) {
        List<TBusinessQuota> quotaList = quotaData(orgCodes, beginYearMonth, endYearMonth, quotaNames);
        return getJsonObjectBase(beginYearMonth, endYearMonth, quotaNames, layout_x, layout_y, quotaList);
    }

    /**
     * 根据指定参数，动态组装结果集，返回Json对象
     * 只适用于对折线图中某一条数据进行查询
     * createUser:李沁壕 to 2017-11-16
     *
     * @param beginYearMonth 开始月份
     * @param endYearMonth   结束月份
     * @param quotaNames     查询参数
     * @param quotaList      结果集
     * @param layout_x       定义x轴的值类型 month(按月份排列) or parameter(按查询的参数排列)
     * @param layout_y       定义x轴的值类型 sum(求和) or value(取值)
     * @return
     */
    private JSONObject getJsonObjectBase(String beginYearMonth, String endYearMonth, List<String> quotaNames, String layout_x, String layout_y, List<TBusinessQuota> quotaList) {
        //根据开始、结束期间获取期间列表
        List<String> yearMonths = DateUtil.getYearArr(beginYearMonth, endYearMonth);
        JSONObject json = new JSONObject();
        int length = 0;
        if (layout_x.equals("parameter")) {//x轴以参数列表排列
            length = quotaNames.size();
        } else if (layout_x.equals("month")) {//x轴以月份列表排列
            json.put("axisx", yearMonths);
            length = yearMonths.size();
        }
        String[] arr_x = new String[length];//X轴节点集
        BigDecimal[] arr_y = new BigDecimal[length];//y轴上值
        for (int i = 0; i < length; i++) {
            arr_y[i] = new BigDecimal(0);
        }
        Boolean flag_y = true;//y轴值数组是否在循环中组装
        for (TBusinessQuota quota : quotaList) {//遍历结果集
            int item = length;//y轴应组装次数
            for (int i = 0; i < item; i++) {//遍历组装折线数列
                Boolean flag_x = false;
                if (layout_x.equals("month")) {//x轴以时间列表排列
                    flag_x = quota.getFyearMonth().equals(yearMonths.get(i));
                } else if (layout_x.equals("parameter")) {//x轴以参数列表排列
                    flag_x = quota.getFnameEn().equals(quotaNames.get(i));
                }
                if (flag_x) {//x轴以参数列表排列
                    if (layout_y.equals("sum")) {//y轴值-累加
                        arr_y[i] = arr_y[i].add(quota.getFvalue().setScale(2, BigDecimal.ROUND_DOWN));
                    } else if (layout_y.equals("value")) {//y轴值-直接取值
                        arr_y[i] = quota.getFvalue().setScale(2, BigDecimal.ROUND_DOWN);
                    }
                    if (flag_y) {//组装y轴值数组
                        if (arr_x[i] == null) {//判断值是否已写入
                            arr_x[i] = quota.getFnameZh().split("-")[1];
                            item--;
                            if (item == 0) {//已组装完毕
                                flag_y = false;
                            }
                        }
                    }
                }
            }
        }
        if (layout_x.equals("parameter")) {//x轴以参数列表排列
            json.put("axisx", arr_x);
        }
        json.put("axisy", arr_y);
        return json;
    }

    /**
     * 综合指标-前一月-总和-数据
     * createUser:李沁壕 to 2017-11-15
     *
     * @param orgCodes        牧场代码
     * @param numb 往前推几个月
     * @param quotaNames     查询的数据类型
     * @return 结果集
     */
    public Map<String, Object> getComprehensiveIndex(int numb,List<String> orgCodes, List<String> quotaNames,String monthOrDay) {
        List<TBusinessQuota> resultList;
        int num = numb;
        double sum = 0;
        Map<String, Object> data = new HashMap<>();
        do {
            String yearMonths = null;
            if(monthOrDay.equals("month")) {
                yearMonths = DateUtil.getBeginEndYearMonth(num)[0];
                num++;
            }else {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                Date date = DateUtil.addDate(new Date(),num);
                yearMonths = dateFormat.format(date);
                num--;
            }
            resultList = quotaData(orgCodes,yearMonths,quotaNames);
            for (String fNameEn : quotaNames) {
                for (TBusinessQuota quota : resultList) {
                    if (quota.getFnameEn().equals(fNameEn)) {
                        sum += quota.getFvalue().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                    }
                }
                if(sum!=0) {
                    data.put("yearMonth",yearMonths);
                }
            }
        }while (sum==0);
        data.put(quotaNames.get(0), (int) sum);
        return data;
    }

    public Map<String,Object> loopQueryData(int beginTime,int endTime,String orgCode, List<String> quotaNames){
        Map<String,Object> lastData = new HashMap<>();
        Map<String,Map<String,BigDecimal>> resultMap;
        String yearMonth="";
        boolean boo = true;
        do {
            String[] beginYearMonths = DateUtil.getBeginEndYearMonth(beginTime);
            String[] endYearMonths = DateUtil.getBeginEndYearMonth(endTime);
            beginTime++;
            endTime++;
            resultMap = revenueRatioQuotaData(orgCode,beginYearMonths[0],endYearMonths[0],quotaNames);
            for(Map<String,BigDecimal> keyMap:resultMap.values()){
                for(String key:keyMap.keySet()){
                    if (key.equals("dysj")) {
                        if (keyMap.get(key).compareTo(BigDecimal.ZERO) == 1) {
                            boo = false;
                            yearMonth = endYearMonths[0];
                        }
                    }
                }
            }
        }while (boo);
        lastData.put("resultMap",resultMap);
        lastData.put("yearMonth",yearMonth);
        return lastData;
    }

    /**
     * 从数据库中查询出所有牧场的营收数据
     * createUser:杨北平 to 2017-11-15
     *
     * @param orgCode       牧场代码
     * @param beginYearMonth 开始时间
     * @param endYearMonth   结束时间
     * @param quotaNames     查询的数据类型
     * @return 结果集
     */
    public Map<String, Map<String,BigDecimal>> revenueRatioQuotaData(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        List<TBusinessQuota> resultList = quotaData(orgCode,beginYearMonth,endYearMonth,quotaNames);
        List<String> orgCodes = new ArrayList<>();
        for(TBusinessQuota quota:resultList){
            if(!orgCodes.contains(quota.getForgCode())&& !quota.getForgCode().equals("ZKRY")){
                orgCodes.add(quota.getForgCode());
            }
        }
        RcCompanyExample example = new RcCompanyExample();
        RcCompanyExample.Criteria criteria = example.createCriteria();
        if(orgCodes.size()>0) {
            criteria.andFnumberIn(orgCodes);
        }
        List<RcCompany> companyList = rcCompanyMapper.selectByExample(example);
        List<String> companyNames = new ArrayList<>();
        for(String orgNumber:orgCodes){
            for(RcCompany company:companyList){
                if (orgNumber.equals(company.getFnumber())){
                    companyNames.add(company.getFname());
                }
            }
        }
        Map<String,Map<String,BigDecimal>> resultMap = new HashMap<>();
        for(int i = 0;i<companyNames.size();i++){
            Map<String,BigDecimal> resultData = new TreeMap<>();
            for(TBusinessQuota quota:resultList){
                if(quota.getForgCode().equals(orgCodes.get(i))){
                    if(quota.getFyearMonth().equals(beginYearMonth)&&quota.getFnameEn().equals(quotaNames.get(0))){
                        resultData.put("sysj",quota.getFvalue());//上月实际
                    }else if(!quota.getFyearMonth().equals(beginYearMonth)&&quota.getFnameEn().equals(quotaNames.get(0))){
                        resultData.put("dysj",quota.getFvalue());//当月实际
                    }else if(!quota.getFyearMonth().equals(beginYearMonth)&&quota.getFnameEn().equals(quotaNames.get(1))){
                        resultData.put("bqsn",quota.getFvalue());//本期上年
                    }
                }
            }
            resultMap.put(companyNames.get(i),resultData);
        }
        return resultMap;
    }

    public JSONObject RatioQuotaDatas(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        JSONObject json = new JSONObject();
        String yearMonth = null;
        json =  revenueRatioQuotaDatas(orgCode,beginYearMonth,endYearMonth,quotaNames);
        int a = json.size();
        yearMonth = endYearMonth;
        int result = 0;
        BigDecimal b = BigDecimal.ZERO;
        if(a>0){
             result = (((Map<String,Object>)(json.get("天友乳业"))).size());
             b = (BigDecimal)((Map<String,Object>)(json.get("天友乳业"))).get("dysj");
        }
        while (result<4||a<7||b.equals(BigDecimal.ZERO)) {
            beginYearMonth = DateUtil.getBeginMonth(beginYearMonth, 1)[0];
            endYearMonth = DateUtil.getBeginMonth(endYearMonth, 1)[0];
            json = revenueRatioQuotaDatas(orgCode, beginYearMonth, endYearMonth, quotaNames);
            a = json.size();
            yearMonth = endYearMonth;
            if(a>0){
                result = (((Map<String,Object>)(json.get("天友乳业"))).size());
                b = (BigDecimal)((Map<String,Object>)(json.get("天友乳业"))).get("dysj");
            }
        }
        json.put("yearMonth",yearMonth);
        return json;
    }

    /**
     * 从数据库中查询出所有牧场的营收数据
     * createUser:杨北平 to 2017-11-15
     *
     * @param orgCode       牧场代码
     * @param beginYearMonth 开始时间
     * @param endYearMonth   结束时间
     * @param quotaNames     查询的数据类型
     * @return 结果集
     */
    public JSONObject revenueRatioQuotaDatas(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        List<TBusinessQuota> resultList = quotaData(orgCode,beginYearMonth,endYearMonth,quotaNames);
        List<String> orgCodes = new ArrayList<>();
        for(TBusinessQuota quota:resultList){
            if(!orgCodes.contains(quota.getForgCode())&& !quota.getForgCode().equals("ZKRY")){
                orgCodes.add(quota.getForgCode());
            }
        }
        RcCompanyExample example = new RcCompanyExample();
        RcCompanyExample.Criteria criteria = example.createCriteria();
        if(orgCodes.size()>0) {
            criteria.andFnumberIn(orgCodes);
        }
        List<RcCompany> companyList = rcCompanyMapper.selectByExample(example);
        List<String> companyNames = new ArrayList<>();
        for(String orgNumber:orgCodes){
            for(RcCompany company:companyList){
                if (orgNumber.equals(company.getFnumber())){
                    companyNames.add(company.getFname());
                }
            }
        }
//        Map<String,Map<String,BigDecimal>> resultMap = new HashMap<>();
        JSONObject json = new JSONObject();
        for(int i = 0;i<companyNames.size();i++){
            Map<String,BigDecimal> resultData = new TreeMap<>();
            for(TBusinessQuota quota:resultList){
                if(quota.getForgCode().equals(orgCodes.get(i))){
                    if(quota.getFyearMonth().equals(beginYearMonth)&&quota.getFnameEn().equals(quotaNames.get(0))){
                        resultData.put("sysj",quota.getFvalue());//上月实际
                    }else if(!quota.getFyearMonth().equals(beginYearMonth)&&quota.getFnameEn().equals(quotaNames.get(0))){
                        resultData.put("dysj",quota.getFvalue());//当月实际
                    }else if(!quota.getFyearMonth().equals(beginYearMonth)&&quota.getFnameEn().equals(quotaNames.get(1))){
                        resultData.put("bqsn",quota.getFvalue());//本期上年
                    }else if(!quota.getFyearMonth().equals(beginYearMonth)&&quota.getFnameEn().equals(quotaNames.get(2))){
                        resultData.put("byys",quota.getFvalue());//本月预算
                    }
                }
            }
            json.put(companyNames.get(i),resultData);
        }
        return json;
    }

    /**
     * 从数据库中查询出所有牧场的营收数据
     * createUser:杨北平 to 2017-11-15
     *
     * @param orgCode       牧场代码
     * @param quotaNames     查询的数据类型
     * @return 结果集
     */
    public JSONObject revenuequarter(String orgCode,List<String> yearMonths, List<String> quotaNames) {
        List<TBusinessQuota> resultList = quarter(orgCode,yearMonths,quotaNames);
        List<String> orgCodes = new ArrayList<>();
        for(TBusinessQuota quota:resultList){
            if(!orgCodes.contains(quota.getForgCode())&& !quota.getForgCode().equals("ZKRY")){
                orgCodes.add(quota.getForgCode());
            }
        }
        RcCompanyExample example = new RcCompanyExample();
        RcCompanyExample.Criteria criteria = example.createCriteria();
        if(orgCodes.size()>0) {
            criteria.andFnumberIn(orgCodes);
        }
        List<RcCompany> companyList = rcCompanyMapper.selectByExample(example);
        List<String> companyNames = new ArrayList<>();
        for(String orgNumber:orgCodes){
            for(RcCompany company:companyList){
                if (orgNumber.equals(company.getFnumber())){
                    companyNames.add(company.getFname());
                }
            }
        }
//        Map<String,Map<String,BigDecimal>> resultMap = new HashMap<>();
        JSONObject json = new JSONObject();
        for(int i = 0;i<companyNames.size();i++){
            Map<String,BigDecimal> resultData = new TreeMap<>();
            for(TBusinessQuota quota:resultList){
                if(quota.getForgCode().equals(orgCodes.get(i))){
                    if(quota.getFyearMonth().equals(yearMonths.get(0))&&quota.getFnameEn().equals(quotaNames.get(0))){
                        resultData.put("sysj",quota.getFvalue());//上月实际
                    }else if(!quota.getFyearMonth().equals(yearMonths.get(0))&&quota.getFnameEn().equals(quotaNames.get(0))){
                        resultData.put("dysj",quota.getFvalue());//当月实际
                    }else if(!quota.getFyearMonth().equals(yearMonths.get(0))&&quota.getFnameEn().equals(quotaNames.get(1))){
                        resultData.put("bqsn",quota.getFvalue());//本期上年
                    }else if(!quota.getFyearMonth().equals(yearMonths.get(0))&&quota.getFnameEn().equals(quotaNames.get(2))){
                        resultData.put("byys",quota.getFvalue());//本月预算
                    }
                }
            }
            json.put(companyNames.get(i),resultData);
        }
        return json;
    }

    public JSONObject revenueRatios(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        List<TBusinessQuota> resultList = quotaData(orgCode,beginYearMonth,endYearMonth,quotaNames);
        List<String> orgCodes = new ArrayList<>();
        for(TBusinessQuota quota:resultList){
            if(!orgCodes.contains(quota.getForgCode())&& !quota.getForgCode().equals("ZKRY")){
                orgCodes.add(quota.getForgCode());
            }
        }
        RcCompanyExample example = new RcCompanyExample();
        RcCompanyExample.Criteria criteria = example.createCriteria();
        if(orgCodes.size()>0) {
            criteria.andFnumberIn(orgCodes);
        }
        List<RcCompany> companyList = rcCompanyMapper.selectByExample(example);
        List<String> companyNames = new ArrayList<>();
        for(String orgNumber:orgCodes){
            for(RcCompany company:companyList){
                if (orgNumber.equals(company.getFnumber())){
                    companyNames.add(company.getFname());
                }
            }
        }
//        Map<String,Map<String,BigDecimal>> resultMap = new HashMap<>();
        JSONObject json = new JSONObject();
        for(int i = 0;i<companyNames.size();i++){
            Map<String,BigDecimal> resultData = new TreeMap<>();
            BigDecimal a = BigDecimal.ZERO;
            BigDecimal b = BigDecimal.ZERO;
            BigDecimal c = BigDecimal.ZERO;
            BigDecimal d = BigDecimal.ZERO;
            for(TBusinessQuota quota:resultList){
                if(quota.getForgCode().equals(orgCodes.get(i))){
                    if(quota.getFyearMonth().contains(beginYearMonth)&&!quota.getFyearMonth().contains("Q")&&quota.getFnameEn().equals(quotaNames.get(0))){
                        a = a.add(quota.getFvalue());

                    }else if(!quota.getFyearMonth().contains(beginYearMonth)&&!quota.getFyearMonth().contains("Q")&&quota.getFnameEn().equals(quotaNames.get(0))){
                        b = b.add(quota.getFvalue());

                    }else if(!quota.getFyearMonth().contains(beginYearMonth)&&!quota.getFyearMonth().contains("Q")&&quota.getFnameEn().equals(quotaNames.get(1))){
                        c = c.add(quota.getFvalue());

                    }else if(!quota.getFyearMonth().contains(beginYearMonth)&&!quota.getFyearMonth().contains("Q")&&quota.getFnameEn().equals(quotaNames.get(2))){
                        d = d.add(quota.getFvalue());
                    }
                    resultData.put("sysj",a);//上年实际
                    resultData.put("dysj",b);//当年实际
                    resultData.put("bqsn",c);//本期上年
                    resultData.put("byys",d);//本年预算
                }

            }
            json.put(companyNames.get(i),resultData);
        }
        return json;
    }

    /**
     * 从数据库中查询出所有牧场的营收数据
     * createUser:杨北平 to 2017-12-23
     *
     * @param orgCodes       牧场代码
     * @param beginYearMonth 开始时间
     * @param endYearMonth   结束时间
     * @param quotaNames     查询的数据类型
     * @return 结果集
     */
    public Map<String, Object> revenueQuotaData(String orgCodes, String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        //查询条件封装
        TBusinessQuotaExample example = new TBusinessQuotaExample();
        //根据开始、结束期间获取期间列表
        List<String> yearMonths = DateUtil.getYearMonthArr(beginYearMonth, endYearMonth);
        //提取去年同月、上一月、当月的月份
        List<String> yearMonth = new ArrayList<>();
        yearMonth.add(yearMonths.get(0));
        yearMonth.add(yearMonths.get(11));
        yearMonth.add(yearMonths.get(12));
        TBusinessQuotaExample.Criteria criteria = example.createCriteria();
        if (orgCodes != null) {
            criteria.andForgCodeEqualTo(orgCodes);
        }
        criteria.andFyearMonthIn(yearMonth);
        criteria.andFnameEnIn(quotaNames);
        example.setOrderByClause("fyear_month asc");//排序字段填写数据库表中的字段名
        List<TBusinessQuota> quotaList = businessQuotaMapper.selectByExample(example);
        Map<String, Object> resultMap = new HashMap<>();
        BigDecimal nowMonthData = BigDecimal.ZERO;
        for (int i = 0; i < quotaNames.size(); i++) {
            for (TBusinessQuota quota : quotaList) {
                if (quotaNames.get(i).equals(quota.getFnameEn()) && yearMonths.get(12).equals(quota.getFyearMonth())) {
                    resultMap.put(quotaNames.get(i), quota.getFvalue());
                    if (quotaNames.get(0).equals(quota.getFnameEn())) {
                        nowMonthData = quota.getFvalue();
                    }

                }
            }
        }
        for (TBusinessQuota quota : quotaList) {
            //上月环比
            if (quotaNames.get(0).equals(quota.getFnameEn()) && yearMonth.get(1).equals(quota.getFyearMonth())) {
                resultMap.put("SYHB", (nowMonthData.subtract(quota.getFvalue())).divide(quota.getFvalue(), 4, BigDecimal.ROUND_HALF_UP));
            }
            //去年同比
            if (quotaNames.get(0).equals(quota.getFnameEn()) && yearMonth.get(0).equals(quota.getFyearMonth())) {
                resultMap.put("QNTB", (nowMonthData.subtract(quota.getFvalue())).divide(quota.getFvalue(), 4, BigDecimal.ROUND_HALF_UP));
            }
        }
        resultMap.put("yearMonth", yearMonth);
        return resultMap;
    }
    @Override
    public JSONObject unitCostChart(String orgCode, String beginYearMonth, List<String> quotaNames) {
        JSONObject resultList = unitCostList(orgCode,beginYearMonth,quotaNames);
        BigDecimal result = (BigDecimal)(((Map<String,Object>)resultList.get("totalList")).get("allSum"));
        while(result.equals(BigDecimal.ZERO)){
            beginYearMonth = DateUtil.getBeginMonth(beginYearMonth, 1)[0];
            resultList = unitCostList(orgCode,beginYearMonth,quotaNames);
            result = (BigDecimal)(((Map<String,Object>)resultList.get("totalList")).get("allSum"));
        }
        resultList.put("beginTime",beginYearMonth);
        return resultList;
    }
    /**
     * 单位完全成本明细
     * createUser:杨北平 to 2017-11-15
     *
     * @param orgCode        牧场代码
     * @param beginYearMonth 开始时间
     * @param quotaNames     查询的数据类型
     * @return 结果集
     */
    @Override
    public JSONObject unitCostList(String orgCode, String beginYearMonth, List<String> quotaNames) {
        //查询条件封装
        TBusinessQuotaExample example = new TBusinessQuotaExample();
        TBusinessQuotaExample.Criteria criteria = example.createCriteria();
        criteria.andForgCodeEqualTo(orgCode);
        criteria.andFyearMonthEqualTo(beginYearMonth);
        criteria.andFnameEnIn(quotaNames);
        example.setOrderByClause("fyear_month asc");//排序字段填写数据库表中的字段名
        List<TBusinessQuota> quotaList = businessQuotaMapper.selectByExample(example);
        JSONObject json = new JSONObject();
        List<String> smallClasses = new ArrayList<>();//得到所有的smallClass
        for (TBusinessQuota quota : quotaList) {
            if (smallClasses.size() == 0 || smallClasses == null) {
                smallClasses.add(quota.getFsmallClass());
            } else {
                for (String smallClass : smallClasses) {
                    if (quota.getFsmallClass() != null) {
                        if (quota.getFsmallClass().equals(smallClass)) {
                            continue;
                        }
                        smallClasses.add(quota.getFsmallClass());
                    }
                }
            }
        }
        Map<String, Object> totalList = new HashMap<>();
        BigDecimal allSum = BigDecimal.ZERO;
        for (String quotaName : quotaNames) {
            BigDecimal sum = BigDecimal.ZERO;
            for (TBusinessQuota quota : quotaList) {
                if (quotaName.equals(quota.getFnameEn())) {
                    allSum = allSum.add(quota.getFvalue());
                    sum = sum.add(quota.getFvalue());
                }
            }
            totalList.put(quotaName, sum);
        }
        totalList.put("allSum", allSum);
        Map<String, Object> summaryList = new HashMap<>();
        for (String smallName : smallClasses) {
            Map<String, Object> singleList = new HashMap<>();
            for (TBusinessQuota quota : quotaList) {
                if (quota.getFsmallClass() != null) {
                    if (smallName.equals(quota.getFsmallClass())) {
                        singleList.put(quota.getFnameEn(), quota);
                    }
                }
            }
            summaryList.put(smallName, singleList);
        }
        json.put("totalList", totalList);
        json.put("summaryList", summaryList);
        return json;
    }


    /**
     * 乳制品销量明细-年度营收趋势图-charts数据
     * createUser:李沁壕 to 2017-11-15
     *
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public JSONObject getRevenueTrendsJSON(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames, String layout_x, String layout_y) {
        return getJsonObject(orgCode, beginYearMonth, endYearMonth, quotaNames, layout_x, layout_y);
    }


    public Map<String, Object> productSales(List<String> orgCodes, String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        Map<String, Object> resultMap = productSalesVolume(orgCodes,beginYearMonth,endYearMonth, quotaNames);
        while (resultMap.size()<=0) {
            beginYearMonth = DateUtil.getBeginMonth(beginYearMonth, 1)[0];
            endYearMonth = DateUtil.getBeginMonth(endYearMonth, 1)[0];
            resultMap = productSalesVolume(orgCodes, beginYearMonth, endYearMonth, quotaNames);
        }
        resultMap.put("yearMonth",endYearMonth);
        return resultMap;
    }
    /**
     * 查询产品销量
     * createUser:杨北平 to 2017-11-17
     *
     * @param orgCodes       牧场代码
     * @param beginYearMonth 开始时间
     * @param endYearMonth   结束时间
     * @param quotaNames     查询的数据类型
     * @return 结果集
     */
    public Map<String, Object> productSalesVolume(List<String> orgCodes, String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        //查询销售量
        Map<String, Object> resultMap = new HashMap<>();
        TBusinessQuotaExample example = new TBusinessQuotaExample();
        TBusinessQuotaExample.Criteria criteria = example.createCriteria();
        criteria.andForgCodeIn(orgCodes);
        criteria.andFyearMonthBetween(beginYearMonth, endYearMonth);
        criteria.andFnameEnIn(quotaNames);
        example.setOrderByClause("fyear_month desc,fvalue desc");//排序字段填写数据库表中的字段名
        List<TBusinessQuota> quotaList = businessQuotaMapper.selectByExample(example);
        List<String> fiveMax = new ArrayList<>();
        for (int j = 0; j < 5; j++) {
            if (quotaList.size() > 0 && !beginYearMonth.equals(quotaList.get(j).getFyearMonth())) {
                fiveMax.add(quotaList.get(j).getFsmallClass());
            }
        }
        if(orgCodes.get(0).equals("HSMRY")){
            TBusinessQuotaExample example1 = new TBusinessQuotaExample();
            TBusinessQuotaExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andFyearMonthEqualTo(beginYearMonth);
            criteria1.andForgCodeEqualTo(orgCodes.get(0));
            List<TBusinessQuota> tFinanceMains = businessQuotaMapper.selectByExample(example1);
            TBusinessQuotaExample example2 = new TBusinessQuotaExample();
            TBusinessQuotaExample.Criteria criteria2 = example2.createCriteria();
            if (tFinanceMains.size() > 0 && fiveMax.size() > 0) {
                criteria2.andForgCodeEqualTo(orgCodes.get(0));
                criteria2.andFsmallClassIn(fiveMax);
                criteria2.andFnameEnIn(quotaNames);
                criteria2.andFyearMonthEqualTo(beginYearMonth);
                example2.setOrderByClause("fsmall_class desc");
                List<TBusinessQuota> result = businessQuotaMapper.selectByExample(example2);
                for (int j = 0; j < fiveMax.size(); j++) {
                    List<Object> rowList = new ArrayList<>();
                    for (int i = 0; i < fiveMax.size(); i++) {
                        if (fiveMax.get(j).equals(quotaList.get(i).getFsmallClass()) && !beginYearMonth.equals(quotaList.get(i).getFyearMonth())) {
                            rowList.add(fiveMax.get(j));
                            rowList.add(quotaList.get(i).getFvalue());
                        }
                    }
                    for (TBusinessQuota finance : result) {
                        if (fiveMax.get(j).equals(finance.getFsmallClass())) {
                            rowList.add(finance.getFvalue());
                        }
                    }
                    resultMap.put(String.valueOf(j + 1), rowList);
                }
            }
        }else {
            TFinanceMainExample example2 = new TFinanceMainExample();
            TFinanceMainExample.Criteria mainCriteria = example2.createCriteria();
            mainCriteria.andFyearMonthEqualTo(beginYearMonth);
            mainCriteria.andFcompanyNumberEqualTo(orgCodes.get(0));
            List<TFinanceMain> tFinanceMains = this.tFinaceMainDao.selectByExample(example2);
            TFinanceMainBusinessListMExample example1 = new TFinanceMainBusinessListMExample();
            TFinanceMainBusinessListMExample.Criteria milkCriteria = example1.createCriteria();
            if (tFinanceMains.size() > 0 && fiveMax.size() > 0) {
                milkCriteria.andFheadIdEqualTo(tFinanceMains.get(0).getFid());
                milkCriteria.andFprojectIn(fiveMax);
                example1.setOrderByClause("fproject desc");
                List<TFinanceMainBusinessListM> result = tfinancemainbusinesslistmMapper.selectByExample(example1);
                for (int j = 0; j < fiveMax.size(); j++) {
                    List<Object> rowList = new ArrayList<>();
                    for (int i = 0; i < fiveMax.size(); i++) {
                        if (fiveMax.get(j).equals(quotaList.get(i).getFsmallClass()) && !beginYearMonth.equals(quotaList.get(i).getFyearMonth())) {
                            rowList.add(fiveMax.get(j));
                            rowList.add(quotaList.get(i).getFvalue());
                        }
                    }
                    for (TFinanceMainBusinessListM finance : result) {
                        if (fiveMax.get(j).equals(finance.getFproject())) {
                            rowList.add(finance.getSalesVolume());
                        }
                    }
                    resultMap.put(String.valueOf(j + 1), rowList);
                }
            }
        }

        return resultMap;
    }
    /**
     * 查询产品销量
     * createUser:杨北平 to 2017-11-17
     *
     * @param orgCodes       牧场代码
     * @param beginYearMonth 开始时间
     * @param endYearMonth   结束时间
     * @param quotaNames     查询的数据类型
     * @return 结果集
     */
    public JSONObject productFiveSale(List<String> orgCodes, String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        //查询销售量
        JSONObject resultMap = new JSONObject();
        TBusinessQuotaExample example = new TBusinessQuotaExample();
        TBusinessQuotaExample.Criteria criteria = example.createCriteria();
        criteria.andForgCodeIn(orgCodes);
        criteria.andFyearMonthBetween(beginYearMonth, endYearMonth);
        criteria.andFnameEnIn(quotaNames);
        example.setOrderByClause("fyear_month desc,fvalue desc");//排序字段填写数据库表中的字段名
        List<TBusinessQuota> quotaList = businessQuotaMapper.selectByExample(example);
        List<String> fiveMax = new ArrayList<>();
        for (int j = 0; j < 5; j++) {
            if (quotaList.size() > 0 && !beginYearMonth.equals(quotaList.get(j).getFyearMonth())) {
                fiveMax.add(quotaList.get(j).getFsmallClass());
            }
        }
        if(orgCodes.get(0).equals("HSMRY")){
            TBusinessQuotaExample example1 = new TBusinessQuotaExample();
            TBusinessQuotaExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andFyearMonthEqualTo(beginYearMonth);
            criteria1.andForgCodeEqualTo(orgCodes.get(0));
            List<TBusinessQuota> tFinanceMains = businessQuotaMapper.selectByExample(example1);
            TBusinessQuotaExample example2 = new TBusinessQuotaExample();
            TBusinessQuotaExample.Criteria criteria2 = example2.createCriteria();
            if (tFinanceMains.size() > 0 && fiveMax.size() > 0) {
                criteria2.andForgCodeEqualTo(orgCodes.get(0));
                criteria2.andFsmallClassIn(fiveMax);
                criteria2.andFnameEnIn(quotaNames);
                criteria2.andFyearMonthEqualTo(beginYearMonth);
                example2.setOrderByClause("fsmall_class desc");
                List<TBusinessQuota> result = businessQuotaMapper.selectByExample(example2);
                for (int j = 0; j < fiveMax.size(); j++) {
                    List<Object> rowList = new ArrayList<>();
                    for (int i = 0; i < fiveMax.size(); i++) {
                        if (fiveMax.get(j).equals(quotaList.get(i).getFsmallClass()) && !beginYearMonth.equals(quotaList.get(i).getFyearMonth())) {
                            rowList.add(fiveMax.get(j));
                            rowList.add(quotaList.get(i).getFvalue());
                        }
                    }
                    for (TBusinessQuota finance : result) {
                        if (fiveMax.get(j).equals(finance.getFsmallClass())) {
                            rowList.add(finance.getFvalue());
                        }
                    }
                    resultMap.put(String.valueOf(j + 1), rowList);
                }
            }
        }else {
            TFinanceMainExample example2 = new TFinanceMainExample();
            TFinanceMainExample.Criteria mainCriteria = example2.createCriteria();
            mainCriteria.andFyearMonthEqualTo(beginYearMonth);
            mainCriteria.andFcompanyNumberEqualTo(orgCodes.get(0));
            List<TFinanceMain> tFinanceMains = this.tFinaceMainDao.selectByExample(example2);
            TFinanceMainBusinessListMExample example1 = new TFinanceMainBusinessListMExample();
            TFinanceMainBusinessListMExample.Criteria milkCriteria = example1.createCriteria();
            if (tFinanceMains.size() > 0 && fiveMax.size() > 0) {
                milkCriteria.andFheadIdEqualTo(tFinanceMains.get(0).getFid());
                milkCriteria.andFprojectIn(fiveMax);
                example1.setOrderByClause("fproject desc");
                List<TFinanceMainBusinessListM> result = tfinancemainbusinesslistmMapper.selectByExample(example1);
                for (int j = 0; j < fiveMax.size(); j++) {
                    List<Object> rowList = new ArrayList<>();
                    for (int i = 0; i < fiveMax.size(); i++) {
                        if (fiveMax.get(j).equals(quotaList.get(i).getFsmallClass()) && !beginYearMonth.equals(quotaList.get(i).getFyearMonth())) {
                            rowList.add(fiveMax.get(j));
                            rowList.add(quotaList.get(i).getFvalue());
                        }
                    }
                    for (TFinanceMainBusinessListM finance : result) {
                        if (fiveMax.get(j).equals(finance.getFproject())) {
                            rowList.add(finance.getSalesVolume());
                        }
                    }
                    resultMap.put(String.valueOf(j + 1), rowList);
                }
            }
        }

        return resultMap;
    }
    /**
     * 年度成本走势图-charts数据
     * createUser:杨北平 to 2017-11-17
     *
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public JSONObject costTrendAjax(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        //根据开始、结束期间获取期间列表
        List<String> yearMonths = DateUtil.getYearArr(beginYearMonth, endYearMonth);
        List<TBusinessQuota> quotaList = quotaData(orgCode, beginYearMonth, endYearMonth, quotaNames);
        JSONObject json = new JSONObject();
        json.put("yearMonths", yearMonths);
        for (String fname : quotaNames) {
            List<TBusinessQuota> resultList = new ArrayList<>();

            TBusinessQuota item;
            for (int i = 0; i < yearMonths.size(); i++) {
                item = new TBusinessQuota();
                item.setFnameEn(fname);
                item.setFvalue(new BigDecimal("0"));
                item.setFyearMonth(yearMonths.get(i));
                resultList.add(item);
            }

            for (TBusinessQuota quota : quotaList) {
                if (fname.equals(quota.getFnameEn())&&quota.getFyearMonth().contains("Q")) {
                    resultList.set(yearMonths.indexOf(quota.getFyearMonth()), quota);
                }
            }
            json.put(fname, resultList);
        }
        return json;
    }

    public List<Long> queryHeadId(String companyNumber, String yearMonth) {
        TFinanceMainExample example = new TFinanceMainExample();
        TFinanceMainExample.Criteria criteria = example.createCriteria();
        criteria.andFyearMonthEqualTo(yearMonth);
        if (!companyNumber.isEmpty() && companyNumber != null) {
            criteria.andFcompanyNumberEqualTo(companyNumber);
        }
        List<TFinanceMain> tFinanceMains = this.tFinaceMainDao.selectByExample(example);
        List<Long> fheadIds = new ArrayList<>();
        for (TFinanceMain main : tFinanceMains) {
            fheadIds.add(main.getFid());
        }
        if (fheadIds.size() == 0) {
            fheadIds.add(0l);
        }
        return fheadIds;
    }

    /**
     * 查询主营业务收支汇总表
     * createUser 杨北平 to 2017-11-19
     *
     * @param yearMonth 查询月份
     * @param rowNum    数据库Frow_index字段
     */
    public JSONObject searchSummaryData(String companyNumber, String yearMonth, List<Integer> rowNum) {
        List<Long> fheadIds = queryHeadId(companyNumber, yearMonth);

        Map<String, Object> propertyMap = new HashMap<>();
        propertyMap.put("fheadIds", fheadIds);
        propertyMap.put("rowNum", rowNum);
        List<FinanceMainBusinessMonth> resultList = this.balanceMainBusinessMonthDao.queryByPropertyAndRowIndex(propertyMap);
        List<String> fprojects = new ArrayList<>();
        JSONObject json = new JSONObject();
        if (resultList.size() == 0) {
            return json;
        }
        for (Integer rowIndex : rowNum) {
            List<Object> oneLine = new ArrayList<>();
            for (int i = 0; i < 14; i++) {
                oneLine.add(BigDecimal.ZERO);
            }
            for (FinanceMainBusinessMonth main : resultList) {
                if (rowIndex == main.getFrow_index()) {
                    if(companyNumber.contains("RY")) {
                        oneLine.set(0, main.getFrow_num());
                    }else {
                        oneLine.set(0, main.getFproject());
                    }
                    oneLine.set(1, main.getSale_budget().add((BigDecimal) oneLine.get(1)));
                    oneLine.set(2, main.getSale_actual().add((BigDecimal) oneLine.get(2)));
                    oneLine.set(3, main.getIncome_budget().add((BigDecimal) oneLine.get(3)));
                    oneLine.set(4, main.getIncome_actual().add((BigDecimal) oneLine.get(4)));
                    oneLine.set(5, main.getIncome_total().add((BigDecimal) oneLine.get(5)));
                    oneLine.set(6, main.getCost_budget().add((BigDecimal) oneLine.get(6)));
                    oneLine.set(7, main.getCost_actual().add((BigDecimal) oneLine.get(7)));
                    oneLine.set(8, main.getCost_total().add((BigDecimal) oneLine.get(8)));
                    oneLine.set(9, main.getSale_profit_budget().add((BigDecimal) oneLine.get(9)));
                    oneLine.set(10, main.getSale_profit_actual().add((BigDecimal) oneLine.get(10)));
                    oneLine.set(11, main.getSale_profit_budget_ratio().add((BigDecimal) oneLine.get(11)));
                    oneLine.set(12, main.getSale_profit_actual_ratio().add((BigDecimal) oneLine.get(12)));
                    oneLine.set(13, main.getSale_total().add((BigDecimal) oneLine.get(13)));
                }
            }
            json.put(rowIndex.toString(), oneLine);
        }
        return json;
    }

    /**
     * 单位成本数据
     * createUser 杨北平 to 2017-11-19
     *
     * @param yearMonth 查询月份
     * @param rowNum    数据库Frow_index字段
     */
    public JSONObject searchCostData(String companyNumber, String yearMonth, List<Integer> rowNum) {
        List<Long> fheadIds = queryHeadId(companyNumber, yearMonth);
        Map<String, Object> propertyMap = new HashMap<>();
        propertyMap.put("fheadIds", fheadIds);
        propertyMap.put("rowNum", rowNum);
        TFinanceProductCostThisExample example = new TFinanceProductCostThisExample();
        TFinanceProductCostThisExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdIn(fheadIds);
        criteria.andFrowIndexIn(rowNum);
        List<TFinanceProductCostThis> resultList = tFinanceProductCostThisMapper.selectByExample(example);
        List<String> fprojects = new ArrayList<>();
        JSONObject json = new JSONObject();
        if (resultList.size() == 0) {
            return json;
        }
        for (Integer rowIndex : rowNum) {
            List<Object> oneLine = new ArrayList<>();
            for (int i = 0; i < 11; i++) {
                oneLine.add(BigDecimal.ZERO);
            }
            for (TFinanceProductCostThis main : resultList) {
                if (rowIndex == main.getFrowIndex()) {
                    switch (main.getFrowIndex()) {
                        case 7:
                            oneLine.set(0, "低温奶");
                            break;
                        case 15:
                            oneLine.set(0, "常温奶");
                            break;
                        default:
                            oneLine.set(0, main.getFprojectName());
                            break;
                    }
                    oneLine.set(1, main.getFyield().add((BigDecimal) oneLine.get(1)));
                    oneLine.set(2, main.getFmaterialBudget().add((BigDecimal) oneLine.get(2)));
                    oneLine.set(3, main.getFmaterialActual().add((BigDecimal) oneLine.get(3)));
                    oneLine.set(4, main.getFlaborCostBudget().add((BigDecimal) oneLine.get(4)));
                    oneLine.set(5, main.getFlaborCostActual().add((BigDecimal) oneLine.get(5)));
                    oneLine.set(6, main.getFmanufCostBudget().add((BigDecimal) oneLine.get(6)));
                    oneLine.set(7, main.getFmanufCostActual().add((BigDecimal) oneLine.get(7)));
                    oneLine.set(8, main.getFproductionCostBudget().add((BigDecimal) oneLine.get(8)));
                    oneLine.set(9, main.getFproductionCostActual().add((BigDecimal) oneLine.get(9)));
                    oneLine.set(10, main.getFproductionCostTotal().add((BigDecimal) oneLine.get(10)));
                }
            }
            json.put(rowIndex.toString(), oneLine);
        }
        return json;
    }

    /**
     * 查询华山牧乳业的销售量与销售额
     *
     * @param beginYearMonth
     * @param endYearMonth
     * @return
     */
    @Override
    public JSONObject queryHSMRY(String beginYearMonth, String endYearMonth) {
        //根据开始、结束期间获取期间列表
        List<String> yearMonths = DateUtil.getYearMonthArr(beginYearMonth, endYearMonth);
        HSMRYSALEREPORTExample example = new HSMRYSALEREPORTExample();
        HSMRYSALEREPORTExample.Criteria criteria = example.createCriteria();
        criteria.andFYEAR_MONTHBetween(beginYearMonth, endYearMonth);
        List<HSMRYSALEREPORT> resultList = this.hsmrysalereportMapper.selectByExample(example);
        List<BigDecimal> dwnXsl = new ArrayList<>();
        List<BigDecimal> cwnXsl = new ArrayList<>();
        List<BigDecimal> dwnXse = new ArrayList<>();
        List<BigDecimal> cwnXse = new ArrayList<>();
        for (String yearMonth : yearMonths) {
            BigDecimal dwnXslMonthData = BigDecimal.ZERO;
            BigDecimal dwnXseMonthData = BigDecimal.ZERO;
            BigDecimal cwnXslMonthData = BigDecimal.ZERO;
            BigDecimal cwnXseMonthData = BigDecimal.ZERO;
            for (HSMRYSALEREPORT hs : resultList) {
                if (yearMonth.equals(hs.getFYEAR_MONTH())) {
                    if (hs.getFPRODUCT_TYPE().equals("低温商业奶")) {
                        if (hs.getFWEIGHT() != null) {
                            dwnXslMonthData = dwnXslMonthData.add(hs.getFWEIGHT());
                        }
                        if (hs.getFAMOUNT() != null) {
                            dwnXseMonthData = dwnXseMonthData.add(hs.getFAMOUNT());
                        }
                    } else {
                        if (hs.getFWEIGHT() != null) {
                            cwnXslMonthData = cwnXslMonthData.add(hs.getFWEIGHT());
                        }
                        if (hs.getFAMOUNT() != null) {
                            cwnXseMonthData = cwnXseMonthData.add(hs.getFAMOUNT());
                        }
                    }
                }
            }
            dwnXsl.add(dwnXslMonthData);
            dwnXse.add(dwnXseMonthData);
            cwnXsl.add(cwnXslMonthData);
            cwnXse.add(cwnXseMonthData);
        }
        JSONObject json = new JSONObject();
        json.put("yearMonths", yearMonths);
        json.put("dwnXsl", dwnXsl);
        json.put("dwnXse", dwnXse);
        json.put("cwnXsl", cwnXsl);
        json.put("cwnXse", cwnXse);
        return json;
    }

    /**
     * 乳业营业收入明细数据
     * @param company
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    @Override
    public List<Object> queryReimbursement(String company, String beginYearMonth, String endYearMonth, List<String> quotaNames) {

        List<Object> list = queryReimbursementRate(company,beginYearMonth,endYearMonth,quotaNames);
        Object dataLiat = list.get(0);
        BigDecimal result = new BigDecimal(0);
        result = ((List<BigDecimal>)dataLiat).get(0);
        while(result.equals(BigDecimal.ZERO)){
            beginYearMonth = DateUtil.getBeginMonth(beginYearMonth, 1)[0];
            endYearMonth = DateUtil.getBeginMonth(endYearMonth, 1)[0];
            list = queryReimbursementRate(company,beginYearMonth,endYearMonth,quotaNames);
            Object dataLiats = list.get(0);
            result = ((List<BigDecimal>)dataLiats).get(0);
        }
        return list;
}
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
    @Override
    public List<Object> queryReimbursementRate(String company, String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        //根据开始、结束期间获取期间列表
        List<String> yearMonths = DateUtil.getYearMonthArr(beginYearMonth, endYearMonth);

        List<TBusinessQuota> quotaList = quotaData(company, beginYearMonth, endYearMonth, quotaNames);
        List<Object> dataList = new ArrayList<>();
        for (int i = yearMonths.size()-2; i >= 0; i--) {
            List<BigDecimal> resultList = new ArrayList<>();
            for (int j = 0; j <= quotaNames.size(); j++) {
                resultList.add(new BigDecimal(0));
            }

            for (int k = 0; k < quotaNames.size(); k++) {
                for (TBusinessQuota quota : quotaList) {
                    if (quotaNames.get(k).equals(quota.getFnameEn()) && yearMonths.get(i+1).equals(quota.getFyearMonth())) {
                        resultList.set(k, quota.getFvalue().add(resultList.get(k)));
                    }
                }
            }
            for (TBusinessQuota quota : quotaList) {
                if (quotaNames.get(0).equals(quota.getFnameEn()) && yearMonths.get(i).equals(quota.getFyearMonth())) {
                    resultList.set(quotaNames.size(), quota.getFvalue().add(resultList.get(quotaNames.size())));
                }
            }
            dataList.add(resultList);
        }
        dataList.add(yearMonths);
        return dataList;
    }

    /**
     * create User 杨北平  2018-1-4
     * 查询财务评价指标对比数据
     * @param yearMonth
     * @return
     */
    @Override
    public JSONObject queryFinancialEvaluationIndex(String yearMonth,List<String> quotaNames) {
        List<TBusinessQuota> quotaList = quotaData("ZKRY", yearMonth, yearMonth, quotaNames);
        JSONObject json = new JSONObject();
        for(String quotaName:quotaNames){
            for(TBusinessQuota quota:quotaList){
                if (quotaName.equals(quota.getFnameEn())){
                    json.put(quota.getFnameZh().split("-")[1],quota.getFvalue());
                }
            }
        }
        return json;
    }

    /**
     * create User 杨北平  2018-01-18
     * 查询牛群发病前5大病种数据
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     */
    public List<TBusinessQuota> dairyCowsMorbidityFiveMaxAjax(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames){
        TBusinessQuotaExample example = new TBusinessQuotaExample();
        TBusinessQuotaExample.Criteria criteria = example.createCriteria();
        if (orgCode != null&&orgCode!="") {
            criteria.andForgCodeEqualTo(orgCode);
        }
        criteria.andFyearMonthBetween(beginYearMonth, endYearMonth);
        criteria.andFnameEnIn(quotaNames);
        example.setOrderByClause("fvalue desc");//排序字段填写数据库表中的字段名
        List<TBusinessQuota> quotaList = businessQuotaMapper.selectByExample(example);
        return quotaList;
    }

    /**
     * 查询单位利润数据
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    @Override
    public JSONObject queryUnitData(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        //根据开始、结束期间获取期间列表
        List<String> yearMonths = DateUtil.getYearArr(beginYearMonth, endYearMonth);
        List<TBusinessQuota> resultList = quotaData(orgCode,beginYearMonth,endYearMonth,quotaNames);//查询数据
        JSONObject json = new JSONObject();
        List<List<TBusinessQuota>> valueList = new ArrayList<>();
        for (String yearMonth:yearMonths){
            List<TBusinessQuota> quotaList = new ArrayList<>();
            for (TBusinessQuota quota:resultList){
                if (yearMonth.equals(quota.getFyearMonth())){
                    quotaList.add(quota);
                }
            }
            valueList.add(quotaList);
        }
        List<Object> resultData = new ArrayList<>();
        for(int j = 0;j<valueList.size();j++){
            List<BigDecimal> value = new ArrayList<>();
            BigDecimal LRZE = BigDecimal.ZERO;//利润总额
            BigDecimal CRNTS = BigDecimal.ZERO;//成乳牛头数
            BigDecimal YGRS = BigDecimal.ZERO;//员工人数
            BigDecimal ZYYWCB = BigDecimal.ZERO;//主营业务成本
            BigDecimal YZCNL = BigDecimal.ZERO;//月总产奶量
            for(TBusinessQuota quota:valueList.get(j)){
                switch (quota.getFnameEn()){
                    case "CW-YYLR":
                        LRZE=quota.getFvalue().multiply(new BigDecimal(10000));
                        break;
                    case "ZHZB-CRNTS-TS":
                        CRNTS=quota.getFvalue();
                        break;
                    case "COUNT-EMPLOYEE":
                        YGRS=quota.getFvalue();
                        break;
                    case "ZHZB-ZYYWCB-WY":
                        ZYYWCB=quota.getFvalue().multiply(new BigDecimal(10000));
                        break;
                    case "PJRCNL-QK":
                        YZCNL=quota.getFvalue().divide(new BigDecimal(1000),2,BigDecimal.ROUND_HALF_UP);
                        break;
                }
            }
            if(!CRNTS.equals(BigDecimal.ZERO)){
                value.add(LRZE.divide(CRNTS,2,BigDecimal.ROUND_HALF_UP));//单牛利润
            }else{
                value.add(new BigDecimal(0));
            }
            if(!YGRS.equals(BigDecimal.ZERO)){
                value.add(LRZE.divide(YGRS,2,BigDecimal.ROUND_HALF_UP));//单人利润
                value.add(CRNTS.divide(YGRS,2,BigDecimal.ROUND_HALF_UP));//人均头数
            }else{
                value.add(new BigDecimal(0));
                value.add(new BigDecimal(0));
            }
            if(!YZCNL.equals(BigDecimal.ZERO)){
                value.add(ZYYWCB.divide(YZCNL,2,BigDecimal.ROUND_HALF_UP));//单奶成本
            }else{
                value.add(new BigDecimal(0));
            }
            resultData.add(value);
        }
        json.put("resultData",resultData);
        json.put("yearMonths",yearMonths);
        return json;
    }


    /**
     * 查询每日产奶量数据
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    @Override
    public JSONObject dailyYieldAjax(String orgCode, String beginYearMonth,String endYearMonth, List<String> quotaNames) {


        List<TBusinessQuota> resultList = quotaData(orgCode,beginYearMonth,endYearMonth,quotaNames);
        JSONObject json = new JSONObject();
        for(TBusinessQuota quota:resultList){
            json.put(quota.getFyearMonth(),quota.getFvalue());
        }
        return json;
    }
    /**
     * 查询产销量明细数据
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    @Override
    public Map<String, Object> getProductionData(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames){
        List<TBusinessQuota> resultList = quotaData(orgCode,beginYearMonth,endYearMonth,quotaNames);
        Map<String,Object> map =  new HashMap<>();
        for(int i = 0;i<quotaNames.size();i++){
            BigDecimal list = BigDecimal.ZERO;
            for(TBusinessQuota quota:resultList){
                if(quota.getFnameEn().equals(quotaNames.get(i))){
                    list = quota.getFvalue();
                }
            }
            map.put(quotaNames.get(i).split("-")[1],list);
        }
        return map;
    }
    /**
     * 查询产销量明细数据
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    @Override
    public Map<String, Object>  getProductionChart(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        List<TBusinessQuota> resultList = quotaData(orgCode, beginYearMonth, endYearMonth, quotaNames);
        Map<String, Object> maps = new HashMap<>();
        for(int i = 0;i<quotaNames.size();i++) {
            BigDecimal nowyear  = BigDecimal.ZERO;
                for (TBusinessQuota quota : resultList) {
                 if(quota.getFyearMonth().equals(endYearMonth)&&quota.getFnameEn().equals(quotaNames.get(i))){
                        nowyear=quota.getFvalue();
                    }
                }
            maps.put(quotaNames.get(i).split("-")[1],nowyear);
        }
        return maps;
    }
    /**
     * 查询产销量明细数据
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    @Override
    public Map<String, Object>  getSummilkChart(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames) {
        List<TBusinessQuota> resultList = quotaData(orgCode, beginYearMonth, endYearMonth, quotaNames);
        Map<String, Object> maps = new HashMap<>();
        for(int i = 0;i<quotaNames.size();i++) {
            BigDecimal nowyear  = BigDecimal.ZERO;
            for (TBusinessQuota quota : resultList) {
                if(quota.getFyearMonth().equals(endYearMonth)&&quota.getFnameEn().equals(quotaNames.get(i))){
                    nowyear=nowyear.add(quota.getFvalue());
                }
            }
            maps.put(quotaNames.get(i).split("-")[1],nowyear);
        }
        return maps;
    }

    /**
     * 华山牧乳业销售分析数据
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    @Override
    public Map<String, Object>  getsaleChart(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames){
        List<TBusinessQuota> resultList = quotaData(orgCode, beginYearMonth, endYearMonth, quotaNames);
        Map<String, Object> maps = new HashMap<>();
        for(int i = 0;i<quotaNames.size();i++) {
            BigDecimal nowyear  = BigDecimal.ZERO;
            for (TBusinessQuota quota : resultList) {
                if(quota.getFnameEn().equals(quotaNames.get(i))){
                    nowyear=quota.getFvalue();
                }
            }
            maps.put(quotaNames.get(i).split("-")[2],nowyear);
        }
        return maps;
    }

    public List<TBusinessQuota> loopQuery(int numb,List<String> orgCodes,List<String> quotaNames){
        List<TBusinessQuota> resultList;
        BigDecimal fvalue = BigDecimal.ZERO;
        int num = numb;
        do {
            String[] OMonth = DateUtil.getBeginEndYearMonth(num);
            resultList = quotaData(orgCodes,OMonth[0],quotaNames);
            num++;
            for (TBusinessQuota quota:resultList){
                if (quota.getFnameEn().equals(quotaNames.get(0))){
                    fvalue = quota.getFvalue();
                }
            }
        }while (fvalue.compareTo(BigDecimal.ZERO)==0);
        List<TBusinessQuota> result = new ArrayList<>();
        for(String quotaName:quotaNames){
            for(TBusinessQuota quota:resultList){
                if (quotaName.equals(quota.getFnameEn())){
                    result.add(quota);
                }
            }
        }
        return result;
    }
    public Map<String,Object> saleChart(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames){
        List<TBusinessQuota> resultList = quotaData(orgCode, beginYearMonth, endYearMonth, quotaNames);
        Map<String,Object> map = new HashMap<>();
            for(String quotaName:quotaNames) {
            List<TBusinessQuota> list = new ArrayList<>();
                for (TBusinessQuota quota : resultList) {
                    if(quota.getFnameEn().equals(quotaName)){
                       list.add(quota);
                    }
                }
            map.put(quotaName.split("-")[2],list);
        }
        return map;
    }
    public List<TBusinessQuota> saleCharts(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames,List<String> smallclass) {
        //查询牛群损失指标
        TBusinessQuotaExample example = new TBusinessQuotaExample();
        TBusinessQuotaExample.Criteria criteria = example.createCriteria();
        if (orgCode != null&&orgCode!="") {
            criteria.andForgCodeEqualTo(orgCode);
        }
        criteria.andFyearMonthBetween(beginYearMonth, endYearMonth);
        criteria.andFnameEnIn(quotaNames);
        criteria.andFsmallClassIn(smallclass);
        example.setOrderByClause("fyear_month asc");//排序字段填写数据库表中的字段名
        List<TBusinessQuota> quotaList = businessQuotaMapper.selectByExample(example);
        return quotaList;
    }


    /**
     * 查询华山牧乳业每日快报主表数据
     * @param orgCode
     * @param num
     * @param quotaNames1
     */
    public Map<String,Object> queryDailyData(String orgCode,int num,List<String> quotaNames1,List<String> quotaNames2){
        BigDecimal value = BigDecimal.ZERO;
        List<TBusinessQuota> quotaList;
        List<TBusinessQuota> budgetData = null;
        List<String> orgCodes = new ArrayList<>();
        Map<String,Object> resultMap = new HashMap<>();
        String yearMonth;
        orgCodes.add(orgCode);
        do {
            String[] yearMonths = DateUtil.getStartEndYearMonth(num);
            quotaList = quotaData(orgCodes, yearMonths[0], quotaNames1);
            for(TBusinessQuota quota:quotaList){
                value = value.add(quota.getFvalue());
            }
            if (value.compareTo(BigDecimal.ZERO)==1){
                budgetData = quotaData(orgCodes,yearMonths[0].substring(0,6),quotaNames2);
            }
            yearMonth=yearMonths[0];
            num++;
        }while (value.compareTo(BigDecimal.ZERO)==0);

        Map<String,BigDecimal> actualMap = dataProcessing(quotaNames1,quotaList);
        Map<String,BigDecimal> budgetMap = dataProcessing(quotaNames2,budgetData);
        actualMap.putAll(budgetMap);
        resultMap.put("resultMap",actualMap);
        resultMap.put("yearMonth",yearMonth);
        return resultMap;
    }
    /**
     * 查询华山牧乳业每日快报主表数据
     * @param orgCode
     * @param num
     * @param quotaNames1
     */
    public Map<String,Object> queryDailyDatas(String orgCode,int num,List<String> quotaNames1,List<String> quotaNames2){
        BigDecimal value = BigDecimal.ZERO;
        List<TBusinessQuota> quotaList;
        List<TBusinessQuota> budgetData = null;
        List<String> orgCodes = new ArrayList<>();
        Map<String,Object> resultMap = new HashMap<>();
        String yearMonth;
        orgCodes.add(orgCode);
        do {
            String[] yearMonths = DateUtil.getStartEndYearMonth(num);
            String[] nowday = DateUtil.startDndDay(yearMonths[0].substring(0,6),num);

            quotaList = quotaData(orgCodes, yearMonths[0], quotaNames1);
            for(TBusinessQuota quota:quotaList){
                value = value.add(quota.getFvalue());
            }
            if (value.compareTo(BigDecimal.ZERO)==1){
                budgetData = quotaData(orgCodes,nowday[0],quotaNames2);
            }
            yearMonth=yearMonths[0];
            num++;
        }while (value.compareTo(BigDecimal.ZERO)==0);

        Map<String,BigDecimal> actualMap = dataProcessing(quotaNames1,quotaList);
        Map<String,BigDecimal> budgetMap = dataProcessing(quotaNames2,budgetData);
        actualMap.putAll(budgetMap);
        resultMap.put("resultMap",actualMap);
        resultMap.put("yearMonth",yearMonth);
        return resultMap;
    }
    public Map<String,BigDecimal> dataProcessing(List<String> quotaNames,List<TBusinessQuota> quotaList){
        Map<String,BigDecimal> resultMap = new TreeMap<>();
        for(String quotaName:quotaNames){
            BigDecimal addValue = BigDecimal.ZERO;
            for(TBusinessQuota quota:quotaList){
                if (quotaName.equals(quota.getFnameEn())){
                    addValue=addValue.add(quota.getFvalue());
                }
            }
            resultMap.put(quotaName,addValue);
        }
        return resultMap;
    }

    /**
     * 首页生鲜奶数据
     * @param orgCode
     * @param beginYearMonth
     * @param endYearMonth
     * @param quotaNames
     * @return
     */
    public JSONObject getJsonMilkChart(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames){
        List<TBusinessQuota> resultList = quotaData(orgCode, beginYearMonth, endYearMonth, quotaNames);
        List<BigDecimal> list = new ArrayList<>();
        for(String quotaName:quotaNames){
            BigDecimal value = BigDecimal.ZERO;
            for(TBusinessQuota quota:resultList){
                if(quota.getFnameEn().equals(quotaName)){
                    value = quota.getFvalue();
                    list.add(value);
                }
            }
        }
        JSONObject result = new JSONObject();
        result.put("resultList",list);
        return result;
    }
    public JSONObject getJsonMilkCharts(String orgCode, String beginYearMonth, String endYearMonth, List<String> quotaNames){
        JSONObject resultList = getJsonMilkChart(orgCode,beginYearMonth,endYearMonth, quotaNames);
        int result = ((List<BigDecimal>)((Map<String,Object>)resultList).get("resultList")).size();
        while (result==0){
            beginYearMonth = DateUtil.getBeginDay(beginYearMonth,1)[0];
            endYearMonth = DateUtil.getBeginDay(endYearMonth,1)[0];
            resultList = getJsonMilkChart(orgCode,beginYearMonth,endYearMonth, quotaNames);
            result = ((List<BigDecimal>)((Map<String,Object>)resultList).get("resultList")).size();
        }
        resultList.put("beginTime",endYearMonth);
        return  resultList;
    }

//    /**
//     * create by 杨北平  2018-03-20
//     * 查询品类分析数据
//     * @param orgCode
//     * @param num 查询开始时间往前推多久
//     * @param quotaNames
//     * @param category 区分月/日
//     * @return
//     */
//    public List<TBusinessQuota> queryCategory(String orgCode,int num,List<String> quotaNames,String category){
//        BigDecimal value = BigDecimal.ZERO;
//        String[] yearMonths;
//        List<TBusinessQuota> quotaList;
//        do {
//            if (category.equals("month")) {
//                yearMonths = DateUtil.getBeginEndYearMonth(num);
//            }else{
//                yearMonths = DateUtil.getStartEndYearMonth(num);
//            }
//            quotaList = quotaData(orgCode,yearMonths[0],yearMonths[1],quotaNames,null,5);
//            for(TBusinessQuota quota:quotaList){
//                value = value.add(quota.getFvalue());
//            }
//            if (value.compareTo(BigDecimal.ZERO)==1){
//
//            }
//            num++;
//        }while (value.compareTo(BigDecimal.ZERO)==0);
//
//        return quotaList;
//    }

    /**
     * 组装品类分析数据
     * @param orgCode
     * @param num
     * @param quotaNames
     * @param category
     * @return
     */
    public Map<String,Object> returnCategoryData(String orgCode,String yearMonth,int num,List<String> quotaNames,String category){
        List<String> smallClasses = new ArrayList<>();
        List<TBusinessQuota> quotaList = quotaData(orgCode,yearMonth,yearMonth,quotaNames,smallClasses,"fvalue desc");
        for(int i = 0;i < 5;i++){
            if (quotaList.size()>0) {
                smallClasses.add(quotaList.get(i).getFsmallClass());
            }
        }
        String[] yearMonths;
        List<String> yearMonthArr = null;
        if (category.equals("month")){
            yearMonths = DateUtil.getBeginMonth(yearMonth,12);
            yearMonthArr = DateUtil.getYearMonthArr(DateUtil.getBeginMonth(yearMonth,11)[0],DateUtil.getBeginMonth(yearMonth,-1)[0]);
        }else {
            yearMonths = DateUtil.getBeginDay(yearMonth,30);
            yearMonthArr = DateUtil.getYearMonthDayArr(DateUtil.getBeginDay(yearMonth,29)[0],yearMonths[1]);
        }
        List<TBusinessQuota> quotaList1 = quotaData(orgCode,yearMonths[0],yearMonths[1],quotaNames,smallClasses,"fyear_month asc,fsmall_class asc");
        if (!category.equals("month")){
            //yearMonthArr = getDateArr(quotaList1);
        }
        Map<String,Object> resultMap = new HashMap<>();
        for(String smallClass:smallClasses){
            List<BigDecimal> resultList = new ArrayList<>();
            for(int i=0;i<yearMonthArr.size();i++){
                resultList.add(BigDecimal.ZERO);
            }
            for(TBusinessQuota quota:quotaList1){
                if (quota.getFsmallClass().equals(smallClass)){
                    for (int j = 0;j<yearMonthArr.size();j++){
                        if (quota.getFyearMonth().equals(yearMonthArr.get(j))){
                            resultList.set(j,quota.getFvalue());
                        }
                    }
                }
            }
            resultMap.put(smallClass,resultList);
        }
        resultMap.put("yearMonthArr",yearMonthArr);
        return resultMap;
    }

    /**
     * 查询数据
     * @param orgCode
     * @param beginMonth
     * @param endMonth
     * @param quotaNames
     * @param smallClasses
     * @return
     */
    public List<TBusinessQuota> quotaData(String orgCode,String beginMonth,String endMonth,List<String> quotaNames,List<String> smallClasses,String order){
        TBusinessQuotaExample example = new TBusinessQuotaExample();
        TBusinessQuotaExample.Criteria criteria = example.createCriteria();
        criteria.andForgCodeEqualTo(orgCode);
        criteria.andFyearMonthBetween(beginMonth,endMonth);
        criteria.andFnameEnIn(quotaNames);
        if (smallClasses!=null && smallClasses.size()>0){
            criteria.andFsmallClassIn(smallClasses);
        }
        example.setOrderByClause(order);
        List<TBusinessQuota> quotaList = this.businessQuotaMapper.selectByExample(example);
        return  quotaList;
    }



}
