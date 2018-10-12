package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessTotal4;

import java.math.BigDecimal;
import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 产品成本汇总表(本月)
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:00
 */
public interface TFinanceMainBusinessTotal4Dao {

    int insert(TFinanceMainBusinessTotal4 milkCostTotal);

    int insertBatch(List<TFinanceMainBusinessTotal4> list);

    int deleteById(BigDecimal id);

    int deleteByHeadId(Long headId);

    List<TFinanceMainBusinessTotal4> queryByProperty(TFinanceMainBusinessTotal4 expenses);

    List<TFinanceMainBusinessTotal4> queryByHeadId(Long headId);

    List<TFinanceMainBusinessTotal4> queryByPropertyAll(List<Long> headIds);
}
