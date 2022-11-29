package com.myboard.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.myboard.dto.MemberDTO;



public interface MemberMapper {

	// Join
	@Insert("insert into member values(#{id},#{name},#{pass},#{addr},now())")
	public void join(MemberDTO member);
	
	// 아이디 중복 확인
	// id값이 있으면 count를 반환해줌.
	@Select("select count(*) from member where id=#{id}")
	public int idCheck(String id);
	
	// 로그인 체크
	@Select("select * from member where id=#{id}")
	public MemberDTO loginCheck(String id);
	
	//수정
	@Update("update member set pass=#{pass}, name=#{name}, addr=#{addr}, regdate=now() where id=#{id}")
	public void update(MemberDTO member);

}
