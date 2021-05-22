package com.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bean.Brand;
import com.bean.Category;
import com.bean.Product;
import com.bean.User;
import com.service.BrandService;
import com.service.CategoryService;
import com.service.ProductService;
import com.service.PurchaseReportService;
import com.service.UserService;

@Controller
@SessionAttributes("name")
public class Home {
	@Autowired
	BrandService brandservice;
	
	@Autowired
	ProductService productservice;
	@Autowired
	CategoryService categoryservice;
	@Autowired
	UserService userservice;
	@Autowired
	PurchaseReportService purchaseoder;
	List<Product> cart = new ArrayList<Product>();
	@RequestMapping(value ="/",method = RequestMethod.GET)
	public String homepage(ModelMap model) {
		model.put("productlist",productservice.listproduct());
		return"index";
	}
	@RequestMapping(value ="/userlogin",method = RequestMethod.GET)
	public String userlogin() {
		return "userlogin";
	}
	@RequestMapping(value ="/userlogin",method = RequestMethod.POST)
	public String loginvaild(ModelMap model,@RequestParam("Uname") String name,@RequestParam("Pass") String password) {
		if(userservice.loginvalid(name, password)) {
			model.put("name", name);
			model.put("password", password);
			return "redirect:/";
		}
		model.put("errorMessage", "Invalid Credentials");
		return "userlogin";		
	}
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String addtocart(@RequestParam int id,ModelMap model) {
		Product product = productservice.findproduct(id);
		cart.add(product);
		return "redirect:/";
	}
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String showcheckout(ModelMap model) {
		model.put("cart",cart);
		String name=(String) model.get("name");
		if(name==null) {
			model.put("errorMessage", "login or Register");
			return"/userlogin";
		}
		if(name.equals(userservice.getuname(name)))
		{
			return"checkout";
		}
		return"redirect:/userlogin";
}
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	@ResponseBody
	public String checkout( ModelMap model) {
		String name=(String) model.get("name");
		User user = userservice.retriveuser(name);
		Date date = new Date();
		purchaseoder.addpurchase(date, cart, user);
		cart.clear();
		return"<h1>oder placed scuessfully</h1>";
}	
	@RequestMapping(value ="/user",method = RequestMethod.GET)
	public String viewuserregister() {
		return "user";
	}
	@RequestMapping(value ="/user",method = RequestMethod.POST)
	public String registeruser(ModelMap model,@RequestParam("Uname") String name,@RequestParam("Pass") String password,@RequestParam("Username") String username,@RequestParam("email") String email) {
		if(username==null||name==null||password==null||email==null) {
			model.put("errorMessage", "Invalid Credentials");
			return "user";
		}
		userservice.Adduser(username, name, password, email);
		return "/userlogin";		
	}
}

