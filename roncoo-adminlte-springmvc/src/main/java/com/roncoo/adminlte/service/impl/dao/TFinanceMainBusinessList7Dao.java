package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList7;

import java.math.BigDecimal;
import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 产品成本汇总表(本月)
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:00
 */
public interface TFinanceMainBusinessList7Dao {

    int insert(TFinanceMainBusinessList7 milkCostTotal);

    int insertBatch(List<TFinanceMainBusinessList7> list);

    int deleteById(BigDecimal id);

    int deleteByHeadId(Long headId);

    List<TFinanceMainBusinessList7> queryByProperty(TFinanceMainBusinessList7 expenses);

    List<TFinanceMainBusinessList7> queryByHeadId(Long headId);

    List<TFinanceMainBusinessList7> queryByPropertyAll(List<Long> headIds);
}
