package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TSysRoleResource;

import java.util.List;

/**
 * 角色资源映射DAO
 */
public interface TSysRoleResourceDao {
    TSysRoleResource selectById(long id);

    List<TSysRoleResource> selectByRoleId(long id);

    int insert(TSysRoleResource rcRolePermissions);

    int update(TSysRoleResource rcRolePermissions);

    int delectByRolePermissions(TSysRoleResource rcRolePermissions);

    int deleteByRoleId(long roleId);

    int countByRoleId(long roleId);

    List<TSysRoleResource> listForRoleId(List<Long> idList);
}
