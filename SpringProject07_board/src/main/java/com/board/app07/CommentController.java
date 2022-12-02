package com.board.app07;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myboard.dto.CommentDTO;
import com.myboard.dto.MemberDTO;
import com.myboard.model.CommentService;



@RequestMapping("/reply/*")  // 컨트롤러에 전체적으로 적용되는 것은 @RequestMapping을 사용함(전체적으로 적용하기 위해서 위로 올림)
//@Controller
@RestController  // @Controller + @ResponseBody -> @ResponseBody으로 다 받아진다면 @RestController로 만들어주면 됨
public class CommentController {

	@Autowired
	private CommentService cservice;
	
	// 댓글추가
	@PostMapping("commentInsert")
	//@ResponseBody // 문자열을 리턴해주기 위해서 사용
	public String insert(@RequestBody CommentDTO comment, HttpSession session) { // @RequestBody : 제이슨 형태로 값을 받기 때문에 사용
		String id = ((MemberDTO)session.getAttribute("sMember")).getId();
		comment.setUserid(id);
		cservice.insert(comment);
		return "success";
		}
	
//	// 댓글 전체보기
//	@GetMapping("commentList")
//	//@ResponseBody   // 전달하는 값이 view가 아니기 때문에 반드시 적어줘야함.
//	public List<CommentDTO> getList(int bnum) {  // 제이슨 형태의 문자열로 인식함.
//		return cservice.getList(bnum);  // 콜백됨.
//	}
	
	// 댓글 전체보기
	@GetMapping("commentList/{bnum}") 
	public List<CommentDTO> getList(@PathVariable int bnum){  // @PathVariable: bnum의 값을 받아오기 위해 사용
		return cservice.getList(bnum);
	}
	
	// 댓글삭제
	@DeleteMapping("delete/{cnum}")
	public int delete(@PathVariable int cnum) {
		cservice.delete(cnum);
		return cnum;   // 댓글번호를 반환하기 위해서 반환형을 int로 했음.
	}
}
