package com.EscapeRoom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/signUp")
public class SignUpController {
	
	@GetMapping("/signUpPage")
	public String SignUpPage() {
		
		System.out.println("회원가입 진입");
		
		return "/signUp/signUpPage";
	}
	
}
