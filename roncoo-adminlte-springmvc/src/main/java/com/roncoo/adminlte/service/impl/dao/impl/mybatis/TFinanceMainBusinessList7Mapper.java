package com.roncoo.adminlte.service.impl.dao.impl.mybatis;


import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList7;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList7Example;
import com.roncoo.adminlte.util.base.MyBatis;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceMainBusinessList7Mapper {
    int countByExample(TFinanceMainBusinessList7Example example);

    int deleteByExample(TFinanceMainBusinessList7Example example);

    int deleteByPrimaryKey(BigDecimal fid);

    int insertBatch(@Param("list") List<TFinanceMainBusinessList7> list);

    int insert(TFinanceMainBusinessList7 record);

    int insertSelective(TFinanceMainBusinessList7 record);

    List<TFinanceMainBusinessList7> selectByExample(TFinanceMainBusinessList7Example example);

    TFinanceMainBusinessList7 selectByPrimaryKey(BigDecimal fid);

    int updateByExampleSelective(@Param("record") TFinanceMainBusinessList7 record, @Param("example") TFinanceMainBusinessList7Example example);

    int updateByExample(@Param("record") TFinanceMainBusinessList7 record, @Param("example") TFinanceMainBusinessList7Example example);

    int updateByPrimaryKeySelective(TFinanceMainBusinessList7 record);

    int updateByPrimaryKey(TFinanceMainBusinessList7 record);
}