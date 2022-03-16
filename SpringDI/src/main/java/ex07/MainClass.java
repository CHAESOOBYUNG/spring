package ex07;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ex01.SpringTest;
import ex02.Hotel;

public class MainClass {
	
	public static void main(String[] args) {
		
		//자바파일을 설정파일로 쓸 때는 를 상속받는다.
		//아래클래스를 사용합니다.
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(JavaConfig.class);
		
		
		SpringTest st = ctx.getBean(SpringTest.class);
		st.test();
		
		Hotel h = ctx.getBean(Hotel.class);
		h.getChef().cooking();
		
		
	}
}
