package com.myspring.model;

import java.util.HashMap;
import java.util.List;

public interface GuestDAO {
	// 추가
	public void dao_guesetInsert(String mid, GuestDTO guest);
	// 전체보기
	public List<GuestDTO> dao_guestList(String mid, HashMap<String,String> hm);
	// 개수
	public int dao_guestCount(String mid, HashMap<String,String> hm);
}
