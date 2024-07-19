package com.goodee.app.member;

import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.goodee.app.member.MemberDAO.";
	
	public int join(MemberDTO dto) throws Exception{
		
		return sqlSession.insert(NAMESPACE + "join", dto);
	}
	
	public MemberDTO login(MemberDTO dto) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE + "login", dto);
	}
	
	public int update(MemberDTO dto) throws Exception{
		
		return sqlSession.update(NAMESPACE + "update", dto);
		
	}
	
	public int delete(MemberDTO dto) throws Exception{
		
		return sqlSession.delete(NAMESPACE + "delete", dto);
	}
	
	public MemberDTO detail(MemberDTO dto) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE + "detail", dto);
	}
	
	public int addFile(MemberFileDTO memberFileDTO) throws Exception{
		
		return sqlSession.insert(NAMESPACE + "addFile", memberFileDTO); 
	}

}
