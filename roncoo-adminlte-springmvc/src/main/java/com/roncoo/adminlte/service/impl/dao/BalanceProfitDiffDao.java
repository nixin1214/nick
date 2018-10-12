package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceProfitDiff;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 利润表差额表
 * Created by lx on 2017/11/1.
 */
public interface BalanceProfitDiffDao {

    int insert(TFinanceProfitDiff obj);

    int insertBatch(@Param("list") List<TFinanceProfitDiff> list);

    int deleteById(Long id);

    int deleteByProperty(TFinanceProfitDiff obj);

    List<TFinanceProfitDiff> queryByProperty(Map map);

}
