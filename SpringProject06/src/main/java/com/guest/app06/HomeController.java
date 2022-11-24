package com.guest.app06;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	// �߰�
		@PostMapping("insert")
		@ResponseBody  // View�� �ƴ� ���� return �Ǳ� ���ϱ� ������ ���
		// GuestVO guest�� ���� Form �±� �ȿ� �ִ� ������ �޾ƿ�����
		// @RequestBody�� ����ϸ� ���̽� ���·� ���� �޾ƿ´�.
		public String insert(@RequestBody GuestVO guest, HttpServletRequest request) {
			// getRemoteAddr()�� ip���� ���ؿ�
			//guest.setIpaddr(request.getRemoteAddr());  // ip���� �־��ֱ� ���� HttpServletRequest��ü�� �������
			service.guestInsert(guest);
			return "success";  //success��� ���ڿ��� return������
		}
		
		@GetMapping("list")
		@ResponseBody  // View�� �ƴ� ���� return �Ǳ� ���ϱ� ������ ���
		public GuestListVO list() {
			List<GuestVO> arr = service.guestList(null);
			int count = service.guestCount(null);
			GuestListVO listvo = new GuestListVO(arr, count);
			return listvo;
		}
		
		@GetMapping("view")
		@ResponseBody
		public String view(int num) {
			GuestVO guest = service.findByNum(num);
			JSONObject obj = new JSONObject();
			obj.put("name", guest.getName());
			obj.put("num", guest.getNum());
			obj.put("content", guest.getContent());
			obj.put("grade", guest.getGrade());
			obj.put("created", guest.getCreated());
			obj.put("ipaddr", guest.getIpaddr());
			
			return obj.toJSONString();
		}
	
}
