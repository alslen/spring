package com.myboard.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myboard.dto.BoardDTO;
import com.myboard.dto.FileBoardDTO;



@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardRepository brepository;

	public void insert(BoardDTO board) {
		brepository.dao_insert(board);
	}

	public List<BoardDTO> findeAll(HashMap<String, Object> hm) {
		return brepository.dao_findeAll(hm);
	}

	public BoardDTO findByNum(int num) {
		brepository.dao_upReadCount(num); 
		return brepository.dao_findByNum(num);
	}

	public void update(BoardDTO board) {
		brepository.dao_update(board);
	}

	public void delete(int num) {
		brepository.dao_delete(num);
	}

	public int getCount(HashMap<String, Object> hm) {
		return brepository.dao_getCount(hm);
	}

	public void fileInsert(FileBoardDTO board) {
		brepository.dao_fileInsert(board);
	}

	public List<FileBoardDTO> fileList() {
	
		return null;
	}
	
	

}
