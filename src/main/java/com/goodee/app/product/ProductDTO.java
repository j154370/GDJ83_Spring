package com.goodee.app.product;

public class ProductDTO {
	
	private Integer product_num;	// 상품 번호, PK키
	private String product_name;	// 상품 이름
	private Double product_rate;	// 이자율
	private String product_ex;		// 상품 설명
	
	
	public Integer getProduct_num() {
		return product_num;
	}
	public void setProduct_num(Integer product_num) {
		this.product_num = product_num;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public Double getProduct_rate() {
		return product_rate;
	}
	public void setProduct_rate(Double product_rate) {
		this.product_rate = product_rate;
	}
	public String getProduct_ex() {
		return product_ex;
	}
	public void setProduct_ex(String product_ex) {
		this.product_ex = product_ex;
	}

}
