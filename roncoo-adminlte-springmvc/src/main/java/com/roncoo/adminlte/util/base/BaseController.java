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
package com.roncoo.adminlte.util.base;

import com.roncoo.adminlte.bean.entity.RcCompany;
import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.util.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.MessageFormat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 基础类，所以controller都应该继承这个类
 * 
 * @author wujing
 */
public class BaseController {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	public static final String TEXT_UTF8 = "text/html;charset=UTF-8";
	public static final String JSON_UTF8 = "application/json;charset=UTF-8";
	public static final String XML_UTF8 = "application/xml;charset=UTF-8";

	public static final String LIST = "list";
	public static final String VIEW = "view";
	public static final String ADD = "add";
	public static final String SAVE = "save";
	public static final String EDIT = "edit";
	public static final String UPDATE = "update";
	public static final String DELETE = "delete";
	public static final String PAGE = "page";

	public static Map<String, RcCompany> COMPANY_CACHE = new ConcurrentHashMap<>();

	public static String redirect(String format, Object... arguments) {
		return new StringBuffer("redirect:").append(MessageFormat.format(format, arguments)).toString();
	}

	/**
	 * 获取页面基础信息
	 * @param modelMap
	 */
	public static void getBaseInfo(ModelMap modelMap) {
		Session session = SecurityUtils.getSubject().getSession();
		RcUser user = (RcUser) session.getAttribute(Constants.Token.USER_INFO);
		modelMap.put("user", user);
	}

	public static HttpSession getSession() {
		HttpSession session = null;
		try {
			session = getRequest().getSession();
		} catch (Exception e) {}
		return session;
	}

	public static HttpServletRequest getRequest() {
		ServletRequestAttributes attrs =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return attrs.getRequest();
	}

	/**
	 * 获取客户端IP
	 * @return 返回IP地址
	 */
	public static String getClientIP() {
		String remoteAddr = "";

		if (getRequest() != null) {
			remoteAddr = getRequest().getHeader("X-FORWARDED-FOR");
			if (remoteAddr == null || "".equals(remoteAddr)) {
				remoteAddr = getRequest().getRemoteAddr();
			}
		}

		return remoteAddr;
	}

	/**
	 * 获取请求路径及参数
	 *
	 * @return 返回访问全路径及参数
	 */
	public static String getRequestPath() {
		HttpServletRequest request = getRequest();
		String url = request.getScheme() +"://" + request.getServerName()
				+ ":" +request.getServerPort()
				+ request.getServletPath();
		if (request.getQueryString() != null){
			url += "?" + request.getQueryString();
		}
		return url;
	}

}
