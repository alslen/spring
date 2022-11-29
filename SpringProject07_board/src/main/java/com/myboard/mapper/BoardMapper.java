package com.myboard.mapper;

import java.util.HashMap;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.myboard.dto.BoardDTO;
import com.myboard.dto.FileBoardDTO;



public interface BoardMapper {

	// 추가(num은 auto increment로 주었기때문에 삽입을 하면 값이 자동으로 들어감)
	@Insert("insert into board(title,writer,content) values(#{title},#{writer},#{content})")
	public void insert(BoardDTO board);
	
	// 전체보기
	//@Select("select * from board")
	public List<BoardDTO> list(HashMap<String, Object> hm);
	
	// 개수
	//@Select("select count(*) from board")
	public int count(HashMap<String, Object> hm);
	
	// 상세보기
	@Select("select * from board where num=#{num}")
	public BoardDTO view(int num);
	
	// 삭제
	@Delete("delete from board where num=#{num}")
	public void delete(int num);
	
	// 수정
	//@Update("update board set title=#{title}, writer=#{writer}, content=#{content} where num=#{num}")
	public void update(BoardDTO board);
	
	//댓글 수 증감
	// @Param : 매개변수를 의미 -> 이것을 사용하지 않을 것 같으면 HashMap을 사용
	public void updateReplyCnt(@Param("bnum") int bnum, @Param("amount") int amount);  // 대응되어지는 이름으로 써줘야함.
	
	// 조회수
	@Update("update board set hitcount=hitcount+1 where num=#{num}")
	public void upReadCount(int num);
	
	// 파일 업로드 추가
	// #{fileImage} : Getter로 불러오기 때문에 DTO와 같은 이름으로 해줘야함
	@Insert("insert into fileboard(title,writer,content,fileimage) values(#{title},#{writer},#{content},#{fileImage})")
	public void fileInsert(FileBoardDTO fboard);
	
	// 파일 리스트
	@Select("select * from fileboard")
	public List<FileBoardDTO> fileList();

}
