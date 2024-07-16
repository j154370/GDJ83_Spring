package com.goodee.app.boards.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goodee.app.boards.BoardDAO;
import com.goodee.app.boards.BoardDTO;
import com.goodee.app.util.Pager;

@Repository
public class QnaDAO implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.goodee.app.boards.qna.QnaDAO.";

	@Override
	public Long getTotalCount(Pager pager) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE + "getTotalCount", pager);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		return sqlSession.selectList(NAMESPACE + "getList", pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO dto) throws Exception {
	
		return sqlSession.selectOne(NAMESPACE + "getDetail", dto);
	}

	@Override
	public int add(BoardDTO dto) throws Exception {
		
		return sqlSession.insert(NAMESPACE + "add", dto);
	}

	@Override
	public int update(BoardDTO dto) throws Exception {
		
		return 0;
	}

	@Override
	public int delete(BoardDTO dto) throws Exception {
		
		return 0;
	}
	
	
	

}
