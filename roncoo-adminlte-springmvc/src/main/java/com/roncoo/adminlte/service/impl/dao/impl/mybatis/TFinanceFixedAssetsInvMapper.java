package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TFinanceFixedAssetsInv;
import com.roncoo.adminlte.bean.entity.TFinanceFixedAssetsInvExample;
import com.roncoo.adminlte.util.base.MyBatis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatis
public interface TFinanceFixedAssetsInvMapper {
    int countByExample(TFinanceFixedAssetsInvExample example);

    int deleteByExample(TFinanceFixedAssetsInvExample example);

    int deleteByPrimaryKey(Long fid);

    int insert(TFinanceFixedAssetsInv record);

    int insertBatch(@Param("list") List<TFinanceFixedAssetsInv> list);

    int insertSelective(TFinanceFixedAssetsInv record);

    List<TFinanceFixedAssetsInv> selectByExample(TFinanceFixedAssetsInvExample example);

    TFinanceFixedAssetsInv selectByPrimaryKey(Long fid);

    int updateByExampleSelective(@Param("record") TFinanceFixedAssetsInv record, @Param("example") TFinanceFixedAssetsInvExample example);

    int updateByExample(@Param("record") TFinanceFixedAssetsInv record, @Param("example") TFinanceFixedAssetsInvExample example);

    int updateByPrimaryKeySelective(TFinanceFixedAssetsInv record);

    int updateByPrimaryKey(TFinanceFixedAssetsInv record);
}