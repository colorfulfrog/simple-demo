package com.yxcoach.common.security;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * CSRF防御拦截器
 * @ClassName: CsrfInterceptor
 * @Description: TODO
 * @author nizhi
 * @date 2017年7月3日 下午4:08:52
 */
public class CsrfInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object obj) throws Exception {
		
		if(true) return true;
		
		
		// 过滤公共url
		String requestURI = request.getRequestURI();
		if (requestURI.indexOf("/login") != -1) {
			return true;
		}

		// 1.referer过滤
		// 从 HTTP 头中取得 Referer 值
		String referer = request.getHeader("Referer");
		// 判断 Referer 是否以指定ip或域名开头
		if (referer == null || !referer.trim().startsWith("192.168.1.25")) {
			return false;
		}

		// 2.token过滤
		HttpSession session = request.getSession();
		// 从 session 中得到 csrftoken 属性
		String sToken = (String) session.getAttribute("csrftoken");
		if (sToken == null) {
			// 产生新的 token 放入 session 中
			sToken = UUID.randomUUID().toString();
			session.setAttribute("csrftoken", sToken);
			return true;
		} else {
			// 从 HTTP 头中取得 csrftoken
			String xhrToken = request.getHeader("csrftoken");
			// 从请求参数中取得 csrftoken
			String pToken = request.getParameter("csrftoken");
			if (sToken == null || xhrToken == null || !sToken.equals(xhrToken)) {
				return false;
			} else if (sToken == null || pToken == null || !sToken.equals(pToken)) {
				return false;
			}
		}
		
		//3.
		
		
		
		
		return true;
	}

}
