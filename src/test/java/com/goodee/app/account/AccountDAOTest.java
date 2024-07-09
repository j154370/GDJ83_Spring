package com.goodee.app.account;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.goodee.app.DefaultTest;


public class AccountDAOTest extends DefaultTest{

	@Autowired
	private AccountDAO accountDAO;
	
	@Test
	public void detailTest() throws Exception{
		AccountDTO accountDTO = new AccountDTO();
		
		accountDTO.setAccount_num("2222");
		accountDTO = accountDAO.detail(accountDTO);
		
		assertNotNull(accountDTO);
	}

}
