 package com.springsecurity.accesshandle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
 /** 
* @ClassName: MyAccessDeniedHandler 
* @Description: 403权限禁止访问的处理器 
* @author qiugui 
* @date 2015年3月6日 下午5:18:52 
*  
*/ 
public class MyAccessDeniedHandler implements AccessDeniedHandler{

	 private String accessDeniedUrl;
	 
	public String getAccessDeniedUrl() {
		return accessDeniedUrl;
	}

	public void setAccessDeniedUrl(String accessDeniedUrl) {
		this.accessDeniedUrl = accessDeniedUrl;
	}

	public MyAccessDeniedHandler() {
	}

	public MyAccessDeniedHandler(String accessDeniedUrl) {
		this.accessDeniedUrl = accessDeniedUrl;
	}

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		
		 response.sendRedirect(accessDeniedUrl);
		 request.getSession().setAttribute("message", "你没有权限访问这个页面！");
	}
	 
}

 