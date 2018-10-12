package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceProductCostTotal;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 产品成本汇总表(累计)
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:00
 */
public interface TFinanceProductCostTotalDao {

    int insert(TFinanceProductCostTotal milkCostTotal);

    int insertBatch(List<TFinanceProductCostTotal> list);

    int deleteById(Long id);

    int deleteByHeadId(long headId);

    List<TFinanceProductCostTotal> queryByProperty(TFinanceProductCostTotal expenses);

    List<TFinanceProductCostTotal> queryByHeadId(Long headId);

    List<TFinanceProductCostTotal> queryByPropertyAll(List<Long> headIds);
}
