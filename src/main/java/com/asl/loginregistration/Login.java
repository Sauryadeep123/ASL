package com.asl.loginregistration;

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

import com.asl.connector.Connector;
import com.asl.dbentity.EmployeeDetails;
import com.asl.dboperations.SelectQuery;
import com.google.gson.Gson;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
			System.out.println("loginnnnnnnnnnnn!!!!!!!");
			
	          
				String email1=req.getParameter("email");
				String password1=req.getParameter("password");
				System.out.println(email1+" "+password1);
				if(SelectQuery.isValidUser(email1,password1))
				{
					System.out.println("user present");
					EmployeeDetails e1=SelectQuery.showEmployee(email1);
					System.out.println(e1.getFirstName() +" "+ e1.getCity());
					
		          
		        }else
		        {
		        	System.out.println("user not present");
		        }
		       
		        	
		}

}

/*
 * Map<String, String> responseData = new HashMap<String, String>();
 * responseData.put("success","false"); Gson gson = new Gson(); String json =
 * gson.toJson(responseData); System.out.println(json); out.print(json);
 */