package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="package")
public class PackageVO
{
	@Id
	@Column(name="packageId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int packageId;
	
	@Column(name="packageName")
	private String packageName;

	@Column(name="packagePrice")
	private String packagePrice;
	
	@Column(name="numberofCoupons")
	private String numberofCoupons;
	
	@Column(name="packageDescription")
	private String packageDescription;
	
	@Column(name="packageStatus")
	private boolean packageStatus=true;
	
	
	@Column(name="fileName")
	private String fileName;
	
	@Column(name="filePath")
	private String filePath;
	
	
	@ManyToOne LoginVO loginVO;
	
	

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

	public boolean isPackageStatus() {
		return packageStatus;
	}

	public void setPackageStatus(boolean packageStatus) {
		this.packageStatus = packageStatus;
	}

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackagePrice() {
		return packagePrice;
	}

	public void setPackagePrice(String packagePrice) {
		this.packagePrice = packagePrice;
	}

	public String getNumberofCoupons() {
		return numberofCoupons;
	}

	public void setNumberofCoupons(String numberofCoupons) {
		this.numberofCoupons = numberofCoupons;
	}

	public String getPackageDescription() {
		return packageDescription;
	}

	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
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
