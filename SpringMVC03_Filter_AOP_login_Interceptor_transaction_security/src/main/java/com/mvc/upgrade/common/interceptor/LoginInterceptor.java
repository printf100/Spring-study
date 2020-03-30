package com.mvc.upgrade.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		logger.info("[ INTERCEPTOR ] : preHandle");

		if (request.getRequestURI().contains("/loginpage.do") || request.getRequestURI().contains("/ajaxlogin.do")
				|| request.getRequestURI().contains("/joinpage.do") || request.getRequestURI().contains("/ajaxidchk.do") || request.getRequestURI().contains("/ajaxjoin.do")
				|| request.getRequestURI().contains("/test.do") || request.getSession().getAttribute("login") != null) {
			return true;

		}
		
		// 로그인이 안되어있다면
		if (request.getSession().getAttribute("login") == null) {
			response.sendRedirect("loginpage.do");
		}

		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		logger.info("[ INTERCEPTOR ] : postHandle");

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		logger.info("[ INTERCEPTOR ] : afterCompletion");
	}

}
