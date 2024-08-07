package com.goodee.app.account;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	
	@Autowired
	private AccountDAO dao;
	
	
	public int add(AccountDTO dto) throws Exception{
		
		Calendar ca = Calendar.getInstance();
		
		long l = ca.getTimeInMillis();
		String s = String.valueOf(l);
		
		dto.setAccount_num(s);
		
		
		return dao.add(dto);
		
	}
	
	public AccountDTO detail(AccountDTO dto) throws Exception{
		
		return dao.detail(dto);
	}
	
	public int transfer(TradeDTO tradeDTO, AccountDTO accountDTO) throws Exception{
		int a = 0;
		
		if(tradeDTO.getTrade_amount() > accountDTO.getBalance()) {
			a = -1;
		}else {
			a = dao.transferMy(tradeDTO);
			a +=dao.transferYou(tradeDTO);
			a += dao.updateMy(tradeDTO);
			a += dao.updateYou(tradeDTO);		
		}
		
		return a;
	}
	
	public List<TradeDTO> getList(ListOption listOption)throws Exception{
		
		return dao.getList(listOption);
	}

}
