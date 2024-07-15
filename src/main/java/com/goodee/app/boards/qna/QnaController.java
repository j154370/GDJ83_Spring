package com.goodee.app.boards.qna;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	
	@GetMapping("list")
	public String getList() throws Exception{
		
		return "board/list";
	}
	
	@GetMapping("detail")
	public String getDetail() throws Exception{
		
		return "board/detail";	
	}
	
	@GetMapping("add")
	public String add()throws Exception{
		
		return "board/add";
	}
	
	@PostMapping("add")
	public String add2()throws Exception{

		return "redirect:/qna/list";
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
