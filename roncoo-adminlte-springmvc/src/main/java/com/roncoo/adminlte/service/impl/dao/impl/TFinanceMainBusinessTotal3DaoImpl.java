package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessTotal3;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessTotal3Example;
import com.roncoo.adminlte.bean.entity.TFinanceProductCostThisExample;
import com.roncoo.adminlte.service.impl.dao.TFinanceMainBusinessTotal3Dao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TFinanceMainBusinessTotal3Mapper;
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
public class TFinanceMainBusinessTotal3DaoImpl implements TFinanceMainBusinessTotal3Dao {

    @Autowired
    private TFinanceMainBusinessTotal3Mapper mapper;

    @Override
    public int insert(TFinanceMainBusinessTotal3 fixedAssetsChange) {
        return mapper.insert(fixedAssetsChange);
    }

    @Override
    public int insertBatch(List<TFinanceMainBusinessTotal3> list) {
        return mapper.insertBatch(list);
    }

    @Override
    public int deleteById(BigDecimal id) {

        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByHeadId(Long headId) {
        TFinanceMainBusinessTotal3Example example = new TFinanceMainBusinessTotal3Example();
        TFinanceMainBusinessTotal3Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        return mapper.deleteByExample(example);
    }

    @Override
    public List<TFinanceMainBusinessTotal3> queryByProperty(TFinanceMainBusinessTotal3 expenses) {
        TFinanceMainBusinessTotal3Example example = new TFinanceMainBusinessTotal3Example();
        TFinanceMainBusinessTotal3Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(expenses.getFheadId());
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceMainBusinessTotal3> queryByHeadId(Long headId) {
        TFinanceMainBusinessTotal3Example example = new TFinanceMainBusinessTotal3Example();
        TFinanceMainBusinessTotal3Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceMainBusinessTotal3> queryByPropertyAll(List<Long> headIds) {
        TFinanceMainBusinessTotal3Example example = new TFinanceMainBusinessTotal3Example();
        TFinanceMainBusinessTotal3Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdIn(headIds);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }
}
