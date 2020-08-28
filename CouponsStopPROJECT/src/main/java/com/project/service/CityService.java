package com.project.service;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.CityDAO;
import com.project.model.CityVO;

@Service
public class CityService 
{
   @Autowired
   CityDAO cityDAO;
   
   @Transactional
   public void insertCity(CityVO cityVO)
   {
	   this.cityDAO.insertCity(cityVO);
   }

   @Transactional
   public List searchCity(CityVO cityVO) 
   {
	   
	   List ls=this.cityDAO.searchCity(cityVO);
		return ls;
		
   }

   @Transactional
   public List deleteCity(CityVO cityVO)
	{
		List ls=this.cityDAO.deleteCity(cityVO);
		return ls;
	}
   
   @Transactional
	public List editCity(CityVO cityVO) 
	{
		List ls=this.cityDAO.editCity(cityVO);
		return ls;
	}

   @Transactional
	public void updateCity(CityVO cityVO) 
	{
		this.cityDAO.updateCity(cityVO);
		
	}
   
}
