package com.goodee.app.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	
	@Autowired
	private AccountDAO dao;
	
	
	public int add(AccountDTO dto) throws Exception{
		
		return dao.add(dto);
		
	}

}
