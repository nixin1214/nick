package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.FinanceMainBusinessDetialMonth;
import com.roncoo.adminlte.bean.entity.FinanceMainBusinessDetialTotal;
import com.roncoo.adminlte.service.impl.dao.BalanceMainBusinessDetailMonthDao;
import com.roncoo.adminlte.service.impl.dao.BalanceMainBusinessDetailTotalDao;
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
public class BalanceMainBusinessDetailTotalDaoImpl implements BalanceMainBusinessDetailTotalDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int insertBatch(@Param("list") List<FinanceMainBusinessDetialTotal> list) {
        return sqlSessionTemplate.getMapper(BalanceMainBusinessDetailTotalDao.class).insertBatch(list);
    }

    @Override
    public int deleteByProperty(FinanceMainBusinessDetialTotal obj) {
        return sqlSessionTemplate.getMapper(BalanceMainBusinessDetailTotalDao.class).deleteByProperty(obj);
    }

    @Override
    public List<FinanceMainBusinessDetialTotal> queryByProperty(Map map) {
        return sqlSessionTemplate.getMapper(BalanceMainBusinessDetailTotalDao.class).queryByProperty(map);
    }
}
