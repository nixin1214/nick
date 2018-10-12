package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFmainIndices3;
import com.roncoo.adminlte.bean.entity.TFmainIndices4;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 主要指标4 DAO
 * Created by lx on 2017/11/1.
 */
public interface TFinaceMainIndices4Dao {

    int insert(TFmainIndices4 obj);

    int insertBatch(@Param("list") List<TFmainIndices4> list);

    int deleteById(Long id);

    int deleteByProperty(TFmainIndices4 obj);

    List<TFmainIndices4> queryByProperty(Map map);

}
