package com.EscapeRoom.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.EscapeRoom.entity.QnA;
import com.EscapeRoom.repository.QnaRepository;



@Controller
@RequestMapping("/qna")
public class qnaController {
	
	@Autowired
	QnaRepository qrepo;
	
	@GetMapping("/qnaContentPage")
	public String qnaPage(Model model) {
		
		System.out.println("qna페이지 접근");
		
		List<QnA> qnaAllList = qrepo.findAll();
		model.addAttribute("qnaAllList", qnaAllList);
		
		return "/qna/qnaContentPage";
		
	}
	
	@GetMapping("/qnaInsertPage")
	public String qnaInsertPage(Model model) {
		
		System.out.println("/qnaInsertPage페이지 접근");
		
		
		return "/qna/qnaInsertPage";
		
	}
	
	@GetMapping("/qnaLeadOnePage")
	public String qnaLeadOne(Model model, QnA qna) {
		
		
		Optional<QnA> selectByOne = qrepo.findById(qna.getQnaNo());
		System.out.println("11111111111111"+selectByOne);
		model.addAttribute("selectByOne", selectByOne.get());
		
		System.out.println("/qnaLeadOnePage페이지 접근");
		
		
		return "/qna/qnaLeadOnePage";
		
	}
	
	@GetMapping("/qnaLeadOneModifyPage")
	public String qnaLeadOneModifyPage(Model model, QnA qna) {
		
		Optional<QnA> selectByOne = qrepo.findById(qna.getQnaNo());
		System.out.println("11111111111111"+selectByOne);
		model.addAttribute("selectByOne", selectByOne.get());
		
		System.out.println("/qnaLeadOneModifyPage페이지 접근");
		
		return "/qna/qnaLeadOneModifyPage";
		
	}
	
	@PostMapping("/qnaInsert")
	public String qnaInsert(QnA qna) {
		
		qna.setQnaStatus("미답변");
		qrepo.save(qna);
		
		return "redirect:qna/qnaContentPage";
	}
	
}
