package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.FinanceMainBusinessDetialMonth;
import com.roncoo.adminlte.service.impl.dao.BalanceMainBusinessDetailMonthDao;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by lx on 2017/11/15.
 */
@Repository
public class BalanceMainBusinessDetailMonthDaoImpl implements BalanceMainBusinessDetailMonthDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int insertBatch(@Param("list") List<FinanceMainBusinessDetialMonth> list) {
        return sqlSessionTemplate.getMapper(BalanceMainBusinessDetailMonthDao.class).insertBatch(list);
    }

    @Override
    public int deleteByProperty(FinanceMainBusinessDetialMonth obj) {
        return sqlSessionTemplate.getMapper(BalanceMainBusinessDetailMonthDao.class).deleteByProperty(obj);
    }

    @Override
    public List<FinanceMainBusinessDetialMonth> queryByProperty(Map map) {
        return sqlSessionTemplate.getMapper(BalanceMainBusinessDetailMonthDao.class).queryByProperty(map);
    }

}
