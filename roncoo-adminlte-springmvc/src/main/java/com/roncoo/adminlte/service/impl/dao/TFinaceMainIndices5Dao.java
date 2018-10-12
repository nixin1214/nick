package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFmainIndices4;
import com.roncoo.adminlte.bean.entity.TFmainIndices5;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 主要指标5
 * Created by lx on 2017/11/1.
 */
public interface TFinaceMainIndices5Dao {

    int insert(TFmainIndices5 obj);

    int insertBatch(@Param("list") List<TFmainIndices5> list);

    int deleteById(Long id);

    int deleteByProperty(TFmainIndices5 obj);

    List<TFmainIndices5> queryByProperty(Map map);

}
