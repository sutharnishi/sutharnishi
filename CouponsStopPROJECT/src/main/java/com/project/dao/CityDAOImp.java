package com.project.dao;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.CityVO;

@Repository
public class CityDAOImp implements CityDAO
{
    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    public void insertCity(CityVO cityVO)
    {
    	Session session = this.sessionFactory.getCurrentSession();
    	session.save(cityVO);
    }
    
    
    @Override
    public List searchCity(CityVO cityVO)
    {
    	List ls=new ArrayList();
    	Session session=this.sessionFactory.getCurrentSession();
    	Query q=session.createQuery("From CityVO where cityStatus=true");
    	ls=q.list();
    	return ls;
    }



	@Override
	public List deleteCity(CityVO cityVO)
	{
		List ls=new ArrayList();
    	Session session=this.sessionFactory.getCurrentSession();
    	Query q= session.createQuery("from CityVO where cityid='"+cityVO.getCityid()+"'");
    	ls=q.list();
		return ls;

	}


	@Override
	public List editCity(CityVO cityVO) 
	{
		List ls=new ArrayList();
    	Session session=this.sessionFactory.getCurrentSession();
    	Query q= session.createQuery("from CityVO where cityid='"+cityVO.getCityid()+"'");
    	ls=q.list();
		return ls;
	}


	@Override
	public void updateCity(CityVO cityVO) 
	{
		Session session=this.sessionFactory.getCurrentSession();
		session.update(cityVO);

		
	}
}
