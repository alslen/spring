package com.guest.app06;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guest.model.GuestListVO;
import com.guest.model.GuestService;
import com.guest.model.GuestVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
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
		@PostMapping("insert")
		@ResponseBody  // View가 아닌 것이 return 되기 원하기 때문에 사용
		// GuestVO guest은 원래 Form 태그 안에 있는 값들을 받아오지만
		// @RequestBody을 사용하면 제이슨 형태로 값을 받아온다.
		public String insert(@RequestBody GuestVO guest, HttpServletRequest request) {
			// getRemoteAddr()는 ip값을 구해옴
			//guest.setIpaddr(request.getRemoteAddr());  // ip값을 넣어주기 위해 HttpServletRequest객체를 사용했음
			service.guestInsert(guest);
			return "success";  //success라는 문자열을 return시켜줌
		}
		
		@GetMapping("list")
		@ResponseBody  // View가 아닌 것이 return 되기 원하기 때문에 사용
		public GuestListVO list(@RequestParam(name="field")String field, @RequestParam(name="word")String word) {
			HashMap<String, String> hm = new HashMap<String, String>();
			hm.put("field", field);
			hm.put("word", word);
			
			List<GuestVO> arr = service.guestList(hm);
			int count = service.guestCount(hm);
			
			GuestListVO listvo = new GuestListVO(arr, count);
			return listvo;
		}
		
		// 상세보기
//		@GetMapping("view")
//		@ResponseBody
//		public String view(int num) {
//			GuestVO guest = service.findByNum(num);
//			JSONObject obj = new JSONObject();
//			obj.put("name", guest.getName());
//			obj.put("num", guest.getNum());
//			obj.put("content", guest.getContent());
//			obj.put("grade", guest.getGrade());
//			obj.put("created", guest.getCreated());
//			obj.put("ipaddr", guest.getIpaddr());
//			
//			return obj.toJSONString();
//		}
		
		@GetMapping("view")
		@ResponseBody
		public GuestVO view(@RequestParam(name="num", required = false)int num) {
			return service.findByNum(num);
		}
		
		// 삭제
		@DeleteMapping("delete/{num}")
		@ResponseBody
		public String delete(@PathVariable int num) {
			service.guestDelete(num);
			return "success";
		}
	
}
