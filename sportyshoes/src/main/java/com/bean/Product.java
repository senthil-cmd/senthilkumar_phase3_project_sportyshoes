package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ProductId;
	private String ProductName;
	private Double ProductPrice;
	@OneToOne
	@JoinColumn(name = "product_Category")
	private Category Productcategory;
	@OneToOne
	@JoinColumn(name = "product_Brand")
	private Brand ProductBrand;
	
	private Integer qty;
	
	private String productfeauter;
	private String productimage;

	
	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public String getProductfeauter() {
		return productfeauter;
	}

	public void setProductfeauter(String productfeauter) {
		this.productfeauter = productfeauter;
	}

	public Product() {
		
	}

	public Integer getProductId() {
		return ProductId;
	}

	public void setProductId(Integer productId) {
		ProductId = productId;
	}

	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public Category getProductcategory() {
		return Productcategory;
	}
	public void setProductcategory(Category productcategory) {
		Productcategory = productcategory;
	}
	public Brand getProductBrand() {
		return ProductBrand;
	}
	public void setProductBrand(Brand productBrand) {
		ProductBrand = productBrand;
	}



	public Double getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(Double productPrice) {
		ProductPrice = productPrice;
	}

	public String getProductimage() {
		return productimage;
	}

	public void setProductimage(String productimage) {
		this.productimage = productimage;
	}

	public Product( String productName, Double productPrice, Category productcategory,
			Brand productBrand, Integer qty, String productfeauter, String productimage) {
		super();
		ProductName = productName;
		ProductPrice = productPrice;
		Productcategory = productcategory;
		ProductBrand = productBrand;
		this.qty = qty;
		this.productfeauter = productfeauter;
		this.productimage = productimage;
	}

	public Product(Integer productId, String productName, Double productPrice, Category productcategory,
			Brand productBrand, Integer qty, String productfeauter, String productimage) {
		super();
		ProductId = productId;
		ProductName = productName;
		ProductPrice = productPrice;
		Productcategory = productcategory;
		ProductBrand = productBrand;
		this.qty = qty;
		this.productfeauter = productfeauter;
		this.productimage = productimage;
	}



	


	
	
	
}
