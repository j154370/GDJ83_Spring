package com.goodee.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductDAO dao;
	
	public List<ProductDTO> getList() throws Exception{
		return dao.getList();
	}
	
	public ProductDTO getDetail(ProductDTO dto) throws Exception{
		return dao.getDetail(dto);
	}
}
