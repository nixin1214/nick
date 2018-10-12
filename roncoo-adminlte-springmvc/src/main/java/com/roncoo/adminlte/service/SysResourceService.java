package com.roncoo.adminlte.service;

import com.roncoo.adminlte.bean.entity.TSysResource;
import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.util.base.Page;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: TODO
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/10/27 15:57
 */
public interface SysResourceService {
    Result<TSysResource> query(long id);

    Result<Integer> save(TSysResource sysResource);

    Result<Integer> update(TSysResource sysResource);

    Result<Integer> delete(long id);

    Result<Page<TSysResource>> listForPage(int pageCurrent, int pageSize, String date, String search);

    Result<List<TSysResource>> listForId(List<Long> idList);

    Result<List<TSysResource>> list();
}
