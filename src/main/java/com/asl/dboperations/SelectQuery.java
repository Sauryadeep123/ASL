package com.asl.dboperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.asl.connector.Connector;
import com.asl.dbentity.EmployeeDetails;

public class SelectQuery {
	static Connection conn = Connector.getConnection();
	public static boolean isValidUser(String email1, String password1) {

		PreparedStatement p = null;
		ResultSet rs = null;
		int flag = 0;
		try {
			System.out.println("Successs!!");
			String sql = "select * from employee_list";
			p = conn.prepareStatement(sql);
			rs = p.executeQuery();
			while (rs.next()) {
				String email2 = rs.getString("email");
				String password2 = rs.getString("password");
				if (email1.equals(email2) && password1.equals(password2)) {
					return true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	public static EmployeeDetails showEmployee(String email1)
	{
		EmployeeDetails e1=new EmployeeDetails();
		
		String sql = "select * from employee_list where email=?";
		PreparedStatement p = null;
		ResultSet rs = null;
		try {
			p = conn.prepareStatement(sql);
			p.setString(1, email1);
			rs = p.executeQuery();
		
			e1.setFirstName(rs.getString("first_name"));
			e1.setCity(sql);
			return e1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return e1;
	
		
		
		
	}
}
