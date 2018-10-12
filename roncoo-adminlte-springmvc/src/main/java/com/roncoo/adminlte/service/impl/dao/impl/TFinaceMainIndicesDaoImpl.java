package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFinanceMainIndices;
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
public class TFinaceMainIndicesDaoImpl implements TFinaceMainIndicesDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int insert(TFinanceMainIndices tFinanceMainIndices) {
        return sqlSessionTemplate.getMapper(TFinaceMainIndicesDao.class).insert(tFinanceMainIndices);
    }

    @Override
    public int insertBatch(List<TFinanceMainIndices> list) {
        return sqlSessionTemplate.getMapper(TFinaceMainIndicesDao.class).insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return sqlSessionTemplate.getMapper(TFinaceMainIndicesDao.class).deleteById(id);
    }

    @Override
    public int deleteByProperty(TFinanceMainIndices tFinanceMainIndices) {
        return sqlSessionTemplate.getMapper(TFinaceMainIndicesDao.class).deleteByProperty(tFinanceMainIndices);
    }

    @Override
    public List<TFinanceMainIndices> queryByProperty(Map map) {
        return sqlSessionTemplate.getMapper(TFinaceMainIndicesDao.class).queryByProperty(map);
    }

    @Override
    public int update(TFinanceMainIndices tFinanceMainIndices) {
        return sqlSessionTemplate.getMapper(TFinaceMainIndicesDao.class).update(tFinanceMainIndices);
    }
}
