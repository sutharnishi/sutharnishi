package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class CategoryVO 
{
	@Id
	@Column(name="categoryId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int categoryId;
	
	@Column(name="categoryName")
	private String categoryName;
	
	@Column(name="categoryDescription")
	private String categoryDescription;
	
	@Column(name="catagoryStatus")
	private boolean catagoryStatus=true;
	
	public boolean isCatagoryStatus() {
		return catagoryStatus;
	}

	public void setCatagoryStatus(boolean catagoryStatus) {
		this.catagoryStatus = catagoryStatus;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
	
	
}
