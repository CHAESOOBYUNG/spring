package com.simple.mapper;

import java.util.ArrayList;

import com.simple.command.ScoreVO;

public interface ScoreMapper {
	
	public void regist(ScoreVO vo);
	public ArrayList<ScoreVO> getList(); //์กฐํ
	public void delete(int num); //์ญ์ 
	
}
