package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.AreaVO;
import com.project.model.CityVO;
import com.project.service.AreaService;
import com.project.service.CityService;

@Controller
public class AreaController
{
	@Autowired
	AreaService areaService;
	
	@Autowired
	CityService cityService;
	
	@RequestMapping(value="admin/loadArea")
	public ModelAndView loadpage(CityVO cityVO)
	{
		List cityList = this.cityService.searchCity(cityVO);
		return new ModelAndView("admin/AddArea","areaData",new AreaVO()).addObject("cityList", cityList);
	}
	
	@RequestMapping(value="admin/insertArea",method=RequestMethod.POST)
	public ModelAndView insertarea(@ModelAttribute AreaVO areaVO)
	{
		areaService.insertArea(areaVO);
		return new ModelAndView("redirect:/admin/loadArea");
	}
	
	@RequestMapping(value="admin/viewArea",method=RequestMethod.GET)
	public ModelAndView viewarea(@ModelAttribute AreaVO areaVO)
	{
		List areaList=areaService.searchArea(areaVO);
		System.out.println("List==========="+areaList.size());
		return new ModelAndView("admin/viewarea","arealist",areaList);
	}
	
	@RequestMapping(value="admin/deleteArea",method=RequestMethod.GET)
	public ModelAndView deletearea(@ModelAttribute AreaVO areaVO,HttpServletRequest request)
	   {	
		
			
		
		   int id = Integer.parseInt(request.getParameter("areaId"));
		   areaVO.setAreaId(id);
		   List areaList=this.areaService.deleteArea(areaVO);
		   
		   areaVO = (AreaVO)areaList.get(0);
			
		   areaVO.setAreaStatus(false);
		  this.areaService.updateArea(areaVO);			
			
		   return new ModelAndView("redirect:/admin/viewArea");
	   }
	
	
	@RequestMapping(value="admin/editArea",method=RequestMethod.GET)
	   public ModelAndView editarea(@ModelAttribute AreaVO areaVO,CityVO cityVO,HttpServletRequest request)
	   {
		
		     List cityList = this.cityService.searchCity(cityVO);
		
		     int areaId = Integer.parseInt(request.getParameter("areaId"));
			 areaVO.setAreaId(areaId);
			 
			 List areaList=areaService.editArea(areaVO);
			 return new ModelAndView("admin/editArea","arealist",(AreaVO)areaList.get(0)).addObject("cityList", cityList);
	   }
	
	 @RequestMapping(value="admin/updateArea",method=RequestMethod.POST)
	   public ModelAndView updatearea(@ModelAttribute AreaVO areaVO)
	   {
		   this.areaService.updateArea(areaVO);
		   return new ModelAndView("redirect:/admin/viewArea");
	   }
	
	

	}
