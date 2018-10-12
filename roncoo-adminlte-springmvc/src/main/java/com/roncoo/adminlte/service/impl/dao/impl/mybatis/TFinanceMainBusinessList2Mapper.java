package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList2;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList2Example;
import com.roncoo.adminlte.util.base.MyBatis;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceMainBusinessList2Mapper {
    int countByExample(TFinanceMainBusinessList2Example example);

    int deleteByExample(TFinanceMainBusinessList2Example example);

    int deleteByPrimaryKey(BigDecimal fid);

    int insert(TFinanceMainBusinessList2 record);

    int insertBatch(@Param("list") List<TFinanceMainBusinessList2> list);

    int insertSelective(TFinanceMainBusinessList2 record);

    List<TFinanceMainBusinessList2> selectByExample(TFinanceMainBusinessList2Example example);

    TFinanceMainBusinessList2 selectByPrimaryKey(BigDecimal fid);

    int updateByExampleSelective(@Param("record") TFinanceMainBusinessList2 record, @Param("example") TFinanceMainBusinessList2Example example);

    int updateByExample(@Param("record") TFinanceMainBusinessList2 record, @Param("example") TFinanceMainBusinessList2Example example);

    int updateByPrimaryKeySelective(TFinanceMainBusinessList2 record);

    int updateByPrimaryKey(TFinanceMainBusinessList2 record);
}