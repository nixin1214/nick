package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList3;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList3Example;
import com.roncoo.adminlte.bean.entity.TFinanceProductCostThisExample;
import com.roncoo.adminlte.service.impl.dao.TFinanceMainBusinessList3Dao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TFinanceMainBusinessList3Mapper;
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
public class TFinanceMainBusinessList3DaoImpl implements TFinanceMainBusinessList3Dao {

    @Autowired
    private TFinanceMainBusinessList3Mapper mapper;

    @Override
    public int insert(TFinanceMainBusinessList3 fixedAssetsChange) {
        return mapper.insert(fixedAssetsChange);
    }

    @Override
    public int insertBatch(List<TFinanceMainBusinessList3> list) {
        return mapper.insertBatch(list);
    }

    @Override
    public int deleteById(BigDecimal id) {

        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByHeadId(Long headId) {
        TFinanceMainBusinessList3Example example = new TFinanceMainBusinessList3Example();
        TFinanceMainBusinessList3Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        return mapper.deleteByExample(example);
    }

    @Override
    public List<TFinanceMainBusinessList3> queryByProperty(TFinanceMainBusinessList3 expenses) {
        TFinanceMainBusinessList3Example example = new TFinanceMainBusinessList3Example();
        TFinanceMainBusinessList3Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(expenses.getFheadId());
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceMainBusinessList3> queryByHeadId(Long headId) {
        TFinanceMainBusinessList3Example example = new TFinanceMainBusinessList3Example();
        TFinanceMainBusinessList3Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceMainBusinessList3> queryByPropertyAll(List<Long> headIds) {
        TFinanceMainBusinessList3Example example = new TFinanceMainBusinessList3Example();
        TFinanceMainBusinessList3Example.Criteria criteria = example.createCriteria();
        criteria.andFheadIdIn(headIds);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }
}
