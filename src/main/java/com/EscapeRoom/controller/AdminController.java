package com.EscapeRoom.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.EscapeRoom.entity.PlayTime;
import com.EscapeRoom.entity.Theme;
import com.EscapeRoom.repository.PlayTimeRepository;
import com.EscapeRoom.repository.ThemeRepository;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	ThemeRepository trepo;
	
	@Autowired
	PlayTimeRepository preop;
	
	// 테마 호출 , 시간호출(진행중)
	@GetMapping("/adminpage")
	public String adminpage(Theme theme,PlayTime playTime, Model model) {
		
		
		
		System.out.println("관리자페이지 이동하기");
		
		List<Theme> themeListAll = trepo.findAll();
		List<PlayTime> playTimeListAll = preop.findAll();
		model.addAttribute("themeListAll", themeListAll);
		model.addAttribute("playTimeListAll", playTimeListAll);
		
		
		return "admin/adminpage";
	}
	
	
	// 테마 CRUD공간
	@PostMapping("/themeInsert")
	@ResponseBody
	public String themeInsert(Theme theme) {
		
		System.out.println("테마 insert 전");
		trepo.save(theme);
		System.out.println(theme);
		System.out.println("테마 insert 완료");
		
		return "themeInsert";
		
	}
	
	@PostMapping("/themeDelete")
	@ResponseBody
	public String themeDelete(Theme theme) {
		
		System.out.println("테마 Delete 전");
		trepo.delete(theme);
		System.out.println(theme);
		System.out.println("테마 Delete 완료");
		
		return "themeDelete";
		
	}
	
	@PostMapping("/oneThemeCall")
	@ResponseBody
	public String oneThemeCall(Theme theme) {
		
		System.out.println("테마 oneThemeCall 전");
		trepo.findById(theme.getThemeNo());
		
		Optional<Theme> theeme1 = trepo.findById(theme.getThemeNo());
		
		System.out.println("테마 oneThemeCall 완료");
		
		return theeme1.get().getThemeName();
		
	}
	
	@PostMapping("/oneThemeUpdate")
	@ResponseBody
	public void oneThemeUpdate(Theme theme) {
		
		System.out.println("테마 oneThemeUpdate 전");
		
		System.out.println("값확인 " + theme);
		
		trepo.save(theme);
		
		System.out.println("테마 oneThemeUpdate 완료");
		
		
		
	}
	
	// 테마 CRUD공간
	
	// 플레이타임 CRUD공간
	
	@PostMapping("/playTimeInsert")
	@ResponseBody
	public String playTimeInsert(PlayTime playTime) {
		System.out.println(playTime);
		System.out.println("playTime insert 전");
		preop.save(playTime);
		System.out.println(playTime);
		System.out.println("playTime insert 완료");
		
		return "aaaa";
		
	}
	
	// 플레이타임 CRUD공간
	
}
