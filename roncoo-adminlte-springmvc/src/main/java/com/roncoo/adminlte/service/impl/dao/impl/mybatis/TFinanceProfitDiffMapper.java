package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceProfitDiff;
import com.roncoo.adminlte.bean.entity.TFinanceProfitDiffExample;
import com.roncoo.adminlte.bean.entity.TFinanceSaleExpensesDiff;
import com.roncoo.adminlte.util.base.MyBatis;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceProfitDiffMapper {
    int countByExample(TFinanceProfitDiffExample example);

    int deleteByExample(TFinanceProfitDiffExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TFinanceProfitDiff record);

    int insertBatch(@Param("list") List<TFinanceProfitDiff> list);

    int insertSelective(TFinanceProfitDiff record);

    List<TFinanceProfitDiff> selectByExample(TFinanceProfitDiffExample example);

    TFinanceProfitDiff selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TFinanceProfitDiff record, @Param("example") TFinanceProfitDiffExample example);

    int updateByExample(@Param("record") TFinanceProfitDiff record, @Param("example") TFinanceProfitDiffExample example);

    int updateByPrimaryKeySelective(TFinanceProfitDiff record);

    int updateByPrimaryKey(TFinanceProfitDiff record);
}