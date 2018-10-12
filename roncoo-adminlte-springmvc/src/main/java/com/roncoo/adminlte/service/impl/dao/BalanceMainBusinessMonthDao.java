package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.FinanceMainBusinessMonth;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface BalanceMainBusinessMonthDao {

    int insert(FinanceMainBusinessMonth obj);

    int insertBatch(@Param("list") List<FinanceMainBusinessMonth> list);

    int deleteById(Long id);

    int deleteByProperty(FinanceMainBusinessMonth obj);

    List<FinanceMainBusinessMonth> queryByProperty(Map map);

    List<FinanceMainBusinessMonth> queryByPropertyAndRowIndex(Map map);

    List<FinanceMainBusinessMonth> queryByPropertyAll(List<Long> tfheadids);

}
