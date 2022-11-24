package com.guest.model;

import java.util.HashMap;
import java.util.List;



public interface GuestService {
	
		// 추가
		public void guestInsert(GuestVO person);
		// 전체보기
		public List<GuestVO> guestList(HashMap<String, String> hm); 
		// 상세보기
		public GuestVO findByNum(int num);
		// 수정
		public void guestUpdate(GuestVO person);
		// 삭제
		public void guestDelete(int num);
		// 개수
		public int guestCount(HashMap<String, String> hm);  

}
