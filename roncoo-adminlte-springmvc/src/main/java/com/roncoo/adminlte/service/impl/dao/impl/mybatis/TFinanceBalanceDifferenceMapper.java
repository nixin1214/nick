package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceBalanceDifference;
import com.roncoo.adminlte.bean.entity.TFinanceBalanceDifferenceExample;
import com.roncoo.adminlte.util.base.MyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatis
public interface TFinanceBalanceDifferenceMapper {
    int countByExample(TFinanceBalanceDifferenceExample example);

    int deleteByExample(TFinanceBalanceDifferenceExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TFinanceBalanceDifference record);

    int insertBatch(@Param("list") List<TFinanceBalanceDifference> list);

    int insertSelective(TFinanceBalanceDifference record);

    List<TFinanceBalanceDifference> selectByExample(TFinanceBalanceDifferenceExample example);

    TFinanceBalanceDifference selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TFinanceBalanceDifference record, @Param("example") TFinanceBalanceDifferenceExample example);

    int updateByExample(@Param("record") TFinanceBalanceDifference record, @Param("example") TFinanceBalanceDifferenceExample example);

    int updateByPrimaryKeySelective(TFinanceBalanceDifference record);

    int updateByPrimaryKey(TFinanceBalanceDifference record);
}