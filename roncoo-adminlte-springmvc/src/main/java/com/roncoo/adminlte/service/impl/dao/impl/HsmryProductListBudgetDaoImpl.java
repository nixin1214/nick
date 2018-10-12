package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.HsmryProductListBudget;
import com.roncoo.adminlte.bean.entity.HsmryProductListBudgetExample;
import com.roncoo.adminlte.service.impl.dao.HsmryProductListBudgetDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.HsmryProductListBudgetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class HsmryProductListBudgetDaoImpl implements HsmryProductListBudgetDao{

    @Autowired
    private HsmryProductListBudgetMapper mapper;

    @Override
    public long countByExample(HsmryProductListBudgetExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(HsmryProductListBudget record) {
        HsmryProductListBudgetExample example = new HsmryProductListBudgetExample();
        HsmryProductListBudgetExample.Criteria criteria = example.createCriteria();
        criteria.andProductnameEqualTo(record.getProductname());
        criteria.andYearmonthEqualTo(record.getYearmonth());
        int result = mapper.deleteByExample(example);
        return result;
    }

    @Override
    public int deleteByPrimaryKey(BigDecimal fid) {
        return mapper.deleteByPrimaryKey(fid);
    }

    @Override
    public int insert(HsmryProductListBudget record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(HsmryProductListBudget record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<HsmryProductListBudget> selectByExample(HsmryProductListBudgetExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public HsmryProductListBudget selectByPrimaryKey(BigDecimal fid) {
        return mapper.selectByPrimaryKey(fid);
    }

    @Override
    public int updateByExampleSelective(HsmryProductListBudget record, HsmryProductListBudgetExample example) {
        return mapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(HsmryProductListBudget record, HsmryProductListBudgetExample example) {
        return mapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(HsmryProductListBudget record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(HsmryProductListBudget record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public int insertBatch(List<HsmryProductListBudget> list) {
        return mapper.insertBatch(list);
    }
}
