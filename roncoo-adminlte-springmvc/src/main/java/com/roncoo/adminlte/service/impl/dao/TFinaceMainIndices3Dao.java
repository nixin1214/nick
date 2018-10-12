package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFmainIndices2;
import com.roncoo.adminlte.bean.entity.TFmainIndices3;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 主要指标3 DAO
 * Created by lx on 2017/11/1.
 */
public interface TFinaceMainIndices3Dao {

    int insert(TFmainIndices3 obj);

    int insertBatch(@Param("list") List<TFmainIndices3> list);

    int deleteById(Long id);

    int deleteByProperty(TFmainIndices3 obj);

    List<TFmainIndices3> queryByProperty(Map map);

}
