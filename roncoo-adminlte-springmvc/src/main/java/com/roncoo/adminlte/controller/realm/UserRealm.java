package com.roncoo.adminlte.controller.realm;

import java.util.HashSet;
import java.util.List;

import com.roncoo.adminlte.bean.entity.*;
import com.roncoo.adminlte.service.TSysUserLogsService;
import com.roncoo.adminlte.service.UserService;
import com.roncoo.adminlte.util.Base64Util;
import com.roncoo.adminlte.util.base.BaseController;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.biz.UserBiz;
import com.roncoo.adminlte.util.Constants;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class UserRealm extends AuthorizingRealm {

	@Autowired
	private UserBiz biz;
	@Autowired
	private UserService userService;
	@Autowired
	private TSysUserLogsService userLogsService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		String userno = (String) principals.getPrimaryPrincipal();
		Result<RcUser> result = biz.queryByUserNo(userno);
		if(result.isStatus()){
			Result<List<RcRole>> resultRole = biz.queryRoles(result.getResultData().getId());
			if(resultRole.isStatus()){
				//获取角色
				HashSet<String> roles = new HashSet<String>();
				for (RcRole rcRole : resultRole.getResultData()) {
					roles.add(rcRole.getRoleValue());
				}
				System.out.println("角色："+roles);
				authorizationInfo.setRoles(roles);
				
				//获取权限
				/*Result<List<RcPermission>> resultPermission = biz.queryPermissions(resultRole.getResultData());
				if(resultPermission.isStatus()){
					HashSet<String> permissions = new HashSet<String>();
					for (RcPermission rcPermission : resultPermission.getResultData()) {
						permissions.add(rcPermission.getPermissionsValue());
					}
					System.out.println("权限："+permissions);
					authorizationInfo.setStringPermissions(permissions);
				}*/
				//注入资源访问权限
				Result<List<TSysResource>> resultResource = biz.queryResources(resultRole.getResultData());
				if (resultResource.isStatus()) {
					HashSet<String> permissions = new HashSet<>();
					HashSet<Long> resourceIds = new HashSet<>();
					for (TSysResource sysResource : resultResource.getResultData()) {
						permissions.add(sysResource.getFpermissionValue());
						resourceIds.add(sysResource.getFid());
					}
					System.out.println("权限：" + permissions);
					authorizationInfo.setStringPermissions(permissions);
					//缓存权限ID列表
					SecurityUtils.getSubject().getSession().setAttribute(Constants.RESOURCES, resultResource.getResultData());
				}
			}
		}
		return authorizationInfo;
		
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

		String userno = (String) authenticationToken.getPrincipal();
		String password = new String((char[]) authenticationToken.getCredentials());
		Result<RcUser> result = biz.login(userno, password);

		if (result.isStatus()) {
			Session session = SecurityUtils.getSubject().getSession();
			session.setAttribute(Constants.Token.RONCOO, userno);
			RcUser user = result.getResultData();
			session.setAttribute(Constants.Token.USER_INFO, user);

			//与云之家绑定
			if (StringUtils.trimToNull(user.getYZJOpenId()) == null) {
				String openId = (String) session.getAttribute(Constants.Token.YZJ_OPEN_ID);
//				user.setYZJOpenId(StringUtils.trimToNull(openId));
//				user.setPassword(password);
				RcUser rcUser = new RcUser();
				rcUser.setUserNo(userno);
				rcUser.setYZJOpenId(openId);
				userService.update(rcUser);
			}

			//查询用户组织
			if (BaseController.COMPANY_CACHE.isEmpty()) {
				loadCompany();//缓存分公司
			}

			if (BaseController.COMPANY_CACHE.containsKey(user.getDataScope())) {
				RcCompany company = BaseController.COMPANY_CACHE.get(user.getDataScope());
				session.setAttribute(Constants.Token.COMPANY_NUMBER, company.getFnumber());
				session.setAttribute(Constants.INDEX_URL, company.getFview());
			} else {
				Result<RcCompany> companyResult = biz.findCompanyByNumber(user.getDataScope());
				if (companyResult.isStatus()) {
					RcCompany company = companyResult.getResultData();
					if (!BaseController.COMPANY_CACHE.containsKey(company.getFnumber())) {
						BaseController.COMPANY_CACHE.put(company.getFnumber(), company);
					}
					session.setAttribute(Constants.Token.COMPANY_NUMBER, company.getFnumber());
					session.setAttribute(Constants.INDEX_URL, company.getFview());
				}
			}
			userLogsService.addLog("登录", "doGetAuthenticationInfo", "PC端", "", "0", "", session.getHost());
			return new SimpleAuthenticationInfo(user.getUserNo(), Base64Util.decode(user.getPassword()), getName());
		} else {
			//添加操作日志
			userLogsService.addLog("登录", "doGetAuthenticationInfo", "PC端", "", "auth_fail", "用户名或密码错误", "");
		}
		return null;
	}

	private void loadCompany() {
		Result<List<RcCompany>> result = biz.queryCompanyList();
		if (result.isStatus()) {
			List<RcCompany> companyList = result.getResultData();
			for(RcCompany company : companyList) {
				BaseController.COMPANY_CACHE.put(company.getFnumber(), company);
			}
		}
	}

	/**
	 * 清空当前用户权限信息
	 */
	public  void clearCachedAuthorizationInfo() {
		PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principalCollection, getName());
		super.clearCachedAuthorizationInfo(principals);
	}
	/**
	 * 指定principalCollection 清除
	 */
	public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principalCollection, getName());
		super.clearCachedAuthorizationInfo(principals);
	}
}
