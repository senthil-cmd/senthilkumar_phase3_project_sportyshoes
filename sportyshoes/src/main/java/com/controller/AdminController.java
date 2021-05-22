package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.AdminService;
import com.service.PurchaseReportService;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminservice;
	
	@Autowired
	PurchaseReportService reportservice;

	@RequestMapping(value ="/adminlogin",method = RequestMethod.GET)
	public String login() {
		return "adminlogin";
	}
	
	@PostMapping("/adminlogin")
	public String loginvaild(ModelMap model,@RequestParam("Uname") String name,@RequestParam("Pass") String password) {
		if(adminservice.loginvalid(name, password)) {
			model.put("name", name);
			model.put("password", password);
			model.put("reportlist",reportservice.listpurchase());
			return "Store";
		}
		model.put("errorMessage", "Invalid Credentials");
		return "adminlogin";		
	}
	
	@RequestMapping(value ="/AdminPasswordReset",method = RequestMethod.GET)
	public String passwordreset() {
		
		return "/AdminPasswordReset";
	}
	@PostMapping("/AdminPasswordReset")
	public String AdminPasswordReset(ModelMap model,@RequestParam("Uname") String name,@RequestParam("OPass") String password,@RequestParam("NPass") String Npassword) {
		if(adminservice.loginvalid(name, password)) {
			adminservice.updateadmin(name, Npassword);
			return "redirect:/adminlogin";
		}		
		model.put("errorMessage", "Invalid Credentials");
	return "AdminPasswordReset";
	
}
}
