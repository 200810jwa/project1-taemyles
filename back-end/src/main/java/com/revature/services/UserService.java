package com.revature.services;

import com.revature.models.User;
import com.revature.models.templates.LoginTemplate;
import com.revature.dao.UserDAO;
import com.revature.dao.IUserDAO;

public class UserService {
	
	private IUserDAO userDao = new UserDAO();
	
	public User login(LoginTemplate lt) {
		User e = userDao.findByUsername(lt.getUsername());
		
		if(e == null) {
			// Instead throw custom exception
			return null;
		}
		
		if(e.getPassword().equals(lt.getPassword())) {
			return e;
		}
		return null;
	}
}
