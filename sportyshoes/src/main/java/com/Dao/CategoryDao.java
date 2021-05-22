package com.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.Category;

@Repository
public interface CategoryDao extends CrudRepository<Category, Integer> {

}
