package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFinanceManagerExpenses;
import com.roncoo.adminlte.bean.entity.TFinanceManagerExpensesExample;
import com.roncoo.adminlte.service.impl.dao.TFinanceManagerExpensesDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TFinanceManagerExpensesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 管理费用
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:42
 */
@Repository
public class TFinanceManagerExpensesDaoImpl implements TFinanceManagerExpensesDao {

    @Autowired
    private TFinanceManagerExpensesMapper mapper;

    @Override
    public int insert(TFinanceManagerExpenses managerExpenses) {
        return mapper.insert(managerExpenses);
    }

    @Override
    public int insertBatch(List<TFinanceManagerExpenses> list) {
        return mapper.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByHeadId(long headId) {
        TFinanceManagerExpensesExample example = new TFinanceManagerExpensesExample();
        TFinanceManagerExpensesExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        return mapper.deleteByExample(example);
    }

    @Override
    public List<TFinanceManagerExpenses> queryByHeadId(Long headId) {
        TFinanceManagerExpensesExample example = new TFinanceManagerExpensesExample();
        TFinanceManagerExpensesExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceManagerExpenses> queryByPropertyAll(List<Long> tfheadids) {
        TFinanceManagerExpensesExample example = new TFinanceManagerExpensesExample();
        TFinanceManagerExpensesExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdIn(tfheadids);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }
}
