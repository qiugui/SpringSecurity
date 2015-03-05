package com.springsecurity.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AdminController {
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String welcomeAdmin(ModelMap model,Principal principal) {
 
		model.addAttribute("message", "Spring Security - ROLE_ADMIN");
		model.addAttribute("username", principal.getName());
		return "admin";
 
	}

}
