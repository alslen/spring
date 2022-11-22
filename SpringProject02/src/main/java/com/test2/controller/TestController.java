package com.test2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 이것을 적으면 AbstractController를 상속받지 않아도 됨
public class TestController {
	@RequestMapping("test.go")  // test.go와 매핑
	public String test() { // String은 View를 가르킴
		System.out.println("test");
		return "result";  // result.jsp를 가리킴
	}
	
	@RequestMapping("test22.go")  
	public void test22() { // 반환형을 void를 사용하면 test22의 이름을 가지는 View를 찾는다.
	}
}
