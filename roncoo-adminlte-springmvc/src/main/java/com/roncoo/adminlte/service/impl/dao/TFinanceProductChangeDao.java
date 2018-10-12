package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceProductChange;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: TODO
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/11 15:26
 */
public interface TFinanceProductChangeDao {
    int insert(TFinanceProductChange productChange);

    int insertBatch(@Param("list") List<TFinanceProductChange> list);

    int deleteById(Long id);

    int deleteByHeadId(long headId);

    List<TFinanceProductChange> queryByProperty(TFinanceProductChange productChange);
}
