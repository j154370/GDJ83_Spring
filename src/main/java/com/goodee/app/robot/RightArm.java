package com.goodee.app.robot;

import org.springframework.stereotype.Component;

//@Component("ra")
public class RightArm implements Arm {
	
	@Override
	public void info() {
		System.out.println("오른팔 입니다.");
	}

}
