package com.service;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.AdminDao;
import com.bean.Admin;

@Service
public class AdminService {
	@Autowired
	private AdminDao admindao;
	
	
	public boolean loginvalid(String username,String password) {
		Admin admin = admindao.findById(username).get();
		if(username.equals(admin.getUsername())&&password.equals(admin.getPassword())) {
			return true;
		}
		
		return false;		
	}
	
	public void updateadmin(String username,String password) {
		Admin admin = admindao.findById(username).get();
		admin.setPassword(password);
		admindao.save(admin);
	}
}
