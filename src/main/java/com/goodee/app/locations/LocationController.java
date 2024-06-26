package com.goodee.app.locations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/location/*")
public class LocationController {
	
	@Autowired
	private LocationService service;

	@RequestMapping("list")
	public void getList(Model model) throws Exception{
		List<LocationDTO> dtos = service.getList();
		
		model.addAttribute("list", dtos);
		
		// return을 생략하면 url 주소와 일치하는 jsp 값을 자동으로 리턴한다.	
	}
	
	
	
	@RequestMapping("detail")
	public String getDetail(Model model, int location_id) throws Exception{
		LocationDTO dto = service.getDetail(location_id);

		String path = "commons/message";
		if(dto != null) {
			model.addAttribute("dto", dto);
			path = "location/detail";
		}else {
			model.addAttribute("result", "원하는 값을 찾을 수 없습니다.");
			model.addAttribute("url", "/location/list");
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
	public String add(Model model, LocationDTO dto) throws Exception{
		// add 페이지에서 데이터를 입력하고 submit을 누를때 작동하는 메소드
		int result = service.add(dto);
		
		String url = "commons/message";
		if(result > 0) {
			url = "redirect:/location/list";
		}else {
			model.addAttribute("result", "정보 등록 실패");
			model.addAttribute("url", "/location/list");
		}
		
		return url;
		
	}
}
