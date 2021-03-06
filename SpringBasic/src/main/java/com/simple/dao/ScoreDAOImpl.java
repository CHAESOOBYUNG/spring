package com.simple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.simple.command.ScoreVO;

@Repository("aaa") //bean의 id를 aaa로 생성
public class ScoreDAOImpl implements ScoreDAO {

	@Autowired
	DataSource ds;
	
	@Override
	public void regist(ScoreVO vo) {
		
		//insert
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into score values(score_seq.nextval, ?, ?, ?, ?)";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMath());
			
			pstmt.executeUpdate(); //성공시 1, 실패시 0 반환
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
			}
		}
		
	}

	@Override
	public ArrayList<ScoreVO> getList() {
		
		ArrayList<ScoreVO> list = new ArrayList<>(); //값을 담을 리스트
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from score";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int math = rs.getInt("math");
				
				ScoreVO vo = new ScoreVO(num, name, kor, eng, math);
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return list;
	}

	@Override
	public void delete(int num) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from score where num = ?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
	
	
	
	
	/*
	//리스트(데이터베이스 대체)
	ArrayList<ScoreVO> list = new ArrayList<>();
	
	@Override
	public void regist(ScoreVO vo) {
		//데이터 연결.........
		list.add(vo);
		
	}

	@Override
	public ArrayList<ScoreVO> getList() {
		// TODO Auto-generated method stub
		return list;
	}
	
	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		list.remove(num); //삭제
	}
	*/
	
	
	

	

	
	
	
}
