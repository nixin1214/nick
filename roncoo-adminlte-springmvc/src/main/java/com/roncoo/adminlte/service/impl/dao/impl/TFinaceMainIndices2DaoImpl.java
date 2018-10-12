package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFinanceMainIndices;
import com.roncoo.adminlte.bean.entity.TFmainIndices2;
import com.roncoo.adminlte.service.impl.dao.TFinaceMainIndices2Dao;
import com.roncoo.adminlte.service.impl.dao.TFinaceMainIndicesDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by lx on 2017/11/1.
 */
@Repository
public class TFinaceMainIndices2DaoImpl implements TFinaceMainIndices2Dao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int insert(TFmainIndices2 fmainIndices2) {
        return sqlSessionTemplate.getMapper(TFinaceMainIndices2Dao.class).insert(fmainIndices2);
    }

    @Override
    public int insertBatch(List<TFmainIndices2> list) {
        return sqlSessionTemplate.getMapper(TFinaceMainIndices2Dao.class).insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return sqlSessionTemplate.getMapper(TFinaceMainIndices2Dao.class).deleteById(id);
    }

    @Override
    public int deleteByProperty(TFmainIndices2 fmainIndices2) {
        return sqlSessionTemplate.getMapper(TFinaceMainIndices2Dao.class).deleteByProperty(fmainIndices2);
    }

    @Override
    public List<TFmainIndices2> queryByProperty(Map map) {
        return sqlSessionTemplate.getMapper(TFinaceMainIndices2Dao.class).queryByProperty(map);
    }
}
