package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessTotal2;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessTotal2Example;
import com.roncoo.adminlte.bean.entity.TFinanceProductCostThisExample;
import com.roncoo.adminlte.service.impl.dao.TFinanceMainBusinessTotal2Dao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TFinanceMainBusinessTotal2Mapper;
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
public class TFinanceMainBusinessTotal2DaoImpl implements TFinanceMainBusinessTotal2Dao {

    @Autowired
    private TFinanceMainBusinessTotal2Mapper mapper;

    @Override
    public int insert(TFinanceMainBusinessTotal2 fixedAssetsChange) {
        return mapper.insert(fixedAssetsChange);
    }

    @Override
    public int insertBatch(List<TFinanceMainBusinessTotal2> list) {
        return mapper.insertBatch(list);
    }

    @Override
    public int deleteById(BigDecimal id) {

        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByHeadId(Long headId) {
        TFinanceMainBusinessTotal2Example example = new TFinanceMainBusinessTotal2Example();
        TFinanceMainBusinessTotal2Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        return mapper.deleteByExample(example);
    }

    @Override
    public List<TFinanceMainBusinessTotal2> queryByProperty(TFinanceMainBusinessTotal2 expenses) {
        TFinanceMainBusinessTotal2Example example = new TFinanceMainBusinessTotal2Example();
        TFinanceMainBusinessTotal2Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(expenses.getFheadId());
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceMainBusinessTotal2> queryByHeadId(Long headId) {
        TFinanceMainBusinessTotal2Example example = new TFinanceMainBusinessTotal2Example();
        TFinanceMainBusinessTotal2Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceMainBusinessTotal2> queryByPropertyAll(List<Long> headIds) {
        TFinanceMainBusinessTotal2Example example = new TFinanceMainBusinessTotal2Example();
        TFinanceMainBusinessTotal2Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdIn(headIds);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }
}
