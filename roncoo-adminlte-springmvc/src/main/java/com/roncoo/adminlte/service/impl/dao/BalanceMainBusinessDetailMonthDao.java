package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.FinanceMainBusinessDetialMonth;
import com.roncoo.adminlte.bean.entity.FinanceMainBusinessTotal;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface BalanceMainBusinessDetailMonthDao {

    int insertBatch(@Param("list") List<FinanceMainBusinessDetialMonth> list);

    int deleteByProperty(FinanceMainBusinessDetialMonth obj);

    List<FinanceMainBusinessDetialMonth> queryByProperty(Map map);


}
