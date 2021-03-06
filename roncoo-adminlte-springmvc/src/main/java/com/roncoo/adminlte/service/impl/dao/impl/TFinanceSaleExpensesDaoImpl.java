package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFinanceSaleExpenses;
import com.roncoo.adminlte.bean.entity.TFinanceSaleExpensesExample;
import com.roncoo.adminlte.service.impl.dao.TFinanceSaleExpensesDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TFinanceSaleExpensesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 销售费用
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:44
 */
@Repository
public class TFinanceSaleExpensesDaoImpl implements TFinanceSaleExpensesDao {
    @Autowired
    private TFinanceSaleExpensesMapper mapper;

    @Override
    public int insert(TFinanceSaleExpenses managerExpenses) {
        return mapper.insert(managerExpenses);
    }

    @Override
    public int insertBatch(List<TFinanceSaleExpenses> list) {
        return mapper.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByHeadId(long headId) {
        TFinanceSaleExpensesExample example = new TFinanceSaleExpensesExample();
        TFinanceSaleExpensesExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        return mapper.deleteByExample(example);
    }

    @Override
    public List<TFinanceSaleExpenses> queryByHeadId(Long headId) {
        TFinanceSaleExpensesExample example = new TFinanceSaleExpensesExample();
        TFinanceSaleExpensesExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceSaleExpenses> queryByPropertyAll(List<Long> tfheadids) {
        TFinanceSaleExpensesExample example = new TFinanceSaleExpensesExample();
        TFinanceSaleExpensesExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdIn(tfheadids);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }
}
