package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessTDiff;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessTDiffExample;
import com.roncoo.adminlte.bean.entity.TFinanceManagerEDiff;
import com.roncoo.adminlte.util.base.MyBatis;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceMainBusinessTDiffMapper {
    int countByExample(TFinanceMainBusinessTDiffExample example);

    int deleteByExample(TFinanceMainBusinessTDiffExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TFinanceMainBusinessTDiff record);

    int insertBatch(@Param("list") List<TFinanceMainBusinessTDiff> list);

    int insertSelective(TFinanceMainBusinessTDiff record);

    List<TFinanceMainBusinessTDiff> selectByExample(TFinanceMainBusinessTDiffExample example);

    TFinanceMainBusinessTDiff selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TFinanceMainBusinessTDiff record, @Param("example") TFinanceMainBusinessTDiffExample example);

    int updateByExample(@Param("record") TFinanceMainBusinessTDiff record, @Param("example") TFinanceMainBusinessTDiffExample example);

    int updateByPrimaryKeySelective(TFinanceMainBusinessTDiff record);

    int updateByPrimaryKey(TFinanceMainBusinessTDiff record);
}