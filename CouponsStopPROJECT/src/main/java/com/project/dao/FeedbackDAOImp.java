package com.project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.hibernate.Query;

import com.project.model.ComplaintVO;
import com.project.model.FeedbackVO;

@Repository
public class FeedbackDAOImp implements FeedbackDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insertFeedback(FeedbackVO feedbackVO) {
		
		Session session = sessionFactory.getCurrentSession(); 
		session.saveOrUpdate(feedbackVO);	
	}
	
	@Override
    public List viewFeedback(FeedbackVO feedbackVO){
			
		Session session = sessionFactory.getCurrentSession();		
		Query q = session.createQuery("from FeedbackVO");		
		List feedbackList = q.list();
		return feedbackList;	
	}
	
	@Override
	public List viewstaffFeedback(FeedbackVO feedbackVO) {
		Session session = sessionFactory.getCurrentSession();
		
		Query q = session.createQuery("from FeedbackVO where loginVO.loginId = '"+feedbackVO.getLoginVO().getLoginId()+"'");
		List complainList = q.list();
		return complainList;
	   }

}
