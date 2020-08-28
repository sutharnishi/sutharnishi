package com.project.dao;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.CategoryVO;

@Repository
public class CategoryDAOImp  implements CategoryDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void insertCategory(CategoryVO categoryVO) 
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.save(categoryVO);		
	}

	@Override
	public List viewCategory(CategoryVO categoryVO)
	{
		List ls= new ArrayList();
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from CategoryVO where catagoryStatus=true");
		ls = q.list(); 
		return ls;
	}

	@Override
	public List deleteCategory(CategoryVO categoryVO) 
	{
		List ls= new ArrayList();
		Session session=this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from CategoryVO where categoryId='"+categoryVO.getCategoryId()+"'");
		ls = q.list(); 
		return ls;
	}

	@Override
	public List editCategory(CategoryVO categoryVO) 
	{
		List ls=new ArrayList();
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from CategoryVO where categoryId='"+categoryVO.getCategoryId()+"'");
		ls = q.list(); 
		return ls;
	}

	@Override
	public void updateCategory(CategoryVO categoryVO)
	{
		 Session session=this.sessionFactory.getCurrentSession();
		 session.update(categoryVO);
		
	}
	

}
