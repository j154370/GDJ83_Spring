package com.goodee.app.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO dao;
	
	
	public List<NoticeDTO> getList() throws Exception{
		
		return dao.getList();
	}
	
	public NoticeDTO getDetail(NoticeDTO dto) throws Exception{
		
		return dao.getDetail(dto);
	}
	
	public int add(NoticeDTO dto) throws Exception{
		
		return dao.add(dto);
	}
	
	public int delete(NoticeDTO dto) throws Exception{
		
		return dao.delete(dto);
	}
	
	public int update(NoticeDTO dto) throws Exception{
		
		return dao.update(dto);
	}

}
