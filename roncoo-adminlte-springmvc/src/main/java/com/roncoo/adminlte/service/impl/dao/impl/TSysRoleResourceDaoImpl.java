package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TSysRoleResource;
import com.roncoo.adminlte.bean.entity.TSysRoleResourceExample;
import com.roncoo.adminlte.service.impl.dao.TSysRoleResourceDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TSysRoleResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TSysRoleResourceDaoImpl implements TSysRoleResourceDao {
    @Autowired
    private TSysRoleResourceMapper roleResourceMapper;

    @Override
    public TSysRoleResource selectById(long id) {
        return roleResourceMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TSysRoleResource> selectByRoleId(long id) {
        TSysRoleResourceExample example = new TSysRoleResourceExample();
        TSysRoleResourceExample.Criteria criteria = example.createCriteria();
        criteria.andFroleIdEqualTo(id);
        return roleResourceMapper.selectByExample(example);
    }

    @Override
    public int insert(TSysRoleResource rcRolePermissions) {
        return roleResourceMapper.insert(rcRolePermissions);
    }

    @Override
    public int update(TSysRoleResource rcRolePermissions) {
        return roleResourceMapper.updateByPrimaryKey(rcRolePermissions);
    }

    @Override
    public int delectByRolePermissions(TSysRoleResource rcRolePermissions) {
        TSysRoleResourceExample example = new TSysRoleResourceExample();
        TSysRoleResourceExample.Criteria criteria = example.createCriteria();
        criteria.andFroleIdEqualTo(rcRolePermissions.getFroleId());
        criteria.andFresourceIdEqualTo(rcRolePermissions.getFresourceId());
        return roleResourceMapper.deleteByExample(example);
    }

    @Override
    public int deleteByRoleId(long roleId) {
        TSysRoleResourceExample example = new TSysRoleResourceExample();
        TSysRoleResourceExample.Criteria criteria = example.createCriteria();
        criteria.andFroleIdEqualTo(roleId);
        return roleResourceMapper.deleteByExample(example);
    }

    @Override
    public int countByRoleId(long roleId) {
        TSysRoleResourceExample example = new TSysRoleResourceExample();
        TSysRoleResourceExample.Criteria criteria = example.createCriteria();
        criteria.andFroleIdEqualTo(roleId);
        return roleResourceMapper.countByExample(example);
    }

    @Override
    public List<TSysRoleResource> listForRoleId(List<Long> idList) {
        TSysRoleResourceExample example = new TSysRoleResourceExample();
        TSysRoleResourceExample.Criteria criteria = example.createCriteria();
        criteria.andFroleIdIn(idList);
        return roleResourceMapper.selectByExample(example);
    }
}
