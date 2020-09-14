package com.revature.services;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.models.templates.LoginTemplate;
import com.revature.models.templates.RegisterTemplate;
import com.revature.dao.UserDAO;

import org.apache.commons.codec.binary.Base64;

import com.revature.dao.IUserDAO;

public class UserService {
	
	private IUserDAO userDao = new UserDAO();
	private PasswordService passServ = new PasswordService();
	
	public UserService() {
		super();
		this.userDao = new UserDAO();
	}
	
	public UserService(IUserDAO userDao) {
		super();
		this.userDao = userDao;
	}
	
	public User login(LoginTemplate lt) {
		User e = userDao.findByUsername(lt.getUsername());
		if(e == null) {
			// Instead throw custom exception
			return null;
		}
		String p1 = e.getPassword();
		String decrypted = passServ.decrypt(p1);
		if(lt.getPassword().equals(decrypted)) {
			return e;
		}
		return null;
	}
	
	public User register(RegisterTemplate rt) {
		String encryptedPass = passServ.encrypt(rt.getPassword());
		User u = new User(0, rt.getUsername(), encryptedPass, rt.getfName(), rt.getlName(), rt.getEmail(), new Role(2, "employee"));
		int new_id = userDao.insert(u);
		if (new_id == 0) {
			return null;
		}
		return u;
		
	}
	
}