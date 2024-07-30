package com.goodee.app.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class TestInterceptor extends HandlerInterceptorAdapter{
	
	// Controller 진입 전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		
		// return이 ture라면 다음 인터셉터나 컨트롤러로 진입
		// return이 false라면 진입을 거부
		System.out.println("test Interceptor");
		return true;
		//return super.preHandle(request, response, handler);
	}
	
	// Controller 나갈 때
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("Post Handle");
		//super.postHandle(request, response, handler, modelAndView);
	}
	
	
	// JSP를 HTML로 만든 이후 (사실상 거의 안씀)
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		System.out.println("After Interceptor");
		//super.afterCompletion(request, response, handler, ex);
	}
}
