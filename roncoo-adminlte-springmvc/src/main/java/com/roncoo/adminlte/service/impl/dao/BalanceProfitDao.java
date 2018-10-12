package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.BalanceProfit;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 利润表
 * Created by lx on 2017/11/1.
 */
public interface BalanceProfitDao {

    int insert(BalanceProfit obj);

    int insertBatch(@Param("list") List<BalanceProfit> list);

    int deleteById(Long id);

    int deleteByProperty(BalanceProfit obj);

    List<BalanceProfit> queryByProperty(Map map);

    List<BalanceProfit> queryByPropertyAll(List<Long> tfheadids);

}
