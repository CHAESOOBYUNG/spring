package com.coding404.freeboard.service;

import java.util.ArrayList;

import com.coding404.command.FreeBoardVO;
import com.coding404.util.Criteria;

public interface FreeBoardMapper {
	
	public int regist(FreeBoardVO vo); //등록
	//public ArrayList<FreeBoardVO> getList(); //목록
	public ArrayList<FreeBoardVO> getList(Criteria cri); //목록
	public int getTotal(Criteria cri); //전체게시글 수
	
	public FreeBoardVO getContent(int bno); //상세
	public int update(FreeBoardVO vo);//수정
	public int delete(int bno); //삭제
}
