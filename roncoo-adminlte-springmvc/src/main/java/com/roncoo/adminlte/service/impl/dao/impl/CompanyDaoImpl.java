/*
 * Copyright 2015-2016 RonCoo(http://www.roncoo.com) Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.roncoo.adminlte.service.impl.dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.roncoo.adminlte.bean.entity.RcCompany;
import com.roncoo.adminlte.bean.entity.RcCompanyExample;
import com.roncoo.adminlte.bean.entity.RcCompanyExample.Criteria;
import com.roncoo.adminlte.service.impl.dao.CompanyDao;
import com.roncoo.adminlte.service.impl.dao.impl.mybatis.RcCompanyMapper;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public class CompanyDaoImpl implements CompanyDao {

	@Autowired
	private RcCompanyMapper mapper;

	@Override
	public RcCompany selectById(long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(RcCompany rcRole) {
		return mapper.insertSelective(rcRole);
	}

	@Override
	public int update(RcCompany rcRole) {
		return mapper.updateByPrimaryKeySelective(rcRole);
	}

	@Override
	public int deleteById(long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public Page<RcCompany> listForPage(int pageCurrent, int pageSize, String date, String search) {
		RcCompanyExample example = new RcCompanyExample();
		example.setOrderByClause("fpos asc");
		Criteria criteria = example.createCriteria();
		if (StringUtils.hasText(search)) {
			criteria.andFnameLike(SqlUtil.like(search));
		}
		PageHelper.startPage(pageCurrent, pageSize);
		List<RcCompany> list = mapper.selectByExample(example);
		PageInfo<RcCompany> pageInfo = new PageInfo<>(list);
		return new Page<>((int)pageInfo.getTotal(), pageInfo.getPages(), pageCurrent, pageSize, list);
	}

	@Override
	public List<RcCompany> list() {
		RcCompanyExample example = new RcCompanyExample();
		example.setOrderByClause("fpos asc");
		return mapper.selectByExample(example);
	}

	@Override
	public RcCompany selectByCompanyName(String roleName) {
		RcCompanyExample example = new RcCompanyExample();
		Criteria criteria = example.createCriteria();
		criteria.andFnameEqualTo(roleName);
		List<RcCompany> resultData = mapper.selectByExample(example);
		if (resultData.size() < 1) {
			return null;
		}
		return resultData.get(0);
	}

	@Override
	public RcCompany selectByCompanyNumber(String number) {
		RcCompanyExample example = new RcCompanyExample();
		Criteria criteria = example.createCriteria();
		criteria.andFnumberEqualTo(number);
		List<RcCompany> resultData = mapper.selectByExample(example);
		if (resultData.size() < 1) {
			return null;
		}
		return resultData.get(0);
	}

	/**
	 * 权限上级CODE查询组织
	 * @param parentCode 上级组织ID
	 * @param showVirtual 是否显示虚拟组织
	 * @return 组织列表
	 */
	public List<RcCompany> selectByParentCode(String parentCode, boolean showVirtual) {
		RcCompanyExample example = new RcCompanyExample();
		Criteria criteria = example.createCriteria();
		criteria.andFlongCodeLike(SqlUtil.like(parentCode));
		criteria.andFstatusEqualTo((short)1);
		if (!showVirtual) {
			criteria.andFtypeNotEqualTo("virtual");//排除虚拟组织
		}
		List<RcCompany> resultData = mapper.selectByExample(example);
		return resultData;
	}

	@Override
	public List<RcCompany> listForId(List<Long> idList) {
		RcCompanyExample example = new RcCompanyExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIn(idList);
		return mapper.selectByExample(example);
	}

}
