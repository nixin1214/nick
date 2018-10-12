package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceStockChange;
import com.roncoo.adminlte.bean.entity.TFinanceStockChangeExample;
import com.roncoo.adminlte.util.base.MyBatis;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceStockChangeMapper {
    int countByExample(TFinanceStockChangeExample example);

    int deleteByExample(TFinanceStockChangeExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TFinanceStockChange record);

    int insertBatch(@Param("list") List<TFinanceStockChange> list);

    int insertSelective(TFinanceStockChange record);

    List<TFinanceStockChange> selectByExample(TFinanceStockChangeExample example);

    TFinanceStockChange selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TFinanceStockChange record, @Param("example") TFinanceStockChangeExample example);

    int updateByExample(@Param("record") TFinanceStockChange record, @Param("example") TFinanceStockChangeExample example);

    int updateByPrimaryKeySelective(TFinanceStockChange record);

    int updateByPrimaryKey(TFinanceStockChange record);
}