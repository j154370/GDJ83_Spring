package com.goodee.app.boards.notice;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.goodee.app.boards.BoardDAO;
import com.goodee.app.boards.BoardDTO;
import com.goodee.app.boards.BoardFileDTO;
import com.goodee.app.boards.BoardService;
import com.goodee.app.files.FileManager;
import com.goodee.app.util.Pager;

@Service
public class NoticeService implements BoardService{
	
	@Autowired
	@Qualifier("noticeDAO")
	private BoardDAO boardDAO;
	
	@Autowired
	private FileManager fileManager;
	
	
	public List<BoardDTO> getList(Pager pager) throws Exception{
		
		pager.makeRow();
		
		long totalCount = boardDAO.getTotalCount(pager);
		
		pager.makeNum(totalCount);
		
		return boardDAO.getList(pager);
	}
	
	public BoardDTO getDetail(BoardDTO dto) throws Exception{
		
		return boardDAO.getDetail(dto);
	}
	
	public int add(BoardDTO dto, MultipartFile[] files, HttpSession session) throws Exception{
		
		int result = boardDAO.add(dto);
		
		if(files == null) {
			return result;
		}
		
		ServletContext servletContext = session.getServletContext();
		
		String path = servletContext.getRealPath("resources/upload/Notice");
		System.out.println(path);
		
		for(MultipartFile f : files) {	
			if(f.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.fileSave(path, f);
			
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFile_name(fileName);
			boardFileDTO.setOri_name(f.getOriginalFilename());
			boardFileDTO.setBoard_num(dto.getBoard_num());
			result = boardDAO.addFile(boardFileDTO);
		
		}
		
		
		return result;
	}
	
	public int delete(BoardDTO dto) throws Exception{
		
		return boardDAO.delete(dto);
	}
	
	public int update(BoardDTO dto) throws Exception{
		
		return boardDAO.update(dto);
	}

}
