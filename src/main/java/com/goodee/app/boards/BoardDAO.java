package com.goodee.app.boards;

import java.util.List;

import com.goodee.app.util.Pager;

public interface BoardDAO {
	
	
	// totalCount가져오는 메서드
	Long getTotalCount(Pager pager) throws Exception;
	
	// public abstract은 무조건 들어가기 때문에 생략이 가능함
	List<BoardDTO> getList(Pager pager) throws Exception;
	
	BoardDTO getDetail(BoardDTO dto) throws Exception;
	
	int add(BoardDTO dto) throws Exception;
	
	int update(BoardDTO dto) throws Exception;
	
	int delete(BoardDTO dto) throws Exception;

}
