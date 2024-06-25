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
}
