package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceMilkCostTotal;
import com.roncoo.adminlte.bean.entity.TFinanceMilkCostTotalExample;
import com.roncoo.adminlte.util.base.MyBatis;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceMilkCostTotalMapper {
    int countByExample(TFinanceMilkCostTotalExample example);

    int deleteByExample(TFinanceMilkCostTotalExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TFinanceMilkCostTotal record);

    int insertBatch(@Param("list") List<TFinanceMilkCostTotal> list);

    int insertSelective(TFinanceMilkCostTotal record);

    List<TFinanceMilkCostTotal> selectByExample(TFinanceMilkCostTotalExample example);

    TFinanceMilkCostTotal selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TFinanceMilkCostTotal record, @Param("example") TFinanceMilkCostTotalExample example);

    int updateByExample(@Param("record") TFinanceMilkCostTotal record, @Param("example") TFinanceMilkCostTotalExample example);

    int updateByPrimaryKeySelective(TFinanceMilkCostTotal record);

    int updateByPrimaryKey(TFinanceMilkCostTotal record);
}