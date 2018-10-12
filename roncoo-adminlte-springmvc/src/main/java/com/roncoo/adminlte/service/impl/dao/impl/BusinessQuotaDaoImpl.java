package com.roncoo.adminlte.service.impl.dao.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.roncoo.adminlte.bean.entity.TBusinessQuota;
import com.roncoo.adminlte.bean.entity.TBusinessQuotaExample;
import com.roncoo.adminlte.service.impl.dao.BusinessQuotaDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TBusinessQuotaMapper;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 业务指标DAO实现类
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/10/31 12:11
 */
@Repository
public class BusinessQuotaDaoImpl implements BusinessQuotaDao {

    @Autowired
    private TBusinessQuotaMapper mapper;

    @Override
    public List<Map<String, Object>> dynamicSql(String sql) {
        return mapper.dynamicSql(sql);
    }

    @Override
    public int insert(TBusinessQuota businessQuota) {
        return mapper.insert(businessQuota);
    }

    @Override
    public Page<TBusinessQuota> listForPage(int pageCurrent, int pageSize, String orgCode, String yearMonth, List<String> quotaName) {
        TBusinessQuotaExample example = new TBusinessQuotaExample();
        example.setOrderByClause("fid desc");
        TBusinessQuotaExample.Criteria criteria = example.createCriteria();
        if (StringUtils.hasText(orgCode)) {
            criteria.andForgCodeEqualTo(orgCode);
        }
        if (quotaName.size()>0) {
            criteria.andFnameEnIn(quotaName);
        }
        if (StringUtils.hasText(yearMonth)) {
            criteria.andFyearMonthLike(SqlUtil.like(yearMonth));
        }
        PageHelper.startPage(pageCurrent, pageSize);
        List<TBusinessQuota> list = mapper.selectByExample(example);
        PageInfo<TBusinessQuota> pageInfo = new PageInfo<>(list);
        return new Page<>((int)pageInfo.getTotal(), pageInfo.getPages(), pageCurrent, pageSize, list);
    }

    @Override
    public Page<TBusinessQuota> listForPage(int pageCurrent, int pageSize, String orgCode, String yearMonth, String quotaName, List<String> companyList) {
        TBusinessQuotaExample example = new TBusinessQuotaExample();
        example.setOrderByClause("fyear_month desc");
        TBusinessQuotaExample.Criteria criteria = example.createCriteria();
        if (StringUtils.hasText(orgCode)) {
            if (orgCode.equals("all")) {//组织范围查询
                criteria.andForgCodeIn(companyList);
            }else {
                criteria.andForgCodeEqualTo(orgCode);
            }
        }
        if (StringUtils.hasText(quotaName)) {
            criteria.andFnameZhLike(SqlUtil.like(quotaName));
        }
        if (StringUtils.hasText(yearMonth) && !yearMonth.equals("all")) {
            criteria.andFyearMonthEqualTo(yearMonth);
        }
        PageHelper.startPage(pageCurrent, pageSize);
        List<TBusinessQuota> list = mapper.selectByExample(example);
        PageInfo<TBusinessQuota> pageInfo = new PageInfo<>(list);
        return new Page<>((int)pageInfo.getTotal(), pageInfo.getPages(), pageCurrent, pageSize, list);
    }

    @Override
    public TBusinessQuota selectById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateById(TBusinessQuota quota) {
        return mapper.updateByPrimaryKey(quota);
    }

    @Override
    public int insertBatch(List<TBusinessQuota> list) {
        return mapper.insertBatch(list);
    }
    public int updateByExample(TBusinessQuota quota) {
        TBusinessQuota quotaNew = new TBusinessQuota();
        quotaNew.setFvalue(quota.getFvalue());
        quotaNew.setFlastUpdator(quota.getFlastUpdator());
        quotaNew.setFupdatime(quota.getFupdatime());
        quotaNew.setFremark(quota.getFremark());
        quotaNew.setFid(quota.getFid());
        return mapper.updateByPrimaryKeySelective(quotaNew);
    }

    public int deleteByProperty(TBusinessQuota quota) {
        TBusinessQuotaExample example = new TBusinessQuotaExample();
        TBusinessQuotaExample.Criteria criteria = example.createCriteria();
        if (quota.getFyearMonth().length()>5) {
            criteria.andFyearMonthEqualTo(quota.getFyearMonth());
        }else {
            criteria.andFyearMonthLike(SqlUtil.like(quota.getFyearMonth()));
        }
        criteria.andForgCodeEqualTo(quota.getForgCode());
        criteria.andFnameEnEqualTo(quota.getFnameEn());
        return mapper.deleteByExample(example);
    }


}
