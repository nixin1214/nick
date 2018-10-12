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
package com.roncoo.adminlte.service.impl.dao;

import com.roncoo.adminlte.bean.entity.TFinanceOther;
import com.roncoo.adminlte.bean.entity.TFinanceOtherExample;
import com.roncoo.adminlte.util.base.Page;

import java.util.List;

/**
 * 组织 Dao
 * 
 * @author LYQ
 *
 */
public interface TFinanceOtherDao {

	TFinanceOther selectById(long id);

	List<TFinanceOther> selectByExample(TFinanceOtherExample example);

	int insert(TFinanceOther role);

	int update(TFinanceOther role);

	int deleteById(long id);

	Page<TFinanceOther> listForPage(int pageCurrent, int pageSize, String date, String search);
	
	List<TFinanceOther> listForId(List<Long> idList);

	int insertBatch(List<TFinanceOther> list);

	/**
	 * 根据组织编码删除对标数据
	 * @param orgCode 组织编辑
	 * @return 删除的条数
	 */
	int deleteByCompany(String orgCode);
}
