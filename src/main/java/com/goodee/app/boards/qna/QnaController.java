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
import org.springframework.web.multipart.MultipartFile;

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
		
		return "Qna";
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
	public String add(QnaDTO qnaDTO, HttpSession session, MultipartFile[] files)throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("dto");
		qnaDTO.setBoard_writer(memberDTO.getUser_id());
		int result = qnaService.add(qnaDTO, files, session);

		return "redirect:./list";
	}
	
	@GetMapping("update")
	public String update(QnaDTO qnaDTO, Model model) throws Exception{
		
		BoardDTO boardDTO = qnaService.getDetail(qnaDTO);
		
		model.addAttribute("dto", boardDTO);
		
		return "board/add";
	}
	
	@PostMapping("update")
	public String update(QnaDTO qnaDTO) throws Exception {
		
		int result = qnaService.update(qnaDTO);
		
		return "redirect:/qna/list";
	}
	
	@GetMapping("delete")
	public String delete(QnaDTO qnaDTO) throws Exception{
		
		int result = qnaService.delete(qnaDTO);
		
		return "redirect:/qna/list";
	}
	
	@GetMapping("reply")
	public String reply(QnaDTO qnaDTO, Model model) throws Exception{
		
		model.addAttribute("dto", qnaDTO);
		
		return "board/add";
	}
	
	@PostMapping("reply")
	public String reply(QnaDTO qnaDTO, HttpSession session) throws Exception{
		
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("dto");
		qnaDTO.setBoard_writer(memberDTO.getUser_id());
		int result = qnaService.reply(qnaDTO);
		
		return "redirect:./list";
	}

}
