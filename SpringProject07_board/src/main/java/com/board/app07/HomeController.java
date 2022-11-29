package com.board.app07;

import java.text.DateFormat;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myboard.dto.BoardDTO;
import com.myboard.dto.pageVO;
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
	// @RequestParam의 required가 true이기 때문에 값이 무조건 와야함. 하지만 검색을 하지 않으면 값이 null값이 들어오기 때문에 defaultValue의 값으로 공백을 줬음.
	@GetMapping({"/","list"})
	public String list(Model model, @RequestParam(name="field", defaultValue = "") String field, @RequestParam(name="word", defaultValue = "") String word, String PageNum) {
		int currentPage=PageNum==null?1:Integer.parseInt(PageNum);   // 현재 페이지
		int pageSize = 5;  // 한 화면에 보여지는 게시글 수
		
		//Object으로 한 이유는 String과 int형을 아우를 수 있는 형이기 때문에
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("field", field);
		hm.put("word", word);
		hm.put("pageStart", (currentPage-1)*pageSize);  // 몇번째 페이지의 첫번째 게시물의 숫자를 구함
		hm.put("pageSize", pageSize);    // 한 화면에 나오는 게시물 수
		
		List<BoardDTO> board = bservice.findeAll(hm); 
		int count = bservice.getCount(hm);
		pageVO page = new pageVO(count, currentPage, pageSize); 
		page.setField(field);
		page.setWord(word);
	
		model.addAttribute("rowNo", count-(currentPage-1)*pageSize);
		model.addAttribute("board", board);
		model.addAttribute("count", count);
		model.addAttribute("p", page);
	//	model.addAttribute("field", field);
	//	model.addAttribute("word", word);
		
		return "boardList";
	}
	
	
	@GetMapping("insert")
	public String insert(HttpSession session) {
		if(session.getAttribute("sMember")==null) {
			return "member/login";
		}
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
	@DeleteMapping("delete/{num}")   // @DeleteMapping으로 해줘야함
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
	
//	//수정
//	@PostMapping("update")
//	public String update(BoardDTO board) {
//		bservice.update(board);
//		return "redirect:/list";
//	}
	
	// 수정
	@PutMapping("update")  // put방식으로 넘기기 때문에 @PutMapping을 사용
	@ResponseBody  // 리턴을 문자열로 하기 위해 사용함
	public String update(@RequestBody BoardDTO board) {  // @RequestBody : JSON형태의 값을 받아오기 위해서 사용
		bservice.update(board);
		return "success";
	}
}
