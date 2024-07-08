package com.goodee.app.account;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.goodee.app.member.MemberDTO;

@Controller
@RequestMapping("/account/*")
public class AccountController {
	
	@Autowired
	private AccountService service;
	
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(HttpSession session, AccountDTO dto) throws Exception{
		
		String name = ((MemberDTO)session.getAttribute("dto")).getUser_id();
		dto.setUser_id(name);
		
		int result = service.add(dto);
		
		return "redirect:/";
		
	}

	
}
