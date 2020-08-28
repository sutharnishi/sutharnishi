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

import com.project.model.AreaVO;
import com.project.model.CategoryVO;
import com.project.model.SubcategoryVO;
import com.project.service.CategoryService;
import com.project.service.SubcategoryService;

@Controller
public class SubcategoryController 
{
	@Autowired SubcategoryService subcategoryService;
	@Autowired CategoryService categoryService;
	
	@RequestMapping(value="admin/loadSubcategory",method= RequestMethod.GET)
	public ModelAndView loadSubcategory(CategoryVO categoryVO) 
	{
	     List categoryList = this.categoryService.viewCategory(categoryVO);	
		return new ModelAndView("admin/addSubcategory","Subcategory",new SubcategoryVO()).addObject("categoryList", categoryList);
	}
	
	@RequestMapping(value="admin/insertSubcategory",method = RequestMethod.POST)
	public ModelAndView insertSubcategory(@ModelAttribute SubcategoryVO subcategoryVO)
	{
			this.subcategoryService.insertSubcategory(subcategoryVO);
			return new  ModelAndView("redirect:/admin/loadSubcategory");
	}
	
	@RequestMapping(value="admin/viewSubcategory",method = RequestMethod.GET)
	public ModelAndView viewSubcategory(@ModelAttribute SubcategoryVO subcategoryVO)
	{
			List list= this.subcategoryService.viewSubcategory(subcategoryVO);
			System.out.println("List Size>"+list.size());
			return new  ModelAndView("admin/viewSubcategory","subcategoryList",list);
	}
	
	@RequestMapping(value="admin/deleteSubcategory",method = RequestMethod.GET)
	public ModelAndView deleteSubcategory(@ModelAttribute SubcategoryVO subcategoryVO,@RequestParam("subcategoryId") int id)
	{
			subcategoryVO.setSubcategoryId(id);;
			List subcategorylist=this.subcategoryService.deleteSubcategory(subcategoryVO);
			
			subcategoryVO = (SubcategoryVO)subcategorylist.get(0);
			
			subcategoryVO.setSubcategoryStatus(false);
			this.subcategoryService.updateSubcategory(subcategoryVO);			
			return new  ModelAndView("redirect:/admin/viewSubcategory");
	}
	
	@RequestMapping(value="admin/editSubcategory",method= RequestMethod.GET)
	public ModelAndView editsubcategory(@ModelAttribute SubcategoryVO subcategoryVO,CategoryVO categoryVO,HttpServletRequest request)
	{
		List categoryList = this.categoryService.viewCategory(categoryVO);
		
		int subcategoryId = Integer.parseInt(request.getParameter("subcategoryId"));
		subcategoryVO.setSubcategoryId(subcategoryId);
		 
		List subcategoryList=subcategoryService.editSubcategory(subcategoryVO);
		 return new ModelAndView("admin/editSubcategory","subcategorylist",(SubcategoryVO)subcategoryList.get(0)).addObject("categoryList",categoryList);
   
	}
	
	@RequestMapping(value="admin/updateSubcategory",method= RequestMethod.POST )
	public ModelAndView updatesubcategory(@ModelAttribute SubcategoryVO subcategoryVO)
	{
		this.subcategoryService.updateSubcategory(subcategoryVO);
		return new ModelAndView("redirect:/admin/viewSubcategory");
	}
	
	
}
