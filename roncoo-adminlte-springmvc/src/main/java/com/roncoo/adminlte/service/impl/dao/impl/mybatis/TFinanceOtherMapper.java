package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceOther;
import com.roncoo.adminlte.bean.entity.TFinanceOtherExample;
import com.roncoo.adminlte.util.base.MyBatis;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceOtherMapper {
    int countByExample(TFinanceOtherExample example);

    int deleteByExample(TFinanceOtherExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TFinanceOther record);

    int insertBatch(@Param("list") List<TFinanceOther> list);

    int insertSelective(TFinanceOther record);

    List<TFinanceOther> selectByExample(TFinanceOtherExample example);

    TFinanceOther selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TFinanceOther record, @Param("example") TFinanceOtherExample example);

    int updateByExample(@Param("record") TFinanceOther record, @Param("example") TFinanceOtherExample example);

    int updateByPrimaryKeySelective(TFinanceOther record);

    int updateByPrimaryKey(TFinanceOther record);
}