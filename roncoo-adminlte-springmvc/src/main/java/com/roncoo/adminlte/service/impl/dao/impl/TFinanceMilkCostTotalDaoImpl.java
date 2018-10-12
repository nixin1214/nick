package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFinanceMilkCostTotal;
import com.roncoo.adminlte.bean.entity.TFinanceMilkCostTotalExample;
import com.roncoo.adminlte.service.impl.dao.TFinanceMilkCostTotalDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TFinanceMilkCostTotalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 乳制品成本明细表(累计)
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:37
 */
@Repository
public class TFinanceMilkCostTotalDaoImpl implements TFinanceMilkCostTotalDao {

    @Autowired
    private TFinanceMilkCostTotalMapper mapper;

    @Override
    public int insert(TFinanceMilkCostTotal fixedAssetsChange) {
        return mapper.insert(fixedAssetsChange);
    }

    @Override
    public int insertBatch(List<TFinanceMilkCostTotal> list) {
        return mapper.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByHeadId(long headId) {
        TFinanceMilkCostTotalExample example = new TFinanceMilkCostTotalExample();
        TFinanceMilkCostTotalExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        return mapper.deleteByExample(example);
    }

    @Override
    public List<TFinanceMilkCostTotal> queryByProperty(TFinanceMilkCostTotal expenses) {
        TFinanceMilkCostTotalExample example = new TFinanceMilkCostTotalExample();
        TFinanceMilkCostTotalExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(expenses.getFheadId());
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceMilkCostTotal> queryByHeadId(Long headId) {
        TFinanceMilkCostTotalExample example = new TFinanceMilkCostTotalExample();
        TFinanceMilkCostTotalExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }
}
