package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.CouponDAO;
import com.project.model.CouponVO;

@Service
public class CouponService 
{
	@Autowired
	CouponDAO couponDAO;
	
	@Transactional
	public void insertCoupon(CouponVO couponVO)
	{
		this.couponDAO.insertCoupon(couponVO);
		
	}

	@Transactional
	public List searchCoupon(CouponVO couponVO)
	{
		List ls=this.couponDAO.searchCoupon(couponVO);
		return ls;
	}

	@Transactional
	public List deleteCoupon(CouponVO couponVO)
	{
		List ls=this.couponDAO.deleteCoupon(couponVO);
		return ls;
	}

	@Transactional
	public List editCoupon(CouponVO couponVO)
	{
		List ls= this.couponDAO.editCoupon(couponVO);
		return ls;
	}
	
	@Transactional
	public void updateCoupon(CouponVO couponVO)
	{
		this.couponDAO.updateCoupon(couponVO);
		
	}

}
