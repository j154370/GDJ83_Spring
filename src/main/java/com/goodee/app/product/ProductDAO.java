package com.goodee.app.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goodee.app.util.DBConnection;

@Repository
public class ProductDAO {
	
	@Autowired
	private DBConnection dbConnection;

	public List<ProductDTO> getList() throws Exception{
		Connection con = dbConnection.getConnection();
		
		String sql = "SELECT * FROM PRODUCT_INFO ORDER BY PRODUCT_NUM ASC";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		ArrayList<ProductDTO> dtos = new ArrayList<ProductDTO>();
		
		while(rs.next()) {
			ProductDTO dto = new ProductDTO();
			
			dto.setProduct_num(rs.getInt("PRODUCT_NUM"));
			dto.setProduct_name(rs.getString("PRODUCT_NAME"));
			dto.setProduct_rate(rs.getDouble("PRODUCT_RATE"));
			dto.setProduct_ex(rs.getString("PRODUCT_EX"));
			
			dtos.add(dto);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return dtos;
		
	}
	
	public ProductDTO getDetail(ProductDTO dto) throws Exception{
		Connection con = dbConnection.getConnection();
		
		String sql = "SELECT * FROM PRODUCT_INFO WHERE PRODUCT_NUM =?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, dto.getProduct_num());
		
		ResultSet rs = st.executeQuery();
		
		ProductDTO dto2 = null;
		
		if(rs.next()) {
			dto2 = new ProductDTO();
			
			dto2.setProduct_num(rs.getInt("PRODUCT_NUM"));
			dto2.setProduct_name(rs.getString("PRODUCT_NAME"));
			dto2.setProduct_rate(rs.getDouble("PRODUCT_RATE"));
			dto2.setProduct_ex(rs.getString("PRODUCT_EX"));
		}
		
		rs.close();
		st.close();
		con.close();
		
		return dto2;
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
