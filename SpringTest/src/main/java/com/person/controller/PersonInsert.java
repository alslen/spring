package com.person.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.person.model.Person;
import com.person.model.PersonDAOImpl;

public class PersonInsert extends AbstractController{

	private PersonDAOImpl dao;
	//setter
	public void setDao(PersonDAOImpl dao) {
		this.dao = dao;  // 외부에 만들었던 dao가 주입된다.
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Person person = new Person();
		person.setGender(req.getParameter("gender"));
		person.setId(req.getParameter("id"));
		person.setJob(req.getParameter("job"));
		person.setName(req.getParameter("name"));
		person.setPassword(req.getParameter("password"));

		dao.personInsert(person);  // dao라는 객체가 주입되었기에 함수를 부를 수 있음
		
		return new ModelAndView("redirect:personList.sp");
	}

}
