package com.goodee.app.trade;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TradeDAO {

	@Autowired	
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.goodee.app.trade.TradeDAO.";
	
	public int add(TradeDTO tradeDTO) throws Exception{
		
		return sqlSession.insert(NAMESPACE + "add", tradeDTO);
	}
	
	public int update(TradeDTO tradeDTO) throws Exception{
		
		return sqlSession.update(NAMESPACE + "update", tradeDTO);
	}
}
