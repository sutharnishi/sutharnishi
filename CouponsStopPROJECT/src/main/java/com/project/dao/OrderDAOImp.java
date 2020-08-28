package com.project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.OrderVO;

@Repository
public class OrderDAOImp implements OrderDAO 
{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void insertOrder(OrderVO orderVO) 
	{
		Session session=this.sessionFactory.getCurrentSession();
		session.save(orderVO);
	}

}
