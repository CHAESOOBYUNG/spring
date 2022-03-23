package com.coding404.freeboard.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding404.command.FreeBoardVO;

@Service("freeBoardService")
public class FreeBoardServiceImpl implements FreeBoardService {
	
	@Autowired
	FreeBoardMapper freeBoardMapper;
	
	@Override
	public int regist(FreeBoardVO vo) {
		
		return freeBoardMapper.regist(vo);
	}

	@Override
	public ArrayList<FreeBoardVO> getList() {
		
		return freeBoardMapper.getList();
	}

	@Override
	public FreeBoardVO getContent(int bno) {
		// TODO Auto-generated method stub
		return freeBoardMapper.getContent(bno); 
	}

	@Override
	public int update(FreeBoardVO vo) {
		// TODO Auto-generated method stub
		return freeBoardMapper.update(vo);
	}

	@Override
	public int delete(int bno) {
		// TODO Auto-generated method stub
		return freeBoardMapper.delete(bno);
	}

	

	

	

	
	
}
