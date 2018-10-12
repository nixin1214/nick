package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFinanceMain;
import com.roncoo.adminlte.bean.entity.TFinanceMainExample;
import com.roncoo.adminlte.service.impl.dao.TFinaceMainDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * Created by lx on 2017/11/1.
 */
@Repository
public class TFinaceMainDaoImpl implements TFinaceMainDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<TFinanceMain> selectByExample(TFinanceMainExample tFinanceMainExample) {
        return sqlSessionTemplate.getMapper(TFinaceMainDao.class).selectByExample(tFinanceMainExample);
    }

    @Override
    public TFinanceMain selectByPrimaryKey(Long id) {
        return sqlSessionTemplate.getMapper(TFinaceMainDao.class).selectByPrimaryKey(id
        );
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sqlSessionTemplate.getMapper(TFinaceMainDao.class).deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByExample(TFinanceMainExample tFinanceMainExample) {
        return sqlSessionTemplate.getMapper(TFinaceMainDao.class).deleteByExample(tFinanceMainExample);
    }

    @Override
    public int insert(TFinanceMain tFinanceMain) {
        return sqlSessionTemplate.getMapper(TFinaceMainDao.class).insert(tFinanceMain);
    }

    @Override
    public int insertSelective(TFinanceMain tFinanceMain) {
        return sqlSessionTemplate.getMapper(TFinaceMainDao.class).insertSelective(tFinanceMain);
    }

    @Override
    public int countByExample(TFinanceMainExample tFinanceMainExample) {
        return sqlSessionTemplate.getMapper(TFinaceMainDao.class).countByExample(tFinanceMainExample);
    }

    @Override
    public int updateByExampleSelective(Map map) {
        return sqlSessionTemplate.getMapper(TFinaceMainDao.class).updateByExampleSelective(map);
    }

    @Override
    public int updateByExample(Map map) {
        return sqlSessionTemplate.getMapper(TFinaceMainDao.class).updateByExample(map);
    }

    @Override
    public int updateByPrimaryKeySelective(TFinanceMain tFinanceMain) {
        return sqlSessionTemplate.getMapper(TFinaceMainDao.class).updateByPrimaryKeySelective(tFinanceMain);
    }

    @Override
    public int updateByPrimaryKey(TFinanceMain tFinanceMain) {
        return sqlSessionTemplate.getMapper(TFinaceMainDao.class).updateByPrimaryKey(tFinanceMain);
    }

    @Override
    public List<TFinanceMain> selectByProperty(Map map) {
        return sqlSessionTemplate.getMapper(TFinaceMainDao.class).selectByProperty(map);
    }

    @Override
    public List<Map> getUnionByBalance(Map map) {
        return null;
    }
}
