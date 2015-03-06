 package com.springsecurity.controller;

import java.security.Principal;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
 
@Controller
public class LoginController {
	 
	@RequestMapping(value="/welcome",method = RequestMethod.GET)
	public String printWelcome(ModelMap model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("username", name);
		model.addAttribute("message", "Spring Security - ROLE_USER");
		return "hello";
	}
	 
	@RequestMapping(value="/login",method = RequestMethod.GET) 
	public String login(ModelMap model) {
		 return "login";
	 }
	 
	@RequestMapping(value="/loginfailed",method = RequestMethod.GET)
	 public String loginerror(ModelMap model){
		 model.addAttribute("error", "true");
		 return "login";
	 }
	 
	@RequestMapping(value="/logout",method = RequestMethod.GET)
	 public String loginout(ModelMap model) {
		 return "login";
	 }
	
	@RequestMapping(value="/dispatch",method = RequestMethod.GET)
	public View dispatch(ModelMap modelMap,HttpServletRequest request){
		String path = request.getContextPath();
		String basepath = request.getScheme()+"://"+request.getServerName()+":"
		+request.getServerPort()+path+"/";
		
		Set<String> roles = AuthorityUtils.authorityListToSet(
				SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		
		if(roles.contains("ROLE_ADMIN")){
			return new RedirectView(basepath+"app/admin");
		}else{
			return new RedirectView(basepath+"app/welcome");
		}
	}
}

 