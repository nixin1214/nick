package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TSysUserLogs;
import com.roncoo.adminlte.bean.entity.TSysUserLogsExample;
import com.roncoo.adminlte.util.base.MyBatis;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TSysUserLogsMapper {
    int countByExample(TSysUserLogsExample example);

    int deleteByExample(TSysUserLogsExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TSysUserLogs record);

    int insertSelective(TSysUserLogs record);

    List<TSysUserLogs> selectByExample(TSysUserLogsExample example);

    TSysUserLogs selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TSysUserLogs record, @Param("example") TSysUserLogsExample example);

    int updateByExample(@Param("record") TSysUserLogs record, @Param("example") TSysUserLogsExample example);

    int updateByPrimaryKeySelective(TSysUserLogs record);

    int updateByPrimaryKey(TSysUserLogs record);
}