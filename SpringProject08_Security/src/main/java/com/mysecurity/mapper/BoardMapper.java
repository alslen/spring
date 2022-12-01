package com.mysecurity.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mysecurity.dto.BoardDTO;

public interface BoardMapper {

	// 추가 insert()
	@Insert("insert into board(title,writer,content,regdate) values(#{title},#{writer},#{content},now())")
	public void insert(BoardDTO board);
	
	// 전체보기 list()
	@Select("select * from board")
	public List<BoardDTO> list();
	
	// 개수
	@Select("select count(*) from board")
	public int getCount();
	
	// 상세보기 findByNum()
	@Select("select * from board where num=#{num}")
	public BoardDTO findByNum(int num);
	
	// 조회수
	@Update("update board set hitcount=hitcount+1 where num=#{num}")
	public void upReadCount(int num);
	
	// 삭제
	@Delete("delete from board where num=#{num}")
	public void delete(int num);
	
	// 수정
	@Update("update board set title=#{title}, content=#{content} where num=#{num}")
	public void update(BoardDTO board);
	
	// 댓글 개수 증감 updateReplyCnt()
	// @Param : 여러값들을 받아올 때 사용
	//-> Mybatis의 SQL 문장에 다수의 파라미터를 전달할 때는 전달되는 변수들에 꼭 @Param 어노테이션을 붙여줘야한다.
	@Update("update board set replycnt=replycnt+#{amount} where num=#{bnum}")
	public void updateReplyCnt(@Param("bnum") int bnum, @Param("amount") int amount);
}
