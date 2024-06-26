package com.goodee.app.departments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping("detail") // "int department_id" 는 parameter값으로, 변수 명과 일치해야만 한다.
	public String getDeatil(Model model, int department_id) throws Exception{
		
		DepartmentDTO dto = service.getDetail(department_id);
		
		String path = "commons/message";
		if(dto != null) {
			model.addAttribute("dto" , dto);	
			path = "department/detail";
		}else {
			model.addAttribute("result", "부서를 찾을 수 없습니다.");
			model.addAttribute("url", "/department/list");
		}
		
		return path;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() {
		// list페이지에서 등록 버튼을 누르면 이 메소드가 작동한다.
		// 단순히 add페이지로 이동하는게 전부이기 때문에 메소드 안에 내용은 없다.
		// 리턴 타입이 void면 자동으로 add 페이지로 이동하기 때문
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(Model model, DepartmentDTO dto) throws Exception{
		
		int result = service.add(dto);
		
		String url = "commons/message";
		if(result > 0) {
			url="redirect:/department/list";
		}else {
			model.addAttribute("result", "부서 등록 실패");
			model.addAttribute("url", "/department/list");
		}
		
		return url;
	}
	
	@RequestMapping("delete")
	public String delete(Model model, DepartmentDTO dto) throws Exception{
		int result = service.delete(dto);
		
		String url = "commons/message";
		if(result > 0) {
			url = "redirect:/department/list";
		}else {
			model.addAttribute("result", "부서 삭제 실패");
			model.addAttribute("url", "/department/list");
		}
		return url;
	}
	
	@RequestMapping("update")
	public String update(Model model, int department_id) throws Exception{
		DepartmentDTO dto = service.getDetail(department_id);
		
		String url = "commons/message";
		if(dto != null) {
			model.addAttribute("dto", dto);
			url = "department/update";
		}else {
			model.addAttribute("result", "수정 실패");
			model.addAttribute("url", "/department/list");
		}
		
		return url;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(DepartmentDTO dto) throws Exception{
		int result = service.update(dto);
		
		return "redirect:list";
		
	}
	
}
