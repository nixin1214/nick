package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList1;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList1Example;
import com.roncoo.adminlte.bean.entity.TFinanceProductCostThisExample;
import com.roncoo.adminlte.service.impl.dao.TFinanceMainBusinessList1Dao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TFinanceMainBusinessList1Mapper;
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
public class TFinanceMainBusinessList1DaoImpl implements TFinanceMainBusinessList1Dao {

    @Autowired
    private TFinanceMainBusinessList1Mapper mapper;

    @Override
    public int insert(TFinanceMainBusinessList1 fixedAssetsChange) {
        return mapper.insert(fixedAssetsChange);
    }

    @Override
    public int insertBatch(List<TFinanceMainBusinessList1> list) {
        return mapper.insertBatch(list);
    }

    @Override
    public int deleteById(BigDecimal id) {

        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByHeadId(Long headId) {
        TFinanceMainBusinessList1Example example = new TFinanceMainBusinessList1Example();
        TFinanceMainBusinessList1Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        return mapper.deleteByExample(example);
    }

    @Override
    public List<TFinanceMainBusinessList1> queryByProperty(TFinanceMainBusinessList1 expenses) {
        TFinanceMainBusinessList1Example example = new TFinanceMainBusinessList1Example();
        TFinanceMainBusinessList1Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(expenses.getFheadId());
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceMainBusinessList1> queryByHeadId(Long headId) {
        TFinanceMainBusinessList1Example example = new TFinanceMainBusinessList1Example();
        TFinanceMainBusinessList1Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceMainBusinessList1> queryByPropertyAll(List<Long> headIds) {
        TFinanceMainBusinessList1Example example = new TFinanceMainBusinessList1Example();
        TFinanceMainBusinessList1Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdIn(headIds);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }
}
