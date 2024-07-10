package com.goodee.app.account;

import java.util.List;

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
	
	
	// service transfer 관련 DAO 메서드
	public int transferMy(TradeDTO tradeDTO) throws Exception{
		
		return sqlSession.insert(NAMESPACE + "transferMy", tradeDTO);
	}
	
	public int transferYou(TradeDTO tradeDTO) throws Exception{
		
		return sqlSession.insert(NAMESPACE + "transferYou", tradeDTO);
	}
	
	public int updateMy(TradeDTO tradeDTO) throws Exception{
		
		return sqlSession.update(NAMESPACE + "updateMy", tradeDTO);
	}
	
	public int updateYou(TradeDTO tradeDTO) throws Exception{
		
		return sqlSession.update(NAMESPACE + "updateYou", tradeDTO);
	}
	
	//거래내역 조회 메서드
	public List<TradeDTO> getList(ListOption listOption) throws Exception{
		
		return sqlSession.selectList(NAMESPACE + "getList", listOption);
	}

	
}
