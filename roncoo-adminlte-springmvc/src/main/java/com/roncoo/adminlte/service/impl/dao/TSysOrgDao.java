package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TSysOrg;
import com.roncoo.adminlte.util.base.Page;

import java.util.List;

public interface TSysOrgDao {
    TSysOrg selectById(long id);

    TSysOrg selectByCode(String number);

    int insert(TSysOrg role);

    int update(TSysOrg role);

    int deleteById(long id);

    Page<TSysOrg> listForPage(int pageCurrent, int pageSize, String date, String search);

    List<TSysOrg> listForId(List<Long> idList);

    List<TSysOrg> list();

}
