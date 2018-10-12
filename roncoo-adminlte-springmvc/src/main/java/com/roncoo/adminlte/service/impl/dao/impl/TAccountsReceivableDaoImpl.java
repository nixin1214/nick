package com.roncoo.adminlte.service.impl.dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.roncoo.adminlte.bean.entity.TAccountsReceivable;
import com.roncoo.adminlte.bean.entity.TAccountsReceivableExample;
import com.roncoo.adminlte.service.impl.dao.TAccountsReceivableDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TAccountsReceivableMapper;
import com.roncoo.adminlte.util.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class TAccountsReceivableDaoImpl implements TAccountsReceivableDao {

    @Autowired
    private TAccountsReceivableMapper receivableMapper;

    @Override
    public long countByExample(TAccountsReceivableExample example) {
        return receivableMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(TAccountsReceivableExample example) {
        return receivableMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(BigDecimal fid) {
        return receivableMapper.deleteByPrimaryKey(fid);
    }

    @Override
    public int insert(TAccountsReceivable record) {
        return receivableMapper.insert(record);
    }

    @Override
    public int insertSelective(TAccountsReceivable record) {
        return receivableMapper.insertSelective(record);
    }

    @Override
    public List<TAccountsReceivable> selectByExample(TAccountsReceivableExample example) {
        return receivableMapper.selectByExample(example);
    }

    @Override
    public TAccountsReceivable selectByPrimaryKey(BigDecimal fid) {
        return receivableMapper.selectByPrimaryKey(fid);
    }

    @Override
    public int updateByExampleSelective(TAccountsReceivable record, TAccountsReceivableExample example) {
        return receivableMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(TAccountsReceivable record, TAccountsReceivableExample example) {
        return receivableMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(TAccountsReceivable record) {
        return receivableMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TAccountsReceivable record) {
        return receivableMapper.updateByPrimaryKey(record);
    }

    @Override
    public int insertBatch(List<TAccountsReceivable> list) {
        return receivableMapper.insertBatch(list);
    }

    @Override
    public List<TAccountsReceivable> selectByHeadId(BigDecimal fheadid) {
        return receivableMapper.selectByHeadId(fheadid);
    }

    @Override
    public Page<TAccountsReceivable> listForPage(int pageCurrent, int pageSize,  List<BigDecimal> headId) {
        TAccountsReceivableExample example = new TAccountsReceivableExample();
        example.setOrderByClause("fid desc");
        TAccountsReceivableExample.Criteria criteria = example.createCriteria();
        if (headId.size()>0){
            criteria.andFheadIdIn(headId);
        }
        PageHelper.startPage(pageCurrent, pageSize);
        List<TAccountsReceivable> list = receivableMapper.selectByExample(example);
        PageInfo<TAccountsReceivable> pageInfo = new PageInfo<>(list);
        return new Page<>((int)pageInfo.getTotal(), pageInfo.getPages(), pageCurrent, pageSize, list);
    }
}
