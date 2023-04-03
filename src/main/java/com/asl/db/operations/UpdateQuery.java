package com.asl.db.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.asl.connector.Connector;
import com.asl.db.entity.EmployeeDetails;

public class UpdateQuery {
Connection conn = null;
	
	public int updateIntoEmployees(EmployeeDetails emp) {
		conn = Connector.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE INTO employees (first_name,email,user_id,password)"
							+ " values (?,?,?,?) WHERE ID=?;");
			ps.setString(1, emp.getFirstName());
			ps.setString(2, emp.getEmail());
			ps.setString(3, "ALU838");
			ps.setString(4, emp.getPassword());
			ps.setInt(5, emp.getSerialNo());
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateIntoEmployeeDetails(EmployeeDetails emp,String id) {
		conn = Connector.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"update INTO employee_details (id,middle_name,last_name,city ,dob,photo,resume)"
							+ " values (?,?,?,?,?,?,?) where id=?;");
			ps.setString(1, id);
			ps.setString(2, emp.getMiddleName());
			ps.setString(3, emp.getLastName());
			ps.setString(4, emp.getCity());
			ps.setString(5, emp.getDob());
			ps.setString(6, emp.getPhoto());
			ps.setString(7, emp.getResume());
			ps.setInt(7, emp.getSerialNo());
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
