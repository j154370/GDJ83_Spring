package com.goodee.app.locations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
	
	@Autowired
	private LocationDAO dao;
	
	
	public List<LocationDTO> getList() throws Exception{
		return dao.getList();
		
	}
	
	public LocationDTO getDetail(int num) throws Exception{
		return dao.getDetail(num);
	}
	
	public int add(LocationDTO dto) throws Exception{
		return dao.add(dto);
	}

}
