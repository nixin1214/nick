package com.roncoo.adminlte.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TFinanceOther;
import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.service.TFinanceOtherService;
import com.roncoo.adminlte.service.impl.dao.TFinanceOtherDao;
import com.roncoo.adminlte.util.Tools;
import com.roncoo.adminlte.util.base.Page;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 对标数据
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/29 16:01
 */
@Service
public class TFinanceOtherServiceImpl implements TFinanceOtherService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TFinanceOtherDao dao;

    @Override
    public Result<TFinanceOther> query(long id) {
        Result<TFinanceOther> result = new Result<>();
        if (id < 0) {
            result.setStatus(false);
            result.setErrCode(1);
            result.setErrMsg("ID无效");
            return result;
        }
        result.setResultData(dao.selectById(id));
        result.setStatus(true);
        return result;
    }

    @Override
    public Result<Integer> save(TFinanceOther rcRole) {
        Result<Integer> result = new Result<>();

        //验证
        if (StringUtils.isEmpty(rcRole.getFquotaName())) {
            result.setErrMsg("指标名称为空");
            return result;
        }
        if (StringUtils.isEmpty(rcRole.getFenterprise())) {
            result.setErrMsg("企业名称为空");
            return result;
        }

        result.setResultData(dao.insert(rcRole));
        result.setStatus(true);
        return result;
    }

    @Override
    public Result<Integer> update(TFinanceOther rcRole) {
        Result<Integer> result = new Result<>();

        //验证
        if (StringUtils.isEmpty(rcRole.getFquotaName())) {
            result.setErrMsg("指标名称为空");
            return result;
        }
        if (StringUtils.isEmpty(rcRole.getFenterprise())) {
            result.setErrMsg("企业名称为空");
            return result;
        }

        result.setResultData(dao.update(rcRole));
        result.setStatus(true);
        return result;
    }

    @Override
    public Result<Integer> delete(long id) {
        Result<Integer> result = new Result<>();

        //验证
        if (id < 0) {
            result.setStatus(false);
            result.setErrMsg("ID无效");
            result.setErrCode(1);
            return result;
        }

        result.setResultData(dao.deleteById(id));
        result.setStatus(true);
        return result;
    }

    @Override
    public Result<Page<TFinanceOther>> listForPage(int pageCurrent, int pageSize, String date, String search) {
        Result<Page<TFinanceOther>> result = new Result<>();
        result.setResultData(dao.listForPage(pageCurrent, pageSize, date, search));
        result.setStatus(true);
        return result;
    }

    @Override
    public Result<List<TFinanceOther>> listForId(List<Long> idList) {
        Result<List<TFinanceOther>> result = new Result<>();
        result.setResultData(dao.listForId(idList));
        return result;
    }

    @Override
    public int insertBatch(List<TFinanceOther> list) {
        return dao.insertBatch(list);
    }

    @Transactional
    public JSONObject importHandler(Workbook wb, String sheetName, String companyNumber, String period, RcUser rcUser) {
        JSONObject object;

        //导入前先清空数据
        dao.deleteByCompany(companyNumber);

        //导入产品完全成本
        object = importBaseData1(wb, rcUser, companyNumber, period);
        if (object.getIntValue("stateCode") == 1) {
            return object;
        }
        //导入集约化财务评价指标对标分析
        object = importBaseData2(wb, rcUser, companyNumber, period);
        return object;
    }

    /**
     * 导入 “产品全成本分析”
     * @param wb EXCEL对象
     * @param rcUser 用户
     * @param companyNumber 组织编码
     * @param period 期间
     */
    private JSONObject importBaseData1(Workbook wb, RcUser rcUser, String companyNumber, String period) {
        JSONObject object = new JSONObject();
        List<TFinanceOther> indiceList = new ArrayList<>();
        Sheet sheet = wb.getSheet("产品全成本分析");
        int rowCount = sheet.getPhysicalNumberOfRows();
        logger.debug("行数 rowCount={}", rowCount);
        if(rowCount<13){
            object.put("stateCode", 1);
            object.put("error", "导入的模板数据有误");
            logger.error("导入的模板数据有误");
        }else{
            String entName = sheet.getRow(1).getCell(2).getStringCellValue();
            for (int r = 3; r < 13; r++) { //遍历有数据的行
                Row row = sheet.getRow(r);
                if(row != null){
                    logger.debug("row index: {}", r);
                    String projectName = Tools.getCellValue(row.getCell(1), wb);
                    BigDecimal c2 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(2), wb));
                    BigDecimal c3 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(3), wb));

                    switch (r) {
                        case 3:
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c2,"DB_SCCB_ZJCL_CB");
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c3,"DB_SCCB_ZJCL_ZB");
                            break;
                        case 4:
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c2,"DB_SCCB_ZJRG_CB");
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c3,"DB_SCCB_ZJRG_ZB");
                            break;
                        case 5:
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c2,"DB_SCCB_NYDL_CB");
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c3,"DB_SCCB_NYDL_ZB");
                            break;
                        case 6:
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c2,"DB_SCCB_ZZFY_CB");
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c3,"DB_SCCB_ZZFY_ZB");
                            break;
                        case 7:
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c2,"DB_SCCB_CBXJ_CB");
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c3,"DB_SCCB_CBXJ_ZB");
                            break;
                        case 8:
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c2,"DB_QJFY_XSFY_CB");
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c3,"DB_QJFY_XSFY_ZB");
                            break;
                        case 9:
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c2,"DB_QJFY_GLFY_CB");
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c3,"DB_QJFY_GLFY_ZB");
                            break;
                        case 10:
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c2,"DB_QJFY_CWFY_CB");
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c3,"DB_QJFY_CWFY_ZB");
                            break;
                        case 11:
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c2,"DB_QJFY_CBXJ_CB");
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c3,"DB_QJFY_CBXJ_ZB");
                            break;
                        default:
                            break;
                    }
                }
            }
            insertBatch(indiceList);
            object.put("stateCode", 0);
            object.put("error", "导入成功");
        }
        return object;
    }

    private void addNew(RcUser rcUser, String companyNumber, String period, List<TFinanceOther> indiceList, String entName, int r, String projectName, BigDecimal c2, String quotaEn) {
        TFinanceOther quota = new TFinanceOther();
        quota.setFrowIndex(Long.parseLong(r + ""));
        quota.setFenterprise(entName);
        quota.setFcompanyCode(companyNumber);
        quota.setFcreatorId(rcUser.getId());
        quota.setFcreatorName(rcUser.getNickName());
        quota.setFquotaName(quotaEn);
        quota.setFquotaValue(c2);
        quota.setFremark(projectName);
        quota.setFresource("EXCEL导入");
        quota.setFyearmonth(period);
        quota.setFcreatime(new Date());
        indiceList.add(quota);

        /*TBusinessQuota quota1 = new TBusinessQuota();
        quota1.setFupdatime(new Date());
        quota1.setFlastUpdator(rcUser.getUserNo());
        quota1.setFvalue(c2);
        quota1.setForgCode(companyNumber);
        quota1.setFcreatime(new Date());
        quota1.setFdimension("年");
        quota1.setFnameEn(quotaEn);
        quota1.setFnameZh(projectName);
        quota1.setFresSys("EXCEL导入");
        quota1.setFtype("对标数据");
        quota1.setFyearMonth(period);
        quota1.setFvalueType("NUMBER");*/
    }

    /**
     * 导入 “集约化财务评价指标对标分析”
     * @param wb EXCEL对象
     * @param rcUser 用户
     * @param companyNumber 组织编码
     * @param period 期间
     */
    private JSONObject importBaseData2(Workbook wb, RcUser rcUser, String companyNumber, String period) {
        JSONObject object = new JSONObject();
        List<TFinanceOther> indiceList = new ArrayList<>();
        Sheet sheet = wb.getSheet("集约化财务评价指标对标分析");
        int rowCount = sheet.getPhysicalNumberOfRows();
        logger.debug("行数 rowCount={}", rowCount);
        if(rowCount<15){
            object.put("stateCode", 1);
            object.put("error", "导入的模板数据有误");
            logger.error("导入的模板数据有误");
        }else{
            String entName = sheet.getRow(1).getCell(2).getStringCellValue();
            for (int r = 2; r < 15; r++) { //遍历有数据的行
                Row row = sheet.getRow(r);
                if(row != null){
                    logger.debug("row index: {}", r);
                    String projectName = Tools.getCellValue(row.getCell(1), wb);
                    BigDecimal c2 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(2), wb));

                    switch (r) {
                        case 2:
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c2,"DB_ZCNL_ZCFZL_BFB");
                            break;
                        case 3:
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c2,"DB_ZCNL_LDBL_BFB");
                            break;
                        case 4:
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c2,"DB_ZCNL_SDBL_BFB");
                            break;
                        case 5:
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c2,"DB_ZCNL_YSZKZZL_BFB");
                            break;
                        case 6:
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c2,"DB_YLNL_XSMLL_BFB");
                            break;
                        case 7:
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c2,"DB_YLNL_YSLL_BFB");
                            break;
                        case 8:
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c2,"DB_YLNL_CBFYLRL_BFB");
                            break;
                        case 9:
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c2,"DB_YLNL_QJFYL_BFB");
                            break;
                        case 10:
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c2,"BD_YLNL_NDSCL_BFB");
                            break;
                        case 11:
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c2,"DB_YLNL_ZCCCL_BFB");
                            break;
                        case 12:
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c2,"DB_CZX_ZCZZL_BFB");
                            break;
                        case 13:
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c2,"DB_CZX_XSMLL_BFB");
                            break;
                        case 14:
                            addNew(rcUser, companyNumber, period, indiceList, entName, r, projectName, c2,"DB_CZX_LRZZL_BFB");
                            break;
                        default:
                            break;
                    }
                }
            }
            insertBatch(indiceList);
            object.put("stateCode", 0);
            object.put("error", "导入成功");
        }
        return object;
    }
}
