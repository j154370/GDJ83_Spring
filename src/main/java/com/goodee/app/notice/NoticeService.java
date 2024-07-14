package com.goodee.app.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodee.app.util.Pager;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO dao;
	
	
	public Map<String, Object> getList(Long page, String kind, String search) throws Exception{
		
		if(page == null) {
			page = 1L;
		}
		
		if(page < 1) {
			page = 1L;
		}
		
		if(search == null) {
			search = "";
		}
		
		long perPage = 10L;
		long startRow = (page-1) * perPage + 1;
		long lastRow = page * perPage;
		
		Pager pager = new Pager();
		
		pager.setStartRow(startRow);
		pager.setLastRow(lastRow);
		pager.setKind(kind);
		pager.setSearch(search);
		
		long totalCount = dao.getTotalCount(pager);
		long totalPage = 0;
		
		// 1. 총 개수로 총 페이지 구하기
		if(totalCount % perPage == 0) {
			totalPage = totalCount / perPage;
		}else {
			totalPage = totalCount / perPage + 1;
		}
		
		// 2. 총 페이지 수로 총 블럭 수 구하기
		long perBlock = 5L;
		long totalBlock = 0;
		
		if(totalPage % perBlock == 0) {
			totalBlock = totalPage / perBlock;
		}else {
			totalBlock = totalPage / perBlock + 1;
		}
		
		// 3. 현재 페이지 번호로 현재 블럭 번호 구하기
		long curBlock = 0;
		
		if(page % perBlock == 0) {
			curBlock = page / perBlock;
		}else {
			curBlock = page / perBlock + 1;
		}
		
		// 4. 현재 블럭 번호로 시작 번호와 끝 번호 구하기
		long startNum = (curBlock - 1) * perBlock + 1;
		long lastNum = curBlock * perBlock;
		
		// 5. 이전, 다음 블럭 유무 판단
		boolean next = true;
		
		if(lastNum >= totalPage) {
			
			next = false;
			
			lastNum = totalPage;
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", dao.getList(pager));
		map.put("totalPage", totalPage);
		map.put("startNum", startNum);
		map.put("lastNum", lastNum);
		map.put("next", next);
		map.put("kind", kind);
		map.put("search", search);
		
		return map;
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
