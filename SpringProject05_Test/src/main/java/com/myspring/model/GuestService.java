package com.myspring.model;

import java.util.HashMap;
import java.util.List;

public interface GuestService {

	// 추가
	public void guesetInsert(GuestDTO guest);
	// 전체보기
	public List<GuestDTO> guestList(HashMap<String,String> hm);
	// 개수
	public int guestCount(HashMap<String,String> hm);
}
