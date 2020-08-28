package com.project.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.servlet4preview.http.PushBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.AreaVO;
import com.project.model.CategoryVO;
import com.project.model.CityVO;
import com.project.model.CompanyVO;
import com.project.model.PackageVO;
import com.project.model.SubcategoryVO;
import com.project.service.AreaService;
import com.project.service.CategoryService;
import com.project.service.CityService;
import com.project.service.CompanyService;
import com.project.service.SubcategoryService;

@Controller
public class CompanyController 
{
	@Autowired
	CompanyService companyService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	SubcategoryService subcategoryService;
	
	@Autowired
	AreaService areaService;
	
	@Autowired
	CityService cityService;
	
	
	@RequestMapping(value="admin/loadCompany")
	public ModelAndView loadcompany(CategoryVO categoryVO,SubcategoryVO subcategoryVO,CityVO cityVO,AreaVO areaVO)
	{
		List categoryList=this.categoryService.viewCategory(categoryVO);
		List subcategoryList=this.subcategoryService.viewSubcategory(subcategoryVO);
		List cityList = this.cityService.searchCity(cityVO);
		List areaList=this.areaService.searchArea(areaVO);
		return new ModelAndView("admin/addCompany","companydata",new CompanyVO()).addObject("categoryList",categoryList).addObject("subcategoryList", subcategoryList).addObject("cityList",cityList).addObject("areaList",areaList);
	}
	
	@RequestMapping(value="admin/insertCompany",method=RequestMethod.POST)
	public ModelAndView insertcompany(@ModelAttribute CompanyVO companyVO,@RequestParam ("file")MultipartFile file, HttpServletRequest request)
	{
		String path =request.getSession().getServletContext().getRealPath("/");
		String FileName= file.getOriginalFilename();
		String FilePath = path + "documents\\demo\\";
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
		
		companyVO.setFileName(FileName);
		companyVO.setFilePath(FilePath);
		
		this.companyService.insertCompany(companyVO);
		return new ModelAndView("redirect:/admin/loadCompany");
	}
	
	@RequestMapping(value="admin/viewCompany",method=RequestMethod.GET)
	public ModelAndView viewCompany(@ModelAttribute CompanyVO companyVO)
	{
		List companyList= this.companyService.viewCompany(companyVO);
		System.out.println("List==========="+companyList.size());
		return new ModelAndView("admin/viewCompany","companylist",companyList);
	}
	
	@RequestMapping(value="admin/deleteCompany",method= RequestMethod.GET)
	public ModelAndView deleteCompany(@ModelAttribute CompanyVO companyVO,HttpServletRequest request)
	{
		   int companyId = Integer.parseInt(request.getParameter("companyId"));
		   companyVO.setCompanyId(companyId);
		   List companyList=this.companyService.deleteCompany(companyVO);
		   
		   companyVO = (CompanyVO)companyList.get(0);
			
		   companyVO.setCompanyStatus(false);
		  this.companyService.updateCompany(companyVO);			
			
		   return new ModelAndView("redirect:/admin/viewCompany");
	}
	
	@RequestMapping(value="admin/editCompany", method=RequestMethod.GET)
	public ModelAndView editcompany(@ModelAttribute CompanyVO companyVO,CategoryVO categoryVO,SubcategoryVO subcategoryVO,CityVO cityVO,AreaVO areaVO,HttpServletRequest request)
	{
		List categoryList=this.categoryService.viewCategory(categoryVO);
		List subcategoryList=this.subcategoryService.viewSubcategory(subcategoryVO);
		List cityList = this.cityService.searchCity(cityVO);
		List areaList=this.areaService.searchArea(areaVO);
		
		
		int companyId = Integer.parseInt(request.getParameter("companyId"));
		   companyVO.setCompanyId(companyId);
		   
		   List companyList=this.companyService.editCompany(companyVO);
		 return new ModelAndView("admin/editCompany","companyList",(CompanyVO)companyList.get(0)).addObject("categoryList",categoryList).addObject("subcategoryList", subcategoryList).addObject("cityList",cityList).addObject("areaList",areaList);
  
	}
	
	@RequestMapping(value="admin/updateCompany", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute CompanyVO companyVO)
	{
		this.companyService.updateCompany(companyVO);
		return new ModelAndView("redirect:/admin/viewCompany");
	}
	
	
	 @RequestMapping(value="user/viewcompany", method= RequestMethod.GET)
		public ModelAndView loadpage(@ModelAttribute CompanyVO companyVO) 
		{
			List companyList = this.companyService.viewCompany(companyVO);
			return new ModelAndView("user/company","companyList",companyList);
		}
}
