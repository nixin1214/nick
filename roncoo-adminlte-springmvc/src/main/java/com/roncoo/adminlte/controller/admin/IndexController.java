/*
 * Copyright 2015-2016 RonCoo(http://www.roncoo.com) Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.roncoo.adminlte.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TBusinessQuota;
import com.roncoo.adminlte.bean.entity.TSysResource;
import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.biz.UserBiz;
import com.roncoo.adminlte.service.*;
import com.roncoo.adminlte.util.Base64Util;
import com.roncoo.adminlte.util.Constants;
import com.roncoo.adminlte.util.DateUtil;
import com.roncoo.adminlte.util.ResourceUtil;
import com.roncoo.adminlte.util.base.BaseController;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 登录功能
 *
 * @author wujing
 */
@Controller
@RequestMapping(value = "/admin")
public class IndexController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private UserBiz biz;
	@Autowired
	private UserService userService;
	@Autowired
	private SysRoleResourceService roleResourceService;
	@Autowired
	private SysResourceService resourceService;
	@Autowired
	private PastureReportService pastureReportService;
	@Autowired
	private TSysUserLogsService userLogsService;
	/**
	 * 项目基础路径
	 */
	@Value("#{configProperties['basePath']}")
	private String basePath;


	/**
	 * 进入首页
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void getIndex(ModelMap modelMap, HttpServletRequest request) {
		getBaseInfo(modelMap);
		userLogsService.addLog("浏览", getRequestPath(), "PC端", getClientIP(), "0", "", "进入首页");

		Result<List<TSysResource>> result = resourceService.list();
		if (result.isStatus()) {
			String html = getMenuHtml(result.getResultData());
			modelMap.put("menuHtml", StringUtils.isNotEmpty(html) ? html : "<ul><li>您无任何访问权限<li></ul>");
		}

	}

	public String getMenuHtml(List<TSysResource> allResource) {
		RcUser userno = (RcUser) SecurityUtils.getSubject().getSession().getAttribute(Constants.Token.USER_INFO);
		if (userno == null) {
			return null;
		}
		Result<List<TSysResource>> resourceResult = biz.getMyResources(userno.getId());
		if (resourceResult != null && resourceResult.isStatus()) {
			Map<Long, Long> resourceIds = new HashMap<>();
			for (TSysResource resource : resourceResult.getResultData()) {
				resourceIds.put(resource.getFid(), resource.getFparentId());
			}
			return ResourceUtil.getMenuDom(allResource, resourceIds, basePath);
		}
		return null;
	}

	/**
	 * 进入首页
	 */
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String postIndex(ModelMap modelMap) {
		return redirect("/admin/index");
	}

	/**
	 * 进入集团首页,获取综合指标数据
	 * updateUser：李沁壕 to 2017-11-15
	 */
	@RequestMapping(value = "/groupIndex", method = RequestMethod.GET)
	public void getGroupIndex(ModelMap modelMap) {

		//综合指标查询条件
		List<String> indexQuotaNames = new ArrayList<>();
		indexQuotaNames.add("ZHZB-ZCZE-WY");//综合指标-资产总额
		Map<String,Object> zcze = this.pastureReportService.getComprehensiveIndex(1,null,indexQuotaNames,"month");
		indexQuotaNames.set(0,"ZHZB-YYSR-WY");//综合指标-营业收入
		Map<String,Object> yysr = this.pastureReportService.getComprehensiveIndex(1,null,indexQuotaNames,"month");
		indexQuotaNames.set(0,"ZHZB-RZPXL-QK");//综合指标-乳制品销量
		Map<String,Object> rzpxl = this.pastureReportService.getComprehensiveIndex(1,null,indexQuotaNames,"month");
		indexQuotaNames.set(0,"ZHZB-YSZK-WY-QM");//综合指标-应收账款
		Map<String,Object> yszk = this.pastureReportService.getComprehensiveIndex(1,null,indexQuotaNames,"month");
		indexQuotaNames.set(0,"PJRCNL-QN");//综合指标-生鲜奶产量ZHZB-SXNCL-QK
		Map<String,Object> sxncl = this.pastureReportService.getComprehensiveIndex(-1,null,indexQuotaNames,"day");
		indexQuotaNames.set(0,"ZHZB-YYSR-BNLJ-WY");//营业收入累计
		Map<String,Object> yysrlj = this.pastureReportService.getComprehensiveIndex(1,null,indexQuotaNames,"month");
		indexQuotaNames.set(0,"ZHZB-RZPXL-LJ");//综合指标-乳制品销量-累计
		Map<String,Object> rzpxllj = this.pastureReportService.getComprehensiveIndex(1,null,indexQuotaNames,"month");
		indexQuotaNames.set(0,"NQJG-MT-MRN");//综合指标-泌乳牛头数
		indexQuotaNames.add("NQJG-MT-GNN");//综合指标-干奶牛头数
		Map<String,Object> crnts = this.pastureReportService.getComprehensiveIndex(-1,null,indexQuotaNames,"day");
		List<String> indexFnameEn = new ArrayList<>();
//		indexFnameEn.add("ZHZB-YYSR-WY");
//		indexFnameEn.add("ZHZB-YYSR-BQSN-WY");
//		Map<String,Object> lastData = this.pastureReportService.loopQueryData(2,1,null,indexFnameEn);
		List<String> quotaNames = new ArrayList<>();
		quotaNames.add("PJRCNL-QK");//综合指标-生鲜奶产量累计
		String[] yearMonths = DateUtil.getNextMonth(1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar1 = Calendar.getInstance();
		Date date1 = calendar1.getTime();
		String nowday = sdf.format(date1);//获取当前时间
		String firstday = DateUtil.datefirstDay();//获取本月1号
		String endday = DateUtil.dateDays();//获取本月25号
		long day = DateUtil.getDaySub(firstday,endday);//获取本月1号到25号的天数
		long days = DateUtil.getDaySub(firstday,nowday);//获取本月1号到当前时间的天数
		String month = nowday.substring(5,7);
		Map<String, Object>  sxncllj;
		if(days>day&&!month.equals("12")){
			sxncllj = this.pastureReportService.getSummilkChart(null,yearMonths[0],yearMonths[0],quotaNames);
		}else {
			sxncllj = this.pastureReportService.getSummilkChart(null,yearMonths[1],yearMonths[1],quotaNames);
		}
		modelMap.put("zcze",zcze);
		modelMap.put("yysr",yysr);
		modelMap.put("rzpxl",rzpxl);
		modelMap.put("yszk",yszk);
		modelMap.put("sxncl",sxncl);
		modelMap.put("sxncllj",sxncllj);
		modelMap.put("crnts",crnts);
		modelMap.put("yysrlj",yysrlj);
		modelMap.put("rzpxllj",rzpxllj);
//		modelMap.put("resultMap",lastData.get("resultMap"));
//		modelMap.put("yearMonths",lastData.get("yearMonth"));
	}

	/**
	 * 成员单位营收按月查询
	 * @param modelMap
	 * @param yearMonth
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/businessIncomeDetailAjax", method = RequestMethod.GET)
	public String  businessIncomeDetailAjax(ModelMap modelMap,String yearMonth) {
		List<String> indexFnameEn = new ArrayList<>();
		indexFnameEn.add("ZHZB-YYSR-WY");//营业收入本期
		indexFnameEn.add("ZHZB-YYSR-BQSN-WY");//营业收入本期上年
		indexFnameEn.add("ZHZB-YYSR-YSMB-WY");//营业收入预算
		String[] yearMonths = DateUtil.getBeginMonth(yearMonth,1);
		JSONObject json = new JSONObject();
		json = this.pastureReportService.RatioQuotaDatas(null,yearMonths[0],yearMonth, indexFnameEn);
		return json.toString();
	}

	/**
	 * 成员累计查询
	 * @param modelMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/businessIncomesum", method = RequestMethod.GET)
	public String  businessIncomesum(ModelMap modelMap,String companyNumber) {
		List<String> indexFnameEn = new ArrayList<>();
		indexFnameEn.add("ZHZB-YYSR-WY");//营业收入本期
		indexFnameEn.add("ZHZB-YYSR-BQSN-WY");//营业收入本期上年
		indexFnameEn.add("ZHZB-YYSR-YSMB-WY");//营业收入预算
		String[] yearMonths = DateUtil.getBeginEndYearyear(1);
		String[] yearMonth = DateUtil.getBeginEndYearyear(-1);
		JSONObject json = new JSONObject();
		json = this.pastureReportService.revenueRatios(null,yearMonth[0],yearMonths[0], indexFnameEn);
		return json.toString();
	}

	/**
	 * 成员单位营收按季度查询
	 * @param modelMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/businessIncomeAjax", method = RequestMethod.GET)
	public String  businessIncomeAjax(ModelMap modelMap,String security) {
		List<String> indexFnameEn = new ArrayList<>();
		List<String> yearMonths = new ArrayList<>();
		indexFnameEn.add("ZHZB-YYSR-WY");//营业收入本期
		indexFnameEn.add("ZHZB-YYSR-BQSN-WY");//营业收入本期上年
		indexFnameEn.add("ZHZB-YYSR-YSMB-WY");//营业收入预算
		String starttime  = DateUtil.getwysfx(security);
		yearMonths.add(starttime);
		yearMonths.add(security);
		JSONObject json = new JSONObject();
		json = this.pastureReportService.revenuequarter(null,yearMonths, indexFnameEn);
		return json.toString();

	}
	/**
	 * 本月销量前五按月查询
	 * @param modelMap
	 * @param yearMonths
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/productSales", method = RequestMethod.GET)
	public String  productSales(ModelMap modelMap,String yearMonths,String companyNumber,String company) {
		List<String> list = new ArrayList<>();
		list.add(company);
		List<String> indexFnameEn = new ArrayList<>();
		indexFnameEn.add("XLFX-GLCPXL-J");//各类产品销量
		String[] yearMonth = DateUtil.getBeginMonth(yearMonths,1);
		JSONObject json = new JSONObject();
		json = this.pastureReportService.productFiveSale(list,yearMonth[0],yearMonths, indexFnameEn);
		return json.toString();
	}
	/**
	 * 进入乳业首页
	 */
	@RequestMapping(value = "/milkIndex", method = RequestMethod.GET)
	public void getMilkIndex(ModelMap modelMap, @RequestParam(required = true) String companyNumber, String companyName) {
		//orgCode参数
		List<String> orgCodes = new ArrayList<>();
		orgCodes.add(companyNumber.toUpperCase());
		List<String> orgCode = new ArrayList<>();
		orgCode.add("HSMRY");
		List<String> quotaNames = new ArrayList<>();

		quotaNames.add("ZHZB-YSZK-WY-QM");//综合指标-应收账款
		List<TBusinessQuota> yszk = this.pastureReportService.loopQuery(1,orgCodes,quotaNames);//查询乳制品销量

		quotaNames.set(0,"ZHZB-YYSR-WY");//综合指标-营业收入
		quotaNames.add("ZHZB-YYSR-YSMB-WY");//综合指标-营业收入-预算目标
		List<TBusinessQuota> yysr = this.pastureReportService.loopQuery(1,orgCodes,quotaNames);//查询营业收入

		quotaNames.set(0,"CW-YYLR");  //财务-营业利润
		quotaNames.set(1,"CW-YYLR-YS"); //财务-营业利润-预算
		List<TBusinessQuota> lrze = this.pastureReportService.loopQuery(1,orgCodes,quotaNames);//查询利润总额

		quotaNames.set(0,"ZHZB-RZPXL-QK");//综合指标-乳制品销量
		quotaNames.set(1,"ZKZB-RZPXL-YSMB-QK");//综合指标-乳制品销量-预算目标
		List<TBusinessQuota> rzpxl = this.pastureReportService.loopQuery(1,orgCodes,quotaNames);//查询乳制品销量
		quotaNames.set(0,"PJRCNL-MTSHSMR");//华山牧乳业每日销量
		Map<String,Object> rzpxl1 = this.pastureReportService.getComprehensiveIndex(-1,orgCode,quotaNames,"day");
		List<String> quota = new ArrayList<>();
		quota.add("PJRCNL-BYSHSMR");//华山牧乳业本月预算
		quota.add("PJRCNL-MYXHSMR");//华山牧乳业本月销量
		String[] yearMonths = DateUtil.getNextMonth(1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar1 = Calendar.getInstance();
		Date date1 = calendar1.getTime();
		String nowdays = sdf.format(date1);//当前时间
		List<Long> days =DateUtil.timeboolean();
		String month = nowdays.substring(5,7);
		long nowday = days.get(3);
		Map<String, Object>  rzpxl2;
		if(days.get(1)>days.get(0)&&!month.equals("12")){
			nowday = days.get(2)-1;
			rzpxl2 = this.pastureReportService.getSummilkChart(orgCode.get(0),yearMonths[0],yearMonths[0],quota);
		}else if(month.equals("12")){
			nowday = days.get(4);
			rzpxl2 = this.pastureReportService.getSummilkChart(orgCode.get(0),yearMonths[1],yearMonths[1],quota);
		}else if(days.get(1)<=days.get(0)&&month.equals("01")){
			nowday = days.get(0);
			rzpxl2 = this.pastureReportService.getSummilkChart(orgCode.get(0),yearMonths[1],yearMonths[1],quota);
		}
		else {
			rzpxl2 = this.pastureReportService.getSummilkChart(orgCode.get(0),yearMonths[1],yearMonths[1],quota);
		}
		quotaNames.set(0,"ZHZB-YYSR-BNLJ-WY");//营业收入本年累计
		quotaNames.set(1,"ZHZB-YYSR-BNLJ-YS");//营业收入本年累计预算
		List<TBusinessQuota> yysrlj = this.pastureReportService.loopQuery(1,orgCodes,quotaNames);//营业收入累计
		quotaNames.set(0,"ZHZB-RZPXL-LJ");//综合指标-乳制品销量-累计
		quotaNames.set(1,"ZKZB-RZPXL-YSMB-LJ");//综合指标-乳制品销量-预算目标-累计
		List<TBusinessQuota> rzpxllj = this.pastureReportService.loopQuery(1,orgCodes,quotaNames);//乳制品销量累计
		quotaNames.set(0,"CW-YYLR-BNLJ");//营业收入本年累计
		quotaNames.set(1,"CW-YYLR-BNLJ-YS");//营业收入本年累计预算
		List<TBusinessQuota> lrzelj = this.pastureReportService.loopQuery(1,orgCodes,quotaNames);//营业收入累计
//		String[] twoMonth = DateUtil.getBeginEndYearMonth(1);
		List<String> quotaName = new ArrayList<>();
//		quotaName.add("XLFX-GLCPXL-J");
//		Map<String,Object> resultMap = this.pastureReportService.productSales(orgCodes,twoMonth[0],twoMonth[1],quotaName);
		String[] yearMonth = DateUtil.getStartEndYearMonth(1);
		String b = yearMonth[0].substring(0,4)+"-"+yearMonth[0].substring(4,6)+"-"+yearMonth[0].substring(6,8);

		modelMap.put("rzpxl1",rzpxl1);
		modelMap.put("rzpxl2",rzpxl2);
		modelMap.put("days",nowday);
		modelMap.put("yysr",yysr);
		modelMap.put("lrze",lrze);
		modelMap.put("rzpxl",rzpxl);
		modelMap.put("rzpxllj",rzpxllj);
		modelMap.put("yszk",yszk);
		modelMap.put("yysrlj",yysrlj);
		modelMap.put("lrzelj",lrzelj);
//		modelMap.put("resultMap",resultMap);
		//modify end
		modelMap.put(Constants.Token.COMPANY_NUMBER, companyNumber);
		modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
		modelMap.put("company", companyNumber);
		//记录操作日志
		userLogsService.addLog("浏览", getRequestPath(), "PC端", getClientIP(), "0", "", "进入乳业首页");
	}

	/**
	 * 进入牧场首页
	 */
	@RequestMapping(value = "/pastureIndex", method = RequestMethod.GET)
	public void getPastureIndex(ModelMap modelMap, @RequestParam(required = true) String companyNumber, String companyName) {
		List<String> orgCodes = new ArrayList<>();
		//综合指标查询条件
		List<String> indexQuotaNames = new ArrayList<>();
		orgCodes.add(companyNumber.toUpperCase());
		indexQuotaNames.add("PJRCNL-QN");//综合指标-生鲜奶产量ZHZB-SXNCL-QN
		Map<String,Object> sxncl = this.pastureReportService.getComprehensiveIndex(-1,orgCodes,indexQuotaNames,"day");
		indexQuotaNames.set(0,"ZHZB-YYSR-WY");//综合指标-营业收入
		indexQuotaNames.add("ZHZB-YYSR-YSMB-WY");//综合指标-营业收入-预算目标
		List<TBusinessQuota> yysr = this.pastureReportService.loopQuery(1,orgCodes,indexQuotaNames);

		indexQuotaNames.set(0,"CW-YYLR");  //财务-营业利润
		indexQuotaNames.set(1,"CW-YYLR-YS"); //财务-营业利润-预算
		List<TBusinessQuota> yylr = this.pastureReportService.loopQuery(1,orgCodes,indexQuotaNames);

		indexQuotaNames.set(0,"ZHZB-DWWQCB-Y");//综合指标-单位完全成本
		indexQuotaNames.set(1,"ZHZB-DWWQCB-YSMB-Y");//综合指标-单位完全成本-预算目标
		List<TBusinessQuota> dwwqcb = this.pastureReportService.loopQuery(1,orgCodes,indexQuotaNames);

		indexQuotaNames.set(0,"ZHZB-YYSR-BNLJ-WY");//营业收入本年累计
		indexQuotaNames.set(1,"ZHZB-YYSR-BNLJ-YS");//营业收入本年累计预算
		List<TBusinessQuota> yysrlj = this.pastureReportService.loopQuery(1,orgCodes,indexQuotaNames);//营业收入累计

		indexQuotaNames.set(0,"CW-YYLR-BNLJ");//营业收入本年累计
		indexQuotaNames.set(1,"CW-YYLR-BNLJ-YS");//营业收入本年累计预算
		List<TBusinessQuota> lrzelj = this.pastureReportService.loopQuery(1,orgCodes,indexQuotaNames);//营业收入累计

		indexQuotaNames.set(0,"ZHZB-DWWQCB-LJ");//单位完全成本本年累计
		indexQuotaNames.set(1,"ZHZB-DWWQCB-LJYS");//单位完全成本本年累计预算
		List<TBusinessQuota> dwwqcblj = this.pastureReportService.loopQuery(1,orgCodes,indexQuotaNames);//营业收入累计

		List<String> quotaName = new ArrayList<>();
		quotaName.add("PJRCNL-QK");//综合指标-生鲜奶产量累计
//		Map<String,Object> sxncllj = this.pastureReportService.getComprehensiveIndex(1,orgCodes,indexQuotaNames,"month");
		String[] yearMonths = DateUtil.getNextMonth(1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar1 = Calendar.getInstance();
		Date date1 = calendar1.getTime();
		String nowday = sdf.format(date1);
		String firstday = DateUtil.datefirstDay();
		String endday = DateUtil.dateDays();
		long day = DateUtil.getDaySub(firstday,endday);
		long days = DateUtil.getDaySub(firstday,nowday);
		Map<String, Object>  sxncllj;
		String month = nowday.substring(5,7);
		if(days>day&&!month.equals("12")){
			sxncllj = this.pastureReportService.getSummilkChart(companyNumber,yearMonths[0],yearMonths[0],quotaName);
		}else {
			sxncllj = this.pastureReportService.getSummilkChart(companyNumber,yearMonths[1],yearMonths[1],quotaName);
		}
		modelMap.put("sxncl",sxncl);
		modelMap.put("sxncllj",sxncllj);
		modelMap.put("yysr",yysr);
		modelMap.put("yylr",yylr);
		modelMap.put("dwwqcb",dwwqcb);
		modelMap.put("yysrlj",yysrlj);
		modelMap.put("lrzelj",lrzelj);
		modelMap.put("dwwqcblj",dwwqcblj);
		modelMap.put(Constants.Token.COMPANY_NUMBER, companyNumber);
		modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
		modelMap.put("company", companyNumber);
		//记录操作日志
		userLogsService.addLog("浏览", getRequestPath(), "PC端", getClientIP(), "0", "", "进入牧场首页");
	}


	/**
	 * 首页地图数据
	 * createUser 杨北平 to 2017-11-13
	 * @param modelMap
	 * @param companyNumber
	 * @param companyName
	 * @return
	 */
	@RequestMapping(value = "/groupIndexMapAjax",method = RequestMethod.GET)
	@ResponseBody
	public String groupIndexMapAjax(ModelMap modelMap, @RequestParam(required = true) String companyNumber, String companyName,String yearMonth){
		//modify begin 2017-11-9 杨北平 新增参数\
		//String[] yearMonth = DateUtil.getBeginEndYearMonth(1);
		List<String> quotaNames = new ArrayList<>();
		if (yearMonth!=""&&!yearMonth.contains("Q")) {
			quotaNames.add("SCFB-TYRY");//市场分布-天友乳业
		}else if (yearMonth.contains("Q")){
			quotaNames.add("ZHZB-YYSR-WY");
			companyNumber = "TYRY";
		}else if (yearMonth==""){
			quotaNames.add("ZHZB-YYSR-BNLJ-WY");
			companyNumber = "TYRY";
		}
		//quotaNames.add("SCFB-HSMRY");//市场分布-华山牧乳业
		JSONObject TYRY = this.pastureReportService.loopQueryMapData(companyNumber,yearMonth,1,quotaNames);
		if (yearMonth.length()==6&&!yearMonth.contains("Q")){
			quotaNames.set(0,"PJRCNL-HSMRMYXSE");//月度数据指标
			companyNumber = "HSMRY";
		}else if(yearMonth.length()==8) {
			quotaNames.set(0, "SCFB-HSMRY");//日数据指标
		}else if (yearMonth.contains("Q")){
			quotaNames.set(0, "SCFB-HSMRY-JD");//季度数据指标
			companyNumber = "ZKRY";
		}else if(yearMonth==""){
			quotaNames.set(0,"SCFB-HSMRY-LJ");
			companyNumber = "ZKRY";
		}
		JSONObject HSMRY = this.pastureReportService.loopQueryMapData(companyNumber,yearMonth,1,quotaNames);
		JSONObject json = new JSONObject();
		json.put("TYRY",TYRY.get("result"));
		json.put("HSMRY",HSMRY.get("result"));
		json.put("yearMonthTY",TYRY.get("yearMonth"));
		json.put("yearMonthHSM",HSMRY.get("yearMonth"));

		return json.toString();
	}





	/**
	 * 进入供应链首页
	 */
	@RequestMapping(value = "/supplyChainIndex", method = RequestMethod.GET)
	public void getSupplyChainIndex(ModelMap modelMap, @RequestParam(required = true) String companyNumber, String companyName) {
		modelMap.put(Constants.Token.COMPANY_NUMBER, companyNumber);
		modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
		//记录操作日志
		userLogsService.addLog("浏览", getRequestPath(), "PC端", getClientIP(), "0", "", "进入供应链首页");
	}

	/**
	 * 进入虚拟组织首页
	 */
	@RequestMapping(value = "/virtualIndex", method = RequestMethod.GET)
	public void virtualIndex(ModelMap modelMap, @RequestParam(required = true) String companyNumber, String companyName) {
		modelMap.put(Constants.Token.COMPANY_NUMBER, companyNumber);
		modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
	}

	/**
	 * 修改密码
	 */
	@RequestMapping(value = "/rePwd",method = RequestMethod.POST)
	@ResponseBody
	public String rePwd(String userName,String oldPwd,String newPwd){
		Result<RcUser> result = userService.login(userName,oldPwd);
		if (!result.isStatus()){
			return "0";
		}else {
			result.getResultData().setPassword(Base64Util.encrypt(newPwd));
			int i = userService.updateByExample(result.getResultData());
			System.out.println(i);
			return "1";
		}
	}

	@RequestMapping(value = "/comingSoon")
	public void comingSoonLoad(ModelMap modelMap, @RequestParam(required = true) String companyNumber, String modularName){
		modelMap.put(Constants.Token.COMPANY_NUMBER, companyNumber);
		modelMap.put("companyName", COMPANY_CACHE.get(companyNumber).getFname());
		modelMap.put("modularName",modularName);
	}



}