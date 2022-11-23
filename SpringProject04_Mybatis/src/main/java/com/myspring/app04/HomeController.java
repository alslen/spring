package com.myspring.app04;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myspring.model.PersonService;
import com.myspring.vo.PersonVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired  // 만든 객체를 주입시키기 위해 사용
	private PersonService service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	//@RequestMapping("per_insert")
	@GetMapping("per_insert")
	public String insert() {
		return "insert";
	}
	
	@PostMapping("per_insert")
	public String insert(@ModelAttribute PersonVO person) { //@ModelAttribute 생략가능
		service.insert(person);
		return "redirect:per_list";
	}
	
	@GetMapping("per_list")
	public String list(@RequestParam(required = false)String field, @RequestParam(required = false)String word, Model model) {  // 값을 담기 위해 Model을 사용
	// @RequestParam 넘어오는 값을 전달 -> 처음에는 field, word값이 넘어오는 것이 없어서 오류가 남
	// -> (required = false)를 추가해주면 됨
	//	List<PersonVO> arr = service.listAll();
	//	int count = service.countAll();
		List<PersonVO> arr = service.list(field, word);
		int count = service.count(field, word);
		
		model.addAttribute("personlist", arr);
		model.addAttribute("count", count);
		return "list";
	}
	
	@GetMapping({"view","update"})
	public void view(String id, Model model) {
		PersonVO person = service.view(id);
		model.addAttribute("person", person);
		
	}
	
	// 수정하기
	@PostMapping("update")
	public String update(PersonVO person, Model model) {
		service.update(person);
		return "redirect:per_list";
	}
	
	// 삭제
	@GetMapping("per_delete")
	public String delete(String id) {
		service.delete(id);
		return "redirect:per_list";
	}
	
}
