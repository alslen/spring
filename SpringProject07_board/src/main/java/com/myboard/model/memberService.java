package com.myboard.model;

import com.myboard.dto.MemberDTO;


public interface memberService {

	// 추가
	public void join(MemberDTO member);
	// 아이디 중복 확인
	public int idCheck(String id);
	// 로그인 체크
	public MemberDTO loginCheck(String id);
	// 변경
	public void update(MemberDTO member);
	
}
