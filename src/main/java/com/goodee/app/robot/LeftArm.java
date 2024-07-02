package com.goodee.app.robot;

import org.springframework.stereotype.Component;

@Component("la")
public class LeftArm implements Arm {
	
	@Override
	public void info() {
		System.out.println("왼쪽 팔 입니다.");
	}

}
