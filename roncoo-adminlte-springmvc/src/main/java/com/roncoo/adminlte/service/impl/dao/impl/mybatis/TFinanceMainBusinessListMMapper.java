package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessListM;
import com.roncoo.adminlte.bean.entity.TFinanceMainBusinessListMExample;
import java.math.BigDecimal;
import java.util.List;

import com.roncoo.adminlte.util.base.MyBatis;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceMainBusinessListMMapper {
    long countByExample(TFinanceMainBusinessListMExample example);

    int deleteByExample(TFinanceMainBusinessListMExample example);

    int deleteByPrimaryKey(BigDecimal fid);

    int insert(TFinanceMainBusinessListM record);

    int insertSelective(TFinanceMainBusinessListM record);

    List<TFinanceMainBusinessListM> selectByExample(TFinanceMainBusinessListMExample example);

    TFinanceMainBusinessListM selectByPrimaryKey(BigDecimal fid);

    int updateByExampleSelective(@Param("record") TFinanceMainBusinessListM record, @Param("example") TFinanceMainBusinessListMExample example);

    int updateByExample(@Param("record") TFinanceMainBusinessListM record, @Param("example") TFinanceMainBusinessListMExample example);

    int updateByPrimaryKeySelective(TFinanceMainBusinessListM record);

    int updateByPrimaryKey(TFinanceMainBusinessListM record);
}