package com.goodee.app.boards.qna;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.goodee.app.boards.BoardDTO;
import com.goodee.app.boards.BoardFileDTO;
import com.goodee.app.boards.BoardService;
import com.goodee.app.files.FileDTO;
import com.goodee.app.files.FileManager;
import com.goodee.app.util.Pager;

@Service
public class QnaService implements BoardService{
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private FileManager fileManager;

	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		pager.makeRow();
		
		pager.makeNum(qnaDAO.getTotalCount(pager));
		
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO dto) throws Exception {
		
		return qnaDAO.getDetail(dto);
	}

	@Override
	public int add(BoardDTO dto, MultipartFile[] files, HttpSession session) throws Exception {
		
		int result = qnaDAO.add(dto);
		
		if(files == null) {
			return result;
		}
		
		ServletContext servletContext = session.getServletContext();
		
		String path = servletContext.getRealPath("resources/upload/Qna");
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
			result = qnaDAO.addFile(boardFileDTO);
		
		}
		
		
		return result;
	}

	@Override
	public int delete(BoardDTO dto) throws Exception {
	
		return qnaDAO.delete(dto);
	}

	@Override
	public int update(BoardDTO dto) throws Exception {
	
		return qnaDAO.update(dto);
	}
	
	public int reply(QnaDTO qnaDTO) throws Exception{
		
		QnaDTO parent = (QnaDTO)qnaDAO.getDetail(qnaDTO);
		
		// step을 1씩 업데이트
		int result = qnaDAO.replyUpdate(parent);
		
		
		// 답글의 ref, step, depth를 셋팅
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep()+1);
		qnaDTO.setDepth(parent.getDepth()+1);
		return qnaDAO.reply(qnaDTO);
	}

	@Override
	public FileDTO fileDetail(FileDTO fileDTO) throws Exception {
		
		return qnaDAO.fileDetail(fileDTO);
	}
	
	
	

}
