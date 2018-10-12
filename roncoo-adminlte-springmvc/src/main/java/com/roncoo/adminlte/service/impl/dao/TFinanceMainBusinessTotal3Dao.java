package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessTotal3;

import java.math.BigDecimal;
import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 产品成本汇总表(本月)
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:00
 */
public interface TFinanceMainBusinessTotal3Dao {

    int insert(TFinanceMainBusinessTotal3 milkCostTotal);

    int insertBatch(List<TFinanceMainBusinessTotal3> list);

    int deleteById(BigDecimal id);

    int deleteByHeadId(Long headId);

    List<TFinanceMainBusinessTotal3> queryByProperty(TFinanceMainBusinessTotal3 expenses);

    List<TFinanceMainBusinessTotal3> queryByHeadId(Long headId);

    List<TFinanceMainBusinessTotal3> queryByPropertyAll(List<Long> headIds);
}
