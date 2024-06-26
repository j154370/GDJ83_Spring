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
	
	public DepartmentDTO getDetail(int num) throws Exception{
		return dao.getDetail(num);
	}
	
	public int add(DepartmentDTO dto) throws Exception{
		return dao.add(dto);
	}
	
	public int delete(DepartmentDTO dto) throws Exception{
		return dao.delete(dto);
	}
	
	public int update(DepartmentDTO dto) throws Exception{
		return dao.update(dto);
	}

}
