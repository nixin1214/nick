package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceExpenses;
import com.roncoo.adminlte.bean.entity.TFinanceExpensesDiff;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 财务费用
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:00
 */
public interface TFinanceExpensesDiffDao {

    int insert(TFinanceExpensesDiff fixedAssetsChange);

    int insertBatch(List<TFinanceExpensesDiff> list);

    int deleteById(Long id);

    int deleteByHeadId(long headId);

    List<TFinanceExpensesDiff> queryByProperty(TFinanceExpensesDiff expenses);

    List<TFinanceExpensesDiff> queryByHeadId(Long headId);
}
