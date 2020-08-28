package com.project.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.CouponVO;
import com.project.model.SubcategoryVO;
import com.project.service.CategoryService;
import com.project.service.CompanyService;
import com.project.service.CouponService;
import com.project.service.SubcategoryService;
import com.project.model.AreaVO;
import com.project.model.CategoryVO;
import com.project.model.CompanyVO;

@Controller
public class CouponController 
{
	@Autowired
	CouponService couponService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	SubcategoryService SubcategoryService;
	
	@Autowired
	CompanyService companyService;
	
	@RequestMapping(value="admin/loadCoupon")
	public ModelAndView loadpage(CategoryVO categoryVO,SubcategoryVO subcategoryVO,CompanyVO companyVO)
	{
		List categoryList=this.categoryService.viewCategory(categoryVO);
		List subcategoryList=this.SubcategoryService.viewSubcategory(subcategoryVO);
		List companyList=this.companyService.viewCompany(companyVO);
		
		return new ModelAndView("admin/addCoupon","coupondata",new CouponVO()).addObject("categoryList", categoryList).addObject("subcategoryList", subcategoryList).addObject("companyList", companyList);
	}
	
	@RequestMapping(value="admin/insertCoupon",method=RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute CouponVO couponVO,@RequestParam ("file")MultipartFile file,  HttpServletRequest request)
	{
		
		String path =request.getSession().getServletContext().getRealPath("/");
		String FileName= file.getOriginalFilename();
		String FilePath = path + "documents\\coupons\\";
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
		
		couponVO.setFileName(FileName);
		couponVO.setFilePath(FilePath);
		
		couponService.insertCoupon(couponVO);
		return new ModelAndView("redirect:/admin/loadCoupon");
	}
	
	@RequestMapping(value="admin/viewCoupon",method=RequestMethod.GET)
	public ModelAndView search(@ModelAttribute CouponVO couponVO)
	{
		List couponList=couponService.searchCoupon(couponVO);
		System.out.println("List==========="+couponList.size());
		return new ModelAndView("admin/viewCoupon","couponlist",couponList);
	}
	
	@RequestMapping(value="admin/deleteCoupon",method= RequestMethod.GET)
	public ModelAndView delete(@ModelAttribute CouponVO couponVO,HttpServletRequest request)
	{
		int id = Integer.parseInt(request.getParameter("couponId"));
		   couponVO.setCouponId(id);
		   List couponList=this.couponService.deleteCoupon(couponVO);
		   
		   couponVO = (CouponVO)couponList.get(0);
			
		   couponVO.setCouponStatus(false);
		  this.couponService.updateCoupon(couponVO);			
			return new ModelAndView("redirect:/admin/viewCoupon");
	}
	
	@RequestMapping(value="admin/editCoupon", method= RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute CouponVO couponVO,CategoryVO categoryVO,SubcategoryVO subcategoryVO,CompanyVO companyVO,HttpServletRequest request)
	{
		List categoryList=this.categoryService.viewCategory(categoryVO);
		List subcategoryList=this.SubcategoryService.viewSubcategory(subcategoryVO);
		List companyList=this.companyService.viewCompany(companyVO);
		
	     int couponId = Integer.parseInt(request.getParameter("couponId"));
		 couponVO.setCouponId(couponId);
		 
		 List couponList=couponService.editCoupon(couponVO);
		 return new ModelAndView("admin/editCoupon","couponlist",(CouponVO)couponList.get(0)).addObject("categoryList", categoryList).addObject("subcategoryList", subcategoryList).addObject("companyList",companyList);
  
	}
	
	@RequestMapping(value="admin/updateCoupon", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute CouponVO couponVO)
	{
		this.couponService.updateCoupon(couponVO);
		return new ModelAndView("redirect:/admin/viewCoupon");
	}
	
	
	@RequestMapping(value="user/viewuserCoupon", method= RequestMethod.GET)
	public ModelAndView loadpage(@ModelAttribute CouponVO couponVO) 
	{
		List coupanList = this.couponService.searchCoupon(couponVO);
		return new ModelAndView("user/coupons","coupanList",coupanList);
	}
	
	@RequestMapping(value="user/dealdescription", method= RequestMethod.GET)
	public ModelAndView dealdescription(@ModelAttribute CouponVO couponVO,@RequestParam ("couponId")int couponId) 
	{
		couponVO.setCouponId(couponId);
		List couponList = this.couponService.editCoupon(couponVO);
		System.out.println("List============"+couponList.size());
		return new ModelAndView("user/deal_description","couponList",couponList);
	}
	
	
}
