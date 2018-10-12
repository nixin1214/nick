package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceTaxSDiff;
import com.roncoo.adminlte.bean.entity.TFinanceTaxSDiffExample;
import com.roncoo.adminlte.util.base.MyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatis
public interface TFinanceTaxSDiffMapper {
    int countByExample(TFinanceTaxSDiffExample example);

    int deleteByExample(TFinanceTaxSDiffExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TFinanceTaxSDiff record);

    int insertBatch(@Param("list") List<TFinanceTaxSDiff> list);

    int insertSelective(TFinanceTaxSDiff record);

    List<TFinanceTaxSDiff> selectByExample(TFinanceTaxSDiffExample example);

    TFinanceTaxSDiff selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TFinanceTaxSDiff record, @Param("example") TFinanceTaxSDiffExample example);

    int updateByExample(@Param("record") TFinanceTaxSDiff record, @Param("example") TFinanceTaxSDiffExample example);

    int updateByPrimaryKeySelective(TFinanceTaxSDiff record);

    int updateByPrimaryKey(TFinanceTaxSDiff record);
}