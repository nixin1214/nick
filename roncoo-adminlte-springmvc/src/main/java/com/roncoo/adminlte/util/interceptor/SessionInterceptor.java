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
package com.roncoo.adminlte.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.roncoo.adminlte.bean.entity.RcUser;
import com.roncoo.adminlte.biz.UserBiz;
import com.roncoo.adminlte.util.Base64Util;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.roncoo.adminlte.util.ConfUtil;
import com.roncoo.adminlte.util.Constants;

/**
 * Session拦截器
 * 
 * @author wujing
 */
public class SessionInterceptor implements HandlerInterceptor {
	@Autowired
	private UserBiz biz;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		if (session == null) {
			response.sendRedirect(ConfUtil.getProperty("basePath"));
			request.setAttribute("error", "用户未登录或登录超时，请重新登录！");
			return false;
		} else {
			Object obj = session.getAttribute(Constants.Token.RONCOO);
			if (obj == null && !authHandler(request)) {
				response.sendRedirect(ConfUtil.getProperty("basePath"));
				request.setAttribute("error", "用户未登录或登录超时，请重新登录！");
				return false;
			} else {
				return true;
			}
		}
	}

	/**
	 * 自动认证
	 * @param request
	 * @return
	 */
	private boolean authHandler(HttpServletRequest request) throws Exception {
		String openId = request.getParameter("openId");
		if (StringUtils.trimToNull(openId) == null) {
			return false;
		}
		RcUser user = biz.findUserByOpenId(openId);
		if (user == null) {
			return false;
		}
		String password = Base64Util.decode(user.getPassword());
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserNo(), password);
		token.setRememberMe(true);
		try {
			SecurityUtils.getSubject().getSession().setAttribute(Constants.Token.YZJ_OPEN_ID, openId);
			SecurityUtils.getSubject().login(token);
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}

}
