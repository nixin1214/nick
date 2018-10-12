package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.FinanceMainBusinessDetialMonth;
import com.roncoo.adminlte.bean.entity.FinanceMainBusinessDetialTotal;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface BalanceMainBusinessDetailTotalDao {

    int insertBatch(@Param("list") List<FinanceMainBusinessDetialTotal> list);

    int deleteByProperty(FinanceMainBusinessDetialTotal obj);

    List<FinanceMainBusinessDetialTotal> queryByProperty(Map map);

}
