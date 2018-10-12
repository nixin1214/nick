package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList5;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList5Example;
import com.roncoo.adminlte.bean.entity.TFinanceProductCostThisExample;
import com.roncoo.adminlte.service.impl.dao.TFinanceMainBusinessList5Dao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TFinanceMainBusinessList5Mapper;
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
public class TFinanceMainBusinessList5DaoImpl implements TFinanceMainBusinessList5Dao {

    @Autowired
    private TFinanceMainBusinessList5Mapper mapper;

    @Override
    public int insert(TFinanceMainBusinessList5 fixedAssetsChange) {
        return mapper.insert(fixedAssetsChange);
    }

    @Override
    public int insertBatch(List<TFinanceMainBusinessList5> list) {
        return mapper.insertBatch(list);
    }

    @Override
    public int deleteById(BigDecimal id) {

        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByHeadId(Long headId) {
        TFinanceMainBusinessList5Example example = new TFinanceMainBusinessList5Example();
        TFinanceMainBusinessList5Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        return mapper.deleteByExample(example);
    }

    @Override
    public List<TFinanceMainBusinessList5> queryByProperty(TFinanceMainBusinessList5 expenses) {
        TFinanceMainBusinessList5Example example = new TFinanceMainBusinessList5Example();
        TFinanceMainBusinessList5Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(expenses.getFheadId());
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceMainBusinessList5> queryByHeadId(Long headId) {
        TFinanceMainBusinessList5Example example = new TFinanceMainBusinessList5Example();
        TFinanceMainBusinessList5Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceMainBusinessList5> queryByPropertyAll(List<Long> headIds) {
        TFinanceMainBusinessList5Example example = new TFinanceMainBusinessList5Example();
        TFinanceMainBusinessList5Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdIn(headIds);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }
}
