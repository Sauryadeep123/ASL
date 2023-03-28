package com.asl.dboperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.asl.connector.Connector;
import com.asl.dbentity.EmployeeDetails;

public class InsertQuery {
	
	Connection conn = null;
	
	public int insertIntoEmployees(EmployeeDetails emp) {
		conn = Connector.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO employees (first_name,email,user_id,password)"
							+ " values (?,?,?,?);");
			ps.setString(1, emp.getFirstName());
			ps.setString(2, emp.getEmail());
			ps.setString(3, "ALU838");
			ps.setString(4, emp.getPassword());
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int insertIntoEmployeeDetails(EmployeeDetails emp,String id) {
		conn = Connector.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO employee_details (id,middle_name,last_name,city ,dob,photo,resume)"
							+ " values (?,?,?,?,?,?,?);");
			ps.setString(1, id);
			ps.setString(2, emp.getMiddleName());
			ps.setString(3, emp.getLastName());
			ps.setString(4, emp.getCity());
			ps.setString(5, emp.getDob());
			ps.setString(6, emp.getPhoto());
			ps.setString(7, emp.getResume());
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
