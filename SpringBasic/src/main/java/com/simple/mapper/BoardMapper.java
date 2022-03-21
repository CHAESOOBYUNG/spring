package com.simple.mapper;

import java.util.ArrayList;

import com.simple.command.BoardVO;

public interface BoardMapper {
	
	public void regist(BoardVO vo);
	public ArrayList<BoardVO> getList(); //조회
	public void delete(int bno); //삭제
}
