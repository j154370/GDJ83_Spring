package com.goodee.app.account;

import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account/*")
public class AccountController {
	
	@Autowired
	private AccountService service;
	
	
	@RequestMapping("add")
	public String add(HttpSession session, AccountDTO dto) throws Exception{
		
		Calendar ca = Calendar.getInstance();
		
		long l = ca.getTimeInMillis();
		String s = String.valueOf(l);
		
		dto = (AccountDTO)session.getAttribute("dto");
		dto.setAccount_num(s);
		dto.setBalance(0);
		
		int result = service.add(dto);
		
		return "redirect:/";
		
	}

	
}
