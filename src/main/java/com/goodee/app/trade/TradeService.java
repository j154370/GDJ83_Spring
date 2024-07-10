package com.goodee.app.trade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradeService {


	@Autowired
	private TradeDAO tradeDAO;
	
	public int trade(TradeDTO tradeDTO) throws Exception{
		
		tradeDTO.setTrade_amount(tradeDTO.getTrade_amount() * -1);
		tradeDTO.setTrade_type("출금");
		
		//보내는 계좌 거래내역 추가
		int result = tradeDAO.add(tradeDTO);
		
		//보내는 계좌 거래내역 수정
		result = tradeDAO.update(tradeDTO);
		
		//받는 계좌 거래내역 추가
		tradeDTO.setAccount_num(tradeDTO.getReceive_num());
		tradeDTO.setTrade_amount(tradeDTO.getTrade_amount() * -1);
		tradeDTO.setTrade_type("입금");
		result = tradeDAO.add(tradeDTO);
		
		//받는 계좌 거래내역 수정
		result = tradeDAO.update(tradeDTO);
		
		return result;
	}
}
