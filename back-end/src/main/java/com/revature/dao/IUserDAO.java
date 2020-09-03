package com.revature.dao;

import java.util.List;

import com.revature.models.User;

public interface IUserDAO {
	public User findById(int id);
	public User findByUsername(String username);
	public List<User> findAll();
	public User insert(User e);
	public User update(User e);
	public boolean delete(int id);
}
