package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFinanceTaxStatistics;
import com.roncoo.adminlte.bean.entity.TFinanceTaxStatisticsExample;
import com.roncoo.adminlte.service.impl.dao.TFinanceTaxStatisticsDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TFinanceTaxStatisticsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 税费统计表
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:15
 */
@Repository
public class TFinanceTaxStatisticsDaoImpl implements TFinanceTaxStatisticsDao {

    @Autowired
    private TFinanceTaxStatisticsMapper mapper;

    @Override
    public int insert(TFinanceTaxStatistics managerExpenses) {
        return mapper.insert(managerExpenses);
    }

    @Override
    public int insertBatch(List<TFinanceTaxStatistics> list) {
        return mapper.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByHeadId(long headId) {
        TFinanceTaxStatisticsExample example = new TFinanceTaxStatisticsExample();
        TFinanceTaxStatisticsExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        return mapper.deleteByExample(example);
    }

    @Override
    public List<TFinanceTaxStatistics> queryByHeadId(Long headId) {
        TFinanceTaxStatisticsExample example = new TFinanceTaxStatisticsExample();
        TFinanceTaxStatisticsExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceTaxStatistics> queryByPropertyAll(List<Long> tfheadids) {
        TFinanceTaxStatisticsExample example = new TFinanceTaxStatisticsExample();
        TFinanceTaxStatisticsExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdIn(tfheadids);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }
}
