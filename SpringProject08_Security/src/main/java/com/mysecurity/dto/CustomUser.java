package com.mysecurity.dto;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;

// security가 적용된 것
@Getter @Setter
public class CustomUser extends User{  //UserDetails를 상속받아도 괜찮음.

	private MemberDTO member;
	
	public CustomUser(MemberDTO vo) {
		super(vo.getUserid(), 
			vo.getUserpw(), 
			vo.getAuthList().stream()
			.map(auth->new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList())
			);  // 생성자
		member = vo;
	}
}
