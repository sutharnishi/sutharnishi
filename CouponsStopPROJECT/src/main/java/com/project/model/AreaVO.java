package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Area")
public class AreaVO 
{
	@Id
	@Column(name="areaId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int areaId;
	
	@Column(name="areaName")
	private String areaName;
	
	@Column(name="areaDescription")
	private String areaDescription;
	
	@ManyToOne CityVO cityVO;
	
	@Column(name="areaStatus")
	private boolean areaStatus=true;
	
	

	public boolean isAreaStatus() {
		return areaStatus;
	}

	public void setAreaStatus(boolean areaStatus) {
		this.areaStatus = areaStatus;
	}

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAreaDescription() {
		return areaDescription;
	}

	public void setAreaDescription(String areaDescription) {
		this.areaDescription = areaDescription;
	}

	public CityVO getCityVO() {
		return cityVO;
	}

	public void setCityVO(CityVO cityVO) {
		this.cityVO = cityVO;
	}

	
	
}
