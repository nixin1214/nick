package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList7;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList7Example;
import com.roncoo.adminlte.bean.entity.TFinanceProductCostThisExample;
import com.roncoo.adminlte.service.impl.dao.TFinanceMainBusinessList7Dao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TFinanceMainBusinessList7Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 产品成本汇总表(本月)
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:37
 */
@Repository
public class TFinanceMainBusinessList7DaoImpl implements TFinanceMainBusinessList7Dao {

    @Autowired
    private TFinanceMainBusinessList7Mapper mapper;

    @Override
    public int insert(TFinanceMainBusinessList7 fixedAssetsChange) {
        return mapper.insert(fixedAssetsChange);
    }

    @Override
    public int insertBatch(List<TFinanceMainBusinessList7> list) {
        return mapper.insertBatch(list);
    }

    @Override
    public int deleteById(BigDecimal id) {

        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByHeadId(Long headId) {
        TFinanceMainBusinessList7Example example = new TFinanceMainBusinessList7Example();
        TFinanceMainBusinessList7Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        return mapper.deleteByExample(example);
    }

    @Override
    public List<TFinanceMainBusinessList7> queryByProperty(TFinanceMainBusinessList7 expenses) {
        TFinanceMainBusinessList7Example example = new TFinanceMainBusinessList7Example();
        TFinanceMainBusinessList7Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(expenses.getFheadId());
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceMainBusinessList7> queryByHeadId(Long headId) {
        TFinanceMainBusinessList7Example example = new TFinanceMainBusinessList7Example();
        TFinanceMainBusinessList7Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceMainBusinessList7> queryByPropertyAll(List<Long> headIds) {
        TFinanceMainBusinessList7Example example = new TFinanceMainBusinessList7Example();
        TFinanceMainBusinessList7Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdIn(headIds);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }
}
