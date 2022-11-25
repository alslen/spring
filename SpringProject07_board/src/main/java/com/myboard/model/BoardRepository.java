package com.myboard.model;

import java.util.HashMap;
import java.util.List;

import com.myboard.dto.BoardDTO;

public interface BoardRepository {
		// �߰�
		public void dao_insert(BoardDTO board);
		// ��ü����
		public List<BoardDTO> dao_findeAll(HashMap<String, Object> hm);
		// �󼼺���
		public BoardDTO dao_findByNum(int num);
		// ����
		public void dao_update(BoardDTO board);
		// ����
		public void dao_delete(int num);
		// ����
		public int dao_getCount(HashMap<String, Object> hm);

}