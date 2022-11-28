package com.myboard.mapper;

import java.util.HashMap;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.myboard.dto.BoardDTO;

public interface BoardMapper {

	// �߰�(num�� auto increment�� �־��⶧���� ������ �ϸ� ���� �ڵ����� ��)
	@Insert("insert into board(title,writer,content) values(#{title},#{writer},#{content})")
	public void insert(BoardDTO board);
	
	// ��ü����
	//@Select("select * from board")
	public List<BoardDTO> list(HashMap<String, Object> hm);
	
	// ����
	//@Select("select count(*) from board")
	public int count(HashMap<String, Object> hm);
	
	// �󼼺���
	@Select("select * from board where num=#{num}")
	public BoardDTO view(int num);
	
	// ����
	@Delete("delete from board where num=#{num}")
	public void delete(int num);
	
	// ����
	//@Update("update board set title=#{title}, writer=#{writer}, content=#{content} where num=#{num}")
	public void update(BoardDTO board);
	
	//��� �� ����
	// @Param : �Ű������� �ǹ� -> �̰��� ������� ���� �� ������ HashMap�� ���
	public void updateReplyCnt(@Param("bnum") int bnum, @Param("amount") int amount);  // �����Ǿ����� �̸����� �������.
	
	// ��ȸ��
	@Update("update board set hitcount=hitcount+1 where num=#{num}")
	public void upReadCount(int num);

}
