package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceManufExpenses;
import com.roncoo.adminlte.bean.entity.TFinanceManufExpensesExample;
import com.roncoo.adminlte.util.base.MyBatis;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceManufExpensesMapper {
    int countByExample(TFinanceManufExpensesExample example);

    int deleteByExample(TFinanceManufExpensesExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TFinanceManufExpenses record);

    int insertBatch(@Param("list") List<TFinanceManufExpenses> list);

    int insertSelective(TFinanceManufExpenses record);

    List<TFinanceManufExpenses> selectByExample(TFinanceManufExpensesExample example);

    TFinanceManufExpenses selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TFinanceManufExpenses record, @Param("example") TFinanceManufExpensesExample example);

    int updateByExample(@Param("record") TFinanceManufExpenses record, @Param("example") TFinanceManufExpensesExample example);

    int updateByPrimaryKeySelective(TFinanceManufExpenses record);

    int updateByPrimaryKey(TFinanceManufExpenses record);
}