package com.myspring.app05;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myspring.model.GuestDTO;
import com.myspring.model.GuestService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired // 인젝트를 시키기 위해 사용
	private GuestService service;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "insert";
	}
	// 추가
	@PostMapping("ginsert")
	public String insert(GuestDTO guest, HttpServletRequest request) {
		guest.setIpaddr(request.getRemoteAddr());
		service.guesetInsert(guest);
		return "redirect:glist";
	}
	// 전체보기
	@GetMapping("glist")
	public String list(String field, String word, Model model) {
		HashMap<String, String> hm = new HashMap<String, String>();
		//Map<String, String> hm = new HashMap<String, String>();
		hm.put("field", field);
		hm.put("word", word);
		
		List<GuestDTO> guest = service.guestList(hm);
		int count = service.guestCount(hm);
		
		// list.jsp에 값을 전달하기 위해 Model을 사용
		model.addAttribute("guest", guest);
		model.addAttribute("count", count);
		return "list";
	}
	
}
