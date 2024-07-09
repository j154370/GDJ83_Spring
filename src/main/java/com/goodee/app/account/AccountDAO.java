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
	
	public void transferMy() throws Exception{
		
	}
	
	public void transferYou() throws Exception{
		
	}
	
	public void updateMy() throws Exception{
		
	}
	
	public void updateYou() throws Exception{
		
	}

	
}
