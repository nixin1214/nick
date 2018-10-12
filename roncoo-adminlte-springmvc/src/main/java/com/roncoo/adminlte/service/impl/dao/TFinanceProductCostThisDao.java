package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceProductCostThis;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 产品成本汇总表(本月)
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:00
 */
public interface TFinanceProductCostThisDao {

    int insert(TFinanceProductCostThis milkCostTotal);

    int insertBatch(List<TFinanceProductCostThis> list);

    int deleteById(Long id);

    int deleteByHeadId(long headId);

    List<TFinanceProductCostThis> queryByProperty(TFinanceProductCostThis expenses);

    List<TFinanceProductCostThis> queryByHeadId(Long headId);

    List<TFinanceProductCostThis> queryByPropertyAll(List<Long> headIds);
}
