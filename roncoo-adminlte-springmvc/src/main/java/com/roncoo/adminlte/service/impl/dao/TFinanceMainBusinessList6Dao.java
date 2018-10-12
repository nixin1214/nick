package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList6;

import java.math.BigDecimal;
import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 产品成本汇总表(本月)
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:00
 */
public interface TFinanceMainBusinessList6Dao {

    int insert(TFinanceMainBusinessList6 milkCostTotal);

    int insertBatch(List<TFinanceMainBusinessList6> list);

    int deleteById(BigDecimal id);

    int deleteByHeadId(Long headId);

    List<TFinanceMainBusinessList6> queryByProperty(TFinanceMainBusinessList6 expenses);

    List<TFinanceMainBusinessList6> queryByHeadId(Long headId);

    List<TFinanceMainBusinessList6> queryByPropertyAll(List<Long> headIds);
}
