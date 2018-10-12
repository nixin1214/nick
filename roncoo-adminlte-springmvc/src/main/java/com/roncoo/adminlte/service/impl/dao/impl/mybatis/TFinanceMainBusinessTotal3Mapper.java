package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessTotal3;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessTotal3Example;
import com.roncoo.adminlte.util.base.MyBatis;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceMainBusinessTotal3Mapper {
    int countByExample(TFinanceMainBusinessTotal3Example example);

    int deleteByExample(TFinanceMainBusinessTotal3Example example);

    int deleteByPrimaryKey(BigDecimal fid);

    int insertBatch(@Param("list") List<TFinanceMainBusinessTotal3> list);

    int insert(TFinanceMainBusinessTotal3 record);

    int insertSelective(TFinanceMainBusinessTotal3 record);

    List<TFinanceMainBusinessTotal3> selectByExample(TFinanceMainBusinessTotal3Example example);

    TFinanceMainBusinessTotal3 selectByPrimaryKey(BigDecimal fid);

    int updateByExampleSelective(@Param("record") TFinanceMainBusinessTotal3 record, @Param("example") TFinanceMainBusinessTotal3Example example);

    int updateByExample(@Param("record") TFinanceMainBusinessTotal3 record, @Param("example") TFinanceMainBusinessTotal3Example example);

    int updateByPrimaryKeySelective(TFinanceMainBusinessTotal3 record);

    int updateByPrimaryKey(TFinanceMainBusinessTotal3 record);
}