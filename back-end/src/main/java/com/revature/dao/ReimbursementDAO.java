package com.revature.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import com.revature.models.RStatus;
import com.revature.models.RType;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;


public class ReimbursementDAO implements IReimbursementDAO{
	private IUserDAO userDao = new UserDAO();
	
	@Override
	public Reimbursement findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> findAll() {
		List<Reimbursement> allReimbursement = new ArrayList<>();
//		
//		try(Connection conn = ConnectionUtil.getConnection()) {
//			String sql = "SELECT * FROM project1.ers_reimbursement";
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			ResultSet rs = stmt.executeQuery();
//			
//			while(rs.next()) {
//				int id = rs.getInt("reimb_id");
//				Double amount = rs.getDouble("reimb_amount");
//				Timestamp submitted = rs.getTimestamp("reimb_submitted");
//				Timestamp resolved = rs.getTimestamp("reimb_resolved");
//				String description = rs.getString("reimb_description");
//				String receipt = rs.getString("reimb_receipt");
//				User author = userDao.findById(rs.getInt("reimb_author"));
//				User resolver = userDao.findById(rs.getInt("reimb_resolver"));
//
//				RStatus statusId = rs.getInt("reimb_status_id") == 1 ? new RStatus (1, "pending")
//						: rs.getInt("reimb_status_id") == 2 ? new RStatus (2, "approved") 
//						: new RStatus (3, "denied");
//				RType typeId = rs.getInt("reimb_type_id") == 1 ? new RType (1, "lodging")
//						: rs.getInt("reimb_type_id") == 2 ? new RType (2, "travel")
//						: rs.getInt("reimb_type_id") == 3 ? new RType (3, "food")
//						: new RType(4, "other");
//				
//				Reimbursement reim = new Reimbursement(id, amount, submitted,
//						resolved, description, receipt, author, resolver, statusId, typeId);
//				allReimbursement.add(reim);
//			}
//		} catch(SQLException e) {
//			e.printStackTrace();
//			System.out.println("FAILED TO RETRIEVE ALL REIMBURSEMENTS");
//			return null;
//		}
		return allReimbursement;
	}

	@Override
	public int insert(Reimbursement reim) {
		String sql = "INSERT INTO project1.ers_reimbursement (reimb_amount, reimb_submitted, reimb_description, reimb_receipt, reimb_author,"
				+ " reimb_status_id, reimb_type_id) VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING project1.ers_reimbursement.reimb_id";
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setDouble(1, reim.getAmount());
			stmt.setTimestamp(2, reim.getTimeSubmitted());
			stmt.setString(3, reim.getDescription());
			stmt.setBytes(4, reim.getReceipt());
			stmt.setInt(5, reim.getAuthor().getId());
			stmt.setInt(6, reim.getStatus().getId());
			stmt.setInt(7, reim.getType().getId());
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
	public Reimbursement update(Reimbursement e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
