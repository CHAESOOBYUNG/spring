package com.coding404.freeboard.service;

import java.util.ArrayList;

import com.coding404.command.FreeBoardVO;

public interface FreeBoardService {

	public int regist(FreeBoardVO vo); //등록
	public ArrayList<FreeBoardVO> getList(); //목록
	public FreeBoardVO getContent(int bno); //상세
	public int update(FreeBoardVO vo);//수정
	public int delete(int bno); //삭제
}
