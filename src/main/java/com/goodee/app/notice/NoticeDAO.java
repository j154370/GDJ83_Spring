package com.goodee.app.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goodee.app.util.Pager;

@Repository
public class NoticeDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private String NAMESPACE = "com.goodee.app.notice.NoticeDAO.";
	
	
	public List<NoticeDTO> getList(Pager pager) throws Exception{
		
		return sqlSession.selectList(NAMESPACE + "getList", pager);
	}
	
	public Long getTotalCount(Pager pager) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE + "getTotalCount", pager);
	}
	
	public NoticeDTO getDetail(NoticeDTO dto) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE + "getDetail", dto);
	}
	
	public int add(NoticeDTO dto) throws Exception{
		
		return sqlSession.insert(NAMESPACE + "add", dto);
	}
	
	public int delete(NoticeDTO dto) throws Exception{
		
		return sqlSession.delete(NAMESPACE + "delete", dto);
	}
	
	public int update(NoticeDTO dto) throws Exception{
		
		return sqlSession.update(NAMESPACE + "update", dto);
	}
}
