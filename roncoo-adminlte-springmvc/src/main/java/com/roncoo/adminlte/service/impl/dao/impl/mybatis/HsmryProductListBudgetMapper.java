package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.HsmryProductListBudget;
import com.roncoo.adminlte.bean.entity.HsmryProductListBudgetExample;
import com.roncoo.adminlte.util.base.MyBatis;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

@MyBatis
public interface HsmryProductListBudgetMapper {
    long countByExample(HsmryProductListBudgetExample example);

    int deleteByExample(HsmryProductListBudgetExample example);

    int deleteByPrimaryKey(BigDecimal fid);

    int insert(HsmryProductListBudget record);

    int insertSelective(HsmryProductListBudget record);

    List<HsmryProductListBudget> selectByExample(HsmryProductListBudgetExample example);

    HsmryProductListBudget selectByPrimaryKey(BigDecimal fid);

    int updateByExampleSelective(@Param("record") HsmryProductListBudget record, @Param("example") HsmryProductListBudgetExample example);

    int updateByExample(@Param("record") HsmryProductListBudget record, @Param("example") HsmryProductListBudgetExample example);

    int updateByPrimaryKeySelective(HsmryProductListBudget record);

    int updateByPrimaryKey(HsmryProductListBudget record);

    int insertBatch(List<HsmryProductListBudget> quotas);//批量插入
}