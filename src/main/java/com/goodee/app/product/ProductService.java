package com.goodee.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodee.app.util.Pager;

@Service
public class ProductService {

	@Autowired
	private ProductDAO dao;
	
	public List<ProductDTO> getList(Long page) throws Exception{
		// page가 1이면, 첫번째 숫자는 1, 두번째 숫자는 10
		// page가 2이면, 첫번째 숫자는 11, 두번째 숫자는 20
		// page가 3이면, 첫번째 숫자는 21, 두번째 숫자는 30
		if(page == null) {
			page = 1L;
		}
		long perPage = 10L;
		long startRow = (page-1) * perPage+1;
		long lastRow = page * perPage;
		
		Pager pager = new Pager();
		pager.setStartRow(startRow);
		pager.setLastRow(lastRow);
		
		long totalCount = dao.getTotalCount();
		long totalPage = 0;
		
		if(totalCount % perPage == 0) {
			totalPage = totalCount / perPage;
		}else {
			totalPage = totalCount / perPage + 1;
		}
		
		return dao.getList(pager);
	}
	
	public ProductDTO getDetail(ProductDTO dto) throws Exception{
		return dao.getDetail(dto);
	}
	
	public int add(ProductDTO dto) throws Exception{
		return dao.add(dto);
	}
	
	public int delete(ProductDTO dto) throws Exception{
		return dao.delete(dto);
	}
	
	public int update(ProductDTO dto) throws Exception{
		return dao.update(dto);
	}
}
