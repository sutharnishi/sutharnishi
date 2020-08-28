package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.project.model.LoginVO;
import com.project.model.CouponVO;

@Entity
@Table(name="Cart")
public class CartVO
{
	
	@Id
	@Column(name="cartId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartId;
	
	@Column(name="quantity")
	private String quantity;
	
	
	@Column(name="totalPrice")
	private int totalPrice;
	
	@Column(name="singlePrice")
	private String singlePrice;
	
	
	@Column(name="Date")
	private String Date;
	
	@ManyToOne LoginVO loginVO;
	
	@ManyToOne CouponVO couponVO;

	
	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getSinglePrice() {
		return singlePrice;
	}

	public void setSinglePrice(String singlePrice) {
		this.singlePrice = singlePrice;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

	public CouponVO getCouponVO() {
		return couponVO;
	}

	public void setCouponVO(CouponVO couponVO) {
		this.couponVO = couponVO;
	}

	
	
	
   
}
