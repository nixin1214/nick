package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessTotal4;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessTotal4Example;
import com.roncoo.adminlte.bean.entity.TFinanceProductCostThisExample;
import com.roncoo.adminlte.service.impl.dao.TFinanceMainBusinessTotal4Dao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TFinanceMainBusinessTotal4Mapper;
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
public class TFinanceMainBusinessTotal4DaoImpl implements TFinanceMainBusinessTotal4Dao {

    @Autowired
    private TFinanceMainBusinessTotal4Mapper mapper;

    @Override
    public int insert(TFinanceMainBusinessTotal4 fixedAssetsChange) {
        return mapper.insert(fixedAssetsChange);
    }

    @Override
    public int insertBatch(List<TFinanceMainBusinessTotal4> list) {
        return mapper.insertBatch(list);
    }

    @Override
    public int deleteById(BigDecimal id) {

        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByHeadId(Long headId) {
        TFinanceMainBusinessTotal4Example example = new TFinanceMainBusinessTotal4Example();
        TFinanceMainBusinessTotal4Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        return mapper.deleteByExample(example);
    }

    @Override
    public List<TFinanceMainBusinessTotal4> queryByProperty(TFinanceMainBusinessTotal4 expenses) {
        TFinanceMainBusinessTotal4Example example = new TFinanceMainBusinessTotal4Example();
        TFinanceMainBusinessTotal4Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(expenses.getFheadId());
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceMainBusinessTotal4> queryByHeadId(Long headId) {
        TFinanceMainBusinessTotal4Example example = new TFinanceMainBusinessTotal4Example();
        TFinanceMainBusinessTotal4Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceMainBusinessTotal4> queryByPropertyAll(List<Long> headIds) {
        TFinanceMainBusinessTotal4Example example = new TFinanceMainBusinessTotal4Example();
        TFinanceMainBusinessTotal4Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdIn(headIds);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }
}
