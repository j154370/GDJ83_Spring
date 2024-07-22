package com.goodee.app.boards;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.goodee.app.util.Pager;

public interface BoardService {
	
	
	public List<BoardDTO> getList(Pager pager)throws Exception;
	
	public BoardDTO getDetail(BoardDTO dto)throws Exception;
	
	public int add(BoardDTO dto, MultipartFile[] files, HttpSession session)throws Exception;
	
	public int delete(BoardDTO dto)throws Exception;
	
	public int update(BoardDTO dto) throws Exception;

}
