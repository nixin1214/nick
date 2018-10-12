package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TExcelConfig;
import com.roncoo.adminlte.bean.entity.TExcelConfigExample;
import com.roncoo.adminlte.util.base.MyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatis
public interface TExcelConfigMapper {
    int countByExample(TExcelConfigExample example);

    int deleteByExample(TExcelConfigExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TExcelConfig record);

    int insertSelective(TExcelConfig record);

    List<TExcelConfig> selectByExample(TExcelConfigExample example);

    TExcelConfig selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TExcelConfig record, @Param("example") TExcelConfigExample example);

    int updateByExample(@Param("record") TExcelConfig record, @Param("example") TExcelConfigExample example);

    int updateByPrimaryKeySelective(TExcelConfig record);

    int updateByPrimaryKey(TExcelConfig record);
}