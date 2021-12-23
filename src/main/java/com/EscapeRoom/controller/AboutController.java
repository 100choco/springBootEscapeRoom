package com.EscapeRoom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/about")
public class AboutController {
	
	@GetMapping("/aboutpage")
	public String mainpage() {
		
		System.out.println("어바웃페이지 접근");
		
		return "/about/aboutpage";
		
	}
}
