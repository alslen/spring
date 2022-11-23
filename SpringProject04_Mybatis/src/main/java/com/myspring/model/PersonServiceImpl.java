package com.myspring.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.vo.PersonVO;

@Service  // 서비스는 @Service라는 어노테이션을 사용(객체를 만들어줌)
public class PersonServiceImpl implements PersonService{

	@Autowired  // 만든 객체를 연결
	private PersonDAO dao;
	// 추가
	@Override
	public void insert(PersonVO person) {
		// insertPerson은 Person.xml의 id로 들어감
		dao.dao_Insert("insertPerson", person);  // dao_insert를 부르는 기능만 함(현재는)
	}

	// 전체보기
	@Override
	public List<PersonVO> listAll() {

		return dao.dao_List("listPerson");
	}

	// 상세보기
	@Override
	public PersonVO view(String id) {
		return dao.dao_View("viewPerson", id);
	}

	// 수정
	@Override
	public void update(PersonVO person) {
		dao.dao_Update("updatePerson", person);
	}
	
	// 삭제
	@Override
	public void delete(String id) {
		dao.dao_Delete("deletePerson", id);
	}

	@Override
	public int countAll() {
		return dao.dao_Count("countPerson");
	}

	// 검색(전체보기)
	@Override
	public List<PersonVO> list(String field, String word) {
		HashMap<String, String> hm = new HashMap<String, String>();  
		hm.put("field", field);
		hm.put("word", word);
		return dao.dao_searchList("searchPerson", hm);
	}

	// 검색(개수)
	@Override
	public int count(String field, String word) {
		HashMap<String, String> hm = new HashMap<String, String>();  
		hm.put("field", field);
		hm.put("word", word);
		return dao.dao_searchCount("searchCount", hm);
	}

}
