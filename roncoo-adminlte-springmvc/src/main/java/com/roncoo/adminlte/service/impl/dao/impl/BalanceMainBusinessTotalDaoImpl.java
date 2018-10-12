package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.FinanceMainBusinessMonth;
import com.roncoo.adminlte.bean.entity.FinanceMainBusinessTotal;
import com.roncoo.adminlte.service.impl.dao.BalanceMainBusinessMonthDao;
import com.roncoo.adminlte.service.impl.dao.BalanceMainBusinessTotalDao;
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
public class BalanceMainBusinessTotalDaoImpl implements BalanceMainBusinessTotalDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;


    @Override
    public int insertBatch(@Param("list") List<FinanceMainBusinessTotal> list) {
        return  sqlSessionTemplate.getMapper(BalanceMainBusinessTotalDao.class).insertBatch(list);
    }

    @Override
    public int deleteByProperty(FinanceMainBusinessTotal obj) {
        return  sqlSessionTemplate.getMapper(BalanceMainBusinessTotalDao.class).deleteByProperty(obj);
    }

    @Override
    public List<FinanceMainBusinessTotal> queryByProperty(Map map) {
        return  sqlSessionTemplate.getMapper(BalanceMainBusinessTotalDao.class).queryByProperty(map);
    }

    @Override
    public List<FinanceMainBusinessTotal> queryByPropertyAll(List<Long> tfheadids) {
        return sqlSessionTemplate.getMapper(BalanceMainBusinessTotalDao.class).queryByPropertyAll(tfheadids);
    }
}
