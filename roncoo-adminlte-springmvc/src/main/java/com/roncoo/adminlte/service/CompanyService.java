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
package com.roncoo.adminlte.service;

import com.roncoo.adminlte.bean.entity.RcCompany;
import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.util.base.Page;

import java.util.List;

/**
 * 角色Service
 * 
 * @author LYQ
 *
 */
public interface CompanyService {

	Result<RcCompany> query(long id);
	
	Result<RcCompany> queryByCompanyName(String name);

	Result<RcCompany> queryByCompanyNumber(String number);

	Result<Integer> save(RcCompany rcRole);

	Result<Integer> update(RcCompany rcRole);

	Result<Integer> delete(long id);

	Result<Page<RcCompany>> listForPage(int pageCurrent, int pageSize, String date, String search);
	
	Result<List<RcCompany>> listForId(List<Long> idList);

	Result<List<RcCompany>> list();

	/**
	 * 查询用户可访问的组织列表
	 * @param parentCode
	 * @param showVirtual 是否显示虚拟组织
	 * @return 结构集
	 */
	Result<List<RcCompany>> listForParentCode(String parentCode, boolean showVirtual);
}
