package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList3;

import java.math.BigDecimal;
import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 产品成本汇总表(本月)
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:00
 */
public interface TFinanceMainBusinessList3Dao {

    int insert(TFinanceMainBusinessList3 milkCostTotal);

    int insertBatch(List<TFinanceMainBusinessList3> list);

    int deleteById(BigDecimal id);

    int deleteByHeadId(Long headId);

    List<TFinanceMainBusinessList3> queryByProperty(TFinanceMainBusinessList3 expenses);

    List<TFinanceMainBusinessList3> queryByHeadId(Long headId);

    List<TFinanceMainBusinessList3> queryByPropertyAll(List<Long> headIds);
}
