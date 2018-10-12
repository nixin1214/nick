package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList8;

import java.math.BigDecimal;
import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 产品成本汇总表(本月)
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:00
 */
public interface TFinanceMainBusinessList8Dao {

    int insert(TFinanceMainBusinessList8 milkCostTotal);

    int insertBatch(List<TFinanceMainBusinessList8> list);

    int deleteById(BigDecimal id);

    int deleteByHeadId(Long headId);

    List<TFinanceMainBusinessList8> queryByProperty(TFinanceMainBusinessList8 expenses);

    List<TFinanceMainBusinessList8> queryByHeadId(Long headId);

    List<TFinanceMainBusinessList8> queryByPropertyAll(List<Long> headIds);
}
