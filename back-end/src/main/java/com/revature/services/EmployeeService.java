package com.revature.services;

import com.revature.models.Employee;
import com.revature.models.templates.LoginTemplate;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.IEmployeeDAO;

public class EmployeeService {
	
	private IEmployeeDAO employeeDao = new EmployeeDAO();
	
	public Employee login(LoginTemplate lt) {
		
		Employee e = employeeDao.findByUsername(lt.getUsername());
		
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
