package com.goodee.app.account;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class AccountDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.goodee.app.account.AccountDAO.";
	
	
	public int add(AccountDTO dto) throws Exception{
		
		return sqlSession.insert(NAMESPACE + "add", dto);
	}
	
	public AccountDTO detail(AccountDTO dto) throws Exception{

		return sqlSession.selectOne(NAMESPACE + "detail", dto);
	}
	
	public int transferMy(TradeDTO tradeDTO) throws Exception{
		
		return sqlSession.insert(NAMESPACE + "transferMy", tradeDTO);
	}
	
	public int transferYou(TradeDTO tradeDTO) throws Exception{
		
		return sqlSession.insert(NAMESPACE + "transferMy", tradeDTO);
	}
	
	public int updateMy(AccountDTO dto) throws Exception{
		
		return sqlSession.update(NAMESPACE + "updateMy", dto);
	}
	
	public int updateYou(AccountDAO dto) throws Exception{
		
		return sqlSession.update(NAMESPACE + "updateYou", dto);
	}

	
}
