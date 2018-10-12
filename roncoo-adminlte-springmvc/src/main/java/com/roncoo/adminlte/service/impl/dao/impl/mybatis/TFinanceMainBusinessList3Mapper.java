package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList3;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessList3Example;
import com.roncoo.adminlte.util.base.MyBatis;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceMainBusinessList3Mapper {
    int countByExample(TFinanceMainBusinessList3Example example);

    int deleteByExample(TFinanceMainBusinessList3Example example);

    int deleteByPrimaryKey(BigDecimal fid);

    int insertBatch(@Param("list") List<TFinanceMainBusinessList3> list);

    int insert(TFinanceMainBusinessList3 record);

    int insertSelective(TFinanceMainBusinessList3 record);

    List<TFinanceMainBusinessList3> selectByExample(TFinanceMainBusinessList3Example example);

    TFinanceMainBusinessList3 selectByPrimaryKey(BigDecimal fid);

    int updateByExampleSelective(@Param("record") TFinanceMainBusinessList3 record, @Param("example") TFinanceMainBusinessList3Example example);

    int updateByExample(@Param("record") TFinanceMainBusinessList3 record, @Param("example") TFinanceMainBusinessList3Example example);

    int updateByPrimaryKeySelective(TFinanceMainBusinessList3 record);

    int updateByPrimaryKey(TFinanceMainBusinessList3 record);
}