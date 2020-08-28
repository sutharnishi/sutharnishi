package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.CompanyDAO;
import com.project.model.CompanyVO;

@Service
public class CompanyService 
{

	@Autowired
	CompanyDAO companyDAO;
	
	@Transactional
	public void insertCompany(CompanyVO companyVO) 
	{
		this.companyDAO.insertCompany(companyVO);
		
	}

	@Transactional
	public List viewCompany(CompanyVO companyVO) 
	{
		List ls=this.companyDAO.viewCompany(companyVO);
		return ls;
	}

	@Transactional
	public List deleteCompany(CompanyVO companyVO)
	{
		List ls=this.companyDAO.deleteCompany(companyVO);
		return ls;
	}

	@Transactional
	public List editCompany(CompanyVO companyVO)
	{
		List ls=this.companyDAO.editCompany(companyVO);
		return ls;
	}

	@Transactional
	public void updateCompany(CompanyVO companyVO) 
	{
		
		this.companyDAO.updateCompany(companyVO);
	}

}
