package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFinanceExpenses;
import com.roncoo.adminlte.bean.entity.TFinanceExpensesDiff;
import com.roncoo.adminlte.bean.entity.TFinanceExpensesDiffExample;
import com.roncoo.adminlte.bean.entity.TFinanceExpensesExample;
import com.roncoo.adminlte.service.impl.dao.TFinanceExpensesDao;
import com.roncoo.adminlte.service.impl.dao.TFinanceExpensesDiffDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TFinanceExpensesDiffMapper;
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
public class TFinanceExpensesDiffDaoImpl implements TFinanceExpensesDiffDao {

    @Autowired
    private TFinanceExpensesDiffMapper mapper;

    @Override
    public int insert(TFinanceExpensesDiff fixedAssetsChange) {
        return mapper.insert(fixedAssetsChange);
    }

    @Override
    public int insertBatch(List<TFinanceExpensesDiff> list) {
        return mapper.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByHeadId(long headId) {
        TFinanceExpensesDiffExample example = new TFinanceExpensesDiffExample();
        TFinanceExpensesDiffExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        return mapper.deleteByExample(example);
    }

    @Override
    public List<TFinanceExpensesDiff> queryByProperty(TFinanceExpensesDiff expenses) {
        TFinanceExpensesDiffExample example = new TFinanceExpensesDiffExample();
        TFinanceExpensesDiffExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(expenses.getFheadId());
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceExpensesDiff> queryByHeadId(Long headId) {
        TFinanceExpensesDiffExample example = new TFinanceExpensesDiffExample();
        TFinanceExpensesDiffExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }
}
