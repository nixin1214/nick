package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceBalance;
import com.roncoo.adminlte.bean.entity.TFinanceBalanceExample;
import com.roncoo.adminlte.util.base.MyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatis
public interface TFinanceBalanceMapper {
    int countByExample(TFinanceBalanceExample example);

    int deleteByExample(TFinanceBalanceExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TFinanceBalance record);

    int insertSelective(TFinanceBalance record);

    List<TFinanceBalance> selectByExample(TFinanceBalanceExample example);

    TFinanceBalance selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TFinanceBalance record, @Param("example") TFinanceBalanceExample example);

    int updateByExample(@Param("record") TFinanceBalance record, @Param("example") TFinanceBalanceExample example);

    int updateByPrimaryKeySelective(TFinanceBalance record);

    int updateByPrimaryKey(TFinanceBalance record);
}