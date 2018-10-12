package com.roncoo.adminlte.service.impl.dao.impl.mybatis;


import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList6;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList6Example;
import com.roncoo.adminlte.util.base.MyBatis;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceMainBusinessList6Mapper {
    int countByExample(TFinanceMainBusinessList6Example example);

    int deleteByExample(TFinanceMainBusinessList6Example example);

    int deleteByPrimaryKey(BigDecimal fid);

    int insertBatch(@Param("list") List<TFinanceMainBusinessList6> list);

    int insert(TFinanceMainBusinessList6 record);

    int insertSelective(TFinanceMainBusinessList6 record);

    List<TFinanceMainBusinessList6> selectByExample(TFinanceMainBusinessList6Example example);

    TFinanceMainBusinessList6 selectByPrimaryKey(BigDecimal fid);

    int updateByExampleSelective(@Param("record") TFinanceMainBusinessList6 record, @Param("example") TFinanceMainBusinessList6Example example);

    int updateByExample(@Param("record") TFinanceMainBusinessList6 record, @Param("example") TFinanceMainBusinessList6Example example);

    int updateByPrimaryKeySelective(TFinanceMainBusinessList6 record);

    int updateByPrimaryKey(TFinanceMainBusinessList6 record);
}