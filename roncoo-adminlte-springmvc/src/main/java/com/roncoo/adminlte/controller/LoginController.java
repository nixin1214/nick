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
package com.roncoo.adminlte.controller;

import com.alibaba.fastjson.JSONObject;
import com.betimes.common.utils.StringUtils;
import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.biz.LoginBiz;
import com.roncoo.adminlte.service.TSysUserLogsService;
import com.roncoo.adminlte.util.Constants;
import com.roncoo.adminlte.util.Tools;
import com.roncoo.adminlte.util.base.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException  ;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * 登录功能，集成了oauth登录
 * 
 * @author wujing
 */
@Controller
@RequestMapping
//@EnableSpringHttpSession
public class LoginController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private LoginBiz biz;
	@Autowired
	private TSysUserLogsService userLogsService;

	/**
	 * 进入登录页面
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(HttpSession session, HttpServletRequest request, ModelMap modelMap) {
		Object token = session.getAttribute(Constants.Token.RONCOO);
		if (token == null) {
			String openId = ServletRequestUtils.getStringParameter(request, "openId", "");
			modelMap.put("openId", openId);
			return "login";
		}
		return redirect("/admin/index");
	}
	/**
	 * 登录，跳转到授权页面
	 * 
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postLogin(HttpServletRequest request, RedirectAttributesModelMap  modelMap) throws ServletRequestBindingException {
		String openId = ServletRequestUtils.getStringParameter(request, "openId", "");
		if (StringUtils.isNotBlank(openId)) {
			SecurityUtils.getSubject().getSession().setAttribute(Constants.Token.YZJ_OPEN_ID, openId);
		}
		if (SecurityUtils.getSubject().isAuthenticated()) {
			return redirect("/admin/login");
		} else {
			modelMap.addFlashAttribute("error", "用户名或密码错误");
			return redirect("/login");
		}
		/*try {
			String username = ServletRequestUtils.getStringParameter(request, "username");
			String password = ServletRequestUtils.getStringParameter(request, "password");
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			SecurityUtils.getSubject().login(token);
		} catch (ServletRequestBindingException e) {
			logger.error("用户名或密码为空");
			modelMap.addFlashAttribute("error", "用户名或密码不能为空");
			throw e;
		} catch (IncorrectCredentialsException e) {
			modelMap.addFlashAttribute("error", "用户名或密码错误");
			throw e;
		} catch (UnknownAccountException e) {
			modelMap.addFlashAttribute("error", "用户不存在");
			throw e;
		}*/
    }

	@RequestMapping(value = "/certification", method = RequestMethod.GET)
	public String certification(HttpSession session) {
		Result<String> result = biz.login();
		if (result.isStatus()) {
			logger.info(result.getResultData());

			session.setAttribute(Constants.Token.RONCOO, "www.kingdee.com");

			// return redirect(result.getResultData());
		}
		return redirect("/login");
	}

	/**
	 * 授权登录
	 */
	@RequestMapping(value = "/oauth", method = RequestMethod.GET)
	public String oauth(@RequestParam(value = "code", defaultValue = "") String code, RedirectAttributes redirectAttributes, HttpSession session) {
		Result<String> result = biz.oauth(code);
		if (result.isStatus()) {
			// 成功之后，传入session
			session.setAttribute(Constants.Token.RONCOO, result.getResultData());
		}

		// 重定向到登录页面，由它来判断session进行登录
		return redirect("/login");
	}

	/**
	 * 退出登陆操作
	 */
	@RequestMapping(value = "/exit", method = RequestMethod.GET)
	public String exit(RedirectAttributes redirectAttributes, HttpSession session) {
		//记录操作日志
		userLogsService.addLog("登出", getRequestPath(), "PC端", getClientIP(), "success", "", "");
		//退出登录
		session.removeAttribute(Constants.Token.RONCOO);
		SecurityUtils.getSubject().logout();
		redirectAttributes.addFlashAttribute("msg", "您已经安全退出");
		return redirect("/login");
	}

	/**
	 * 权限不足
	 */
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public void error() {
	}


	/**
	 * 登录，跳转到授权页面
	 *
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/login2", method = RequestMethod.POST)
	public String postLogin(HttpSession session, HttpServletRequest request, ModelMap modelMap) throws ServletRequestBindingException {
		try {
			String username = ServletRequestUtils.getStringParameter(request, "username");
			String password = ServletRequestUtils.getStringParameter(request, "password");
			String openId = ServletRequestUtils.getStringParameter(request, "openId", "");
			SecurityUtils.getSubject().getSession().setAttribute(Constants.Token.YZJ_OPEN_ID, openId);
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			SecurityUtils.getSubject().login(token);
			return redirect("/admin/index");
		} catch (ServletRequestBindingException e) {
			logger.error("用户名或密码为空");
			modelMap.put("error", "用户名或密码不能为空");
			throw e;
		} catch (IncorrectCredentialsException e) {
			modelMap.put("error", "用户名或密码错误");
			throw e;
		}
	}

}
