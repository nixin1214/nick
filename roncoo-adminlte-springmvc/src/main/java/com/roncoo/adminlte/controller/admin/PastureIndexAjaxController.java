package com.roncoo.adminlte.controller.admin;


import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.service.PastureReportService;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin")
public class PastureIndexAjaxController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private PastureReportService pastureReportService;



    /**
     * 牧场首页产量分析图数据
     * createUser 杨北平 to 2017-11-9
     * @param modelMap
     * @param companyNumber 公司编码
     * @param companyName 公司名称
     * @return 结果集
     */
    @ResponseBody
    @RequestMapping(value="/pastueIndexYieldChartAjax",method = RequestMethod.GET)
    public String yieldChartData(ModelMap modelMap, @RequestParam(required = true) String companyNumber, String companyName,String yearMonths){
        String[] yearMont = DateUtil.getBeginMonth(yearMonths,11);
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("PJRCNL-CRN-QK");
        quotaNames.add("PJRCNL-QK");
        JSONObject json = this.pastureReportService.charData(companyNumber, yearMont[0], yearMont[1], quotaNames);
        modelMap.put(Constants.Token.COMPANY_NUMBER, companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        return json.toString();
    }


    /**
     * 牧场首页牛群结构分析图数据
     * createUser 杨北平 to 2017-11-9
     * @param modelMap
     * @param companyNumber 公司编码
     * @param companyName 公司名称
     * @return 结果集
     */
    @ResponseBody
    @RequestMapping(value="/structureChartAjax",method = RequestMethod.GET)
    public String structureChartData(ModelMap modelMap, @RequestParam(required = true) String companyNumber, String companyName,String yearMonths){
//        String[] yearMonts = DateUtil.getBeginEndYearMonth(1);
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("NQJG-GD-TS"); //牛群结构-公犊-头数
        quotaNames.add("NQJG-MD-TS"); //牛群结构-母犊-头数
        quotaNames.add("NQJG-QNN-TS"); //牛群结构-青年牛-头数
        quotaNames.add("NQJG-GNN-TS"); //牛群结构-干奶牛-头数
        quotaNames.add("NQJG-MRN-TS"); //牛群结构-泌乳牛-头数
        quotaNames.add("NQJG-YCN-MY"); //牛群结构-育成牛头数
        JSONObject json = this.pastureReportService.chartData(companyNumber.toUpperCase(), yearMonths, yearMonths, quotaNames);
        modelMap.put(Constants.Token.COMPANY_NUMBER, companyNumber);
        modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
        json.put("yearMonths",yearMonths);
        return json.toString();
    }


    /**
     * 牧场首页产量分析图数据
     * createUser 杨北平 to 2017-11-9
     * @param modelMap
     * @param companyNumber 公司编码
     * @param yearMonth 公司名称
     * @return 结果集
     */
    @ResponseBody
    @RequestMapping(value="/dailyYieldAjax",method = RequestMethod.GET)
    public String dailyYieldAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, String yearMonth){
            String start = DateUtil.dateToDay(yearMonth);
            String startTime = start.substring(0,4)+start.substring(5,7)+start.substring(8,10);
            String endTime = yearMonth.substring(0,4)+yearMonth.substring(5,7)+yearMonth.substring(8,10);
            List<String> quotaNames = new ArrayList<>();
            quotaNames.add("PJRCNL-QN");
            quotaNames.add("PJRCNL-XL");
            quotaNames.add("XLFX-XL");
            quotaNames.add("XLFX-XLE");
            JSONObject json  = this.pastureReportService.getSaleChart(companyNumber,startTime,endTime,quotaNames);
            return json.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/illnessAnalysisAjax",method = RequestMethod.POST)
    public String illnessAnalysisAjax(String yearMonth,String companyNumber){
        String yearMonthArr[] = DateUtil.getBeginMonth(yearMonth,1);
        //病情分析查询条件
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("BQFX-CRNFBN-BFB");//成乳牛发病率
        quotaNames.add("BQFX-YCNFBN-BFB");//育成牛发病率
        quotaNames.add("BQFX-DNFBN-BFB");//犊牛发病率
        quotaNames.add("BQFX-CRNSTN-BFB");//成乳牛死淘率
        quotaNames.add("BQFX-YCNSTN-BFB");//育成牛死淘率
        quotaNames.add("BQFX-DNSTN-BFB");//犊牛死淘率
        Map<String, List<BigDecimal>> structureData = this.pastureReportService.indexIll(companyNumber, yearMonthArr[0], yearMonthArr[1], quotaNames);
        JSONObject json = new JSONObject();
        json.put("structureData",structureData);
        json.put("beginYearMonth",yearMonthArr[0]);
        return json.toString();
    }


}
