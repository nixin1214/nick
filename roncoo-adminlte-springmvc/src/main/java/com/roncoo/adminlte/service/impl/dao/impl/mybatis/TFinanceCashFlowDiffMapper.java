package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceCashFlowDiff;
import com.roncoo.adminlte.bean.entity.TFinanceCashFlowDiffExample;
import com.roncoo.adminlte.bean.entity.TFinanceExpensesDiff;
import com.roncoo.adminlte.util.base.MyBatis;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceCashFlowDiffMapper {
    int countByExample(TFinanceCashFlowDiffExample example);

    int deleteByExample(TFinanceCashFlowDiffExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TFinanceCashFlowDiff record);

    int insertBatch(@Param("list") List<TFinanceCashFlowDiff> list);

    int insertSelective(TFinanceCashFlowDiff record);

    List<TFinanceCashFlowDiff> selectByExample(TFinanceCashFlowDiffExample example);

    TFinanceCashFlowDiff selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TFinanceCashFlowDiff record, @Param("example") TFinanceCashFlowDiffExample example);

    int updateByExample(@Param("record") TFinanceCashFlowDiff record, @Param("example") TFinanceCashFlowDiffExample example);

    int updateByPrimaryKeySelective(TFinanceCashFlowDiff record);

    int updateByPrimaryKey(TFinanceCashFlowDiff record);
}