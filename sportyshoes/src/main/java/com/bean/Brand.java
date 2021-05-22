package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer BrandId;
	private String BrandName;

	public Integer getBrandId() {
		return BrandId;
	}

	public void setBrandId(Integer brandId) {
		BrandId = brandId;
	}

	public String getBrandName() {
		return BrandName;
	}

	public void setBrandName(String brandName) {
		BrandName = brandName;
	}

	public Brand() {

	}

	public Brand(Integer brandId, String brandName) {
		super();
		BrandId = brandId;
		BrandName = brandName;
	}

	public Brand(String brandName) {
		BrandName = brandName;
	}


}
