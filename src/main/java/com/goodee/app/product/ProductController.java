package com.goodee.app.product;

import java.util.List;

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
	public void getList(Model model) throws Exception{
		List<ProductDTO> dtos = service.getList();
		
		model.addAttribute("list", dtos);
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
	
	@RequestMapping("add")
	public void add() {
	}
	
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public void add2() {
		
	}
}
