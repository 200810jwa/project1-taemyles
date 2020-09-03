package com.revature.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.User;
import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

public class UserDAO implements IUserDAO {

	@Override
	public User findById(int id) {
		return null;
	}

	@Override
	public User findByUsername(String username) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM project1.ers_users WHERE ers_username = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, username);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				return new User(
						rs.getInt("ers_users_id"),
						rs.getString("user_first_name"),
						rs.getString("user_last_name"),
						rs.getString("ers_username"),
						rs.getString("ers_password"),
						rs.getString("ers_email"),
						rs.getInt("user_role_id") == 1 ? new Role(1, "Finance Manager") : new Role(2, "Employee") 
						);
			}
		} catch(SQLException e) {
			return null;
		}
		
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User insert(User e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
