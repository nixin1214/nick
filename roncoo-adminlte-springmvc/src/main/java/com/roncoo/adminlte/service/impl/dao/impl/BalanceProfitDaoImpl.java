package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.BalanceProfit;
import com.roncoo.adminlte.service.impl.dao.BalanceProfitDao;
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
public class BalanceProfitDaoImpl implements BalanceProfitDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int insert(BalanceProfit obj) {
        return sqlSessionTemplate.getMapper(BalanceProfitDao.class).insert(obj);
    }

    @Override
    public int insertBatch(@Param("list") List<BalanceProfit> list) {
        return sqlSessionTemplate.getMapper(BalanceProfitDao.class).insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return sqlSessionTemplate.getMapper(BalanceProfitDao.class).deleteById(id);
    }

    @Override
    public int deleteByProperty(BalanceProfit obj) {
        return sqlSessionTemplate.getMapper(BalanceProfitDao.class).deleteByProperty(obj);
    }

    @Override
    public List<BalanceProfit> queryByProperty(Map map) {
        return sqlSessionTemplate.getMapper(BalanceProfitDao.class).queryByProperty(map);
    }

    @Override
    public List<BalanceProfit> queryByPropertyAll(List<Long> tfheadids) {
        return sqlSessionTemplate.getMapper(BalanceProfitDao.class).queryByPropertyAll(tfheadids);
    }
}
