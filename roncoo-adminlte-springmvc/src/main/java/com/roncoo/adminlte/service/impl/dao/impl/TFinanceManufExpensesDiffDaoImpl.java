package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFinanceManufEDiff;
import com.roncoo.adminlte.bean.entity.TFinanceManufEDiffExample;
import com.roncoo.adminlte.bean.entity.TFinanceManufExpenses;
import com.roncoo.adminlte.bean.entity.TFinanceManufExpensesExample;
import com.roncoo.adminlte.service.impl.dao.TFinanceManufExpensesDao;
import com.roncoo.adminlte.service.impl.dao.TFinanceManufExpensesDiffDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TFinanceManufEDiffMapper;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TFinanceManufExpensesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 制造费用
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:40
 */
@Repository
public class TFinanceManufExpensesDiffDaoImpl implements TFinanceManufExpensesDiffDao {

    @Autowired
    private TFinanceManufEDiffMapper mapper;

    @Override
    public int insert(TFinanceManufEDiff fixedAssetsChange) {
        return mapper.insert(fixedAssetsChange);
    }

    @Override
    public int insertBatch(List<TFinanceManufEDiff> list) {
        return mapper.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByHeadId(long headId) {
        TFinanceManufEDiffExample example = new TFinanceManufEDiffExample();
        TFinanceManufEDiffExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        return mapper.deleteByExample(example);
    }

    @Override
    public List<TFinanceManufEDiff> queryByHeadId(Long headId) {
        TFinanceManufEDiffExample example = new TFinanceManufEDiffExample();
        TFinanceManufEDiffExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }
}
