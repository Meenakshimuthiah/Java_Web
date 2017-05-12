package com.edu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.edu.spring.pojo.LoginDetails;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		if (!uri.endsWith("/user/login")) {
			LoginDetails userData = (LoginDetails) request.getSession().getAttribute("user");
			if (userData == null) {
				response.sendRedirect(request.getContextPath());
				return false;
			}
		}
		return true;
	}
}
