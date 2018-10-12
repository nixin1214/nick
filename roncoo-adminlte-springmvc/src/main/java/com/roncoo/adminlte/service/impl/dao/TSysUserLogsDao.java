package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TSysUserLogs;
import com.roncoo.adminlte.bean.entity.TSysUserLogsExample;
import com.roncoo.adminlte.util.base.Page;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 用户操作日志
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/16 14:17
 */
public interface TSysUserLogsDao {

    TSysUserLogs selectById(long id);

    int insert(TSysUserLogs role);

    int update(TSysUserLogs role);

    int deleteById(long id);

    Page<TSysUserLogs> listForPage(int pageCurrent, int pageSize, TSysUserLogsExample example);

    List<TSysUserLogs> listForId(List<Long> idList);

    List<TSysUserLogs> listForExample(TSysUserLogsExample example);
}
