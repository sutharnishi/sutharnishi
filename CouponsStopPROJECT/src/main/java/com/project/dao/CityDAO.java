package com.project.dao;

import java.util.List;

import com.project.model.CityVO;

public interface CityDAO 
{
   public void insertCity(CityVO cityVO);
   public List searchCity(CityVO cityVO);
   public List deleteCity(CityVO cityVO);
   public List editCity(CityVO cityVO);
   public void updateCity(CityVO cityVO);


}
