package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceSaleExpenses;
import com.roncoo.adminlte.bean.entity.TFinanceSaleExpensesDiff;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 销售费用
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:02
 */
public interface TFinanceSaleExpensesDiffDao {

    int insert(TFinanceSaleExpensesDiff managerExpenses);

    int insertBatch(List<TFinanceSaleExpensesDiff> list);

    int deleteById(Long id);

    int deleteByHeadId(long headId);

    List<TFinanceSaleExpensesDiff> queryByHeadId(Long headId);
}
