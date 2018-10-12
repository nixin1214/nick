package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TAccountsReceivable;
import com.roncoo.adminlte.bean.entity.TAccountsReceivableExample;
import com.roncoo.adminlte.util.base.Page;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface TAccountsReceivableDao {


    long countByExample(TAccountsReceivableExample example);

    int deleteByExample(TAccountsReceivableExample example);

    int deleteByPrimaryKey(BigDecimal fid);

    int insert(TAccountsReceivable record);

    int insertSelective(TAccountsReceivable record);

    List<TAccountsReceivable> selectByExample(TAccountsReceivableExample example);

    TAccountsReceivable selectByPrimaryKey(BigDecimal fid);

    List<TAccountsReceivable> selectByHeadId(BigDecimal fheadid);

    int updateByExampleSelective(@Param("record") TAccountsReceivable record, @Param("example") TAccountsReceivableExample example);

    int updateByExample(@Param("record") TAccountsReceivable record, @Param("example") TAccountsReceivableExample example);

    int updateByPrimaryKeySelective(TAccountsReceivable record);

    int updateByPrimaryKey(TAccountsReceivable record);

    int insertBatch(List<TAccountsReceivable> list);

    /**
     * 分页查询
     * @param pageCurrent
     * @param pageSize
     * @param headId
     * @return
     */
    Page<TAccountsReceivable> listForPage(int pageCurrent, int pageSize, List<BigDecimal> headId);

}
