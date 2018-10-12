package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TBusinessQuota;
import com.roncoo.adminlte.bean.entity.TBusinessQuotaExample;
import com.roncoo.adminlte.util.base.MyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@MyBatis
public interface TBusinessQuotaMapper {
    int countByExample(TBusinessQuotaExample example);

    int deleteByExample(TBusinessQuotaExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TBusinessQuota record);

    int insertSelective(TBusinessQuota record);

    int insertBatch(List<TBusinessQuota> quotas);

    List<TBusinessQuota> selectByExample(TBusinessQuotaExample example);

    TBusinessQuota selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TBusinessQuota record, @Param("example") TBusinessQuotaExample example);

    int updateByExample(@Param("record") TBusinessQuota record, @Param("example") TBusinessQuotaExample example);

    int updateByPrimaryKeySelective(TBusinessQuota record);

    int updateByPrimaryKey(TBusinessQuota record);

    List<Map<String, Object>> dynamicSql(String sql);

}