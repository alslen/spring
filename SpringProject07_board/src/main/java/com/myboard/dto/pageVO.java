package com.myboard.dto;

import lombok.Getter;

import lombok.Setter;



@Getter @Setter
public class pageVO {  /// 보통 사용자가 값을 전달할때는 함수이름에 VO를 사용함
	private int totPage; // 전체페이지
	private int blockPage;  // 페이징 개수
	private int startPage; 
	private int endPage;
	private int currentPage;  // 현재페이지
	private String field;
	private String word;
	
	public pageVO(int count, int currentPage, int pageSize) {
		totPage = count/pageSize + (count%pageSize==0?0:1);
		blockPage = 3;  // [이전]4 5 6[다음]
		startPage = ((currentPage-1)/blockPage)*blockPage+1;
		endPage = startPage+blockPage-1;  // 계산상 마지막 페이지
		if(endPage>totPage) endPage = totPage;  // totPage 실제 마지막페이지
		
		setBlockPage(blockPage);
		setCurrentPage(currentPage);
		setEndPage(endPage);
		setStartPage(startPage);
		setTotPage(totPage);
	}
}
