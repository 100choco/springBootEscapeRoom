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

import com.EscapeRoom.entity.Difficulty;
import com.EscapeRoom.entity.OperatingTime;
import com.EscapeRoom.entity.PlayTime;
import com.EscapeRoom.entity.Theme;
import com.EscapeRoom.repository.DifficultyRepository;
import com.EscapeRoom.repository.OperatingTimeRepository;
import com.EscapeRoom.repository.PlayTimeRepository;
import com.EscapeRoom.repository.ThemeRepository;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	ThemeRepository trepo;
	
	@Autowired
	PlayTimeRepository prepo;
	
	@Autowired
	DifficultyRepository drepo;
	
	@Autowired
	OperatingTimeRepository orepo;
	
	// 테마 호출 , 시간호출(진행중)
	@GetMapping("/themeRoom/themeRoomPage")
	public String adminpage(Theme theme,PlayTime playTime, Model model, Difficulty defficulty, OperatingTime operatingTime) {
		
		System.out.println("관리자페이지 이동하기");
		
		List<Theme> themeListAll = trepo.findAll();
		List<PlayTime> playTimeListAll = prepo.findAll();
		List<Difficulty> difficultyListAll = drepo.findAll();
		List<OperatingTime> operatingTimeListAll = orepo.findAll();
		model.addAttribute("themeListAll", themeListAll);
		model.addAttribute("playTimeListAll", playTimeListAll);
		model.addAttribute("difficultyListAll", difficultyListAll);
		model.addAttribute("operatingTimeListAll", operatingTimeListAll);
		
		
		return "/admin/themeRoom/themeRoomPage";
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
		prepo.save(playTime);
		System.out.println(playTime);
		System.out.println("playTime insert 완료");
		
		return "aaaa";
		
	}
	
	@PostMapping("/onePlayTimeCall")
	@ResponseBody
	public int onePlayTimeCall(PlayTime playTime) {
		
		System.out.println("플레이타임 부르기 전");
		
		trepo.findById(playTime.getPlayTimeNo());
		
		Optional<PlayTime> theeme1 = prepo.findById(playTime.getPlayTimeNo());
		
		System.out.println("플레이타임 부르기 완료");
		
		return theeme1.get().getPlayTime();
		
	}
	
	
	@PostMapping("/onePlayTimeUpdate")
	@ResponseBody
	public void onePlayTimeUpdate(PlayTime playTime) {
		
		System.out.println("테마 oneThemeUpdate 전");
		
		System.out.println("값확인 " + playTime);
		
		prepo.save(playTime);
		
		System.out.println("테마 oneThemeUpdate 완료");
		
		
		
	}
	
	@PostMapping("/playTimeDelete")
	@ResponseBody
	public String playTimeDelete(PlayTime playTime) {
		
		System.out.println("이용시간 delete 전");
		prepo.delete(playTime);
		System.out.println(playTime);
		System.out.println("이용시간 delete 완료");
		
		return "difficulty";
		
	}
	
	// 플레이타임 CRUD공간
	
	// 난이도 CRUD공간
	@PostMapping("/difficultyInsert")
	@ResponseBody
	public String difficultyInsert(Difficulty difficulty) {
		
		System.out.println("어려움 insert 전");
		drepo.save(difficulty);
		System.out.println("==========11111111"+difficulty);
		System.out.println("어려움 insert 완료");
		
		return "difficulty";
		
	}
	
	@PostMapping("/difficultydelete")
	@ResponseBody
	public String difficultydelete(Difficulty difficulty) {
		
		System.out.println("어려움 delete 전");
		drepo.delete(difficulty);
		System.out.println(difficulty);
		System.out.println("테마 delete 완료");
		
		return "difficulty";
		
	}
	
	// 운영시간 crud
	
	@PostMapping("/operatingInsert")
	@ResponseBody
	public String operatingInsert(OperatingTime operatingTime) {
		
		System.out.println("운영시간 insert 전");
		orepo.save(operatingTime);
		System.out.println(operatingTime);
		System.out.println("운영시간 insert 완료");
		
		return "themeInsert";
		
	}
	
	
	  @PostMapping("/operatingTimedelete")
	  @ResponseBody public String operatingTimedelete(OperatingTime operatingTime) {
	  
	  System.out.println("운영시간 Delete 전"); orepo.delete(operatingTime);
	  System.out.println(operatingTime); System.out.println("테마 Delete 완료");
	  
	  return "operatingTimedelete";
	  
	  }
	 
	
	
	  @PostMapping("/oneOperatingTimeCall")
	  @ResponseBody public int oneOperatingTimeCall(OperatingTime operatingTime) {
	  
	  System.out.println("operatingTime oneoperatingTimeCall 전");
	  
	  trepo.findById(operatingTime.getOperatingTimeNo());
	  
	  Optional<OperatingTime> oper = orepo.findById(operatingTime.getOperatingTimeNo());
	  
	  System.out.println("operatingTime oneoperatingTimeCall 완료");
	  
	  return oper.get().getOperatingTime();
	  
	  }
	 
	
	
	  @PostMapping("/oneOperatingTimeUpdate")
	  @ResponseBody public void oneOperatingTimeUpdate(OperatingTime operatingTime) {
	  
	  System.out.println("OperatingTime 전");
	  
	  System.out.println("값확인 " + operatingTime);
	  
	  orepo.save(operatingTime);
	  
	  System.out.println("OperatingTime 완료");
	  
	  
	  
	  }
	 
	
	
	// 통합 출력
		@GetMapping("/createRoom/createRoomPage")
		public String createRoompage(Theme theme,PlayTime playTime, Model model, Difficulty defficulty, OperatingTime operatingTime) {
			
			System.out.println("createRoom 이동하기");
			
			List<Theme> themeListAll = trepo.findAll();
			List<PlayTime> playTimeListAll = prepo.findAll();
			List<Difficulty> difficultyListAll = drepo.findAll();
			List<OperatingTime> operatingTimeListAll = orepo.findAll();
			model.addAttribute("themeListAll", themeListAll);
			model.addAttribute("playTimeListAll", playTimeListAll);
			model.addAttribute("difficultyListAll", difficultyListAll);
			model.addAttribute("operatingTimeListAll", operatingTimeListAll);
			
			return "/admin/createRoom/createRoomPage";
		}
	
	
}
