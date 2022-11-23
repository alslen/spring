package com.myspring.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myspring.vo.PersonVO;

@Repository  // 객체를 만듦(DAO는 @Repository를 주로 사용)
public class PersonDAOImpl implements PersonDAO{

	@Autowired
	private SqlSession sqlMapper;
	@Override
	public void dao_Insert(String mid, PersonVO person) {
		// mybatis에서 sql문을 실행해줌
		sqlMapper.insert(mid, person);
	}

	@Override
	public List<PersonVO> dao_List(String mid) {  
		
		return sqlMapper.selectList(mid);  // 객체가 여러개이기 때문에 selectList을 사용
	}

	@Override
	public PersonVO dao_View(String mid, String id) {
		return sqlMapper.selectOne(mid, id); //객체를 하나만 넘기면 selectOne을 사용
	}

	@Override
	public void dao_Update(String mid, PersonVO person) {
		sqlMapper.update(mid, person);
	}

	@Override
	public void dao_Delete(String mid, String id) {
		sqlMapper.delete(mid, id);
	}

	@Override
	public int dao_Count(String mid) {
		return sqlMapper.selectOne(mid);
	}

	// 검색(전체보기)
	@Override
	public List<PersonVO> dao_searchList(String mid, HashMap<String, String> hm) {
		return sqlMapper.selectList(mid, hm);  //mybatis는 인자값을 2개까지만 인식함
	}

	// 검색(개수)
	@Override
	public int dao_searchCount(String mid, HashMap<String, String> hm) {
		return sqlMapper.selectOne(mid, hm);
	}

	

}
