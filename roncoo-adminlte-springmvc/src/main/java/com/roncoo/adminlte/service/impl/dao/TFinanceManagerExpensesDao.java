package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceManagerExpenses;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: TODO
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:01
 */
public interface TFinanceManagerExpensesDao {

    int insert(TFinanceManagerExpenses managerExpenses);

    int insertBatch(List<TFinanceManagerExpenses> list);

    int deleteById(Long id);

    int deleteByHeadId(long headId);

    List<TFinanceManagerExpenses> queryByHeadId(Long headId);

    List<TFinanceManagerExpenses> queryByPropertyAll(List<Long> tfheadids);
}
