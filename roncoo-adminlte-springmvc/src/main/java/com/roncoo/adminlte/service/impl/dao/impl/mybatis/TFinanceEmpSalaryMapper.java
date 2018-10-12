package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceEmpSalary;
import com.roncoo.adminlte.bean.entity.TFinanceEmpSalaryExample;
import com.roncoo.adminlte.util.base.MyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatis
public interface TFinanceEmpSalaryMapper {
    int countByExample(TFinanceEmpSalaryExample example);

    int deleteByExample(TFinanceEmpSalaryExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TFinanceEmpSalary record);

    int insertBatch(@Param("list") List<TFinanceEmpSalary> list);

    int insertSelective(TFinanceEmpSalary record);

    List<TFinanceEmpSalary> selectByExample(TFinanceEmpSalaryExample example);

    TFinanceEmpSalary selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TFinanceEmpSalary record, @Param("example") TFinanceEmpSalaryExample example);

    int updateByExample(@Param("record") TFinanceEmpSalary record, @Param("example") TFinanceEmpSalaryExample example);

    int updateByPrimaryKeySelective(TFinanceEmpSalary record);

    int updateByPrimaryKey(TFinanceEmpSalary record);
}