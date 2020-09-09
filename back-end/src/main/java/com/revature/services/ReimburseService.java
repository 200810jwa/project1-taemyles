package com.revature.services;

import java.io.IOException;
import java.nio.file.Files;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import com.revature.dao.IReimbursementDAO;
import com.revature.dao.ReimbursementDAO;
import com.revature.models.RStatus;
import com.revature.models.RType;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.models.templates.ReimburseTemplate;

public class ReimburseService {
	private IReimbursementDAO reimbursementDao = new ReimbursementDAO();
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	//(int id, double amount, Timestamp timeSubmitted, Timestamp timeResolved,
	//String description, Blob receipt, User author, User resolver, RStatus status, RType type)
	
	public Reimbursement addReimbursement(User u, ReimburseTemplate reim) {
		Reimbursement newReim = null;
		newReim = new Reimbursement(0, reim.getAmount(), timestamp,
				null, reim.getDescription(), reim.getReceipt(), u, null, new RStatus(1, "pending"),
				reim.getType() == "lodging" ? new RType(1, reim.getType()) : reim.getType() == "travel" ? new RType(2, reim.getType())
				: reim.getType() == "food" ? new RType(3,reim.getType()) : new RType(4, reim.getType()));
		int new_id = reimbursementDao.insert(newReim);
		if (new_id == 0) {
			return null;
		}
		newReim.setId(new_id);
		return newReim;
	}
}

//RType typeId = rs.getInt("reimb_type_id") == 1 ? new RType (1, "lodging")
//		: rs.getInt("reimb_type_id") == 2 ? new RType (2, "travel")
//		: rs.getInt("reimb_type_id") == 3 ? new RType (3, "food")
//		: new RType(4, "other");