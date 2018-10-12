package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TExcelConfig;
import com.roncoo.adminlte.util.base.Page;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: TODO
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/11 11:42
 */
public interface TExcelConfigDao {
    TExcelConfig selectById(long id);

    TExcelConfig selectByName(String roleName);

    TExcelConfig selectByNumber(String number);

    int insert(TExcelConfig role);

    int update(TExcelConfig role);

    int deleteById(long id);

    Page<TExcelConfig> listForPage(int pageCurrent, int pageSize, String date, String search);

    List<TExcelConfig> listForId(List<Long> idList);

    List<TExcelConfig> list();
}
