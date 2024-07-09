package com.goodee.app.account;

import java.sql.Date;

public class TradeDTO {
	
	private Long trade_num;
	private String account_num_me;
	private String account_num_you;
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
	
	public String getAccount_num_me() {
		return account_num_me;
	}
	public void setAccount_num_me(String account_num_me) {
		this.account_num_me = account_num_me;
	}
	public String getAccount_num_you() {
		return account_num_you;
	}
	public void setAccount_num_you(String account_num_you) {
		this.account_num_you = account_num_you;
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
