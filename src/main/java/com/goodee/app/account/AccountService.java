package com.goodee.app.account;

import java.util.Calendar;

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
	
	

}
