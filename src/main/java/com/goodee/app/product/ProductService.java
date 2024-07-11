package com.goodee.app.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodee.app.util.Pager;

@Service
public class ProductService {

	@Autowired
	private ProductDAO dao;
	
	public Map<String, Object> getList(Long page) throws Exception{
		// page가 1이면, 첫번째 숫자는 1, 두번째 숫자는 10
		// page가 2이면, 첫번째 숫자는 11, 두번째 숫자는 20
		// page가 3이면, 첫번째 숫자는 21, 두번째 숫자는 30
		if(page == null) {
			page = 1L;
		}
		
		if(page < 1) {
			page = 1L;
		}
		
		long perPage = 10L;
		long startRow = (page-1) * perPage+1;
		long lastRow = page * perPage;
		
		Pager pager = new Pager();
		pager.setStartRow(startRow);
		pager.setLastRow(lastRow);
		
		long totalCount = dao.getTotalCount();
		long totalPage = 0;
		
		
		// 1. 총 개수로 총 페이지 수 구하기
		if(totalCount % perPage == 0) {
			totalPage = totalCount / perPage;
		}else {
			totalPage = totalCount / perPage + 1;
		}
		
		
		// 2. 총 페이지수로 총 블럭 수 구하기
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
		long startNum = (curBlock-1) * perBlock + 1;
		long lastNum = curBlock * perBlock;
		
		
		// 5. 이전, 다음 블럭 유무 판단
		boolean next = true; // true면 다음 블럭이 있고, false면 다음 블럭이 없다
		
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
		
		return map;
	}
	
	public ProductDTO getDetail(ProductDTO dto) throws Exception{
		return dao.getDetail(dto);
	}
	
	public int add(ProductDTO dto) throws Exception{
		return dao.add(dto);
	}
	
	public int delete(ProductDTO dto) throws Exception{
		return dao.delete(dto);
	}
	
	public int update(ProductDTO dto) throws Exception{
		return dao.update(dto);
	}
}
