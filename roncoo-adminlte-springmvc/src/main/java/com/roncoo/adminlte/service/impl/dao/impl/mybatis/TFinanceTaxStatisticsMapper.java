package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceTaxStatistics;
import com.roncoo.adminlte.bean.entity.TFinanceTaxStatisticsExample;
import com.roncoo.adminlte.util.base.MyBatis;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceTaxStatisticsMapper {
    int countByExample(TFinanceTaxStatisticsExample example);

    int deleteByExample(TFinanceTaxStatisticsExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TFinanceTaxStatistics record);

    int insertBatch(@Param("list") List<TFinanceTaxStatistics> list);

    int insertSelective(TFinanceTaxStatistics record);

    List<TFinanceTaxStatistics> selectByExample(TFinanceTaxStatisticsExample example);

    TFinanceTaxStatistics selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TFinanceTaxStatistics record, @Param("example") TFinanceTaxStatisticsExample example);

    int updateByExample(@Param("record") TFinanceTaxStatistics record, @Param("example") TFinanceTaxStatisticsExample example);

    int updateByPrimaryKeySelective(TFinanceTaxStatistics record);

    int updateByPrimaryKey(TFinanceTaxStatistics record);
}