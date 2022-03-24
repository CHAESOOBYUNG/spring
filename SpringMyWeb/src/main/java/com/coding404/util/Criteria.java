package com.coding404.util;

import lombok.Data;

@Data //getter, setter
public class Criteria {
	//페이지 기준정보를 가지는 클래스
	private int pageNum;
	private int amount;
	
	//검색키워드
	private String searchName;
	private String searchType;
	
	public Criteria() {
		this(1, 10);
	}
	
	public Criteria(int pageNum, int amount) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	
}
