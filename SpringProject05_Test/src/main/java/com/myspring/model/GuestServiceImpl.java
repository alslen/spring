package com.myspring.model;

import java.util.HashMap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 객체 생성할 때 꼭 필요함
public class GuestServiceImpl implements GuestService{

	@Autowired
	private GuestDAO dao;
	
	// 추가
	@Override
	public void guesetInsert(GuestDTO guest) {
		dao.dao_guesetInsert("insertGuest",guest);
		
	}

	// 전체보기(검색기능)
	@Override
	public List<GuestDTO> guestList(HashMap<String, String> hm) {

		return dao.dao_guestList("listGuest", hm);
	}

	// 개수(검색기능 포함)
	@Override
	public int guestCount(HashMap<String, String> hm) {
		
		return dao.dao_guestCount("countGuest", hm);
	}

}
