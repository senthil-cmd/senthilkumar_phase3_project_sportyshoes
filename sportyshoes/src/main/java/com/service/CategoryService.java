package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.CategoryDao;
import com.bean.Category;
@Service
public class CategoryService {
	@Autowired
	private CategoryDao categorydao;
	
	public void addcategory(String categoryname ) {
		categorydao.save(new Category(categoryname));
	}
	public Category findcategory(Integer categoryid) {
		return categorydao.findById(categoryid).get();
	}
	public void updateCategory(Integer categoryid,String categoryname) {
		Category category = categorydao.findById(categoryid).get();
		category.setCategoryName(categoryname);
		categorydao.save(category);
	}
	public void deletecategory(Integer categoryid) {
		Optional<Category> category = categorydao.findById(categoryid);
	if (category.isPresent()) {
		categorydao.deleteById(categoryid);
	}
	}
	public List<Category> listcategory(){
		
		ArrayList<Category> categorylist  =(ArrayList<Category>)categorydao.findAll();
				return categorylist;
	}
	
}
