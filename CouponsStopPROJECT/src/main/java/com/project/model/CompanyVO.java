package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class CompanyVO 
{
	@Id
	@Column(name="companyId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int companyId;
	
	@Column(name="companyName")
	private String companyName;
	
	@Column(name="companyEmailId")
	private String companyEmailId;
	
	@Column(name="companyContact")
	private String companyContact;
	
	@Column(name="companyWebsite")
	private String companyWebsite;
	
	@Column(name="companyAddress")
	private String companyAddress;
	
	@Column(name="companyDescription")
	private String companyDescription;
	
	
	@Column(name="fileName")
	private String fileName;
	
	@Column(name="filePath")
	private String filePath;
	
	
	
	@ManyToOne CategoryVO categoryVO;
	@ManyToOne SubcategoryVO subcategoryVO;
	@ManyToOne CityVO cityVO;
	@ManyToOne AreaVO areaVO;
	
	@Column(name="companyStatus")
	private boolean companyStatus=true;

	
	
	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyEmailId() {
		return companyEmailId;
	}

	public void setCompanyEmailId(String companyEmailId) {
		this.companyEmailId = companyEmailId;
	}

	public String getCompanyContact() {
		return companyContact;
	}

	public void setCompanyContact(String companyContact) {
		this.companyContact = companyContact;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyDescription() {
		return companyDescription;
	}

	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}

	public CategoryVO getCategoryVO() {
		return categoryVO;
	}

	public void setCategoryVO(CategoryVO categoryVO) {
		this.categoryVO = categoryVO;
	}

	public SubcategoryVO getSubcategoryVO() {
		return subcategoryVO;
	}

	public void setSubcategoryVO(SubcategoryVO subcategoryVO) {
		this.subcategoryVO = subcategoryVO;
	}

	public CityVO getCityVO() {
		return cityVO;
	}

	public void setCityVO(CityVO cityVO) {
		this.cityVO = cityVO;
	}

	public AreaVO getAreaVO() {
		return areaVO;
	}

	public void setAreaVO(AreaVO areaVO) {
		this.areaVO = areaVO;
	}

	public boolean isCompanyStatus() {
		return companyStatus;
	}

	public void setCompanyStatus(boolean companyStatus) {
		this.companyStatus = companyStatus;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

		
	
	
	
}
