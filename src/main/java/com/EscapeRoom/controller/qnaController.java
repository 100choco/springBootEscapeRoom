package com.EscapeRoom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/qna")
public class qnaController {
	
	@GetMapping("/qnapage")
	public String qnapage() {
		
		System.out.println("qna페이지 접근");
		
		return "/qna/qnapage";
		
	}
}
