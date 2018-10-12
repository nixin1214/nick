package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.FinanceMainBusinessMonth;
import com.roncoo.adminlte.bean.entity.FinanceMainBusinessTotal;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface BalanceMainBusinessTotalDao {

    int insertBatch(@Param("list") List<FinanceMainBusinessTotal> list);

    int deleteByProperty(FinanceMainBusinessTotal obj);

    List<FinanceMainBusinessTotal> queryByProperty(Map map);

    List<FinanceMainBusinessTotal> queryByPropertyAll(List<Long> tfheadids);

}
