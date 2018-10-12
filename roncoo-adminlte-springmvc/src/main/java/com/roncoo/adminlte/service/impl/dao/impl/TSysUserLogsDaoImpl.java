package com.roncoo.adminlte.service.impl.dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.roncoo.adminlte.bean.entity.TSysUserLogs;
import com.roncoo.adminlte.bean.entity.TSysUserLogsExample;
import com.roncoo.adminlte.service.impl.dao.TSysUserLogsDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TSysUserLogsMapper;
import com.roncoo.adminlte.util.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 用户操作日志
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/16 14:20
 */
@Repository
public class TSysUserLogsDaoImpl implements TSysUserLogsDao {
    @Autowired
    private TSysUserLogsMapper mapper;

    @Override
    public TSysUserLogs selectById(long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(TSysUserLogs role) {
        return mapper.insert(role);
    }

    @Override
    public int update(TSysUserLogs role) {
        return mapper.updateByPrimaryKey(role);
    }

    @Override
    public int deleteById(long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public Page<TSysUserLogs> listForPage(int pageCurrent, int pageSize, TSysUserLogsExample example) {
        example.setOrderByClause("fid desc");

//        int totalCount = mapper.countByExample(example);
//        pageSize = SqlUtil.checkPageSize(pageSize);
//        pageCurrent = SqlUtil.checkPageCurrent(totalCount, pageSize, pageCurrent);
//        int totalPage = SqlUtil.countTotalPage(totalCount, pageSize);
//        example.setPageSize(pageSize);
//        example.setLimitStart(SqlUtil.countOffset(pageCurrent, pageSize));
//        List<TSysUserLogs> list = mapper.selectByExample(example);

        PageHelper.startPage(pageCurrent, pageSize);
        List<TSysUserLogs> list = mapper.selectByExample(example);
        PageInfo<TSysUserLogs> pageInfo = new PageInfo<>(list);
        return new Page<>((int)pageInfo.getTotal(), pageInfo.getPages(), pageCurrent, pageSize, list);
    }

    @Override
    public List<TSysUserLogs> listForId(List<Long> idList) {
        TSysUserLogsExample example = new TSysUserLogsExample();
        TSysUserLogsExample.Criteria criteria = example.createCriteria();
        criteria.andFidIn(idList);
        return mapper.selectByExample(example);
    }

    @Override
    public List<TSysUserLogs> listForExample(TSysUserLogsExample example) {
        return mapper.selectByExample(example);
    }
}
