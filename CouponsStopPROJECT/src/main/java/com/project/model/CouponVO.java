package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Coupon")
public class CouponVO
{
	@Id
	@Column(name="couponId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int couponId;
	
	@Column(name="couponName")
	private String couponName;
	
	@Column(name="couponCode")
	private String couponCode;
	
	@Column(name="couponDiscount")
	private String couponDiscount;
	
	@Column(name="couponDescription")
	private String couponDescription;

	@Column(name="couponPrice")
	private String couponPrice;
	
	@Column(name="quantity")
	private String quantity;
	
	@Column(name="fileName")
	private String fileName;
	
	@Column(name="filePath")
	private String filePath;
	
	
	
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@ManyToOne CategoryVO categoryVO;
	
	@ManyToOne SubcategoryVO subcategoryVO;
	
	@ManyToOne CompanyVO companyVO;
	
	@Column(name="couponStatus")
	private boolean couponStatus=true;

	public int getCouponId() {
		return couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public String getCouponDiscount() {
		return couponDiscount;
	}

	public void setCouponDiscount(String couponDiscount) {
		this.couponDiscount = couponDiscount;
	}

	public String getCouponDescription() {
		return couponDescription;
	}

	public void setCouponDescription(String couponDescription) {
		this.couponDescription = couponDescription;
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

	public CompanyVO getCompanyVO() {
		return companyVO;
	}

	public void setCompanyVO(CompanyVO companyVO) {
		this.companyVO = companyVO;
	}

	public boolean isCouponStatus() {
		return couponStatus;
	}

	public void setCouponStatus(boolean couponStatus) {
		this.couponStatus = couponStatus;
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

	public String getCouponPrice() {
		return couponPrice;
	}

	public void setCouponPrice(String couponPrice) {
		this.couponPrice = couponPrice;
	}

	
	
}
