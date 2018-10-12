package com.roncoo.adminlte.service.impl.dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.roncoo.adminlte.bean.entity.TFinanceOther;
import com.roncoo.adminlte.bean.entity.TFinanceOtherExample;
import com.roncoo.adminlte.service.impl.dao.TFinanceOtherDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TFinanceOtherMapper;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 对标数据
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/29 15:56
 */
@Repository
public class TFinanceOtherDaoImpl implements TFinanceOtherDao {

    @Autowired
    private TFinanceOtherMapper mapper;

    @Override
    public TFinanceOther selectById(long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TFinanceOther> selectByExample(TFinanceOtherExample example) {return mapper.selectByExample(example); }

    @Override
    public int insert(TFinanceOther role) {
        return mapper.insert(role);
    }

    @Override
    public int update(TFinanceOther role) {
        return mapper.updateByPrimaryKey(role);
    }

    @Override
    public int deleteById(long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public Page<TFinanceOther> listForPage(int pageCurrent, int pageSize, String date, String search) {
        TFinanceOtherExample example = new TFinanceOtherExample();
        TFinanceOtherExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("frow_index asc");
        if (StringUtils.hasText(search)) {
            criteria.andFremarkLike(SqlUtil.like(search));
        }
        PageHelper.startPage(pageCurrent, pageSize);
        List<TFinanceOther> list = mapper.selectByExample(example);
        PageInfo<TFinanceOther> pageInfo = new PageInfo<>(list);
        return new Page<>((int)pageInfo.getTotal(), pageInfo.getPages(), pageCurrent, pageSize, list);
    }

    @Override
    public List<TFinanceOther> listForId(List<Long> idList) {
        TFinanceOtherExample example = new TFinanceOtherExample();
        TFinanceOtherExample.Criteria criteria = example.createCriteria();
        criteria.andFidIn(idList);
        example.setOrderByClause("frow_index asc");
        return mapper.selectByExample(example);
    }

    @Override
    public int insertBatch(List<TFinanceOther> list) {
        return mapper.insertBatch(list);
    }

    public int deleteByCompany(String orgCode) {
        TFinanceOtherExample example = new TFinanceOtherExample();
        TFinanceOtherExample.Criteria criteria = example.createCriteria();
        criteria.andFcompanyCodeEqualTo(orgCode);
        return mapper.deleteByExample(example);
    }
}
