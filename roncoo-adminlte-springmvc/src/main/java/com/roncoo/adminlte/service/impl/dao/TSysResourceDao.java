package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TSysResource;
import com.roncoo.adminlte.util.base.Page;

import java.util.List;

public interface TSysResourceDao {
    TSysResource selectById(long id);

    int insert(TSysResource permission);

    int update(TSysResource permission);

    int deleteById(long id);

    Page<TSysResource> listForPage(int pageCurrent, int pageSize, String date, String search);

    List<TSysResource> listForId(List<Long> idList);

    List<TSysResource> list();
}
