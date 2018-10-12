package com.roncoo.adminlte.service.impl;

import com.roncoo.adminlte.bean.entity.TSysResource;
import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.service.SysResourceService;
import com.roncoo.adminlte.service.impl.dao.TSysResourceDao;
import com.roncoo.adminlte.util.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: TODO
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/10/27 16:01
 */
@Service
public class SysResourceServiceImpl implements SysResourceService {
    @Autowired
    private TSysResourceDao resourceDao;

    @Override
    public Result<TSysResource> query(long id) {
        Result<TSysResource> result = new Result<TSysResource>();
        if (id < 0) {
            result.setErrMsg("此id无效");
            return result;
        }
        TSysResource resource = resourceDao.selectById(id);
        if (resource != null) {
            result.setErrCode(0);
            result.setStatus(true);
            result.setResultData(resource);
            result.setErrMsg("查询成功");
            return result;
        }
        result.setErrMsg("查询失败");
        return result;
    }

    @Override
    public Result<Integer> save(TSysResource sysResource) {
        Result<Integer> result = new Result<Integer>();
        if (verify(sysResource, result)) return result;
        int resultNum = resourceDao.insert(sysResource);
        if (resultNum > 0) {
            result.setErrCode(0);
            result.setStatus(true);
            result.setErrMsg("添加成功");
            return result;
        }
        result.setErrMsg("添加失败");
        return result;
    }

    /**
     * 字段验证
     * @param sysResource
     * @param result
     * @return
     */
    private boolean verify(TSysResource sysResource, Result<Integer> result) {
        if (StringUtils.isEmpty(sysResource.getFresName())) {
            result.setErrMsg("资源名称不能为空");
            return true;
        }
        if (StringUtils.isEmpty(sysResource.getFresType())) {
            result.setErrMsg("资源类型不能为空");
            return true;
        }
        if (sysResource.getFparentId() == null) {
            result.setErrMsg("父级菜单不能为空");
            return true;
        }
        if (!StringUtils.hasText(sysResource.getFpermissionName())) {
            result.setErrMsg("权限名不能为空");
            return true;
        }
        if (!StringUtils.hasText(sysResource.getFpermissionValue())) {
            result.setErrMsg("权限值不能为空");
            return true;
        }
        return false;
    }

    @Override
    public Result<Integer> update(TSysResource sysResource) {
        Result<Integer> result = new Result<Integer>();
        if (verify(sysResource, result)) {
            return result;
        }
        int resultNum = resourceDao.update(sysResource);
        if (resultNum > 0) {
            result.setErrCode(0);
            result.setStatus(true);
            result.setErrMsg("更新成功");
            return result;
        }
        result.setErrMsg("更新失败");
        return result;
    }

    @Override
    public Result<Integer> delete(long id) {
        Result<Integer> result = new Result<Integer>();
        if (id < 0) {
            result.setErrMsg("此id无效");
            return result;
        }
        int resultNum = resourceDao.deleteById(id);
        if (resultNum > 0) {
            result.setErrCode(0);
            result.setStatus(true);
            result.setErrMsg("删除成功");
            return result;
        }
        result.setErrMsg("删除失败");
        return result;
    }

    @Override
    public Result<Page<TSysResource>> listForPage(int pageCurrent, int pageSize, String date, String search) {
        Result<Page<TSysResource>> result = new Result<Page<TSysResource>>();
        if (pageCurrent < 1) {
            result.setErrMsg("pageCurrent有误");
            return result;
        }
        if (pageSize < 1) {
            result.setErrMsg("pageSize有误");
            return result;
        }
        Page<TSysResource> resultData = resourceDao.listForPage(pageCurrent, pageSize, date, search);
        result.setResultData(resultData);
        result.setErrCode(0);
        result.setStatus(true);
        result.setErrMsg("查询成功");
        return result;
    }

    @Override
    public Result<List<TSysResource>> listForId(List<Long> idList) {
        Result<List<TSysResource>> result = new Result<List<TSysResource>>();
        if (idList.size() < 1) {
            result.setErrMsg("没有id需要查询");
            return result;
        }
        List<TSysResource> resultData = resourceDao.listForId(idList);
        result.setErrCode(0);
        result.setStatus(true);
        result.setResultData(resultData);
        result.setErrMsg("查询成功");
        return result;
    }

    @Override
    public Result<List<TSysResource>> list() {
        Result<List<TSysResource>> result = new Result<List<TSysResource>>();
        List<TSysResource> resultData = resourceDao.list();
        result.setErrCode(0);
        result.setStatus(true);
        result.setResultData(resultData);
        result.setErrMsg("查询成功");
        return result;
    }
}
