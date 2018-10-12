package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceManufEDiff;
import com.roncoo.adminlte.bean.entity.TFinanceManufExpenses;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 制造费用
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:01
 */
public interface TFinanceManufExpensesDiffDao {

    int insert(TFinanceManufEDiff fixedAssetsChange);

    int insertBatch(List<TFinanceManufEDiff> list);

    int deleteById(Long id);

    int deleteByHeadId(long headId);

    List<TFinanceManufEDiff> queryByHeadId(Long headId);
}
