package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessTotal2;

import java.math.BigDecimal;
import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 产品成本汇总表(本月)
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:00
 */
public interface TFinanceMainBusinessTotal2Dao {

    int insert(TFinanceMainBusinessTotal2 milkCostTotal);

    int insertBatch(List<TFinanceMainBusinessTotal2> list);

    int deleteById(BigDecimal id);

    int deleteByHeadId(Long headId);

    List<TFinanceMainBusinessTotal2> queryByProperty(TFinanceMainBusinessTotal2 expenses);

    List<TFinanceMainBusinessTotal2> queryByHeadId(Long headId);

    List<TFinanceMainBusinessTotal2> queryByPropertyAll(List<Long> headIds);
}
