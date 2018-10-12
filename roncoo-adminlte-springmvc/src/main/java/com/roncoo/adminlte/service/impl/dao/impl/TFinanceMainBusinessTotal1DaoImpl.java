package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessTotal1;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessTotal1Example;
import com.roncoo.adminlte.bean.entity.TFinanceProductCostThisExample;
import com.roncoo.adminlte.service.impl.dao.TFinanceMainBusinessTotal1Dao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TFinanceMainBusinessTotal1Mapper;
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
public class TFinanceMainBusinessTotal1DaoImpl implements TFinanceMainBusinessTotal1Dao {

    @Autowired
    private TFinanceMainBusinessTotal1Mapper mapper;

    @Override
    public int insert(TFinanceMainBusinessTotal1 fixedAssetsChange) {
        return mapper.insert(fixedAssetsChange);
    }

    @Override
    public int insertBatch(List<TFinanceMainBusinessTotal1> list) {
        return mapper.insertBatch(list);
    }

    @Override
    public int deleteById(BigDecimal id) {

        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByHeadId(Long headId) {
        TFinanceMainBusinessTotal1Example example = new TFinanceMainBusinessTotal1Example();
        TFinanceMainBusinessTotal1Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        return mapper.deleteByExample(example);
    }

    @Override
    public List<TFinanceMainBusinessTotal1> queryByProperty(TFinanceMainBusinessTotal1 expenses) {
        TFinanceMainBusinessTotal1Example example = new TFinanceMainBusinessTotal1Example();
        TFinanceMainBusinessTotal1Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(expenses.getFheadId());
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceMainBusinessTotal1> queryByHeadId(Long headId) {
        TFinanceMainBusinessTotal1Example example = new TFinanceMainBusinessTotal1Example();
        TFinanceMainBusinessTotal1Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceMainBusinessTotal1> queryByPropertyAll(List<Long> headIds) {
        TFinanceMainBusinessTotal1Example example = new TFinanceMainBusinessTotal1Example();
        TFinanceMainBusinessTotal1Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdIn(headIds);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }
}
