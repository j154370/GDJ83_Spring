package com.goodee.app.locations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.goodee.app.util.DBConnection;

@Repository
public class LocationDAO {
	
	@Autowired
	private DBConnection dbConnection;
	
	public List<LocationDTO> getList() throws Exception{
		Connection con = dbConnection.getConnection();
		
		String sql = "SELECT * FROM LOCATIONS ORDER BY LOCATION_ID ASC";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		ArrayList<LocationDTO> dtos = new ArrayList<LocationDTO>();
		
		while(rs.next()) {
			LocationDTO dto = new LocationDTO();
			
			dto.setLocation_id(rs.getInt("LOCATION_ID"));
			dto.setStreet_address(rs.getString("STREET_ADDRESS"));
			dto.setPostal_code(rs.getString("POSTAL_CODE"));
			dto.setCity(rs.getString("CITY"));
			dto.setState_province(rs.getString("STATE_PROVINCE"));
			dto.setCountry_id(rs.getString("COUNTRY_ID"));
			
			dtos.add(dto);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return dtos;
		
	}
	
	public LocationDTO getDetail(int num) throws Exception{
		Connection con = dbConnection.getConnection();
		
		String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, num);
		
		ResultSet rs = st.executeQuery();
		
		LocationDTO dto = null;
		if(rs.next()) {
			dto = new LocationDTO();
			
			dto.setLocation_id(rs.getInt("LOCATION_ID"));
			dto.setStreet_address(rs.getString("STREET_ADDRESS"));
			dto.setPostal_code(rs.getString("POSTAL_CODE"));
			dto.setCity(rs.getString("CITY"));
			dto.setState_province(rs.getString("STATE_PROVINCE"));
			dto.setCountry_id(rs.getString("COUNTRY_ID"));
		}
		
		rs.close();
		st.close();
		con.close();
		
		return dto;
	}
	
	public int add(LocationDTO dto) throws Exception{
		Connection con = dbConnection.getConnection();
		
		String sql = "INSERT INTO LOCATIONS (LOCATION_ID, STREET_ADDRESS, POSTAL_CODE, CITY, STATE_PROVINCE, COUNTRY_ID) "
					+ " VALUES (LOCATIONS_SEQ.NEXTVAL,?,?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, dto.getStreet_address());
		st.setString(2, dto.getPostal_code());
		st.setString(3, dto.getCity());
		st.setString(4, dto.getState_province());
		st.setString(5, dto.getCountry_id());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}

}
