package com.simple.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simple.command.ScoreVO;
import com.simple.dao.ScoreDAO;

@Service("scoreService") //bean의 id를 scoreService로 생성
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	@Qualifier("aaa")
	ScoreDAO scoreDAO;
	
	@Override
	public void regist(ScoreVO vo) {
		scoreDAO.regist(vo);
	}

	@Override
	public ArrayList<ScoreVO> getList() {
		return scoreDAO.getList();
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		scoreDAO.delete(num);
	}
	
	
	
	

	
	
}
