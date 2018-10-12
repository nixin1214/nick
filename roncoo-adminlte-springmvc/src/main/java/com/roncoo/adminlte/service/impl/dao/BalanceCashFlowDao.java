package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.BalanceCashFlow;
import com.roncoo.adminlte.bean.entity.BalanceProfit;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 现金流量
 * Created by lx on 2017/11/1.
 */
public interface BalanceCashFlowDao {

    int insert(BalanceCashFlow obj);

    int insertBatch(@Param("list") List<BalanceCashFlow> list);

    int deleteById(Long id);

    int deleteByProperty(BalanceCashFlow obj);

    List<BalanceCashFlow> queryByProperty(Map map);

    List<BalanceCashFlow> queryByPropertyAll(List<Long> tfheadids);
}
