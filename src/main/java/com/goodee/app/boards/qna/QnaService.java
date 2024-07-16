package com.goodee.app.boards.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodee.app.boards.BoardDTO;
import com.goodee.app.boards.BoardService;
import com.goodee.app.util.Pager;

@Service
public class QnaService implements BoardService{
	
	@Autowired
	private QnaDAO qnaDAO;

	
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
	public int add(BoardDTO dto) throws Exception {
	
		return qnaDAO.add(dto);
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
	
	

}
