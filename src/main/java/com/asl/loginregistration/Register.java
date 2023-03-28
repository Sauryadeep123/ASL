package com.asl.loginregistration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.asl.connector.Connector;
import com.asl.dbentity.EmployeeDetails;
import com.asl.dboperations.InsertQuery;
import com.asl.dboperations.SelectQuery;
import com.asl.filehandling.FileHandling;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
@MultipartConfig
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		EmployeeDetails emp=new EmployeeDetails();
		
		emp.setFirstName(req.getParameter("firstName"));
		emp.setMiddleName(req.getParameter("middleName"));
		emp.setLastName(req.getParameter("lastName"));
		emp.setEmail(req.getParameter("email"));
		emp.setPassword(req.getParameter("password"));
		emp.setCity(req.getParameter("city"));
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date=null;
		try {
			date = sdf1.parse(req.getParameter("dob"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
		emp.setDob(sqlStartDate);
		emp.setPassword(req.getParameter("password"));
		
		if(new SelectQuery().alreadyUser(emp.getEmail())) {
			
		}
		else {
			Part partPhoto = req.getPart("photo");
			Part partResume = req.getPart("resume");
			String path = "/home/chirag/eclipse-workspace/ASL/";
			try {
				emp.setPhoto(new FileHandling().saveFile(path + "photos", partPhoto,emp.getEmail()));
				emp.setResume(new FileHandling().saveFile(path + "resume", partResume,emp.getEmail()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			new InsertQuery().insertIntoEmployees(emp);
			new InsertQuery().insertIntoEmployeeDetails(emp,new SelectQuery().getId(emp.getEmail()));
			
		}
		
		PrintWriter out = res.getWriter();
		
					RequestDispatcher rd=req.getRequestDispatcher("RegistrationSuccess.html");
		        	rd.include(req, res);
		        	RequestDispatcher rd2=req.getRequestDispatcher("Login.html");
		        	rd2.include(req, res);
				
	}

}