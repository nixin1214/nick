package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceStockChange;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: TODO
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/11 15:27
 */
public interface TFinanceStockChangeDao {

    int insert(TFinanceStockChange stockChange);

    int insertBatch(@Param("list") List<TFinanceStockChange> list);

    int deleteById(Long id);

    int deleteByHeadId(long headId);

    List<TFinanceStockChange> queryByProperty(TFinanceStockChange stockChange);
}
