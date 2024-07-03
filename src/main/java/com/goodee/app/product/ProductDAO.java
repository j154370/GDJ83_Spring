package com.goodee.app.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.goodee.app.product.ProductDAO.";
	

	public List<ProductDTO> getList() throws Exception{
		
		return sqlSession.selectList(NAMESPACE + "getList");
		
	}
	
	public ProductDTO getDetail(ProductDTO dto) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE+"getDetail", dto);	
	}
	
	public int add(ProductDTO dto) throws Exception{
		
		return sqlSession.insert(NAMESPACE + "add", dto);
	}
	
	public int delete(ProductDTO dto) throws Exception{
		
		return sqlSession.delete(NAMESPACE + "delete", dto);
	}
	
	public int update(ProductDTO dto) throws Exception{
		
		return sqlSession.update(NAMESPACE + "update", dto);
	}
}
