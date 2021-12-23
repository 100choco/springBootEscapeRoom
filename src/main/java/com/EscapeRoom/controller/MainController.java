package com.EscapeRoom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String mainpage() {
		
		System.out.println("메인페이지 접근");
		
		return "/main/mainpage";
		
	}
}
