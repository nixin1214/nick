package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.BalanceCashFlow;
import com.roncoo.adminlte.bean.entity.TFinanceCashFlowDiff;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 现金流量
 * Created by lx on 2017/11/1.
 */
public interface BalanceCashFlowDiffDao {

    int insert(TFinanceCashFlowDiff obj);

    int insertBatch(@Param("list") List<TFinanceCashFlowDiff> list);

    int deleteById(Long id);

    int deleteByProperty(TFinanceCashFlowDiff obj);

    List<TFinanceCashFlowDiff> queryByProperty(Map map);

}
