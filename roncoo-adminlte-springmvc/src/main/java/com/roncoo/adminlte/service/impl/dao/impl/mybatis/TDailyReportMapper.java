package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TDailyReport;
import com.roncoo.adminlte.bean.entity.TDailyReportExample;
import com.roncoo.adminlte.util.base.MyBatis;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

@MyBatis
public interface TDailyReportMapper {
    long countByExample(TDailyReportExample example);

    int deleteByExample(TDailyReportExample example);

    int deleteByPrimaryKey(BigDecimal fid);

    int insert(TDailyReport record);

    int insertSelective(TDailyReport record);

    //批量插入
    int insertBatch(List<TDailyReport> tDailyReports);

    List<TDailyReport> selectByExample(TDailyReportExample example);

    TDailyReport selectByPrimaryKey(BigDecimal fid);

    int updateByExampleSelective(@Param("record") TDailyReport record, @Param("example") TDailyReportExample example);

    int updateByExample(@Param("record") TDailyReport record, @Param("example") TDailyReportExample example);

    int updateByPrimaryKeySelective(TDailyReport record);

    int updateByPrimaryKey(TDailyReport record);
}