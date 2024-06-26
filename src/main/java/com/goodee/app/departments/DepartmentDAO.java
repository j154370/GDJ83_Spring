package com.goodee.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goodee.app.util.DBConnection;

@Repository
public class DepartmentDAO {
	
	@Autowired
	private DBConnection dbConnection;
	
	
	public List<DepartmentDTO> getLIst() throws Exception{
		Connection con = dbConnection.getConnection();
		
		// SQL (Query)문 작성
		String sql = "SELECT * FROM DEPARTMENTS ORDER BY DEPARTMENT_ID ASC";
		
		// 작성한 SQL문을 미리 서버로 전송하는 것
		PreparedStatement st = con.prepareStatement(sql);
		
		// 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		
		ArrayList<DepartmentDTO> dtos = new ArrayList<DepartmentDTO>();
		
		while(rs.next()) {
			DepartmentDTO dto = new DepartmentDTO();
			int id = rs.getInt("DEPARTMENT_ID");
			String name = rs.getString("DEPARTMENT_NAME");
			
			dto.setDepartment_id(id);
			dto.setDepartment_name(name);
			dto.setManager_id(rs.getLong("MANAGER_ID"));
			dto.setLocation_id(rs.getInt("LOCATION_ID"));
			
			dtos.add(dto);
		}
		
		//연결한 자원을 해제
		rs.close();
		st.close();
		con.close();
		
		return dtos;
	}
	
	public DepartmentDTO getDetail(int num) throws Exception{
		Connection con = dbConnection.getConnection();
		
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		// ? 처리
		st.setInt(1, num);
		
		ResultSet rs = st.executeQuery();
		
		DepartmentDTO dto = null;
		if(rs.next()) {
			dto = new DepartmentDTO();
			
			dto.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			dto.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			dto.setManager_id(rs.getLong("MANAGER_ID"));
			dto.setLocation_id(rs.getInt("LOCATION_ID"));	
		}
		
		rs.close();
		st.close();
		con.close();
		
		return dto;
	}
	
	public int add(DepartmentDTO dto) throws Exception{
		Connection con = dbConnection.getConnection();
		
		String sql = "INSERT INTO DEPARTMENTS "
				+ " (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID) " 
				+ " VALUES (DEPARTMENTS_SEQ.NEXTVAL,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, dto.getDepartment_name());
		st.setLong(2, dto.getManager_id());
		st.setInt(3, dto.getLocation_id());
		
		// insert문은 executeUpdate 메서드를 사용
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	public int delete(DepartmentDTO dto) throws Exception{
		Connection con = dbConnection.getConnection();
		
		String sql = "DELETE DEPARTMENTS WHERE DEPARTMENT_ID=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, dto.getDepartment_id());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	public int update(DepartmentDTO dto) throws Exception{
		Connection con = dbConnection.getConnection();
		
		String sql = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME=?, MANAGER_ID=?, LOCATION_ID=? "
				+ " WHERE DEPARTMENT_ID=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, dto.getDepartment_name());
		st.setLong(2, dto.getManager_id());
		st.setInt(3, dto.getLocation_id());
		st.setInt(4, dto.getDepartment_id());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}

}
