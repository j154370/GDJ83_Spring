package com.goodee.app.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goodee.app.member.MemberDTO;
import com.goodee.app.util.Pager;


@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.goodee.app.product.ProductDAO.";
	
	
	public int addWish(Map<String, Object> map) throws Exception{
		
		return sqlSession.insert(NAMESPACE + "addWish", map);
	}
	
	public List<ProductDTO> wishList(MemberDTO memberDTO)throws Exception{
		
		return sqlSession.selectList(NAMESPACE + "wishList", memberDTO);
	}
	

	public List<ProductDTO> getList(Pager pager) throws Exception{
		
		return sqlSession.selectList(NAMESPACE + "getList", pager);	
		
	}
	
	// service에서 사용할 totalCount 값을 구하기 위한 메서드
	public Long getTotalCount(Pager pager) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE + "getTotalCount", pager);
	}
	
	public ProductDTO getDetail(ProductDTO dto) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE+"getDetail", dto);	
	}
	
	public Long getNum() throws Exception{
		
		return sqlSession.selectOne(NAMESPACE + "getNum");
	}
	
	public int add(ProductDTO dto) throws Exception{
		
		return sqlSession.insert(NAMESPACE + "add", dto);
	}
	
	public int addFile(ProductFileDTO productFileDTO) throws Exception{
		
		return sqlSession.insert(NAMESPACE + "addFile", productFileDTO);
	}
	
	public int delete(ProductDTO dto) throws Exception{
		
		return sqlSession.delete(NAMESPACE + "delete", dto);
	}
	
	public int update(ProductDTO dto) throws Exception{
		
		return sqlSession.update(NAMESPACE + "update", dto);
	}
	
}
