package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFmainIndices2;
import com.roncoo.adminlte.bean.entity.TFmainIndices3;
import com.roncoo.adminlte.service.impl.dao.TFinaceMainIndices3Dao;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by lx on 2017/11/9.
 */
@Repository
public class TFinaceMainIndices3DaoImpl implements TFinaceMainIndices3Dao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int insert(TFmainIndices3 obj) {
        return sqlSessionTemplate.getMapper(TFinaceMainIndices3Dao.class).insert(obj);
    }

    @Override
    public int insertBatch(@Param("list") List<TFmainIndices3> list) {
        return sqlSessionTemplate.getMapper(TFinaceMainIndices3Dao.class).insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return sqlSessionTemplate.getMapper(TFinaceMainIndices3Dao.class).deleteById(id);
    }

    @Override
    public int deleteByProperty(TFmainIndices3 obj) {
        return sqlSessionTemplate.getMapper(TFinaceMainIndices3Dao.class).deleteByProperty(obj);
    }

    @Override
    public List<TFmainIndices3> queryByProperty(Map map) {
        return sqlSessionTemplate.getMapper(TFinaceMainIndices3Dao.class).queryByProperty(map);
    }
}
