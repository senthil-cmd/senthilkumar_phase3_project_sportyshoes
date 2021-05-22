package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.BrandDao;
import com.bean.Brand;
@Service
public class BrandService {
	@Autowired
	private BrandDao branddao;

	
	public void addBrand(String brandname ) {
		branddao.save(new Brand(brandname ));
	}
	public Brand findBrand(Integer brandid) {
	return	branddao.findById(brandid).get();	
	}
	public void updateBrand(Integer brandid,String brandname) {
			Brand brand = branddao.findById(brandid).get();
			brand.setBrandName(brandname);
			branddao.save(brand);
	}
	public void deleteBrand(Integer brandid) {
		Optional<Brand> brand = branddao.findById(brandid);
		if(brand.isPresent()) {
			branddao.deleteById(brandid);
		}
	}
	public List<Brand> loadbrand(){
		
	ArrayList<Brand> brandlist = (ArrayList<Brand>) branddao.findAll();
		
		return brandlist;
	}
	
}
