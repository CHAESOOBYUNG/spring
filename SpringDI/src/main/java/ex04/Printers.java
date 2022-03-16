package ex04;

import javax.annotation.Resource;

public class Printers {
	
	/*
	 * @Resource -> 이름 -> 타입으로 찾아서 주입
	 * 
	 */
	
	@Resource(name = "aaa")
	private Document doc;
	
	//기본생성자
	public Printers() {
		
	}
	
	//생성자
	public Printers(Document doc) {
		super();
		this.doc = doc;
	}

	public Document getDoc() {
		return doc;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
	}
	
	
}
