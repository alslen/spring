package com.myboard.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myboard.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardRepository brepository;
	
	// 추가
	@Override
	public void insert(BoardDTO board) {
		brepository.dao_insert(board);
	}

	// 전체보기
	@Override
	public List<BoardDTO> findeAll(HashMap<String, Object> hm) {
		
		return brepository.dao_findeAll(hm);
	}

	
	// 상세보기
	@Override
	public BoardDTO findByNum(int num) {
		brepository.dao_upReadCount(num);  // 댓글수
		return brepository.dao_findByNum(num);
	}

	// 수정
	@Override
	public void update(BoardDTO board) {
		brepository.dao_update(board);
	}

	// 삭제
	@Override
	public void delete(int num) {
		brepository.dao_delete(num);
	}

	// 개수
	@Override
	public int getCount(HashMap<String, Object> hm) {
		
		return brepository.dao_getCount(hm);
	}

}
