package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.LoginVO;
import com.project.service.LoginService;
import com.project.utils.Basemethods;

@Controller
public class MainController extends Basemethods{
	
	@Autowired
	LoginService loginService;
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView loadLogin() {

		return new ModelAndView("login");
	}

	
	@RequestMapping(value = "/admin/index", method = RequestMethod.GET)
	public ModelAndView adminIndex(LoginVO loginVO ) {

		/*User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUsername();
		loginVO.setUsername(userName);
		List ls = this.loginService.searchLoginID(loginVO);
		LoginVO lVO= (LoginVO)ls.get(0);
		int loginId = lVO.getLoginId();
		System.out.println("loginID>>>>>>"+loginId);*/
		
		return new ModelAndView("admin/index");
	}
	
	@RequestMapping(value = "/user/index", method = RequestMethod.GET)
	public ModelAndView userIndex() {

		return new ModelAndView("user/homepage");
	}
	@RequestMapping(value = "/logout", method = {RequestMethod.POST, RequestMethod.GET})	
	public String viewUserDetails(ModelMap model,HttpServletResponse response,HttpServletRequest request) {

		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null) {
	            new SecurityContextLogoutHandler().logout(request, response, auth);
	            request.getSession().invalidate();
	            request.getSession().setAttribute("tempStatus", "success");
	            request.getSession().setAttribute("statusText", "Logout Successfully!");
	}
	        return "login";
	        }
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView load() {

		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView load403() {

		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "step1", method = RequestMethod.GET)
	public ModelAndView step1() {

		return new ModelAndView("ForgotPassword");
	}
	
	@RequestMapping(value="searchstep1",method = RequestMethod.POST)
	public ModelAndView searchstep1(@RequestParam("username") String un,LoginVO loginVO,HttpSession session)
	{
		System.out.println("USERNAME>>>"+un);
		session.setAttribute("username", un);
		loginVO.setUsername(un);

		List ls=this.loginService.searchstep1(loginVO);
		System.out.println("List size>>>>>>>>>"+ls.size());
		if(ls!=null && !ls.isEmpty())
		{
			int OTP=generateOTP(4);
			System.out.println("OTP>>>>>"+OTP);
			String subject="otp";
			String content="otp:"+OTP;
			sendMail(un,subject, content);
			session.setAttribute("generatedOTP",OTP);
			return new ModelAndView("EditPassword");
		}
		else
		{
			return new ModelAndView("redirect:/");	
		}   
	}
	
	@RequestMapping(value="step2", method = RequestMethod.POST)
	public ModelAndView step2(@RequestParam("password") String pwd ,LoginVO loginVO,HttpSession session)
	{
		String userName= (String)session.getAttribute("username");
		loginVO.setUsername(userName);
		loginVO.setPassword(pwd);
		
		this.loginService.updatePassword(loginVO);
		return new ModelAndView("redirect:/");
	}
	@RequestMapping(value = "/user/homepage", method = RequestMethod.GET)
	public ModelAndView userloadIndex() 
	{

		return new ModelAndView("user/homepage");
	}
}
