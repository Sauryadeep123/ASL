package com.asl.db.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.asl.connector.Connector;
import com.asl.db.entity.Employee;
import com.asl.db.entity.EmployeeDetails;

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
	
	public  boolean alreadyUser(String email1) {
		conn = Connector.getConnection();

		PreparedStatement p = null;
		ResultSet rs = null;
		try {

			String sql = "select email from employees";
			p = conn.prepareStatement(sql);
			rs = p.executeQuery();
			while (rs.next()) {
				String email2 = rs.getString("email");
				if (email1.equals(email2)) {

					return true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

	public  ArrayList<EmployeeDetails> showEmployee() {
		conn = Connector.getConnection();
		

		PreparedStatement p1 = null;
		ResultSet rs1 = null;
		
		try {
			String sql1 = "select * from employees";
			
			p1 = conn.prepareStatement(sql1);
			rs1 = p1.executeQuery();
			
			if(rs1!=null)
			{
				ArrayList<EmployeeDetails> list=new ArrayList<>();
				
			while (rs1.next()) {
				System.out.println("");
				EmployeeDetails e1 = new EmployeeDetails();
				
					e1.setFirstName(rs1.getString("first_name"));
					e1.setEmail(rs1.getString("email"));
                    e1.setSerialNo(rs1.getInt("id"));
                   String image=getImage(e1.getSerialNo());
                   e1.setPhoto(image);
                   System.out.println(e1.getFirstName()+" "+e1.getEmail()+" "+e1.getPhoto()+" "+e1.getSerialNo());
                   list.add(e1);
        				
        			}
			
			return list;
				}
			
			
				
				
			
				
		} catch (SQLException e) {
			System.out.println("employee details exception");
			e.printStackTrace();
		}
		return null;
	}
	
	public  String getImage(int id1) {
		conn = Connector.getConnection();
		System.out.println("id "+id1);

		PreparedStatement p = null;
		ResultSet rs = null;
		int flag = 0;
		try {

			String sql = "select * from employee_details";
			p = conn.prepareStatement(sql);
			rs = p.executeQuery();
			while (rs.next()) {
				int id2=rs.getInt("id");
				if (id1==id2) {

					return rs.getString("photo");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "-1";

	}
	public  String getId(String email1) {
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
				if (email1.equals(email2)) {

					return rs.getString("id");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "-1";

	}
}