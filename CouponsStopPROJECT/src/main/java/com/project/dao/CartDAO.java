package com.project.dao;

import java.util.List;

import com.project.model.CartVO;

public interface CartDAO {

	public void insertCart(CartVO cartVO);
	
	public List searchCart(CartVO cartVO);

	public void deleteItem(CartVO cartVO);

}
