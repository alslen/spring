package com.mysecurity.app08;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysecurity.dto.BoardDTO;
import com.mysecurity.service.BoardService;

@RequestMapping("/board/*")
@Controller
public class BoardController {

	
	@Autowired
	private BoardService bservice;
	
	@GetMapping("insert")
	@PreAuthorize("isAuthenticated()") // 미리 권한을 검색 -> 권한을 획득했다면 글쓰기 페이지로 이동, 권한이 없다면 로그인페이지로 이동
	public void insert() {
		
	}
	
	@PostMapping("insert")
	public String insert(BoardDTO board) {
		bservice.insert(board);
		return "redirect:list";
	}
	
	@GetMapping("list")
	public String list(Model model) {
		List<BoardDTO> board = bservice.list();
		model.addAttribute("count", bservice.getCount());
		model.addAttribute("board", board);
		return "board/list";
	}
	@GetMapping("view/{num}")
	public String view(@PathVariable int num, Model model) {
		BoardDTO board = bservice.findByNum(num);
		model.addAttribute("board", board);
		return "board/view";
	}
	
//	@GetMapping("delete/{num}")
//	public String delete(@PathVariable int num) {
//		bservice.delete(num);
//		return "redirect:/board/list";
//	}
	
	// 삭제
	@DeleteMapping("delete/{num}")
	@ResponseBody
	public String delete(@PathVariable int num) {
		bservice.delete(num);
		return "success";
	}
	
	// 수정폼
	@GetMapping("update/{num}")
	public String update(@PathVariable int num, Model model) {
		BoardDTO board = bservice.findByNum(num);
		model.addAttribute("board", board);
		return "board/update";
	}
	
	// 수정
	@PutMapping("update")
	@ResponseBody
	public String update(@RequestBody BoardDTO board) {
		bservice.update(board);
		return "success";
	}
	
}
