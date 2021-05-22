package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Category;
	private String CategoryName;
	

	public Integer getCategory() {
		return Category;
	}
	public void setCategory(Integer category) {
		Category = category;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	
	public Category() {
		
	}
	public Category(String categoryName) {
		super();
		CategoryName = categoryName;
	}
	public Category(Integer category, String categoryName) {
		super();
		Category = category;
		CategoryName = categoryName;
	}
	
}
