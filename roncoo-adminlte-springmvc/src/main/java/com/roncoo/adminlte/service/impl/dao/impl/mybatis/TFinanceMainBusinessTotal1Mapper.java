package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessTotal1;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessTotal1Example;
import com.roncoo.adminlte.util.base.MyBatis;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceMainBusinessTotal1Mapper {
    int countByExample(TFinanceMainBusinessTotal1Example example);

    int deleteByExample(TFinanceMainBusinessTotal1Example example);

    int deleteByPrimaryKey(BigDecimal fid);

    int insertBatch(@Param("list") List<TFinanceMainBusinessTotal1> list);

    int insert(TFinanceMainBusinessTotal1 record);

    int insertSelective(TFinanceMainBusinessTotal1 record);

    List<TFinanceMainBusinessTotal1> selectByExample(TFinanceMainBusinessTotal1Example example);

    TFinanceMainBusinessTotal1 selectByPrimaryKey(BigDecimal fid);

    int updateByExampleSelective(@Param("record") TFinanceMainBusinessTotal1 record, @Param("example") TFinanceMainBusinessTotal1Example example);

    int updateByExample(@Param("record") TFinanceMainBusinessTotal1 record, @Param("example") TFinanceMainBusinessTotal1Example example);

    int updateByPrimaryKeySelective(TFinanceMainBusinessTotal1 record);

    int updateByPrimaryKey(TFinanceMainBusinessTotal1 record);
}