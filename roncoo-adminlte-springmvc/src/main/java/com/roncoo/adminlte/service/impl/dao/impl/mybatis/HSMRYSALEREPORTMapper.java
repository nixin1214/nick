package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.HSMRYSALEREPORT;
import com.roncoo.adminlte.bean.entity.HSMRYSALEREPORTExample;
import java.util.List;

import com.roncoo.adminlte.util.base.MyBatis;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface HSMRYSALEREPORTMapper {
    long countByExample(HSMRYSALEREPORTExample example);

    int deleteByExample(HSMRYSALEREPORTExample example);

    int insert(HSMRYSALEREPORT record);

    int insertSelective(HSMRYSALEREPORT record);

    List<HSMRYSALEREPORT> selectByExampleWithBLOBs(HSMRYSALEREPORTExample example);

    List<HSMRYSALEREPORT> selectByExample(HSMRYSALEREPORTExample example);

    int updateByExampleSelective(@Param("record") HSMRYSALEREPORT record, @Param("example") HSMRYSALEREPORTExample example);

    int updateByExampleWithBLOBs(@Param("record") HSMRYSALEREPORT record, @Param("example") HSMRYSALEREPORTExample example);

    int updateByExample(@Param("record") HSMRYSALEREPORT record, @Param("example") HSMRYSALEREPORTExample example);
}