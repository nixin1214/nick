package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFinanceEmpSalary;
import com.roncoo.adminlte.bean.entity.TFinanceEmpSalaryExample;
import com.roncoo.adminlte.service.impl.dao.TFinanceEmpSalaryDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TFinanceEmpSalaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 员工薪酬
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:35
 */
@Repository
public class TFinanceEmpSalaryDaoImpl implements TFinanceEmpSalaryDao {

    @Autowired
    private TFinanceEmpSalaryMapper mapper;

    @Override
    public int insert(TFinanceEmpSalary fixedAssetsChange) {
        return mapper.insert(fixedAssetsChange);
    }

    @Override
    public int insertBatch(List<TFinanceEmpSalary> list) {
        return mapper.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByHeadId(long headId) {
        TFinanceEmpSalaryExample example = new TFinanceEmpSalaryExample();
        TFinanceEmpSalaryExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        return mapper.deleteByExample(example);
    }

    @Override
    public List<TFinanceEmpSalary> queryByProperty(TFinanceEmpSalary fixedAssetsChange) {
        TFinanceEmpSalaryExample example = new TFinanceEmpSalaryExample();
        TFinanceEmpSalaryExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(fixedAssetsChange.getFheadId());
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceEmpSalary> queryByHeadId(Long headId) {
        TFinanceEmpSalaryExample example = new TFinanceEmpSalaryExample();
        TFinanceEmpSalaryExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceEmpSalary> queryByPropertyAll(List<Long> tfheadids) {
        TFinanceEmpSalaryExample example = new TFinanceEmpSalaryExample();
        TFinanceEmpSalaryExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdIn(tfheadids);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }
}
