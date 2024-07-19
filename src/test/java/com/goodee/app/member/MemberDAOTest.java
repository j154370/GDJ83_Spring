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
	public void fileTest() throws Exception{
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setUser_id("12345632525235252335235");
		memberFileDTO.setFile_name("aaa");
		memberFileDTO.setOri_name("dog.jpg");
		int result = memberDAO.addFile(memberFileDTO);
		
		System.out.println(result);
	}
	

}
