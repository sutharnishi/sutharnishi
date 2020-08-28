package com.project.dao;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.SubcategoryVO;

@Repository
public class SubcategoryDAOImp implements SubcategoryDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void insertSubcategory(SubcategoryVO subcategoryVO) 
	{
		
			Session session = this.sessionFactory.getCurrentSession();
			session.save(subcategoryVO);
		
	}

	@Override
	public List viewSubcategory(SubcategoryVO subcategoryVO) 
	{
		List ls=new ArrayList();
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from SubcategoryVO where subcategoryStatus=true");
		ls = q.list(); 
		return ls;
	}

	@Override
	public List deleteSubcategory(SubcategoryVO subcategoryVO) 
	{
		
		List ls=new ArrayList();
    	Session session=this.sessionFactory.getCurrentSession();
    	Query q= session.createQuery("from SubcategoryVO where subcategoryId='"+subcategoryVO.getSubcategoryId()+"'");
    	ls=q.list();
		return ls;
	}

	@Override
	public List editSubcategory(SubcategoryVO subcategoryVO) 
	{
		List ls=new ArrayList();
    	Session session=this.sessionFactory.getCurrentSession();
    	Query q= session.createQuery("from SubcategoryVO where subcategoryId='"+subcategoryVO.getSubcategoryId()+"'");
    	ls=q.list();
		return ls;
	}

	@Override
	public void updateSubcategory(SubcategoryVO subcategoryVO)
	{
		Session session=this.sessionFactory.getCurrentSession();
		session.update(subcategoryVO);
	}
	
}
