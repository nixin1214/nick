package com.roncoo.adminlte.service.impl.dao.impl;

import com.roncoo.adminlte.bean.entity.TSysOrg;
import com.roncoo.adminlte.bean.entity.TSysOrgExample;
import com.roncoo.adminlte.service.impl.dao.TSysOrgDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.TSysOrgMapper;
import com.roncoo.adminlte.util.base.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TSysOrgDaoImpl implements TSysOrgDao {
    private TSysOrgMapper orgMapper;

    @Override
    public TSysOrg selectById(long id) {
        return orgMapper.selectByPrimaryKey(id);
    }

    @Override
    public TSysOrg selectByCode(String number) {
        TSysOrgExample example = new TSysOrgExample();
        TSysOrgExample.Criteria criteria = example.createCriteria();
        criteria.andFcodeEqualTo(number);
        List<TSysOrg> list = this.orgMapper.selectByExample(example);
        return list != null ? list.get(0) : null;
    }

    @Override
    public int insert(TSysOrg org) {
        return this.orgMapper.insert(org);
    }

    @Override
    public int update(TSysOrg role) {
        return orgMapper.updateByPrimaryKey(role);
    }

    @Override
    public int deleteById(long id) {
        return orgMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Page<TSysOrg> listForPage(int pageCurrent, int pageSize, String date, String search) {
        return null;
    }

    @Override
    public List<TSysOrg> listForId(List<Long> idList) {
        TSysOrgExample example = new TSysOrgExample();
        TSysOrgExample.Criteria criteria = example.createCriteria();
        criteria.andFidIn(idList);
        return orgMapper.selectByExample(example);
    }

    @Override
    public List<TSysOrg> list() {
        TSysOrgExample example = new TSysOrgExample();
        return orgMapper.selectByExample(example);
    }
}
