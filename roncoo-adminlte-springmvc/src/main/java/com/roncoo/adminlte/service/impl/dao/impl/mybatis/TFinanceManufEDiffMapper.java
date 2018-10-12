package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceManufEDiff;
import com.roncoo.adminlte.bean.entity.TFinanceManufEDiffExample;
import com.roncoo.adminlte.bean.entity.TFinanceProfitDiff;
import com.roncoo.adminlte.util.base.MyBatis;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceManufEDiffMapper {
    int countByExample(TFinanceManufEDiffExample example);

    int deleteByExample(TFinanceManufEDiffExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TFinanceManufEDiff record);

    int insertBatch(@Param("list") List<TFinanceManufEDiff> list);

    int insertSelective(TFinanceManufEDiff record);

    List<TFinanceManufEDiff> selectByExample(TFinanceManufEDiffExample example);

    TFinanceManufEDiff selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TFinanceManufEDiff record, @Param("example") TFinanceManufEDiffExample example);

    int updateByExample(@Param("record") TFinanceManufEDiff record, @Param("example") TFinanceManufEDiffExample example);

    int updateByPrimaryKeySelective(TFinanceManufEDiff record);

    int updateByPrimaryKey(TFinanceManufEDiff record);
}