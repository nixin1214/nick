package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TExcelSheetConfig;
import com.roncoo.adminlte.util.base.Page;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: TODO
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/11 11:43
 */
public interface TExcelSheetConfigDao {

    TExcelSheetConfig selectById(long id);

    TExcelSheetConfig selectBySheetName(String name);

    TExcelSheetConfig selectByIndex(int number);

    int insert(TExcelSheetConfig role);

    int update(TExcelSheetConfig role);

    int deleteById(long id);

    Page<TExcelSheetConfig> listForPage(int pageCurrent, int pageSize, String date, String search);

    List<TExcelSheetConfig> listForId(List<Long> idList);

    List<TExcelSheetConfig> listByHeadId(long headId);

    List<TExcelSheetConfig> list();
}
