package com.project.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.CartVO;
import com.project.model.CityVO;
import com.project.model.CouponVO;
import com.project.model.LoginVO;
import com.project.model.PackageVO;
import com.project.service.CartService;
import com.project.service.LoginService;
import com.project.service.PackageService;
import com.project.utils.Basemethods;

@Controller
public class PackageController 
{
	@Autowired
	PackageService packageService;
	
	@Autowired
	LoginService loginService;

	@Autowired
	CartService cartService;
	
	
	@RequestMapping(value="admin/loadPackage")
	public ModelAndView LoadPage()
	   {
		   return new ModelAndView("admin/addPackage","packageData",new PackageVO());
	   }
	
	@RequestMapping(value="admin/insertPackage",method=RequestMethod.POST)
	public ModelAndView insertpackage(@ModelAttribute PackageVO packageVO,@RequestParam ("file")MultipartFile file,  HttpServletRequest request)
	{
		String path =request.getSession().getServletContext().getRealPath("/");
		String FileName= file.getOriginalFilename();
		String FilePath = path + "documents\\packages\\";
		try 
		{
			byte barr[]=file.getBytes();  
	        BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream(FilePath+"/"+FileName));  
	        bout.write(barr);  
	        bout.flush();  
	        bout.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		packageVO.setFileName(FileName);
		packageVO.setFilePath(FilePath);
		
		
		this.packageService.insertPackage(packageVO);
		return new ModelAndView("redirect:/admin/loadPackage");
	}
	
	@RequestMapping(value="admin/viewPackage",method=RequestMethod.GET)
	   public ModelAndView viewPackage(@ModelAttribute PackageVO packageVO)
	   {
		   List packageList=this.packageService.viewPackage(packageVO);
		   
		   System.out.println("List==========="+packageList.size());
		   return new ModelAndView("admin/viewPackage","packagelist",packageList);
	   }
	
	@RequestMapping(value="admin/deletePackage",method=RequestMethod.GET)
   public ModelAndView deletePackage(@ModelAttribute PackageVO packageVO,HttpServletRequest request)
   {	
	   int packageId = Integer.parseInt(request.getParameter("packageId"));
	   packageVO.setPackageId(packageId);
	   List packageList=this.packageService.deletePackage(packageVO);
	   
	   packageVO = (PackageVO)packageList.get(0);
		
	   packageVO.setPackageStatus(false);
		this.packageService.updatePackage(packageVO);
	   return new ModelAndView("redirect:/admin/viewPackage");
   }
	
	
	@RequestMapping(value="admin/editPackage",method=RequestMethod.GET)
   public ModelAndView editPackage(@ModelAttribute PackageVO packageVO, @RequestParam ("packageId")int id)
   {
		packageVO.setPackageId(id);
		 List ls=packageService.editPackage(packageVO);
		 return new ModelAndView("admin/editPackage","packagelist",(PackageVO)ls.get(0));
   }
   
   @RequestMapping(value="admin/updatePackage",method=RequestMethod.POST)
   public ModelAndView updatecity(@ModelAttribute PackageVO packageVO)
   {
	   this.packageService.updatePackage(packageVO);
	   return new ModelAndView("redirect:/admin/viewPackage");
   }
   
   @RequestMapping(value="user/viewpackage", method= RequestMethod.GET)
	public ModelAndView loadpage(@ModelAttribute PackageVO packageVO) 
	{
		List packageList = this.packageService.viewPackage(packageVO);
		return new ModelAndView("user/viewpackage","packageList",packageList);
	}
   
   @RequestMapping(value="user/package_description", method= RequestMethod.GET)
	public ModelAndView packagedescription(@ModelAttribute PackageVO packageVO,@RequestParam ("packageId")int packageId) 
	{
		
		List ls=packageService.editPackage(packageVO);
		System.out.println("List============"+ls.size());
		return new ModelAndView("user/package_description","ls",ls);
	}
  
   
	
   @RequestMapping(value="user/loadcontact", method= RequestMethod.GET)
	public ModelAndView LoadContactPage()
	   {
		   return new ModelAndView("user/contact");
	   }
   
   @RequestMapping(value="user/LoadAboutUs", method= RequestMethod.GET)
	public ModelAndView LoadAboutUsPage()
	   {
		   return new ModelAndView("user/about");
	   }
	
  
}
