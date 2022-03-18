package com.simple.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.BoardVO;
import com.simple.service.BoardService;

@Controller
@RequestMapping("/service")
public class BoardServiceController {
	
	@Autowired
	@Qualifier("boardService")
	BoardService boardService;
	
	//boardRegister 화면처리(등록)
	@RequestMapping("/boardRegister")
	public void boardRegister() {
		
	}
	
	//화면치리(결과)
	@RequestMapping("/boardResult")
	public void boardResult() {
		
	}
	
	//화면처리(목록)
	@RequestMapping("/boardList")
	public String boardList(Model model) {
		
		//결과반환
		ArrayList<BoardVO> list = boardService.getList();
		model.addAttribute("list", list);
		
		return "service/boardList";
		
	}
	
	//화면처리(삭제)
	@RequestMapping("/boardDelete")
	public String boardDelete(@RequestParam("bno") int bno) {
		
		boardService.boardDelete(bno);
		
		return "redirect:/service/boardList";
		
	}
	
	//boardRegister 폼처리
	@RequestMapping(value="/boardForm", method=RequestMethod.POST)
	public String boardForm(BoardVO vo) {
		
		boardService.boardRegist(vo);
		
		return "redirect:/service/boardResult";
	}
	
	
	
	
}
