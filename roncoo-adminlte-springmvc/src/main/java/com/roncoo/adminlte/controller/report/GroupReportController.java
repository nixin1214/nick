package com.roncoo.adminlte.controller.report;

import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.TDailyReport;
import com.roncoo.adminlte.service.PastureReportService;
import com.roncoo.adminlte.service.TDailyReportService;
import com.roncoo.adminlte.service.TSysUserLogsService;
import com.roncoo.adminlte.util.DateUtil;
import com.roncoo.adminlte.util.base.BaseController;
import org.jsoup.helper.DataUtil;
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
 * @Description: 集团报表控制器
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/5 21:54
 */
@Controller
@RequestMapping(value = "report/groupReport")
public class GroupReportController extends BaseController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PastureReportService pastureReportService;
    @Autowired
    private TSysUserLogsService userLogsService;

    @Autowired
    private TDailyReportService tDailyReportService;
    /**
     * yearMontArr 得到已经过去12个月的第一个月和最后一个月
     */
    //private String[] yearMontArr = DateUtil.getBeginEndYearMonth(12);

    /**
     * 资产总额明细
     * @param companyNumber
     */
    @RequestMapping(value = "/totalAssetsDetail", method = RequestMethod.GET)
    public void totalAssetsDetail(ModelMap modelMap, @RequestParam(required = true) String companyNumber) {
        String[] yearMonts = DateUtil.getBeginEndYearMonth(1);
        String layout_x = "parameter";//定义x轴的值类型 month(按月份排列) or parameter(按查询的参数排列)
        String layout_y = "sum";//定义x轴的值类型 sum(求和) or value(取值)
        String orgCode = null;
        List<String > quotaNames = new ArrayList<>();
        quotaNames.add("ZHZB-HBZJ-WY");
        quotaNames.add("ZHZB-YSZK-WY-QM");
        quotaNames.add("ZHZB-CH-WY");
        quotaNames.add("ZHZB-GDZC-WY");
        JSONObject json = this.pastureReportService.getJsonChart(orgCode, yearMonts[0], yearMonts[0], quotaNames, layout_x, layout_y);
        modelMap.put("resultData", json.get("axisy"));
        modelMap.put("beginTime", json.get("beginTime"));
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "资产总额明细");
    }

    /**
     * 营业收入明细
     * @param companyNumber
     */
    @RequestMapping(value = "/businessIncomeDetail", method = RequestMethod.GET)
    public void businessIncomeDetail(ModelMap modelMap, @RequestParam(required = true) String companyNumber) {
        String[] yearMonts = DateUtil.getBeginEndYearMonth(1);
        String layout_x = "parameter";//定义x轴的值类型 month(按月份排列) or parameter(按查询的参数排列)
        String layout_y = "sum";//定义x轴的值类型 sum(求和) or value(取值)
        List<String > quotaNames = new ArrayList<>();
        quotaNames.add("ZHZB-YYSR-WY");
        JSONObject json_a = this.pastureReportService.getJsonChart("TYRY", yearMonts[0], yearMonts[0], quotaNames, layout_x, layout_y);
        JSONObject json_b = this.pastureReportService.getJsonChart("HSMRY", yearMonts[0], yearMonts[0], quotaNames, layout_x, layout_y);
        JSONObject json_c = this.pastureReportService.getJsonChart("TNMC", yearMonts[0], yearMonts[0], quotaNames, layout_x, layout_y);
        JSONObject json_d = this.pastureReportService.getJsonChart("HSMC", yearMonts[0], yearMonts[0], quotaNames, layout_x, layout_y);
        modelMap.put("TYRY", json_a.get("axisy"));
        modelMap.put("HSMRY", json_b.get("axisy"));
        modelMap.put("TNMC", json_c.get("axisy"));
        modelMap.put("HSMC", json_d.get("axisy"));
        modelMap.put("beginTime", json_a.get("beginTime"));
        modelMap.put("startTime", json_b.get("beginTime"));
        modelMap.put("endTime", json_c.get("beginTime"));
        modelMap.put("overTime", json_d.get("beginTime"));
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "资产总额明细");
    }

    /**
     * 乳制品销量明品细
     * @param companyNumber
     */
    @RequestMapping(value = "/dairySalesDetail", method = RequestMethod.GET)
    public void dairySalesDetail(ModelMap modelMap, @RequestParam(required = true) String companyNumber) {
        String[] yearMonts = DateUtil.getBeginEndYearMonth(1);
        String layout_x = "parameter";//定义x轴的值类型 month(按月份排列) or parameter(按查询的参数排列)
        String layout_y = "sum";//定义x轴的值类型 sum(求和) or value(取值)
        List<String > quotaNames = new ArrayList<>();
        quotaNames.add("XLFX-DWNXL-QK");
        quotaNames.add("XLFX-CWNXL-QK");
        quotaNames.add("XLFX-NFXL-QK");
        JSONObject json_a = this.pastureReportService.getJsonChart("TYRY", yearMonts[0], yearMonts[0], quotaNames, layout_x, layout_y);
        JSONObject json_b = this.pastureReportService.getJsonChart("HSMRY", yearMonts[0], yearMonts[0], quotaNames, layout_x, layout_y);
        modelMap.put("resultData", json_a.get("axisy"));
        modelMap.put("result",json_b.get("axisy"));
        modelMap.put("beginTime", json_a.get("beginTime"));
        modelMap.put("endTime", json_b.get("beginTime"));
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "乳制器销量明细");
    }

    /**
     * 应收账款明细
     * @param companyNumber
     */
    @RequestMapping(value = "/accountsReceivableDetail", method = RequestMethod.GET)
    public void accountsReceivableDetail(ModelMap modelMap, @RequestParam(required = true) String companyNumber) {
        String[] yearMonth = DateUtil.getBeginEndYearMonth(2);//取前2个月
        String orgCode = null;
        List<String > quotaNames = new ArrayList<>();
        quotaNames.add("ZHZB-YSZK-WY-QM");  //期末应收账款
        quotaNames.add("ZHZB-YSZK-WY-NC");  //年初应收账款
        quotaNames.add("ZHZB-YSZK-WY-SN");  //上年本月应收账款
        quotaNames.add("ZHZB-YYSR-WY");   //本期营业收入
        List<Object> resultList = this.pastureReportService.queryReimbursement(orgCode, yearMonth[0], yearMonth[1], quotaNames);
        String[] lastMonth = DateUtil.getBeginMonth(((ArrayList<String>)resultList.get(1)).get(1),12);
        modelMap.put("resultData",resultList.get(0));
        modelMap.put("lastMonth",lastMonth[0]);
        modelMap.put("result",resultList.get(1));
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "应收账款明细");
    }

    /**
     * 应收账款12个月走势明细
     * @param companyNumber
     */
    @ResponseBody
    @RequestMapping(value = "/reimbursementRateAjax", method = RequestMethod.GET)
    public String reimbursementRateAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber,String yearMonths) {
        //String[] yearMonth = DateUtil.getBeginEndYearMonth(2);
        String[] lastYearMonth = DateUtil.getBeginMonth(yearMonths,12);
        String orgCode = null;
        List<String > quotaNames = new ArrayList<>();
        quotaNames.add("ZHZB-YSZK-WY-QM");  //期末应收账款
        quotaNames.add("ZHZB-YYSR-WY");   //本期营业收入
        List<Object> resultList = this.pastureReportService.queryReimbursementRate(orgCode, lastYearMonth[0], DateUtil.getBeginMonth(yearMonths,-1)[0], quotaNames);
        JSONObject json = new JSONObject();//组装返回页面的json
        json.put("resultList",resultList);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        return json.toJSONString();
    }

    /**
     * 生鲜奶产量明细
     * @param companyNumber
     */
    @RequestMapping(value = "/milkYieldDetail", method = RequestMethod.GET)
    public void milkYieldDetail(ModelMap modelMap, @RequestParam(required = true) String companyNumber) {
        List<String > quotaNames = new ArrayList<>();
        quotaNames.add("PJRCNL-QN");//月总产奶量
        quotaNames.add("PJRCNL-CRN-MT");//成乳牛平均日产奶量
        quotaNames.add("PJRCNL-MRN-MT");//泌乳牛平均日产奶量
        quotaNames.add("NQJG-MT-MRN");//泌乳牛头数
        String[] yearMonth = DateUtil.getStartEndYearMonth(1);
        JSONObject json_a = this.pastureReportService.getJsonMilkCharts("TNMC", yearMonth[0], yearMonth[0], quotaNames);
        JSONObject json_b =this.pastureReportService.getJsonMilkCharts("HSMC", yearMonth[0], yearMonth[0], quotaNames);
        modelMap.put("resultData",json_a.get("resultList"));
        modelMap.put("result",json_b.get("resultList"));
        modelMap.put("beginTime", json_a.get("beginTime"));
        modelMap.put("endTime", json_b.get("beginTime"));
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "生鲜奶产量明细");
    }

    /**
     * 牛群结构明细
     * @param companyNumber
     */
    @RequestMapping(value = "/cattleDetail", method = RequestMethod.GET)
    public void cattleDetail(ModelMap modelMap, @RequestParam(required = true) String companyNumber) {
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "牛群结构明细");
    }

    /**
     * 乳制品销量明细-年度营收趋势图-charts数据
     * createUser：李沁壕 to 2017-11-15
     * @param modelMap
     * @param companyNumber
     * @param companyName
     * @return
     */
    @RequestMapping(value = "/revenueTrendsAjax", method = RequestMethod.GET)
    @ResponseBody
    public String revenueTrendsAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String companyName,String yearMonths){
        String[] yearMontArr = DateUtil.getBeginMonth(yearMonths,11);
        String layout_x = "month";//定义x轴的值类型 month(按月份排列) or parameter(按查询的参数排列)
        String layout_y = "sum";//定义x轴的值类型 sum(求和) or value(取值)
        String orgCode = null;
        List<String > quotaNames_a = new ArrayList<>();
        quotaNames_a.add("XSJEFX-DWNXSE-WY");
        JSONObject json_a = this.pastureReportService.getJsonObject(orgCode, yearMontArr[0], yearMontArr[1], quotaNames_a, layout_x, layout_y);

        List<String > quotaNames_b = new ArrayList<>();
        quotaNames_b.add("XSJEFX-CWNXSE-WY");
        JSONObject json_b = this.pastureReportService.getJsonObject(orgCode, yearMontArr[0], yearMontArr[1], quotaNames_b, layout_x, layout_y);

        List<String > quotaNames_c = new ArrayList<>();
        quotaNames_c.add("XSJEFX-NFXSE-WY");
        JSONObject json_c = this.pastureReportService.getJsonObject(orgCode, yearMontArr[0], yearMontArr[1], quotaNames_c, layout_x, layout_y);

        JSONObject json = new JSONObject();//组装返回页面的json
        json.put("axisx",json_a.get("axisx"));
        json.put("DWN",json_a.get("axisy"));
        json.put("CWN",json_b.get("axisy"));
        json.put("GTNF",json_c.get("axisy"));

        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        return json.toJSONString();
    }

    /**
     * 乳制品销量明细-分公司销量对比-营收趋势图-charts数据
     * createUser：李沁壕 to 2017-11-17
     * @param modelMap
     * @param companyNumber
     * @param companyName
     * @return
     */
    @RequestMapping(value = "/salesComparisonAjax", method = RequestMethod.GET)
    @ResponseBody
    public String salesComparisonAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String companyName, @RequestParam(value = "yearMonth") String yearMonth){
        String layout_x = "parameter";//定义x轴的值类型 month(按月份排列) or parameter(按查询的参数排列)
        String layout_y = "value";//定义x轴的值类型 sum(求和) or value(取值)
        List<String > quotaNames = new ArrayList<>();
        quotaNames.add("XLFX-DWNXL-QK");
        quotaNames.add("XLFX-CWNXL-QK");
        quotaNames.add("XLFX-NFXL-QK");
        quotaNames.add("HZB-RZPXL-QKZ");
        JSONObject json_a = this.pastureReportService.getJsonObject("TYRY", yearMonth, yearMonth, quotaNames, layout_x, layout_y);
        JSONObject json_b = this.pastureReportService.getJsonObject("HSMRY", yearMonth, yearMonth, quotaNames, layout_x, layout_y);
        JSONObject json_c = this.pastureReportService.getJsonObject("ZKRY", yearMonth, yearMonth, quotaNames, layout_x, layout_y);

        JSONObject json = new JSONObject();//组装返回页面的json
        json.put("axisx",json_a.get("axisx"));
        json.put("TYRY",json_a.get("axisy"));
        json.put("HSMRY",json_b.get("axisy"));
        json.put("ZKRY",json_c.get("axisy"));

        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        return json.toJSONString();
    }

    /**
     * 资产总额明细-资产总额走势图-charts数据
     * createUser：李沁壕 to 2017-11-17
     * @param modelMap
     * @param companyNumber
     * @param companyName
     * @return
     */
    @RequestMapping(value = "/assetsTrendAjax", method = RequestMethod.GET)
    @ResponseBody
    public String assetsTrendAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String companyName,String yearMonths){
        String[] yearMontArr = DateUtil.getBeginMonth(yearMonths,11);
        String layout_x = "month";//定义x轴的值类型 month(按月份排列) or parameter(按查询的参数排列)
        String layout_y = "sum";//定义x轴的值类型 sum(求和) or value(取值)
        String orgCode = null;
        List<String > quotaNames_a = new ArrayList<>();
        quotaNames_a.add("ZHZB-HBZJ-WY");
        JSONObject json_a = this.pastureReportService.getJsonObject(orgCode, yearMontArr[0], yearMontArr[1], quotaNames_a, layout_x, layout_y);

        List<String > quotaNames_b = new ArrayList<>();
        quotaNames_b.add("ZHZB-YSZK-WY-QM");
        JSONObject json_b = this.pastureReportService.getJsonObject(orgCode, yearMontArr[0], yearMontArr[1], quotaNames_b, layout_x, layout_y);

        List<String > quotaNames_c = new ArrayList<>();
        quotaNames_c.add("ZHZB-CH-WY");
        JSONObject json_c = this.pastureReportService.getJsonObject(orgCode, yearMontArr[0], yearMontArr[1], quotaNames_c, layout_x, layout_y);

        List<String > quotaNames_d = new ArrayList<>();
        quotaNames_d.add("ZHZB-GDZC-WY");
        JSONObject json_d = this.pastureReportService.getJsonObject(orgCode, yearMontArr[0], yearMontArr[1], quotaNames_d, layout_x, layout_y);

        JSONObject json = new JSONObject();//组装返回页面的json
        json.put("axisx",json_a.get("axisx"));
        json.put("HBJJ",json_a.get("axisy"));
        json.put("YSZK",json_b.get("axisy"));
        json.put("CH",json_c.get("axisy"));
        json.put("GDZC",json_d.get("axisy"));
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        return json.toJSONString();
    }

    /**
     * 资产总额明细-资产对比图-charts数据
     * createUser：李沁壕 to 2017-11-17
     * @param modelMap
     * @param companyNumber
     * @param companyName
     * @return
     */
    @RequestMapping(value = "/assetsComparisonAjax", method = RequestMethod.GET)
    @ResponseBody
    public String assetsComparisonAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String companyName, @RequestParam(value = "yearMonth") String yearMonth){
        String layout_x = "parameter";//定义x轴的值类型 month(按月份排列) or parameter(按查询的参数排列)
        String layout_y = "sum";//定义x轴的值类型 sum(求和) or value(取值)
        List<String > quotaNames = new ArrayList<>();
        quotaNames.add("ZHZB-HBZJ-WY");
        quotaNames.add("ZHZB-YSZK-WY-QM");
        quotaNames.add("ZHZB-CH-WY");
        quotaNames.add("ZHZB-GDZC-WY");
        quotaNames.add("ZHZB-ZCZE-WY");

        JSONObject json_a = this.pastureReportService.getJsonObject("TYRY", yearMonth, yearMonth, quotaNames, layout_x, layout_y);
        JSONObject json_b = this.pastureReportService.getJsonObject("HSMRY", yearMonth, yearMonth, quotaNames, layout_x, layout_y);
        JSONObject json_c = this.pastureReportService.getJsonObject("TNMC", yearMonth, yearMonth, quotaNames, layout_x, layout_y);
        JSONObject json_d = this.pastureReportService.getJsonObject("HSMC", yearMonth, yearMonth, quotaNames, layout_x, layout_y);
        JSONObject json_e = this.pastureReportService.getJsonObject("ZKGYL", yearMonth, yearMonth, quotaNames, layout_x, layout_y);
        JSONObject json_f = this.pastureReportService.getJsonObject("THMY", yearMonth, yearMonth, quotaNames, layout_x, layout_y);

        JSONObject json = new JSONObject();//组装返回页面的json
        json.put("axisx",json_a.get("axisx"));
        json.put("TYRY",json_a.get("axisy"));
        json.put("HSMRY",json_b.get("axisy"));
        json.put("TNMC",json_c.get("axisy"));
        json.put("HSMC",json_d.get("axisy"));
        json.put("ZKGYL",json_e.get("axisy"));
        json.put("THMY",json_f.get("axisy"));
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        System.out.println(json.toJSONString());
        return json.toJSONString();
    }

    /**
     * 营业收入明细-资产对比图-charts数据
     * createUser：江林 to 2017-12-26
     * @param modelMap
     * @param companyNumber
     * @return
     */
    @RequestMapping(value = "/businessIncomeDetailAjax", method = RequestMethod.GET)
    @ResponseBody
    public String businessIncomeDetailAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, String yearMonth){
        String layout_x = "parameter";//定义x轴的值类型 month(按月份排列) or parameter(按查询的参数排列)
        String layout_y = "value";//定义x轴的值类型 sum(求和) or value(取值)
        if("".equals(yearMonth)||yearMonth==null){
            String[] thisyearMont = DateUtil.getBeginEndYearMonth(1);
            yearMonth= thisyearMont[0];
        }
        List<String > quotaNames = new ArrayList<>();
        quotaNames.add("ZHZB-ZYYWCB-WY");
        quotaNames.add("ZHZB-ZYYWJSR-WY");

        JSONObject json_a = this.pastureReportService.getJsonObject("TYRY", yearMonth, yearMonth, quotaNames, layout_x, layout_y);
        JSONObject json_b = this.pastureReportService.getJsonObject("HSMRY", yearMonth, yearMonth, quotaNames, layout_x, layout_y);
        JSONObject json_c = this.pastureReportService.getJsonObject("TNMC", yearMonth, yearMonth, quotaNames, layout_x, layout_y);
        JSONObject json_d = this.pastureReportService.getJsonObject("HSMC", yearMonth, yearMonth, quotaNames, layout_x, layout_y);
        JSONObject json_e = this.pastureReportService.getJsonObject("ZKGYL", yearMonth, yearMonth, quotaNames, layout_x, layout_y);
        JSONObject json_f = this.pastureReportService.getJsonObject("THMY", yearMonth, yearMonth, quotaNames, layout_x, layout_y);

        JSONObject json = new JSONObject();//组装返回页面的json
        json.put("axisx",json_a.get("axisx"));
        json.put("TYRY",json_a.get("axisy"));
        json.put("HSMRY",json_b.get("axisy"));
        json.put("TNMC",json_c.get("axisy"));
        json.put("HSMC",json_d.get("axisy"));
        json.put("ZKGYL",json_e.get("axisy"));
        json.put("THMY",json_f.get("axisy"));
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        System.out.println(json.toJSONString());
        return json.toJSONString();
    }





    /**
     * 资产总额明细-资产分布图-charts数据
     * createUser：李沁壕 to 2017-11-17
     * @param modelMap
     * @param companyNumber
     * @param companyName
     * @return
     */
    @RequestMapping(value = "/assetsDistributionAjax", method = RequestMethod.GET)
    @ResponseBody
    public String assetsDistributionAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String companyName, @RequestParam(value = "yearMonth") String yearMonth){
        String layout_x = "parameter";//定义x轴的值类型 month(按月份排列) or parameter(按查询的参数排列)
        String layout_y = "value";//定义x轴的值类型 sum(求和) or value(取值)
        List<String > quotaNames = new ArrayList<>();
        quotaNames.add("ZHZB-ZCZE-WY");

        JSONObject json_a = this.pastureReportService.getJsonObject("TYRY", yearMonth, yearMonth, quotaNames, layout_x, layout_y);
        JSONObject json_b = this.pastureReportService.getJsonObject("HSMRY", yearMonth, yearMonth, quotaNames, layout_x, layout_y);
        JSONObject json_c = this.pastureReportService.getJsonObject("TNMC", yearMonth, yearMonth, quotaNames, layout_x, layout_y);
        JSONObject json_d = this.pastureReportService.getJsonObject("HSMC", yearMonth, yearMonth, quotaNames, layout_x, layout_y);
        JSONObject json_e = this.pastureReportService.getJsonObject("ZKGYL", yearMonth, yearMonth, quotaNames, layout_x, layout_y);

        JSONObject json = new JSONObject();//组装返回页面的json
        json.put("axisx",json_a.get("axisx"));
        json.put("TYRY",json_a.get("axisy"));
        json.put("HSMRY",json_b.get("axisy"));
        json.put("TNMC",json_c.get("axisy"));
        json.put("HSMC",json_d.get("axisy"));
        json.put("ZKGYL",json_e.get("axisy"));
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        return json.toJSONString();
    }

    /**
     * 营业收入明细-获取年度营收趋势图-charts数据
     * createUser：李沁壕 to 2017-11-17
     * @param modelMap
     * @param companyNumber
     * @param companyName
     * @return
     */
    @RequestMapping(value = "/annualRevenueTrendsAjax", method = RequestMethod.GET)
    @ResponseBody
    public String annualRevenueTrendsAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String companyName,String yearMonthone){
        String[] yearMontArr = DateUtil.getBeginMonth(yearMonthone,11);
        String layout_x = "month";//定义x轴的值类型 month(按月份排列) or parameter(按查询的参数排列)
        String layout_y = "sum";//定义x轴的值类型 sum(求和) or value(取值)
        String orgCode = null;
        List<String > quotaNames_a = new ArrayList<>();
        quotaNames_a.add("ZHZB-YYSR-WY");
        JSONObject json_a = this.pastureReportService.getJsonObject(orgCode, yearMontArr[0], yearMontArr[1], quotaNames_a, layout_x, layout_y);

        List<String > quotaNames_b = new ArrayList<>();
        quotaNames_b.add("ZHZB-YYSR-YSMB-WY");
        JSONObject json_b = this.pastureReportService.getJsonObject(orgCode, yearMontArr[0], yearMontArr[1], quotaNames_b, layout_x, layout_y);

        List<String > quotaNames_c = new ArrayList<>();
        quotaNames_c.add("ZHZB-YYSR-BQSN-WY");
        JSONObject json_c = this.pastureReportService.getJsonObject(orgCode, yearMontArr[0], yearMontArr[1], quotaNames_c, layout_x, layout_y);

        JSONObject json = new JSONObject();//组装返回页面的json
        json.put("axisx",json_a.get("axisx"));
        json.put("YYSR",json_a.get("axisy"));
        json.put("YYSRYS",json_b.get("axisy"));
        json.put("YYSRBQSN",json_c.get("axisy"));
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
        String layout_y = "sum";//定义x轴的值类型 sum(求和) or value(取值)
        String orgCode = null;
        List<String > quotaNames = new ArrayList<>();
        quotaNames.add("ZHZB-YYSR-BNLJ-WY");
        quotaNames.add("ZHZB-YYSR-BQSN-LJ");
        JSONObject json_a = this.pastureReportService.getJsonObject(orgCode, yearMonthone, yearMonthone, quotaNames, layout_x, layout_y);
        JSONObject json = new JSONObject();//组装返回页面的json
        json.put("axisx",json_a.get("axisx"));
        json.put("resultList",json_a.get("axisy"));
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        return json.toJSONString();
    }
    /**
     * 应收账款明细-近12个月应收账款图-charts数据
     * createUser：李沁壕 to 2017-11-18
     * @param modelMap
     * @param companyNumber
     * @param companyName
     * @return
     */
    @RequestMapping(value = "/accountsReceivableAjax", method = RequestMethod.GET)
    @ResponseBody
    public String accountsReceivableAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String companyName,String yearMonth){
        String[] yearMontArr = DateUtil.getBeginMonth(yearMonth,11);
        String layout_x = "month";//定义x轴的值类型 month(按月份排列) or parameter(按查询的参数排列)
        String layout_y = "value";//定义x轴的值类型 sum(求和) or value(取值)
        List<String > quotaNames = new ArrayList<>();
        quotaNames.add("ZHZB-YSZK-WY-QM");
        JSONObject json_a = this.pastureReportService.getJsonObject("TYRY", yearMontArr[0], yearMontArr[1], quotaNames, layout_x, layout_y);
        JSONObject json_b = this.pastureReportService.getJsonObject("HSMRY", yearMontArr[0], yearMontArr[1], quotaNames, layout_x, layout_y);
        JSONObject json_c = this.pastureReportService.getJsonObject("TNMC", yearMontArr[0], yearMontArr[1], quotaNames, layout_x, layout_y);
        JSONObject json_d = this.pastureReportService.getJsonObject("HSMC", yearMontArr[0], yearMontArr[1], quotaNames, layout_x, layout_y);
        JSONObject json_e = this.pastureReportService.getJsonObject("ZKGYL", yearMontArr[0], yearMontArr[1], quotaNames, layout_x, layout_y);
        JSONObject json_f = this.pastureReportService.getJsonObject("THMY", yearMontArr[0], yearMontArr[1], quotaNames, layout_x, layout_y);
        JSONObject json = new JSONObject();//组装返回页面的json
        json.put("axisx",json_a.get("axisx"));
        json.put("TYRY",json_a.get("axisy"));
        json.put("HSMRY",json_b.get("axisy"));
        json.put("TNMC",json_c.get("axisy"));
        json.put("HSMC",json_d.get("axisy"));
        json.put("ZKGYL",json_e.get("axisy"));
        json.put("THMY",json_f.get("axisy"));
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        return json.toJSONString();
    }

    /**
     * 生鲜奶产量明细-产量走势对比图-charts数据
     * createUser：李沁壕 to 2017-11-18
     * @param modelMap
     * @param companyNumber
     * @param companyName
     * @return
     */
    @RequestMapping(value = "/yieldTrendAjax", method = RequestMethod.GET)
    @ResponseBody
    public String yieldTrendAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String companyName,String yearMonths){
        String[] yearMontArr = DateUtil.getBeginMonth(yearMonths,11);
        List<String > quotaNames = new ArrayList<>();
        quotaNames.add("PJRCNL-QK");
        JSONObject json_a = this.pastureReportService.getSaleCharts("TNMC", yearMontArr[0], yearMontArr[1], quotaNames);
        JSONObject json_b = this.pastureReportService.getSaleCharts("HSMC", yearMontArr[0], yearMontArr[1], quotaNames);
        JSONObject json = new JSONObject();//组装返回页面的json
        json.put("axisx",json_a.get("yearMonth"));
        json.put("TNMC",json_a.get("PJRCNL-QK"));
        json.put("HSMC",json_b.get("PJRCNL-QK"));
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        return json.toJSONString();
    }

    /**
     * 牛群结构明细-牛群结构图-charts数据
     * createUser：李沁壕 to 2017-11-18
     * @param modelMap
     * @param companyNumber
     * @param companyName
     * @return
     */
    @RequestMapping(value = "/herdStructureAjax", method = RequestMethod.GET)
    @ResponseBody
    public String herdStructureAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String companyName,String yearMonths){
//        String[] yearMonts = DateUtil.getBeginEndYearMonth(1);
        String layout_x = "parameter";//定义x轴的值类型 month(按月份排列) or parameter(按查询的参数排列)
        String layout_y = "sum";//定义x轴的值类型 sum(求和) or value(取值)
        List<String > quotaNames = new ArrayList<>();
        quotaNames.add("NQJG-GD-TS");
        quotaNames.add("NQJG-MD-TS");
        quotaNames.add("NQJG-QNN-TS");
        quotaNames.add("NQJG-GNN-TS");
        quotaNames.add("NQJG-MRN-TS");
        quotaNames.add("NQJG-YCN-MY");
        JSONObject json_a = this.pastureReportService.getJsonObject("TNMC", yearMonths, yearMonths, quotaNames, layout_x, layout_y);
        JSONObject json_b = this.pastureReportService.getJsonObject("HSMC", yearMonths, yearMonths, quotaNames, layout_x, layout_y);
        JSONObject json = new JSONObject();//组装返回页面的json
        json.put("axisx",json_a.get("axisx"));
        json.put("TNMC",json_a.get("axisy"));
        json.put("HSMC",json_b.get("axisy"));
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        return json.toJSONString();
    }

    /**
     * 牛群结构明细-牛群结构变动情况图-charts数据
     * createUser：李沁壕 to 2017-11-18
     * @param modelMap
     * @param companyNumber
     * @param companyName
     * @return
     */
    @RequestMapping(value = "/herdStructureChangeAjax", method = RequestMethod.GET)
    @ResponseBody
    public String herdStructureChangeAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String companyName,String yearMonth){
        String[] yearMontArr = DateUtil.getBeginMonth(yearMonth,11);
        String layout_x = "month";//定义x轴的值类型 month(按月份排列) or parameter(按查询的参数排列)
        String layout_y = "sum";//定义x轴的值类型 sum(求和) or value(取值)
        String orgCode = null;

        List<String > quotaNames_a = new ArrayList<>();
        quotaNames_a.add("NQJG-14M-QNN-TS");
        JSONObject json_a = this.pastureReportService.getJsonObject(orgCode, yearMontArr[0], yearMontArr[1], quotaNames_a, layout_x, layout_y);

        List<String > quotaNames_b = new ArrayList<>();
        quotaNames_b.add("NQJG-14M-WPZ-TS");
        JSONObject json_b = this.pastureReportService.getJsonObject(orgCode, yearMontArr[0], yearMontArr[1], quotaNames_b, layout_x, layout_y);

        List<String > quotaNames_c = new ArrayList<>();
        quotaNames_c.add("NQJG-14M-YPZWHY-TS");
        JSONObject json_c = this.pastureReportService.getJsonObject(orgCode, yearMontArr[0], yearMontArr[1], quotaNames_c, layout_x, layout_y);

        List<String > quotaNames_d = new ArrayList<>();
        quotaNames_d.add("NQJG-14M-WHY14YYSQNN-TS");
        JSONObject json_d = this.pastureReportService.getJsonObject(orgCode, yearMontArr[0], yearMontArr[1], quotaNames_d, layout_x, layout_y);

        List<String > quotaNames_e = new ArrayList<>();
        quotaNames_e.add("ZHZB-CRNTS-TS");
        JSONObject json_e = this.pastureReportService.getJsonObject(orgCode, yearMontArr[0], yearMontArr[1], quotaNames_e, layout_x, layout_y);

        List<String > quotaNames_f = new ArrayList<>();
        quotaNames_f.add("NQJG-CRN-SLWPZ-TS");
        JSONObject json_f = this.pastureReportService.getJsonObject(orgCode, yearMontArr[0], yearMontArr[1], quotaNames_f, layout_x, layout_y);

        List<String > quotaNames_g = new ArrayList<>();
        quotaNames_g.add("NQJG-CRN-YPZWHY-TS");
        JSONObject json_g = this.pastureReportService.getJsonObject(orgCode, yearMontArr[0], yearMontArr[1], quotaNames_g, layout_x, layout_y);

        List<String > quotaNames_h = new ArrayList<>();
        quotaNames_h.add("NQJG-CRN-SNWPZ-TS");
        JSONObject json_h = this.pastureReportService.getJsonObject(orgCode, yearMontArr[0], yearMontArr[1], quotaNames_h, layout_x, layout_y);

        JSONObject json = new JSONObject();//组装返回页面的json
        json.put("axisx",json_a.get("axisx"));
        json.put("NQJG-14M-QNN-TS",json_a.get("axisy"));
        json.put("NQJG-14M-WPZ-TS",json_b.get("axisy"));
        json.put("NQJG-14M-YPZWHY-TS",json_c.get("axisy"));
        json.put("NQJG-14M-WHY14YYSQNN-TS",json_d.get("axisy"));
        json.put("ZHZB-CRNTS-TS",json_e.get("axisy"));
        json.put("NQJG-CRN-SLWPZ-TS",json_f.get("axisy"));
        json.put("NQJG-CRN-YPZWHY-TS",json_g.get("axisy"));
        json.put("NQJG-CRN-SNWPZ-TS",json_h.get("axisy"));

        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        return json.toJSONString();
    }



    /**
     * 牧场每日产销量
     * @param companyNumber
     */
    @RequestMapping(value = "/pastureDailyYield", method = RequestMethod.GET)
    public void pastureDailyYield(ModelMap modelMap, @RequestParam(required = true) String companyNumber) {
        String[] yearMonth = DateUtil.getStartEndYearMonth(1);
        List<String > quotaNames = new ArrayList<>();
        quotaNames.add("PJRCNL-QN");//每日产奶量
        quotaNames.add("PJRCNL-XL");//每日销售量
        Map<String, Object>  resultlist = this.pastureReportService.getProductionData("TNMC",yearMonth[0],yearMonth[0],quotaNames);
        Map<String, Object>  resultlists = this.pastureReportService.getProductionData("HSMC",yearMonth[0],yearMonth[0],quotaNames);
        List<String > quotaName = new ArrayList<>();
        quotaName.add("PJRCNL-XSL");//当月销售量
        quotaName.add("PJRCNL-QP");//当月产奶量
        quotaName.add("PJRCNL-RJCN");//当月预算日均产奶总量
        quotaName.add("PJRCNL-RJXL");//当月预算日均销售量
        quotaName.add("PJRCNL-BYCN");//本月预算产奶总量
        quotaName.add("PJRCNL-BYXL");//本月预算销售量

        String[] yearMonths = DateUtil.getNextMonth(1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar1 = Calendar.getInstance();
        Date date1 = calendar1.getTime();
        String nowdays = sdf.format(date1);//当前时间
        String firstday = DateUtil.datefirstDay();//获取本月第一天
        String endday = DateUtil.dateDays();//本月26号
        String starttime = DateUtil.dateDay();//获取上个月26号
        long day = DateUtil.getDaySub(firstday,endday);//本月第一天至本月26号的天数
        long days = DateUtil.getDaySub(firstday,nowdays);//本月第一天至当前时间的天数
        long startday = DateUtil.getDaySub(endday,nowdays);;//得到本月25号到当前时间的天数
        long bothtime = DateUtil.getDaySub(starttime,nowdays);//上个月26号至现在的时间
        String month = nowdays.substring(5,7);
        long nowday;
        Map<String, Object>  result;
        Map<String, Object>  data;
        if(days>day&&!month.equals("12")){
             nowday = startday-1;
             result = this.pastureReportService.getProductionChart("TNMC",yearMonths[0],yearMonths[0],quotaName);
             data = this.pastureReportService.getProductionChart("HSMC",yearMonths[0],yearMonths[0],quotaName);
        }else if(days<day&&month.equals("01")){
            nowday = days;
            result = this.pastureReportService.getProductionChart("TNMC",yearMonths[1],yearMonths[1],quotaName);
            data = this.pastureReportService.getProductionChart("HSMC",yearMonths[1],yearMonths[1],quotaName);
        }
        else {
            nowday = bothtime-1;
            result = this.pastureReportService.getProductionChart("TNMC",yearMonths[1],yearMonths[1],quotaName);
            data = this.pastureReportService.getProductionChart("HSMC",yearMonths[1],yearMonths[1],quotaName);
        }
        modelMap.put("yearMonth", yearMonth[0]);
        modelMap.put("nowday", nowday);
        modelMap.put("resultlists", resultlists);
        modelMap.put("data", data);
        modelMap.put("resultlist", resultlist);
        modelMap.put("result", result);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "牛群结构明细");
    }



    /**
     * 乳业每日产销量
     * @param companyNumber
     */
    @RequestMapping(value = "/milkDailyYield", method = RequestMethod.GET)
    public void milkDailyYield(ModelMap modelMap, @RequestParam(required = true) String companyNumber) {
        List<String> quotaNames = new ArrayList<>();
        //查询销量数据
        quotaNames.add("HSMRY-XL-DWDTXL");//低温奶当日实际销量
        quotaNames.add("HSMRY-XL-DWXLRJ");//低温奶销量-累计日均
        quotaNames.add("HSMRY-XL-DWXLLJ");//低温奶销量-本月累计
        quotaNames.add("HSMRY-XL-CWDTXL");//常温奶当日实际销量
        quotaNames.add("HSMRY-XL-CWXLRJ");//常温奶销量-累计日均
        quotaNames.add("HSMRY-XL-CWXLLJ");//常温奶销量-本月累计
        quotaNames.add("HSMRY-XLE-XSDTXL");//学生奶当日实际销量
        quotaNames.add("HSMRY-XL-XSXLRJ");//学生奶销量-累计日均
        quotaNames.add("HSMRY-XL-XSXLLJ");//学生奶销量-本月累计
        //销量预算指标
        List<String> quotaNames1 = new ArrayList<>();
        quotaNames1.add("PJRCNL-BYSYDW");//本月预算商业奶低温
        quotaNames1.add("PJRCNL-BYSYCW");//本月预算商业奶常温
        quotaNames1.add("PJRCNL-BYSYXJ");//本月预算商业奶小计
        quotaNames1.add("PJRCNL-BYSYXSN");//本月预算学生奶
        quotaNames1.add("PJRCNL-BYSQSHJ");//本月预算全司合计
        quotaNames1.add("PJRCNL-BYSHSMR");//本月预算华山牧乳业
        quotaNames1.add("PJRCNL-BYSZKGY");//本月预算中垦供应链
        long days;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar1 = Calendar.getInstance();
        Date date1 = calendar1.getTime();
        String nowdays = sdf.format(date1);//当前时间
        List<Long> nowday =DateUtil.timeboolean();
        String month = nowdays.substring(5,7);
        Map<String,Object> resultMap = null;
        if(nowday.get(1)>nowday.get(0)&&!month.equals("12")){
            days = nowday.get(2)-1;
            resultMap = this.pastureReportService.queryDailyDatas("HSMRY",1,quotaNames,quotaNames1);
        }else if(month.equals("12")){
            days = nowday.get(4);
            resultMap = this.pastureReportService.queryDailyData("HSMRY",1,quotaNames,quotaNames1);
        }else if (nowday.get(1)<=nowday.get(0)&&month.equals("01")){
            days = nowday.get(0);
            resultMap = this.pastureReportService.queryDailyData("HSMRY",1,quotaNames,quotaNames1);
        }
        else{
            days = nowday.get(3);
            resultMap = this.pastureReportService.queryDailyData("HSMRY",1,quotaNames,quotaNames1);
        }

        //查询销售额数据
        quotaNames.set(0,"HSMRY-XLE-DWDTXS");//低温奶当日实际销售额
        quotaNames.set(1,"HSMRY-XSE-DWXSRJ");//低温奶销售额-累计日均
        quotaNames.set(2,"HSMRY-XSE-DWXSLJ");//低温奶销售额-本月累计
        quotaNames.set(3,"HSMRY-XLE-CWDTXS");//常温奶当日实际销售额
        quotaNames.set(4,"HSMRY-XSE-CWXSRJ");//常温奶销售额-累计日均
        quotaNames.set(5,"HSMRY-XSE-CWXSLJ");//常温奶销售额-本月累计
        quotaNames.set(6,"HSMRY-XLE-XSDTXS");//学生奶当日实际销售额
        quotaNames.set(7,"HSMRY-XSE-XSXSRJ");//学生奶销售额-累计日均
        quotaNames.set(8,"HSMRY-XSE-XSXSLJ");//学生奶销售额-本月累计
        //销售额预算指标
        quotaNames1.set(0,"BYDWNXSE-YS");//本月低温奶销售额预算
        quotaNames1.set(1,"BYCWNXSE-YS");//本月常温奶销售额预算
        quotaNames1.set(2,"BYSYNXSE-YS");//本月商业奶销售额预算
        quotaNames1.set(3,"BYXSNXSE-YS");//本月学生奶销售额预算
        quotaNames1.set(4,"BYQSXSEHJ-YS");//本月全司销售额合计预算
        quotaNames1.set(5,"BYHSMRYXSE-YS");//本月华山牧乳业销售额预算
        quotaNames1.set(6,"BYZKGYLXSE-YS");//本月中垦供应链销售额预算
        Map<String,Object> dataMap = null;
        if(nowday.get(1)>nowday.get(0)&&!month.equals("12")){
            days = nowday.get(2)-1;
            dataMap = this.pastureReportService.queryDailyDatas("HSMRY",1,quotaNames,quotaNames1);
        }else if(month.equals("12")) {
            days = nowday.get(4);
            dataMap = this.pastureReportService.queryDailyData("HSMRY",1,quotaNames,quotaNames1);
        }else if (nowday.get(1)<=nowday.get(0)&&month.equals("01")){
            days = nowday.get(0);
            dataMap = this.pastureReportService.queryDailyData("HSMRY", 1, quotaNames, quotaNames1);
        }
        else{
            days = nowday.get(3);
            dataMap = this.pastureReportService.queryDailyData("HSMRY",1,quotaNames,quotaNames1);
        }

        SimpleDateFormat sdfs = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar2 = Calendar.getInstance();
        Date date2 = calendar2.getTime();
        String nowtime = sdfs.format(date2);//当前时间


        List<BigDecimal> dis = new ArrayList<>();
        dis.add(new BigDecimal(22));
        dis.add(new BigDecimal(42));
        //查询中垦供应链数据
        List<TDailyReport> reportList = this.tDailyReportService.selectByExample(nowtime,new BigDecimal(0),dis);

        modelMap.put("yearMonth",dataMap.get("yearMonth"));
        modelMap.put("days",days);
        modelMap.put("reportList",reportList);
        modelMap.put("resultMap",resultMap.get("resultMap"));
        modelMap.put("dataMap",dataMap.get("resultMap"));
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "牛群结构明细");
    }
    /**
     * 中垦供应链每日产销量
     * @param companyNumber
     */
    @RequestMapping(value = "/supplylDailyYield", method = RequestMethod.GET)
    public void supplylDailyYield(ModelMap modelMap, @RequestParam(required = true) String companyNumber) {
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "牛群结构明细");
    }


}
