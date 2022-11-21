package com.person.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.person.model.Person;
import com.person.model.PersonDAOImpl;

public class PersonList extends AbstractController{
	
	private PersonDAOImpl dao;
	
	public void setDao(PersonDAOImpl dao) {
		this.dao = dao;
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		List<Person> arr = dao.personList();
		ModelAndView mv = new ModelAndView();
		mv.addObject("personlist", arr);  // arr을 "personlist"라는 이름으로 저장함
		mv.setViewName("WEB-INF/jsp/personList.jsp");
		return mv;
	}
}
