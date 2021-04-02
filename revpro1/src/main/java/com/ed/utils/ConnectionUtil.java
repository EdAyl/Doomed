package com.ed.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public class ConnectionUtil {
	
	public static Connection getConnection() throws SQLException {
		Driver PostgresDriver = new Driver(); 
	    DriverManager.registerDriver(PostgresDriver);
		String url = "jdbc:postgresql://localhost:5432/Reimbursement";
		String user = "postgres";
		String password = "ea006008007";
		return DriverManager.getConnection(url, user, password);
	}
	
	public static void main(String[] args) {
		try(Connection con = ConnectionUtil.getConnection()){
			System.out.println("Connection successful");
		}catch(SQLException e){
			System.out.println(e);
		}
	}
}
