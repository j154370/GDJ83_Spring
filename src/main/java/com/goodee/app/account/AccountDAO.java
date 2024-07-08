package com.goodee.app.account;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goodee.app.member.MemberDTO;

@Repository
public class AccountDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.goodee.app.account.AccountDAO.";
	
	
	public int add(AccountDTO dto) throws Exception{
		
		return sqlSession.insert(NAMESPACE + "add", dto);
	}
	
	public List<AccountDTO> list(MemberDTO dto)throws Exception{
		
		return sqlSession.selectList(NAMESPACE + "list", dto);
		
	}

}
