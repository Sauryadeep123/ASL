package com.asl.loginregistration;


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

import com.asl.connector.Connector;
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

		String email1 = req.getParameter("email");
		System.out.println(email1);
		String password1 = req.getParameter("password");
		Map<String, String> responseData = new HashMap<String, String>();
		if (SelectQuery.isValidUser(email1, password1)) {
			
			EmployeeDetails e1 = SelectQuery.showEmployee(email1);
			
			responseData.put("success", "true");
			responseData.put("firstname", e1.getFirstName());
			responseData.put("email", e1.getEmail());
			responseData.put("serialno", (e1.getSerialNo()+1)+"");
			responseData.put("userid", e1.getUserid());
			
			Gson gson = new Gson();
			String json = gson.toJson(responseData);
			System.out.println(json);
			out.print(json);
		

		} else {
			responseData.put("success", "false");
			Gson gson = new Gson();
			String json = gson.toJson(responseData);
			out.print(json);
			System.out.println("user not present");
		}

	}

}