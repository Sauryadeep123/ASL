package com.asl.login;


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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.asl.connector.Connector;
import com.asl.db.entity.Employee;
import com.asl.db.entity.EmployeeDetails;
import com.asl.db.operations.SelectQuery;
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
		ArrayList<EmployeeDetails> list= null;
		String email1 = req.getParameter("email");
		System.out.println(email1);
		//String password1 = req.getParameter("password");
		try {
		 HttpSession session=req.getSession(false);  
		 if(session!=null) {
	        email1=(String)session.getAttribute("email");
	       // password1=(String)session.getAttribute("password");
		 }
		}catch(Exception e) {
			e.printStackTrace();
		}
		SelectQuery obj=new SelectQuery();
		if (obj.isValidUser(email1)) {
			System.out.println("user present!!!!!!!");
			
			list=obj.showEmployee();

			Gson gson = new Gson();
			String json = gson.toJson(list);
			System.out.println(json);
			out.print(json);
			try {
				 HttpSession session=req.getSession(false);
			if(session.getAttribute("succes")=="false")
			{
			   Cookie ck=new Cookie("insert","false"); 
			   res.addCookie(ck);
			}else {
				Cookie ck=new Cookie("insert",email1); 
				res.addCookie(ck);
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
		

		} else {
		//	responseData.put("success", "false");
			Map<String,String> map=new HashMap<>();
			map.put("success", "false");
			Gson gson = new Gson();
			String json = gson.toJson(map);
			out.print(json);
			System.out.println("user not present");
		}

	}

}