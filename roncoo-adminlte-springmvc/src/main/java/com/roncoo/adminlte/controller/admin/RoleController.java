package com.roncoo.adminlte.controller.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.roncoo.adminlte.bean.entity.TSysResource;
import com.roncoo.adminlte.bean.entity.TSysRoleResource;
import com.roncoo.adminlte.bean.vo.TSysResourceVo;
import com.roncoo.adminlte.service.SysResourceService;
import com.roncoo.adminlte.service.SysRoleResourceService;
import com.roncoo.adminlte.service.TSysUserLogsService;
import com.roncoo.adminlte.util.Constants;
import com.roncoo.adminlte.util.ResourceUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.roncoo.adminlte.bean.entity.RcPermission;
import com.roncoo.adminlte.bean.entity.RcRole;
import com.roncoo.adminlte.bean.vo.RcRoleVo;
import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.biz.RoleBiz;
import com.roncoo.adminlte.util.base.BaseController;
import com.roncoo.adminlte.util.base.Page;
import com.roncoo.adminlte.util.base.PageBean;
import com.roncoo.adminlte.util.base.ParamUtil;

@Controller
@RequestMapping(value = "/admin/role/", method = RequestMethod.POST)
public class RoleController extends BaseController {

	@Autowired
	private RoleBiz biz;

	@Autowired
    private SysResourceService resourceService;

	@Autowired
	private SysRoleResourceService roleResourceService;
	@Autowired
	private TSysUserLogsService userLogsService;

	@RequestMapping(value = LIST, method = RequestMethod.GET)
	public void list() {

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
	public PageBean<RcRole> queryForPage(@RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "length", defaultValue = "10") int pageSize, @RequestParam(value = "date", required = false) String date, @RequestParam(value = "search", required = false) String search) {
		Result<Page<RcRole>> result = biz.listForPage((start / pageSize) + 1, pageSize, date, search);
		//记录操作日志
		userLogsService.addLog("浏览角色", getRequestPath(), "PC端", getClientIP(), "success", "", "浏览角色列表");
		if (result.isStatus()) {
			return new PageBean<RcRole>(result.getResultData());
		}
		return new PageBean<RcRole>();
	}

	@RequestMapping(value = ADD, method = RequestMethod.GET)
	public void add(ModelMap modelMap) {
		Result<List<RcPermission>> resultPermission = biz.queryPermissionList();
		if (resultPermission.isStatus()) {
			modelMap.put("permissions", resultPermission.getResultData());
		}
	}


	@RequestMapping(value = SAVE, method = RequestMethod.POST)
    @ResponseBody
	public String save(RcRole rcRole, String resources) {
		List<Long> permissions = ParamUtil.toLongList(resources, ",");
		Result<Integer> result = biz.save(rcRole, permissions);
		if (result.isStatus()) {
			//记录操作日志
			userLogsService.addLog("添加角色", getRequestPath(), "PC端", getClientIP(), "0", "", "添加角色成功");
			//return redirect("/admin/role/list");
			return "添加角色成功";
		} else {
			//记录操作日志
			userLogsService.addLog("添加角色", getRequestPath(), "PC端", getClientIP(), "add_role:fail", "添加角色失败", rcRole.toString());
            return "角色已存在，请重新输入";
		}

	}

	@RequestMapping(value = VIEW, method = RequestMethod.GET)
	public void view(ModelMap modelMap, long id) {
		Result<RcRoleVo> result = biz.query(id);
		if (result.isStatus()) {
			//记录操作日志
			userLogsService.addLog("浏览角色", getRequestPath(), "PC端", getClientIP(), "success", "", "浏览角色详情");
			modelMap.put("bean", result.getResultData());
		}
	}

	@RequestMapping(value = EDIT, method = RequestMethod.GET)
	public void edit(ModelMap modelMap, long id) {
		Result<RcRoleVo> result = biz.query(id);
		if (result.isStatus()) {
			modelMap.put("bean", result.getResultData());
		}

		Result<List<RcPermission>> resultPermission = biz.queryPermissionList();
		if (resultPermission.isStatus()) {
			modelMap.put("permissions", resultPermission.getResultData());
		}

		Result<List<TSysRoleResource>> resultRoleResource = roleResourceService.queryByRoleId(id);
		if (resultRoleResource.isStatus()) {
			StringBuilder resourceIds = new StringBuilder();
			for (TSysRoleResource roleResource : resultRoleResource.getResultData()) {
				resourceIds.append(roleResource.getFresourceId()).append(",");
			}
			modelMap.put("resources", resourceIds.toString());
		}
	}

	@RequestMapping(value = UPDATE)
	@ResponseBody
	public String update(RcRole rcRole, String resources) {
		List<Long> permissions = ParamUtil.toLongList(resources, ",");
		Result<Integer> result = biz.update(rcRole, permissions);
		if (result.isStatus()) {
			//记录操作日志
			userLogsService.addLog("编辑角色", getRequestPath(), "PC端", getClientIP(), "success", "", rcRole.toString());
			return redirect("/admin/role/list");
		}
		return null;
	}
	
	@RequestMapping(value = DELETE, method = RequestMethod.GET)
	@ResponseBody
	public String delete(long id) {
		Result<Integer> result = biz.delete(id);
		if(result.isStatus()){
			//记录操作日志
			userLogsService.addLog("删除角色", getRequestPath(), "PC端", getClientIP(), "success", "", "删除角色成功:" + id);
			return redirect("/admin/role/list");
		}
		return null;
	}

	@RequestMapping(value = "getResources", method = RequestMethod.GET)
    @ResponseBody
	public String getResources(ModelMap modelMap) {
        Result<List<TSysResource>> result = resourceService.list();
        if (result.isStatus()) {
            List<TSysResource> list = result.getResultData();
			List<Map<String, Object>> treeList = ResourceUtil.getTreeList(list, null);
            /*List<Map<String, Object>> treeList = new ArrayList<Map<String, Object>>();
            for (TSysResource resource : list) {
            	if (resource.getFstatus() == 0) {
            		continue;
				}
				if (resource.getFresType().equalsIgnoreCase(Constants.ResourceType.LABEL)) {
            		continue;
				}

				if (resource.getFparentId() == -1) {
					treeList.add(ResourceUtil.getMapNode(resource));
				} else {
					Map<String, Object> parentNode = ResourceUtil.getParentNode(treeList, resource.getFparentId());
					if (parentNode != null && parentNode.containsKey("children")) {
						List<Map<String, Object>> childNodes = (List<Map<String, Object>>) parentNode.get("children");
						childNodes.add(ResourceUtil.getMapNode(resource));
					}
				}
            }*/
            return (JSONArray.fromObject(treeList)).toString();
        }
        return null;
    }

}
