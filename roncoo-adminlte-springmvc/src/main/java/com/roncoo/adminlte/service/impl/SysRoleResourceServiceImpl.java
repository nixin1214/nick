package com.roncoo.adminlte.service.impl;

import com.roncoo.adminlte.bean.entity.TSysRoleResource;
import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.service.SysRoleResourceService;
import com.roncoo.adminlte.service.impl.dao.TSysRoleResourceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: TODO
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/10/27 15:07
 */
@Service
public class SysRoleResourceServiceImpl implements SysRoleResourceService {

    @Autowired
    private TSysRoleResourceDao roleResourceDao;

    @Override
    public Result<TSysRoleResource> query(long id) {
        Result<TSysRoleResource> result = new Result<>();
        if (id < 1) {
            result.setErrMsg("此操作的id：" + id + "为无效id");
            return result;
        }
        result.setResultData(roleResourceDao.selectById(id));
        result.setStatus(true);
        result.setErrCode(0);
        return result;
    }

    @Override
    public Result<List<TSysRoleResource>> queryByRoleId(long id) {
        Result<List<TSysRoleResource>> result = new Result<>();
        if (id < 0) {
            result.setErrMsg("此操作的id：" + id + "为无效id");
            return result;
        }
        List<TSysRoleResource> list = roleResourceDao.selectByRoleId(id);
        result.setResultData(list);
        result.setStatus(true);
        result.setErrCode(0);
        return result;
    }

    @Override
    public Result<Integer> save(long roleId, List<Long> resourceList) {
        Result<Integer> result = new Result<Integer>();
        if (roleId < 1) {
            result.setErrMsg("此角色id无效");
            return result;
        }
        if (CollectionUtils.isEmpty(resourceList)) {
            result.setErrCode(0);
            result.setStatus(true);
            result.setErrMsg("没有需要插入的数据");
            return result;
        }
        TSysRoleResource roleResources = new TSysRoleResource();
        int i = 0;
        for (Long permissionId : resourceList) {
            roleResources.setFresourceId(permissionId);
            roleResources.setFroleId(roleId);
            i = i + roleResourceDao.insert(roleResources);
        }
        int resourceSize = resourceList.size();
        if (i == resourceSize) {
            result.setErrMsg("操作成功");
            result.setErrCode(0);
            result.setStatus(true);
            return result;
        }
        result.setErrMsg("操作失败");
        return result;
    }

    @Override
    public Result<Integer> update(long roleId, List<Long> resourceList) {
        Result<Integer> result = new Result<Integer>();
        if (roleId < 1) {
            result.setErrMsg("此角色id无效");
            return result;
        }
        if (roleResourceDao.countByRoleId(roleId) != roleResourceDao.deleteByRoleId(roleId)) {
            result.setErrMsg("操作失败");
            return result;
        }
        return save(roleId, resourceList);
    }

    @Override
    public Result<Integer> delete(long roleId) {
        Result<Integer> result = new Result<Integer>();
        if (roleId < 0) {
            result.setErrMsg("此id无效");
            return result;
        }
        int resultNum = roleResourceDao.deleteByRoleId(roleId);
        if (resultNum > 0) {
            result.setErrCode(0);
            result.setStatus(true);
        }
        return result;
    }

    @Override
    public Result<Integer> deleteByRolePermissions(TSysRoleResource rcRolePermissions) {
        Result<Integer> result = new Result<Integer>();
        if (rcRolePermissions.getFroleId() < 0) {
            result.setErrMsg("此角色id无效");
            return result;
        }
        if (rcRolePermissions.getFresourceId() < 0) {
            result.setErrMsg("此权限id无效");
            return result;
        }
        int resultNum = roleResourceDao.delectByRolePermissions(rcRolePermissions);
        if (resultNum > 0) {
            result.setErrCode(0);
            result.setStatus(true);
        }
        return result;
    }

    @Override
    public Result<List<TSysRoleResource>> listForRoleId(List<Long> idList) {
        Result<List<TSysRoleResource>> result = new Result<List<TSysRoleResource>>();
        if (idList.size() < 1) {
            result.setErrMsg("没有id需要查询");
            return result;
        }
        List<TSysRoleResource> resultData = roleResourceDao.listForRoleId(idList);
        result.setErrCode(0);
        result.setStatus(true);
        result.setResultData(resultData);
        result.setErrMsg("查询成功");
        return result;
    }
}
