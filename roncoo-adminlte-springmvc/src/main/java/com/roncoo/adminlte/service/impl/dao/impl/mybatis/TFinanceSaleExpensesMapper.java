package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceSaleExpenses;
import com.roncoo.adminlte.bean.entity.TFinanceSaleExpensesExample;
import com.roncoo.adminlte.util.base.MyBatis;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceSaleExpensesMapper {
    int countByExample(TFinanceSaleExpensesExample example);

    int deleteByExample(TFinanceSaleExpensesExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TFinanceSaleExpenses record);

    int insertBatch(@Param("list") List<TFinanceSaleExpenses> list);

    int insertSelective(TFinanceSaleExpenses record);

    List<TFinanceSaleExpenses> selectByExample(TFinanceSaleExpensesExample example);

    TFinanceSaleExpenses selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TFinanceSaleExpenses record, @Param("example") TFinanceSaleExpensesExample example);

    int updateByExample(@Param("record") TFinanceSaleExpenses record, @Param("example") TFinanceSaleExpensesExample example);

    int updateByPrimaryKeySelective(TFinanceSaleExpenses record);

    int updateByPrimaryKey(TFinanceSaleExpenses record);
}