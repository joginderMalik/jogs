package com.labs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.labs.users.services.DbService;

@Controller
public class PatientController {
	
	@Autowired 
	DbService dbService;

	@RequestMapping(value = "/bookTest", method = RequestMethod.GET)
	public ModelAndView login(){
		System.out.println("/book Test called...");
		ModelAndView model = new ModelAndView();
		model.addObject("pageURL", "bookTestForm");
		model.setViewName("base");
		return model;
	}

	
}
