package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceProductCostThis;
import com.roncoo.adminlte.bean.entity.TFinanceProductCostThisExample;
import com.roncoo.adminlte.util.base.MyBatis;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceProductCostThisMapper {
    int countByExample(TFinanceProductCostThisExample example);

    int deleteByExample(TFinanceProductCostThisExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TFinanceProductCostThis record);

    int insertBatch(@Param("list") List<TFinanceProductCostThis> list);

    int insertSelective(TFinanceProductCostThis record);

    List<TFinanceProductCostThis> selectByExample(TFinanceProductCostThisExample example);

    TFinanceProductCostThis selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TFinanceProductCostThis record, @Param("example") TFinanceProductCostThisExample example);

    int updateByExample(@Param("record") TFinanceProductCostThis record, @Param("example") TFinanceProductCostThisExample example);

    int updateByPrimaryKeySelective(TFinanceProductCostThis record);

    int updateByPrimaryKey(TFinanceProductCostThis record);
}