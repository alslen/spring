package com.guest.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.guest.mapper.GuestMapper;

@Repository
public class GuestRepositoryImpl implements GuestRepository{

	@Autowired
	private GuestMapper mapper;  //root-
	@Override
	public void dao_guestInsert(GuestVO person) {
		mapper.insert(person);  //  // mapper의 메소드를 불러줌
	}

	@Override
	public List<GuestVO> dao_guestList(HashMap<String, String> hm) {
		return mapper.list(hm);
	}

	@Override
	public GuestVO dao_findByNum(int num) {
		return mapper.findByNum(num);
	}

	@Override
	public void dao_guestUpdate(GuestVO person) {
		
	}

	@Override
	public void dao_guestDelete(int num) {
		
	}

	@Override
	public int dao_guestCount(HashMap<String, String> hm) {
		return mapper.count(hm);
	}

}
