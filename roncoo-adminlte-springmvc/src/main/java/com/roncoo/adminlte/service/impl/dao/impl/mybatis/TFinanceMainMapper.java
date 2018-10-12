package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceMain;
import com.roncoo.adminlte.bean.entity.TFinanceMainExample;
import com.roncoo.adminlte.util.base.MyBatis;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TFinanceMainMapper {
    int countByExample(TFinanceMainExample example);

    int deleteByExample(TFinanceMainExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TFinanceMain record);

    int insertSelective(TFinanceMain record);

    List<TFinanceMain> selectByExample(TFinanceMainExample example);

    TFinanceMain selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TFinanceMain record, @Param("example") TFinanceMainExample example);

    int updateByExample(@Param("record") TFinanceMain record, @Param("example") TFinanceMainExample example);

    int updateByPrimaryKeySelective(TFinanceMain record);

    int updateByPrimaryKey(TFinanceMain record);
}