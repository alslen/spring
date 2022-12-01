package com.mysecurity.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomLoginSuccess implements AuthenticationSuccessHandler{

	@Autowired  // 객체형이 같으면 주입된다.
	private PasswordEncoder passwordEncoder;  // PasswordEncoder(부모)와 BCryptPasswordEncoder(자식)은 상속관계에 있음
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		String encPwd = passwordEncoder.encode(request.getParameter("password"));
		System.out.println("password : "+encPwd);
		List<String> roleNames = new ArrayList();
		authentication.getAuthorities().forEach(authority -> roleNames.add(authority.getAuthority()));
		System.out.println("roleNames : "+roleNames);
		response.sendRedirect("/app08/board/list");
	}
}
