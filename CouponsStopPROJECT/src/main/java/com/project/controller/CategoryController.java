package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.CategoryVO;
import com.project.service.CategoryService;

@Controller
public class CategoryController 
{
	@Autowired 
	CategoryService categoryService;
	
	@RequestMapping(value="admin/loadCategory",method= RequestMethod.GET)
	public ModelAndView loadpage() 
	{
		return new ModelAndView("admin/addCategory","categoryData",new CategoryVO());
	}
	
	@RequestMapping(value="admin/insertCategory",method = RequestMethod.POST)
	public ModelAndView insertcategory(@ModelAttribute CategoryVO categoryVO)
	{
			this.categoryService.insertCategory(categoryVO);
			return new  ModelAndView("redirect:/admin/loadCategory");
	}
	
	@RequestMapping(value="admin/viewCategory",method = RequestMethod.GET)
	public ModelAndView viewCategory(@ModelAttribute CategoryVO categoryVO)
	{
			List list= this.categoryService.viewCategory(categoryVO);
			return new  ModelAndView("admin/viewCategory","categoryList",list);
	}
	
	@RequestMapping(value="admin/deleteCategory",method = RequestMethod.GET)
	public ModelAndView deleteCategory(@ModelAttribute CategoryVO categoryVO,@RequestParam("categoryId") int id)
	{
			categoryVO.setCategoryId(id);
			
			List categoryList = this.categoryService.deleteCategory(categoryVO);
			categoryVO = (CategoryVO)categoryList.get(0);
			
			categoryVO.setCatagoryStatus(false);
			this.categoryService.updateCategory(categoryVO);			
			return new  ModelAndView("redirect:/admin/viewCategory");
	}
	
	@RequestMapping(value = "admin/editCategory", method = RequestMethod.GET) 
	public ModelAndView editCategory(@ModelAttribute CategoryVO categoryVO,@RequestParam("categoryId")int id)
	{	
		categoryVO.setCategoryId(id);
		List list = this.categoryService.editCategory(categoryVO);
		System.out.print("List Size"+list.size());
		return new ModelAndView("admin/editCategory","categoryData",(CategoryVO)list.get(0));
	}
	
	@RequestMapping(value="admin/updateCategory",method=RequestMethod.POST)
	public ModelAndView updateCategory(@ModelAttribute CategoryVO categoryVO)
	{
		this.categoryService.updateCategory(categoryVO);
		return new ModelAndView("redirect:/admin/viewCategory");	
	}
	
	
	
}
