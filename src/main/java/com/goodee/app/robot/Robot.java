package com.goodee.app.robot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class Robot {
	
	//@Autowired
	private Arm ra;
	
	//@Autowired
	private Arm la;
	
	private String company;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Arm getRa() {
		return ra;
	}

	public void setRa(Arm ra) {
		this.ra = ra;
	}

	public Arm getLa() {
		return la;
	}

	public void setLa(Arm la) {
		this.la = la;
	}

	
	
	
	

}