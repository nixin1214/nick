package com.roncoo.adminlte.service.impl.dao.impl.mybatis;

import com.roncoo.adminlte.bean.entity.TAccountsReceivable;
import com.roncoo.adminlte.bean.entity.TAccountsReceivableExample;
import com.roncoo.adminlte.util.base.MyBatis;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@MyBatis
public interface TAccountsReceivableMapper {
    int countByExample(TAccountsReceivableExample example);

    int deleteByExample(TAccountsReceivableExample example);

    int deleteByPrimaryKey(BigDecimal fid);

    int insert(TAccountsReceivable record);

    int insertSelective(TAccountsReceivable record);

    List<TAccountsReceivable> selectByExample(TAccountsReceivableExample example);

    TAccountsReceivable selectByPrimaryKey(BigDecimal fid);

    List<TAccountsReceivable> selectByHeadId(BigDecimal fheadId);

    int updateByExampleSelective(@Param("record") TAccountsReceivable record, @Param("example") TAccountsReceivableExample example);

    int updateByExample(@Param("record") TAccountsReceivable record, @Param("example") TAccountsReceivableExample example);

    int updateByPrimaryKeySelective(TAccountsReceivable record);

    int updateByPrimaryKey(TAccountsReceivable record);

    int insertBatch(List<TAccountsReceivable> list);
}