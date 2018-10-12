package com.roncoo.adminlte.controller.report;
/**
 * Created by Andrew on 2017-09-24.
 */

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.*;
import com.roncoo.adminlte.bean.type.IndiceType;
import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.biz.UserBiz;
import com.roncoo.adminlte.service.*;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.RcCompanyMapper;
import com.roncoo.adminlte.util.Constants;
import com.roncoo.adminlte.util.DateUtil;
import com.roncoo.adminlte.util.Tools;
import com.roncoo.adminlte.util.base.BaseController;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.PageBean;
import com.roncoo.adminlte.util.base.ParamUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 数据编辑控制
 *
 * @author andrew
 * @create 2017-09-24 18:23
 */
@Controller
@RequestMapping(value = "/report/dataEdit")
public class DataEditController extends BaseController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserBiz userBiz;
    @Autowired
    private TSysUserLogsService userLogsService;
    @Autowired
    private TFinanceMainService tFinaceMainService;
    @Autowired
    private TFinanceMainIndicesService indicesService;
    @Autowired
    private TFinanceMainIndices2Service indices2Service;
    @Autowired
    private TFinanceMainIndices3Service indices3Service;
    @Autowired
    private TFinanceMainIndices4Service indices4Service;
    @Autowired
    private TFinanceMainIndices5Service indices5Service;
    @Autowired
    private BalanceSheetService balanceSheetService;
    @Autowired
    private BalanceProfitService balanceProfitService;
    @Autowired
    private TFinanceProductChangeService productChangeService;
    @Autowired
    private TFinanceStockChangeService stockChangeService;
    @Autowired
    private TFinanceFixedAssetsChangeService fixedAssetsChangeService;
    @Autowired
    private TFinanceSaleExpensesService saleExpensesService;
    @Autowired
    private TFinanceEmpSalaryService empSalaryService;
    @Autowired
    private TFinanceExpensesService expensesService;
    @Autowired
    private TFinanceManagerExpensesService managerExpensesService;
    @Autowired
    private TFinanceManufExpensesService manufExpensesService;
    @Autowired
    private TFinanceTaxStatisticsService taxStatisticsService;
    @Autowired
    private TFinanceFixedAssetsInvService fixedAssetsInvService;
    @Autowired
    private TFinanceMilkCostThisService milkCostThisService;
    @Autowired
    private TFinanceMilkCostTotalService milkCostTotalService;
    @Autowired
    private TFinanceMainBusinessList1Service tfinanceMainBusinessList1;
    @Autowired
    private TFinanceMainBusinessList2Service tfinanceMainBusinessList2;
    @Autowired
    private TFinanceMainBusinessList3Service tfinanceMainBusinessList3;
    @Autowired
    private TFinanceMainBusinessList4Service tfinanceMainBusinessList4;
    @Autowired
    private TFinanceMainBusinessList5Service tfinanceMainBusinessList5;
    @Autowired
    private TFinanceMainBusinessList6Service tfinanceMainBusinessList6;
    @Autowired
    private TFinanceMainBusinessList7Service tfinanceMainBusinessList7;
    @Autowired
    private TFinanceMainBusinessList8Service tfinanceMainBusinessList8;
    @Autowired
    private TFinanceMainBusinessTotal1Service tfinanceMainBusinessTotal1;
    @Autowired
    private TFinanceMainBusinessTotal2Service tfinanceMainBusinessTotal2;
    @Autowired
    private TFinanceMainBusinessTotal3Service tfinanceMainBusinessTotal3;
    @Autowired
    private TFinanceMainBusinessTotal4Service tfinanceMainBusinessTotal4;
    @Autowired
    private TFinanceProductCostThisService productCostThisService;
    @Autowired
    private TFinanceProductCostTotalService productCostTotalService;
    @Autowired
    private TFinanceBalanceDifferenceService balanceDifferenceService;

    @Autowired
    private BalanceCashFlowService balanceCashFlowService;
    @Autowired
    private BalanceMainBusinessMonthService businessMonthService;
    @Autowired
    private BalanceMainBusinessTotalService businessTotalService;

    @Autowired
    private BalanceMainBusinessDetailMonthService businessDetailMonthService;
    @Autowired
    private BalanceMainBusinessDetailTotalService businessDetailTotalService;
    @Autowired
    private TDailyReportService tDailyReportService;

    //差额表
    @Autowired
    private BalanceCashFlowDiffService balanceCashFlowDiffService;
    @Autowired
    private BalanceMainBusinessMonthDiffService businessMonthDiffService;
    @Autowired
    private BalanceMainBusinessTotalDiffService businessTotalDiffService;
    @Autowired
    private BalanceProfitDiffService balanceProfitDiffService;
    @Autowired
    private TFinanceExpensesDiffService expensesDiffService;
    @Autowired
    private TFinanceManagerExpensesDiffService managerExpensesDiffService;
    @Autowired
    private TFinanceManufExpensesDiffService manufExpensesDiffService;
    @Autowired
    private TFinanceSaleExpensesDiffService saleExpensesDiffService;
    @Autowired
    private TFinanceTaxStatisticsDiffService taxStatisticsDiffService;

    @Autowired
    private TFinanceOtherService otherService;

    @Autowired
    private BusinessQuotaService businessQuotaService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private  HsmryProductListBudgetService hsmryProductListBudgetService;

    @Autowired
    private TAccountsReceivableService receivableService;

    @Autowired
    private RcCompanyMapper rcCompanyMapper;

    @RequestMapping(value = LIST, method = RequestMethod.GET)
    public void list(ModelMap modelMap) {
        modelMap.put("companys", userBiz.findMyCompanys());
    }

    /**
     * 进入对标页面
     * @param modelMap
     */
    @RequestMapping(value = "baseDataList", method = RequestMethod.GET)
    public void baseDataList(ModelMap modelMap) {
        modelMap.put("companys", userBiz.findMyCompanys());
    }

    /**
     * 分页查询
     *
     * @param start
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = PAGE)
    public PageBean<TBusinessQuota> queryForPage(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "length", defaultValue = "10") int pageSize, @RequestParam(value = "yearMonth", required = false) String yearMonth, @RequestParam(value = "quotaName", required = false) String quotaName, @RequestParam(value = "orgCode", required = false) String orgCode) {
        Session session = SecurityUtils.getSubject().getSession();
        String companyNumber = (String) session.getAttribute(Constants.Token.COMPANY_NUMBER);
        orgCode = StringUtils.isEmpty(orgCode) ? "all" : orgCode;
        yearMonth = StringUtils.isEmpty(yearMonth) ? "all" : yearMonth;
        List<String> companyList = new ArrayList<>();
        for (RcCompany company : userBiz.findMyCompanys()) {
            companyList.add(company.getFnumber());
        }

        Result<Page<TBusinessQuota>> result = businessQuotaService.listForPage((start / pageSize) + 1, pageSize, orgCode, yearMonth, quotaName, companyList);
        //记录操作日志
        userLogsService.addLog("浏览指标", getRequestPath(), "PC端", getClientIP(), "success", "", "浏览指标列表");
        if (result.isStatus()) {
            return new PageBean<TBusinessQuota>(result.getResultData());
        }
        return new PageBean<TBusinessQuota>();
    }


    /**
     * 分页查询
     *
     * @param start
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page2")
    public PageBean<TFinanceOther> queryForPage2(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "length", defaultValue = "10") int pageSize, @RequestParam(value = "yearMonth", required = false) String yearMonth, @RequestParam(value = "quotaName", required = false) String quotaName, @RequestParam(value = "orgCode", required = false) String orgCode) {
        Session session = SecurityUtils.getSubject().getSession();
        String companyNumber = (String) session.getAttribute(Constants.Token.COMPANY_NUMBER);
        orgCode = StringUtils.isEmpty(orgCode) ? companyNumber : orgCode;
        yearMonth = StringUtils.isEmpty(yearMonth) ? Tools.getPeriodeDate() : yearMonth;

        Result<Page<TFinanceOther>> result = otherService.listForPage((start / pageSize) + 1, pageSize, yearMonth, quotaName);
        //记录操作日志
        userLogsService.addLog("浏览指标", getRequestPath(), "PC端", getClientIP(), "success", "", "浏览对标数据列表");
        if (result.isStatus()) {
            return new PageBean<TFinanceOther>(result.getResultData());
        }
        return new PageBean<TFinanceOther>();
    }
    /**
     * 分页查询
     *
     * @param start
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page3")
    public PageBean<TBusinessQuota> queryForPage3(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "length", defaultValue = "10") int pageSize, @RequestParam(value = "yearMonth", required = false) String yearMonth, @RequestParam(value = "quotaName", required = false) String quotaName, @RequestParam(value = "orgCode", required = false) String orgCode) {
        Session session = SecurityUtils.getSubject().getSession();
        String companyNumber = (String) session.getAttribute(Constants.Token.COMPANY_NUMBER);
        orgCode = StringUtils.isEmpty(orgCode) ? companyNumber : orgCode;
        if(orgCode.equals("ZKRY")){
            orgCode = null;
        }
        yearMonth = StringUtils.isEmpty(yearMonth) ? Tools.getPeriodeYear() : yearMonth;
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("PJRCNL-RJCN");
        quotaNames.add("PJRCNL-RJXL");
        quotaNames.add("PJRCNL-BYCN");
        quotaNames.add("PJRCNL-BYXL");
        Result<Page<TBusinessQuota>> result = businessQuotaService.listForPage((start / pageSize) + 1, pageSize,orgCode, yearMonth, quotaNames);
        //记录操作日志
        userLogsService.addLog("浏览指标", getRequestPath(), "PC端", getClientIP(), "success", "", "浏览对标数据列表");
        if (result.isStatus()) {
            return new PageBean<TBusinessQuota>(result.getResultData());
        }
        return new PageBean<TBusinessQuota>();
    }
    /**
     * 分页查询
     *
     * @param start
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page4")
    public PageBean<TBusinessQuota> queryForPage4(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "length", defaultValue = "10") int pageSize, @RequestParam(value = "yearMonth", required = false) String yearMonth, @RequestParam(value = "quotaName", required = false) String quotaName, @RequestParam(value = "orgCode", required = false) String orgCode) {
        yearMonth = StringUtils.isEmpty(yearMonth) ? Tools.getPeriodeYear() : yearMonth;
        List<String> quotaNames = new ArrayList<>();
        quotaNames.add("PJRCNL-BYSYDW");
        quotaNames.add("PJRCNL-BYSYCW");
        quotaNames.add("PJRCNL-BYSYXJ");
        quotaNames.add("PJRCNL-BYSYXSN");
        quotaNames.add("PJRCNL-BYSQSHJ");
        quotaNames.add("PJRCNL-BYSHSMR");
        quotaNames.add("PJRCNL-BYSZKGY");

        quotaNames.add("BYDWNXSE-YS");
        quotaNames.add("BYCWNXSE-YS");
        quotaNames.add("BYSYNXSE-YS");
        quotaNames.add("BYXSNXSE-YS");
        quotaNames.add("BYQSXSEHJ-YS");
        quotaNames.add("BYHSMRYXSE-YS");
        quotaNames.add("BYZKGYLXSE-YS");
        for (String index:IndiceType.getHsmryProductIndex().values()){
            quotaNames.add(index);
        }
        Result<Page<TBusinessQuota>> result = businessQuotaService.listForPage((start / pageSize) + 1, pageSize,orgCode, yearMonth, quotaNames);
        //记录操作日志
        userLogsService.addLog("浏览指标", getRequestPath(), "PC端", getClientIP(), "success", "", "浏览对标数据列表");
        if (result.isStatus()) {
            return new PageBean<TBusinessQuota>(result.getResultData());
        }
        return new PageBean<TBusinessQuota>();
    }


    /**
     * 修改指标
     * @param rcRole
     * @param resources
     * @return
     */
    @RequestMapping(value = UPDATE)
    @ResponseBody
    public String update(TBusinessQuota rcRole, String resources) {
        List<Long> permissions = ParamUtil.toLongList(resources, ",");
        Session seesion = SecurityUtils.getSubject().getSession();
        RcUser rcUser = (RcUser) seesion.getAttribute(Constants.Token.USER_INFO);
        if (rcRole != null) {
            rcRole.setFupdatime(new Date());
            rcRole.setFlastUpdator(rcUser.getUserNo());
        }
        Result<Integer> result = businessQuotaService.update(rcRole, rcUser);
        if (result.isStatus()) {
            //记录操作日志
            userLogsService.addLog("编辑指标", getRequestPath(), "PC端", getClientIP(), "success", "", rcRole.toString());
            return redirect("/report/dataEdit/list");
        }
        return null;
    }

    /**
     * 查看指标明细
     * @param modelMap
     * @param id
     */
    @RequestMapping(value = VIEW, method = RequestMethod.GET)
    public void view(ModelMap modelMap, long id) {
        Result<TBusinessQuota> result = businessQuotaService.query(id);
        if (result.isStatus()) {
            //记录操作日志
            userLogsService.addLog("浏览指标", getRequestPath(), "PC端", getClientIP(), "success", "", "浏览指标详情");
            modelMap.put("bean", result.getResultData());
        }
    }

    /**
     * 进入指标编辑界面
     * @param modelMap
     * @param id
     */
    @RequestMapping(value = EDIT, method = RequestMethod.GET)
    public void edit(ModelMap modelMap, long id) {
        Result<TBusinessQuota> result = businessQuotaService.query(id);
        if (result.isStatus()) {
            modelMap.put("bean", result.getResultData());
        }
    }

    /**
     * 数据列表界面
     * @param modelMap
     */
    @RequestMapping(value = "/financeDataList", method = RequestMethod.GET)
    public void financeDataList(ModelMap modelMap) {
        //记录操作日志
        userLogsService.addLog("进入财务报表上报界面", getRequestPath(), "PC端", getClientIP(), "success", "", "");
        Session session = SecurityUtils.getSubject().getSession();
        String companyNumber = (String)session.getAttribute(Constants.Token.COMPANY_NUMBER);
        modelMap.put("companys", userBiz.findMyCompanys(true));
        modelMap.put("companyNumber",companyNumber);
    }

    /**
     * 查询指标JSON
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/queryFinaceIndcies",method = RequestMethod.POST)
    public void financeQuery(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String period = ServletRequestUtils.getStringParameter(request,"period",Tools.getPeriodeDate());
        int idcNum = ServletRequestUtils.getIntParameter(request,"idcNum",0);
        String company = ServletRequestUtils.getStringParameter(request, "company", "");

        //获取当前组织
        Session seesion = SecurityUtils.getSubject().getSession();
        String companyNum = (String) seesion.getAttribute(Constants.Token.COMPANY_NUMBER);
        String idcName = IndiceType.getIndiceTypeStr(idcNum);
        logger.info("用户请求查询财务指标...期间：{}，指标序号：{},指标名称：{},当前组织：{}", period, idcNum, idcName, companyNum);

        JSONObject object = new JSONObject();
        //查询是否有导入记录
        TFinanceMain tfmain = tFinaceMainService.selectByProperty(company,period,idcName);
        if(tfmain == null || tfmain.getFid() == 0){
            object.put("stateCode", 0);
            object.put("error", "没有导入记录");
            object.put("datas", "[]");
        }else{
            long fid = tfmain.getFid();
            switch (idcNum) {
                case 1:
                    //获取主要指标1
                    object = indicesService.queryByHeadId(fid);
                    break;
                case 2:
                    //主要指标2
                    object = indices2Service.queryByHeadId(fid);
                    break;
                case 3:
                    //主要指标3
                    object = indices3Service.queryByHeadId(fid);
                    break;
                case 4:
                    //主要指标4
                    object = indices4Service.queryByHeadId(fid);
                    break;
                case 5:
                    //主要指标5
                    object = indices5Service.queryByHeadId(fid);
                    break;
                case 6:
                    //资产负债表
                    object = balanceSheetService.queryByHeadId(fid);
                    break;
                case 7:
                    //利润表
                    object = balanceProfitService.queryByHeadId(fid);
                    break;
                case 8:
                    //现金流量表
                    object = balanceCashFlowService.queryByHeadId(fid);
                    break;
                case 9:
                   //主营业务收支总表（本月）
                    object = businessMonthService.queryByHeadId(fid);
                    break;
                case 10:
                    // 主营业务收支总表（累计）
                    object = businessTotalService.queryByHeadId(fid);
                    break;
                case 37:
                    //主营收支明细表(本月华山牧乳业)
                    object = tfinanceMainBusinessList1.queryByHeadId(fid);
                    break;
                case 38:
                    //主营收支明细牧场(本月含运费)
                    object = tfinanceMainBusinessList2.queryByHeadId(fid);
                    break;
                case 39:
                    //主营收支明细牧场(本月不含运费)
                    object = tfinanceMainBusinessList3.queryByHeadId(fid);
                    break;
                case 40:
                    //主营收支明细(本月供应链)
                    object = tfinanceMainBusinessList4.queryByHeadId(fid);
                    break;
                case 41:
                    //主营收支明细(累计华山牧乳业)
                    object = tfinanceMainBusinessList5.queryByHeadId(fid);
                    break;
                case 42:
                    //主营收支明细(累计牧场含运费)
                    object = tfinanceMainBusinessList6.queryByHeadId(fid);
                    break;
                case 43:
                    //主营收支明细(累计牧场不含运费)
                    object = tfinanceMainBusinessList7.queryByHeadId(fid);
                    break;
                case 44:
                    //主营收支明细(累计供应链)
                    object = tfinanceMainBusinessList8.queryByHeadId(fid);
                    break;
                case 45:
                    //乳制品成本明细(本月华山牧乳业)
                    object = tfinanceMainBusinessTotal1.queryByHeadId(fid);
                    break;
                case 46:
                    //乳制品成本明细(本月牧场)
                    object = tfinanceMainBusinessTotal2.queryByHeadId(fid);
                    break;
                case 47:
                    //乳制品成本明细(累计华山牧乳业)
                    object = tfinanceMainBusinessTotal3.queryByHeadId(fid);
                    break;
                case 48:
                    //乳制品成本明细(累计牧场)
                    object = tfinanceMainBusinessTotal4.queryByHeadId(fid);
                    break;

                    // 主营业务收支明细（本月天友乳业）
                case 11:
                    object = businessDetailMonthService.queryByHeadId(fid);
                    break;
                case 12:
                    // 主营业务收支明细（累计天友乳业）
                    object = businessDetailTotalService.queryByHeadId(fid);
                    break;
                case 13:
                    //产品成本汇总表(本月)
                    object = productCostThisService.queryByHeadId(fid);
                    break;
                case 14:
                    //产品成本汇总表(累计)
                    object = productCostTotalService.queryByHeadId(fid);
                    break;
                case 15:
                    //乳制品成本明细表(本月天友乳业)
                    object = milkCostThisService.queryByHeadId(fid);
                    break;
                case 16:
                    //乳制品成本明细表(累计天友乳业)
                    object = milkCostTotalService.queryByHeadId(fid);
                    break;
                case 17:
                    //销售费用
                    object = saleExpensesService.queryByHeadId(fid);
                    break;
                case 18:
                    //管理费用
                    object = managerExpensesService.queryByHeadId(fid);
                    break;
                case 19:
                    //制造费用
                    object = manufExpensesService.queryByHeadId(fid);
                    break;
                case 20:
                    //财务费用
                    object = expensesService.queryByHeadId(fid);
                    break;
                case 21:
                    //税费统计表
                    object = taxStatisticsService.queryByHeadId(fid);
                    break;
                case 22:
                    //员工薪酬
                    object = empSalaryService.queryByHeadId(fid);
                    break;
                case 23:
                    //固定资产投资情况表
                    object = fixedAssetsInvService.queryByHeadId(fid);
                    break;
                case 24:
                    //固定资产增减表
                    object = fixedAssetsChangeService.queryByHeadId(fid);
                    break;
                case 25:
                    //存货增减表
                    object = stockChangeService.queryByHeadId(fid);
                    break;
                case 26:
                    //产品增减表
                    object = productChangeService.queryByHeadId(fid);
                    break;
                case 27:
                    //资产负债表(差额表)
                    object = balanceDifferenceService.queryByHeadId(fid);
                    break;
                default:
                    break;
            }
        }
        object.put("idcNum", idcNum);
        Tools.responseJSON(response, object );
    }

    /**
     * 导入财务报表：主要指标
     * @param request
     * @param response
     * @throws IOException
     * @throws EncryptedDocumentException
     * @throws InvalidFormatException
     */
    @RequestMapping(value = "/importFinance", method = RequestMethod.POST)
    public void importFinance(HttpServletRequest request, HttpServletResponse response) throws IOException, EncryptedDocumentException, InvalidFormatException {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("financeFile");
        InputStream inputStream = file.getInputStream();
        //兼容方式 Excel 2003/2010
        Workbook wb = WorkbookFactory.create(inputStream);
        int indicNum = ServletRequestUtils.getIntParameter(request,"idcNum",1);
        String[] yearMontArr = DateUtil.getBeginEndYearMonth(1);
        String yearMonth = ServletRequestUtils.getStringParameter(request,"yearMonth",yearMontArr[0]);
        //通过序号获取对应的指标名称
        //String sheetName = IndiceType.getIndiceTypeStr(indicNum);
        //获取当前组织
        Session seesion = SecurityUtils.getSubject().getSession();
        RcUser rcUser = (RcUser) seesion.getAttribute(Constants.Token.USER_INFO);
        String companyNumber = (String) seesion.getAttribute(Constants.Token.COMPANY_NUMBER);
        //导入上月的期间日期 201709
        String period = Tools.getPeriodeDate();
        logger.info("导入财务指标...期间：{}，指标序号：{},当前组织：{}", yearMonth, indicNum, companyNumber);

        JSONObject object = new JSONObject();
        int count = 0;
        for (Map.Entry<Integer, String> entry : IndiceType.getTypeMap().entrySet()) {
            if (wb.getSheetIndex(entry.getValue()) < 0) {
                continue;
            }
            count++;
            try {
                logger.debug("开始导入【{}】表...", entry.getValue());
                object = importHandler(wb, entry.getKey(), entry.getValue(), rcUser, companyNumber, yearMonth);
                object.put("error", "导入成功！");
                logger.debug("导入【{}】成功...", entry.getValue());
                object.put("stateCode", 200);
            } catch (Exception e) {
                logger.error("导入失败，报表：{}，异常信息：{}", entry.getValue(), e.getMessage(), e);
                //记录操作日志
                userLogsService.addLog("导入财务报表", getRequestPath(), "PC端", getClientIP(), "error", e.getMessage().substring(0, 1999), "执行报表导入操作异常，期间：" + yearMonth + ", 组织：" + companyNumber);
                object.put("error", "导入[" + entry.getValue() + "]失败");
                object.put("stateCode", 400);
                break;
            }
        }
        if (count==0){
            object.put("error","模板有误!");
        }
        object.put("idcNum",indicNum);
        Tools.responseJSON(response, object);
        //记录操作日志
        userLogsService.addLog("导入财务报表", getRequestPath(), "PC端", getClientIP(), "success", "", "执行报表导入操作，期间：" + yearMonth + ", 组织：" + companyNumber);
    }

    /**
     * 导入sheet页
     * @param wb EXCEL对象
     * @param indicNum 序号
     * @param sheetName sheet页名称
     * @param rcUser 当前操作用户
     * @param companyNumber 组织编码
     * @param period 期间
     * @return
     */
    private JSONObject importHandler(Workbook wb, int indicNum, String sheetName, RcUser rcUser, String companyNumber, String period) {
        JSONObject object = new JSONObject();
        switch (indicNum) {
            case 1:
                //获取主要指标1
                object = indicesService.importHandler(wb, sheetName, companyNumber, period, rcUser);
                break;
            case 2:
                //解析主要指标2
                object = indices2Service.importHandler(wb,sheetName,companyNumber,period,rcUser);
                break;
            case 3:
                //解析主要指标3
                object = indices3Service.importHandler(wb,sheetName,companyNumber,period,rcUser);
                break;
            case 4:
                //主要指标4
                object = indices4Service.importHandler(wb,sheetName,companyNumber,period,rcUser);
                break;
            case 5:
                //主要指标5
                object = indices5Service.importHandler(wb,sheetName,companyNumber,period,rcUser);
                break;
            case 6:
                //资产负债表
                object = balanceSheetService.importHandler(wb,sheetName,companyNumber,period,rcUser);
                break;
            case 7:
                //利润表
                object = balanceProfitService.importHandler(wb,sheetName,companyNumber,period,rcUser);
                break;
            case 8:
                //现金流量表
                object = balanceCashFlowService.importHandler(wb,sheetName,companyNumber,period,rcUser);
                break;
            case 9:
                //主营业务收支总(本月)
                object = businessMonthService.importHandler(wb,sheetName,companyNumber,period,rcUser);
                break;
            case 10:
                //主营业务收支总(累计)
                object = businessTotalService.importHandler(wb,sheetName,companyNumber,period,rcUser);
                break;
            case 37:
                //主营收支明细表(本月华山牧乳业)
                object = tfinanceMainBusinessList1.importHandler(wb,sheetName,companyNumber,period,rcUser);
                break;
            case 38:
                //主营收支明细牧场(本月含运费)
                object = tfinanceMainBusinessList2.importHandler(wb,sheetName,companyNumber,period,rcUser);
                break;
            case 39:
                //主营收支明细牧场(本月不含运费)
                object = tfinanceMainBusinessList3.importHandler(wb,sheetName,companyNumber,period,rcUser);
                break;
            case 40:
                //主营收支明细(本月供应链)
                object = tfinanceMainBusinessList4.importHandler(wb,sheetName,companyNumber,period,rcUser);
                break;
            case 41:
                //主营收支明细(累计华山牧乳业)
                object = tfinanceMainBusinessList5.importHandler(wb,sheetName,companyNumber,period,rcUser);
                break;
            case 42:
                //主营收支明细(累计牧场含运费)
                object = tfinanceMainBusinessList6.importHandler(wb,sheetName,companyNumber,period,rcUser);
                break;
            case 43:
                //主营收支明细(累计牧场含运费)
                object = tfinanceMainBusinessList7.importHandler(wb,sheetName,companyNumber,period,rcUser);
                break;
            case 44:
                //主营收支明细(累计牧场含运费)
                object = tfinanceMainBusinessList8.importHandler(wb,sheetName,companyNumber,period,rcUser);
                break;
            case 45:
                //主营收支明细(累计牧场含运费)
                object = tfinanceMainBusinessTotal1.importHandler(wb,sheetName,companyNumber,period,rcUser);
                break;
            case 46:
                //主营收支明细(累计牧场含运费)
                object = tfinanceMainBusinessTotal2.importHandler(wb,sheetName,companyNumber,period,rcUser);
                break;
            case 47:
                //主营收支明细(累计牧场含运费)
                object = tfinanceMainBusinessTotal3.importHandler(wb,sheetName,companyNumber,period,rcUser);
                break;
            case 48:
                //主营收支明细(累计牧场含运费)
                object = tfinanceMainBusinessTotal4.importHandler(wb,sheetName,companyNumber,period,rcUser);
                break;
            case 11:
                //主营业务收支明细(本月天友乳业)
                object = businessDetailMonthService.importHandler(wb,sheetName,companyNumber,period,rcUser);
                break;
            case 12:
                //主营业务收支明细(累计天友乳业)
                object = businessDetailTotalService.importHandler(wb,sheetName,companyNumber,period,rcUser);
                break;
            case 13:
                //产品成本汇总表(本月)
                object = productCostThisService.importHandler(wb, sheetName, companyNumber, period, rcUser);
                break;
            case 14:
                //产品成本汇总表(累计)
                object = productCostTotalService.importHandler(wb, sheetName, companyNumber, period, rcUser);
                break;
            case 15:
                //乳制品成本明细表(本月天友乳业)
                object = milkCostThisService.importHandler(wb, sheetName, companyNumber, period, rcUser);
                break;
            case 16:
                //乳制品成本明细表(累计天友乳业)
                object = milkCostTotalService.importHandler(wb, sheetName, companyNumber, period, rcUser);
                break;
            case 17:
                //销售费用
                object = saleExpensesService.importHandler(wb, sheetName, companyNumber, period, rcUser);
                break;
            case 18:
                //管理费用
                object = managerExpensesService.importHandler(wb, sheetName, companyNumber, period, rcUser);
                break;
            case 19:
                //制造费用
                object = manufExpensesService.importHandler(wb, sheetName, companyNumber, period, rcUser);
                break;
            case 20:
                //财务费用
                object = expensesService.importHandler(wb, sheetName, companyNumber, period, rcUser);
                break;
            case 21:
                //税费统计表
                object = taxStatisticsService.importHandler(wb, sheetName, companyNumber, period, rcUser);
                break;
            case 22:
                //员工薪酬
                object = empSalaryService.importHandler(wb, sheetName, companyNumber, period, rcUser);
                break;
            case 23:
                //固定资产投资情况表
                object = fixedAssetsInvService.importHandler(wb, sheetName, companyNumber, period, rcUser);
                break;
            case 24:
                //固定资产增减表
                object = fixedAssetsChangeService.importHandler(wb, sheetName, companyNumber, period, rcUser);
                break;
            case 25:
                //存货增减表
                object = stockChangeService.importHandler(wb, sheetName, companyNumber, period, rcUser);
                break;
            case 26:
                //产品增减表
                object = productChangeService.importHandler(wb, sheetName, companyNumber, period, rcUser);
                break;
            case 27:
                //资产负债表(差额表)
                object = balanceDifferenceService.importHandler(wb, sheetName, companyNumber, period, rcUser);
                break;
            case 28:
                //利润表差额表
                object = balanceProfitDiffService.importHandler(wb, sheetName, companyNumber, period, rcUser);
                break;
            case 29:
                //现金流量表差额表
                object = balanceCashFlowDiffService.importHandler(wb, sheetName, companyNumber, period, rcUser);
                break;
            case 30:
                //主营业务收支本月差额表
                object = businessMonthDiffService.importHandler(wb, sheetName, companyNumber, period, rcUser);
                break;
            case 31:
                //主营业务收支累计差额表
                object = businessTotalDiffService.importHandler(wb, sheetName, companyNumber, period, rcUser);
                break;
            case 32:
                //销售费用差额表
                object = saleExpensesDiffService.importHandler(wb, sheetName, companyNumber, period, rcUser);
                break;
            case 33:
                //管理费用差额表
                object = managerExpensesDiffService.importHandler(wb, sheetName, companyNumber, period, rcUser);
                break;
            case 34:
                //制造费用差额表
                object = manufExpensesDiffService.importHandler(wb, sheetName, companyNumber, period, rcUser);
                break;
            case 35:
                //财务费用差额表
                object = expensesDiffService.importHandler(wb, sheetName, companyNumber, period, rcUser);
                break;
            case 36:
                //税费统计表差额表
                object = taxStatisticsDiffService.importHandler(wb, sheetName, companyNumber, period, rcUser);
                break;
            default:
                object = new JSONObject();
                object.put("stateCode", "1");
                object.put("error", "超出sheet页数据导入范围");
                break;
        }
        return object;
    }


    /**
     * 导入对标数据
     * @param request
     * @param response
     * @throws IOException
     * @throws EncryptedDocumentException
     * @throws InvalidFormatException
     */
    @RequestMapping(value = "/importBaseData", method = RequestMethod.POST)
    public void importBaseData(HttpServletRequest request, HttpServletResponse response) throws IOException, EncryptedDocumentException, InvalidFormatException {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("financeFile");
        InputStream inputStream = file.getInputStream();
        //兼容方式 Excel 2003/2010
        Workbook wb = WorkbookFactory.create(inputStream);
        //获取当前组织
        Session seesion = SecurityUtils.getSubject().getSession();
        RcUser rcUser = (RcUser) seesion.getAttribute(Constants.Token.USER_INFO);
        String companyNumber = (String) seesion.getAttribute(Constants.Token.COMPANY_NUMBER);
        //导入上月的期间日期 201709
        String period = Tools.getPeriodeDate();
        logger.info("导入对标数据...期间：{}，当前组织：{}", period, companyNumber);

        JSONObject object = new JSONObject();
        try {
            object = otherService.importHandler(wb,"", companyNumber, period, rcUser);
            userLogsService.addLog("导入对标数据", getRequestPath(), "PC端", getClientIP(), "success", "", "导入对标数据");
            Tools.responseJSON(response, object);
        } catch (Exception e) {
            logger.error("导入对标数据失败");
            object.put("stateCode", "1");
            object.put("error", "导入失败");
            userLogsService.addLog("导入对标数据", getRequestPath(), "PC端", getClientIP(), "fail", e.getMessage(), "导入对标数据失败");
            Tools.responseJSON(response, object);
        }
    }
    /**
     * 导入牧场产销量数据
     * @param request
     * @param response
     * @throws IOException
     * @throws EncryptedDocumentException
     * @throws InvalidFormatException
     */
    @RequestMapping(value = "/milkBudget", method = RequestMethod.POST)
    public void milkBudget(HttpServletRequest request, HttpServletResponse response) throws IOException, EncryptedDocumentException, InvalidFormatException {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("financeFile");
        InputStream inputStream = file.getInputStream();
        //兼容方式 Excel 2003/2010
        Workbook wb = WorkbookFactory.create(inputStream);
        //获取当前组织
        Session seesion = SecurityUtils.getSubject().getSession();
        RcUser rcUser = (RcUser) seesion.getAttribute(Constants.Token.USER_INFO);
        String companyNumber = (String) seesion.getAttribute(Constants.Token.COMPANY_NUMBER);
        JSONObject object = new JSONObject();
        String[] sheetNames = {"产销量预算表","产销量预算明细表"};
        for(int i=0;i<=1;i++){
            if (wb.getSheetIndex(sheetNames[i])<0){
                continue;
            }
            try {
                switch (i){
                    case 0:
                        object = businessQuotaService.ranchBudgets(wb,"", companyNumber,rcUser);
                        break;
                    case 1:
                        object = this.hsmryProductListBudgetService.importHsmryDailyReport(wb);
                        break;
                }
                userLogsService.addLog(sheetNames[i], getRequestPath(), "PC端", getClientIP(), "success", "", sheetNames[i]);
                //Tools.responseJSON(response, object);
            } catch (Exception e){
                e.printStackTrace();
                logger.error("导入乳业预算数据失败");
                object.put("stateCode", "1");
                object.put("error", "导入失败");
                userLogsService.addLog("导入乳业预算数据", getRequestPath(), "PC端", getClientIP(), "fail", e.getMessage().substring(0,4000), "导入乳业预算数据失败");
            }
        }
        Tools.responseJSON(response, object);
    }
    /**
     * 导入华山牧乳业预算数据
     * @param request
     * @param response
     * @throws IOException
     * @throws EncryptedDocumentException
     * @throws InvalidFormatException
     */
    @RequestMapping(value = "/ranchBudget", method = RequestMethod.POST)
    public void ranchBudget(HttpServletRequest request, HttpServletResponse response) throws IOException, EncryptedDocumentException, InvalidFormatException {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("financeFile");
        InputStream inputStream = file.getInputStream();
        //兼容方式 Excel 2003/2010
        Workbook wb = WorkbookFactory.create(inputStream);
        //获取当前组织
        Session seesion = SecurityUtils.getSubject().getSession();
        RcUser rcUser = (RcUser) seesion.getAttribute(Constants.Token.USER_INFO);
        String companyNumber = (String) seesion.getAttribute(Constants.Token.COMPANY_NUMBER);
        JSONObject object = new JSONObject();
        try {
            object = businessQuotaService.ranchBudget(wb,"", companyNumber,rcUser);
            userLogsService.addLog("导入对标数据", getRequestPath(), "PC端", getClientIP(), "success", "", "导入对标数据");
            Tools.responseJSON(response, object);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("导入对标数据失败");
            object.put("stateCode", "1");
            object.put("error", "导入失败");
            userLogsService.addLog("导入对标数据", getRequestPath(), "PC端", getClientIP(), "fail", e.getMessage().substring(0,4000), "导入对标数据失败");
            Tools.responseJSON(response, object);
        }
    }

    /**
     * 导入牛奶理化指标数据
     * @param request
     * @param response
     * @throws IOException
     * @throws EncryptedDocumentException
     * @throws InvalidFormatException
     */
    @RequestMapping(value = "/importMilkIndexData", method = RequestMethod.POST)
    public void importMilkIndexData(HttpServletRequest request, HttpServletResponse response) throws IOException, EncryptedDocumentException, InvalidFormatException {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("financeFile");
        InputStream inputStream = file.getInputStream();
        //兼容方式 Excel 2003/2010
        Workbook wb = WorkbookFactory.create(inputStream);
        //获取当前组织
        Session seesion = SecurityUtils.getSubject().getSession();
        RcUser rcUser = (RcUser) seesion.getAttribute(Constants.Token.USER_INFO);
        String companyNumber = (String) seesion.getAttribute(Constants.Token.COMPANY_NUMBER);
        //导入上月的期间日期 201709
        String period = Tools.getPeriodeDate();
        logger.info("导入牛奶理化指标数据...期间：{}，当前组织：{}", period, companyNumber);

        JSONObject object = new JSONObject();
        try {
            object = businessQuotaService.importMilkIndexData(rcUser, companyNumber, period, wb);
            userLogsService.addLog("导入牛奶质量指标", getRequestPath(), "PC端", getClientIP(), "success", "", "导入牛奶质量指标");
            Tools.responseJSON(response, object);
        } catch (Exception e) {
            logger.error("导入对标数据失败");
            object.put("stateCode", "1");
            object.put("error", "导入失败");
            userLogsService.addLog("导入牛奶质量指标", getRequestPath(), "PC端", getClientIP(), "fail", e.getMessage(), "导入牛奶质量指标");
            Tools.responseJSON(response, object);
        }
    }

    /**
     * 下载模板
     * @param request
     * @param response
     * @param tempType 模样类型
     */
    @RequestMapping(value = "/downloadTempFile", method = RequestMethod.GET)
    public void downloadTempFile(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = true) String tempType) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String modelPath = null;
            String fileName = null;
            if ("OTHER_TEMP".equalsIgnoreCase(tempType)) {
                modelPath = request.getSession().getServletContext().getRealPath("/static/template/FINANCE_OTHER_TEMPLATE.xls");
                fileName = "外部对标数据上报模板";
            } else if ("FINANCE_REPORT_TEMP".equalsIgnoreCase(tempType)) {
                modelPath = request.getSession().getServletContext().getRealPath("/static/template/FINANCE_REPORT_TEMPLATE_V2018.xls");
                fileName = "财务报表上报模板";
            } else if ("MILK_INDEX_TEMP".equalsIgnoreCase(tempType)) {
                modelPath = request.getSession().getServletContext().getRealPath("/static/template/MILK_INDEX_TEMPLATE.xls");
                fileName = "牛奶质量指标模板";
            }else if ("DAILY_REPORT".equalsIgnoreCase(tempType)) {
                modelPath = request.getSession().getServletContext().getRealPath("/static/template/DAILY_REPORT.xls");
                fileName = "每日报表模板";
            }else if ("PASTURE_BUDGET".equalsIgnoreCase(tempType)) {
                modelPath = request.getSession().getServletContext().getRealPath("/static/template/PASTURE_BUDGET.xls");
                fileName = "产销量预算表";
            }else if ("HSMRY_BUDGET".equalsIgnoreCase(tempType)) {
                modelPath = request.getSession().getServletContext().getRealPath("/static/template/MILKHSMRY_BUDGET.xls");
                fileName = "华山牧乳业预算表";
            }else if ("ACCOUNTS_RECEIVABLE".equalsIgnoreCase(tempType)) {
                modelPath = request.getSession().getServletContext().getRealPath("/static/template/ACCOUNTS_RECEIVABLE.xls");
                fileName = "应收账款数据模板";
            }

            FileInputStream fis = new FileInputStream(new File(modelPath));
            Workbook wb = new HSSFWorkbook(fis);

            response.setContentType("application/vnd.ms-excel");
            // 进行转码，使其支持中文文件名
            String codedFileName = java.net.URLEncoder.encode(fileName, "UTF-8");
            response.setHeader("content-disposition", "attachment;filename=" + codedFileName + ".xls");
            OutputStream out = response.getOutputStream();
            wb.write(out);
            wb.close();
        } catch (FileNotFoundException e) {
            try {
                e.printStackTrace();
                response.getOutputStream().print("模板未找到");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (Exception e) {
            logger.error("下载失败，error: {}", e.getMessage(), e);
        }
    }

    /**
     * 根据月份，合并计算Excel报表
     * @param yearMonth 月份
     */
    @RequestMapping(value = "/consolidationSheet", method = RequestMethod.GET)
    public void consolidationSheet(HttpServletRequest request, HttpServletResponse response, String yearMonth){
        JSONObject obj = tFinaceMainService.selectByMonth(yearMonth);
        Map<Long,String> map = (Map)obj.get("resultMap");
        List<Long> tfheadids = JSONArray.parseArray(obj.getJSONArray("fids").toString(),Long.class);//查询出的表头ID集合
        if (tfheadids.size() > 0){//查询当月至少有一家子公司上报了数据
            try {
                String fileName = "";
                if(yearMonth.substring(0,4).equals("2017")) {
                    fileName = request.getSession().getServletContext().getRealPath("/static/template/ZKRY_REPORT_UNION_TEMPLATE_V2017.xlsx");// Excel文件所在路径
                }else {
                    fileName = request.getSession().getServletContext().getRealPath("/static/template/ZKRY_REPORT_UNION_TEMPLATE_V2018.xlsx");// Excel文件所在路径
                }
                File file = new File(fileName); // 创建文件对象
                InputStream inputStream = new FileInputStream(file);//读取
                //兼容方式 Excel 2003/2010
                Workbook wb = WorkbookFactory.create(inputStream);
                SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
                Sheet sheet = wb.getSheetAt(3);
                Row pageHomeRow = sheet.getRow(7);
                Cell dateCell = pageHomeRow.getCell(0);
                dateCell.setCellValue(format.parse(yearMonth));
                int sheetNum = 20;//文件表单总数
                int sheetStartIndex = 5;//开始填写的表单下标
                for (int i = sheetStartIndex; i <= sheetNum; i++) {//遍历表单
                    switch (i) {
                        case 5:
                            //主要指标(本期和累计)
                            indicesService.queryByMonth(wb,tfheadids,map,fileName);
                            break;
                        case 6:
                            //资产负债表(合并)
                            balanceSheetService.exportHandler(wb.getSheetAt(i),tfheadids,fileName);
                            break;
                        case 7:
                            //利润表(合并)
                            balanceProfitService.exportHandler(wb.getSheetAt(i),tfheadids,fileName);
                            break;
                        case 8:
                            //现金流量表(合并)
                            balanceCashFlowService.exportHandler(wb.getSheetAt(i),tfheadids);
                            break;
                        case 9:
                            //主营收支总(本月合并)
                            businessMonthService.exportHandler(wb.getSheetAt(i),tfheadids);
                            break;
                        case 10:
                            //主营收支总(累计合并)
                            businessTotalService.exportHandler(wb.getSheetAt(i),tfheadids);
                            break;
                        case 11:
                            //产品成本汇总表(本月)
                            productCostThisService.exportHandler(wb.getSheetAt(i),tfheadids);
                            break;
                        case 12:
                            //产品成本汇总表(累计)
                            productCostTotalService.exportHandler(wb.getSheetAt(i),tfheadids);
                            break;
                        case 13:
                            //销售费用表(合并)
                            saleExpensesService.exportHandler(wb.getSheetAt(i),tfheadids);
                            break;
                        case 14:
                            //管理费用表(合并)
                            managerExpensesService.exportHandler(wb.getSheetAt(i),tfheadids);
                            break;
                        case 15:
                            //制造费用(合并)
                            manufExpensesService.exportHandler(wb.getSheetAt(i),tfheadids);
                            break;
                        case 16:
                            //财务费用(合并)
                            expensesService.exportHandler(wb.getSheetAt(i),tfheadids);
                            break;
                        case 17:
                            //税费统计表(合并)
                            taxStatisticsService.exportHandler(wb.getSheetAt(i),tfheadids);
                            break;
                        case 18:
                            //员工薪酬表(合并)
                            empSalaryService.exportHandler(wb.getSheetAt(i),tfheadids);
                            break;
                        case 19:
                            //固定资产投资情况表(合并)
                            fixedAssetsInvService.exportHandler(wb.getSheetAt(i),tfheadids);
                            break;
                        case 20:
                            //固定资产增减表(合并)
                            fixedAssetsChangeService.exportHandler(wb.getSheetAt(i),tfheadids);
                            break;
                    }
                }
                response.setContentType("application/vnd.ms-excel");
                // 进行转码，使其支持中文文件名
                String codedFileName = java.net.URLEncoder.encode("财务报表", "UTF-8");
                response.setHeader("content-disposition", "attachment;filename=" + codedFileName + ".xlsx");
                OutputStream out = response.getOutputStream();
                wb.write(out);
                wb.close();
            }catch (FileNotFoundException e) {
                try {
                    response.getOutputStream().print("模板未找到");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } catch (Exception e) {
                logger.error("下载失败，error: {}", e.getMessage(), e);
            }
        }
    }

    /**
     * 根据月份，查询报表数据是否存在
     * @param yearMonth 月份
     */
    @RequestMapping(value = "/querySheet", method = RequestMethod.GET)
    @ResponseBody
    public String querySheet(HttpServletRequest request, HttpServletResponse response, String yearMonth){
        JSONObject obj = tFinaceMainService.selectByMonth(yearMonth);
        Map<Long,String> map = (Map)obj.get("resultMap");
        List<Long> tfheadids = JSONArray.parseArray(obj.getJSONArray("fids").toString(),Long.class);//查询出的表头ID集合
        if (tfheadids.size() > 0){//查询当月至少有一家子公司上报了数据
            return "haveMonth";
        }else {//当月暂无数据
            return "noMonth";
        }
    }


    /**
     * 查询出所有公司,信息
     */
    @RequestMapping(value = "/queryCompany", method = RequestMethod.POST)
    @ResponseBody
    public String queryCompany(){
        List list = companyService.list().getResultData();
        JSONObject json = new JSONObject();
        json.put("list",list);
        return json.toString();
    }

    /**
     * 查询出对应公司的所有指标 杨北平   2018-02-26
     */
    @RequestMapping(value = "/locadIndex", method = RequestMethod.GET)
    @ResponseBody
    public String locadIndex(String companyName){
        JSONObject json = this.businessQuotaService.queryIndex(companyName,null);
        return json.toString();
    }

    /**
     * 查询出指标对应的细分类 杨北平   2018-02-26
     */
    @RequestMapping(value = "/locadList", method = RequestMethod.GET)
    @ResponseBody
    public String locadList(String companyName,String indexData){
        JSONObject json = this.businessQuotaService.queryListOption(companyName,indexData);
        return json.toString();
    }

    /**
     * 保存手动维护指标 杨北平   2018-02-27
     */
    @RequestMapping(value = "/submitSave", method = RequestMethod.POST)
    @ResponseBody
    public String submitSave(TBusinessQuota quota){
        List<TBusinessQuota> list = businessQuotaService.queryQuota(quota.getForgCode(),quota.getFnameEn(),quota.getFyearMonth(),quota.getFsmallClass());
        Result<Integer> val = null;
        quota.setFcreatime(new Date());
        quota.setFupdatime(new Date());
        Session seesion = SecurityUtils.getSubject().getSession();
        RcUser rcUser = (RcUser) seesion.getAttribute(Constants.Token.USER_INFO);
        int data = 0;
        if (list.size()<=0){
            data = 1;
            val = businessQuotaService.addNew(quota);
        }else {
            data = 2;
            quota.setFid(list.get(0).getFid());
            val = businessQuotaService.update(quota,rcUser);
        }
        return String.valueOf(data);
    }


    /**
     * 进入每日报表导入页面
     * @param modelMap
     */
    @RequestMapping(value = "dailyReport", method = RequestMethod.GET)
    public void dailyReport(ModelMap modelMap) {
        modelMap.put("companys", userBiz.findMyCompanys());
    }

    /**
     * 进入牧场预算导入页面
     * @param modelMap
     */
    @RequestMapping(value = "ranchBudget", method = RequestMethod.GET)
    public void ranchBudget(ModelMap modelMap) {
        modelMap.put("companys", userBiz.findMyCompanys());
    }

    /**
     * 进入华山牧乳业预算导入页面
     * @param modelMap
     */
    @RequestMapping(value = "milkBudget", method = RequestMethod.GET)
    public void milkBudget(ModelMap modelMap) {
        modelMap.put("companys", userBiz.findMyCompanys());
    }


    /**
     * 进入应收账款导入页面
     * @param modelMap
     */
    @RequestMapping(value = "accountsReceivable", method = RequestMethod.GET)
    public void accountsReceivable(ModelMap modelMap) {
        Session seesion = SecurityUtils.getSubject().getSession();
        String companyNumber = (String) seesion.getAttribute(Constants.Token.COMPANY_NUMBER);
        if (companyNumber.equals("ZKRY")){
            companyNumber = null;
        }
        RcCompanyExample example = new RcCompanyExample();
        RcCompanyExample.Criteria criteria = example.createCriteria();
        if (companyNumber!=null){
            criteria.andFnumberEqualTo(companyNumber);
        }
        List<RcCompany> companyList = this.rcCompanyMapper.selectByExample(example);
        modelMap.put("companys", userBiz.findMyCompanys());
        modelMap.put("companyNumber",companyNumber);
        modelMap.put("companyList",companyList);
    }


    /**
     * 导入对标数据
     * @param request
     * @param response
     * @throws IOException
     * @throws EncryptedDocumentException
     * @throws InvalidFormatException
     */
    @RequestMapping(value = "/importDailyReport", method = RequestMethod.POST)
    public void importDailyReport(HttpServletRequest request, HttpServletResponse response,String period) throws IOException, EncryptedDocumentException, InvalidFormatException {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("financeFile");
        InputStream inputStream = file.getInputStream();
        //兼容方式 Excel 2003/2010
        Workbook wb = WorkbookFactory.create(inputStream);
        //获取当前组织
        Session seesion = SecurityUtils.getSubject().getSession();
        RcUser rcUser = (RcUser) seesion.getAttribute(Constants.Token.USER_INFO);
        String companyNumber = (String) seesion.getAttribute(Constants.Token.COMPANY_NUMBER);
        //导入上月的期间日期 201709
        //String period = Tools.getPeriodeDate();
        logger.info("导入每日报表...期间：{}，当前组织：{}", period, companyNumber);

        JSONObject object = new JSONObject();
        try {
            //导入总表数据
            if (wb.getSheetIndex("供应链总表")>=0) {
                object = this.tDailyReportService.importDailyReport(wb, "供应链总表", companyNumber, period, rcUser);
            }
            //导入分表数据
            if (wb.getSheetIndex("供应链分表")>=0){
                object = this.tDailyReportService.importDailyReport(wb, "供应链分表", companyNumber, period, rcUser);
            }
            userLogsService.addLog("导入每日报表", getRequestPath(), "PC端", getClientIP(), "success", "", "导入每日报表");
            Tools.responseJSON(response, object);
        } catch (Exception e) {
            logger.error("导入每日报表失败");
            object.put("stateCode", "1");
            object.put("error", "导入失败");
            userLogsService.addLog("导入每日报表", getRequestPath(), "PC端", getClientIP(), "fail", e.getMessage().substring(0,1000), "导入每日报表失败");
            Tools.responseJSON(response, object);
        }
    }

    @RequestMapping(value = "/dailyReportTotal",method = RequestMethod.POST)
    @ResponseBody
    public void dailyReportTotal(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "pageSize") int pageSize, @RequestParam(value = "yearMonth", required = false) String yearMonth, int type, HttpServletResponse response) throws IOException{
        yearMonth = StringUtils.isEmpty(yearMonth) ? Tools.getPeriodeDate() : yearMonth;
        JSONObject object = this.tDailyReportService.listForPage(start, pageSize, yearMonth, type);
        userLogsService.addLog("浏览指标", getRequestPath(), "PC端", getClientIP(), "success", "", "浏览对标数据列表");
        object.put("idcNum", type);
        Tools.responseJSON(response, object );
    }



    /**
     * 导入华山牧乳业预算数据
     * @param request
     * @param response
     * @throws IOException
     * @throws EncryptedDocumentException
     * @throws InvalidFormatException
     */
    @RequestMapping(value = "/accountsReceivableImport", method = RequestMethod.POST)
    public void accountsReceivableImport(HttpServletRequest request, HttpServletResponse response,String yearMonth) throws IOException, EncryptedDocumentException, InvalidFormatException {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("financeFile");
        InputStream inputStream = file.getInputStream();
        //兼容方式 Excel 2003/2010
        Workbook wb = WorkbookFactory.create(inputStream);
        //获取当前组织
        Session seesion = SecurityUtils.getSubject().getSession();
        RcUser rcUser = (RcUser) seesion.getAttribute(Constants.Token.USER_INFO);
        String companyNumber = (String) seesion.getAttribute(Constants.Token.COMPANY_NUMBER);
        JSONObject object = new JSONObject();
        try {
            object = receivableService.importAccounts(wb,"应收账款前五导入", companyNumber,yearMonth,rcUser);
            userLogsService.addLog("导入应收账款数据", getRequestPath(), "PC端", getClientIP(), "success", "", "导入应收账款数据");
            Tools.responseJSON(response, object);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("导入应收账款数据失败");
            object.put("stateCode", "1");
            object.put("error", "导入失败");
            userLogsService.addLog("导入应收账款数据", getRequestPath(), "PC端", getClientIP(), "fail", e.getMessage().substring(0,4000), "导入应收账款数据失败");
            Tools.responseJSON(response, object);
        }
    }


    /**
     * 分页查询
     *
     * @param start
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "queryAccountReceivable")
    public PageBean<TAccountsReceivable> queryAccountReceivable(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "length", defaultValue = "10") int pageSize, @RequestParam(value = "yearMonth", required = false) String yearMonth,  @RequestParam(value = "orgCode", required = false) String orgCode) {
        List<BigDecimal> headIdList = this.tFinaceMainService.selectHeadId(orgCode,yearMonth);
        if (headIdList==null||headIdList.size()==0){
            PageBean<TAccountsReceivable> result = new PageBean<TAccountsReceivable>();
            result.setData(new ArrayList<TAccountsReceivable>());
            return result;
        }else {
            Result<Page<TAccountsReceivable>> result = this.receivableService.listForPage((start / pageSize) + 1, pageSize,headIdList);
            //记录操作日志
            userLogsService.addLog("浏览指标", getRequestPath(), "PC端", getClientIP(), "success", "", "浏览对标数据列表");
            if (result.isStatus()) {
                return new PageBean<TAccountsReceivable>(result.getResultData());
            }
            PageBean<TAccountsReceivable> result1 = new PageBean<TAccountsReceivable>();
            result1.setData(new ArrayList<TAccountsReceivable>());
            return result1;
        }
    }
}
