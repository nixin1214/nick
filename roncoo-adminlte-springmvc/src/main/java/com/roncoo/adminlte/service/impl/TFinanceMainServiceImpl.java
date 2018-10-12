package com.roncoo.adminlte.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TFinanceMain;
import com.roncoo.adminlte.bean.entity.TFinanceMainExample;
import com.roncoo.adminlte.bean.type.IndiceType;
import com.roncoo.adminlte.service.TFinanceMainService;
import com.roncoo.adminlte.service.impl.dao.TFinaceMainDao;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by lx on 2017/11/1.
 */
@Service
public class TFinanceMainServiceImpl implements TFinanceMainService {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TFinaceMainDao tFinaceMainDao;

    @Override
    public List<TFinanceMain> selectByExample(TFinanceMainExample tFinanceMainExample) {
        return tFinaceMainDao.selectByExample(tFinanceMainExample);
    }

    public List<BigDecimal> selectHeadId(String orgCode,String yearMonth){
        TFinanceMainExample example = new TFinanceMainExample();
        TFinanceMainExample.Criteria criteria = example.createCriteria();
        if (orgCode!=null){
            criteria.andFcompanyNumberEqualTo(orgCode);
        }
        if (yearMonth!=null){
            criteria.andFyearMonthEqualTo(yearMonth);
        }
        List<BigDecimal> resultList = new ArrayList<>();
        List<TFinanceMain> mainList = selectByExample(example);
        for (TFinanceMain main:mainList){
            resultList.add(new BigDecimal(main.getFid()));
        }
        return resultList;
    }

    @Override
    public TFinanceMain selectByPrimaryKey(Long id) {
        return tFinaceMainDao.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return tFinaceMainDao.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByExample(TFinanceMainExample tFinanceMainExample) {
        return tFinaceMainDao.deleteByExample(tFinanceMainExample);
    }

    @Override
    public int insert(TFinanceMain tFinanceMain) {
        return tFinaceMainDao.insert(tFinanceMain);
    }

    @Override
    public int insertSelective(TFinanceMain tFinanceMain) {
        return tFinaceMainDao.insertSelective(tFinanceMain);
    }

    @Override
    public int countByExample(TFinanceMainExample tFinanceMainExample) {
        return tFinaceMainDao.countByExample(tFinanceMainExample);
    }

    @Override
    public int updateByExampleSelective(Map map) {
        return tFinaceMainDao.updateByExampleSelective(map);
    }

    @Override
    public int updateByExample(Map map) {
        return tFinaceMainDao.updateByExample(map);
    }

    @Override
    public int updateByPrimaryKeySelective(TFinanceMain tFinanceMain) {
        return tFinaceMainDao.updateByPrimaryKeySelective(tFinanceMain);
    }

    @Override
    public int updateByPrimaryKey(TFinanceMain tFinanceMain) {
        return tFinaceMainDao.updateByPrimaryKey(tFinanceMain);
    }


    @Override
    public TFinanceMain selectByProperty(String fcompany_number, String fyear_month,String freport) {
        Map map = new HashMap();
        if (fcompany_number!=null) {
            map.put("fcompany_number", fcompany_number);
        }
        map.put("fyear_month",fyear_month);
        //map.put("freport",freport);
        List<TFinanceMain> result = tFinaceMainDao.selectByProperty(map);
        if (result.size()>0) {
            return result.get(0);
        }else{
            return null;
        }
    }

    /**
     * 新增公司期间记录
     *
     * @param companyNumber 公司编码
     * @param sheetName sheet页名称
     * @param period 期间
     * @param rcUser 操作用户
     * @return 记录ID
     */
    public Long addFinanceMain(String companyNumber,String sheetName,String period,RcUser rcUser){
        TFinanceMain tfmain = new TFinanceMain();
        if(rcUser!=null) tfmain.setFcreator(rcUser.getId());//操作用户id
        tfmain.setFcreatime(new Date());
        tfmain.setFupdatime(new Date());
        tfmain.setFcompanyNumber(companyNumber);
        tfmain.setFyearMonth(period);
        tfmain.setFstatus(String.valueOf(1));
        tfmain.setFreport(sheetName);
        int row = tFinaceMainDao.insert(tfmain);
        tfmain = selectByProperty(companyNumber,period,sheetName);
        Long fid = tfmain.getFid();
        logger.info("新增财务期间基础信息成功，公司：{}，期间：{}，用户：{}, 新记录fid:{}", companyNumber, period, rcUser.getUserNo(), fid);
        return  fid;
    }

    @Override
    public Long getOrAddFinanceMainId(String companyNumber, String sheetName, String period, RcUser rcUser) {
        TFinanceMain tfmain = selectByProperty(companyNumber,period,sheetName);
        Long id;
        if (tfmain != null) {
            id = tfmain.getFid();
        } else {
            id = addFinanceMain(companyNumber, sheetName, period, rcUser);
        }
        return id;
    }

    /**
     * 导出合并报表
     * @param rcUser 操作人
     * @param period 期间
     * @param request 请求对象
     * @param wb 模板对象
     */
    public void exportUnionReport(RcUser rcUser, String period, HttpServletRequest request, Workbook wb) {
        Map<Integer, String> unionReports = IndiceType.getUnionReport();
        for(Map.Entry<Integer, String> entry : unionReports.entrySet()) {
            switch (entry.getKey()) {
                case 1:
                    Sheet sheet = wb.getSheet(entry.getValue());

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    break;
                case 16:
                    break;
                case 17:
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * createUser 杨北平 to 2017-12-6
     * 根据月份查询出所有公司的报表数据（合并导出）
     * @param year_month
     * @return
     */
    @Override
    public JSONObject selectByMonth(String year_month) {
        Map map = new HashMap();
        map.put("fyear_month",year_month);
        List<TFinanceMain> tFinanceMains = tFinaceMainDao.selectByProperty(map);
        List<Long> fids = new ArrayList<>();
        Map<Long,String> resultMap = new HashMap<>();
        for(TFinanceMain tf :tFinanceMains){
            fids.add(tf.getFid());
            resultMap.put(tf.getFid(),tf.getFcompanyNumber());
        }
        JSONObject json = new JSONObject();
        json.put("resultMap",resultMap);
        json.put("fids",fids);
        return json;
    }
}
