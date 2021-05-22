package com.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.PurchaseReportDao;
import com.bean.Category;
import com.bean.Product;
import com.bean.PurchaseReport;
import com.bean.User;
@Service
public class PurchaseReportService {
	@Autowired
	private PurchaseReportDao purchasereportdao;
	
	public void addpurchase(Date date,List<Product> product,User user) {
		purchasereportdao.save(new PurchaseReport(date,product,user));
	}
	public List<PurchaseReport> listpurchase(){
		ArrayList<PurchaseReport> purchaselist =(ArrayList<PurchaseReport>)purchasereportdao.findAll(); 
		return purchaselist ;
		
	}
	
	public List<PurchaseReport> listpurchasebydate(Date date){
		ArrayList<PurchaseReport> purchaselist =(ArrayList<PurchaseReport>)purchasereportdao.findAll();
		ArrayList<PurchaseReport> purchasebydate = new ArrayList<PurchaseReport>();
		for (PurchaseReport purchase : purchaselist) {
			if(purchase.getDate().equals(date)) {
				purchasebydate.add(purchase);
			}	
		}
	return purchasebydate;
	}
	public List<PurchaseReport> listpurchasebycategory(String name){
		ArrayList<PurchaseReport> purchaselist =(ArrayList<PurchaseReport>)purchasereportdao.findAll();
		ArrayList<PurchaseReport> purchasebycategory = new ArrayList<PurchaseReport>();
		List<Product> product = new ArrayList<Product> ();
		for (PurchaseReport purchase : purchaselist){
			 List<Product> products = purchase.getProduct();
			 for(Product product1 :products) {
				 if(product1.getProductcategory().getCategoryName().equals(name)) {
					 product.add(product1);
					 purchasebycategory.add(purchase);
				 }
				 
			 }
		}
	return purchasebycategory;
	}
	
	public PurchaseReport retrive(Integer id) {
		PurchaseReport report = purchasereportdao.findById(id).get();
		return report;
	}
}
