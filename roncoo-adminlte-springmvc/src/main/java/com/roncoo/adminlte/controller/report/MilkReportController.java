package com.roncoo.adminlte.controller.report;

import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.TAccountsReceivable;
import com.roncoo.adminlte.bean.entity.TDailyReport;
import com.roncoo.adminlte.service.*;
import com.roncoo.adminlte.util.Constants;
import com.roncoo.adminlte.util.DateUtil;
import com.roncoo.adminlte.util.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 乳业视图报表控制器
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/3 10:43
 */
@Controller
@RequestMapping(value = "report/milkReport", method = RequestMethod.POST)
public class MilkReportController extends BaseController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TSysUserLogsService  userLogsService;
    @Autowired
    private PastureReportService pastureReportService;

    @Autowired
    private HsmryDailyReportListService reportListService;

    @Autowired
    private TDailyReportService tDailyReportService;

    @Autowired
    private TAccountsReceivableService receivableService;

    @Autowired
    private TFinanceMainService mainService;
    /**
     *createUser:倪鑫 to 2017-11-18
     * yearMontArr 得到已经过去12个月的第一个月和最后一个月
     */
    //modify begin 2017-11-9 倪鑫 新增参数
    //private String[] yearMontArr = DateUtil.getBeginEndYearMonth(12);
    //modify end
    /**
     * 营业收入明细
     * @param companyNumber
     */
    @RequestMapping(value = "/businessIncomeDetail", method = RequestMethod.GET)
    public void businessIncomeDetail(ModelMap modelMap, @RequestParam(required = true) String companyNumber,String company) {
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "营业收入明细");
        String[] yearMonths = DateUtil.getBeginEndYearMonth(2);
        List<String> indexFnameEn = new ArrayList<>();
        indexFnameEn.add("ZHZB-YYSR-WY");
        indexFnameEn.add("ZHZB-YYSR-BNLJ-WY");
        indexFnameEn.add("ZHZB-YYSR-BQSN-WY");
        List<Object> resultList = this.pastureReportService.queryReimbursement(company,yearMonths[0], yearMonths[1],indexFnameEn);
        String[] lastMonth = DateUtil.getBeginMonth(((ArrayList<String>)resultList.get(1)).get(1),12);
        modelMap.put("resultList",resultList.get(0));
        modelMap.put("lastMonth",lastMonth[0]);
        modelMap.put("result",resultList.get(1));
        modelMap.put("company",company);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
    }

    /**
     * 营业收入明细-获取年度营收趋势图-charts数据
     *createUser：倪鑫 to 2017-11-19
     * @param yearMonth
     * @return
     */
    @RequestMapping(value = "/businessDataAjax", method = RequestMethod.GET)
    @ResponseBody
    public String summaryDataAjax(String yearMonth,String companyNumber) {
        String[] defaultMonth = DateUtil.getBeginEndYearMonth(1);
        if (yearMonth.isEmpty()){
            yearMonth = defaultMonth[0];
        }
        int[] rowIndex = new int[3];
            rowIndex[0] = 6;
            rowIndex[1] = 14;
            rowIndex[2] = 22;
        List<Integer> rowNum = new ArrayList<>();
        if (rowIndex.length>0){
            for (int rows :rowIndex){
                rowNum.add(rows);
            }
        }
        JSONObject json = this.pastureReportService.searchSummaryData(companyNumber,yearMonth,rowNum);
        return json.toJSONString();
    }

    /**
     *营业收入明细-获取年度营收趋势图-charts数据
     *createUser：倪鑫  to 2017-11-19
     * @param modelMap
     * @param companyNumber
     * @param company
     * @return
     */
    @RequestMapping(value = "/businessIncomeDetailAjax", method = RequestMethod.GET)
    @ResponseBody
    public String annualRevenueTrendsAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String company,String yearMonthone){
        String[] yearMontArr = DateUtil.getBeginMonth(yearMonthone,11);
        String layout_x = "month";//定义x轴的值类型 month(按月份排列) or parameter(按查询的参数排列)
        String layout_y = "sum";//定义x轴的值类型 sum(求和) or value(取值)
        List<String > quotaNames_a = new ArrayList<>();
        quotaNames_a.add("ZHZB-YYSR-WY");
        JSONObject json_a = this.pastureReportService.getJsonObject(company, yearMontArr[0], yearMontArr[1], quotaNames_a, layout_x, layout_y);

        List<String > quotaNames_b = new ArrayList<>();
        quotaNames_b.add("ZHZB-YYSR-YSMB-WY");
        JSONObject json_b = this.pastureReportService.getJsonObject(company, yearMontArr[0], yearMontArr[1], quotaNames_b, layout_x, layout_y);
        List<String > quotaNames_c = new ArrayList<>();
        quotaNames_c.add("ZHZB-YYSR-BQSN-WY");
        JSONObject json_c = this.pastureReportService.getJsonObject(company, yearMontArr[0], yearMontArr[1], quotaNames_c, layout_x, layout_y);
        JSONObject json = new JSONObject();//组装返回页面的json
        json.put("axisx",json_a.get("axisx"));
        json.put("ZYYWCB",json_a.get("axisy"));
        json.put("ZYYWJSR",json_b.get("axisy"));
        json.put("ZHZBSN",json_c.get("axisy"));
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        return json.toJSONString();
    }

    /**
     * *营业收入明细-饼图-charts数据
     *createUser：倪鑫  to 2017-1-18
     * @param modelMap
     * @param companyNumber
     * @param company
     * @return
     */
    @RequestMapping(value = "/businessAjax", method = RequestMethod.GET)
    @ResponseBody
    public String businessAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String company,String yearMonthone){
        String layout_x = "parameter";//定义x轴的值类型 month(按月份排列) or parameter(按查询的参数排列)
        String layout_y = "value";//定义x轴的值类型 sum(求和) or value(取值)
        List<String > quotaNames = new ArrayList<>();
        quotaNames.add("ZHZB-YYSR-BNLJ-WY");
        quotaNames.add("ZHZB-YYSR-BQSN-LJ");
        JSONObject json_a = this.pastureReportService.getJsonObject(company, yearMonthone, yearMonthone, quotaNames, layout_x, layout_y);
        JSONObject json = new JSONObject();//组装返回页面的json
        json.put("axisx",json_a.get("axisx"));
        json.put("resultList",json_a.get("axisy"));
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        return json.toJSONString();
    }
    /**
     * 销售毛利率明细
     *
     * @param modelMap
     * @param companyNumber
     */
    @RequestMapping(value = "/grossProfitMarginDetail", method = RequestMethod.GET)
    public void grossProfitMargin(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String company) {
        modelMap.put("company",company);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
    }

    /**
     * 销售毛利率chart数据
     *
     * @param modelMap
     * @param companyNumber
     */
    @RequestMapping(value = "/grossProfitMarginDetailAjax", method = RequestMethod.GET)
    @ResponseBody
    public String grossProfitMarginDetailAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String company) {
        String[] yearMontArr = DateUtil.getBeginEndYearMonth(12);
        String layout_x = "month";//定义x轴的值类型 month(按月份排列) or parameter(按查询的参数排列)
        String layout_y = "sum";//定义x轴的值类型 sum(求和) or value(取值)
        List<String > quotaNames_a = new ArrayList<>();
        quotaNames_a.add("ZHZB-CWNXSMLL-BFB");
        JSONObject json_a = this.pastureReportService.getJsonObject(company, yearMontArr[0], yearMontArr[1], quotaNames_a, layout_x, layout_y);
        List<String > quotaNames_b = new ArrayList<>();
        quotaNames_b.add("ZHZB-DWNXSMLL-BFB");
        JSONObject json_b = this.pastureReportService.getJsonObject(company, yearMontArr[0], yearMontArr[1], quotaNames_b, layout_x, layout_y);
        List<String > quotaNames_c = new ArrayList<>();
        quotaNames_c.add("ZHZB-GTNFXSMLL-BFB");
        JSONObject json_c = this.pastureReportService.getJsonObject(company, yearMontArr[0], yearMontArr[1], quotaNames_c, layout_x, layout_y);
        List<String > quotaNames_d = new ArrayList<>();
        quotaNames_d.add("ZKZB-XSMLL-BFB");
        JSONObject json_d = this.pastureReportService.getJsonObject(company, yearMontArr[0], yearMontArr[1], quotaNames_d, layout_x, layout_y);
        JSONObject json = new JSONObject();
        json.put("axisx",json_a.get("axisx"));
        json.put("CWN",json_a.get("axisy"));
        json.put("DWN",json_b.get("axisy"));
        json.put("GDN",json_c.get("axisy"));
        json.put("ZKZB",json_d.get("axisy"));
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        return json.toJSONString();
    }

    /**
     * 乳制品销量明细
     * @param modelMap
     * @param companyNumber
     */
    @RequestMapping(value = "/dairySalesDetail", method = RequestMethod.GET)
    public void dairySalesDetail(ModelMap modelMap, @RequestParam(required = true) String companyNumber, String company) {
        String[] yearMonts = DateUtil.getBeginEndYearMonth(1);
        String layout_x = "parameter";//定义x轴的值类型 month(按月份排列) or parameter(按查询的参数排列)
        String layout_y = "sum";//定义x轴的值类型 sum(求和) or value(取值)
        List<String > quotaNames = new ArrayList<>();
        quotaNames.add("XLFX-DWNXL-QK");
        quotaNames.add("XLFX-CWNXL-QK");
        quotaNames.add("PJRCNL-XSMYXL");
        quotaNames.add("ZHZB-ZYYWJSR-WY");
        quotaNames.add("XLFX-NFXL-QK");//奶粉销量
        JSONObject json = this.pastureReportService.getJsonChart(company, yearMonts[0], yearMonts[0], quotaNames, layout_x, layout_y);
        modelMap.put("resultData", json.get("axisy"));
        modelMap.put("beginTime", json.get("beginTime"));
        modelMap.put("company",company);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "乳制品销量明细");
    }

    /**
     * 乳制品销量明细-年度营收趋势图-charts数据
     * createUser：倪鑫 to 2017-11-19
     * @param modelMap
     * @param companyNumber
     * @return
     */
    @RequestMapping(value = "/dairySalesDetailAjax", method = RequestMethod.GET)
    @ResponseBody
    public String dairySalesDetailAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String company,String yearMonthone){
        String[] yearMontArr = DateUtil.getBeginMonth(yearMonthone,11);
        String layout_x = "month";//定义x轴的值类型 month(按月份排列) or parameter(按查询的参数排列)
        String layout_y = "sum";//定义x轴的值类型 sum(求和) or value(取值)
        List<String > quotaNames_a = new ArrayList<>();
        quotaNames_a.add("XLFX-DWNXL-QK");
        JSONObject json_a = this.pastureReportService.getJsonObject(company, yearMontArr[0], yearMontArr[1], quotaNames_a, layout_x, layout_y);

        List<String > quotaNames_b = new ArrayList<>();
        quotaNames_b.add("XLFX-CWNXL-QK");
        JSONObject json_b = this.pastureReportService.getJsonObject(company, yearMontArr[0], yearMontArr[1], quotaNames_b, layout_x, layout_y);

        List<String > quotaNames_c = new ArrayList<>();
        quotaNames_c.add("PJRCNL-XSMYXL");
        JSONObject json_c = this.pastureReportService.getJsonObject(company, yearMontArr[0], yearMontArr[1], quotaNames_c, layout_x, layout_y);

        quotaNames_c.add("XLFX-NFXL-QK");
        JSONObject json_d = this.pastureReportService.getJsonObject(company, yearMontArr[0], yearMontArr[1], quotaNames_c, layout_x, layout_y);

        JSONObject json = new JSONObject();//组装返回页面的json
        json.put("axisx",json_a.get("axisx"));
        json.put("DWN",json_a.get("axisy"));
        json.put("CWN",json_b.get("axisy"));
        json.put("GTNF",json_c.get("axisy"));
        json.put("NF",json_d.get("axisy"));
        json.put("company",company);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        return json.toJSONString();
    }
    /**
     * 应收账款明细
     * @param modelMap
     * @param companyNumber
     */
    @RequestMapping(value = "/accountsReceivableDetail", method = RequestMethod.GET)
    public void accountsReceivableDetail(ModelMap modelMap, @RequestParam(required = true) String companyNumber,String company) {
        String[] yearMontArr = DateUtil.getBeginEndYearMonth(2);//取前2个月
        List<String > quotaNames = new ArrayList<>();
        quotaNames.add("ZHZB-YSZK-WY-QM"); //期末应收账款
        quotaNames.add("ZHZB-YSZK-WY-NC");  //年初应收账款
        quotaNames.add("ZHZB-YSZK-WY-SN");//上年本月应收账款
        quotaNames.add("ZHZB-YYSR-WY");   //本期营业收入
        List<Object> resultList = this.pastureReportService.queryReimbursement(company, yearMontArr[0], yearMontArr[1], quotaNames);
        String[] lastMonth = DateUtil.getBeginMonth(((ArrayList<String>)resultList.get(1)).get(1),12);
        modelMap.put("resultData",resultList.get(0));
        modelMap.put("lastMonth",lastMonth[0]);
        modelMap.put("result",resultList.get(1));
        modelMap.put("company",company);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "应收账款明细");

    }

    /**
     * 应收账款明细charts数据
     * @param modelMap
     * @param companyNumber
     * @param company
     * @return
     */
    @RequestMapping(value = "/accountsReceivableDetailAjax", method = RequestMethod.GET)
    @ResponseBody
    public String accountsReceivableDetailAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String company,String yearMonth){
        String[] yearMontArr = DateUtil.getBeginMonth(yearMonth,11);
        String layout_x = "month";//定义x轴的值类型 month(按月份排列) or parameter(按查询的参数排列)
        String layout_y = "sum";//定义x轴的值类型 sum(求和) or value(取值)
        List<String > quotaNames_a = new ArrayList<>();
        quotaNames_a.add("ZHZB-YSZK-WY-QM");
        JSONObject json_a = this.pastureReportService.getJsonObject(company, yearMontArr[0], yearMontArr[1], quotaNames_a, layout_x, layout_y);
        JSONObject json = new JSONObject();//组装返回页面的json
        json.put("axisx",json_a.get("axisx"));
        json.put("OBC",json_a.get("axisy"));
        return json.toJSONString();
    }

    /**
     * 采购看板
     * @param modelMap
     * @param companyNumber
     */
    @RequestMapping(value = "/purchasingReport", method = RequestMethod.GET)
    public void purchasingReport(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(required = true) String company) {
        modelMap.put("company", company);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "采购看板");
    }

    /**
     * 采购价格分析
     * @param modelMap
     * @param companyNumber
     */
    @RequestMapping(value = "/purchasingPriceReport", method = RequestMethod.GET)
    public void purchasingPriceReport(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(required = true) String company) {
        modelMap.put("company", company);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "采购价格分析");
    }

    /**
     * 采购执行分析
     * @param modelMap
     * @param companyNumber
     */
    @RequestMapping(value = "/purchasingExecutionReport", method = RequestMethod.GET)
    public void purchasingExecutionReport(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(required = true) String company) {
        modelMap.put("company", company);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "采购执行分析");
    }

    /**
     * 销售看板
     * @param modelMap
     * @param companyNumber
     */
    @RequestMapping(value = "/salesKanban", method = RequestMethod.GET)
    public void salesKanban(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(required = true) String company) {
        modelMap.put("company", company);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "销售看板");
    }

    /**
     * 区域分析
     * @param modelMap
     * @param companyNumber
     */
    @RequestMapping(value = "/regionalAnalysis", method = RequestMethod.GET)
    public void regionalAnalysis(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(required = true) String company) {
        modelMap.put("company", company);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "区域分析");
    }


    /**
     * 区域分析ajax
     * *江林
     * @param modelMap
     * @param companyNumber
     */

    @RequestMapping(value = "/regionalAnalysisajax", method = RequestMethod.GET)
    @ResponseBody
    public String regionalAnalysisajax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String company,String yearMonth) {
        String[] yearMonths = DateUtil.getBeginMonth(yearMonth,11);
        List<String > quotaNames_a = new ArrayList<>();
        JSONObject json = new JSONObject();
        quotaNames_a.add("PJRCNL-MYXHSMR");
        JSONObject json_a = this.pastureReportService.getSaleCharts(company, yearMonths[0], yearMonths[1], quotaNames_a);
        quotaNames_a.set(0,"ZKGYL-LSMYXL");
        JSONObject json_b = this.pastureReportService.getSaleCharts("ZKGYL", yearMonths[0], yearMonths[1], quotaNames_a);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        json.put("HSMRY",json_a);
        json.put("ZKGYL",json_b);
        json.put("yearMonth",json_a.get("yearMonth"));
        return json.toJSONString();
    }
    /**
     * 每日区域分析ajax
     * *
     * @param modelMap
     * @param companyNumber
     */

    @RequestMapping(value = "/hsmrySaleDayajax", method = RequestMethod.GET)
    @ResponseBody
    public String hsmrySaleDayajax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String company,String securityTimes) {
        String start = DateUtil.dateToDay(securityTimes);
        String startTime = start.substring(0,4)+start.substring(5,7)+start.substring(8,10);
        String endTime = securityTimes.substring(0,4)+securityTimes.substring(5,7)+securityTimes.substring(8,10);
        List<String > quotaNames_a = new ArrayList<>();
        JSONObject json = new JSONObject();
        quotaNames_a.add("PJRCNL-MTSHSMR");
        JSONObject json_a = this.pastureReportService.getSaleChart(company, startTime, endTime, quotaNames_a);
        quotaNames_a.add("ZKGYL-LSMTXL");
        JSONObject json_b = this.pastureReportService.getSaleChart("ZKGYL", startTime, endTime, quotaNames_a);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        json.put("HSMRY",json_a);
        json.put("ZKGYL",json_b);
        json.put("yearMonth",json_a.get("yearMonth"));
        return json.toJSONString();
    }



    /**
     * 品类分析
     * @param modelMap
     * @param companyNumber
     */
    @RequestMapping(value = "/categoryAnalysis", method = RequestMethod.GET)
    public void categoryAnalysis(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(required = true) String company) {
        modelMap.put("company", company);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "品类分析");
    }

    /**
     * 销售部门分析
     * @param modelMap
     * @param companyNumber
     */
    @RequestMapping(value = "/salesDepartmentAnalysis", method = RequestMethod.GET)
    public void salesDepartmentAnalysis(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(required = true) String company) {
        modelMap.put("company", company);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "销售部门分析");
    }

    /**
     * 销售渠道
     *
     * @param modelMap
     * @param companyNumber
     */
    @RequestMapping(value = "/channelAnalysis", method = RequestMethod.GET)
    public void salesChannel(ModelMap modelMap, @RequestParam(required = true) String companyNumber,String company) {
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "销售渠道");
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("company",company);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
    }
    /**
     * 销售日报表
     *
     * @param modelMap
     * @param companyNumber
     */
    @RequestMapping(value = "/salesAnalysis", method = RequestMethod.GET)
    public void salesAnalysis(ModelMap modelMap, @RequestParam(required = true) String companyNumber,String company) {
        Map<String,Object> resultMap = this.reportListService.selectByExample();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String yearMonths = sdf.format(new Date());
//        String[] yearMonths = DateUtil.getBeginDay(sdf.format(new Date()),1);
        List<BigDecimal> dis = new ArrayList<>();
        dis.add(new BigDecimal(22));
        dis.add(new BigDecimal(42));
        List<TDailyReport> reportList = this.tDailyReportService.selectByExample(yearMonths,new BigDecimal(0),dis);

        SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar1 = Calendar.getInstance();
        Date date1 = calendar1.getTime();
        String nowdays = sdfs.format(date1);//当前时间
        String firstday = DateUtil.datefirstDay();//获取本月第一天
        String endday = DateUtil.dateDays();//本月26号
        String starttime = DateUtil.dateDay();//获取上个月26号
        long day = DateUtil.getDaySub(firstday,endday);//本月第一天至本月26号的天数
        long days = DateUtil.getDaySub(firstday,nowdays);//本月第一天至当前时间的天数
        long startday = DateUtil.getDaySub(endday,nowdays);;//得到本月26号到当前时间的天数
        long bothtime = DateUtil.getDaySub(starttime,nowdays);//上个月26号至现在的时间
        String month = nowdays.substring(5,7);
        long nowday;
        if(days>day&&!month.equals("12")){
            nowday = startday-1;
        }else if(days<day&&month.equals("01")){
            nowday = days;
        }else {
            nowday = bothtime-1;
        }
        modelMap.put("nowday", nowday);
        modelMap.put("resultMap",resultMap);
        modelMap.put("yearMonth",yearMonths);
        modelMap.put("reportList",reportList);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("company",company);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
    }

