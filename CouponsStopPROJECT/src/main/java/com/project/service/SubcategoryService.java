package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.SubcategoryDAO;
import com.project.model.SubcategoryVO;

@Service
public class SubcategoryService {

	
	@Autowired
	SubcategoryDAO subcategoryDAO;
	
	@Transactional
	public void insertSubcategory(SubcategoryVO subcategoryVO)
	{
		this.subcategoryDAO.insertSubcategory(subcategoryVO);
		
	}

	@Transactional
	public List viewSubcategory(SubcategoryVO subcategoryVO)
	{
		
		List ls=this.subcategoryDAO.viewSubcategory(subcategoryVO);
		return ls;
	}

	@Transactional
	public List deleteSubcategory(SubcategoryVO subcategoryVO) 
	{
		List ls=this.subcategoryDAO.deleteSubcategory(subcategoryVO);
		return ls;
	}

	@Transactional
	public List editSubcategory(SubcategoryVO subcategoryVO)
	{
		List ls=this.subcategoryDAO.editSubcategory(subcategoryVO);
		return ls;
	}
	
	@Transactional
	public void updateSubcategory(SubcategoryVO subcategoryVO) 
	{
		this.subcategoryDAO.updateSubcategory(subcategoryVO);
		
	}

}
