package com.mysecurity.app08;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysecurity.dto.CommentDTO;
import com.mysecurity.dto.CommentListVO;
import com.mysecurity.service.CommentService;

@RestController  // Controller + ResponseBody -> JSON형태로 리턴된다.
@RequestMapping("/reply/*")
public class CommentController {

	@Autowired
	private CommentService cservice;
	
	@PostMapping("commentInsert")
	public String insert(@RequestBody CommentDTO comment) {
		cservice.insert(comment);
		return "success";
	}
	
	@GetMapping("commentList/{bnum}")
	public CommentListVO list(@PathVariable int bnum) {
		
		List<CommentDTO> carr = cservice.list(bnum);
		int count = cservice.getCount(bnum);
//		HashMap<Object,Object> hm = new HashMap<Object, Object>();
//		hm.put("carr", carr);
//		hm.put("count", count);
		
		CommentListVO cvo = new CommentListVO(carr, count);  
		return cvo;  // 리턴값을 무조건 하나만 넘겨줘야함. -> Map으로 만들어주어도 괜찮음.
	}
	
	// 댓글삭제
	@DeleteMapping("commentDelete/{cnum}")
	public int delete(@PathVariable int cnum) {
		cservice.delete(cnum);
		return cnum;
	}
}
