package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList4;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList4Example;
import com.roncoo.adminlte.bean.entity.TFinanceProductCostThisExample;
import com.roncoo.adminlte.service.impl.dao.TFinanceMainBusinessList4Dao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TFinanceMainBusinessList4Mapper;
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
public class TFinanceMainBusinessList4DaoImpl implements TFinanceMainBusinessList4Dao {

    @Autowired
    private TFinanceMainBusinessList4Mapper mapper;

    @Override
    public int insert(TFinanceMainBusinessList4 fixedAssetsChange) {
        return mapper.insert(fixedAssetsChange);
    }

    @Override
    public int insertBatch(List<TFinanceMainBusinessList4> list) {
        return mapper.insertBatch(list);
    }

    @Override
    public int deleteById(BigDecimal id) {

        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByHeadId(Long headId) {
        TFinanceMainBusinessList4Example example = new TFinanceMainBusinessList4Example();
        TFinanceMainBusinessList4Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        return mapper.deleteByExample(example);
    }

    @Override
    public List<TFinanceMainBusinessList4> queryByProperty(TFinanceMainBusinessList4 expenses) {
        TFinanceMainBusinessList4Example example = new TFinanceMainBusinessList4Example();
        TFinanceMainBusinessList4Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(expenses.getFheadId());
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceMainBusinessList4> queryByHeadId(Long headId) {
        TFinanceMainBusinessList4Example example = new TFinanceMainBusinessList4Example();
        TFinanceMainBusinessList4Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceMainBusinessList4> queryByPropertyAll(List<Long> headIds) {
        TFinanceMainBusinessList4Example example = new TFinanceMainBusinessList4Example();
        TFinanceMainBusinessList4Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdIn(headIds);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }
}
