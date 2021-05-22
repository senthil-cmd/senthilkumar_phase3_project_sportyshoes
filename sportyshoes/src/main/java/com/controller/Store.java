package com.controller;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.BrandService;
import com.service.CategoryService;
import com.service.ProductService;
import com.service.PurchaseReportService;
import com.service.UserService;
import com.bean.*;

@Controller

public class Store {
	@Autowired
	BrandService brandservice;
	
	@Autowired
	ProductService productservice;
	@Autowired
	CategoryService categoryservice;
	@Autowired
	PurchaseReportService reportservices;
	
	@Autowired
	UserService userservice;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

	//---------------------brand service----------------------------//+
	
	
	
	@RequestMapping(value ="/managebrand",method = RequestMethod.GET)
	public String managebrand(ModelMap model) {
	//	String name = (String) model.get("name");
		model.put("brandlist", brandservice.loadbrand());
		return"managebrand";
}
	@RequestMapping(value ="/addbrand", method = RequestMethod.GET)
	public String showaddbrand(ModelMap model) {
		model.addAttribute("brand",new Brand(0,"brandname"));
		return "brand";
	}
	
	@RequestMapping(value ="/addbrand", method = RequestMethod.POST)
	public String addbrand(ModelMap model, @Valid Brand brand, BindingResult result) {

		if (result.hasErrors()) {
			return "brand";
		}
		brandservice.addBrand(brand.getBrandName());
		return "redirect:/managebrand";
	}
	@RequestMapping(value = "/updatebrand", method = RequestMethod.GET)
	public String showUpdatebrand(@RequestParam int id, ModelMap model) {
		Brand brand = brandservice.findBrand(id);
		model.put("brand", brand);
		return "brand";
	}

	@RequestMapping(value = "/updatebrand", method = RequestMethod.POST)
	public String updatebrand(ModelMap model, @Valid Brand brand,
			BindingResult result) {

		if (result.hasErrors()) {
			return "brand";
		}
		brandservice.updateBrand(brand.getBrandId(),brand.getBrandName());
		return "redirect:/managebrand";
	}
	@RequestMapping(value = "/deletebrand", method = RequestMethod.GET)
	public String deletebrand(@RequestParam int id) {
		brandservice.deleteBrand(id);
		return "redirect:/managebrand";
	}
	
	//------------------manage-category-------------------//
	
	@RequestMapping(value ="/managecategory",method = RequestMethod.GET)
	public String managecategory(ModelMap model) {
		model.put("categorylist",categoryservice.listcategory());
		return"managecategory";
}
	@RequestMapping(value ="/addcategory", method = RequestMethod.GET)
	public String showaddcategory(ModelMap model) {
		model.addAttribute("category",new Category(0,"category"));
		return "category";
	}
	@RequestMapping(value ="/addcategory", method = RequestMethod.POST)
	public String addcategory(ModelMap model, @Valid Category category, BindingResult result) {

		if (result.hasErrors()) {
			return "category";
		}
		categoryservice.addcategory(category.getCategoryName());
		return "redirect:/managecategory";
	}
	@RequestMapping(value = "/updatecategory", method = RequestMethod.GET)
	public String showUpdatecategory(@RequestParam int id, ModelMap model) {
		Category category = categoryservice.findcategory(id);
		model.put("Category",category);
		return "category";
	}

	@RequestMapping(value = "/updatecategory", method = RequestMethod.POST)
	public String updatecategory(ModelMap model, @Valid Category category,
			BindingResult result) {

		if (result.hasErrors()) {
			return "category";
		}
		categoryservice.updateCategory(category.getCategory(),category.getCategoryName());
		return "redirect:/managecategory";
	}
	@RequestMapping(value = "/deletecategory", method = RequestMethod.GET)
	public String deletecategory(@RequestParam int id) {
		categoryservice.deletecategory(id);
		return "redirect:/managecategory";
	}
	//-------------------manage product------------------//
	
	
	@RequestMapping(value ="/manageproduct",method = RequestMethod.GET)
	public String manageproduct(ModelMap model) {
		
		 
		model.put("productlist",productservice.listproduct());
		return"/manageproduct";
	}
		@RequestMapping(value ="/addproduct", method = RequestMethod.GET)
		public String showaddproduct(ModelMap model) {
			model.addAttribute("product",new Product(0,"productname",0.00,(new Category(1,"categoryname")),(new Brand(0,"brandname")),0,"feauture","image"));
			model.put("brand",brandservice.loadbrand());
			model.put("productcategory",categoryservice.listcategory());
			return "product";
		}
			@RequestMapping(value ="/addproduct", method = RequestMethod.POST)
		public @Valid String addproduct(ModelMap model ,@Valid Product product,BindingResult result) {
				if (result.hasErrors()) {
					return "product";
				}
				Category category = categoryservice.findcategory(product.getProductcategory().getCategory());
				Brand brand = brandservice.findBrand(product.getProductBrand().getBrandId());
				productservice.addproduct(product.getProductName(),product.getProductPrice(),category,brand,product.getQty(), product.getProductfeauter(),product.getProductimage());
				return "redirect:/manageproduct";
				
			
			}
			@RequestMapping(value = "/updateproduct", method = RequestMethod.GET)
			public String showupdateproduct(@RequestParam int id, ModelMap model) {
				Product product = productservice.findproduct(id);
				model.addAttribute("product",new Product(product.getProductId(),product.getProductimage(),product.getProductPrice(),new Category(product.getProductcategory().getCategory(),product.getProductcategory().getCategoryName()),new Brand(product.getProductBrand().getBrandId(),product.getProductBrand().getBrandName()),product.getQty(),product.getProductfeauter(),product.getProductimage()));
				model.put("brand",brandservice.loadbrand());
				model.put("productcategory",categoryservice.listcategory());
				return "product";
			}	
			
			@RequestMapping(value = "/updateproduct", method = RequestMethod.POST)
			public String updateproduct(ModelMap model, @Valid Product	product,
					BindingResult result) {

				if (result.hasErrors()) {
					return "product"; 
				}
				productservice.updateproduct(product.getProductId(),product.getProductName(),product.getProductPrice(),product.getQty(), product.getProductfeauter(),product.getProductimage());
				return "redirect:/manageproduct";
			}
			@RequestMapping(value = "/deleteproduct", method = RequestMethod.GET)
			public String deleteproduct(@RequestParam int id) {
				productservice.deleteproduct(id);
				return "redirect:/manageproduct";
			}
/*------------------------manage purchase report---------------*/
	@RequestMapping(value ="/managepurchasereport",method = RequestMethod.GET)
	public String managepurchasereport(ModelMap model) {
		PurchaseReport purchaserepots = reportservices.retrive(2);
		model.put("purchasereports",purchaserepots);
		return"managepurchasereport";
	
		
}
	@RequestMapping(value ="/managepurchasereport",method = RequestMethod.POST)
	public String purchasebydate(ModelMap model,@Valid PurchaseReport purchasereport) {
		model.put("purchasebydate",reportservices.listpurchasebydate(purchasereport.getDate()));
		 return"purchasereport";
		
}
	
	@RequestMapping(value ="/manageuser",method = RequestMethod.GET)
	public String manageuser(ModelMap model) {
		model.put("listuser",userservice.listuser());
		return"/manageuser";
}
}