package com.goodee.app.boards.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goodee.app.boards.BoardDAO;
import com.goodee.app.boards.BoardDTO;
import com.goodee.app.boards.BoardFileDTO;
import com.goodee.app.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO{

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.goodee.app.boards.notice.NoticeDAO.";
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception{
		
		return sqlSession.selectList(NAMESPACE + "getList", pager);
	}
	
	@Override
	public Long getTotalCount(Pager pager) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE + "getTotalCount", pager);
	}
	
	@Override
	public BoardDTO getDetail(BoardDTO dto) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE + "getDetail", dto);
	}

	@Override
	public int add(BoardDTO dto) throws Exception{
		
		return sqlSession.insert(NAMESPACE + "add", dto);
	}
	
	@Override
	public int addFile(BoardFileDTO boardFileDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE + "addFile", boardFileDTO);
	}

	@Override
	public int delete(BoardDTO dto) throws Exception{
		
		return sqlSession.delete(NAMESPACE + "delete", dto);
	}
	
	@Override
	public int update(BoardDTO dto) throws Exception{
		
		return sqlSession.update(NAMESPACE + "update", dto);
	}
}
