package com.goodee.app.departments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/department/*")
public class DepartmentController {
	
	@Autowired
	private DepartmentService service;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList() throws Exception{
		service.getList();
	}
}
