package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceTaxSDiff;
import com.roncoo.adminlte.bean.entity.TFinanceTaxStatistics;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 税费统计表
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:00
 */
public interface TFinanceTaxStatisticsDiffDao {

    int insert(TFinanceTaxSDiff managerExpenses);

    int insertBatch(List<TFinanceTaxSDiff> list);

    int deleteById(Long id);

    int deleteByHeadId(long headId);

    List<TFinanceTaxSDiff> queryByHeadId(Long headId);
}
