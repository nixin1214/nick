package com.roncoo.adminlte.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.TBusinessQuota;
import com.roncoo.adminlte.service.PastureReportService;
import com.roncoo.adminlte.util.Constants;
import com.roncoo.adminlte.util.DateUtil;
import com.roncoo.adminlte.util.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * createUser 杨北平 to 2017-11-16
 * 乳业首页ajax查询
 */
@Controller
@RequestMapping(value = "/admin")
public class MilkIndexAjaxController {

    /**
     * 项目基础路径
     */
    @Value("#{configProperties['basePath']}")
    private String basePath;

    @Autowired
    private PastureReportService pastureReportService;

    //得到过去n个月的开始月份与结束月份
    //private String[] yearMontArr = DateUtil.getBeginEndYearMonth(12);

    /**
     * 乳业首页销售金额与销量分析
     * createUser 杨北平 to 2017-11-9
     * @param modelMap
     * @param companyNumber 公司编码
     * @return 结果集
     */
    @ResponseBody
    @RequestMapping(value="/indexSaleChartAjax",method = RequestMethod.GET)
    public String IndexSaleChartAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber,String yearMonth){
        String[] yearMont = DateUtil.getBeginMonth(yearMonth,11);
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("XSJEFX-DWNXSE-WY");//低温奶销售额
        quotaNames.add("XSJEFX-CWNXSE-WY");//常温奶销售额
        quotaNames.add("XSJEFX-NFXSE-WY");//奶粉销售额
        quotaNames.add("PJRCNL-XSMYXSE");//学生奶销售额
        quotaNames.add("XLFX-DWNXL-QK");//低温奶销量
        quotaNames.add("XLFX-CWNXL-QK");//常温奶销量
        quotaNames.add("XLFX-NFXL-QK");//奶粉销量
        quotaNames.add("PJRCNL-XSMYXL");//学生奶销量
        JSONObject json = this.pastureReportService.calfLossRateData(companyNumber, yearMont[0], yearMont[1], quotaNames);
        return json.toString();
    }

    /**
     * 乳业首页销售区域与销售渠道分析
     * createUser 杨北平 to 2017-11-9
     * @param modelMap
     * @param companyNumber 公司编码
     * @param companyName 公司名称
     * @return 结果集
     */
    @ResponseBody
    @RequestMapping(value="/indexSaleAreaChartAjax",method = RequestMethod.GET)
    public String indexSaleAreaChartAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, String companyName){
        //得到过去n个月的开始月份与结束月份
        String[] yearMont = DateUtil.getBeginEndYearMonth(1);
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("XSFX-QYFX-WY");//销售分析-区域分析
        quotaNames.add("XSFX-QDFX-WY");//销售分析-渠道分析
        //orgCode参数
        List<String> orgCodes = new ArrayList<>();
        orgCodes.add(companyNumber.toUpperCase());
        List<TBusinessQuota> resultList = this.pastureReportService.quotaData(orgCodes, yearMont[0],  quotaNames);
        JSONObject json = new JSONObject();
        json.put("resultList",resultList);
        modelMap.put(Constants.Token.COMPANY_NUMBER, companyNumber);
        modelMap.put("companyName", BaseController.COMPANY_CACHE.get(companyNumber).getFname());
        return json.toString();
    }

}
