package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceTaxStatistics;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 税费统计表
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:00
 */
public interface TFinanceTaxStatisticsDao {

    int insert(TFinanceTaxStatistics managerExpenses);

    int insertBatch(List<TFinanceTaxStatistics> list);

    int deleteById(Long id);

    int deleteByHeadId(long headId);

    List<TFinanceTaxStatistics> queryByHeadId(Long headId);

    List<TFinanceTaxStatistics> queryByPropertyAll(List<Long> tfheadids);
}
