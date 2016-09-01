package com.labs.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.labs.users.services.DbService;

@Controller
public class MainController {

	private static final Logger logger = Logger.getLogger(MainController.class);
	
	@Autowired
	private DbService dbService;
	
	@RequestMapping(value = { "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {
		System.out.println("welcome controller");
		ModelAndView model = new ModelAndView();
		//model.addObject("message", "This is default page!");
		model.addObject("pageURL", "patientForm");
		model.setViewName("base");
		return model;
	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {
		System.out.println("admin controller");
		ModelAndView model = new ModelAndView();
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName("base");
		return model;
	}

	//To show login page only
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout ){
		System.out.println("/login called...");
		ModelAndView model = new ModelAndView();
		
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		
		model.addObject("pageURL", "loginForm");
		model.setViewName("base");
		return model;
	}

	// customize the error message // not using this method as such.
	private String getErrorMessage(HttpServletRequest request, String key) {

		Exception exception = (Exception) request.getSession().getAttribute(key);

		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = "Invalid username and password!";
		} else if (exception instanceof LockedException) {
			error = exception.getMessage();
		} else {
			error = "Invalid username and password!";
		}

		return error;
	}

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail.getUsername() + " doesn't have access to view this page !");

			model.addObject("username", userDetail.getUsername());
		}
		model.setViewName("accessDenied");
		return model;
	}

	@RequestMapping(value = { "/loginError" }, method = { RequestMethod.GET })
	public ModelAndView login_error(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("/loginError method called");
		if (!(auth instanceof AnonymousAuthenticationToken)) {
		    /* The user is logged in :) */
		    modelAndView.setViewName("patient/patient");
		    return modelAndView;
		}
		modelAndView.addObject("pageURL", "loginForm");
		model.addAttribute("message", "Invalid Username/Password combination.");
		modelAndView.setViewName("base");
		return modelAndView;
		}
}