package com.goodee.app.account;

public class ListOption {
	
	private String account_num;
	
	private Integer order;   // 0이면 desc, 1이면 asc 정렬
	
	private Integer order2;
	

	public Integer getOrder2() {
		return order2;
	}

	public void setOrder2(Integer order2) {
		this.order2 = order2;
	}

	

	public String getAccount_num() {
		return account_num;
	}

	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

}
