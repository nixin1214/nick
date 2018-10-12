package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.BalanceProfit;
import com.roncoo.adminlte.bean.entity.TFinanceBalanceDifference;
import com.roncoo.adminlte.bean.entity.TFinanceProfitDiff;
import com.roncoo.adminlte.service.impl.dao.BalanceProfitDao;
import com.roncoo.adminlte.service.impl.dao.BalanceProfitDiffDao;
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
public class BalanceProfitDiffDaoImpl implements BalanceProfitDiffDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int insert(TFinanceProfitDiff obj) {
        return sqlSessionTemplate.getMapper(BalanceProfitDiffDao.class).insert(obj);
    }

    @Override
    public int insertBatch(@Param("list") List<TFinanceProfitDiff> list) {
        return sqlSessionTemplate.getMapper(BalanceProfitDiffDao.class).insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return sqlSessionTemplate.getMapper(BalanceProfitDiffDao.class).deleteById(id);
    }

    @Override
    public int deleteByProperty(TFinanceProfitDiff obj) {
        return sqlSessionTemplate.getMapper(BalanceProfitDiffDao.class).deleteByProperty(obj);
    }

    @Override
    public List<TFinanceProfitDiff> queryByProperty(Map map) {
        return sqlSessionTemplate.getMapper(BalanceProfitDiffDao.class).queryByProperty(map);
    }
}
