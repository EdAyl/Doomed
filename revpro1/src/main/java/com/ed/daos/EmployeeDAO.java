package com.ed.daos;

import java.sql.Connection;
import java.util.List;

import com.ed.models.Employee;

public interface EmployeeDAO {
	public List<Employee> getEmployees();
	public Employee getEmployeeFromID(int accountID);
	Employee getEmployeeFromID(int accountID, Connection con);
	public int createEmployee(Employee employee);
	public Employee getEmployeeFromUsername(String username);
}
