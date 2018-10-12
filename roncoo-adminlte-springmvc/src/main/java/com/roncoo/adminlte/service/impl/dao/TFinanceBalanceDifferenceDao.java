package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceBalanceDifference;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 资产负债表(差额表)
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:00
 */
public interface TFinanceBalanceDifferenceDao {

    int insert(TFinanceBalanceDifference difference);

    int insertBatch(List<TFinanceBalanceDifference> list);

    int deleteById(Long id);

    int deleteByHeadId(long headId);

    List<TFinanceBalanceDifference> queryByProperty(TFinanceBalanceDifference expenses);

    List<TFinanceBalanceDifference> queryByHeadId(Long headId);
}
