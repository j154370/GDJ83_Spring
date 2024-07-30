package com.goodee.app.interceptors;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.goodee.app.boards.BoardDTO;
import com.goodee.app.member.MemberDTO;

public class WriterInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		String method = request.getMethod();
		
		if(method.toUpperCase().equals("POST")) {
			return;
		}
		
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("dto");
		
		Map<String, Object> map = modelAndView.getModel();
		Iterator<String> it = map.keySet().iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		BoardDTO boardDTO = (BoardDTO)map.get("dto");
		
		if(!boardDTO.getBoard_writer().equals(memberDTO.getUser_id())) {
			
			modelAndView.setViewName("redirect:/");
			
		}
		
		super.postHandle(request, response, handler, modelAndView);
	}

}
