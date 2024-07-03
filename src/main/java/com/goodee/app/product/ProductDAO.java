package com.goodee.app.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goodee.app.util.DBConnection;

@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.goodee.app.product.ProductDAO.";
	
	
	public List<ProductDTO> getList() throws Exception{
		
		return sqlSession.selectList(NAMESPACE + "getList");
		
	}
	
	public ProductDTO getDetail(ProductDTO dto) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE + "getDetail", dto);
	}
	
	public int add(ProductDTO dto) throws Exception{
		Connection con = dbConnection.getConnection();
		
		String sql = "INSERT INTO PRODUCT_INFO VALUES (PRODUCT_SEQ.NEXTVAL,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, dto.getProduct_name());
		st.setDouble(2, dto.getProduct_rate());
		st.setString(3, dto.getProduct_ex());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	public int delete(ProductDTO dto) throws Exception{
		Connection con = dbConnection.getConnection();
		
		String sql = "DELETE PRODUCT_INFO WHERE PRODUCT_NUM =?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, dto.getProduct_num());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	public int update(ProductDTO dto) throws Exception{
		Connection con = dbConnection.getConnection();
		
		String sql = "UPDATE PRODUCT_INFO SET PRODUCT_NAME =?, PRODUCT_RATE =?, PRODUCT_EX =? "
				+ " WHERE PRODUCT_NUM = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, dto.getProduct_name());
		st.setDouble(2, dto.getProduct_rate());
		st.setString(3, dto.getProduct_ex());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
}
