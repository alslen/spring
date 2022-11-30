package com.mysecurity.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mysecurity.dto.CustomUser;
import com.mysecurity.dto.MemberDTO;
import com.mysecurity.mapper.MemberMapper;

public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private MemberMapper mapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername");
		//security가 적용x
		MemberDTO member = mapper.read(username);
		System.out.println("member : "+member);
		
		UserDetails user = new CustomUser(member);  //security가 적용
		System.out.println("user : "+user);
		return member==null?null:user;
	}

}
