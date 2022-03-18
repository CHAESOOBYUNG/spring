package com.simple.basic;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simple.dao.ScoreDAO;

@RunWith(SpringJUnit4ClassRunner.class) //스프링 JUnit의 테스트 환경을 잡아준다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/root-context.xml") //root-context를 스프링 설정파일로 참조
public class JDBCBasic {
	
	@Autowired
	@Qualifier("ds")
	DataSource ds;
	
	@Test
	public void test01() {
		
		try {
			Connection conn = ds.getConnection();
			System.out.println(conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
