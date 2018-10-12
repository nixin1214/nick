package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceExpenses;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 财务费用
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:00
 */
public interface TFinanceExpensesDao {

    int insert(TFinanceExpenses fixedAssetsChange);

    int insertBatch(List<TFinanceExpenses> list);

    int deleteById(Long id);

    int deleteByHeadId(long headId);

    List<TFinanceExpenses> queryByProperty(TFinanceExpenses expenses);

    List<TFinanceExpenses> queryByHeadId(Long headId);

    List<TFinanceExpenses> queryByPropertyAll(List<Long> tfheadids);
}
