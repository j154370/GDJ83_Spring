package com.goodee.app.boards.notice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.goodee.app.boards.BoardDTO;
import com.goodee.app.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	@ModelAttribute("board")
	public String getBoard() {
		
		return "Notice";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList(Model model, Pager pager) throws Exception{
		
		
		List<BoardDTO> list = service.getList(pager);
		
		model.addAttribute("pager",pager);
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail(NoticeDTO dto, Model model) throws Exception{
		
		BoardDTO boardDTO = service.getDetail(dto);
		
		model.addAttribute("dto", boardDTO);
		
		return "board/detail";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() throws Exception{
		
		return "board/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(NoticeDTO dto, Model model) throws Exception{
		
		int result = service.add(dto);
		
		model.addAttribute("dto", dto);
		
		return "redirect:/notice/list"; 
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(NoticeDTO dto) throws Exception{
		
		int result = service.delete(dto);
		
		return "redirect:/notice/list";
		
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(NoticeDTO dto, Model model) throws Exception{
		BoardDTO boardDTO = service.getDetail(dto);
		
		model.addAttribute("dto", boardDTO);
		
		return "board/add";
		
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(NoticeDTO dto) throws Exception{
		
		int result = service.update(dto);
		
		return "redirect:/notice/list";
	}

}
