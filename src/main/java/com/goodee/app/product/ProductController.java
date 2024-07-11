package com.goodee.app.product;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@RequestMapping("list")
	public void getList(Model model, Long page) throws Exception{
		Map<String, Object> map = service.getList(page);
		
		model.addAttribute("map", map);
	}
	
	@RequestMapping("detail")
	public String getDetail(Model model, ProductDTO dto) throws Exception{
		ProductDTO dto2 = service.getDetail(dto);
		
		String path = "commons/message";
		if(dto2 != null) {
			model.addAttribute("dto", dto2);
			path = "product/detail";
		}else {
			model.addAttribute("result", "해당 데이터를 찾을 수 없습니다.");
			model.addAttribute("url", "/product/list");
		}
		
		return path;
		
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() throws Exception{
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(Model model, ProductDTO dto) throws Exception{
		int result = service.add(dto);
		
		String path = "commons/message";
		
		if(result > 0) {
			path = "redirect:/product/list";
		} else {
			model.addAttribute("result", "데이터 추가에 실패하였습니다.");
			model.addAttribute("url", "/product/list");
		}
		return path;
	}
	
	@RequestMapping("delete")
	public String delete(Model model, ProductDTO dto) throws Exception{
		int result = service.delete(dto);
		
		String path = "commons/message";
		
		if(result > 0) {
			path = "redirect:/product/list";
		}else {
			model.addAttribute("result", "데이터 삭제에 실패하였습니다.");
			model.addAttribute("url", "/product/list");
		}
		
		return path;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(Model model, ProductDTO dto) throws Exception{
		ProductDTO dto2 = service.getDetail(dto);
		
		String path = "commons/message";
		if(dto2 != null) {
			model.addAttribute("dto", dto2);
			path = "product/update";
		}else {
			model.addAttribute("result", "데이터 삭제에 실패하였습니다.");
			model.addAttribute("url", "/product/list");
		}
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(ProductDTO dto) throws Exception{
		int result = service.update(dto);
		
		return "redirect:/product/list";
	}
}
