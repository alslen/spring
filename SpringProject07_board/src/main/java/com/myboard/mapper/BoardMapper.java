package com.myboard.mapper;

import java.util.HashMap;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.myboard.dto.BoardDTO;

public interface BoardMapper {

	// 추가(num은 auto increment로 주었기때문에 삽입을 하면 값이 자동으로 들어감)
	@Insert("insert into board(title,writer,content) values(#{title},#{writer},#{content})")
	public void insert(BoardDTO board);
	
	// 전체보기
	@Select("select * from board")
	public List<BoardDTO> list(HashMap<String, Object> hm);
	
	// 개수
	@Select("select count(*) from board")
	public int count(HashMap<String, Object> hm);
	
	// 상세보기
	@Select("select * from board where num=#{num}")
	public BoardDTO view(int num);
	
	@Delete("delete from board where num=#{num}")
	public void delete(int num);
	
	@Update("update board set title=#{title}, writer=#{writer}, content=#{content} where num=#{num}")
	public void update(BoardDTO board);

}
