package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TBusinessQuotaLog;
import com.roncoo.adminlte.bean.entity.TBusinessQuotaLogExample;
import com.roncoo.adminlte.util.base.MyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatis
public interface TBusinessQuotaLogMapper {
    int countByExample(TBusinessQuotaLogExample example);

    int deleteByExample(TBusinessQuotaLogExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TBusinessQuotaLog record);

    int insertSelective(TBusinessQuotaLog record);

    List<TBusinessQuotaLog> selectByExample(TBusinessQuotaLogExample example);

    TBusinessQuotaLog selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TBusinessQuotaLog record, @Param("example") TBusinessQuotaLogExample example);

    int updateByExample(@Param("record") TBusinessQuotaLog record, @Param("example") TBusinessQuotaLogExample example);

    int updateByPrimaryKeySelective(TBusinessQuotaLog record);

    int updateByPrimaryKey(TBusinessQuotaLog record);
}