package com.EscapeRoom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/theme")
public class ThemeController {
	
	@GetMapping("/themepage")
	public String themepage() {
		
		System.out.println("태마페이지 접근");
		
		return "/theme/themepage";
		
	}
}
