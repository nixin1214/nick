package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceSaleExpenses;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 销售费用
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:02
 */
public interface TFinanceSaleExpensesDao {

    int insert(TFinanceSaleExpenses managerExpenses);

    int insertBatch(List<TFinanceSaleExpenses> list);

    int deleteById(Long id);

    int deleteByHeadId(long headId);

    List<TFinanceSaleExpenses> queryByHeadId(Long headId);

    List<TFinanceSaleExpenses> queryByPropertyAll(List<Long> tfheadids);
}
