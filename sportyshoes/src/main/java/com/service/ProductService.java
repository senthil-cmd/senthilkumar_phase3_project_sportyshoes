package com.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.ProductDao;
import com.bean.Brand;
import com.bean.Category;
import com.bean.Product;
@Service
public class ProductService {

	@Autowired
	private ProductDao productdao;
	
	public void addproduct(String productname,Double productprice,Category productcategory,Brand productbrand,Integer qty,String productfeauter,String Productimage) {
	
		productdao.save(new Product(productname, productprice, productcategory, productbrand, qty,productfeauter, Productimage ));
	}
	
	
	
	
	public Product findproduct(Integer productid) {
		return productdao.findById(productid).get();	
	}
	
	public void deleteproduct(Integer productid) {
		Optional<Product> product = productdao.findById(productid);
		if(product.isPresent()) {
			productdao.deleteById(productid);
		}
	}
	public void updateproduct(Integer productid,String productname,Double productprice,Integer qty,String productfeauter,String Productimage) {
		Product product = productdao.findById(productid).get();
			product.setProductName(productname);
			product.setProductPrice(productprice);
			product.setQty(qty);
			product.setProductfeauter(productfeauter);
			product.setProductimage(Productimage);
		productdao.save(product);
	}
			
		
	
public ArrayList<Product> listproduct(){
	
	ArrayList<Product> productlist= (ArrayList<Product>) productdao.findAll();
		
		return productlist;
	}
}
