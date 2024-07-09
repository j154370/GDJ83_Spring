package com.goodee.app.account;

import java.sql.Date;

public class TradeDTO {
	
	private Long trade_num;
	private String account_num;
	private Long balance;
	private String trade_type;
	private Long trade_amount;
	private Date trade_date;
	
	
	
	public Long getTrade_num() {
		return trade_num;
	}
	public void setTrade_num(Long trade_num) {
		this.trade_num = trade_num;
	}
	public String getAccount_num() {
		return account_num;
	}
	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public Long getTrade_amount() {
		return trade_amount;
	}
	public void setTrade_amount(Long trade_amount) {
		this.trade_amount = trade_amount;
	}
	public Date getTrade_date() {
		return trade_date;
	}
	public void setTrade_date(Date trade_date) {
		this.trade_date = trade_date;
	}
	
	
}
