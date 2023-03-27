package com.asl.dboperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.asl.connector.Connector;
import com.asl.dbentity.Employee;
import com.asl.dbentity.EmployeeDetails;

public class SelectQuery {
	Connection conn = null;

	public  boolean isValidUser(String email1, String password1) {
		conn = Connector.getConnection();

		PreparedStatement p = null;
		ResultSet rs = null;
		int flag = 0;
		try {

			String sql = "select * from employees";
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

	public  ArrayList<Employee> showEmployee() {
		conn = Connector.getConnection();
		

		PreparedStatement p = null;
		ResultSet rs = null;
		try {
			String sql = "select * from employees";
			p = conn.prepareStatement(sql);
            
			rs = p.executeQuery();
			if(rs!=null)
			{
				ArrayList<Employee> list=new ArrayList<>();
			
			while (rs.next()) {
				System.out.println("");
				  Employee e1 = new Employee();
					e1.setFirstName(rs.getString("first_name"));
					e1.setEmail(rs.getString("email"));
                    e1.setSerialNo(rs.getInt("id"));
					e1.setUserId(rs.getString("user_id"));
					list.add(e1);
					System.out.println(e1.getFirstName());
				
				}
			return list;
			}
			

		} catch (SQLException e) {
			System.out.println("employee details exception");
			e.printStackTrace();
		}
		return null;
	}
}