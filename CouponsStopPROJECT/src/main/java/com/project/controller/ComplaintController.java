package com.project.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.ComplaintVO;
import com.project.model.LoginVO;
import com.project.service.ComplaintService;
import com.project.service.LoginService;
import com.project.utils.Basemethods;


@Controller
public class ComplaintController {

	@Autowired
	ComplaintService complaintService;
	
	
	@Autowired
	LoginService loginService;
	
	
	@RequestMapping(value="/user/loadComplaint",method=RequestMethod.GET)
	public ModelAndView loadComplaint(@ModelAttribute ComplaintVO complaintVO){
		return new ModelAndView("user/addComplaint","ComplaintVO", new ComplaintVO());
	}
	
	@RequestMapping(value="/user/insertComplaint",method=RequestMethod.POST)
	public ModelAndView insertComplaint(@ModelAttribute ComplaintVO complaintVO){
		
		Date d = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		complaintVO.setComplaintDate(dateFormat.format(d));

		String userName = Basemethods.getUser();

		List loginList  = loginService.searchLoginID(userName);
		
		LoginVO loginVO2 = (LoginVO) loginList.get(0);
		complaintVO.setLoginVO(loginVO2);
		
		complaintVO.setComplainStatus("PENDING");
		this.complaintService.insertComplaint(complaintVO);
		return new ModelAndView("redirect:/user/loadComplaint");
	}
	
	@RequestMapping(value="/admin/viewComplaint",method=RequestMethod.GET)
	public ModelAndView viewComplain() {
		
		List complaintList = this.complaintService.viewComplaint();
		
		return new ModelAndView("/admin/viewComplain","complaintList",complaintList);
		
	}
	
	@RequestMapping(value="admin/replytoUser",method=RequestMethod.GET)
	public ModelAndView loadReply(@RequestParam("id")int id,@ModelAttribute ComplaintVO complaintVO) {
		
		
		complaintVO.setId(id);
		
		List complaintList = this.complaintService.searchComplaint(complaintVO);
		
		return new ModelAndView("admin/addReply","complaintVO",complaintList.get(0));
	}
	
	@RequestMapping(value="admin/insertReply",method=RequestMethod.POST)
	public ModelAndView insertReply(@ModelAttribute ComplaintVO complaintVO) {
		
		Date d = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		
		complaintVO.setReplyDate(dateFormat.format(d));
		complaintVO.setComplainStatus("resolved");
		
		this.complaintService.insertComplaint(complaintVO);
		
		return new ModelAndView("redirect:/admin/viewComplaint");
	}
	
	@RequestMapping(value="user/seeComplaint",method=RequestMethod.GET)
	public ModelAndView seeComplaint(@ModelAttribute ComplaintVO complaintVO) {
		
		
		String userName = Basemethods.getUser();

		List loginList  = loginService.searchLoginID(userName);
    	
    	/*System.out.println(userName);*/
		
		LoginVO loginVO2 = (LoginVO) loginList.get(0);
		
		complaintVO.setLoginVO(loginVO2);
		
		List complaintList = this.complaintService.seeComplaint(complaintVO);
		
		return new ModelAndView("/user/viewComplain","complaintList",complaintList);
		
	}
}
