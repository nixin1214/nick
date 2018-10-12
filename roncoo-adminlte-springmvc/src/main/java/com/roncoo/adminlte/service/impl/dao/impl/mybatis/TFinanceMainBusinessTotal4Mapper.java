package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessTotal3;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessTotal4;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessTotal4Example;
import com.roncoo.adminlte.util.base.MyBatis;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceMainBusinessTotal4Mapper {
    int countByExample(TFinanceMainBusinessTotal4Example example);

    int deleteByExample(TFinanceMainBusinessTotal4Example example);

    int deleteByPrimaryKey(BigDecimal fid);

    int insertBatch(@Param("list") List<TFinanceMainBusinessTotal4> list);

    int insert(TFinanceMainBusinessTotal4 record);

    int insertSelective(TFinanceMainBusinessTotal4 record);

    List<TFinanceMainBusinessTotal4> selectByExample(TFinanceMainBusinessTotal4Example example);

    TFinanceMainBusinessTotal4 selectByPrimaryKey(BigDecimal fid);

    int updateByExampleSelective(@Param("record") TFinanceMainBusinessTotal4 record, @Param("example") TFinanceMainBusinessTotal4Example example);

    int updateByExample(@Param("record") TFinanceMainBusinessTotal4 record, @Param("example") TFinanceMainBusinessTotal4Example example);

    int updateByPrimaryKeySelective(TFinanceMainBusinessTotal4 record);

    int updateByPrimaryKey(TFinanceMainBusinessTotal4 record);
}