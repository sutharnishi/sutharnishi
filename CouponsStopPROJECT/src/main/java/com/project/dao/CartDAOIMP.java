package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.CartVO;

@Repository
public class CartDAOIMP implements CartDAO 
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void insertCart(CartVO cartVO)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.save(cartVO);		
		
	}
	
	@Override
	public List searchCart(CartVO cartVO)
	{

		List ls= new ArrayList();
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from CartVO where loginVO.loginId='"+cartVO.getLoginVO().getLoginId()+"'");
		ls = q.list(); 
		return ls;
	}

	@Override
	public void deleteItem(CartVO cartVO)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(cartVO);
	}

	
}
