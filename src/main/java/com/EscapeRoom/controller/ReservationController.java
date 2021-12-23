package com.EscapeRoom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	
	@GetMapping("/reservationpage")
	public String reservationpage() {
		
		System.out.println("reservation페이지 접근");
		
		return "/reservation/reservationpage";
		
	}
}
