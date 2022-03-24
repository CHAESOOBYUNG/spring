package com.coding404.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coding404.command.FreeBoardVO;
import com.coding404.freeboard.service.FreeBoardService;
import com.coding404.util.Criteria;
import com.coding404.util.PageVO;

@Controller
@RequestMapping("/freeBoard")
public class FreeBoardController {
	
	@Autowired
	@Qualifier("freeBoardService")
	FreeBoardService freeBoardService;
	
	//화면처리
	@RequestMapping("/freeRegist")
	public String freeRegist() {
		return "freeBoard/freeRegist";
	}
	
	//화면처리(목록)
	@RequestMapping("/freeList")
	public String freeList(Model model, Criteria cri) {
		
		System.out.println(cri.toString());
		
		//데이터를 가지고 나감
		//페이지 없는 모형
		//ArrayList<FreeBoardVO> list = freeBoardService.getList();
		
		//페이지가 달린 모형
		ArrayList<FreeBoardVO> list = freeBoardService.getList(cri);
		
		//페이지네이션 생성(전체 게시글 수)
		int total = freeBoardService.getTotal(cri);
		PageVO pageVO = new PageVO(cri, total);
		
		
		model.addAttribute("list", list);
		model.addAttribute("pageVO", pageVO);
		
		
		return "freeBoard/freeList";
	}
	
//	//화면처리(상세보기)
//	@RequestMapping("/freeDetail")
//	public String freeDetail(@RequestParam("bno") int bno, Model model) {
//		
//		/*
//		 * 1. bno키를 받아서 getContent() 호출
//		 * 2. 마이바티스에서 bno에 대한 결과를 조회해서 vo에 저장(화면에 vo를 전달)
//		 * 3. 화면에서는 결과값을 띄워주면 됩니다.
//		 */
//		
//		FreeBoardVO vo = freeBoardService.getContent(bno);
//		model.addAttribute("vo", vo);
//		
//		
//		return "freeBoard/freeDetail";
//	}
//	
//	@RequestMapping("/freeModify")
//	public String freeModify(@RequestParam("bno") int bno, Model model) {
//		
//		FreeBoardVO vo = freeBoardService.getContent(bno);
//		model.addAttribute("vo", vo);
//		
//		return "freeBoard/freeModify";
//	}
	
	//화면처리(상세, 변경) 기능이 같다면 묶어서 사용할 수 있습니다.
	@RequestMapping({"/freeDetail", "/freeModify"})
	public void getContent(@RequestParam("bno") int bno, Model model) {
		
		FreeBoardVO vo = freeBoardService.getContent(bno);
		System.out.println(vo.toString());
		model.addAttribute("vo", vo);
	}
	
	//등록폼
	@RequestMapping(value="/registForm", method = RequestMethod.POST)
	public String registForm(FreeBoardVO vo, RedirectAttributes RA) {
		
		int result = freeBoardService.regist(vo);
		
		//result는 성공 실패 결과
		if(result == 1) {
			RA.addFlashAttribute("msg", "게시글이 등록처리 되었습니다"); //리다이렉트시 1회성 데이터
		} else {
			RA.addFlashAttribute("msg", "게시글 등록에 실패했습니다");
		}
		
		return "redirect:/freeBoard/freeList"; //리다이렉트
	}
	
	//수정폼
	@RequestMapping(value = "/updateForm", method = RequestMethod.POST)
	public String updateForm(FreeBoardVO vo, RedirectAttributes RA) {
		
		/*
		 * 1. 화면에서 넘어오는 데이터를 받습니다. VO
		 * 2. update(vo) 메서드를 통해서 업데이트 작업을 수행합니다.
		 * 3. 성공, 실패 결과를 받아서, 성공시 성공메시지와 함께 list화면으로 리다이렉트.
		 *    실패시 실패메시지와 함께 list화면으로 리다이렉트
		 */
		int result = freeBoardService.update(vo);
		
		//result 결과
		if(result == 1) {
			RA.addFlashAttribute("msg", "게시글이 수정되었습니다");
		} else {
			RA.addFlashAttribute("msg", "게시글 수정에 실패했습니다");
		}
		
		return "redirect:/freeBoard/freeList"; 
		//return redirect:/freeBoard/freeDetail?bno=" + vo.getBno();
	}
	
	//삭제폼
	@RequestMapping(value="/deleteForm", method = RequestMethod.POST)
	public String deleteForm(@RequestParam("bno") int bno, RedirectAttributes RA) {
		
		/*
		 * 1. bno로 삭제를 진행합니다.
		 * 2. 삭제 성공시 성공메시지와 함께 list화면으로 리다이렉트
		 *    삭제 실패시 실패메시지와 함께 modify화면으로 리다이렉트
		 */
		int result = freeBoardService.delete(bno);
		
		//result 결과
		if(result == 1) {
			RA.addFlashAttribute("msg", "게시글이 삭제되었습니다");
			return "redirect:/freeBoard/freeList";
		} else {
			RA.addFlashAttribute("msg", "게시글 삭제에 실패하셨습니다");
			return "redirect:/freeBoard/freeModify?bno=" + bno;
		}
	
	}
	
}
