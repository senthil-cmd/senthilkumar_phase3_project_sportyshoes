package com.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.Brand;
@Repository
public interface BrandDao extends CrudRepository<Brand, Integer> {

}
