package com.revature.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

public class EmployeeDAO implements IEmployeeDAO {

	@Override
	public Employee findById(int id) {
		return null;
	}

	@Override
	public Employee findByUsername(String username) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM project1.ers_users WHERE ers_username = ?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, username);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				return new Employee(
						rs.getInt("ers_users_id"),
						rs.getString("user_first_name"),
						rs.getString("user_last_name"),
						rs.getString("ers_username"),
						rs.getString("ers_password"),
							rs.getInt("user_role_id") == 1 ? new Role(1, "Finance Manager") : new Role(2, "Employee") 
						);
			}
		} catch(SQLException e) {
			return null;
		}
		
		return null;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee insert(Employee e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee update(Employee e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
