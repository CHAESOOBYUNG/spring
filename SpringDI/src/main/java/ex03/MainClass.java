package ex03;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		/*
		DatabaseDev dev = new DatabaseDev();
		dev.setUid("....");
		dev.setUrl(".......");
		dev.setUpw("...");
		*/
		
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("application-context.xml");
		
		DatabaseDev dev = ctx.getBean(DatabaseDev.class);
		
		System.out.println(dev.getUrl());
		System.out.println(dev.getUid());
		System.out.println(dev.getUpw());
		
		//1. application-context에 MemberDAO의 의존관계를 나타내고
		//   main에서는 getBean메서드를 통해서 값을 출력해보세요.
		MemberDAO dao = ctx.getBean(MemberDAO.class);
		
		System.out.println( dao.getDs().getUrl());
		System.out.println( dao.getDs().getUid());
		System.out.println( dao.getDs().getUpw());
		
		
	
	}
}
