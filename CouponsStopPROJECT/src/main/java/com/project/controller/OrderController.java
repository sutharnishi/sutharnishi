package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.AreaVO;
import com.project.model.CartVO;
import com.project.model.CityVO;
import com.project.model.LoginVO;
import com.project.model.OrderVO;
import com.project.service.AreaService;
import com.project.service.CartService;
import com.project.service.CityService;
import com.project.service.LoginService;
import com.project.service.OrderService;
import com.project.utils.Basemethods;

@Controller
public class OrderController

{
	@Autowired
	OrderService orderService;
	
	@Autowired
	CityService cityService;
	
	@Autowired
	AreaService areaService;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	CartService cartService;
	
	@RequestMapping(value="/user/billing", method= RequestMethod.POST)
	public ModelAndView billing(@ModelAttribute OrderVO orderVO,CityVO cityVO,AreaVO areaVO)
	{
		List cityList = this.cityService.searchCity(cityVO);
		
		List areaList = this.areaService.searchArea(areaVO);
		
		return new ModelAndView("user/billing","orderVO",new OrderVO()).addObject("cityList", cityList).addObject("areaList", areaList);
	}
	
	@RequestMapping(value="/user/order", method= RequestMethod.POST)
	public ModelAndView insertorder(@ModelAttribute OrderVO orderVO,LoginVO loginVO,CartVO cartVO)
	{
		String userName = Basemethods.getUser();
		List loginIdList = this.loginService.searchLoginID(userName);
		loginVO = (LoginVO) loginIdList.get(0);
		
		cartVO.setLoginVO(loginVO);
		List cartList = this.cartService.searchCart(cartVO);
		cartVO = (CartVO)cartList.get(0);
			
		orderVO.setLoginVO(loginVO);
		orderVO.setCartVO(cartVO);
		this.orderService.insertOrder(orderVO);
		return new ModelAndView("user/homepage");
	}
}
