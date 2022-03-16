package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("/")
	public String home() {
		
		
		System.out.println("실행됨");;
		
		//return "/WEB-INF/jsp/home.jsp"; //디스패처 서플릿으로 돌아갈 경로
		return "home";
	}
}
