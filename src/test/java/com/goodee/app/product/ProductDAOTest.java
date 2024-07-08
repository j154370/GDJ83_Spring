package com.goodee.app.product;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.goodee.app.DefaultTest;

public class ProductDAOTest extends DefaultTest{
	
	@Autowired
	private ProductDAO productDAO;
	
	@Test
	public void getDatailTest() throws Exception{
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProduct_num(11);
		productDTO = productDAO.getDetail(productDTO);
		// 단정문 Assert (테스트 결과 확인할때 사용)
		assertNotNull(productDTO);
	}
	
	public void add() {
		ProductDTO productDTO = new ProductDTO();
		
	}
 
}
