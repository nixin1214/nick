package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList4;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList4Example;
import com.roncoo.adminlte.util.base.MyBatis;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceMainBusinessList4Mapper {
    int countByExample(TFinanceMainBusinessList4Example example);

    int deleteByExample(TFinanceMainBusinessList4Example example);

    int deleteByPrimaryKey(BigDecimal fid);

    int insertBatch(@Param("list") List<TFinanceMainBusinessList4> list);

    int insert(TFinanceMainBusinessList4 record);

    int insertSelective(TFinanceMainBusinessList4 record);

    List<TFinanceMainBusinessList4> selectByExample(TFinanceMainBusinessList4Example example);

    TFinanceMainBusinessList4 selectByPrimaryKey(BigDecimal fid);

    int updateByExampleSelective(@Param("record") TFinanceMainBusinessList4 record, @Param("example") TFinanceMainBusinessList4Example example);

    int updateByExample(@Param("record") TFinanceMainBusinessList4 record, @Param("example") TFinanceMainBusinessList4Example example);

    int updateByPrimaryKeySelective(TFinanceMainBusinessList4 record);

    int updateByPrimaryKey(TFinanceMainBusinessList4 record);
}