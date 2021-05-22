package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.UserDao;
import com.bean.Admin;
import com.bean.User;

@Service
public class UserService {

	@Autowired
	private UserDao userdao;

	public void Adduser(String username, String uname,String password,String email) {
		userdao.save(new User(username,uname,password,email));
	}
	
	public List<User> listuser(){
		ArrayList<User> userlist = (ArrayList<User>)userdao.findAll();
		return userlist;
		
	}
	
	public User retriveuser(String uname){
		User user=userdao.findById(uname).get();
		
		return user;
	}
	
	public String getuname(String uname) {
		User user=userdao.findById(uname).get();
		
		return user.getUname();
	}
	public boolean loginvalid(String uname,String password) {
		User user = userdao.findById(uname).get();
		if(uname.equals(user.getUname())&&password.equals(user.getPassword())) {
			return true;
		}
		
		return false;		
	}
}
