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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.roncoo.adminlte.bean.vo.RcRoleVo;
import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.util.base.Page;

@Component
public class RoleBiz {

	@Autowired
	private RoleService service;

	@Autowired
	private RolePermissionsService rolePermissionsService;

	@Autowired
	private PermissionService permissionService;

	@Autowired
	private SysRoleResourceService roleResourceService;

	@Autowired
	private SysResourceService resourceService;

	public Result<Page<RcRole>> listForPage(int pageCurrent, int pageSize, String date, String search) {
		return service.listForPage(pageCurrent, pageSize, date, search);
	}

	public Result<RcRoleVo> query(long id) {
		Result<RcRole> result = service.query(id);
		Result<RcRoleVo> resultRoleVo = new Result<RcRoleVo>();
		if (result.isStatus()) {
			RcRoleVo rcRoleVo = new RcRoleVo(result.getResultData());
			/*Result<List<RcRolePermissions>> resultRolePermissions = rolePermissionsService.queryByRoleId(id);
			if (resultRolePermissions.isStatus()) {
				ArrayList<Long> idList = new ArrayList<Long>();
				for (RcRolePermissions rcRolePermissions : resultRolePermissions.getResultData()) {
					idList.add(rcRolePermissions.getPermissionId());
				}
				Result<List<RcPermission>> resultPermission = permissionService.listForId(idList);
				rcRoleVo.setPermissionList(resultPermission.getResultData());
				resultRoleVo.setErrCode(0);
				resultRoleVo.setStatus(true);
				resultRoleVo.setResultData(rcRoleVo);
				resultRoleVo.setErrMsg("查询成功");
				return resultRoleVo;
			}*/
			Result<List<TSysRoleResource>> resultRoleResources = roleResourceService.queryByRoleId(id);
			if (resultRoleResources.isStatus()) {
				ArrayList<Long> idList = new ArrayList<Long>();
				for (TSysRoleResource rcRolePermissions : resultRoleResources.getResultData()) {
					idList.add(rcRolePermissions.getFresourceId());
				}
				Result<List<TSysResource>> resultPermission = resourceService.listForId(idList);
				rcRoleVo.setResourcesList(resultPermission.getResultData());
				resultRoleVo.setErrCode(0);
				resultRoleVo.setStatus(true);
				resultRoleVo.setResultData(rcRoleVo);
				resultRoleVo.setErrMsg("查询成功");
				return resultRoleVo;
			}
		}
		return resultRoleVo;
	}

	public Result<List<RcPermission>> queryPermissionList() {
		return permissionService.list();
	}

	@Transactional
	public Result<Integer> save(RcRole rcRole, List<Long> permissionList) {
		Result<Integer> result = service.save(rcRole);
		if (result.isStatus()) {
			Result<RcRole> resultRole = service.queryByRoleName(rcRole.getRoleName());
			if (result.isStatus()) {
				return roleResourceService.save(resultRole.getResultData().getId(), permissionList);
			}
		}
		return result;
	}

	@Transactional
	public Result<Integer> delete(long id) {
		Result<Integer> result = roleResourceService.delete(id);
		if (result.isStatus()) {
			return service.delete(id);
		}
		return result;
	}

	@Transactional
	public Result<Integer> update(RcRole rcRole, List<Long> permissionList) {
		Result<Integer> result = roleResourceService.update(rcRole.getId(), permissionList);
		if (result.isStatus()) {
			return service.update(rcRole);
		}
		return result;
	}
}
