package com.ssafy.happyhouse.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.happyhouse.model.dto.HouseInfoDto;
import com.ssafy.happyhouse.model.service.HouseMapService;

@Controller
@RequestMapping("/house")
public class HouseController {
	HouseMapService houseMapService;
	
	@Autowired
	public void setHouseMapService(HouseMapService houseMapService) {
		this.houseMapService = houseMapService;
	}
	
	@GetMapping("/search.do")
	public String search(String search_type, String address, String house_type, String sales_type, Model model) throws Exception {
		System.out.println(search_type+","+address+","+house_type+","+sales_type+"zzzzzz");
		
		if("all".equals(search_type)) {
			List<HouseInfoDto> list = houseMapService.getListByDong(address); 
			List<HouseInfoDto> list2 = houseMapService.getListByName(address); 
			
			list.addAll(list2);
			
			model.addAttribute("list", list);
		}else if("dong".equals(search_type)) {
			List<HouseInfoDto> list = houseMapService.getListByDong(address); 
			model.addAttribute("list", list);			
		}else if("name".equals(search_type)) {
			List<HouseInfoDto> list = houseMapService.getListByName(address); 
			model.addAttribute("list", list);			
		}
		return "search";
	}
}
