package com.goodee.app.account;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.goodee.app.member.MemberDTO;
import com.goodee.app.trade.TradeDTO;
import com.goodee.app.trade.TradeService;

@Controller
@RequestMapping("/account/*")
public class AccountController {
	
	@Autowired
	private AccountService service;
	
	@Autowired
	private TradeService tradeService;
	
	
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
	public void transfer() throws Exception{
	}
	
	@RequestMapping(value="transfer", method = RequestMethod.POST)
	public String transfer2(TradeDTO tradeDTO) throws Exception{
		
		// 보내는 계좌 : account_num
		// 받는 계좌 : receive_num
		int result = tradeService.trade(tradeDTO);
		
		return "redirect:../member/mypage";
		
	}
	

	
}
