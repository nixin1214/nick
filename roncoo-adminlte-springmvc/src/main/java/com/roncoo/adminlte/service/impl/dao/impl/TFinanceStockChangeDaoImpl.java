package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFinanceStockChange;
import com.roncoo.adminlte.bean.entity.TFinanceStockChangeExample;
import com.roncoo.adminlte.service.impl.dao.TFinanceStockChangeDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TFinanceStockChangeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 存货增减表DAO实现类
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/11 15:36
 */
@Repository
public class TFinanceStockChangeDaoImpl implements TFinanceStockChangeDao {

    @Autowired
    private TFinanceStockChangeMapper mapper;

    @Override
    public int insert(TFinanceStockChange stockChange) {
        return mapper.insert(stockChange);
    }

    @Override
    public int insertBatch(List<TFinanceStockChange> list) {
        return mapper.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByHeadId(long headId) {
        TFinanceStockChangeExample example = new TFinanceStockChangeExample();
        TFinanceStockChangeExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        return mapper.deleteByExample(example);
    }

    @Override
    public List<TFinanceStockChange> queryByProperty(TFinanceStockChange stockChange) {
        TFinanceStockChangeExample example = new TFinanceStockChangeExample();
        TFinanceStockChangeExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(stockChange.getFheadId());
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }
}
