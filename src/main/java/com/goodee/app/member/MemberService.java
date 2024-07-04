package com.goodee.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MemberDAO dao;
	
	
	public int join(MemberDTO dto) throws Exception{
		
		return dao.join(dto);
	}
	
	public MemberDTO login(MemberDTO dto) throws Exception{
		
		MemberDTO result = dao.login(dto);
		
		if(result != null) {
			if(result.getUser_pw().equals(dto.getUser_pw())) {
				return result;
			}else {
				return null;
			}
		}
		
		return result;
		
	}
}
