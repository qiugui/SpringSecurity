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
	
	
	/**   
	 * @Title: errorpage   
	 * @Description: 配置403页面的控制器
	 * @param modelMap
	 * @param principal
	 * @return        
	 */
	 
	@RequestMapping(value="/403", method = RequestMethod.GET)
	public String errorpage(ModelMap modelMap,Principal principal){
		modelMap.addAttribute("message", "你没有访问权限");
		modelMap.addAttribute("username", principal.getName());
		return "403";
	}

}
