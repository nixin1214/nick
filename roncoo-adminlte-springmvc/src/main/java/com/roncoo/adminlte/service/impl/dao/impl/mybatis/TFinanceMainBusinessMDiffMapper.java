package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessMDiff;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessMDiffExample;
import com.roncoo.adminlte.util.base.MyBatis;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceMainBusinessMDiffMapper {
    int countByExample(TFinanceMainBusinessMDiffExample example);

    int deleteByExample(TFinanceMainBusinessMDiffExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TFinanceMainBusinessMDiff record);

    int insertSelective(TFinanceMainBusinessMDiff record);

    List<TFinanceMainBusinessMDiff> selectByExample(TFinanceMainBusinessMDiffExample example);

    TFinanceMainBusinessMDiff selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TFinanceMainBusinessMDiff record, @Param("example") TFinanceMainBusinessMDiffExample example);

    int updateByExample(@Param("record") TFinanceMainBusinessMDiff record, @Param("example") TFinanceMainBusinessMDiffExample example);

    int updateByPrimaryKeySelective(TFinanceMainBusinessMDiff record);

    int updateByPrimaryKey(TFinanceMainBusinessMDiff record);
}