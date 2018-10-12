package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFinanceManagerEDiff;
import com.roncoo.adminlte.bean.entity.TFinanceManagerEDiffExample;
import com.roncoo.adminlte.bean.entity.TFinanceManagerExpenses;
import com.roncoo.adminlte.bean.entity.TFinanceManagerExpensesExample;
import com.roncoo.adminlte.service.impl.dao.TFinanceManagerExpensesDao;
import com.roncoo.adminlte.service.impl.dao.TFinanceManagerExpensesDiffDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TFinanceManagerEDiffMapper;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TFinanceManagerExpensesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 管理费用
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:42
 */
@Repository
public class TFinanceManagerExpensesDiffDaoImpl implements TFinanceManagerExpensesDiffDao {

    @Autowired
    private TFinanceManagerEDiffMapper mapper;

    @Override
    public int insert(TFinanceManagerEDiff managerExpenses) {
        return mapper.insert(managerExpenses);
    }

    @Override
    public int insertBatch(List<TFinanceManagerEDiff> list) {
        return mapper.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByHeadId(long headId) {
        TFinanceManagerEDiffExample example = new TFinanceManagerEDiffExample();
        TFinanceManagerEDiffExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        return mapper.deleteByExample(example);
    }

    @Override
    public List<TFinanceManagerEDiff> queryByHeadId(Long headId) {
        TFinanceManagerEDiffExample example = new TFinanceManagerEDiffExample();
        TFinanceManagerEDiffExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }
}
