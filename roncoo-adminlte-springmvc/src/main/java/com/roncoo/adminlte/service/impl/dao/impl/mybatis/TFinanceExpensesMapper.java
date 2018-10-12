package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceExpenses;
import com.roncoo.adminlte.bean.entity.TFinanceExpensesExample;
import com.roncoo.adminlte.util.base.MyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatis
public interface TFinanceExpensesMapper {
    int countByExample(TFinanceExpensesExample example);

    int deleteByExample(TFinanceExpensesExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TFinanceExpenses record);

    int insertBatch(@Param("list") List<TFinanceExpenses> list);

    int insertSelective(TFinanceExpenses record);

    List<TFinanceExpenses> selectByExample(TFinanceExpensesExample example);

    TFinanceExpenses selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TFinanceExpenses record, @Param("example") TFinanceExpensesExample example);

    int updateByExample(@Param("record") TFinanceExpenses record, @Param("example") TFinanceExpensesExample example);

    int updateByPrimaryKeySelective(TFinanceExpenses record);

    int updateByPrimaryKey(TFinanceExpenses record);
}