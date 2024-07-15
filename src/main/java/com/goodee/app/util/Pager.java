package com.goodee.app.util;

public class Pager {
	
	//검색 컬럼 종류
	private String kind;
	
	// 검색어
	private String search; 
	
	private Long page;
	
	private Long startRow;
	
	private Long lastRow;
	
	//---------------------
	
	private Long startNum;
	
	private Long lastNum;
	
	private boolean next;
	
	long perPage = 10L;


	
	// rowNum을 계산하는 메서드
	public void makeRow() throws Exception{
		this.startRow = (this.getPage()-1) * perPage+1;  // 여기서 getter를 통해 page가 null이 들어왔을 때 1로 바꿈
		this.lastRow = page * perPage;
	}

	
	// 페이징 처리 메서드
	public void makeNum(long totalCount) throws Exception{
		
		long totalPage = 0;
		// 1.총 개수로 총 페이지 수 구하기
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
				
		// 3. 현재 페이지 번호(page)로 현재 블럭 번호 구하기
			long curBlock = 0;
				
			if(page % perBlock == 0) {
				curBlock = page / perBlock;
			}else {
				curBlock = page / perBlock + 1;
			}
				
		// 4. 현재 블럭 번호(curBlock)로 시작 번호와 끝번호를 구하기
			this.startNum = (curBlock-1) * perBlock + 1;
			this.lastNum = curBlock * perBlock;
				
				
		// 5. 이전 블럭, 다음 블럭 유무 판단
			this.next = true; // true면 다음 블럭 존재, false면 다음 블럭 없음
				
			if(curBlock == totalBlock) {
				next = false;
					
				lastNum = totalPage;
				
			}					
	}
	
	
	
	
	
	
	
	//getter setter
	
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	// getter활용
	public String getSearch() {
		
		if(this.search == null) {
			this.search = "";
		}
		
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}


	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}

	public Long getLastRow() {
		return lastRow;
	}

	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	
	// getter활용
	public Long getPage() {
		if(this.page == null || this.page < 1) {
			this.page = 1L;
		}
		
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public long getPerPage() {
		return perPage;
	}

	public void setPerPage(long perPage) {
		this.perPage = perPage;
	}
	
	
	

}
