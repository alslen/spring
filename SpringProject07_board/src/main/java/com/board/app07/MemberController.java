package com.board.app07;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.SessionScope;

import com.myboard.dto.MemberDTO;
import com.myboard.model.memberService;

@RequestMapping("/member/*") 
@Controller
public class MemberController {
	@Autowired
	private memberService mservice;
	
	// 회원가입 폼
	@GetMapping("join")
	public void join() {
	}
	
	// 회원가입(아이디 중복확인, DB추가)
	@PostMapping("join")
	@ResponseBody  // 문자열 자체를 반환해주기 위해 사용(View로 반환x)
	public String join(@RequestBody MemberDTO member) {  // 제이슨 형태로 값을 받아오기 위해 @RequestBody를 사용
		int cnt = mservice.idCheck(member.getId());  // 아이디 중복확인
		
		// select한 결과 값이 있다는 의미
		if(cnt != 0) return "fail";  // 아이디 중복
		mservice.join(member);
		return "success";
	}
	
	// 로그인 폼
	@GetMapping("login")
	public void login() {
	
	}
	
	// 로그인 체크
	@PostMapping("login")
	@ResponseBody
	public String login(@RequestBody MemberDTO user, HttpSession session) {
		MemberDTO member = mservice.loginCheck(user.getId());
		if(member == null) {  // 회원이 아님
			return "no";
		}
		// user.getPass() 
		if(user.getPass().equals(member.getPass())) {  // 회원(비번맞음)
			session.setAttribute("sMember", member);
			return "success";
		} else {  // 비번틀림
			return "pError";
		}
	}
	
	// 로그아웃
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "member/login";
	}
	
	// 회원수정 폼 
	@GetMapping("update")
	public void update() {
		
	}
	
	@PutMapping("update")
	@ResponseBody
	public String update(@RequestBody MemberDTO member, HttpSession session) {
		mservice.update(member);
		session.invalidate();
		return "success";
	}
}
