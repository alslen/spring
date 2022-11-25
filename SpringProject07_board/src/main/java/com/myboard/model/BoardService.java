package com.myboard.model;

import java.util.HashMap;
import java.util.List;

import com.myboard.dto.BoardDTO;

public interface BoardService {
	// �߰�
	public void insert(BoardDTO board);
	// ��ü����
	public List<BoardDTO> findeAll(HashMap<String, Object> hm);
	// �󼼺���
	public BoardDTO findByNum(int num);
	// ����
	public void update(BoardDTO board);
	// ����
	public void delete(int num);
	// ����
	public int getCount(HashMap<String, Object> hm);
}