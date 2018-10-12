package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceSaleExpensesDiff;
import com.roncoo.adminlte.bean.entity.TFinanceSaleExpensesDiffExample;
import com.roncoo.adminlte.bean.entity.TFinanceTaxSDiff;
import com.roncoo.adminlte.util.base.MyBatis;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceSaleExpensesDiffMapper {
    int countByExample(TFinanceSaleExpensesDiffExample example);

    int deleteByExample(TFinanceSaleExpensesDiffExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TFinanceSaleExpensesDiff record);

    int insertBatch(@Param("list") List<TFinanceSaleExpensesDiff> list);

    int insertSelective(TFinanceSaleExpensesDiff record);

    List<TFinanceSaleExpensesDiff> selectByExample(TFinanceSaleExpensesDiffExample example);

    TFinanceSaleExpensesDiff selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TFinanceSaleExpensesDiff record, @Param("example") TFinanceSaleExpensesDiffExample example);

    int updateByExample(@Param("record") TFinanceSaleExpensesDiff record, @Param("example") TFinanceSaleExpensesDiffExample example);

    int updateByPrimaryKeySelective(TFinanceSaleExpensesDiff record);

    int updateByPrimaryKey(TFinanceSaleExpensesDiff record);
}