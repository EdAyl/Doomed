package com.ed.daos;

import java.sql.Connection;
import java.util.List;

import com.ed.models.Reimbursements;

public interface ReimbursementsDAO {
	List<Reimbursements> getReimbursements();
	Reimbursements getReimbursementByID(int id);
	Reimbursements getReimbursementByID(int id, Connection con);
	List<Reimbursements> getPendingReimbursements();
	List<Reimbursements> getApprovedReimbursements();
	List<Reimbursements> getDeniedReimbursements();
	List<Reimbursements> getReimbursementFromEmployeeID(int employeeID);
	List<Reimbursements> getPendingReimbursementsFromEmployeeID(int employeeID);
	List<Reimbursements> getApprovedReimbursementsFromEmployeeID(int employeeID);
	List<Reimbursements> getDeniedReimbursementsFromEmployeeID(int employeeID);
	void addReimbursement(Reimbursements r);
}
