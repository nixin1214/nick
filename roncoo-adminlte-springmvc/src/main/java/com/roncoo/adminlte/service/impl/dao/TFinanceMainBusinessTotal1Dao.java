package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessTotal1;

import java.math.BigDecimal;
import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 产品成本汇总表(本月)
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:00
 */
public interface TFinanceMainBusinessTotal1Dao {

    int insert(TFinanceMainBusinessTotal1 milkCostTotal);

    int insertBatch(List<TFinanceMainBusinessTotal1> list);

    int deleteById(BigDecimal id);

    int deleteByHeadId(Long headId);

    List<TFinanceMainBusinessTotal1> queryByProperty(TFinanceMainBusinessTotal1 expenses);

    List<TFinanceMainBusinessTotal1> queryByHeadId(Long headId);

    List<TFinanceMainBusinessTotal1> queryByPropertyAll(List<Long> headIds);
}
