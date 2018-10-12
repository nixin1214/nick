package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.FinanceMainBusinessMonth;
import com.roncoo.adminlte.service.impl.dao.BalanceMainBusinessMonthDao;
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
public class BalanceMainBusinessMonthDaoImpl implements BalanceMainBusinessMonthDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int insert(FinanceMainBusinessMonth obj) {
        return sqlSessionTemplate.getMapper(BalanceMainBusinessMonthDao.class).insert(obj);
    }

    @Override
    public int insertBatch(@Param("list") List<FinanceMainBusinessMonth> list) {
        return  sqlSessionTemplate.getMapper(BalanceMainBusinessMonthDao.class).insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return  sqlSessionTemplate.getMapper(BalanceMainBusinessMonthDao.class).deleteById(id);
    }

    @Override
    public int deleteByProperty(FinanceMainBusinessMonth obj) {
        return  sqlSessionTemplate.getMapper(BalanceMainBusinessMonthDao.class).deleteByProperty(obj);
    }

    @Override
    public List<FinanceMainBusinessMonth> queryByProperty(Map map) {
        return  sqlSessionTemplate.getMapper(BalanceMainBusinessMonthDao.class).queryByProperty(map);
    }

    @Override
    public List<FinanceMainBusinessMonth> queryByPropertyAndRowIndex(Map map) {
        return  sqlSessionTemplate.getMapper(BalanceMainBusinessMonthDao.class).queryByPropertyAndRowIndex(map);
    }

    @Override
    public List<FinanceMainBusinessMonth> queryByPropertyAll(List<Long> tfheadids) {
        return  sqlSessionTemplate.getMapper(BalanceMainBusinessMonthDao.class).queryByPropertyAll(tfheadids);
    }
}
