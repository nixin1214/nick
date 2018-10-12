package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceFixedAssetsChange;
import com.roncoo.adminlte.bean.entity.TFinanceFixedAssetsChangeExample;
import com.roncoo.adminlte.util.base.MyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatis
public interface TFinanceFixedAssetsChangeMapper {
    int countByExample(TFinanceFixedAssetsChangeExample example);

    int deleteByExample(TFinanceFixedAssetsChangeExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TFinanceFixedAssetsChange record);

    int insertBatch(@Param("list") List<TFinanceFixedAssetsChange> list);

    int insertSelective(TFinanceFixedAssetsChange record);

    List<TFinanceFixedAssetsChange> selectByExample(TFinanceFixedAssetsChangeExample example);

    TFinanceFixedAssetsChange selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TFinanceFixedAssetsChange record, @Param("example") TFinanceFixedAssetsChangeExample example);

    int updateByExample(@Param("record") TFinanceFixedAssetsChange record, @Param("example") TFinanceFixedAssetsChangeExample example);

    int updateByPrimaryKeySelective(TFinanceFixedAssetsChange record);

    int updateByPrimaryKey(TFinanceFixedAssetsChange record);
}