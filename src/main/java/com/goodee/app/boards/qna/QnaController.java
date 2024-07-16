package com.goodee.app.boards.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goodee.app.boards.BoardDTO;
import com.goodee.app.member.MemberDTO;
import com.goodee.app.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() {
		
		return "QnA";
	}
	
	
	@GetMapping("list")
	public String getList(Pager pager, Model model) throws Exception{
		
		List<BoardDTO> list = qnaService.getList(pager);
		
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@GetMapping("detail")
	public String getDetail(QnaDTO qnaDTO, Model model) throws Exception{
		
		BoardDTO boardDTO = qnaService.getDetail(qnaDTO);
		model.addAttribute("dto", boardDTO);
		
		return "board/detail";	
	}
	
	@GetMapping("add")
	public String add()throws Exception{
		
		return "board/add";
	}
	
	@PostMapping("add")
	public String add(QnaDTO qnaDTO, HttpSession session)throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("dto");
		qnaDTO.setBoard_writer(memberDTO.getUser_id());
		int result = qnaService.add(qnaDTO);

		return "redirect:./list";
	}
	
	@GetMapping("update")
	public String update() throws Exception{
		
		return "board/update";
	}
	
	@PostMapping("update")
	public String update2() throws Exception {
		
		return "redirect:/qna/list";
	}

}
