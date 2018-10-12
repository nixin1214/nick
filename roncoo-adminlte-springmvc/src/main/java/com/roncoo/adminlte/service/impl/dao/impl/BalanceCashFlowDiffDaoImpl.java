package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFinanceCashFlowDiff;
import com.roncoo.adminlte.service.impl.dao.BalanceCashFlowDiffDao;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by lx on 2017/11/11.
 */
@Repository
public class BalanceCashFlowDiffDaoImpl implements BalanceCashFlowDiffDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int insert(TFinanceCashFlowDiff obj) {
        return sqlSessionTemplate.getMapper(BalanceCashFlowDiffDao.class).insert(obj);
    }

    @Override
    public int insertBatch(@Param("list") List<TFinanceCashFlowDiff> list) {
        return sqlSessionTemplate.getMapper(BalanceCashFlowDiffDao.class).insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return sqlSessionTemplate.getMapper(BalanceCashFlowDiffDao.class).deleteById(id);
    }

    @Override
    public int deleteByProperty(TFinanceCashFlowDiff obj) {
        return sqlSessionTemplate.getMapper(BalanceCashFlowDiffDao.class).deleteByProperty(obj);
    }

    @Override
    public List<TFinanceCashFlowDiff> queryByProperty(Map map) {
        return sqlSessionTemplate.getMapper(BalanceCashFlowDiffDao.class).queryByProperty(map);
    }
}
