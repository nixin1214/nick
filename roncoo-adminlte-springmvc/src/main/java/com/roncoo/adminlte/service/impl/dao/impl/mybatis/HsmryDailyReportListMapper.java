package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.HsmryDailyReportList;
import com.roncoo.adminlte.bean.entity.HsmryDailyReportListExample;
import com.roncoo.adminlte.util.base.MyBatis;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

@MyBatis
public interface HsmryDailyReportListMapper {
    long countByExample(HsmryDailyReportListExample example);

    int deleteByExample(HsmryDailyReportListExample example);

    int deleteByPrimaryKey(BigDecimal fid);

    int insert(HsmryDailyReportList record);

    int insertSelective(HsmryDailyReportList record);

    List<HsmryDailyReportList> selectByExample(HsmryDailyReportListExample example);

    HsmryDailyReportList selectByPrimaryKey(BigDecimal fid);

    int updateByExampleSelective(@Param("record") HsmryDailyReportList record, @Param("example") HsmryDailyReportListExample example);

    int updateByExample(@Param("record") HsmryDailyReportList record, @Param("example") HsmryDailyReportListExample example);

    int updateByPrimaryKeySelective(HsmryDailyReportList record);

    int updateByPrimaryKey(HsmryDailyReportList record);
}