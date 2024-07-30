package com.goodee.app.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.goodee.app.member.MemberDTO;

public class AdminInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("dto");
		
		if(memberDTO == null) {
			response.sendRedirect("/member/login");
			
			return false;
		}
		
		if(!memberDTO.getUser_id().equals("123123123")) {
			response.sendRedirect("/");
			
			return false;
		}
		
		return true;
	}

}
