package com.myboard.model;

import java.util.List;

import com.myboard.dto.CommentDTO;

public interface CommentService {

	// �߰�
	public void insert(CommentDTO comment);
	// ��ü����
	public List<CommentDTO> getList(int bnum);
	// ����
	public void delete(int cnum);
	
}