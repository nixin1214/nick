package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TExcelSheetConfig;
import com.roncoo.adminlte.bean.entity.TExcelSheetConfigExample;
import com.roncoo.adminlte.util.base.MyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatis
public interface TExcelSheetConfigMapper {
    int countByExample(TExcelSheetConfigExample example);

    int deleteByExample(TExcelSheetConfigExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TExcelSheetConfig record);

    int insertSelective(TExcelSheetConfig record);

    List<TExcelSheetConfig> selectByExample(TExcelSheetConfigExample example);

    TExcelSheetConfig selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TExcelSheetConfig record, @Param("example") TExcelSheetConfigExample example);

    int updateByExample(@Param("record") TExcelSheetConfig record, @Param("example") TExcelSheetConfigExample example);

    int updateByPrimaryKeySelective(TExcelSheetConfig record);

    int updateByPrimaryKey(TExcelSheetConfig record);
}