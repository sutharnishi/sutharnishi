package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.CategoryDAO;
import com.project.model.CategoryVO;

@Service
public class CategoryService {
	
	@Autowired
	CategoryDAO categoryDAO;

	@Transactional
	public void insertCategory(CategoryVO categoryVO) 
	{
		this.categoryDAO.insertCategory(categoryVO);
		
	}

	@Transactional
	public List viewCategory(CategoryVO categoryVO) 
	{
		List ls=this.categoryDAO.viewCategory(categoryVO);
		return ls;
	}

	@Transactional
	public List deleteCategory(CategoryVO categoryVO) 
	{
		List ls=this.categoryDAO.deleteCategory(categoryVO);
		return ls;
	}
	
	@Transactional
	public List editCategory(CategoryVO categoryVO) 
	{
		List ls=this.categoryDAO.editCategory(categoryVO);
		
		return ls;
	}

	@Transactional
	public void updateCategory(CategoryVO categoryVO) 
	{
		this.categoryDAO.updateCategory(categoryVO);
		
	}

}