//    /**
//     * 乳业首页销量分析图数据
//     * createUser 杨北平 to 2017-11-9
//     * @param modelMap
//     * @param companyNumber 公司编码
//     * @return 结果集
//     */
//    @ResponseBody
//    @RequestMapping(value="/financialIndexAjax",method = RequestMethod.GET)
//    public String indexSaleAreaChartAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber,String yearMonth){
//        String[] yearMonths = DateUtil.getBeginMonth(yearMonth,11);
//        List<String> quotaNames = new ArrayList<>();
//        quotaNames.add("XSFX-QDFX-WY");//销售分析-渠道分析
//        JSONObject json = pastureReportService.getarea(companyNumber,yearMonths[0],yearMonths[1],quotaNames);
//        //orgCode参数
//        return json.toString();
//    }

    /**
     * createUser 倪鑫 to 2018-1-4
     * 销售渠道分析chart数据
     * @param companyNumber 公司编码
     * @param yearMonth
     * @return
     */

    @RequestMapping(value="/saleComparisonAjax",method = RequestMethod.GET)
    @ResponseBody
    public String SaleAreaChartAjax(String companyNumber,String yearMonth){
        String[] yearMonths = DateUtil.getBeginMonth(yearMonth,11);
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("XSFX-QDFX-WY");//销售分析-商超部
        quotaNames.add("XSFX-QDFX-SQ");//销售分析-社区分析
        quotaNames.add("XSFX-QDFX-TQ");//销售分析-特渠部
        quotaNames.add("XSFX-QDFX-XSK");//销售分析-学生奶客户
        quotaNames.add("XSFX-QDFX-JX");//销售分析-咸阳办事处
        quotaNames.add("XSFX-QDFX-QT");//销售分析-其他
        JSONObject json_a = pastureReportService.getarea(companyNumber,yearMonths[0],yearMonths[1],quotaNames);
        return json_a.toString();
    }

    @RequestMapping(value="/salesComparisonAjax",method = RequestMethod.GET)
    @ResponseBody
    public String salesComparisonAjax(String companyNumber,String yearsMonth){
        String[] yearMonths = DateUtil.getBeginMonth(yearsMonth,11);
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("XSFX-QDFX-WYE");//销售额分析-商超部
        quotaNames.add("XSFX-QDFX-SQE");//销售额分析-社区分析
        quotaNames.add("XSFX-QDFX-TQE");//销售额分析-特渠部
        quotaNames.add("XSFX-QDFX-XSKE");//销售额分析-学生奶客户
        quotaNames.add("XSFX-QDFX-JXE");//销售额分析-咸阳办事处
        quotaNames.add("XSFX-QDFX-QTE");//销售额分析-其他
        JSONObject json_a = pastureReportService.getarea(companyNumber,yearMonths[0],yearMonths[1],quotaNames);
        return json_a.toString();
    }

    @RequestMapping(value = "/saleComparisonAjaxday", method = RequestMethod.GET)
    @ResponseBody
    public String saleComparisonAjaxday(String companyNumber,String yearMonths) {
        String start = DateUtil.dateToDay(yearMonths);
        String startTime = start.substring(0,4)+start.substring(5,7)+start.substring(8,10);
        String endTime = yearMonths.substring(0,4)+yearMonths.substring(5,7)+yearMonths.substring(8,10);
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("XSFX-QDFX-WYMT");//销售分析-渠道分析
        quotaNames.add("XSFX-QDFX-SQMT");//销售分析-社区分析
        quotaNames.add("XSFX-QDFX-TQMT");//销售分析-特渠部
        quotaNames.add("XSFX-QDFX-XSKMT");//销售分析-学生奶客户
        quotaNames.add("XSFX-QDFX-JXMT");//销售分析-咸阳办事处
        quotaNames.add("XSFX-QDFX-QTMT");//销售分析-其他
        JSONObject json = this.pastureReportService.getareas(companyNumber, startTime, endTime, quotaNames);
        return json.toJSONString();
    }


    @RequestMapping(value = "/salesComparisonAjaxday", method = RequestMethod.GET)
    @ResponseBody
    public String salesComparisonAjaxday(String companyNumber,String yearsMonths) {
        String start = DateUtil.dateToDay(yearsMonths);
        String startTime = start.substring(0,4)+start.substring(5,7)+start.substring(8,10);
        String endTime = yearsMonths.substring(0,4)+yearsMonths.substring(5,7)+yearsMonths.substring(8,10);
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("XSFX-QDFX-WYEMT");//销售额分析-渠道分析
        quotaNames.add("XSFX-QDFX-SQEMT");//销售额分析-社区分析
        quotaNames.add("XSFX-QDFX-TQEMT");//销售额分析-特渠部
        quotaNames.add("XSFX-QDFX-XSKEMT");//销售额分析-学生奶客户
        quotaNames.add("XSFX-QDFX-JXEMT");//销售额分析-咸阳办事处
        quotaNames.add("XSFX-QDFX-QTEMT");//销售额分析-其他
        JSONObject json = this.pastureReportService.getareas(companyNumber, startTime, endTime, quotaNames);
        return json.toJSONString();
    }
    /**
     * createUser 杨北平   2018-1-10
     * 回款率charts数据
     * @param modelMap
     * @param companyNumber
     * @param company
     * @return
     */
    @RequestMapping(value = "/reimbursementRateAjax", method = RequestMethod.GET)
    @ResponseBody
    public String reimbursementRateAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String company,String yearMonths){
        String[] yearMontArr = DateUtil.getBeginMonth(yearMonths,12);
        List<String > quotaNames = new ArrayList<>();
        quotaNames.add("ZHZB-YSZK-WY-QM"); //期末应收账款
        //quotaNames.add("ZHZB-YSZK-WY-NC");  //年初应收账款
        quotaNames.add("ZHZB-YYSR-WY");   //本期营业收入
        List<Object> resultList = this.pastureReportService.queryReimbursementRate(company, yearMontArr[0], DateUtil.getBeginMonth(yearMonths,-1)[0], quotaNames);
        JSONObject json = new JSONObject();//组装返回页面的json
        json.put("resultList",resultList);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        return json.toJSONString();
    }

    /**
     * 按月查询品类分析数据
     * @param yearMonth
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryMonthData",method = RequestMethod.GET)
    public String queryMonthData(String yearMonth){
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("HSMRY-PLYXL");
        Map<String,Object> resultMap = this.pastureReportService.returnCategoryData("HSMRY",yearMonth,1,quotaNames,"month");
        quotaNames.set(0,"HSMRY-PLYXSE");
        Map<String,Object> amountMap = this.pastureReportService.returnCategoryData("HSMRY",yearMonth,1,quotaNames,"month");
        JSONObject json = new JSONObject();
        json.put("resultMap",resultMap);
        json.put("amountMap",amountMap);
        return json.toString();
    }

    /**
     * 按日查询品类分析数据
     * @param yearMonth
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryDayData",method = RequestMethod.GET)
    public String queryDayData(String yearMonth){
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("HSMRY-PLRXL");
        Map<String,Object> resultMap = this.pastureReportService.returnCategoryData("HSMRY",yearMonth,1,quotaNames,"day");
        quotaNames.set(0,"HSMRY-PLRXSE");
        Map<String,Object> amountMap = this.pastureReportService.returnCategoryData("HSMRY",yearMonth,1,quotaNames,"day");
        JSONObject json = new JSONObject();
        json.put("resultMap",resultMap);
        json.put("amountMap",amountMap);
        return json.toString();
    }


    /**
     * 销售看板chart销量数据
     * @param companyNumber
     * @param yearMonth
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/saleChartAjax",method = RequestMethod.GET)
    public String saleChartAjax(String companyNumber,String yearMonth,String company){
        String start = DateUtil.dateToDay(yearMonth);
        String startTime = start.substring(0,4)+start.substring(5,7)+start.substring(8,10);
        String endTime = yearMonth.substring(0,4)+yearMonth.substring(5,7)+yearMonth.substring(8,10);
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("HSMRY-XL-DWDTXL");//低温奶当日实际销量
        quotaNames.add("HSMRY-XL-CWDTXL");//常温奶当日实际销量
        quotaNames.add("HSMRY-XLE-XSDTXL");//学生奶当日实际销量
        JSONObject json_a = pastureReportService.getSaleChart(company,startTime,endTime,quotaNames);
        return json_a.toString();
    }
    /**
     * 销售看板chart销量额数据
     * @param companyNumber
     * @param yearMonths
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/saleChartsAjax",method = RequestMethod.GET)
    public String saleChartsAjax(String companyNumber,String yearMonths,String company){
        String start = DateUtil.dateToDay(yearMonths);
        String startTime = start.substring(0,4)+start.substring(5,7)+start.substring(8,10);
        String endTime = yearMonths.substring(0,4)+yearMonths.substring(5,7)+yearMonths.substring(8,10);
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("HSMRY-XLE-DWDTXS");//低温奶当日实际销售额
        quotaNames.add("HSMRY-XLE-CWDTXS");//常温奶当日实际销售额
        quotaNames.add("HSMRY-XLE-XSDTXS");//学生奶当日实际销售额
        JSONObject json_a = pastureReportService.getSaleChart(company,startTime,endTime,quotaNames);
        return json_a.toString();
    }
    /**
     * 销售看板chart每月销量数据
     * @param companyNumber
     * @param yearTime
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/saleChartMonthAjax",method = RequestMethod.GET)
    public String saleChartMonthAjax(String companyNumber,String yearTime,String company){
        String[] yearMontArr = DateUtil.getBeginMonth(yearTime,11);
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("PJRCNL-DWMYXL");//低温奶每月销量
        quotaNames.add("PJRCNL-CWMYXL");//常温奶每月销量
        quotaNames.add("PJRCNL-XSMYXL");//学生奶每月销量
        JSONObject json_a = pastureReportService.getSaleCharts(company,yearMontArr[0],yearMontArr[1],quotaNames);
        return json_a.toString();
    }
    /**
     * 销售看板chart每月销售额数据
     * @param companyNumber
     * @param yearTimes
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/saleMonthAjax",method = RequestMethod.GET)
    public String saleMonthAjax(String companyNumber,String yearTimes,String company){
        String[] yearMontArr = DateUtil.getBeginMonth(yearTimes,11);
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("PJRCNL-DWMYXSE");//低温奶每月销售额
        quotaNames.add("PJRCNL-CWMYXSE");//常温奶每月销售额
        quotaNames.add("PJRCNL-XSMYXSE");//学生奶每月销售额
        JSONObject json_a = pastureReportService.getSaleCharts(company,yearMontArr[0],yearMontArr[1],quotaNames);
        return json_a.toString();
    }
    /**
     * 乳制品销量明细-年度营收趋势图-charts数据
     * createUser：倪鑫 to 2017-11-19
     * @param modelMap
     * @param companyNumber
     * @return
     */
    @RequestMapping(value = "/zkgylAnalysisajax", method = RequestMethod.GET)
    @ResponseBody
    public String zkgylAnalysisajax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String company,String yearMonths){
        String[] yearMontArr = DateUtil.getBeginMonth(yearMonths,11);
        JSONObject json = new JSONObject();
        List<String > quotaNames_a = new ArrayList<>();
        quotaNames_a.add("PJRCNL-HSMRMYXSE");
        JSONObject json_a = pastureReportService.getSaleCharts(company,yearMontArr[0],yearMontArr[1],quotaNames_a);
        quotaNames_a.set(0,"ZKGYL-LSMYXLE");
        JSONObject json_b = pastureReportService.getSaleCharts("ZKGYL",yearMontArr[0],yearMontArr[1],quotaNames_a);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        json.put("HSMRY",json_a);
        json.put("ZKGYL",json_b);
        json.put("yearMonth",json_a.get("yearMonth"));
        return json.toString();
    }
    /**
     * 乳制品销量明细-年度营收趋势图-charts数据
     * createUser：倪鑫 to 2017-11-19
     * @param modelMap
     * @param companyNumber
     * @return
     */
    @RequestMapping(value = "/zkgyldayajax", method = RequestMethod.GET)
    @ResponseBody
    public String zkgyldayajax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String company,String selectTimes){
        String start = DateUtil.dateToDay(selectTimes);
        String startTime = start.substring(0,4)+start.substring(5,7)+start.substring(8,10);
        String endTime = selectTimes.substring(0,4)+selectTimes.substring(5,7)+selectTimes.substring(8,10);
        List<String > quotaNames_a = new ArrayList<>();
        JSONObject json = new JSONObject();
        quotaNames_a.add("PJRCNL-MTXSHSM");//华山牧乳业每日销售额
        JSONObject json_a = pastureReportService.getSaleChart(company,startTime,endTime,quotaNames_a);
        quotaNames_a.set(0,"ZKGYL-LSMTXLE");//零售与分销每天销量额
        JSONObject json_b = pastureReportService.getSaleChart("ZKGYL",startTime,endTime,quotaNames_a);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        json.put("HSMRY",json_a);
        json.put("ZKGYL",json_b);
        json.put("yearMonth",json_a.get("yearMonth"));
        return json.toString();
    }
    /**
     * 财务对比分析-共用
     * createUser：李沁壕 to 2017-11-24
     */
    @RequestMapping(value = "/Analysis", method = RequestMethod.GET)
    public void Analysis(ModelMap modelMap,
       @RequestParam(required = true) String companyNumber,
       @RequestParam(defaultValue = "") String company) {
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "");
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("company", company);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
    }
    /**
     * 首页-对比分析-产品成本对比charts数据
     * createUser 李沁壕 to 2017-11-15
     * @param modelMap
     * @param companyNumber 公司编码
     * @param companyName 公司名称
     * @return 结果集
     */
    @ResponseBody
    @RequestMapping(value="/productCostAjax",method = RequestMethod.GET)
    public String productCostAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, String companyName,String yearMonths){
        String layout_x = "parameter";//定义x轴的值类型 month(按月份排列) or parameter(按查询的参数排列)
        String layout_y = "sum";//定义x轴的值类型 sum(求和) or value(取值)

        //取得当前月份
//		Calendar cal = Calendar.getInstance();
//		int month = (cal.get(Calendar.MONTH)==0?12:cal.get(Calendar.MONTH));
//        String[] yearMonths = DateUtil.getBeginEndYearMonth(1);

        //华山牧乳业、天友乳业
        List<String> quotaNames_a = new ArrayList<>();
        quotaNames_a.add("CPCB-ZJCL-WY-NPJ");//直接材料
        quotaNames_a.add("CPCB-ZJRG-WY-NPJ");//直接人工
        quotaNames_a.add("CPCB-NYDL-WY-NPJ");//能源动力
        quotaNames_a.add("CPCB-ZZFY-WY-NPJ");//制造费用

        quotaNames_a.add("CPCB-XSFY-WY");//销售费用
        quotaNames_a.add("CPCB-GLFY-WY");//管理费用
        quotaNames_a.add("CPCB-CWFY-WY");//财务费用
        JSONObject json_a = this.pastureReportService.getJsonObject("HSMRY", yearMonths, yearMonths, quotaNames_a,layout_x,layout_y);
        JSONObject json_b = this.pastureReportService.getJsonObject("TYRY", yearMonths, yearMonths, quotaNames_a,layout_x,layout_y);
        String[] yearMonth1 = DateUtil.getBeginEndYearMonth(1);
        List<String> quotaNames_c = new ArrayList<>();
        //JSONObject json_d = this.pastureReportService.getJsonObject("TYRY", yearMonth1[0], yearMonth1[1], quotaNames_c,layout_x,layout_y);
        //JSONObject json_e = this.pastureReportService.getJsonObject("HSMRY", yearMonth1[0], yearMonth1[1], quotaNames_c,layout_x,layout_y);
        //光明乳业
        List<String> quotaNames_b = new ArrayList<>();
        quotaNames_b.add("DB_SCCB_ZJCL_CB");
        quotaNames_b.add("DB_SCCB_ZJRG_CB");
        quotaNames_b.add("DB_SCCB_NYDL_CB");
        quotaNames_b.add("DB_SCCB_ZZFY_CB");
        quotaNames_b.add("DB_QJFY_XSFY_CB");
        quotaNames_b.add("DB_QJFY_GLFY_CB");
        quotaNames_b.add("DB_QJFY_CWFY_CB");

        JSONObject json_c = this.pastureReportService.getJsonObjectOfGMRY(yearMonths, yearMonths, quotaNames_b,layout_x,layout_y);
        JSONObject json = new JSONObject();//组装返回页面的json
        json.put("axisx",json_a.get("axisx"));
        //json.put("axisx1",json_d.get("axisx"));
        json.put("HSMRY",json_a.get("axisy"));
        //json.put("HSMRY1",json_e.get("axisy"));
        json.put("TYRY",json_b.get("axisy"));
        //json.put("TYRY1",json_d.get("axisy"));
        json.put("GMRY",json_c.get("axisy"));
        //json.put("month",month);
        modelMap.put(Constants.Token.COMPANY_NUMBER, companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        return json.toString();
    }

    /**
     * 首页-对比分析-财务评价指标charts数据
     * createUser 李沁壕 to 2017-11-15
     * @param modelMap
     * @param companyNumber 公司编码
     * @param companyName 公司名称
     * @return 结果集
     */
    @ResponseBody
    @RequestMapping(value="/financialEvaluationAjax",method = RequestMethod.GET)
    public String financialEvaluationAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, String companyName){
        String layout_x = "parameter";//定义x轴的值类型 month(按月份排列) or parameter(按查询的参数排列)
        String layout_y = "sum";//定义x轴的值类型 sum(求和) or value(取值)

        //取得当前月份
        Calendar cal = Calendar.getInstance();
        int month = (cal.get(Calendar.MONTH)==0?12:cal.get(Calendar.MONTH));
        String[] yearMonths = DateUtil.getBeginEndYearMonth(month);
        List<String> quotaNames_a = new ArrayList<>();
        quotaNames_a.add("ZHZB-ZCFZL");
        quotaNames_a.add("ZHZB-SDBL");
        quotaNames_a.add("ZHZB-LDBL");
        quotaNames_a.add("ZHZB-YSZKZZL");
        quotaNames_a.add("ZHZB-XSMLL");
        quotaNames_a.add("ZHZB-YYLRL");
        quotaNames_a.add("ZHZB-CBFYLRL");
        quotaNames_a.add("ZHZB-QJFYL");
        quotaNames_a.add("ZHZB-ZCZZL");
        quotaNames_a.add("ZHZB-XSZZL");
        quotaNames_a.add("ZHZB-LRZZL");

        //获取图表中一条折线数据
        JSONObject json_a = this.pastureReportService.queryFinancialEvaluationIndex(yearMonths[0].substring(0,4),quotaNames_a);

        List<String> quotaNames_b = new ArrayList<>();
        quotaNames_b.add("DB_CZX_ZCZZL_BFB");
        quotaNames_b.add("DB_ZCNL_ZCFZL_BFB");
        quotaNames_b.add("DB_ZCNL_LDBL_BFB");
        quotaNames_b.add("DB_YLNL_CBFYLRL_BFB");
        quotaNames_b.add("DB_YLNL_QJFYL_BFB");
        quotaNames_b.add("DB_ZCNL_YSZKZZL_BFB");
        quotaNames_b.add("DB_CZX_LRZZL_BFB");
        quotaNames_b.add("DB_ZCNL_SDBL_BFB");
        quotaNames_b.add("DB_CZX_XSMLL_BFB");
        quotaNames_b.add("DB_YLNL_XSMLL_BFB");
        quotaNames_b.add("DB_YLNL_YSLL_BFB");

        //获取图表中一条折线数据
        JSONObject json_b = this.pastureReportService.getJsonObjectOfGMRY(yearMonths[0], yearMonths[1], quotaNames_b,layout_x,layout_y);

        JSONObject json = new JSONObject(new LinkedHashMap());//组装返回页面的json
        json.put("ZKRY",json_a);
        json.put("GMRY",json_b.get("axisy"));
        json.put("axisx",json_b.get("axisx"));
        modelMap.put(Constants.Token.COMPANY_NUMBER, companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        return json.toString();
    }

    @RequestMapping(value = "/queryAccountsReceivable",method = RequestMethod.GET)
    @ResponseBody
    public String queryAccountsReceivable(String companyNumber,String company,String yearMonth){
        List<BigDecimal> headIdList = mainService.selectHeadId(company,yearMonth);
        JSONObject json = new JSONObject();
        if (headIdList.size()>0){
            List<TAccountsReceivable> resultList = this.receivableService.queryByExmple(headIdList);
            json.put("resultList",resultList);
        }else {
            List<TAccountsReceivable> resultList = receivableService.fillNull();
            json.put("resultList",resultList);
        }
        return json.toString();
    }

}
