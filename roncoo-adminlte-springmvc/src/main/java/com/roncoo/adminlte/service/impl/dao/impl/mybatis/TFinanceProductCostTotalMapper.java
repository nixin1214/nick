package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceProductCostTotal;
import com.roncoo.adminlte.bean.entity.TFinanceProductCostTotalExample;
import com.roncoo.adminlte.util.base.MyBatis;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceProductCostTotalMapper {
    int countByExample(TFinanceProductCostTotalExample example);

    int deleteByExample(TFinanceProductCostTotalExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TFinanceProductCostTotal record);

    int insertBatch(@Param("list") List<TFinanceProductCostTotal> list);

    int insertSelective(TFinanceProductCostTotal record);

    List<TFinanceProductCostTotal> selectByExample(TFinanceProductCostTotalExample example);

    TFinanceProductCostTotal selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TFinanceProductCostTotal record, @Param("example") TFinanceProductCostTotalExample example);

    int updateByExample(@Param("record") TFinanceProductCostTotal record, @Param("example") TFinanceProductCostTotalExample example);

    int updateByPrimaryKeySelective(TFinanceProductCostTotal record);

    int updateByPrimaryKey(TFinanceProductCostTotal record);
}