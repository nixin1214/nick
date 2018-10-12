package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceProductChange;
import com.roncoo.adminlte.bean.entity.TFinanceProductChangeExample;
import com.roncoo.adminlte.util.base.MyBatis;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceProductChangeMapper {
    int countByExample(TFinanceProductChangeExample example);

    int deleteByExample(TFinanceProductChangeExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TFinanceProductChange record);

    int insertBatch(@Param("list") List<TFinanceProductChange> list);

    int insertSelective(TFinanceProductChange record);

    List<TFinanceProductChange> selectByExample(TFinanceProductChangeExample example);

    TFinanceProductChange selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TFinanceProductChange record, @Param("example") TFinanceProductChangeExample example);

    int updateByExample(@Param("record") TFinanceProductChange record, @Param("example") TFinanceProductChangeExample example);

    int updateByPrimaryKeySelective(TFinanceProductChange record);

    int updateByPrimaryKey(TFinanceProductChange record);
}