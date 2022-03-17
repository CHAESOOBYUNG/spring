package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.Quiz01VO;
import com.simple.command.Quiz02VO;
import com.simple.command.Quiz03VO;

@Controller
@RequestMapping("/quiz")
public class QuizController {
	
	//퀴즈01 화면처리
	@RequestMapping("/quiz01")
	public void quiz01() {
		
	}
	
	//퀴즈01 폼처리
	@RequestMapping("/sendBirth")
	public String sendBirth(Quiz01VO vo, Model model) {
		
		System.out.println(vo.getYear() + vo.getMonth() + vo.getDay());
		model.addAttribute("birth", vo); //데이터를 담는다.
		
		
		return "quiz/quiz01_ok"; //경로
	}
	
	//퀴즈02  화면처리
	@RequestMapping("/quiz02")
	public void quiz02() {
		
	}
	
	//퀴즈02 폼처리
	@RequestMapping("/join")
	public String join(@ModelAttribute("vo2") Quiz02VO vo2) {
		
		return "quiz/quiz02_ok";
	}
	
	//퀴즈03 화면처리
	@RequestMapping("/quiz03")
	public void quiz03() {
		
	}
	
	//퀴즈03 폼처리
	@RequestMapping("/join2")
	public String join2(@RequestParam(value="id", required = false, defaultValue = "") String id,
						@RequestParam("pw") String pw,
						@RequestParam("pw_check") String pw_check,
						RedirectAttributes RA,
						Model model ) {
		
		if(id.equals("")) { //아이디를 적지않은 경우
			
			RA.addFlashAttribute("msg", "아이디를 확인하세요");
			
			return "redirect:/quiz/quiz03"; //리다이렉트 이동
			
		} else if( !pw.equals(pw_check) ) { //체크가 다른경우
			
			RA.addFlashAttribute("msg", "비밀번호를 확인하세요");
			return "redirect:/quiz/quiz03"; //리다이렉트 이동
			
		} else {
			
			model.addAttribute("msg", id + "님 환영합니다");
			return "quiz/quiz03_ok"; //포워드 이동
		}
				
	}
	
}
