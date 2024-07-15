package com.goodee.app.boards.notice;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model, Long page, String kind, String search) throws Exception{
		
		Map<String, Object> map = service.getList(page, kind, search);
		
		model.addAttribute("map", map);
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void getDetail(NoticeDTO dto, Model model) throws Exception{
		
		dto = service.getDetail(dto);
		
		model.addAttribute("dto", dto);
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() throws Exception{
		
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
	public void update(NoticeDTO dto, Model model) throws Exception{
		dto = service.getDetail(dto);
		
		model.addAttribute("dto", dto);
		
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(NoticeDTO dto) throws Exception{
		
		int result = service.update(dto);
		
		return "redirect:/notice/list";
	}

}
