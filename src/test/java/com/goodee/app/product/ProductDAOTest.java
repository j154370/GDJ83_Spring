package com.goodee.app.product;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.goodee.app.DefaultTest;

public class ProductDAOTest extends DefaultTest{
	
	@Autowired
	private ProductDAO productDAO;
	
//	@Test
//	public void getDatailTest() throws Exception{
//		ProductDTO productDTO = new ProductDTO();
//		productDTO.setProduct_num(11);
//		productDTO = productDAO.getDetail(productDTO);
//		// 단정문 Assert (테스트 결과 확인할때 사용)
//		assertNotNull(productDTO);
//	}
	
//	@Test
//	public void addTest() throws Exception{
//		ProductDTO productDTO = new ProductDTO();
//		for(int i = 0; i < 100; i++) {
//			productDTO.setProduct_name("자유입출금" + i);
//			double d = ((int)(Math.random()*1000))/100.0;
//			productDTO.setProduct_rate(d);
//			productDTO.setProduct_ex("상세설명" + i);
//			productDAO.add(productDTO);
//			Thread.sleep(500);
//		}
//		System.out.println("Finish");
//	}
	
	@Test
	public void pageTest() {
		long perPage = 10L;
		
		long totalCount = 145L;
		long totalPage = 0;
		
		if(totalCount % perPage == 0) {
			totalPage = totalCount / perPage;
		}else {
			totalPage = totalCount / perPage + 1;
		}
		
		System.out.println(totalPage);
	}
 
}
