package com.guest.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements GuestService{

	@Autowired
	private GuestRepository repository;
	
	@Override
	public void guestInsert(GuestVO person) {
		repository.dao_guestInsert(person);
	}

	@Override
	public List<GuestVO> guestList(HashMap<String, String> hm) {
		return repository.dao_guestList(hm);
	}

	@Override
	public GuestVO findByNum(int num) {
		return repository.dao_findByNum(num);
	}

	@Override
	public void guestUpdate(GuestVO person) {
		
	}

	// ªË¡¶
	@Override
	public void guestDelete(int num) {
		repository.dao_guestDelete(num);
	}

	@Override
	public int guestCount(HashMap<String, String> hm) {
		return repository.dao_guestCount(hm);
	}

}
