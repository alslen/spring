package com.myspring.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository  // 스프링 컨테이너가 객체를 관리하기 위해 써줘야함
public class GuestDAOImpl implements GuestDAO{

	@Autowired  // sqlMapper은 root-context에 객체를 만들었기 때문에 주입만 시킴
	private SqlSession sqlMapper;  // mybatis를 사용하기 위해 사용
	
	@Override
	public void dao_guesetInsert(String mid, GuestDTO guest) {
		sqlMapper.insert(mid, guest);
		
	}

	@Override
	public List<GuestDTO> dao_guestList(String mid, HashMap<String, String> hm) {
		
		return sqlMapper.selectList(mid, hm);
	}

	@Override
	public int dao_guestCount(String mid, HashMap<String, String> hm) {
		
		return sqlMapper.selectOne(mid, hm);
	}

	

}
