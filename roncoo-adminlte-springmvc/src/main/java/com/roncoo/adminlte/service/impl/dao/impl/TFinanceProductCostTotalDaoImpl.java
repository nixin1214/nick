package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFinanceProductCostTotal;
import com.roncoo.adminlte.bean.entity.TFinanceProductCostTotalExample;
import com.roncoo.adminlte.service.impl.dao.TFinanceProductCostTotalDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TFinanceProductCostTotalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 产品成本汇总表(累计)
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:37
 */
@Repository
public class TFinanceProductCostTotalDaoImpl implements TFinanceProductCostTotalDao {

    @Autowired
    private TFinanceProductCostTotalMapper mapper;

    @Override
    public int insert(TFinanceProductCostTotal fixedAssetsChange) {
        return mapper.insert(fixedAssetsChange);
    }

    @Override
    public int insertBatch(List<TFinanceProductCostTotal> list) {
        return mapper.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByHeadId(long headId) {
        TFinanceProductCostTotalExample example = new TFinanceProductCostTotalExample();
        TFinanceProductCostTotalExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        return mapper.deleteByExample(example);
    }

    @Override
    public List<TFinanceProductCostTotal> queryByProperty(TFinanceProductCostTotal expenses) {
        TFinanceProductCostTotalExample example = new TFinanceProductCostTotalExample();
        TFinanceProductCostTotalExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(expenses.getFheadId());
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceProductCostTotal> queryByHeadId(Long headId) {
        TFinanceProductCostTotalExample example = new TFinanceProductCostTotalExample();
        TFinanceProductCostTotalExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceProductCostTotal> queryByPropertyAll(List<Long> headIds) {
        TFinanceProductCostTotalExample example = new TFinanceProductCostTotalExample();
        TFinanceProductCostTotalExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdIn(headIds);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }
}
