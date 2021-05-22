package com.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.Brand;
import com.bean.Category;
import com.bean.Product;
@Repository
public interface ProductDao extends CrudRepository< Product, Integer> {
	
}

