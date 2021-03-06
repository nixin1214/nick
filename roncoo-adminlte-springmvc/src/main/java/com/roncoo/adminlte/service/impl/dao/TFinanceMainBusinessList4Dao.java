package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList4;

import java.math.BigDecimal;
import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 产品成本汇总表(本月)
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:00
 */
public interface TFinanceMainBusinessList4Dao {

    int insert(TFinanceMainBusinessList4 milkCostTotal);

    int insertBatch(List<TFinanceMainBusinessList4> list);

    int deleteById(BigDecimal id);

    int deleteByHeadId(Long headId);

    List<TFinanceMainBusinessList4> queryByProperty(TFinanceMainBusinessList4 expenses);

    List<TFinanceMainBusinessList4> queryByHeadId(Long headId);

    List<TFinanceMainBusinessList4> queryByPropertyAll(List<Long> headIds);
}
