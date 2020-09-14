package com.revature.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.utils.ConnectionUtil;
import com.revature.models.Role;

public class UserDAO implements IUserDAO {

	@Override
	public User findById(int id) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM project1.ers_users WHERE ers_users_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				return new User(
						rs.getInt("ers_users_id"),
						rs.getString("user_first_name"),
						rs.getString("user_last_name"),
						rs.getString("ers_username"),
						rs.getString("ers_password"),
						rs.getString("user_email"),
						rs.getInt("user_role_id") == 1 ? new Role(1, "manager") : new Role(2, "employee") 
						);
			}
		} catch(SQLException e) {
			return null;
		}
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
						rs.getString("user_email"),
						rs.getInt("user_role_id") == 1 ? new Role(1, "manager") : new Role(2, "employee") 
						);
			}
		} catch(SQLException e) {
			return null;
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		List<User> allUsers = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM project1.ers_users";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("ers_users_id");
				String fName = rs.getString("user_first_name");
				String lName = rs.getString("user_last_name");
				String username = rs.getString("ers_username");
				String password = rs.getString("ers_password");
				String email = rs.getString("user_email");
				Role role = rs.getInt("user_role_id") == 1 ? new Role(1, "manager") : new Role(2, "employee");
				User u = new User(id, username, password, fName, lName, email, role);
				allUsers.add(u);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("FAILED TO RETRIEVE ALL USERS");
			return null;
		}
		
		return allUsers;
	}

	@Override
	public int insert(User u) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO project1.ers_users "
				+ "(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)"
				+ " VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, u.getFirstName());
			stmt.setString(2, u.getLastName());
			stmt.setString(3, u.getUsername());
			stmt.setString(4, u.getPassword());
			stmt.setString(5, u.getEmail());
			stmt.setObject(6, u.getRole().getId());
			int update = stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			 if (rs != null && rs.next()) {
				  int key = (int) rs.getLong(1);
				  return key;
				 }
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("FAILED TO INSERT USER");
		}
		return 0;
	}

	@Override
	public User update(User u) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE project1.ers_users SET user_first_name = ?, user_last_name = ?,"
					+ " ers_username = ?, ers_password = ?, user_email = ?, user_role_id = ? WHERE project1.ers_users_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, u.getFirstName());
			stmt.setString(2, u.getLastName());
			stmt.setString(3, u.getUsername());
			stmt.setString(4, u.getPassword());
			stmt.setString(5, u.getEmail());
			stmt.setObject(6, u.getRole());
			
			if (stmt.executeUpdate() != 0) {
				return new User(u.getId(), u.getFirstName(), u.getLastName(), u.getUsername(), u.getPassword(), u.getEmail(), u.getRole());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("FAILED TO UPDATE USER");
		}
		return null;
	}

	@Override
	public boolean delete(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "DELETE FROM project1.ers_users WHERE project1.ers_users.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			if (stmt.executeUpdate() != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("FAILED TO DELETE USER");
		}
		return false;
	}
}