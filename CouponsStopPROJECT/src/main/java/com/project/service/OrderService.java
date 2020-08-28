package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.OrderDAO;
import com.project.model.OrderVO;

@Service
public class OrderService 
{
	
	@Autowired
	OrderDAO orderDAO;
	
	@Transactional
	public void insertOrder(OrderVO orderVO) 
	{
		this.orderDAO.insertOrder(orderVO);
		
	}

}
