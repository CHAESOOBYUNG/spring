package ex04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Printer {
	
	/*
	 * @Autowired -> 자동주입 타입 -> 이름
	 * 
	 * @Autowired(required = false)
	 * 스프링이 빈을 주입할 때 주입할 빈이 없으면 에러를 발생시키는데,
	 * 이를 무시하고 지나가는 옵션입니다
	 * 
	 * @Qulifier
	 * 컨테이너에 동일한 객체가 여러개 있을 때 이름으로 강제 연결하는 어노테이션
	 * 
	 */
	
	@Autowired(required = false)
	@Qualifier("aaa")
	private Document doc;
	
	//기본생성자
	public Printer() {
		
	}
	
	//생성자
	public Printer(Document doc) {
		this.doc = doc;
	}


	public Document getDoc() {
		return doc;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
	}
	
	
}
