package com.roncoo.adminlte.service.impl.dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.roncoo.adminlte.bean.entity.TSysResource;
import com.roncoo.adminlte.bean.entity.TSysResourceExample;
import com.roncoo.adminlte.service.impl.dao.TSysResourceDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TSysResourceMapper;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public class TSysResourceDaoImpl implements TSysResourceDao {

    @Autowired
    private TSysResourceMapper mapper;
    @Override
    public TSysResource selectById(long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(TSysResource resource) {
        return mapper.insert(resource);
    }

    @Override
    public int update(TSysResource permission) {
        return mapper.updateByPrimaryKey(permission);
    }

    @Override
    public int deleteById(long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public Page<TSysResource> listForPage(int pageCurrent, int pageSize, String date, String search) {
        TSysResourceExample example = new TSysResourceExample();
        example.setOrderByClause("id desc");
        TSysResourceExample.Criteria criteria = example.createCriteria();
        if (StringUtils.hasText(search)) {
            criteria.andFresNameLike(SqlUtil.like(search));
        }
        PageHelper.startPage(pageCurrent, pageSize);
        List<TSysResource> list = mapper.selectByExample(example);
        PageInfo<TSysResource> pageInfo = new PageInfo<>(list);
        return new Page<>((int)pageInfo.getTotal(), pageInfo.getPages(), pageCurrent, pageSize, list);
    }

    @Override
    public List<TSysResource> listForId(List<Long> idList) {
        TSysResourceExample example = new TSysResourceExample();
        TSysResourceExample.Criteria criteria = example.createCriteria();
        criteria.andFidIn(idList);
        return mapper.selectByExample(example);
    }

    @Override
    public List<TSysResource> list() {
        TSysResourceExample example = new TSysResourceExample();
        example.setOrderByClause("fpos");
        return mapper.selectByExample(example);
    }
}
