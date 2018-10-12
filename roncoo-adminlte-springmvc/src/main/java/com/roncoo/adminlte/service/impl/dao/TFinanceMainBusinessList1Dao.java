package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList1;

import java.math.BigDecimal;
import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 产品成本汇总表(本月)
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:00
 */
public interface TFinanceMainBusinessList1Dao {

    int insert(TFinanceMainBusinessList1 milkCostTotal);

    int insertBatch(List<TFinanceMainBusinessList1> list);

    int deleteById(BigDecimal id);

    int deleteByHeadId(Long headId);

    List<TFinanceMainBusinessList1> queryByProperty(TFinanceMainBusinessList1 expenses);

    List<TFinanceMainBusinessList1> queryByHeadId(Long headId);

    List<TFinanceMainBusinessList1> queryByPropertyAll(List<Long> headIds);
}
