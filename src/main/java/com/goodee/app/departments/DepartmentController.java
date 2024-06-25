package com.goodee.app.departments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/department/*")
public class DepartmentController {
	
	@Autowired
	private DepartmentService service;
	
	@RequestMapping("list")
	public void getList(Model model) throws Exception{
		List<DepartmentDTO> dtos = service.getList();
		
		model.addAttribute("list", dtos);
		
		// return을 생략하면 url 주소와 일치하는 jsp 값을 자동으로 리턴한다.
		
	}
}
