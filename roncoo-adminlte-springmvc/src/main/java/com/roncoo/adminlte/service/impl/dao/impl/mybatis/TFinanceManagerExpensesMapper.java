package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceManagerExpenses;
import com.roncoo.adminlte.bean.entity.TFinanceManagerExpensesExample;
import com.roncoo.adminlte.util.base.MyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatis
public interface TFinanceManagerExpensesMapper {
    int countByExample(TFinanceManagerExpensesExample example);

    int deleteByExample(TFinanceManagerExpensesExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TFinanceManagerExpenses record);

    int insertBatch(@Param("list") List<TFinanceManagerExpenses> list);

    int insertSelective(TFinanceManagerExpenses record);

    List<TFinanceManagerExpenses> selectByExample(TFinanceManagerExpensesExample example);

    TFinanceManagerExpenses selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TFinanceManagerExpenses record, @Param("example") TFinanceManagerExpensesExample example);

    int updateByExample(@Param("record") TFinanceManagerExpenses record, @Param("example") TFinanceManagerExpensesExample example);

    int updateByPrimaryKeySelective(TFinanceManagerExpenses record);

    int updateByPrimaryKey(TFinanceManagerExpenses record);
}