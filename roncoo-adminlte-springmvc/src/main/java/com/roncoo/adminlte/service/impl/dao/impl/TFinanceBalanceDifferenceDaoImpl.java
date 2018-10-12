package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFinanceBalanceDifference;
import com.roncoo.adminlte.bean.entity.TFinanceBalanceDifferenceExample;
import com.roncoo.adminlte.service.impl.dao.TFinanceBalanceDifferenceDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TFinanceBalanceDifferenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 资产负债表(差额表)
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:37
 */
@Repository
public class TFinanceBalanceDifferenceDaoImpl implements TFinanceBalanceDifferenceDao {

    @Autowired
    private TFinanceBalanceDifferenceMapper mapper;

    @Override
    public int insert(TFinanceBalanceDifference fixedAssetsChange) {
        return mapper.insert(fixedAssetsChange);
    }

    @Override
    public int insertBatch(List<TFinanceBalanceDifference> list) {
        return mapper.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByHeadId(long headId) {
        TFinanceBalanceDifferenceExample example = new TFinanceBalanceDifferenceExample();
        TFinanceBalanceDifferenceExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        return mapper.deleteByExample(example);
    }

    @Override
    public List<TFinanceBalanceDifference> queryByProperty(TFinanceBalanceDifference expenses) {
        TFinanceBalanceDifferenceExample example = new TFinanceBalanceDifferenceExample();
        TFinanceBalanceDifferenceExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(expenses.getFheadId());
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceBalanceDifference> queryByHeadId(Long headId) {
        TFinanceBalanceDifferenceExample example = new TFinanceBalanceDifferenceExample();
        TFinanceBalanceDifferenceExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }
}
