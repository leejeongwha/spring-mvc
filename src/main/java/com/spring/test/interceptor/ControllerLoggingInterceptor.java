package com.spring.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.spring.test.annotation.Auth;

public class ControllerLoggingInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse, Object obj, Exception exception) throws Exception {
		System.out.println("afterCompletion");
	}

	@Override
	public void postHandle(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse, Object obj, ModelAndView modelandview) throws Exception {
		System.out.println("postHandle");
	}

	@Override
	public boolean preHandle(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse, Object obj) throws Exception {
		System.out.println("preHandle");
		Auth auth = ((HandlerMethod)obj).getMethodAnnotation(Auth.class);

		//Auth 어노테이션이 없음
		if (auth == null) {
			//TODO 로그인 체크 하지 않음
			System.out.println("Auth 어노테이션이 없음");
		}
		//Auth 어노테이션 존재
		else {
			//TODO 로그인 체크
			System.out.println("Auth 어노테이션이 있음");
		}
		return true;
	}

}
