package com.goodee.app.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	public LoginFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		Object obj = session.getAttribute("dto");

		if (obj != null) {
			chain.doFilter(request, response);
		} else {
			// 1. forward 방식
			request.setAttribute("result", "로그인 후에 다시 시도하세요");
			request.setAttribute("url", "/member/login");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/commons/message.jsp");
			view.forward(request, response);

			// 2. redirect 방식
//			HttpServletResponse res = (HttpServletResponse)response;
//			res.sendRedirect("/member/login");
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
