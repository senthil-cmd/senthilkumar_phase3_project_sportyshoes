package com.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class PurchaseReport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer purchaseId;
	private Date date;
	@OneToMany
	private List<Product> product;
	@OneToOne
	@JoinColumn(name="User_Details")
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public PurchaseReport(Integer purchaseId, Date date, List<Product> product, User user) {
		super();
		this.purchaseId = purchaseId;
		this.date = date;
		this.product = product;
		this.user = user;
	}
	public PurchaseReport(Date date, List<Product> product, User user) {
		super();
		this.date = date;
		this.product = product;
		this.user = user;
	}
	public PurchaseReport() {
	}

}
