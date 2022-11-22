package com.person2.model;

import java.util.List;


public interface Person2DAO {

		// 추가
		public void person_Insert(PersonVO person);
		// 전체보기
		public List<PersonVO> person_List();
		// 상세보기
		public PersonVO person_View(String id);
		// 수정
		public void Person_Update(PersonVO person);
		// 삭제
		public void Person_Delete(String id);
		//개수
		public int person_Count();
}
