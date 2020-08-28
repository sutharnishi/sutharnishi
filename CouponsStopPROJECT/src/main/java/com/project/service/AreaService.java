package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.AreaDAO;
import com.project.model.AreaVO;

@Service
public class AreaService
{
	@Autowired
	AreaDAO areaDAO;

	@Transactional
	public void insertArea(AreaVO areaVO) 
	{
		this.areaDAO.insertArea(areaVO);
		
	}

	@Transactional
	public List searchArea(AreaVO areaVO) 
	{
		List ls=this.areaDAO.searchArea(areaVO);
		return ls;
	}

	@Transactional
	public List deleteArea(AreaVO areaVO)
	{
		List ls=this.areaDAO.deleteArea(areaVO);
		return ls;
		
	}
	
	@Transactional
	public List editArea(AreaVO areaVO) 
	{
		List ls=this.areaDAO.editArea(areaVO);
		return ls;
	}

	@Transactional
	public void updateArea(AreaVO areaVO)
	{
			this.areaDAO.updateArea(areaVO);
		
	}

}
