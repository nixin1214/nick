package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceMain;
import com.roncoo.adminlte.bean.entity.TFinanceMainExample;

import java.util.List;
import java.util.Map;

/**
 * 主要指标
 * Created by lx on 2017/11/1.
 */
public interface TFinaceMainDao {

    List<TFinanceMain> selectByExample(TFinanceMainExample tFinanceMainExample);

    TFinanceMain selectByPrimaryKey(Long id);

    int deleteByPrimaryKey(Long id);

    int deleteByExample(TFinanceMainExample tFinanceMainExample);

    int insert(TFinanceMain tFinanceMain);

    int insertSelective(TFinanceMain tFinanceMain);

    int countByExample(TFinanceMainExample tFinanceMainExample);

    int updateByExampleSelective(Map map);

    int updateByExample(Map map);

    int updateByPrimaryKeySelective(TFinanceMain tFinanceMain);

    int updateByPrimaryKey(TFinanceMain tFinanceMain);

    List<TFinanceMain> selectByProperty(Map map);

    /**
     * 查询资产负债表合并报表
     * @param map 参会集合
     * @return 数据列表
     */
    List<Map> getUnionByBalance(Map map);
}
