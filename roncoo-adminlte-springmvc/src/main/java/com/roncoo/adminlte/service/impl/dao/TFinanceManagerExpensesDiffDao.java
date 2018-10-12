package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceManagerEDiff;
import com.roncoo.adminlte.bean.entity.TFinanceManagerExpenses;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: TODO
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:01
 */
public interface TFinanceManagerExpensesDiffDao {

    int insert(TFinanceManagerEDiff managerExpenses);

    int insertBatch(List<TFinanceManagerEDiff> list);

    int deleteById(Long id);

    int deleteByHeadId(long headId);

    List<TFinanceManagerEDiff> queryByHeadId(Long headId);
}
