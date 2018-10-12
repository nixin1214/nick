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
package com.roncoo.adminlte.service.impl;

import com.roncoo.adminlte.bean.entity.RcCompany;
import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.service.impl.dao.CompanyDao;
import com.roncoo.adminlte.service.CompanyService;
import com.roncoo.adminlte.util.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDao dao;

	@Override
	public Result<RcCompany> query(long id) {
		Result<RcCompany> result = new Result<RcCompany>();
		if (id < 0) {
			result.setErrMsg("此id无效");
			return result;
		}
		RcCompany role = dao.selectById(id);
		if (role != null) {
			result.setErrCode(0);
			result.setStatus(true);
			result.setResultData(role);
		}
		return result;
	}

	@Override
	public Result<Integer> save(RcCompany rcRole) {
		Result<Integer> result = new Result<Integer>();
		if (!StringUtils.hasText(rcRole.getFnumber())) {
			result.setErrMsg("分公司编码不能为空");
			return result;
		}

		if (!StringUtils.hasText(rcRole.getFname())) {
			result.setErrMsg("分公司名称不能为空");
			return result;
		}

		if (!StringUtils.hasText(rcRole.getFtype())) {
			result.setErrMsg("分公司类型不能为空");
			return result;
		}

		if (dao.selectByCompanyName(rcRole.getFname()) != null) {
			result.setErrMsg("分公司已经存在");
			return result;
		}

		int resultNum = dao.insert(rcRole);
		if (resultNum > 0) {
			result.setErrCode(0);
			result.setStatus(true);
		}
		return result;
	}

	@Override
	public Result<Integer> update(RcCompany rcRole) {
		Result<Integer> result = new Result<Integer>();
		if (!StringUtils.hasText(rcRole.getFnumber())) {
			result.setErrMsg("分公司编码不能为空");
			return result;
		}

		if (!StringUtils.hasText(rcRole.getFname())) {
			result.setErrMsg("分公司名称不能为空");
			return result;
		}

		if (!StringUtils.hasText(rcRole.getFtype())) {
			result.setErrMsg("分公司类型不能为空");
			return result;
		}

		int resultNum = dao.update(rcRole);
		if (resultNum > 0) {
			result.setErrCode(0);
			result.setStatus(true);
		}
		return result;
	}

	@Override
	public Result<Integer> delete(long id) {
		Result<Integer> result = new Result<Integer>();
		if (id < 0) {
			result.setErrMsg("此id无效");
			return result;
		}
		int resultNum = dao.deleteById(id);
		if (resultNum > 0) {
			result.setErrCode(0);
			result.setStatus(true);
		}
		return result;
	}

	@Override
	public Result<Page<RcCompany>> listForPage(int pageCurrent, int pageSize, String date, String search) {
		Result<Page<RcCompany>> result = new Result<Page<RcCompany>>();
		if (pageCurrent < 1) {
			result.setErrMsg("pageCurrent有误");
			return result;
		}
		if (pageSize < 1) {
			result.setErrMsg("pageSize有误");
			return result;
		}
		Page<RcCompany> resultData = dao.listForPage(pageCurrent, pageSize, date, search);
		result.setResultData(resultData);
		result.setErrCode(0);
		result.setStatus(true);
		result.setErrMsg("查询成功");
		return result;
	}

	@Override
	public Result<List<RcCompany>> list() {
		Result<List<RcCompany>> result = new Result<List<RcCompany>>();
		List<RcCompany> resultData = dao.list();
		if (resultData.size() > 0) {
			result.setResultData(resultData);
			result.setErrCode(0);
			result.setStatus(true);
			result.setErrMsg("查询成功");
			return result;
		}
		result.setErrMsg("查询失败");
		return result;
	}

	@Override
	public Result<RcCompany> queryByCompanyName(String roleName) {
		Result<RcCompany> result = new Result<RcCompany>();
		if (!StringUtils.hasText(roleName)) {
			result.setErrMsg("分公司名不能为空");
			return result;
		}
		RcCompany resultData = dao.selectByCompanyName(roleName);
		if (resultData != null) {
			result.setResultData(resultData);
			result.setErrCode(0);
			result.setStatus(true);
			result.setErrMsg("查询成功");
			return result;
		}
		result.setErrMsg("查询失败");
		return result;
	}

	@Override
	public Result<RcCompany> queryByCompanyNumber(String number) {
		Result<RcCompany> result = new Result<RcCompany>();
		if (!StringUtils.hasText(number)) {
			result.setErrMsg("编码不能为空");
			return result;
		}
		RcCompany resultData = dao.selectByCompanyNumber(number);
		if (resultData != null) {
			result.setResultData(resultData);
			result.setErrCode(0);
			result.setStatus(true);
			result.setErrMsg("查询成功");
			return result;
		}
		result.setErrMsg("查询失败");
		return result;
	}

	@Override
	public Result<List<RcCompany>> listForId(List<Long> idList) {
		Result<List<RcCompany>> result = new Result<List<RcCompany>>();
		if (idList.size() < 1) {
			result.setErrMsg("没有id需要查询");
			return result;
		}
		List<RcCompany> resultData = dao.listForId(idList);
		result.setErrCode(0);
		result.setStatus(true);
		result.setResultData(resultData);
		result.setErrMsg("查询成功");
		return result;
	}

	/**
	 * 查询用户可访问的组织列表
	 * @param parentCode
	 * @param showVirtual 是否显示虚拟组织
	 * @return 结构集
	 */
	public Result<List<RcCompany>> listForParentCode(String parentCode, boolean showVirtual) {
		Result<List<RcCompany>> result = new Result<>();
		if (StringUtils.isEmpty(parentCode)) {
			result.setErrMsg("上级CODE为空");
			return result;
		}
		List<RcCompany> resultData = dao.selectByParentCode(parentCode, showVirtual);
		result.setErrCode(0);
		result.setStatus(true);
		result.setResultData(resultData);
		return result;
	}
}
