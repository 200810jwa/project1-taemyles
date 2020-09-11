package com.revature.services;

import com.revature.models.User;
import com.revature.models.templates.LoginTemplate;
import com.revature.dao.UserDAO;

import org.apache.commons.codec.binary.Base64;

import com.revature.dao.IUserDAO;

public class UserService {
	
	private IUserDAO userDao = new UserDAO();
	private PasswordService passServ = new PasswordService();
	public User login(LoginTemplate lt) {
		User e = userDao.findByUsername(lt.getUsername());
		if(e == null) {
			// Instead throw custom exception
			return null;
		}
		String p1 = e.getPassword();
		String pass = lt.getPassword();
		String decrypted = passServ.decrypt(p1);
		if(lt.getPassword().equals(decrypted)) {
			return e;
		}
		return null;
	}
	
}