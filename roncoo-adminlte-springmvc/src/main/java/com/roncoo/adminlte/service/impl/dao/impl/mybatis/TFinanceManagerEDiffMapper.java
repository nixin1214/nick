package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceManagerEDiff;
import com.roncoo.adminlte.bean.entity.TFinanceManagerEDiffExample;
import com.roncoo.adminlte.bean.entity.TFinanceManufEDiff;
import com.roncoo.adminlte.util.base.MyBatis;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceManagerEDiffMapper {
    int countByExample(TFinanceManagerEDiffExample example);

    int deleteByExample(TFinanceManagerEDiffExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TFinanceManagerEDiff record);

    int insertBatch(@Param("list") List<TFinanceManagerEDiff> list);

    int insertSelective(TFinanceManagerEDiff record);

    List<TFinanceManagerEDiff> selectByExample(TFinanceManagerEDiffExample example);

    TFinanceManagerEDiff selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TFinanceManagerEDiff record, @Param("example") TFinanceManagerEDiffExample example);

    int updateByExample(@Param("record") TFinanceManagerEDiff record, @Param("example") TFinanceManagerEDiffExample example);

    int updateByPrimaryKeySelective(TFinanceManagerEDiff record);

    int updateByPrimaryKey(TFinanceManagerEDiff record);
}