package com.roncoo.adminlte.service.impl.dao.impl.mybatis;


import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessTotal2;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessTotal2Example;
import com.roncoo.adminlte.util.base.MyBatis;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceMainBusinessTotal2Mapper {
    int countByExample(TFinanceMainBusinessTotal2Example example);

    int deleteByExample(TFinanceMainBusinessTotal2Example example);

    int deleteByPrimaryKey(BigDecimal fid);

    int insertBatch(@Param("list") List<TFinanceMainBusinessTotal2> list);

    int insert(TFinanceMainBusinessTotal2 record);

    int insertSelective(TFinanceMainBusinessTotal2 record);

    List<TFinanceMainBusinessTotal2> selectByExample(TFinanceMainBusinessTotal2Example example);

    TFinanceMainBusinessTotal2 selectByPrimaryKey(BigDecimal fid);

    int updateByExampleSelective(@Param("record") TFinanceMainBusinessTotal2 record, @Param("example") TFinanceMainBusinessTotal2Example example);

    int updateByExample(@Param("record") TFinanceMainBusinessTotal2 record, @Param("example") TFinanceMainBusinessTotal2Example example);

    int updateByPrimaryKeySelective(TFinanceMainBusinessTotal2 record);

    int updateByPrimaryKey(TFinanceMainBusinessTotal2 record);
}