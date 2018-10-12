package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList4;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList5;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList5Example;
import com.roncoo.adminlte.util.base.MyBatis;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceMainBusinessList5Mapper {
    int countByExample(TFinanceMainBusinessList5Example example);

    int deleteByExample(TFinanceMainBusinessList5Example example);

    int deleteByPrimaryKey(BigDecimal fid);

    int insertBatch(@Param("list") List<TFinanceMainBusinessList5> list);

    int insert(TFinanceMainBusinessList5 record);

    int insertSelective(TFinanceMainBusinessList5 record);

    List<TFinanceMainBusinessList5> selectByExample(TFinanceMainBusinessList5Example example);

    TFinanceMainBusinessList5 selectByPrimaryKey(BigDecimal fid);

    int updateByExampleSelective(@Param("record") TFinanceMainBusinessList5 record, @Param("example") TFinanceMainBusinessList5Example example);

    int updateByExample(@Param("record") TFinanceMainBusinessList5 record, @Param("example") TFinanceMainBusinessList5Example example);

    int updateByPrimaryKeySelective(TFinanceMainBusinessList5 record);

    int updateByPrimaryKey(TFinanceMainBusinessList5 record);
}