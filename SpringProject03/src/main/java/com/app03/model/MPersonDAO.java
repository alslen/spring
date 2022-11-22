package com.app03.model;

import java.util.List;

public interface MPersonDAO {
			
			// 추가
			public void person_Insert(PersonDTO person);
			// 전체보기
			public List<PersonDTO> person_List();
			// 상세보기
			public PersonDTO person_View(String id);
			// 수정
			public void Person_Update(PersonDTO person);
			// 삭제
			public void Person_Delete(String id);
			//개수
			public int person_Count();
}
