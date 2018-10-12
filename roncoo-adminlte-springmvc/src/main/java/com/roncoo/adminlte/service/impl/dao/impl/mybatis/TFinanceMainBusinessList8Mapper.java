package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList7;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList8;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList8Example;
import com.roncoo.adminlte.util.base.MyBatis;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceMainBusinessList8Mapper {
    int countByExample(TFinanceMainBusinessList8Example example);

    int deleteByExample(TFinanceMainBusinessList8Example example);

    int deleteByPrimaryKey(BigDecimal fid);

    int insertBatch(@Param("list") List<TFinanceMainBusinessList8> list);

    int insert(TFinanceMainBusinessList8 record);

    int insertSelective(TFinanceMainBusinessList8 record);

    List<TFinanceMainBusinessList8> selectByExample(TFinanceMainBusinessList8Example example);

    TFinanceMainBusinessList8 selectByPrimaryKey(BigDecimal fid);

    int updateByExampleSelective(@Param("record") TFinanceMainBusinessList8 record, @Param("example") TFinanceMainBusinessList8Example example);

    int updateByExample(@Param("record") TFinanceMainBusinessList8 record, @Param("example") TFinanceMainBusinessList8Example example);

    int updateByPrimaryKeySelective(TFinanceMainBusinessList8 record);

    int updateByPrimaryKey(TFinanceMainBusinessList8 record);
}