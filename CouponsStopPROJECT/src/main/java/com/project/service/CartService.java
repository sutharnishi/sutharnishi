package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.CartDAO;
import com.project.model.CartVO;

@Service
public class CartService 
{
	@Autowired
	CartDAO cartDAO;
	
	
	@Transactional
	public void insertCart(CartVO cartVO) 
	{
		this.cartDAO.insertCart(cartVO);
		
	}
	@Transactional
	public List searchCart(CartVO cartVO)
	{
		List ls = this.cartDAO.searchCart(cartVO);
		return ls;
		
	}
	
	@Transactional
	public void deleteItem(CartVO cartVO) 
	{
		this.cartDAO.deleteItem(cartVO);
				
	}

}
