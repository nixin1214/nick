package com.roncoo.adminlte.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TBusinessQuota;
import com.roncoo.adminlte.bean.entity.TBusinessQuotaExample;
import com.roncoo.adminlte.bean.entity.TBusinessQuotaLog;
import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.service.BusinessQuotaService;
import com.roncoo.adminlte.service.impl.dao.BusinessQuotaDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TBusinessQuotaLogMapper;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TBusinessQuotaMapper;
import com.roncoo.adminlte.util.Tools;
import com.roncoo.adminlte.util.base.Page;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 业务指标服务层实现类
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/10/31 12:14
 */
@Service
public class BusinessQuotaServiceImpl implements BusinessQuotaService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BusinessQuotaDao dao;
    @Autowired
    private TBusinessQuotaLogMapper mapper;

    @Autowired
    private TBusinessQuotaMapper quotaMapper;

    @Override
    public List<Map<String, Object>> dynamicSql(String sql) {
        return dao.dynamicSql(sql);
    }

    public Result<Page<TBusinessQuota>> listForPage(int pageCurrent, int pageSize, String orgCode, String yearMonth, List<String> quotaName) {
        Result<Page<TBusinessQuota>> result = new Result<Page<TBusinessQuota>>();
        if (pageCurrent < 1) {
            result.setErrMsg("pageCurrent有误");
            return result;
        }
        if (pageSize < 1) {
            result.setErrMsg("pageSize有误");
            return result;
        }
        Page<TBusinessQuota> resultData = dao.listForPage(pageCurrent, pageSize, orgCode, yearMonth, quotaName);
        result.setResultData(resultData);
        result.setErrCode(0);
        result.setStatus(true);
        result.setErrMsg("查询成功");
        return result;
    }

    public Result<Page<TBusinessQuota>> listForPage(int pageCurrent, int pageSize, String orgCode, String yearMonth, String quotaName, List<String> companyList) {
        Result<Page<TBusinessQuota>> result = new Result<Page<TBusinessQuota>>();
        if (pageCurrent < 1) {
            result.setErrMsg("pageCurrent有误");
            return result;
        }
        if (pageSize < 1) {
            result.setErrMsg("pageSize有误");
            return result;
        }
        Page<TBusinessQuota> resultData = dao.listForPage(pageCurrent, pageSize, orgCode, yearMonth, quotaName, companyList);
        result.setResultData(resultData);
        result.setErrCode(0);
        result.setStatus(true);
        result.setErrMsg("查询成功");
        return result;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Result<Integer> update(TBusinessQuota quota, RcUser rcUser) {
        Result<Integer> result = new Result<Integer>();
        if (quota.getFvalue() == null) {
            result.setErrMsg("指标值不能为空");
            return result;
        }

        //添加修改记录
        TBusinessQuota oldQuota = dao.selectById(quota.getFid());
        TBusinessQuotaLog quotaLog = new TBusinessQuotaLog();
        quotaLog.setFcreatime(new Date());
        quotaLog.setFquotaId(oldQuota.getFid());
        quotaLog.setFquotaName(oldQuota.getFnameZh());
        quotaLog.setFquotaNameEn(oldQuota.getFnameEn());
        quotaLog.setFquotaOldValue(oldQuota.getFvalue());
        quotaLog.setFquotaNewValue(quota.getFvalue());
        quotaLog.setFuserNo(rcUser.getUserNo());
        quotaLog.setFuserId(rcUser.getId());
        quotaLog.setFuserName(rcUser.getNickName());
        quotaLog.setForgId(rcUser.getCompany().getId());
        mapper.insert(quotaLog);

        //修改指标值
        dao.updateByExample(quota);
        result.setErrCode(0);
        result.setStatus(true);
        return result;
    }

    @Transactional(readOnly = true)
    public Result<TBusinessQuota> query(long id) {
        Result<TBusinessQuota> result = new Result<TBusinessQuota>();
        if (id < 0) {
            result.setErrMsg("此id无效");
            return result;
        }
        TBusinessQuota quota = dao.selectById(id);
        if (quota != null) {
            result.setErrCode(0);
            result.setStatus(true);
            result.setResultData(quota);
        }
        return result;
    }

    public Result<Integer> addNew(TBusinessQuota quota) {
        Result<Integer> result = new Result<>();
        if (quota.getFvalue() == null) {
            result.setErrMsg("指标值不能为空");
            return result;
        } else if (org.apache.commons.lang.StringUtils.trimToNull(quota.getFyearMonth()) == null) {
            result.setErrMsg("期间不能为空");
            return result;
        } else if (org.apache.commons.lang.StringUtils.trimToNull(quota.getForgCode()) == null) {
            result.setErrMsg("组织不能为空");
            return result;
        }
        result.setResultData(dao.insert(quota));
        result.setStatus(true);
        return result;
    }

    @Override
    public Result<Integer> delete(TBusinessQuota quota) {
        Result<Integer> result = new Result<Integer>();
        if (StringUtils.isEmpty(quota.getForgCode())) {
            result.setErrMsg("组织编码不能为空");
            return result;
        } else if (StringUtils.isEmpty(quota.getFyearMonth())) {
            result.setErrMsg("期间不能为空");
            return result;
        } else if (StringUtils.isEmpty(quota.getFnameEn())) {
            result.setErrMsg("指标名称不能为空");
            return result;
        }
        result.setResultData(dao.deleteByProperty(quota));
        return result;
    }

    @Override
    @Transactional
    public JSONObject importMilkIndexData(RcUser rcUser, String companyNumber, String period, Workbook wb) {
        //导入上月的期间日期 201709
        logger.info("导入牛奶理化指标数据...期间：{}，当前组织：{}", period, companyNumber);

        JSONObject object = new JSONObject();
        Sheet sheet = wb.getSheet("牛奶质量指标");
        int rowCount = sheet.getPhysicalNumberOfRows();
        logger.debug("行数 rowCount={}", rowCount);
        if(rowCount<2){
            logger.error("导入的模板数据有误");
            object.put("stateCode", 0);
            object.put("error", "导入的模板数据有误");
        }else{
            Row row = sheet.getRow(1);
            BigDecimal c0 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(0), wb));
            BigDecimal c1 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(1), wb));
            BigDecimal c2 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(2), wb));
            BigDecimal c3 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(3), wb));
            TBusinessQuota quota = addNewQuota(rcUser, companyNumber, period, c0, "牛奶质量指标-体细胞含量", "NNZLZB-TXBHL");
            dao.deleteByProperty(quota);
            addNew(quota);

            TBusinessQuota quota1 = addNewQuota(rcUser, companyNumber, period, c1, "牛奶质量指标-微生物含量", "NNZLZB-WSWHL");
            dao.deleteByProperty(quota1);
            addNew(quota1);

            TBusinessQuota quota2 = addNewQuota(rcUser, companyNumber, period, c2, "牛奶质量指标-蛋白质含量", "NNZLZB-DBZHL");
            dao.deleteByProperty(quota2);
            addNew(quota2);

            TBusinessQuota quota3 = addNewQuota(rcUser, companyNumber, period, c3, "牛奶质量指标-脂肪含量", "NNZLZB-ZFHL");
            dao.deleteByProperty(quota3);
            addNew(quota3);
            logger.debug("牛奶质量指标导入成功，company:{}, user:{}, yearMonth:{}", companyNumber, rcUser.getUserNo(), period);
            object.put("stateCode", "200");
            object.put("error", "导入成功");
        }
        return object;
    }

    private TBusinessQuota addNewQuota(RcUser rcUser, String companyNumber, String period, BigDecimal c0, String nameZh, String nameEn) {
        TBusinessQuota quota1 = new TBusinessQuota();
        quota1.setFyearMonth(period);
        quota1.setFvalueType("NUMBER");
        quota1.setFvalue(c0);
        quota1.setFtype("牧场指标");
        quota1.setFresSys("EXCEL导入");
        quota1.setFnameZh(nameZh);
        quota1.setFnameEn(nameEn);
        quota1.setFdimension("月");
        quota1.setFcreatime(new Date());
        quota1.setForgCode(companyNumber);
        quota1.setFlastUpdator(rcUser.getUserNo());
        quota1.setFupdatime(new Date());
        quota1.setFunit("ml");
        return quota1;
    }

    /**
     *  杨北平    2018-02-26
     * @param orgCode
     * @param fnameEn
     * @return
     */
    public List<TBusinessQuota> queryQuota(String orgCode,String fnameEn,String fyearMonth,String fsmallClass){
        TBusinessQuotaExample example = new TBusinessQuotaExample();
        TBusinessQuotaExample.Criteria criteria = example.createCriteria();
        if (orgCode!=null) {
            criteria.andForgCodeEqualTo(orgCode);
        }
        if (fnameEn!=null){
            criteria.andFnameEnEqualTo(fnameEn);
        }
        if (fyearMonth!=null){
            criteria.andFyearMonthEqualTo(fyearMonth);
        }
        if (fsmallClass!=null&&fsmallClass!=""){
            criteria.andFsmallClassEqualTo(fsmallClass);
        }
        List<TBusinessQuota> list = this.quotaMapper.selectByExample(example);
        return list;
    }


    /**
     * 根据公司查询对应的指标项  杨北平   2018-02-26
     * @param orgCode
     * @return
     */
    @Override
    public JSONObject queryIndex(String orgCode,String fnameEn) {
        List<TBusinessQuota> list = queryQuota(orgCode,fnameEn,null,null);
        List<TBusinessQuota> resultList = new ArrayList<>();
        for (TBusinessQuota quota:list){
            boolean boo = false;
            for (TBusinessQuota quotaL:resultList){
                if (quota.getFnameEn().equals(quotaL.getFnameEn())){
                    boo = true;
                    continue;
                }
            }
            if (!boo){
                resultList.add(quota);
            }
        }
        JSONObject json = new JSONObject();
        json.put("resultList",resultList);
        return json;
    }



    /**
     * 查询出指标对应的细分类 杨北平   2018-02-26
     */
    @Override
    public JSONObject queryListOption(String orgCode,String fnameEn) {
        List<TBusinessQuota> list = queryQuota(orgCode,fnameEn,null,null);
        List<TBusinessQuota> resultList = new ArrayList<>();
        for (TBusinessQuota quota:list){
            boolean boo = true;
            if(quota.getFsmallClass()==null) {
                boo = false;
            }
            for (TBusinessQuota quotaL : resultList) {
                if (quota.getFsmallClass().equals(quotaL.getFsmallClass())) {
                    boo = false;
                    continue;
                }
            }
            if (boo){
                resultList.add(quota);
            }
        }
        JSONObject json = new JSONObject();
        json.put("resultList",resultList);
        return json;
    }

    /**
     * 牧场预算数据导入
     * @param wb excel对象
     * @param sheetName sheet页名称
     * @param companyNumber 公司编码
     * @param rcUser 操作用户
     * @return
     */
    @Override
    public JSONObject ranchBudget(Workbook wb, String sheetName, String companyNumber, RcUser rcUser){
        JSONObject object;
        object = ranchBudget1(wb, companyNumber, rcUser);
            if (object.getIntValue("stateCode") == 1) {
                return object;
            }
        return object;
    }

    /**
     * 华山牧乳业数据导入
     * @param wb
     * @param sheetName
     * @param companyNumber
     * @param rcUser
     * @return
     */
    @Override
    public JSONObject ranchBudgets(Workbook wb, String sheetName, String companyNumber, RcUser rcUser){
        JSONObject object;
        object = ranchBudget2(wb, companyNumber, rcUser);
        if (object.getIntValue("stateCode") == 1) {
            return object;
        }
        return object;
    }
    /**
     * 导入华山牧乳业每日快报总表预算数据
     * @param wb EXCEL对象
     * @param rcUser 用户
     * @param companyNumber 组织编码
     */
    public JSONObject ranchBudget2(Workbook wb,String companyNumber, RcUser rcUser){
        JSONObject object = new JSONObject();
        String nowYear = "";
        Sheet sheet = wb.getSheet("产销量预算表");
        int rowCount = sheet.getPhysicalNumberOfRows();
        logger.debug("行数 rowCount={}", rowCount);
        if(rowCount<14){
            object.put("stateCode", 1);
            object.put("error", "导入的模板数据有误");
            logger.error("导入的模板数据有误");
        }else {
            List<TBusinessQuota> quotas = new ArrayList<>();
            for (int r = 2; r < 15; r++) {
                TBusinessQuota quota ;
                Row row = sheet.getRow(r);
                if (row != null) {
                    logger.debug("row index: {}", r);
                    String c0 = Tools.getCellValue(row.getCell(0), wb).substring(0, 4);
                    nowYear = c0;
                    String c1 = Tools.getCellValue(row.getCell(1), wb);
                    if (c1.length() == 3) {
                        c1 = "0" + c1.substring(0, 1);
                    } else {
                        c1 = c1.substring(0, 2);
                    }
                    String yearMonth = c0 + c1;
                    BigDecimal c2 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(2), wb));
                    quota = addNew("本月预算商业奶低温","PJRCNL-BYSYDW",companyNumber,yearMonth,c2,"吨");
                    quotas.add(quota);
                    BigDecimal c3 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(3), wb));
                    TBusinessQuota quota1 ;
                    quota1 = addNew("本月预算商业奶常温","PJRCNL-BYSYCW",companyNumber,yearMonth,c3,"吨");
                    quotas.add(quota1);
                    BigDecimal c4 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(4), wb));
                    TBusinessQuota quota2 ;
                    quota2 = addNew("本月预算商业奶小计","PJRCNL-BYSYXJ",companyNumber,yearMonth,c4,"吨");
                    quotas.add(quota2);
                    BigDecimal c5 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(5), wb));
                    TBusinessQuota quota3 ;
                    quota3 = addNew("本月预算学生奶","PJRCNL-BYSYXSN",companyNumber,yearMonth,c5,"吨");
                    quotas.add(quota3);
                    BigDecimal c6= Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(6),wb));
                    TBusinessQuota quota4 ;
                    quota4 = addNew("本月预算全司合计","PJRCNL-BYSQSHJ",companyNumber,yearMonth,c6,"吨");
                    quotas.add(quota4);
                    BigDecimal c7= Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(7),wb));
                    TBusinessQuota quota5 ;
                    quota5 = addNew("本月预算华山牧乳业","PJRCNL-BYSHSMR",companyNumber,yearMonth,c7,"吨");
                    quotas.add(quota5);
                    BigDecimal c8= Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(8),wb));
                    TBusinessQuota quota6 ;
                    quota6 = addNew("本月预算中垦供应链","PJRCNL-BYSZKGY",companyNumber,yearMonth,c8,"吨");
                    quotas.add(quota6);

                    TBusinessQuota quota7 ;
                    BigDecimal c9 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(9), wb));
                    quota7 = addNew("本月商业低温奶销售额预算","BYDWNXSE-YS",companyNumber,yearMonth,c9,"万元");
                    quotas.add(quota7);
                    BigDecimal c10 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(10), wb));
                    TBusinessQuota quota8 ;
                    quota8 = addNew("本月商业常温奶销售额预算","BYCWNXSE-YS",companyNumber,yearMonth,c10,"万元");
                    quotas.add(quota8);
                    BigDecimal c11 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(11), wb));
                    TBusinessQuota quota9 ;
                    quota9 = addNew("本月商业奶销售额小计预算","BYSYNXSE-YS",companyNumber,yearMonth,c11,"万元");
                    quotas.add(quota9);
                    BigDecimal c12 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(12), wb));
                    TBusinessQuota quota10 ;
                    quota10 = addNew("本月学生奶销售额预算","BYXSNXSE-YS",companyNumber,yearMonth,c12,"万元");
                    quotas.add(quota10);
                    BigDecimal c13= Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(13),wb));
                    TBusinessQuota quota11 ;
                    quota11 = addNew("本月全司销售额合计预算","BYQSXSEHJ-YS",companyNumber,yearMonth,c13,"万元");
                    quotas.add(quota11);
                    BigDecimal c14= Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(14),wb));
                    TBusinessQuota quota12 ;
                    quota12 = addNew("本月华山牧乳业销售额预算","BYHSMRYXSE-YS",companyNumber,yearMonth,c14,"万元");
                    quotas.add(quota12);
                    BigDecimal c15= Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(15),wb));
                    TBusinessQuota quota13 ;
                    quota13 = addNew("本月中垦供应链销售额预算","BYKGYLXSE-YS",companyNumber,yearMonth,c15,"万元");
                    quotas.add(quota13);
                }
            }
            TBusinessQuota quota = new TBusinessQuota();
            quota.setFyearMonth(nowYear);
            quota.setForgCode(companyNumber);
            //删除销量指标数据
            quota.setFnameEn("PJRCNL-BYSYDW");
            dao.deleteByProperty(quota);
            quota.setFnameEn("PJRCNL-BYSYCW");
            dao.deleteByProperty(quota);
            quota.setFnameEn("PJRCNL-BYSYXJ");
            dao.deleteByProperty(quota);
            quota.setFnameEn("PJRCNL-BYSYXSN");
            dao.deleteByProperty(quota);
            quota.setFnameEn("PJRCNL-BYSQSHJ");
            dao.deleteByProperty(quota);
            quota.setFnameEn("PJRCNL-BYSHSMR");
            dao.deleteByProperty(quota);
            quota.setFnameEn("PJRCNL-BYSZKGY");
            dao.deleteByProperty(quota);
            //删除销售额指标数据
            quota.setFnameEn("BYDWNXSE-YS");
            dao.deleteByProperty(quota);
            quota.setFnameEn("BYCWNXSE-YS");
            dao.deleteByProperty(quota);
            quota.setFnameEn("BYSYNXSE-YS");
            dao.deleteByProperty(quota);
            quota.setFnameEn("BYXSNXSE-YS");
            dao.deleteByProperty(quota);
            quota.setFnameEn("BYQSXSEHJ-YS");
            dao.deleteByProperty(quota);
            quota.setFnameEn("BYHSMRYXSE-YS");
            dao.deleteByProperty(quota);
            quota.setFnameEn("BYZKGYLXSE-YS");
            dao.deleteByProperty(quota);
            //导入数据
            this.dao.insertBatch(quotas);
            object.put("stateCode", 0);
            object.put("error", "导入成功");
        }
        return object;
    }
    /**
     * 导入牧场预算数据
     * @param wb EXCEL对象
     * @param rcUser 用户
     * @param companyNumber 组织编码
     */
    public JSONObject ranchBudget1(Workbook wb,String companyNumber, RcUser rcUser){
        JSONObject object = new JSONObject();
        String nowYear = "";
        Sheet sheet = wb.getSheet("产销量预算表");
        int rowCount = sheet.getPhysicalNumberOfRows();
        logger.debug("行数 rowCount={}", rowCount);
        if(rowCount<14){
            object.put("stateCode", 1);
            object.put("error", "导入的模板数据有误");
            logger.error("导入的模板数据有误");
        }else {
            List<TBusinessQuota> quotas = new ArrayList<>();
            for(int r = 2;r < 15;r++){
                TBusinessQuota quota = new TBusinessQuota();
                Row row = sheet.getRow(r);
                if(row != null){
                    logger.debug("row index: {}", r);
                    String c0 = Tools.getCellValue(row.getCell(0), wb).substring(0,4);
                    nowYear = c0;
                    String c1 = Tools.getCellValue(row.getCell(1), wb);
                    if(c1.length()==3){
                        c1 = "0" + c1.substring(0,1);
                    }else {
                        c1 = c1.substring(0,2);
                    }
                    String yearMonth = c0+c1;
                    BigDecimal c2 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(3), wb));
                    quota = addNew("本月预算产奶总量","PJRCNL-BYCN",companyNumber,yearMonth,c2,"吨");
                    quotas.add(quota);
                    BigDecimal c3 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(4), wb));
                    TBusinessQuota quota1 = new TBusinessQuota();
                    quota1 =addNew("本月预算销售量","PJRCNL-BYXL",companyNumber,yearMonth,c3,"吨");
                    quotas.add(quota1);
                    BigDecimal c4 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(5), wb));
                    TBusinessQuota quota2 = new TBusinessQuota();
                    quota2 =addNew("当月预算日均产奶总量","PJRCNL-RJCN",companyNumber,yearMonth,c4,"吨");
                    quotas.add(quota2);
                    BigDecimal c5 = Tools.getDecimalCellValue(Tools.getCellValue(row.getCell(6), wb));
                    TBusinessQuota quota3 = new TBusinessQuota();
                    quota3 =addNew("当月预算日均销售量","PJRCNL-RJXL",companyNumber,yearMonth,c5,"吨");
                    quotas.add(quota3);

                }
            }

            TBusinessQuota quota = new TBusinessQuota();
            quota.setFyearMonth(nowYear);
            quota.setForgCode(companyNumber);
            quota.setFnameEn("PJRCNL-BYCN");
            dao.deleteByProperty(quota);
            quota.setFnameEn("PJRCNL-BYXL");
            dao.deleteByProperty(quota);
            quota.setFnameEn("PJRCNL-RJCN");
            dao.deleteByProperty(quota);
            quota.setFnameEn("PJRCNL-RJXL");
            dao.deleteByProperty(quota);
            this.dao.insertBatch(quotas);
            object.put("stateCode", 0);
            object.put("error", "导入成功");
        }
        return object;
    }

    private TBusinessQuota addNew(String FnameZh,String FnameEn,String companyNumber,String yearMonth,BigDecimal c2,String dw){
        TBusinessQuota quota = new TBusinessQuota();
        quota.setForgCode(companyNumber);
        quota.setFyearMonth(yearMonth);
        quota.setFvalueType("number");
        quota.setFtype("导入");
        quota.setFunit("吨");
        quota.setFdimension("月");
        quota.setFnameZh(FnameZh);
        quota.setFnameEn(FnameEn);
        quota.setFvalue(c2);
            return quota;
    }




}
