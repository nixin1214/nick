package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceProfit;
import com.roncoo.adminlte.bean.entity.TFinanceProfitExample;
import java.math.BigDecimal;
import java.util.List;

import com.roncoo.adminlte.util.base.MyBatis;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceProfitMapper {
    long countByExample(TFinanceProfitExample example);

    int deleteByExample(TFinanceProfitExample example);

    int deleteByPrimaryKey(BigDecimal fid);

    int insert(TFinanceProfit record);

    int insertSelective(TFinanceProfit record);

    List<TFinanceProfit> selectByExample(TFinanceProfitExample example);

    TFinanceProfit selectByPrimaryKey(BigDecimal fid);

    int updateByExampleSelective(@Param("record") TFinanceProfit record, @Param("example") TFinanceProfitExample example);

    int updateByExample(@Param("record") TFinanceProfit record, @Param("example") TFinanceProfitExample example);

    int updateByPrimaryKeySelective(TFinanceProfit record);

    int updateByPrimaryKey(TFinanceProfit record);
}