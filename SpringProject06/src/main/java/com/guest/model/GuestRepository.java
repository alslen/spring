package com.guest.model;

import java.util.HashMap;
import java.util.List;

public interface GuestRepository {

			// 추가
			public void dao_guestInsert(GuestVO person);
			// 전체보기
			public List<GuestVO> dao_guestList(HashMap<String, String> hm); 
			// 상세보기
			public GuestVO dao_findByNum(int num);
			// 수정
			public void dao_guestUpdate(GuestVO person);
			// 삭제
			public void dao_guestDelete(int num);
			// 개수
			public int dao_guestCount(HashMap<String, String> hm);  
}
