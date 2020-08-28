package com.project.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.CartVO;
import com.project.model.CouponVO;
import com.project.model.LoginVO;
import com.project.service.CartService;
import com.project.service.CouponService;
import com.project.service.LoginService;
import com.project.utils.Basemethods;

@Controller
public class CartController 
{
	@Autowired
	CouponService couponService;
	
	@Autowired
	LoginService loginService;

	@Autowired
	CartService cartService;
	
	@RequestMapping(value="/user/addToCartInsert",method=RequestMethod.POST)
	public ModelAndView addToCartInsert(@RequestParam("singlePrice") String singlePrice ,
			@RequestParam("quantity") String quantity,
			@RequestParam("couponId") int couponId,@ModelAttribute CartVO cartVO ,HttpSession session)
	{
		int singlePrice1 = Integer.parseInt(singlePrice);
		int quantity1 = Integer.parseInt(quantity);
		
		CouponVO couponVO = new CouponVO();
		couponVO.setCouponId(couponId);
		
		LoginVO loginVO = new LoginVO();
		
		String userName = Basemethods.getUser();
		List loginIdList = this.loginService.searchLoginID(userName);
		loginVO = (LoginVO) loginIdList.get(0);
		
		int loginId = loginVO.getLoginId();
		loginVO.setLoginId(loginId);
		
		int totalPrice1= quantity1 * singlePrice1 ;
		
		System.out.println(loginId);
		System.out.println(totalPrice1);
		System.out.println(couponId);
		System.out.println(quantity);
		System.out.println(singlePrice);
		
		cartVO.setQuantity(quantity);
		cartVO.setSinglePrice(singlePrice);
		cartVO.setLoginVO(loginVO);
		cartVO.setCouponVO(couponVO);
		cartVO.setTotalPrice(totalPrice1);
		
		this.cartService.insertCart(cartVO);
		
		return new ModelAndView("redirect:/user/viewCart");
		
	}
	
	@RequestMapping(value="/user/viewCart",method=RequestMethod.GET)
	public ModelAndView viewCart(@ModelAttribute CartVO cartVO)
	{
		LoginVO loginVO = new LoginVO();
		
		String userName = Basemethods.getUser();
		List loginIdList = this.loginService.searchLoginID(userName);
		loginVO = (LoginVO) loginIdList.get(0);
		
		int loginId = loginVO.getLoginId();
		loginVO.setLoginId(loginId);
		
		cartVO.setLoginVO(loginVO);
		List cartList = this.cartService.searchCart(cartVO);
		
		return new ModelAndView("user/cart","cartList",cartList);
      		
	}
		
	
	@RequestMapping(value="/user/deleteItem", method= RequestMethod.GET)
	public ModelAndView deleteItem(@ModelAttribute CartVO cartVO,@RequestParam ("cartId")int cartId)
	{
		cartVO.setCartId(cartId);
		System.out.println(cartVO.getCartId());
		this.cartService.deleteItem(cartVO);
		return new ModelAndView("redirect:/user/viewCart");
		 
	}
	
	
	@RequestMapping(value="/user/payment", method= RequestMethod.GET)
	public ModelAndView checkout(@ModelAttribute CartVO cartVO, @RequestParam ("total")int total,LoginVO loginVO) 
	{
		
		String userName = Basemethods.getUser();
		List loginIdList = this.loginService.searchLoginID(userName);
		loginVO = (LoginVO) loginIdList.get(0);
		System.out.println("in Controller TOTAL PRRICE>>>>>>>"+total);
		/*cartVO.setTotalPrice(total);*/
		cartVO.setLoginVO(loginVO);
		List cartList = this.cartService.searchCart(cartVO);
		
		
		System.out.println(cartList.size()+"cartList size");
		return new ModelAndView("user/payment","total",total);
	}
}
