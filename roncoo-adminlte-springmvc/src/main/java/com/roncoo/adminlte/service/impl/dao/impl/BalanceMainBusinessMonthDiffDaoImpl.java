package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.FinanceMainBusinessMonth;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessMDiff;
import com.roncoo.adminlte.service.impl.dao.BalanceMainBusinessMonthDao;
import com.roncoo.adminlte.service.impl.dao.BalanceMainBusinessMonthDiffDao;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by lx on 2017/11/14.
 */
@Repository
public class BalanceMainBusinessMonthDiffDaoImpl implements BalanceMainBusinessMonthDiffDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int insert(TFinanceMainBusinessMDiff obj) {
        return sqlSessionTemplate.getMapper(BalanceMainBusinessMonthDiffDao.class).insert(obj);
    }

    @Override
    public int insertBatch(@Param("list") List<TFinanceMainBusinessMDiff> list) {
        return  sqlSessionTemplate.getMapper(BalanceMainBusinessMonthDiffDao.class).insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return  sqlSessionTemplate.getMapper(BalanceMainBusinessMonthDiffDao.class).deleteById(id);
    }

    @Override
    public int deleteByProperty(TFinanceMainBusinessMDiff obj) {
        return  sqlSessionTemplate.getMapper(BalanceMainBusinessMonthDiffDao.class).deleteByProperty(obj);
    }

    @Override
    public List<TFinanceMainBusinessMDiff> queryByProperty(Map map) {
        return  sqlSessionTemplate.getMapper(BalanceMainBusinessMonthDiffDao.class).queryByProperty(map);
    }

    @Override
    public List<TFinanceMainBusinessMDiff> queryByPropertyAndRowIndex(Map map) {
        return  sqlSessionTemplate.getMapper(BalanceMainBusinessMonthDiffDao.class).queryByPropertyAndRowIndex(map);
    }

}
