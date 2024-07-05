package com.goodee.app.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberService service;

	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void join() throws Exception {

	}

	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(Model model, MemberDTO dto) throws Exception {
		int result = service.join(dto);

		String path = "commons/message";
		if (result > 0) {
			path = "redirect:/";
		} else {
			model.addAttribute("result", "정보 입력에 실패했습니다.");
			model.addAttribute("url", "./");
		}

		return path;
	}

	@RequestMapping(value = "login", method = RequestMethod.GET) // required = false의 뜻은 쿠키 안에 값이 없어도 괜찮다는 설정(이걸 안하면
																	// Null이 들어올 때 에러가 발생한다)
	public void login(Model model, @CookieValue(name = "remember", required = false, defaultValue = "") String value)
			throws Exception {
		model.addAttribute("id", value);
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login2(MemberDTO dto, HttpServletResponse response, String remember, HttpSession session)
			throws Exception {

		// 쿠키 관련 코드
		if (remember != null) {
			Cookie cookie = new Cookie("remember", dto.getUser_id());
			cookie.setMaxAge(3600);
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("remember", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}

		// 로그인 관련 코드
		dto = service.login(dto);
		if (dto != null) {
			session.setAttribute("dto", dto);
		} else {

		}

		return "redirect:/";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate(); // 세션의 유지시간을 0으로 만듬. 즉, 종료를 의미함
		// session.setAttribute("dto",null);
		// session.removeAttribute("dto"); 둘다 같은 방법

		return "redirect:/";
	}

	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public void mypage() throws Exception {

	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(Model model, MemberDTO dto) throws Exception {
		
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(MemberDTO dto, HttpSession session) throws Exception {
		
		MemberDTO user = (MemberDTO)session.getAttribute("dto");
		dto.setUser_id(user.getUser_id());
		
		int result = service.update(dto);
		
		if(result > 0) {
			session.setAttribute("dto", dto);
		}

		return "redirect:/";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public String delete(MemberDTO dto, HttpSession session) throws Exception{
		
		MemberDTO user = (MemberDTO)session.getAttribute("dto");
		dto.setUser_id(user.getUser_id());
		
		int result = service.delete(dto);
		
		if(result > 0) {
			session.invalidate();
		}
		
		return "redirect:/";
	}

}
