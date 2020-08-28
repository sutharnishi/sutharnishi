package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.AreaVO;

@Repository
public class AreaDAOImp implements AreaDAO 
{

	@Autowired
    SessionFactory sessionFactory;
	
	@Override
	public void insertArea(AreaVO areaVO) 
	{

		Session session = this.sessionFactory.getCurrentSession();
		session.save(areaVO);
		
	}

	@Override
	public List searchArea(AreaVO areaVO) 
	{
		List ls=new ArrayList();
    	Session session=this.sessionFactory.getCurrentSession();
    	Query q=session.createQuery("From AreaVO where areaStatus=true");
    	ls=q.list();
    	return ls;
		
	}

	@Override
	public List deleteArea(AreaVO areaVO) 
	{
		List ls=new ArrayList();
    	Session session=this.sessionFactory.getCurrentSession();
    	Query q= session.createQuery("from AreaVO where areaId='"+areaVO.getAreaId()+"'");
    	ls=q.list();
		return ls;
	}

	@Override
	public List editArea(AreaVO areaVO) 
	{
		List ls=new ArrayList();
    	Session session=this.sessionFactory.getCurrentSession();
    	Query q= session.createQuery("from AreaVO where areaId='"+areaVO.getAreaId()+"'");
    	ls=q.list();
		return ls;
	}

	@Override
	public void updateArea(AreaVO areaVO)
	{
		Session session=this.sessionFactory.getCurrentSession();
		session.update(areaVO);
	}
}
