package com.roncoo.adminlte.controller.report;

/**
 * 牧场报表相关指标接口
 *
 * Created by Andrew on 2017-09-03.
 */

import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.Payrecord;
import com.roncoo.adminlte.bean.entity.TBusinessQuota;
import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.service.PastureReportService;
import com.roncoo.adminlte.service.PayrecordService;
import com.roncoo.adminlte.service.TSysUserLogsService;
import com.roncoo.adminlte.util.DateUtil;
import com.roncoo.adminlte.util.base.BaseController;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.PageBean;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 报表控制器
 *
 * @author andrew
 * @create 2017-09-03 15:58
 */
@Controller
@RequestMapping(value = "/report/pastureReport", method = RequestMethod.POST)
public class PastureReportController extends BaseController {


    @Autowired
    private PastureReportService pastureReportService;
    @Autowired
    private TSysUserLogsService userLogsService;
    @Autowired
    private PayrecordService payrecordService;

    /**
     *createUser:杨北平 to 2017-11-8
     * yearMontArr 得到已经过去12个月的第一个月和最后一个月
     */
    //modify begin 2017-11-9 杨北平 新增参数
    //private String[] yearMontArr = DateUtil.getBeginEndYearMonth(12);
    //modify end
    /**
     * 牛群结构分析表
     *
     * @param modelMap
     * @param companyNumber 公司编码
     */
    @RequestMapping(value = "/herdStructure", method = RequestMethod.GET)
    public void herdStructure(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String company) {
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "牛群结构分析表");
        modelMap.put("company",company);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
    }

    /**
     * 牛奶产量及理化指标
     *
     * @param modelMap
     * @param companyNumber 公司编码
     */
    @RequestMapping(value = "/yieldAndIndex", method = RequestMethod.GET)
    public void yieldAndIndex(ModelMap modelMap, @RequestParam(required = true) String companyNumber, String company) {
        String[] yearMontArr = DateUtil.getBeginEndYearMonth(1);
        String[] yearMonth = DateUtil.getBeginMonth(yearMontArr[1],11);
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "牛奶产量及理化指标");
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("PJRCNL-MRN-QK");//平均日产奶量-泌乳牛
        quotaNames.add("PJRCNL-CRN-QK");//平均日产奶量-成乳牛
        quotaNames.add("SYTR-MRN");//饲养头日数-泌乳牛
        quotaNames.add("SYTR-CRN");//饲养头日数-成乳牛
        quotaNames.add("PJRCNL-QK");//月总产奶量
        quotaNames.add("PJRCNL-PJMRTS-DAY");//平均泌乳天数
        Map<String,Object> resultData = pastureReportService.yieldTableData(company, yearMonth[0], yearMonth[1], quotaNames);
        modelMap.put("resultData",resultData);
        modelMap.put("company",company);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
    }

    /**
     * 平均每日饲料成本
     * createUser：李沁壕 to 2017-11-13
     * @param modelMap
     * @param companyNumber 公司编码
     */
    @RequestMapping(value = "/avgFeedCost", method = RequestMethod.GET)
    public void avgFeedCost(ModelMap modelMap, @RequestParam(required = true) String companyNumber, String companyName, String company) {
        String[] yearMontArr = DateUtil.getBeginEndYearMonth(12);
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "平均每日饲料成本");
        List<String > quotaNames = new ArrayList<>();
        quotaNames.add("PJMRSLCB-MRN");
        quotaNames.add("PJMRSLCB-GNN");
        quotaNames.add("PJMRSLCB-CRN");
        quotaNames.add("PJMRSLCB-QNN");
        quotaNames.add("PJMRSLCB-DN");
        quotaNames.add("SYTR-MRN");
        quotaNames.add("SYTR-GNN");
        quotaNames.add("SYTR-CRN");
        quotaNames.add("SYTR-QNN");
        quotaNames.add("SYTR-DN");
        quotaNames.add("YSLCB-MRN");
        quotaNames.add("YSLCB-GNN");
        quotaNames.add("YSLCB-CRN");
        quotaNames.add("YSLCB-QNN");
        quotaNames.add("YSLCB-DN");
        Map<String, Object> resultMap = pastureReportService.getAvgFeedCost(company, yearMontArr[0], yearMontArr[1], quotaNames);
        modelMap.put("resultData", resultMap);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("company", company);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
    }

    /**
     * 销售渠道
     *
     * @param modelMap
     * @param companyNumber
     */
    @RequestMapping(value = "/salesChannel", method = RequestMethod.GET)
    public void salesChannel(ModelMap modelMap, @RequestParam(required = true) String companyNumber) {
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "销售渠道");
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
    }

    /**
     * 犊牛损失率分析
     *
     * @param modelMap
     * @param companyNumber 公司编码
     */
    @RequestMapping(value = "/aclfLossRate", method = RequestMethod.GET)
    public void aclfLossRate(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String companyName, String company) {
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "犊牛损失率分析");
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("company", company);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
    }

    /**
     * 油料消耗页面跳转
     * createUser 杨北平 to 2017-12-4
     * @param modelMap
     * @param companyNumber 公司编码
     */
    @RequestMapping(value = "/oilConsumption", method = RequestMethod.GET)
    public void oilConsumption(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String companyName, String company) {
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "油料消耗表");
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("company", company);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
    }

    /**
     * 油料消耗表数据查询
     * createUser 杨北平 to 2017-12-4
     * @return
     */
    @ResponseBody
    @RequestMapping(value = PAGE,method = RequestMethod.POST)
    public PageBean<Payrecord> queryForPage(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "length", defaultValue = "10") int pageSize,@RequestParam(value = "finishTime", required = false) String finishTime,@RequestParam(value = "endTime", required = false) String endTime, @RequestParam(value = "orgCode", required = false) String orgCode, @RequestParam(value = "cardName", required = false) String cardName) {
        orgCode = StringUtils.isEmpty(orgCode) ? "all" : orgCode;
        finishTime = StringUtils.isEmpty(finishTime) ? "all" : finishTime;
        endTime = StringUtils.isEmpty(endTime)? "all" : endTime;
        cardName = StringUtils.isEmpty(cardName) ? "all" : cardName;

        Result<Page<Payrecord>> result = payrecordService.listForPage( (start / pageSize) + 1, pageSize,cardName,finishTime, orgCode,endTime);

        //记录操作日志
        userLogsService.addLog("浏览指标", getRequestPath(), "PC端", getClientIP(), "success", "", "油料消耗表");
            if(result.isStatus()){
            return new PageBean<Payrecord>(result.getResultData());
        }
        return new PageBean<Payrecord>();
    }

    /**
     * 成乳牛发病率分析
     *
     * @param modelMap
     * @param companyNumber 公司编码
     */
    @RequestMapping(value = "/dairyCowsMorbidity", method = RequestMethod.GET)
    public void dairyCowsMorbidity(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String companyName, String company) {
        String[] yearMontArr = DateUtil.getBeginEndYearMonth(11);
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "成乳牛发病率分析");
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("CRLFBL-TS");//成乳牛发病率-头数
        quotaNames.add("BQFX-CRNFBN-BFB");//成乳牛发病率-百分比
        Map<String, Object> resutlMap = pastureReportService.getOutCattleData(company, yearMontArr[0], yearMontArr[1], quotaNames);
        JSONObject json = this.pastureReportService.charData(company, yearMontArr[0], yearMontArr[1], quotaNames);
        modelMap.put("resultData", resutlMap);
        modelMap.put("fblData",json);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("company", company);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
    }

    /**
     * 成乳牛死淘分析
     *
     * @param modelMap
     * @param companyNumber 公司编码
     */
    @RequestMapping(value = "/dairyCowsClean", method = RequestMethod.GET)
    public void dairyCowsClean(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String company) {
        String[] yearMontArr = DateUtil.getBeginEndYearMonth(11);
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "成乳牛死淘分析");
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("CRLSTL-SW-TS");
        quotaNames.add("CRLSTL-TT-TS");
        Map<String, Object> resutlMap = pastureReportService.getOutCattleData(company, yearMontArr[0], yearMontArr[1], quotaNames);
        modelMap.put("resultData", resutlMap);
        modelMap.put("company",company);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
    }


    /**
     * 育成牛死淘分析
     *
     * @param modelMap
     * @param companyNumber 公司编码
     */
    @RequestMapping(value = "/cattleClean", method = RequestMethod.GET)
    public void cattleClean(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String company) {
        String[] yearMontArr = DateUtil.getBeginEndYearMonth(11);
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "育成牛死淘分析");
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("YCNSTL-SW-TS");
        quotaNames.add("YCNSTL-TT-TS");
        Map<String, Object> resutlMap = pastureReportService.getOutCattleData(company, yearMontArr[0], yearMontArr[1], quotaNames);
        modelMap.put("resultData", resutlMap);
        modelMap.put("company",company);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
    }


    /**
     * 犊牛死淘分析
     *
     * @param modelMap
     * @param companyNumber 公司编码
     */
    @RequestMapping(value = "/calfClean", method = RequestMethod.GET)
    public void calfClean(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String company) {
        String[] yearMontArr = DateUtil.getBeginEndYearMonth(11);
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "犊牛死淘分析");
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("DNSTL-SW-TS");
        quotaNames.add("DNSTL-TT-TS");
        Map<String, Object> resutlMap = pastureReportService.getOutCattleData(company, yearMontArr[0], yearMontArr[1], quotaNames);
        modelMap.put("resultData", resutlMap);
        modelMap.put("company",company);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
    }

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
     * 单位完全成本明细
     * @param companyNumber
     */
    @RequestMapping(value = "/unitTotalCostDetail", method = RequestMethod.GET)
    public void unitTotalCostDetail(ModelMap modelMap, @RequestParam(required = true) String companyNumber,String company) {
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "单位完全成本明细");
        String[] yearMont = DateUtil.getBeginEndYearMonth(1);
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("CPCB-ZJCL-WY");//材料成本
        quotaNames.add("CPCB-ZJRG-WY");//人工成本
        quotaNames.add("CPCB-ZZFY-WY");//制造成本
        quotaNames.add("CPCB-SCCBHJ-WY");//产品成本-生产成本合计
        JSONObject json = this.pastureReportService.unitCostChart(company,yearMont[0],quotaNames);
        modelMap.put("result",json);
        modelMap.put("beginTime", json.get("beginTime"));
        modelMap.put("company",company);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
    }

    /**
     * 生鲜奶产量明细
     * @param companyNumber
     */
    @RequestMapping(value = "/milkYieldDetail", method = RequestMethod.GET)
    public void milkYieldDetail(ModelMap modelMap, @RequestParam(required = true) String companyNumber) {
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "生鲜奶产量明细");
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
    }

    /**
     * 犊牛死淘chart数据
     *  createUser:杨北平 to 2017-11-8
     * @param modelMap
     * @param companyNumber
     * @param company
     * @return
     */
    @RequestMapping(value = "/calfCleanAjax", method = RequestMethod.GET)
    @ResponseBody
    public String calfCleanAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String company,String yearMonth) {
        String[] yearMontArr = DateUtil.getBeginMonth(yearMonth,11);
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("DNSTL-SW-TS");
        quotaNames.add("DNSTL-TT-TS");
        JSONObject json = this.pastureReportService.charData(company, yearMontArr[0], yearMontArr[1], quotaNames);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        return json.toJSONString();
    }
    /**
     * 每天犊牛死淘chart数据
     *  createUser:杨北平 to 2017-11-8
     * @param modelMap
     * @param companyNumber
     * @param company
     * @return
     */
    @RequestMapping(value = "/calfEveryAjax", method = RequestMethod.GET)
    @ResponseBody
    public String calfEveryAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String company,String yearMonths) {
        String start = DateUtil.dateToDay(yearMonths);
        String startTime = start.substring(0,4)+start.substring(5,7)+start.substring(8,10);
        String endTime = yearMonths.substring(0,4)+yearMonths.substring(5,7)+yearMonths.substring(8,10);
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("DNSTL-SW-TSMT");
        quotaNames.add("DNSTL-TT-TSMT");
        JSONObject json = this.pastureReportService.charEveryData(company, startTime,endTime, quotaNames);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        return json.toJSONString();
    }


    /**
     * 育成牛死淘chart数据
     *  createUser:杨北平 to 2017-11-8
     * @param modelMap
     * @param companyNumber
     * @param company
     * @return
     */
    @RequestMapping(value = "/cattleCleanAjax", method = RequestMethod.GET)
    @ResponseBody
    public String cattleCleanAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String company,String yearMonth) {
        String[] yearMontArr = DateUtil.getBeginMonth(yearMonth,11);
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("YCNSTL-SW-TS");
        quotaNames.add("YCNSTL-TT-TS");
        JSONObject json = this.pastureReportService.charData(company, yearMontArr[0], yearMontArr[1], quotaNames);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        return json.toJSONString();
    }
    /**
     * 每天育成牛死淘chart数据
     *  createUser:杨北平 to 2017-11-8
     * @param modelMap
     * @param companyNumber
     * @param company
     * @return
     */
    @RequestMapping(value = "/cattleEveryAjax", method = RequestMethod.GET)
    @ResponseBody
    public String cattleEveryAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String company,String yearMonths) {
        String start = DateUtil.dateToDay(yearMonths);
        String startTime = start.substring(0,4)+start.substring(5,7)+start.substring(8,10);
        String endTime = yearMonths.substring(0,4)+yearMonths.substring(5,7)+yearMonths.substring(8,10);
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("YCNSTL-SW-TSMT");
        quotaNames.add("YCNSTL-TT-TSMT");
        JSONObject json = this.pastureReportService.charEveryData(company,startTime,endTime, quotaNames);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        return json.toJSONString();
    }


    /**
     * 成乳牛死淘chart数据
     *  createUser:杨北平 to 2017-11-8
     * @param modelMap
     * @param companyNumber
     * @param company
     * @return
     */
    @RequestMapping(value = "/dairyCowsCleanAjax", method = RequestMethod.GET)
    @ResponseBody
    public String dairyCowsCleanAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String company,String yearMonth) {
        String[] yearMontArr = DateUtil.getBeginMonth(yearMonth,11);
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("CRLSTL-SW-TS");
        quotaNames.add("CRLSTL-TT-TS");
        JSONObject json = this.pastureReportService.charData(company, yearMontArr[0], yearMontArr[1], quotaNames);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        return json.toJSONString();
    }
    /**
     * 每天成乳牛死淘chart数据
     *  createUser:倪鑫 to 2017-11-8
     * @param modelMap
     * @param companyNumber
     * @param company
     * @return
     */
    @RequestMapping(value = "/dairyCowsEveryAjax", method = RequestMethod.GET)
    @ResponseBody
    public String dairyCowsEveryAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String company,String yearMonths) {
        String start = DateUtil.dateToDay(yearMonths);
        String startTime = start.substring(0,4)+start.substring(5,7)+start.substring(8,10);
        String endTime = yearMonths.substring(0,4)+yearMonths.substring(5,7)+yearMonths.substring(8,10);
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("CRLSTL-SW-TSMT");
        quotaNames.add("CRLSTL-TT-TSMT");
        JSONObject json = this.pastureReportService.charEveryData(company,startTime,endTime, quotaNames);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        return json.toJSONString();
    }

    /**
     * 成乳牛发病率chart数据
     *  createUser:杨北平 to 2017-11-8
     * @param company
     * @return
     */
    @RequestMapping(value = "/dairyCowsMorbidityAjax", method = RequestMethod.GET)
    @ResponseBody
    public String dairyCowsMorbidityAjax(@RequestParam(required = true) String company,String yearMonth) {
        String[] yearMontArr = DateUtil.getBeginMonth(yearMonth,11);
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("CRLFBL-TS");
        quotaNames.add("SYTR-CRN");

        JSONObject json = this.pastureReportService.charData(company, yearMontArr[0], yearMontArr[1], quotaNames);
        return json.toJSONString();
    }
    /**
     *每天成乳牛发病率chart数据
     *  createUser:杨北平 to 2017-11-8
     * @param company
     * @return
     */
    @RequestMapping(value = "/dairyEveryAjax", method = RequestMethod.GET)
    @ResponseBody
    public String dairyEveryAjax(@RequestParam(required = true) String company,String yearMonths) {
        String start = DateUtil.dateToDay(yearMonths);
        String startTime = start.substring(0,4)+start.substring(5,7)+start.substring(8,10);
        String endTime = yearMonths.substring(0,4)+yearMonths.substring(5,7)+yearMonths.substring(8,10);
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("CRLFBL-TSMT");
        quotaNames.add("SYTRMT-CRN");
        JSONObject json = this.pastureReportService.charEveryData(company, startTime, endTime, quotaNames);
        return json.toJSONString();
    }

    /**
     * 成乳牛发病率chart数据
     *  createUser:杨北平 to 2017-11-11
     * @param modelMap
     * @param companyNumber
     * @param company
     * @return
     */
    @RequestMapping(value = "/yieldAndIndexAjax", method = RequestMethod.GET)
    @ResponseBody
    public String yieldAndIndexAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String company,String yearMonth) {
        String[] yearMontArr = DateUtil.getBeginMonth(yearMonth,11);
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("PJRCNL-QK");
        quotaNames.add("NNZLZB-TXBHL");
        quotaNames.add("NNZLZB-WSWHL");
        JSONObject json = this.pastureReportService.yieldcharData(company, yearMontArr[0], yearMontArr[1], quotaNames);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("company",company);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        return json.toJSONString();
    }
    @RequestMapping(value = "/yieldAndIndexEveryAjax", method = RequestMethod.GET)
    @ResponseBody
    public String yieldAndIndexEveryAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String company,String yearMonths) {
        String start = DateUtil.dateToDay(yearMonths);
        String startTime = start.substring(0,4)+start.substring(5,7)+start.substring(8,10);
        String endTime = yearMonths.substring(0,4)+yearMonths.substring(5,7)+yearMonths.substring(8,10);
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("PJRCNL-QN");
        JSONObject json  = this.pastureReportService.getSaleChart(company,startTime,endTime,quotaNames);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("company",company);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        return json.toJSONString();
    }

    /**
     * 犊牛损失率分析
     *  createUser:杨北平 to 2017-11-11
     * @param company
     * @return
     */
    @RequestMapping(value = "/aclfLossRateAjax", method = RequestMethod.GET)
    @ResponseBody
    public String aclfLossRateAjax(@RequestParam(required = true)String company,String yearMonth) {
        String[] yearMontArr = DateUtil.getBeginMonth(yearMonth,11);
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("DNSSL-PZCG5CWHY-TS");//配种超过5次仍未受孕头数
        quotaNames.add("DNSSL-DTTTCRN-TS");//带胎淘汰成乳牛数
        quotaNames.add("DNSSL-BYLC-TS");//本月流产牛头数
        JSONObject json = this.pastureReportService.calfLossRateData(company, yearMontArr[0], yearMontArr[1], quotaNames);
        return json.toJSONString();
    }
    /**
     * 每天犊牛损失率分析
     *  createUser:杨北平 to 2017-11-11
     * @param company
     * @return
     */
    @RequestMapping(value = "/aclfLossRateAjaxEveryAjax", method = RequestMethod.GET)
    @ResponseBody
    public String aclfLossRateAjaxEveryAjax(@RequestParam(required = true)String company,String yearMonths) {
        String start = DateUtil.dateToDay(yearMonths);
        String startTime = start.substring(0,4)+start.substring(5,7)+start.substring(8,10);
        String endTime = yearMonths.substring(0,4)+yearMonths.substring(5,7)+yearMonths.substring(8,10);
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("DNSSL-PZCG5CWMT-TS");//配种超过5次仍未受孕头数
        quotaNames.add("DNSSL-DTTTCMT-TS");//带胎淘汰成乳牛数
        quotaNames.add("DNSSL-BYMT-TS");//本月流产牛头数
        JSONObject json = this.pastureReportService.getSaleChart(company, startTime, endTime, quotaNames);
        return json.toJSONString();
    }

    /**
     * 牛群结构分析chart数据
     * createUser：李沁壕 to 2017-11-10
     * @param modelMap
     * @param companyNumber
     * @param company
     * @return
     */
    @RequestMapping(value = "/herdStructureAjax", method = RequestMethod.GET)
    @ResponseBody
    public String herdStructureAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String company,String yearMonth){
        String[] yearMont = DateUtil.getBeginMonth(yearMonth,11);
        List<String > quotaNames = new ArrayList<>();
        quotaNames.add("NQJG-GD-TS");
        quotaNames.add("NQJG-MD-TS");
        quotaNames.add("NQJG-QNN-TS");
        quotaNames.add("NQJG-GNN-TS");
        quotaNames.add("NQJG-MRN-TS");
        quotaNames.add("NQJG-YCN-MY");
        JSONObject json = this.pastureReportService.getCattleDataJSON(company, yearMont[0], yearMont[1], quotaNames);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        return json.toJSONString();
    }
    /**
     * 牛群结构分析chart数据
     * createUser：李沁壕 to 2017-11-10
     * @param modelMap
     * @param companyNumber
     * @param company
     * @return
     */
    @RequestMapping(value = "/herdStructureEveryAjax", method = RequestMethod.GET)
    @ResponseBody
    public String herdStructureEveryAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String company,String yearMonths){
        String start = DateUtil.dateToDay(yearMonths);
        List<String > quotaNames = new ArrayList<>();
        String startTime = start.substring(0,4)+start.substring(5,7)+start.substring(8,10);
        String endTime = yearMonths.substring(0,4)+yearMonths.substring(5,7)+yearMonths.substring(8,10);
        quotaNames.add("NQJG-MT-GD");
        quotaNames.add("NQJG-MT-MD");
        quotaNames.add("NQJG-MT-QNN");
        quotaNames.add("NQJG-MT-MRN");
        quotaNames.add("NQJG-MT-GNN");
        quotaNames.add("NQJG-MT-YCN");
        JSONObject json = this.pastureReportService.getSaleChart(company, startTime, endTime, quotaNames);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        return json.toJSONString();
    }

    /**
     * 平均饲料成本charts数据
     * createUser：李沁壕 to 2017-11-13
     * @param company
     * @return
     */
    @RequestMapping(value = "/avgFeedCostAjax", method = RequestMethod.GET)
    @ResponseBody
    public String avgFeedCostAjax(@RequestParam(required = true) String company,String yearMonth){
        String[] yearMontArr = DateUtil.getBeginMonth(yearMonth,11);
        List<String > quotaNames = new ArrayList<>();
//        quotaNames.add("YSLCB-MRN");
//        quotaNames.add("YSLCB-GNN");
//        quotaNames.add("YSLCB-CRN");
//        quotaNames.add("YSLCB-QNN");
//        quotaNames.add("YSLCB-DN");
        quotaNames.add("PJMRSLCB-MRN");
        quotaNames.add("PJMRSLCB-GNN");
        quotaNames.add("PJMRSLCB-CRN");
        quotaNames.add("PJMRSLCB-QNN");
        quotaNames.add("PJMRSLCB-DN");
        JSONObject json = this.pastureReportService.getAvgFeedCostJSON(company, yearMontArr[0], yearMontArr[1], quotaNames);
        return json.toJSONString();
    }


    /**
     * 单位完全成本明细
     * @param yearMonth
     */
    @RequestMapping(value = "/unitTotalCostDetailAjax", method = RequestMethod.GET)
    @ResponseBody
    public String unitTotalCostDetailAjax(String yearMonth,String companyNumber,Integer rowIndex) {
        //modify begin 2017-11-9 杨北平 新增参数
        String[] defaultMonth = DateUtil.getBeginEndYearMonth(1);
        if (yearMonth.isEmpty()){
            yearMonth = defaultMonth[0];
        }
        List<Integer> rowNum = new ArrayList<>();
        rowNum.add(rowIndex);
        JSONObject json = this.pastureReportService.searchCostData(companyNumber,yearMonth,rowNum);
        return json.toString();
    }

    /**
     * 年度成本走势图数据
     * createUser：杨北平 to 2017-11-17
     * @return
     */
    @RequestMapping(value = "/costTrendAjax", method = RequestMethod.GET)
    @ResponseBody
    public String costTrendAjax(String company,String yearMonths){
        String[] yearMontArr = DateUtil.getBeginMonth(yearMonths,11);
        List<String > quotaNames = new ArrayList<>();
        quotaNames.add("CPCB-ZJCL-WY");//材料成本
        quotaNames.add("CPCB-ZJRG-WY");//人工成本
        quotaNames.add("CPCB-ZZFY-WY");//制造成本
        JSONObject json = this.pastureReportService.getSaleCharts(company, yearMontArr[0], yearMontArr[1], quotaNames);
        return json.toJSONString();
    }

    /**
     * 年度营收趋势图
     * createUser：杨北平 to 2017-11-18
     */
    @RequestMapping(value = "/businessIncomeDetailAjax", method = RequestMethod.GET)
    @ResponseBody
    public String businessIncomeDetailAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, String company,String yearMonthone) {
        String[] yearMontArr = DateUtil.getBeginMonth(yearMonthone,11);
        //记录操作日志
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("ZHZB-YYSR-WY");//综合指标-主营业务成本
        quotaNames.add("ZHZB-YYSR-YSMB-WY");//综合指标-主营业务净收入
        quotaNames.add("ZHZB-YYSR-BQSN-WY");
        JSONObject json = this.pastureReportService.getSaleCharts(company, yearMontArr[0], yearMontArr[1], quotaNames);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        return json.toJSONString();
    }

    /**
     * 年度营收趋势图(营业利润)
     * createUser：江林 to 2017-12-28
     */
    @RequestMapping(value = "/operatingprofitAjax", method = RequestMethod.GET)
    @ResponseBody
    public String operatingprofitAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, String company,String yearMonthone) {
        String[] yearMontArr = DateUtil.getBeginMonth(yearMonthone,11);
        //记录操作日志
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("CW-YYLR");//营业利润营
        quotaNames.add("CW-YYLR-YS");//营业利润预算
        quotaNames.add("CW-YYLR-SN");//营业利润本期上年
        JSONObject json = this.pastureReportService.getSaleCharts(company, yearMontArr[0], yearMontArr[1], quotaNames);
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        return json.toJSONString();
    }




    /**
     * 年度营收趋势图
     * createUser：杨北平 to 2017-11-18
     */
    @RequestMapping(value = "/summaryDataAjax", method = RequestMethod.POST)
    @ResponseBody
    public String summaryDataAjax(ModelMap modelMap,String yearMonth,String companyNumber,int[] rowIndex) {
        String[] defaultMonth = DateUtil.getBeginEndYearMonth(1);
        if (yearMonth.isEmpty()){
            yearMonth = defaultMonth[0];
        }
           List<Integer> rowNums = new ArrayList<>();
        if (rowIndex.length>0){
            for (int row:rowIndex){
                rowNums.add(row);
            }
        }
        JSONObject json = this.pastureReportService.searchSummaryData(companyNumber,yearMonth,rowNums);
        return json.toJSONString();
    }

    /**
     * 财务指标页面-共用
     * createUser：李沁壕 to 2017-11-24
     */
    @RequestMapping(value = "/financialIndex", method = RequestMethod.GET)
    public void financialIndex(ModelMap modelMap,
       @RequestParam(required = true) String companyNumber,
       @RequestParam(defaultValue = "") String company,
       @RequestParam(required = true)String fNameEn,
       @RequestParam(required = true)String fNameZh,
       @RequestParam(required = true)String fNameYs,
       @RequestParam(required = true)String lastYearFNameEn) {
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "");
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("company", company);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        modelMap.put("fNameEn", fNameEn);
        modelMap.put("fNameYs", fNameYs);
        modelMap.put("fNameZh", fNameZh);
        modelMap.put("lastYearFNameEn", lastYearFNameEn);
    }

    /**
     * 财务指标趋势图
     * createUser：李沁壕 to 2017-11-24
     */
    @RequestMapping(value = "/financialIndexAjax", method = RequestMethod.GET)
    @ResponseBody
    public String financialIndexAjax(ModelMap modelMap,
        @RequestParam(required = true) String companyNumber,
        @RequestParam(required = true)String fNameEn,
        @RequestParam(required = true)String fNameYs,
        @RequestParam(required = true)String lastYearFNameEn,String yearMonthone) {

        String[] yearMontArr = DateUtil.getBeginMonth(yearMonthone,11);
        String layout_x = "month";//定义x轴的值类型 month(按月份排列) or parameter(按查询的参数排列)
        String layout_y = "value";//定义x轴的值类型 sum(求和) or value(取值)
        List<String> quotaNames_a = new ArrayList<>();
        quotaNames_a.add(fNameEn);

        JSONObject json_a = this.pastureReportService.getJsonObject(companyNumber, yearMontArr[0], yearMontArr[1], quotaNames_a,layout_x,layout_y);

        quotaNames_a.set(0,lastYearFNameEn);
        JSONObject json_b = this.pastureReportService.getJsonObject(companyNumber, yearMontArr[0], yearMontArr[1], quotaNames_a,layout_x,layout_y);
        quotaNames_a.set(0,fNameYs);
        JSONObject json_c = this.pastureReportService.getJsonObject(companyNumber, yearMontArr[0], yearMontArr[1], quotaNames_a,layout_x,layout_y);

        JSONObject json = new JSONObject();
        json.put("fNameEn",quotaNames_a);
        json.put("yearMonths",json_a.get("axisx"));
        json.put("BQFvalue",json_a.get("axisy"));//本期
        json.put("SNFvalue",json_b.get("axisy"));//上年
        json.put("YSFvalue",json_c.get("axisy"));//预算
        return json.toJSONString();
    }

    /**
     * 营业收入明细
     * @param companyNumber
     */
    @RequestMapping(value = "/operatingProfit", method = RequestMethod.GET)
    public void operatingProfit(ModelMap modelMap, @RequestParam(required = true) String companyNumber,String company) {
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "营业利润明细");
        String[] yearMonths = DateUtil.getBeginEndYearMonth(2);
        List<String> indexFnameEn = new ArrayList<>();
        indexFnameEn.add("CW-YYLR"); //本期营业利润
        indexFnameEn.add("CW-YYLR-BNLJ"); //本年累计营业利润
        indexFnameEn.add("CW-YYLR-SN"); //本期上年营业利润
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
     * 成乳牛发病率前5大病种chart数据
     *  createUser:杨北平 to 2018-01-18
     * @param company
     * @return
     */
    @RequestMapping(value = "/dairyCowsMorbidityFiveMaxAjax", method = RequestMethod.GET)
    @ResponseBody
    public String dairyCowsMorbidityFiveMaxAjax(@RequestParam(required = true) String company,String yearMonth) {
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("CRLFBL-TS");
        List<TBusinessQuota> resultList = pastureReportService.dairyCowsMorbidityFiveMaxAjax(company, yearMonth, yearMonth, quotaNames);
        JSONObject json = new JSONObject();
        json.put("resultList",resultList);
        return json.toJSONString();
    }
    /**
     * 每天成乳牛发病率前5大病种chart数据
     *  createUser:杨北平 to 2018-01-18
     * @param company
     * @return
     */
    @RequestMapping(value = "/dairyCowsMorbidityFiveMaxEveryAjax", method = RequestMethod.GET)
    @ResponseBody
    public String dairyCowsMorbidityFiveMaxEveryAjax(@RequestParam(required = true) String company,String yearMonths) {
        String startTime = yearMonths.substring(0,4)+yearMonths.substring(5,7)+yearMonths.substring(8,10);
        String endTime = yearMonths.substring(0,4)+yearMonths.substring(5,7)+yearMonths.substring(8,10);
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("CRLFBL-TSMT");
        List<TBusinessQuota> resultList = pastureReportService.dairyCowsMorbidityFiveMaxAjax(company, startTime, endTime, quotaNames);
        JSONObject json = new JSONObject();
        json.put("resultList",resultList);
        return json.toJSONString();
    }

    /**
     * 单位指标页面跳转
     * createUser 杨北平 to 2017-12-4
     * @param modelMap
     * @param companyNumber 公司编码
     */
    @RequestMapping(value = "/unitDataDisplay", method = RequestMethod.GET)
    public void unitDataDisplay(ModelMap modelMap, @RequestParam(required = true) String companyNumber, @RequestParam(defaultValue = "") String companyName, String company) {
        //记录操作日志
        userLogsService.addLog("浏览报表", getRequestPath(), "PC端", getClientIP(), "success", "", "油料消耗表");
        modelMap.put("companyNumber", companyNumber);
        modelMap.put("company", company);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
    }

    /**
     * 单牛产量走势图数据
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/singleCowYieldAjax", method = RequestMethod.GET)
    public String singleCowYieldAjax(String companyNumber,String yearMonth){
        String[] yearMonths = DateUtil.getBeginMonth(yearMonth,11);
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("PJRCNL-MRN-QK");
        JSONObject json_a = pastureReportService.getJsonObject(companyNumber,yearMonths[0],yearMonths[1],quotaNames,"month","value");
        quotaNames.set(0,"PJRCNL-CRN-QK");
        JSONObject json_b = pastureReportService.getJsonObject(companyNumber,yearMonths[0],yearMonths[1],quotaNames,"month","value");
        JSONObject json = new JSONObject();
        json.put("yearMonths",json_a.get("axisx"));
        json.put("MRN",json_a.get("axisy"));
        json.put("CRN",json_b.get("axisy"));
        return json.toString();
    }

    /**
     * 单位利润分析图数据
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/unitDataDisplayAjax", method = RequestMethod.GET)
    public String unitDataDisplayAjax(String companyNumber,String yearMonthone){
        String[] yearMonths = DateUtil.getBeginMonth(yearMonthone,11);
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("CW-YYLR");//利润总额
        quotaNames.add("ZHZB-CRNTS-TS");//成乳牛头数
        quotaNames.add("COUNT-EMPLOYEE");//员工人数
        quotaNames.add("ZHZB-ZYYWCB-WY");//主营业务成本
        quotaNames.add("PJRCNL-QK");//牛奶产量
        JSONObject json = pastureReportService.queryUnitData(companyNumber,yearMonths[0],yearMonths[1],quotaNames);
        return json.toString();
    }

}