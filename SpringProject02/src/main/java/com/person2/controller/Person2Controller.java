package com.person2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.person2.model.Person2DAOImpl;
import com.person2.model.PersonVO;

@Controller
public class Person2Controller {
	@Autowired  // @Autowired은 외부에 있는 값들을 주입시켜줌
	private Person2DAOImpl dao;
	// 추가폼
	@RequestMapping("person_insert.go")
	public String person_insert() {  // get 방식(기본)
		return "personForm";
	}
	
	//추가
	@RequestMapping(value= "person_insert.go", method=RequestMethod.POST) // post 방식
	public String person_insert(PersonVO person) {  // person에 들어있는 값이 자동으로 들어감, 단, personForm.jsp의 name과 같은 값으로 해줘야함
		dao.person_Insert(person);
		return "redirect:person_list.go";
	}
	
	// 전체보기
	@RequestMapping("person_list.go")
	public String list(Model model) {
		List<PersonVO> arr = dao.person_List();
		model.addAttribute("personlist", arr);
		return "personList";
	}
	//public ModelAndView list() {
		//List<PersonVO> arr = dao.person_List();
		//ModelAndView mv = new ModelAndView();
		//mv.addObject("personlist", arr);  
		//mv.setViewName("personList");
		//return mv;
	//}
	
	// 상세보기
	@RequestMapping("person_view.go")
	public String view(String id, Model model) {
		PersonVO person = dao.person_View(id);
		model.addAttribute("person", person);
		return "personView";
	}
//	public ModelAndView view(String id) {  // id값을 받아오기 때문에 매개변수로 넣어주었음(같은 이름으로 해야지 자동으로 값을 받아옴)
//		ModelAndView mv = new ModelAndView();
//		PersonVO person = dao.person_View(id);
//		mv.addObject("person", person);
//		mv.setViewName("personView");
//		return mv;
//	}
	
	// 수정 폼
	@RequestMapping("person_update.go")
	public String updateForm(Model model, String id) {
		model.addAttribute("person", dao.person_View(id));
		return "personUpdateForm";
	}
	// 수정
	@RequestMapping(value="person_update.go", method=RequestMethod.POST)
	public String update(PersonVO person) {
		dao.Person_Update(person);
		return "redirect:person_list.go";
	}
	
	// 삭제
	@RequestMapping("person_delete.go")
	public String delete(String id) {
		dao.Person_Delete(id);
		return "redirect:person_list.go";
	}
}
