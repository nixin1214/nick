package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList2;

import java.math.BigDecimal;
import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 产品成本汇总表(本月)
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:00
 */
public interface TFinanceMainBusinessList2Dao {

    int insert(TFinanceMainBusinessList2 milkCostTotal);

    int insertBatch(List<TFinanceMainBusinessList2> list);

    int deleteById(BigDecimal id);

    int deleteByHeadId(Long headId);

    List<TFinanceMainBusinessList2> queryByProperty(TFinanceMainBusinessList2 expenses);

    List<TFinanceMainBusinessList2> queryByHeadId(Long headId);

    List<TFinanceMainBusinessList2> queryByPropertyAll(List<Long> headIds);
}
