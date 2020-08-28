package com.project.dao;

import java.util.List;

import com.project.model.CompanyVO;

public interface CompanyDAO {

	public void insertCompany(CompanyVO companyVO);

	public List viewCompany(CompanyVO companyVO);

	public List deleteCompany(CompanyVO companyVO);

	public List editCompany(CompanyVO companyVO);

	public void updateCompany(CompanyVO companyVO);
	

}
