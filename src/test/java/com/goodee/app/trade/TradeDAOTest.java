package com.goodee.app.trade;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.goodee.app.DefaultTest;

public class TradeDAOTest extends DefaultTest{

	@Autowired
	private TradeDAO tradeDAO;
	
	private TradeDTO tradeDTO;
	
	@Before
	public void before() {
		this.tradeDTO = new TradeDTO();
		tradeDTO.setAccount_num("1111");
		tradeDTO.setTrade_amount(5000L);
		tradeDTO.setTrade_type("입금");
	}
	
	@Test
	public void addTest() throws Exception{
		int result = tradeDAO.add(tradeDTO);
		
		assertEquals(1, result);
	}
	
	@Test
	public void updateTest() throws Exception{
		int result = tradeDAO.update(tradeDTO);
		assertNotEquals(0, result);
	}
	

}
