package com.revature.services;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.IReimbursementDAO;
import com.revature.dao.IUserDAO;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.UserDAO;
import com.revature.models.RStatus;
import com.revature.models.RType;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.models.templates.ManagerReimburseTemplate;
import com.revature.models.templates.ReimburseTemplate;

public class ReimburseService {
	private IReimbursementDAO reimbursementDao = new ReimbursementDAO();
	private IUserDAO userDao = new UserDAO();
	
	public ReimburseService() {
		super();
		this.reimbursementDao = new ReimbursementDAO();
	}
	
	public ReimburseService(IReimbursementDAO reimDao) {
		super();
		this.reimbursementDao = reimDao;
	}
	
	public Reimbursement addReimbursement(User u, ReimburseTemplate reim) {
		Reimbursement newReim = null;
		newReim = new Reimbursement(0, reim.getAmount(), new Timestamp(System.currentTimeMillis()),
				null, reim.getDescription(), utfToByte(reim.getReceipt()), u, null, new RStatus(1, "pending"),
				reim.getType().equals("lodging") ? new RType(1, reim.getType()) : reim.getType().equals("travel") ? new RType(2, reim.getType())
				: reim.getType().equals("food") ? new RType(3,reim.getType()) : new RType(4, reim.getType()));
		int new_id = reimbursementDao.insert(newReim);
		if (new_id == 0) {
			return null;
		}
		newReim.setId(new_id);
		return newReim;
	}

	public Boolean updateReimbursement(User u, ManagerReimburseTemplate reim) {
		Reimbursement newReim = null;
		newReim = new Reimbursement(reim.getId(), reim.getAmount(), reim.getTimeSubmitted(), new Timestamp(System.currentTimeMillis()), reim.getDescription(),
				utfToByte(reim.getReceipt()), reim.getAuthor(), u, reim.getStatus().equals("pending") ? new RStatus(1, reim.getStatus())
				: reim.getStatus().equals("approved") ? new RStatus(2, reim.getStatus()) : new RStatus(3, reim.getStatus()),
				null);
		System.out.println(newReim);
		boolean success = reimbursementDao.update(newReim);
		if (success == false) {
			return null;
		}
		return true;
	}
	
	public List<Reimbursement> viewReimbursement(User u) {
		List<Reimbursement> allReim = new ArrayList<Reimbursement>();
		List<Reimbursement> retReim = new ArrayList<Reimbursement>();
		allReim = reimbursementDao.findAll();
		for (int i = 0; i < allReim.size(); i++) {
			if (allReim.get(i).getAuthor().getUsername().equals(u.getUsername())) {
				retReim.add(allReim.get(i));
			}
		}
		return retReim;
	}
	
	public List<Reimbursement> viewAllReimbursement() {
		List<Reimbursement> allReim = new ArrayList<Reimbursement>();
		allReim = reimbursementDao.findAll();
		return allReim;
	}
	
	public byte[] utfToByte(String s) {
		byte[] bytes = null;
		try {
			bytes = s.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bytes;
	}
}