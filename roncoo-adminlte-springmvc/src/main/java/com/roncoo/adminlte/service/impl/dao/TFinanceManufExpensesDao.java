package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceManufExpenses;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 制造费用
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:01
 */
public interface TFinanceManufExpensesDao {

    int insert(TFinanceManufExpenses fixedAssetsChange);

    int insertBatch(List<TFinanceManufExpenses> list);

    int deleteById(Long id);

    int deleteByHeadId(long headId);

    List<TFinanceManufExpenses> queryByHeadId(Long headId);

    List<TFinanceManufExpenses> queryByPropertyAll(List<Long> tfheadids);
}
