package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceEmpSalary;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 员工薪酬
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 10:59
 */
public interface TFinanceEmpSalaryDao {

    int insert(TFinanceEmpSalary fixedAssetsChange);

    int insertBatch(List<TFinanceEmpSalary> list);

    int deleteById(Long id);

    int deleteByHeadId(long headId);

    List<TFinanceEmpSalary> queryByProperty(TFinanceEmpSalary fixedAssetsChange);

    List<TFinanceEmpSalary> queryByHeadId(Long headId);

    List<TFinanceEmpSalary> queryByPropertyAll(List<Long> tfheadids);
}
