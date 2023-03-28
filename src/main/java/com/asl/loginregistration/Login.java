package com.asl.loginregistration;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asl.connector.Connector;
import com.asl.dbentity.Employee;
import com.asl.dbentity.EmployeeDetails;
import com.asl.dboperations.SelectQuery;
import com.google.gson.Gson;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


/**
 * Servlet implementation class login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		System.out.println("loginnnnnnnnnnnn!!!!!!!");
		PrintWriter out=res.getWriter();
		ArrayList<Employee> list= null;
		String email1 = req.getParameter("email");
		System.out.println(email1);
		String password1 = req.getParameter("password");
//		Map<Integer,Map<String,String>> responseData = new HashMap<>();
		if ((new SelectQuery()).isValidUser(email1, password1)) {
			System.out.println("user present!!!!!!!");
			
			list=new SelectQuery().showEmployee();
//			Gson jsonarray[]=new Gson[list.size()];
//			int count=0;
//			for(int i=0;i<list.size();i++)
//			{
//				Map<String,String> map=new HashMap<>();
//				map.put("success", "true");
//				map.put("firstname",list.get(i).getFirstName());
//				map.put("email", list.get(i).getEmail());
//				map.put("serialno", list.get(i).getSerialNo()+"");
//				map.put("userid", list.get(i).getUserId());
//				responseData.put(count, map);
//				count++;
//			}
			
			
			
			Gson gson = new Gson();
			String json = gson.toJson(list);
			System.out.println(json);
			out.print(json);
		

		} else {
		//	responseData.put("success", "false");
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
			System.out.println("user not present");
		}

	}

}