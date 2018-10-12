package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.FinanceMainBusinessMonth;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessMDiff;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface BalanceMainBusinessMonthDiffDao {

    int insert(TFinanceMainBusinessMDiff obj);

    int insertBatch(@Param("list") List<TFinanceMainBusinessMDiff> list);

    int deleteById(Long id);

    int deleteByProperty(TFinanceMainBusinessMDiff obj);

    List<TFinanceMainBusinessMDiff> queryByProperty(Map map);

    List<TFinanceMainBusinessMDiff> queryByPropertyAndRowIndex(Map map);

}
