package com.goodee.app.member;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.goodee.app.DefaultTest;
import com.goodee.app.product.ProductDAO;
import com.goodee.app.product.ProductDTO;

public class MemberDAOTest extends DefaultTest{
	
	@Autowired
	private MemberDAO memberDAO = new MemberDAO();
	
	@Test
	public void loginTest() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUser_id("12345");
		memberDTO = memberDAO.login(memberDTO);
		
		assertNotNull(memberDTO);
	}
	

}
