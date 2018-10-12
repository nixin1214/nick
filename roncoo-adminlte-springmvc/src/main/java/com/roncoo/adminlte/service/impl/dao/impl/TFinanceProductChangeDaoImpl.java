package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFinanceProductChange;
import com.roncoo.adminlte.bean.entity.TFinanceProductChangeExample;
import com.roncoo.adminlte.service.impl.dao.TFinanceProductChangeDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TFinanceProductChangeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 产品增减表DAO实现类
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/11 15:29
 */
@Repository
public class TFinanceProductChangeDaoImpl implements TFinanceProductChangeDao {
    @Autowired
    private TFinanceProductChangeMapper mapper;

    @Override
    public int insert(TFinanceProductChange productChange) {
        return mapper.insert(productChange);
    }

    @Override
    public int insertBatch(List<TFinanceProductChange> list) {
        return mapper.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByHeadId(long headId) {
        TFinanceProductChangeExample example = new TFinanceProductChangeExample();
        TFinanceProductChangeExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        return mapper.deleteByExample(example);
    }

    @Override
    public List<TFinanceProductChange> queryByProperty(TFinanceProductChange map) {
        TFinanceProductChangeExample example = new TFinanceProductChangeExample();
        TFinanceProductChangeExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(map.getFheadId());
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }
}
