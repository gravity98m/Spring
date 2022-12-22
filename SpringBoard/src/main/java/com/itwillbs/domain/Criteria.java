package com.itwillbs.domain;

public class Criteria {
	// 페이징처리에 필요한 정보를 저장 (페이지 시작정보, 사이즈)
	
	 private int page; // 시작페이지 정보
	 private int perPageNum; // 페이지 개수
	 
	 // 페이징처리 정보가 없을경우 - 기본값
	 public Criteria() {
		 this.page = 1;
		 this.perPageNum = 10;
	 }
	 
	// 페이지 정보 (음수일때 1페이지 정보)
		public void setPage(int page) {
			if(page <= 0) {
				this.page = 1;
				return;
			}
			 
			this.page = page;
		}
		// 페이지 사이즈 (음수, 페이지수가 100이상 => 기본값 10)
		public void setperPageNum(int perPageNum) {
			if(perPageNum <= 0 || perPageNum >= 100) {
				this.perPageNum = 10;
				return;
			}
				
			this.perPageNum = perPageNum;
		}
		
		
		
		public int getPage() {
			return page;
		}
		
		// #{pageStart}안에 정보를 전달
		public int getPageStart() {
			return (this.page-1)*perPageNum;
		}
		
		// #{perPageNum} 안에 정보를 전달
		public int getperPageNum() {
			return perPageNum;
		}

		// alt + shift + s / s
		@Override
		public String toString() {
			return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
		}
		
		
}
