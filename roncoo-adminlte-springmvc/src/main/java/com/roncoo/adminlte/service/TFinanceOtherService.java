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

import com.alibaba.fastjson.JSONObject;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.entity.TFinanceOther;
import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.util.base.Page;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

/**
 * 对标数据Service
 *
 * @author ANDREW
 *
 */
public interface TFinanceOtherService {

	Result<TFinanceOther> query(long id);

	Result<Integer> save(TFinanceOther rcRole);

	Result<Integer> update(TFinanceOther rcRole);

	Result<Integer> delete(long id);

	Result<Page<TFinanceOther>> listForPage(int pageCurrent, int pageSize, String date, String search);

	Result<List<TFinanceOther>> listForId(List<Long> idList);

	int insertBatch(List<TFinanceOther> list);


	/**
	 * 数据导入
	 * @param wb excel对象
	 * @param sheetName sheet页名称
	 * @param companyNumber 公司编码
	 * @param period 期间
	 * @param rcUser 操作用户
	 * @return JSON格式表格数据
	 */
	JSONObject importHandler(Workbook wb, String sheetName, String companyNumber, String period, RcUser rcUser);
}
