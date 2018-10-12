package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.BalanceSheet;
import com.roncoo.adminlte.service.impl.dao.BalanceSheetDao;
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
public class BalanceSheetDaoImpl implements BalanceSheetDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int insert(BalanceSheet obj) {
        return sqlSessionTemplate.getMapper(BalanceSheetDao.class).insert(obj);
    }

    @Override
    public int insertBatch(@Param("list") List<BalanceSheet> list) {
        return sqlSessionTemplate.getMapper(BalanceSheetDao.class).insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return sqlSessionTemplate.getMapper(BalanceSheetDao.class).deleteById(id);
    }

    @Override
    public int deleteByProperty(BalanceSheet obj) {
        return sqlSessionTemplate.getMapper(BalanceSheetDao.class).deleteByProperty(obj);
    }

    @Override
    public List<BalanceSheet> queryByProperty(Map map) {
        return sqlSessionTemplate.getMapper(BalanceSheetDao.class).queryByProperty(map);
    }

    @Override
    public List<BalanceSheet> queryByPropertyAll(List<Long> tfheadids) {
        return sqlSessionTemplate.getMapper(BalanceSheetDao.class).queryByPropertyAll(tfheadids);
    }
}
