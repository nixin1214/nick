package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceMainIndices;
import com.roncoo.adminlte.bean.entity.TFmainIndices2;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 主要指标2
 * Created by lx on 2017/11/1.
 */
public interface TFinaceMainIndices2Dao {

    int insert(TFmainIndices2 fmainIndices2);

    int insertBatch(@Param("list") List<TFmainIndices2> list);

    int deleteById(Long id);

    int deleteByProperty(TFmainIndices2 fmainIndices2);

    List<TFmainIndices2> queryByProperty(Map map);

}
