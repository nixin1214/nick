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
package com.roncoo.adminlte.controller.admin;

import com.roncoo.adminlte.service.TSysUserLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.roncoo.adminlte.bean.entity.RcDataDictionary;
import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.biz.DataDictionaryBiz;
import com.roncoo.adminlte.util.base.BaseController;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.PageBean;

/**
 * 数据字典
 * 
 * @author LYQ
 */
@Controller
@RequestMapping(value = "/admin/dataDictionary/", method = RequestMethod.POST)
public class DataDictionaryController extends BaseController {

	@Autowired
	private DataDictionaryBiz biz;
	@Autowired
	private TSysUserLogsService userLogsService;

	/**
	 * 查看数据字典列表
	 */
	@RequestMapping(value = LIST, method = RequestMethod.GET)
	public void list() {
	}

	/**
	 * 添加
	 */
	@RequestMapping(value = ADD, method = RequestMethod.GET)
	public void add() {
	}

	/**
	 * 分页查询
	 * 
	 * @param start
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = PAGE)
	public PageBean<RcDataDictionary> queryForPage(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "length", defaultValue = "10") int pageSize, @RequestParam(value = "date", required = false) String date, @RequestParam(value = "search", required = false) String search) {
		Result<Page<RcDataDictionary>> result = biz.listForPage((start / pageSize) + 1, pageSize, search, date);
		if (result.isStatus()) {
			//记录操作日志
			userLogsService.addLog("浏览字典", getRequestPath(), "PC端", getClientIP(), "success", "", "");
			return new PageBean<RcDataDictionary>(result.getResultData());
		}
		return new PageBean<RcDataDictionary>();
	}

	/**
	 * 
	 * 往数据字典中插入记录
	 * 
	 * @param rcDataDictionary
	 * @return String
	 */
	@RequestMapping(value = SAVE, method = RequestMethod.POST)
	@ResponseBody
	public String save(@ModelAttribute RcDataDictionary rcDataDictionary, ModelMap modelMap) {
		Result<RcDataDictionary> result = biz.save(rcDataDictionary);
		if (result.isStatus()) {
			//记录操作日志
			userLogsService.addLog("添加字典", getRequestPath(), "PC端", getClientIP(), "success", "", rcDataDictionary.toString());
			//return redirect("/admin/dataDictionary/list");
			return "添加成功";
		}else{
			return "添加失败";
		}
		//return "admin/dataDictionary/list";
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @param fieldCode
	 * @return
	 */
	@RequestMapping(value = DELETE, method = RequestMethod.GET)
	public String delete(@RequestParam(value = "id", defaultValue = "-1") Long id, @RequestParam(value = "fieldCode", defaultValue = "") String fieldCode) {
		Result<String> result = biz.delete(id, fieldCode);
		if (result.isStatus()) {
			//记录操作日志
			userLogsService.addLog("删除字典", getRequestPath(), "PC端", getClientIP(), "success", "", "删除字典成功");
			return redirect("/admin/dataDictionary/list");
		}
		//记录操作日志
		userLogsService.addLog("删除字典", getRequestPath(), "PC端", getClientIP(), "delete_dict:fail", "删除字典失败", "");
		return redirect("/admin/dataDictionary/list");
	}

	/**
	 * 查看详细信息
	 * 
	 * @param id
	 * @param modelMap
	 */
	@RequestMapping(value = VIEW, method = RequestMethod.GET)
	public void view(@RequestParam(value = "id", defaultValue = "-1") Long id, ModelMap modelMap) {
		Result<RcDataDictionary> result = biz.query(id);
		//记录操作日志
		userLogsService.addLog("浏览字典", getRequestPath(), "PC端", getClientIP(), "success", "", "浏览字典详情");
		if (result.isStatus()) {
			modelMap.put("dictionary", result.getResultData());
		}
	}

	/**
	 * 编辑
	 * 
	 * @param id
	 * @param modelMap
	 */
	@RequestMapping(value = EDIT, method = RequestMethod.GET)
	public void edit(Long id, ModelMap modelMap) {
		Result<RcDataDictionary> result = biz.query(id);
		if (result.isStatus()) {
			modelMap.put("dictionary", result.getResultData());
		}
	}

	/**
	 * 更新
	 * 
	 * @param dictionary
	 * @param oldFieldCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = UPDATE)
	public String update(@ModelAttribute RcDataDictionary dictionary, @RequestParam(value = "oldFieldCode") String oldFieldCode) {
		Result<RcDataDictionary> result = biz.update(dictionary, oldFieldCode);
		if (result.isStatus()) {
			//记录操作日志
			userLogsService.addLog("编辑字典", getRequestPath(), "PC端", getClientIP(), "success", "", dictionary.toString());
			// 更新之后，提示都没有
			return redirect("/admin/dataDictionary/list");
		}
		//记录操作日志
		userLogsService.addLog("编辑字典", getRequestPath(), "PC端", getClientIP(), "edit_dict:fail", "编辑字典失败", dictionary.toString());
		return "admin/dataDictionary/list";

	}
}
