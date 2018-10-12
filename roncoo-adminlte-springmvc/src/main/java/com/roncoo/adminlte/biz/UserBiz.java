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
package com.roncoo.adminlte.biz;

import java.util.ArrayList;
import java.util.List;

import com.roncoo.adminlte.bean.entity.*;
import com.roncoo.adminlte.service.*;
import com.roncoo.adminlte.util.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.roncoo.adminlte.bean.vo.RcUserVo;
import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.util.base.Page;

/**
 * 用户逻辑业务
 * 
 * @author LYQ
 *
 */
@Component
public class UserBiz {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRoleService userRoleService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private RolePermissionsService rolePermissionsService;

	@Autowired
	private PermissionService permissionService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private SysRoleResourceService roleResourceService;

	@Autowired
	private SysResourceService resourceService;

	/**
	 * 用户登录
	 * 
	 * @param userno
	 * @param password
	 * @return
	 */
	public Result<RcUser> login(String userno, String password) {
		return userService.login(userno, password);
	}
	

	/**
	 * 分页查询用户信息
	 * 
	 * @param pageCurrent
	 * @param pageSize
	 * @param date
	 * @param search
	 * @return
	 */
	public Result<Page<RcUserVo>> listForPage(int pageCurrent, int pageSize, String date, String search) {
		Result<Page<RcUserVo>> resultVo = new Result<Page<RcUserVo>>();
		Result<Page<RcUser>> result = userService.listForPage(pageCurrent, pageSize, date, search);
		if (result.isStatus()) {
			ArrayList<RcUserVo> resultData = new ArrayList<RcUserVo>();
			RcUserVo rcUserVo;
			for (RcUser rcUser : result.getResultData().getList()) {
				rcUserVo = new RcUserVo(rcUser);
				Result<List<RcRole>> resultRole = queryRoles(rcUser.getId());
				if (resultRole.isStatus()) {
					rcUserVo.setRoleList(resultRole.getResultData());
					resultData.add(rcUserVo);
				}
			}
			Page<RcUserVo> page = new Page<RcUserVo>(result.getResultData().getTotalCount(), result.getResultData().getTotalPage(), result.getResultData().getPageCurrent(), result.getResultData().getPageSize(), resultData);
			resultVo.setErrCode(0);
			resultVo.setStatus(true);
			resultVo.setErrMsg("查询成功");
			resultVo.setResultData(page);
			return resultVo;
		}
		return resultVo;
	}

	/**
	 * 根据id查询用户的信息
	 * 
	 * @param id
	 * @return
	 */
	public Result<RcUserVo> query(long id) {
		Result<RcUserVo> resultVo = new Result<RcUserVo>();
		Result<RcUser> result = userService.query(id);
		if (result.isStatus()) {
			RcUserVo rcUserVo = new RcUserVo(result.getResultData());
			Result<List<RcRole>> resultR = queryRoles(id);
			if (result.isStatus()) {
				rcUserVo.setRoleList(resultR.getResultData());
				resultVo.setErrCode(0);
				resultVo.setStatus(true);
				resultVo.setErrMsg("查询成功");
				resultVo.setResultData(rcUserVo);
				return resultVo;
			}
			resultVo.setErrMsg("查询失败");
		}
		return resultVo;
	}

	/**
	 * 根据账号查询用户信息
	 * 
	 * @param userno
	 * @return
	 */
	public Result<RcUser> queryByUserNo(String userno) {
		return userService.queryByUserNo(userno);
	}

	/**
	 * 获取角色列表
	 * 
	 * @return
	 */
	public Result<List<RcRole>> queryRoleList() {
		return roleService.list();
	}

	/**
	 * 获取用户角色
	 * 
	 * @param userId
	 * @return
	 */
	public Result<List<RcRole>> queryRoles(long userId) {
		Result<List<RcUserRole>> resultUR = userRoleService.queryByUserId(userId);
		ArrayList<Long> params = new ArrayList<Long>();
		for (RcUserRole rcUserRole : resultUR.getResultData()) {
			params.add(rcUserRole.getRolesId());
		}
		Result<List<RcRole>> result = roleService.listForId(params);
		return result;
	}

