package com.board.app07;

import java.text.DateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myboard.dto.BoardDTO;
import com.myboard.model.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private BoardService bservice;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
//	 */
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		
//		return "list";
//	}
	
	// 추가
	@PostMapping("insert")
	public String insert(BoardDTO board) {
		bservice.insert(board);
		return "redirect:list";
	}
	
	// 전체보기
	@GetMapping({"/","list"})
	public String list(Model model) {
		//HashMap<String, Object> hm = new HashMap<String, Object>();
		
		List<BoardDTO> board = bservice.findeAll(null);
		int count = bservice.getCount(null);
		model.addAttribute("board", board);
		model.addAttribute("count", count);
		
		return "boardList";
	}
	
	
	@GetMapping("insert")
	public String insert() {
		return "boardInsert";
	}
	
	// 상세보기
	@GetMapping("view/{num}")
	public String view(@PathVariable int num, Model model) {
		BoardDTO board = bservice.findByNum(num);
		model.addAttribute("board", board);
		return "boardView";
	}
	
//	@GetMapping("delete/{num}")
//	public String delete(@PathVariable int num) {
//		bservice.delete(num);
//		return "redirect:/list";
//	}
//	
	
	// 삭제
	@DeleteMapping("delete/{num}")  // @DeleteMapping으로 해줘야함
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
		return "/update";
	}
	
	// 수정
	@PostMapping("update")
	public String update(BoardDTO board) {
		bservice.update(board);
		return "redirect:/list";
	}
	
}
