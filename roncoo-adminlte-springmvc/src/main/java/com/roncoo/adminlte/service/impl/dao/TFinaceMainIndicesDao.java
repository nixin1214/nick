package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceMain;
import com.roncoo.adminlte.bean.entity.TFinanceMainExample;
import com.roncoo.adminlte.bean.entity.TFinanceMainIndices;

import java.util.List;
import java.util.Map;

/**
 * 主要指标1
 * Created by lx on 2017/11/1.
 */
public interface TFinaceMainIndicesDao {

    int insert(TFinanceMainIndices tFinanceMainIndices);

    int insertBatch(List<TFinanceMainIndices> list);

    int deleteById(Long id);

    int deleteByProperty(TFinanceMainIndices tFinanceMainIndices);

    List<TFinanceMainIndices> queryByProperty(Map map);

    int update(TFinanceMainIndices tFinanceMainIndices);

}
