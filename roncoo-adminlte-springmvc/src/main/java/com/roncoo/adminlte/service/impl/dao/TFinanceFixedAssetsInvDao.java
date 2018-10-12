package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceFixedAssetsInv;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 固定资产投资情况
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 10:59
 */
public interface TFinanceFixedAssetsInvDao {

    int insert(TFinanceFixedAssetsInv fixedAssetsChange);

    int insertBatch(List<TFinanceFixedAssetsInv> list);

    int deleteById(Long id);

    int deleteByHeadId(long headId);

    List<TFinanceFixedAssetsInv> queryByProperty(TFinanceFixedAssetsInv fixedAssetsInv);

    List<TFinanceFixedAssetsInv> queryByHeadId(Long headId);

    List<TFinanceFixedAssetsInv> queryByPropertyAll(List<Long> tfheadids);
}
