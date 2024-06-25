package com.goodee.app.departments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentDAO dao;
	
	public List<DepartmentDTO> getList() throws Exception{
		return dao.getLIst();
	}

}
