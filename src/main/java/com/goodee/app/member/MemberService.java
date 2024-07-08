package com.goodee.app.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodee.app.account.AccountDAO;
import com.goodee.app.account.AccountDTO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private AccountDAO accountDAO;
	
	
	public int join(MemberDTO dto) throws Exception{
		
		return dao.join(dto);
	}
	
	public MemberDTO login(MemberDTO dto) throws Exception{
		
		MemberDTO result = dao.login(dto);
		
		if(result != null) {
			if(result.getUser_pw().equals(dto.getUser_pw())) {
				// 로그인 성공 지점 (마이 페이지에 계좌 정보를 띄우는 코드)
				
				return result;
			}else {
				result =  null;
			}
		}
		
		return result;
		
	}
	
	public int update(MemberDTO dto) throws Exception{
		
		return dao.update(dto);
	}
	
	public int delete(MemberDTO dto) throws Exception{
		
		return dao.delete(dto);
	}
	
}
