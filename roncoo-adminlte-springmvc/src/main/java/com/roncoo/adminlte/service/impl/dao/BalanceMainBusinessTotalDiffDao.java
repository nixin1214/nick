package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.FinanceMainBusinessTotal;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessTDiff;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface BalanceMainBusinessTotalDiffDao {

    int insertBatch(@Param("list") List<TFinanceMainBusinessTDiff> list);

    int deleteByProperty(TFinanceMainBusinessTDiff obj);

    List<TFinanceMainBusinessTDiff> queryByProperty(Map map);

}
