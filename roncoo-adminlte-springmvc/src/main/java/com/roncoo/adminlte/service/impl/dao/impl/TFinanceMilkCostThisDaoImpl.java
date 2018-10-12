package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFinanceMilkCostThis;
import com.roncoo.adminlte.bean.entity.TFinanceMilkCostThisExample;
import com.roncoo.adminlte.service.impl.dao.TFinanceMilkCostThisDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TFinanceMilkCostThisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 乳制品成本明细表(本月)
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:37
 */
@Repository
public class TFinanceMilkCostThisDaoImpl implements TFinanceMilkCostThisDao {

    @Autowired
    private TFinanceMilkCostThisMapper mapper;

    @Override
    public int insert(TFinanceMilkCostThis fixedAssetsChange) {
        return mapper.insert(fixedAssetsChange);
    }

    @Override
    public int insertBatch(List<TFinanceMilkCostThis> list) {
        return mapper.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByHeadId(long headId) {
        TFinanceMilkCostThisExample example = new TFinanceMilkCostThisExample();
        TFinanceMilkCostThisExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        return mapper.deleteByExample(example);
    }

    @Override
    public List<TFinanceMilkCostThis> queryByProperty(TFinanceMilkCostThis expenses) {
        TFinanceMilkCostThisExample example = new TFinanceMilkCostThisExample();
        TFinanceMilkCostThisExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(expenses.getFheadId());
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceMilkCostThis> queryByHeadId(Long headId) {
        TFinanceMilkCostThisExample example = new TFinanceMilkCostThisExample();
        TFinanceMilkCostThisExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }
}
