package com.goodee.app.account;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public void detail(AccountDTO dto, Model model) throws Exception{
		dto = service.detail(dto);
		
		model.addAttribute("dto", dto);
		
	}
	
	@RequestMapping(value="transfer", method = RequestMethod.GET)
	public void transfer(AccountDTO dto, Model model) throws Exception{
		dto = service.detail(dto);
		
		model.addAttribute("dto", dto);
	}
	
	@RequestMapping(value="transfer", method = RequestMethod.POST)
	public String transfer(TradeDTO tradeDTO, AccountDTO accountDTO, Model model ) throws Exception{
		
		int result = service.transfer(tradeDTO, accountDTO);
		
		String path = "";
		if(result == 4) {
			path = "commons/message";
			model.addAttribute("result", "송금 성공");
			model.addAttribute("url", "/member/mypage");
			
		}else {
			path = "commons/message";
			model.addAttribute("result", "송금 실패");
			model.addAttribute("url", "/member/mypage");
		}
		
		return path;
	}
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public void list(Model model, ListOption listOption) throws Exception{
		
		List<TradeDTO> list = service.getList(listOption);
		
		model.addAttribute("list", list);
	}

	
}
