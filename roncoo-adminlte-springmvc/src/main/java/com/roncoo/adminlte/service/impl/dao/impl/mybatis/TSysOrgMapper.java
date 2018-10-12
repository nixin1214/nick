package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TSysOrg;
import com.roncoo.adminlte.bean.entity.TSysOrgExample;
import com.roncoo.adminlte.util.base.MyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatis
public interface TSysOrgMapper {
    int countByExample(TSysOrgExample example);

    int deleteByExample(TSysOrgExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TSysOrg record);

    int insertSelective(TSysOrg record);

    List<TSysOrg> selectByExample(TSysOrgExample example);

    TSysOrg selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TSysOrg record, @Param("example") TSysOrgExample example);

    int updateByExample(@Param("record") TSysOrg record, @Param("example") TSysOrgExample example);

    int updateByPrimaryKeySelective(TSysOrg record);

    int updateByPrimaryKey(TSysOrg record);
}