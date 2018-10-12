package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceMilkCostThis;
import com.roncoo.adminlte.bean.entity.TFinanceMilkCostThisExample;
import com.roncoo.adminlte.util.base.MyBatis;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceMilkCostThisMapper {
    int countByExample(TFinanceMilkCostThisExample example);

    int deleteByExample(TFinanceMilkCostThisExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TFinanceMilkCostThis record);

    int insertBatch(@Param("list") List<TFinanceMilkCostThis> list);

    int insertSelective(TFinanceMilkCostThis record);

    List<TFinanceMilkCostThis> selectByExample(TFinanceMilkCostThisExample example);

    TFinanceMilkCostThis selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TFinanceMilkCostThis record, @Param("example") TFinanceMilkCostThisExample example);

    int updateByExample(@Param("record") TFinanceMilkCostThis record, @Param("example") TFinanceMilkCostThisExample example);

    int updateByPrimaryKeySelective(TFinanceMilkCostThis record);

    int updateByPrimaryKey(TFinanceMilkCostThis record);
}