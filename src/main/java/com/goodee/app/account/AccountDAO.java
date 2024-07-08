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
	
//	마이페이지 조회를 할 때 새로 갱신한다면 이 코드가 필요하고, 로그인을 할 때 자동으로 만들겠다면 이 코드는 필요가 없다.
//	public List<AccountDTO> list(MemberDTO dto)throws Exception{
//		
//		return sqlSession.selectList(NAMESPACE + "list", dto);
//		
//	}

}
