package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFinanceExpenses;
import com.roncoo.adminlte.bean.entity.TFinanceExpensesExample;
import com.roncoo.adminlte.service.impl.dao.TFinanceExpensesDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TFinanceExpensesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 财务费用
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:37
 */
@Repository
public class TFinanceExpensesDaoImpl implements TFinanceExpensesDao {

    @Autowired
    private TFinanceExpensesMapper mapper;

    @Override
    public int insert(TFinanceExpenses fixedAssetsChange) {
        return mapper.insert(fixedAssetsChange);
    }

    @Override
    public int insertBatch(List<TFinanceExpenses> list) {
        return mapper.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByHeadId(long headId) {
        TFinanceExpensesExample example = new TFinanceExpensesExample();
        TFinanceExpensesExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        return mapper.deleteByExample(example);
    }

    @Override
    public List<TFinanceExpenses> queryByProperty(TFinanceExpenses expenses) {
        TFinanceExpensesExample example = new TFinanceExpensesExample();
        TFinanceExpensesExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(expenses.getFheadId());
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceExpenses> queryByHeadId(Long headId) {
        TFinanceExpensesExample example = new TFinanceExpensesExample();
        TFinanceExpensesExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceExpenses> queryByPropertyAll(List<Long> tfheadids) {
        TFinanceExpensesExample example = new TFinanceExpensesExample();
        TFinanceExpensesExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdIn(tfheadids);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }
}
