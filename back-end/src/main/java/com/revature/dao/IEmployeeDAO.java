package com.revature.dao;

import java.util.List;

import com.revature.models.Employee;

public interface IEmployeeDAO {
	public Employee findById(int id);
	public Employee findByUsername(String username);
	public List<Employee> findAll();
	public Employee insert(Employee e);
	public Employee update(Employee e);
	public boolean delete(int id);
}
