package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList5;

import java.math.BigDecimal;
import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 产品成本汇总表(本月)
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:00
 */
public interface TFinanceMainBusinessList5Dao {

    int insert(TFinanceMainBusinessList5 milkCostTotal);

    int insertBatch(List<TFinanceMainBusinessList5> list);

    int deleteById(BigDecimal id);

    int deleteByHeadId(Long headId);

    List<TFinanceMainBusinessList5> queryByProperty(TFinanceMainBusinessList5 expenses);

    List<TFinanceMainBusinessList5> queryByHeadId(Long headId);

    List<TFinanceMainBusinessList5> queryByPropertyAll(List<Long> headIds);
}
