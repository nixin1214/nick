package com.roncoo.adminlte.service;

import com.roncoo.adminlte.bean.entity.TSysRoleResource;
import com.roncoo.adminlte.bean.vo.Result;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 角色资源
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/10/27 15:06
 */
public interface SysRoleResourceService {
    Result<TSysRoleResource> query(long id);

    Result<List<TSysRoleResource>> queryByRoleId(long id);

    Result<Integer> save(long roleId, List<Long> permissionList);

    Result<Integer> update(long roleId, List<Long> permissionList);

    Result<Integer> delete(long roleId);

    Result<Integer> deleteByRolePermissions(TSysRoleResource rcRolePermissions);

    Result<List<TSysRoleResource>> listForRoleId(List<Long> idList);
}
