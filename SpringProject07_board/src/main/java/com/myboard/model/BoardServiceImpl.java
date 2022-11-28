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
	
	// �߰�
	@Override
	public void insert(BoardDTO board) {
		brepository.dao_insert(board);
	}

	// ��ü����
	@Override
	public List<BoardDTO> findeAll(HashMap<String, Object> hm) {
		
		return brepository.dao_findeAll(hm);
	}

	
	// �󼼺���
	@Override
	public BoardDTO findByNum(int num) {
		brepository.dao_upReadCount(num);  // ��ۼ�
		return brepository.dao_findByNum(num);
	}

	// ����
	@Override
	public void update(BoardDTO board) {
		brepository.dao_update(board);
	}

	// ����
	@Override
	public void delete(int num) {
		brepository.dao_delete(num);
	}

	// ����
	@Override
	public int getCount(HashMap<String, Object> hm) {
		
		return brepository.dao_getCount(hm);
	}

}
