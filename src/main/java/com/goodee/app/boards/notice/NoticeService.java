package com.goodee.app.boards.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.goodee.app.boards.BoardDAO;
import com.goodee.app.boards.BoardDTO;
import com.goodee.app.boards.BoardService;
import com.goodee.app.util.Pager;

@Service
public class NoticeService implements BoardService{
	
	@Autowired
	@Qualifier("noticeDAO")
	private BoardDAO boardDAO;
	
	
	public List<BoardDTO> getList(Pager pager) throws Exception{
		
		pager.makeRow();
		
		long totalCount = boardDAO.getTotalCount(pager);
		
		pager.makeNum(totalCount);
		
		return boardDAO.getList(pager);
	}
	
	public BoardDTO getDetail(BoardDTO dto) throws Exception{
		
		return boardDAO.getDetail(dto);
	}
	
	public int add(BoardDTO dto) throws Exception{
		
		return boardDAO.add(dto);
	}
	
	public int delete(BoardDTO dto) throws Exception{
		
		return boardDAO.delete(dto);
	}
	
	public int update(BoardDTO dto) throws Exception{
		
		return boardDAO.update(dto);
	}

}