	/**
	 * 获取角色权限
	 * 
	 * @param roles
	 * @return
	 */
	public Result<List<RcPermission>> queryPermissions(List<RcRole> roles) {
		ArrayList<Long> roleParams = new ArrayList<Long>();
		for (RcRole rcRole : roles) {
			roleParams.add(rcRole.getId());
		}
		Result<List<RcRolePermissions>> resultRP = rolePermissionsService.listForRoleId(roleParams);
		if (resultRP.isStatus()) {
			ArrayList<Long> params = new ArrayList<Long>();
			for (RcRolePermissions rcRolePermissions : resultRP.getResultData()) {
				params.add(rcRolePermissions.getPermissionId());
			}
			return permissionService.listForId(params);
		}
		return null;
	}

	/**
	 * 获取用户权限资源
	 * @param userno
	 * @return
	 */
	public Result<List<TSysResource>> getMyResources(Long userno) {
		Result<List<RcRole>> roleResult = queryRoles(userno);
		if (roleResult.isStatus()) {
			return queryResources(roleResult.getResultData());
		}
		return null;
	}

	/**
	 * 查询角色拥有的权限资源
	 *
	 * Create by andrew 2017-10-27 16:34
	 * @param roles 角色列表
	 * @return 资源列表
	 */
	public Result<List<TSysResource>> queryResources(List<RcRole> roles) {
		ArrayList<Long> roleParams = new ArrayList<>();
		for (RcRole role : roles) {
			roleParams.add(role.getId());
		}
		Result<List<TSysRoleResource>> resultRR = roleResourceService.listForRoleId(roleParams);
		if (resultRR.isStatus()) {
			ArrayList<Long> params = new ArrayList<>();
			for (TSysRoleResource roleResource : resultRR.getResultData()) {
				params.add(roleResource.getFresourceId());
			}
			return resourceService.listForId(params);
		}
		return null;
	}

	@Transactional
	public Result<Integer> save(RcUser rcUser, List<Long> roles) {
		Result<Integer> result = userService.save(rcUser);
		if (result.isStatus()) {
			Result<RcUser> resultUser = userService.queryByUserNo(rcUser.getUserNo());
			if (resultUser.isStatus()) {
				return userRoleService.updateByUserId(resultUser.getResultData().getId(), roles);
			}
		}
		return result;
	}

	@Transactional
	public Result<Integer> delete(long userId) {
		RcUserRole rcUserRole = new RcUserRole();
		rcUserRole.setUserId(userId);
		Result<Integer> result = userRoleService.deleteByUserRole(rcUserRole);
		if (result.isStatus()) {
			return userService.delete(userId);
		}
		return result;
	}

	@Transactional
	public Result<Integer> update(RcUser rcUser, List<Long> roles) {
		Result<Integer> result = userService.update(rcUser);
		if (result.isStatus()) {
			return userRoleService.updateByUserId(rcUser.getId(), roles);
		}
		return result;
	}

	public Result<List<RcCompany>> queryCompanyList() {
		Result<List<RcCompany>> result = this.companyService.list();
		return result;
	}

	/**
	 * 根据编码查询权限组织
	 *
	 * @param companyNumber 分公司编码
	 * @return
	 */
	public Result<RcCompany> findCompanyByNumber(String companyNumber) {
		Result<RcCompany> result = this.companyService.queryByCompanyNumber(companyNumber);
		return result;
	}

	/**
	 * 查询当前用户权限组织
	 * Create by Andrew 2017年11月21日
	 * @return 如果不为空则返回组织列表，否则返回NULL
	 */
	public List<RcCompany> findMyCompanys() {
		Session session = SecurityUtils.getSubject().getSession();
		String companyNumber = (String) session.getAttribute(Constants.Token.COMPANY_NUMBER);
		Result<List<RcCompany>> result = companyService.listForParentCode(companyNumber, false);
		if (result.isStatus()) {
			return result.getResultData();
		}
		return null;
	}


	/**
	 * 查询当前用户权限组织
	 *
	 * @param showVirtual 是否显示虚拟组织
	 * Create by Andrew 2017年11月21日
	 * @return 如果不为空则返回组织列表，否则返回NULL
	 */
	public List<RcCompany> findMyCompanys(boolean showVirtual) {
		Session session = SecurityUtils.getSubject().getSession();
		String companyNumber = (String) session.getAttribute(Constants.Token.COMPANY_NUMBER);
		Result<List<RcCompany>> result = companyService.listForParentCode(companyNumber, showVirtual);
		if (result.isStatus()) {
			return result.getResultData();
		}
		return null;
	}

	/**
	 * 根据OPENID查询用户信息
	 * @param openId 云之家OPENID
	 * @return 用户对象
	 */
	public RcUser findUserByOpenId(String openId) {
		return userService.queryByOpenId(openId);
	}
}
