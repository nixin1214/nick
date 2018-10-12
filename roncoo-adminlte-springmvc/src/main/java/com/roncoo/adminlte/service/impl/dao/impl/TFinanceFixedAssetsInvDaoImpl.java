package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TFinanceFixedAssetsInv;
import com.roncoo.adminlte.bean.entity.TFinanceFixedAssetsInvExample;
import com.roncoo.adminlte.service.impl.dao.TFinanceFixedAssetsInvDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TFinanceFixedAssetsInvMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 固定资产投资情况表
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/14 11:30
 */
@Repository
public class TFinanceFixedAssetsInvDaoImpl implements TFinanceFixedAssetsInvDao {
    @Autowired
    private TFinanceFixedAssetsInvMapper mapper;

    @Override
    public int insert(TFinanceFixedAssetsInv fixedAssetsChange) {
        return mapper.insert(fixedAssetsChange);
    }

    @Override
    public int insertBatch(List<TFinanceFixedAssetsInv> list) {
        return mapper.insertBatch(list);
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByHeadId(long headId) {
        TFinanceFixedAssetsInvExample example = new TFinanceFixedAssetsInvExample();
        TFinanceFixedAssetsInvExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        return mapper.deleteByExample(example);
    }

    @Override
    public List<TFinanceFixedAssetsInv> queryByProperty(TFinanceFixedAssetsInv fixedAssetsInv) {
        TFinanceFixedAssetsInvExample example = new TFinanceFixedAssetsInvExample();
        TFinanceFixedAssetsInvExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(fixedAssetsInv.getFheadId());
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceFixedAssetsInv> queryByHeadId(Long headId) {
        TFinanceFixedAssetsInvExample example = new TFinanceFixedAssetsInvExample();
        TFinanceFixedAssetsInvExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdEqualTo(headId);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<TFinanceFixedAssetsInv> queryByPropertyAll(List<Long> tfheadids) {
        TFinanceFixedAssetsInvExample example = new TFinanceFixedAssetsInvExample();
        TFinanceFixedAssetsInvExample.Criteria criteria = example.createCriteria();
        criteria.andFheadIdIn(tfheadids);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }
}
