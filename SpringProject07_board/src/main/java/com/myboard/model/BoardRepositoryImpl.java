package com.myboard.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myboard.dto.BoardDTO;
import com.myboard.dto.FileBoardDTO;
import com.myboard.mapper.BoardMapper;



@Repository
public class BoardRepositoryImpl implements BoardRepository{

	@Autowired
	private BoardMapper bmapper;

	public void dao_insert(BoardDTO board) {
		bmapper.insert(board);
	}

	public List<BoardDTO> dao_findeAll(HashMap<String, Object> hm) {
		return bmapper.list(hm);
	}

	public BoardDTO dao_findByNum(int num) {
		return bmapper.view(num);
	}

	public void dao_update(BoardDTO board) {
		bmapper.update(board);
	}

	public void dao_delete(int num) {
		bmapper.delete(num);
	}

	public int dao_getCount(HashMap<String, Object> hm) {
		return bmapper.count(hm);
	}

	public void dao_upReadCount(int num) {
		bmapper.upReadCount(num);
	}

	public void dao_fileInsert(FileBoardDTO board) {
		bmapper.fileInsert(board);
	}

	public List<FileBoardDTO> dao_fileList() {
		
		return bmapper.fileList();
	}
	
	

}
