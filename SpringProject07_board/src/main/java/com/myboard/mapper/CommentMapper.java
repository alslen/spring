package com.myboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.myboard.dto.CommentDTO;



public interface CommentMapper {

	// 댓글 추가
	public void insert(CommentDTO comment);
	
	// 댓글 전체보기
	public List<CommentDTO> getList(int bnum);
	
	// 댓글 삭제
	public void delete(int cnum);
	
	//read
	@Select("select * from commentboard where cnum=#{cnum}")
	public CommentDTO read(int cnum);
}
