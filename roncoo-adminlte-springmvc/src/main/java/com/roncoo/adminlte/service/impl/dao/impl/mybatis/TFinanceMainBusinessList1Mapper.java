package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList1;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList1Example;
import com.roncoo.adminlte.bean.entity.TFinanceProductCostThis;
import com.roncoo.adminlte.util.base.MyBatis;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceMainBusinessList1Mapper {
    int countByExample(TFinanceMainBusinessList1Example example);

    int deleteByExample(TFinanceMainBusinessList1Example example);

    int deleteByPrimaryKey(BigDecimal fid);

    int insert(TFinanceMainBusinessList1 record);

    int insertBatch(@Param("list") List<TFinanceMainBusinessList1> list);

    int insertSelective(TFinanceMainBusinessList1 record);

    List<TFinanceMainBusinessList1> selectByExample(TFinanceMainBusinessList1Example example);

    TFinanceMainBusinessList1 selectByPrimaryKey(BigDecimal fid);

    int updateByExampleSelective(@Param("record") TFinanceMainBusinessList1 record, @Param("example") TFinanceMainBusinessList1Example example);

    int updateByExample(@Param("record") TFinanceMainBusinessList1 record, @Param("example") TFinanceMainBusinessList1Example example);

    int updateByPrimaryKeySelective(TFinanceMainBusinessList1 record);

    int updateByPrimaryKey(TFinanceMainBusinessList1 record);
}