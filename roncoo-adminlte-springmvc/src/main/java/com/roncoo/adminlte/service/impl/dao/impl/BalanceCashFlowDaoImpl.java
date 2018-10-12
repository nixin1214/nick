package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.BalanceCashFlow;
import com.roncoo.adminlte.bean.entity.BalanceProfit;
import com.roncoo.adminlte.service.impl.dao.BalanceCashFlowDao;
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
public class BalanceCashFlowDaoImpl implements BalanceCashFlowDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int insert(BalanceCashFlow obj) {
        return sqlSessionTemplate.getMapper(BalanceCashFlowDao.class).insert(obj);
    }

    @Override
    public int insertBatch(@Param("list") List<BalanceCashFlow> list) {
        return sqlSessionTemplate.getMapper(BalanceCashFlowDao.class).insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return sqlSessionTemplate.getMapper(BalanceCashFlowDao.class).deleteById(id);
    }

    @Override
    public int deleteByProperty(BalanceCashFlow obj) {
        return sqlSessionTemplate.getMapper(BalanceCashFlowDao.class).deleteByProperty(obj);
    }

    @Override
    public List<BalanceCashFlow> queryByProperty(Map map) {
        return sqlSessionTemplate.getMapper(BalanceCashFlowDao.class).queryByProperty(map);
    }

    @Override
    public List<BalanceCashFlow> queryByPropertyAll(List<Long> tfheadids) {
        return sqlSessionTemplate.getMapper(BalanceCashFlowDao.class).queryByPropertyAll(tfheadids);
    }
}
