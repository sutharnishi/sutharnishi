package com.project.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.CityVO;
import com.project.service.CityService;

@Controller
public class CityController 
{
   @Autowired
   CityService cityService;
   
   @RequestMapping(value="admin/loadCity")
   public ModelAndView LoadPage()
   {
	   return new ModelAndView("admin/addCity","cityData",new CityVO());
   }
   
   @RequestMapping(value="admin/insertCity",method=RequestMethod.POST)
	public ModelAndView insertcity(@ModelAttribute CityVO cityVO)
	{
		this.cityService.insertCity(cityVO);
		return new ModelAndView("redirect:/admin/loadCity");
	}
   
   @RequestMapping(value="admin/viewCity",method=RequestMethod.GET)
   public ModelAndView viewcity(@ModelAttribute CityVO cityVO)
   {
	   List cityList=this.cityService.searchCity(cityVO);
	   
	   System.out.println("List==========="+cityList.size());
	   return new ModelAndView("admin/viewcity","citylist",cityList);
   }
   
   @RequestMapping(value="admin/deleteCity",method=RequestMethod.GET)
   public ModelAndView deletecity(@ModelAttribute CityVO cityVO,HttpServletRequest request)
   {	
	   int id = Integer.parseInt(request.getParameter("cityid"));
	   cityVO.setCityid(id);
	   List cityList=this.cityService.deleteCity(cityVO);
	   
	   cityVO = (CityVO)cityList.get(0);
		
	   cityVO.setCityStatus(false);
		this.cityService.updateCity(cityVO);
	   return new ModelAndView("redirect:/admin/viewCity");
   }
   
   @RequestMapping(value="admin/editCity",method=RequestMethod.GET)
   public ModelAndView editcity(@ModelAttribute CityVO cityVO, @RequestParam ("cityid")int id)
   {
		cityVO.setCityid(id);
		 List ls=cityService.editCity(cityVO);
		 return new ModelAndView("admin/editcity","editlist",(CityVO)ls.get(0));
   }
   
   @RequestMapping(value="admin/updateCity",method=RequestMethod.POST)
   public ModelAndView updatecity(@ModelAttribute CityVO cityVO)
   {
	   this.cityService.updateCity(cityVO);
	   return new ModelAndView("redirect:/admin/viewCity");
   }
   
}

