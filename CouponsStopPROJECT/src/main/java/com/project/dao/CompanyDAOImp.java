package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.CompanyVO;

@Repository
public class CompanyDAOImp implements CompanyDAO
{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void insertCompany(CompanyVO companyVO) 
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.save(companyVO);
		
		
	}

	@Override
	public List viewCompany(CompanyVO companyVO) 
	{
		
		List ls=new ArrayList();
    	Session session=this.sessionFactory.getCurrentSession();
    	Query q=session.createQuery("From CompanyVO where companyStatus=true");
    	ls=q.list();
    	return ls;
	}

	@Override
	public List deleteCompany(CompanyVO companyVO)
	{
		List ls=new ArrayList();
    	Session session=this.sessionFactory.getCurrentSession();
    	Query q= session.createQuery("from CompanyVO where companyId='"+companyVO.getCompanyId()+"'");
    	ls=q.list();
		return ls;

		
	}

	@Override
	public List editCompany(CompanyVO companyVO) 
	{
		
		List ls=new ArrayList();
    	Session session=this.sessionFactory.getCurrentSession();
    	Query q= session.createQuery("from CompanyVO where companyId='"+companyVO.getCompanyId()+"'");
    	ls=q.list();
		return ls;

	}

	@Override
	public void updateCompany(CompanyVO companyVO) 
	{
		Session session=this.sessionFactory.getCurrentSession();
		session.update(companyVO);
	}
	
	

}
