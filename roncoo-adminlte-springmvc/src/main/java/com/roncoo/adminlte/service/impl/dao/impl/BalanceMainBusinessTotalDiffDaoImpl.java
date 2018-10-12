package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.FinanceMainBusinessTotal;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessTDiff;
import com.roncoo.adminlte.service.impl.dao.BalanceMainBusinessTotalDao;
import com.roncoo.adminlte.service.impl.dao.BalanceMainBusinessTotalDiffDao;
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
public class BalanceMainBusinessTotalDiffDaoImpl implements BalanceMainBusinessTotalDiffDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;


    @Override
    public int insertBatch(@Param("list") List<TFinanceMainBusinessTDiff> list) {
        return  sqlSessionTemplate.getMapper(BalanceMainBusinessTotalDiffDao.class).insertBatch(list);
    }

    @Override
    public int deleteByProperty(TFinanceMainBusinessTDiff obj) {
        return  sqlSessionTemplate.getMapper(BalanceMainBusinessTotalDiffDao.class).deleteByProperty(obj);
    }

    @Override
    public List<TFinanceMainBusinessTDiff> queryByProperty(Map map) {
        return  sqlSessionTemplate.getMapper(BalanceMainBusinessTotalDiffDao.class).queryByProperty(map);
    }
}
