package com.asl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String firstname1=req.getParameter("firstName");
		String middlename1=req.getParameter("middleName");
		String lastname1=req.getParameter("lastName");
		String email1=req.getParameter("email");
		String city1=req.getParameter("city");
		String dob1=req.getParameter("dob");
		PrintWriter out = res.getWriter();
		
		
		
	}

}
