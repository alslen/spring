package com.myspring.model;

import java.util.HashMap;
import java.util.List;

import com.myspring.vo.PersonVO;


public interface PersonDAO {

				// 추가
				public void dao_Insert(String mid, PersonVO person);
				// 전체보기
				public List<PersonVO> dao_List(String mid);
				public List<PersonVO> dao_searchList(String mid, HashMap<String, String> hm);
				// 상세보기
				public PersonVO dao_View(String mid, String id);
				// 수정
				public void dao_Update(String mid, PersonVO person);
				// 삭제
				public void dao_Delete(String mid, String id);
				//개수
				public int dao_Count(String mid);
				public int dao_searchCount(String mid, HashMap<String, String> hm);
}
