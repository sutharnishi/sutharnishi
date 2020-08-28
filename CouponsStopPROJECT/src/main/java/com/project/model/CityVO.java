package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="City")
public class CityVO 
{
	@Id
	@Column(name="cityid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cityid;
	
	@Column(name="cityName")
	private String cityName;
	
	@Column(name="cityDescription")
	private String cityDescription;

	@Column(name="cityStatus")
	private boolean cityStatus=true;
	

	public boolean isCityStatus() {
		return cityStatus;
	}

	public void setCityStatus(boolean cityStatus) {
		this.cityStatus = cityStatus;
	}

	public int getCityid() {
		return cityid;
	}

	public void setCityid(int cityid) {
		this.cityid = cityid;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityDescription() {
		return cityDescription;
	}

	public void setCityDescription(String cityDescription) {
		this.cityDescription = cityDescription;
	}

}
