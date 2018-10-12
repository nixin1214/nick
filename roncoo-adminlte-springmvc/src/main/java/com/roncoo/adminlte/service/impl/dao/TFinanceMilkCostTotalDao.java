package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceMilkCostTotal;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 乳制品成本明细表(累计)
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:00
 */
public interface TFinanceMilkCostTotalDao {

    int insert(TFinanceMilkCostTotal milkCostTotal);

    int insertBatch(List<TFinanceMilkCostTotal> list);

    int deleteById(Long id);

    int deleteByHeadId(long headId);

    List<TFinanceMilkCostTotal> queryByProperty(TFinanceMilkCostTotal expenses);

    List<TFinanceMilkCostTotal> queryByHeadId(Long headId);
}
