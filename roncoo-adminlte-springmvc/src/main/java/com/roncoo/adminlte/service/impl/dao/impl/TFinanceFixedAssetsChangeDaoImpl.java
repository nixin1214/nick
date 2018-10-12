package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFinanceFixedAssetsChange;
import com.roncoo.adminlte.bean.entity.TFinanceFixedAssetsChangeExample;
import com.roncoo.adminlte.service.impl.dao.TFinanceFixedAssetsChangeDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TFinanceFixedAssetsChangeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 固定资产增减表DAO实现类
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/11 15:36
 */
@Repository
public class TFinanceFixedAssetsChangeDaoImpl implements TFinanceFixedAssetsChangeDao {
    @Autowired
    private TFinanceFixedAssetsChangeMapper mapper;

    @Override
    public int insert(TFinanceFixedAssetsChange fixedAssetsChange) {
        return mapper.insert(fixedAssetsChange);
    }

    @Override
    public int insertBatch(List<TFinanceFixedAssetsChange> list) {
        return mapper.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByHeadId(long headId) {
        TFinanceFixedAssetsChangeExample example = new TFinanceFixedAssetsChangeExample();
        TFinanceFixedAssetsChangeExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        return mapper.deleteByExample(example);
    }

    @Override
    public List<TFinanceFixedAssetsChange> queryByProperty(TFinanceFixedAssetsChange map) {
        TFinanceFixedAssetsChangeExample example = new TFinanceFixedAssetsChangeExample();
        TFinanceFixedAssetsChangeExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(map.getFheadId());
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceFixedAssetsChange> queryByPropertyAll(List<Long> tfheadids) {
        TFinanceFixedAssetsChangeExample example = new TFinanceFixedAssetsChangeExample();
        TFinanceFixedAssetsChangeExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdIn(tfheadids);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }
}
