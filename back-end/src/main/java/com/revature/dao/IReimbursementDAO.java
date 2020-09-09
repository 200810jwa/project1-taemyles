package com.revature.dao;

import java.util.List;

import com.revature.models.Reimbursement;

public interface IReimbursementDAO {
	public Reimbursement findById(int id);
	public List<Reimbursement> findAll();
	public int insert(Reimbursement e);
	public Reimbursement update(Reimbursement e);
	public boolean delete(int id);
}
