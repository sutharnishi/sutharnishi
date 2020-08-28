package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.CouponVO;


@Repository
public class CouponDAOImp implements CouponDAO 
{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void insertCoupon(CouponVO couponVO) 
	{
		Session session=this.sessionFactory.getCurrentSession();
		session.save(couponVO);
		
	}

	@Override
	public List searchCoupon(CouponVO couponVO)
	{
		List ls=new ArrayList();
    	Session session=this.sessionFactory.getCurrentSession();
    	Query q=session.createQuery("From CouponVO  where couponStatus=true");
    	ls=q.list();
		return ls;
	}

	@Override
	public List deleteCoupon(CouponVO couponVO) 
	{
		List ls=new ArrayList();
    	Session session=this.sessionFactory.getCurrentSession();
    	Query q=session.createQuery("From CouponVO where couponId='"+couponVO.getCouponId()+"'");
    	ls=q.list();
		return ls;
	}

	@Override
	public List editCoupon(CouponVO couponVO) 
	{
		List ls=new ArrayList();
    	Session session=this.sessionFactory.getCurrentSession();
    	Query q=session.createQuery("From CouponVO where couponId='"+couponVO.getCouponId()+"'");
    	ls=q.list();
		return ls;
	}

	@Override
	public void updateCoupon(CouponVO couponVO) 
	{
		Session session=this.sessionFactory.getCurrentSession();
		session.update(couponVO);
		
	}
	
	

}
