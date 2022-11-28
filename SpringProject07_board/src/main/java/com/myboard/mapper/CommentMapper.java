package com.myboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.myboard.dto.CommentDTO;

public interface CommentMapper {

	// ��� �߰�
	public void insert(CommentDTO comment);
	
	// ��� ��ü����
	public List<CommentDTO> getList(int bnum);
	
	// ��ۻ���
	public void delete(int cnum);
	
	//read
	@Select("select * from commentboard where cnum=#{cnum}")
	public CommentDTO read(int cnum);
}
