package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFmainIndices5;
import com.roncoo.adminlte.service.impl.dao.TFinaceMainIndices5Dao;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by lx on 2017/11/10.
 */
@Repository
public class TFinaceMainIndices5DaoImpl implements TFinaceMainIndices5Dao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int insert(TFmainIndices5 obj) {
        return sqlSessionTemplate.getMapper(TFinaceMainIndices5Dao.class).insert(obj);
    }

    @Override
    public int insertBatch(@Param("list") List<TFmainIndices5> list) {
        return sqlSessionTemplate.getMapper(TFinaceMainIndices5Dao.class).insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return sqlSessionTemplate.getMapper(TFinaceMainIndices5Dao.class).deleteById(id);
    }

    @Override
    public int deleteByProperty(TFmainIndices5 obj) {
        return sqlSessionTemplate.getMapper(TFinaceMainIndices5Dao.class).deleteByProperty(obj);
    }

    @Override
    public List<TFmainIndices5> queryByProperty(Map map) {
        return sqlSessionTemplate.getMapper(TFinaceMainIndices5Dao.class).queryByProperty(map);
    }
}
