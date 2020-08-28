package com.project.configuration;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.project.model.LoginVO;
import com.project.service.LoginService;

@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	
	@Autowired
	LoginService loginService;
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		// set our response to OK status
		response.setStatus(HttpServletResponse.SC_OK);

		
		HttpSession session = request.getSession();
		boolean admin = false;
		boolean user = false;
		
		System.out.println("AT onAuthenticationSuccess(...) function!");

		for (GrantedAuthority auth : authentication.getAuthorities()) {
			if ("ROLE_ADMIN".equals(auth.getAuthority())) {
				admin = true;
			}else if ("ROLE_USER".equals(auth.getAuthority())) {
				user = true;
			}else {
				
			}
		}

		if (admin) {
			System.out.println("user is admin");
		
			response.sendRedirect("/admin/index");
		} else if(user) {
			System.out.println("user is user");
			
			response.sendRedirect("/user/index");
		}else {
			System.out.println("user is anonymous");
			response.sendRedirect("/403");
		}
	}
	
	
}

