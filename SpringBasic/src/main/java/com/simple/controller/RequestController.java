package com.simple.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.ReqVO;

@Controller //컴포넌트 스캔이 읽어서 bean으로 생성한다.
@RequestMapping("/request")
public class RequestController {

	//	@RequestMapping("/test")
	//	public void test() {
	//		
	//		System.out.println("실행됨");
	//	}

	//	void형 메서드는 들어오는 경로를 그대로 리졸버뷰에 반환합니다.
	@RequestMapping("/ex01")
	public void ex01() {
	}

	//	//String형 메서드는 들어가는 경로, 나가는 경로를 각각 지정합니다.
	//	@RequestMapping("/request/ex01")
	//	public String ex01() {
	//		
	//		return "request/ex01";
	//	}
	//}

	
	//GET요청만 받는다.
	@RequestMapping(value="/basic1", method = RequestMethod.GET )
	public void basic1() {
		System.out.println("basic1번실행");
	}
	
	//Post요청만 받는다
	@RequestMapping(value = "/basic2", method = RequestMethod.POST)
	public void basic2() {
		System.out.println("basic2번실행");
	}
	
	//get, post요청 상관없이 둘 다 받아줍니다.
	@RequestMapping("/basic3")
	public void basic3() {
		System.out.println("basic3실행");
	}
	
	//동일한 요청을 하나로 맵핑할 때는 {경로, ....}로 표기할 수 있습니다.
//	@RequestMapping(value = {"/basic1", "/basic2", "basic3"} )
//	public void basic4() {
//		System.out.println("basic요청");
//	}
	
	//==============================파라미터값 처리========================
	//ex02화면 처리하는 메서드
	
	@RequestMapping("ex02")
	public String ex02() {
		
		return "request/ex02";	
	}
	
	//폼태그받기
//	@RequestMapping("/param")
//	public String param(HttpServletRequest request) {
//		
//		String id = request.getParameter("id");
//		String age = request.getParameter("age");
//		String[] inter = request.getParameterValues("inter");
//		
//		System.out.println(id);
//		System.out.println(age);
//		System.out.println( Arrays.toString(inter));
//		
//		return "request/ex02_result"; 
//	}
	
	//2nd - RequestParam(이름) - 필수값이 넘어와야 합니다
//	@RequestMapping("/param")
//	public String param(@RequestParam("id") String id, 
//						@RequestParam("age") int age,
//						@RequestParam(value = "inter", required = false, defaultValue = "") ArrayList<String> list) {
//		
//		//필수가 아닌 파라미터는 required = false 속성을 지정하면 됩니다.
//		//필수가 아닌 파라미터일 경우 null값을 지정하게 되는데 defaultValue로 기본값을 지정할 수 있습니다.
//		
//		System.out.println(id);
//		System.out.println(age);
//		System.out.println(list.toString());
//		
//		
//		return "request/ex02_result"; 
//	}
	
	//3rd - 커맨드객체
	@RequestMapping("/param")
	public String param(ReqVO vo) {
		
		System.out.println(vo.getId());
		System.out.println(vo.getAge());
		System.out.println(vo.getInter().toString());
		
		return "request/ex02_result";
	}
	
	//===================실습=========================
	@RequestMapping("/req_quiz01")
	public String req_quiz01() {
		
		return "request/req_quiz01";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam("id") String id,
						@RequestParam("pw") String pw) {
		if(id.equals("abc123") && pw.equals("xxx123")) {
			
			return "request/req_quiz01_ok";
			
		} else {
			
			return "request/req_quiz01_no";
		}
	}
	
}
