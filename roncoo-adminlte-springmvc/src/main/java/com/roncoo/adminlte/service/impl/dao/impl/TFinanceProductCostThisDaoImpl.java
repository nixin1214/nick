package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFinanceProductCostThis;
import com.roncoo.adminlte.bean.entity.TFinanceProductCostThisExample;
import com.roncoo.adminlte.service.impl.dao.TFinanceProductCostThisDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TFinanceProductCostThisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 产品成本汇总表(本月)
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:37
 */
@Repository
public class TFinanceProductCostThisDaoImpl implements TFinanceProductCostThisDao {

    @Autowired
    private TFinanceProductCostThisMapper mapper;

    @Override
    public int insert(TFinanceProductCostThis fixedAssetsChange) {
        return mapper.insert(fixedAssetsChange);
    }

    @Override
    public int insertBatch(List<TFinanceProductCostThis> list) {
        return mapper.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByHeadId(long headId) {
        TFinanceProductCostThisExample example = new TFinanceProductCostThisExample();
        TFinanceProductCostThisExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        return mapper.deleteByExample(example);
    }

    @Override
    public List<TFinanceProductCostThis> queryByProperty(TFinanceProductCostThis expenses) {
        TFinanceProductCostThisExample example = new TFinanceProductCostThisExample();
        TFinanceProductCostThisExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(expenses.getFheadId());
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceProductCostThis> queryByHeadId(Long headId) {
        TFinanceProductCostThisExample example = new TFinanceProductCostThisExample();
        TFinanceProductCostThisExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceProductCostThis> queryByPropertyAll(List<Long> headIds) {
        TFinanceProductCostThisExample example = new TFinanceProductCostThisExample();
        TFinanceProductCostThisExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdIn(headIds);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }
}
