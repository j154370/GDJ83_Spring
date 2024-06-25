package com.goodee.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goodee.app.util.DBConnection;

@Repository
public class DepartmentDAO {
	
	@Autowired
	private DBConnection dbConnection;
	
	
	public void getLIst() throws Exception{
		Connection con = dbConnection.getConnection();
		
		// SQL (Query)문 작성
		String sql = "SELECT * FROM DEPARTMENTS ORDER BY DEPARTMENT_ID ASC";
		
		// 작성한 SQL문을 미리 서버로 전송하는 것
		PreparedStatement st = con.prepareStatement(sql);
		
		// 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("DEPARTMENT_ID");
			String name = rs.getString("DEPARTMENT_NAME");
			System.out.println(id + " : " + name);
		}
		
		//연결한 자원을 해제
		rs.close();
		st.close();
		con.close();
	}

}
