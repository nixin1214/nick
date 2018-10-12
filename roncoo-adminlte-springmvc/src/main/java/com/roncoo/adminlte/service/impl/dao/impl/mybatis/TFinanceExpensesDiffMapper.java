package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceExpensesDiff;
import com.roncoo.adminlte.bean.entity.TFinanceExpensesDiffExample;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessTDiff;
import com.roncoo.adminlte.util.base.MyBatis;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceExpensesDiffMapper {
    int countByExample(TFinanceExpensesDiffExample example);

    int deleteByExample(TFinanceExpensesDiffExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TFinanceExpensesDiff record);

    int insertBatch(@Param("list") List<TFinanceExpensesDiff> list);

    int insertSelective(TFinanceExpensesDiff record);

    List<TFinanceExpensesDiff> selectByExample(TFinanceExpensesDiffExample example);

    TFinanceExpensesDiff selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TFinanceExpensesDiff record, @Param("example") TFinanceExpensesDiffExample example);

    int updateByExample(@Param("record") TFinanceExpensesDiff record, @Param("example") TFinanceExpensesDiffExample example);

    int updateByPrimaryKeySelective(TFinanceExpensesDiff record);

    int updateByPrimaryKey(TFinanceExpensesDiff record);
}