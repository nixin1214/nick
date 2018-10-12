package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TSysRoleResource;
import com.roncoo.adminlte.bean.entity.TSysRoleResourceExample;
import com.roncoo.adminlte.util.base.MyBatis;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TSysRoleResourceMapper {
    int countByExample(TSysRoleResourceExample example);

    int deleteByExample(TSysRoleResourceExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TSysRoleResource record);

    int insertSelective(TSysRoleResource record);

    List<TSysRoleResource> selectByExample(TSysRoleResourceExample example);

    TSysRoleResource selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TSysRoleResource record, @Param("example") TSysRoleResourceExample example);

    int updateByExample(@Param("record") TSysRoleResource record, @Param("example") TSysRoleResourceExample example);

    int updateByPrimaryKeySelective(TSysRoleResource record);

    int updateByPrimaryKey(TSysRoleResource record);
}