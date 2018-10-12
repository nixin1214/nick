package com.roncoo.adminlte.service.impl.dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.roncoo.adminlte.bean.entity.TExcelConfig;
import com.roncoo.adminlte.bean.entity.TExcelConfigExample;
import com.roncoo.adminlte.service.impl.dao.TExcelConfigDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TExcelConfigMapper;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: EXCEL配置类
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/11 11:44
 */
@Repository
public class TExcelConfigDaoImpl implements TExcelConfigDao {

    @Autowired
    private TExcelConfigMapper mapper;

    @Override
    public TExcelConfig selectById(long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public TExcelConfig selectByName(String roleName) {
        TExcelConfigExample example = new TExcelConfigExample();
        TExcelConfigExample.Criteria criteria = example.createCriteria();
        criteria.andFnameEqualTo(roleName);
        List<TExcelConfig> list = mapper.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public TExcelConfig selectByNumber(String number) {
        TExcelConfigExample example = new TExcelConfigExample();
        TExcelConfigExample.Criteria criteria = example.createCriteria();
        criteria.andFnumberEqualTo(number);
        List<TExcelConfig> list = mapper.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public int insert(TExcelConfig role) {
        return mapper.insert(role);
    }

    @Override
    public int update(TExcelConfig role) {
        return mapper.updateByPrimaryKey(role);
    }

    @Override
    public int deleteById(long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public Page<TExcelConfig> listForPage(int pageCurrent, int pageSize, String date, String search) {
        TExcelConfigExample example = new TExcelConfigExample();
        example.setOrderByClause("id desc");
        TExcelConfigExample.Criteria criteria = example.createCriteria();
        if (StringUtils.hasText(search)) {
            criteria.andFnameLike(SqlUtil.like(search));
        }
        PageHelper.startPage(pageCurrent, pageSize);
        List<TExcelConfig> list = mapper.selectByExample(example);
        PageInfo<TExcelConfig> pageInfo = new PageInfo<>(list);
        return new Page<>((int)pageInfo.getTotal(), pageInfo.getPages(), pageCurrent, pageSize, list);
    }

    @Override
    public List<TExcelConfig> listForId(List<Long> idList) {
        TExcelConfigExample example = new TExcelConfigExample();
        example.setOrderByClause("id desc");
        TExcelConfigExample.Criteria criteria = example.createCriteria();
        criteria.andFidIn(idList);
        return mapper.selectByExample(example);
    }

    @Override
    public List<TExcelConfig> list() {
        TExcelConfigExample example = new TExcelConfigExample();
        example.setOrderByClause("id desc");
        return mapper.selectByExample(example);
    }
}
