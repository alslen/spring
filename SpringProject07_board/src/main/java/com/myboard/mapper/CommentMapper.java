package com.myboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.myboard.dto.CommentDTO;

public interface CommentMapper {

	// ¥Ò±€ √ﬂ∞°
	public void insert(CommentDTO comment);
	
	// ¥Ò±€ ¿¸√º∫∏±‚
	public List<CommentDTO> getList(int bnum);
	
	// ¥Ò±€ªË¡¶
	public void delete(int cnum);
	
	//read
	@Select("select * from commentboard where cnum=#{cnum}")
	public CommentDTO read(int cnum);
}
