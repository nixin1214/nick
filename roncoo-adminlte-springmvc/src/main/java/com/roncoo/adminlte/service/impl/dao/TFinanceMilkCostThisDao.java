package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceMilkCostThis;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 乳制品成本明细表(本月)
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:00
 */
public interface TFinanceMilkCostThisDao {

    int insert(TFinanceMilkCostThis milkCostThis);

    int insertBatch(List<TFinanceMilkCostThis> list);

    int deleteById(Long id);

    int deleteByHeadId(long headId);

    List<TFinanceMilkCostThis> queryByProperty(TFinanceMilkCostThis expenses);

    List<TFinanceMilkCostThis> queryByHeadId(Long headId);
}
