package com.project.dao;

import java.util.List;

import com.project.model.CouponVO;

public interface CouponDAO 
{

	public void insertCoupon(CouponVO couponVO);

	public List searchCoupon(CouponVO couponVO);

	public List deleteCoupon(CouponVO couponVO);

	public List editCoupon(CouponVO couponVO);

	public void updateCoupon(CouponVO couponVO);
	

}
