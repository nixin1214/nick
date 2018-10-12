package com.roncoo.adminlte.controller.admin;

import java.util.List;

import com.roncoo.adminlte.bean.entity.RcCompany;
import com.roncoo.adminlte.service.TSysUserLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.roncoo.adminlte.bean.entity.RcRole;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.bean.vo.RcUserVo;
import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.biz.UserBiz;
import com.roncoo.adminlte.util.base.BaseController;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.PageBean;
import com.roncoo.adminlte.util.base.ParamUtil;

@Controller
@RequestMapping(value = "/admin/security/", method = RequestMethod.POST)
public class SecurityController extends BaseController {

	@Autowired
	private UserBiz biz;
	@Autowired
	private TSysUserLogsService userLogsService;

	@RequestMapping(value = LIST, method = RequestMethod.GET)
	public void list() {

	}

	@RequestMapping(value = ADD, method = RequestMethod.GET)
	public void add(ModelMap modelMap) {
		Result<List<RcRole>> resultRole = biz.queryRoleList();
		if (resultRole.isStatus()) {
			modelMap.put("roles", resultRole.getResultData());
		}

		Result<List<RcCompany>> resultCompany = biz.queryCompanyList();
		if (resultCompany.isStatus()) {
			modelMap.put("companys", resultCompany.getResultData());
		}
		//记录操作日志
		userLogsService.addLog("添加", getRequestPath(), "PC端", getClientIP(), "0", "", "进入添加用户界面");
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
	public PageBean<RcUserVo> queryForPage(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "length", defaultValue = "10") int pageSize, @RequestParam(value = "date", required = false) String date, @RequestParam(value = "search", required = false) String search) {
		Result<Page<RcUserVo>> result = biz.listForPage((start / pageSize) + 1, pageSize, date, search);
		if (result.isStatus()) {
			return new PageBean<RcUserVo>(result.getResultData());
		}
		//记录操作日志
		userLogsService.addLog("浏览", getRequestPath(), "PC端", getClientIP(), "0", "", "浏览用户列表");
		return new PageBean<RcUserVo>();
	}

	@RequestMapping(value = VIEW, method = RequestMethod.GET)
	public void view(ModelMap modelMap, long id) {
		Result<RcUserVo> result = biz.query(id);
		if (result.isStatus()) {
			modelMap.put("bean", result.getResultData());
		}
		//记录操作日志
		userLogsService.addLog("浏览", getRequestPath(), "PC端", getClientIP(), "0", "", "浏览用户详情");
	}

	@RequestMapping(value = EDIT, method = RequestMethod.GET)
	public void edit(ModelMap modelMap, long id) {
		Result<RcUserVo> result = biz.query(id);
		if (result.isStatus()) {
			modelMap.put("bean", result.getResultData());
		}
		Result<List<RcRole>> resultRole = biz.queryRoleList();
		if (resultRole.isStatus()) {
			modelMap.put("roles", resultRole.getResultData());
		}
		Result<List<RcCompany>> resultCompany = biz.queryCompanyList();
		if (resultCompany.isStatus()) {
			modelMap.put("companys", resultCompany.getResultData());
		}
		//记录操作日志
		userLogsService.addLog("编辑", getRequestPath(), "PC端", getClientIP(), "0", "", "进入用户信息编辑界面");
	}

	@RequestMapping(value = SAVE,method = RequestMethod.POST)
	@ResponseBody
	public String save(RcUser rcUser, @RequestParam(value = "role", required = false) String role) {
		List<Long> roles = ParamUtil.toLongList(role, ",");
		Result<Integer> result = biz.save(rcUser, roles);
		if (result.isStatus()) {
			//记录操作日志
			userLogsService.addLog("添加用户", getRequestPath(), "PC端", getClientIP(), "0", "", "添加用户成功");
			//return redirect("/admin/security/list");
			return "添加用户成功";
		} else {
			//记录操作日志
			userLogsService.addLog("添加用户", getRequestPath(), "PC端", getClientIP(), "edit_user:fail", "用户添加失败", rcUser.toString());
			return "用户已存在，请重新输入";
		}
	}
	
	@RequestMapping(value = DELETE, method = RequestMethod.GET)
	public String delete(long id) {
		Result<Integer> result = biz.delete(id);
		if (result.isStatus()) {
			//记录操作日志
			userLogsService.addLog("删除用户", getRequestPath(), "PC端", getClientIP(), "0", "", "删除用户信息");
			return redirect("/admin/security/list");
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = UPDATE)
	public String update(RcUser rcUser, @RequestParam(value = "role", required = false) String role) {
		List<Long> roles = ParamUtil.toLongList(role, ",");
		Result<Integer> result = biz.update(rcUser, roles);
		if (result.isStatus()) {
			//记录操作日志
			userLogsService.addLog("修改用户", getRequestPath(), "PC端", getClientIP(), "0", "", "修改用户信息>>" + rcUser.toString());
			return "success";
		}
		return null;
	}

}
