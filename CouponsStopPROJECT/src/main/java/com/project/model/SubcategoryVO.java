package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="subcategory")
public class SubcategoryVO 
{
	@Id
	@Column(name="subcategoryId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int subcategoryId;
	
	@Column(name="subcategoryName")
	private String subcategoryName;

	@Column(name="subcategoryDescription")
	private String subcategoryDescription;
	
	@ManyToOne CategoryVO categoryVO;
	
	@Column(name="subcategoryStatus")
	private boolean subcategoryStatus=true;
	
	

	public boolean isSubcategoryStatus() {
		return subcategoryStatus;
	}

	public void setSubcategoryStatus(boolean subcategoryStatus) {
		this.subcategoryStatus = subcategoryStatus;
	}

	public int getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(int subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public String getSubcategoryName() {
		return subcategoryName;
	}

	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}

	public String getSubcategoryDescription() {
		return subcategoryDescription;
	}

	public void setSubcategoryDescription(String subcategoryDescription) {
		this.subcategoryDescription = subcategoryDescription;
	}

	public CategoryVO getCategoryVO() {
		return categoryVO;
	}

	public void setCategoryVO(CategoryVO categoryVO) {
		this.categoryVO = categoryVO;
	}
	
	
}
