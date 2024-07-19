package com.goodee.app.member;

import java.util.List;

import com.goodee.app.account.AccountDTO;

public class MemberDTO {
	
	private String user_id;     	// 유저 아이디, PK키
	private String user_name;		// 유저 이름
	private String user_phone;		// 전화번호
	private String user_pw;			// 비밀번호
	private String user_email;		// 이메일
	private String user_address;	// 주소
	private MemberFileDTO memberFileDTO;
	private List<AccountDTO> dtos;
	
	
	
	
	public MemberFileDTO getMemberFileDTO() {
		return memberFileDTO;
	}
	public void setMemberFileDTO(MemberFileDTO memberFileDTO) {
		this.memberFileDTO = memberFileDTO;
	}
	public List<AccountDTO> getDtos() {
		return dtos;
	}
	public void setDtos(List<AccountDTO> dtos) {
		this.dtos = dtos;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}


}
