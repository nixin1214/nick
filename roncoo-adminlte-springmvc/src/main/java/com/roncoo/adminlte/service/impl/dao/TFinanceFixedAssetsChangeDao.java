package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceFixedAssetsChange;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: TODO
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/11 15:28
 */
public interface TFinanceFixedAssetsChangeDao {

    int insert(TFinanceFixedAssetsChange fixedAssetsChange);

    int insertBatch(@Param("list") List<TFinanceFixedAssetsChange> list);

    int deleteById(Long id);

    int deleteByHeadId(long headId);

    List<TFinanceFixedAssetsChange> queryByProperty(TFinanceFixedAssetsChange fixedAssetsChange);

    List<TFinanceFixedAssetsChange> queryByPropertyAll(List<Long> tfheadids);
}
