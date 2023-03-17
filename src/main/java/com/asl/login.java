package com.asl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 res.setContentType("text/html");
//		PrintWriter out = res.getWriter();
//		String email1=req.getParameter("email");
//		out.print(email1);
        Connection con=null;
        try {
        	con=Connector.getConnection();
        	 
        	
        }catch(Exception e)
        {
        	e.printStackTrace();
        }
        System.out.println("success");
      
        
		 
	}

}
