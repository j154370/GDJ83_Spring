package com.goodee.app.member;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.goodee.app.account.AccountDAO;
import com.goodee.app.account.AccountDTO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private AccountDAO accountDAO;
	
	private String name="members";
	
	
	public int join(MemberDTO dto, MultipartFile files, HttpSession session) throws Exception{
		int result = dao.join(dto);
		
		if(files == null) {
			return result;
		}
	
		ServletContext servletContext = session.getServletContext();
		
		// 1. 어디에 저장할 것인가 - 운영체제가 알고있는 경로
		String path = servletContext.getRealPath("resources/upload/members");
		
		File file = new File(path);
		
		System.out.println(path);
		
		if(!file.exists()) {
			file.mkdir();
		}
		
		// 2. 파일명은 어떻게 할 것인가 - (1)라이브러리 사용
		
		String fileName = UUID.randomUUID().toString() + "_" + files.getOriginalFilename();
		
		// 3. HDD에 파일을 저장하는 단계 - (1)MultipartFile 사용
		file = new File(file, fileName);
		
		files.transferTo(file);
		
		
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setUser_id(dto.getUser_id());
		memberFileDTO.setFile_name(fileName);
		memberFileDTO.setOri_name(files.getOriginalFilename());
		
		result = dao.addFile(memberFileDTO);
		
		return result;
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
	
	public MemberDTO detail(MemberDTO dto) throws Exception{
		
		return dao.detail(dto);
		
	}
	
}
