package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.BalanceSheet;
import com.roncoo.adminlte.bean.entity.TFmainIndices5;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 资产负债表
 * Created by lx on 2017/11/1.
 */
public interface BalanceSheetDao {

    int insert(BalanceSheet obj);

    int insertBatch(@Param("list") List<BalanceSheet> list);

    int deleteById(Long id);

    int deleteByProperty(BalanceSheet obj);

    List<BalanceSheet> queryByProperty(Map map);

    List<BalanceSheet> queryByPropertyAll(List<Long> tfheadids);
}
