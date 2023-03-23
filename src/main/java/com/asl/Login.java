package com.asl;

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
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
			System.out.println("loginnnnnnnnnnnn!!!!!!!");
			res.setContentType("text/html");
			  PreparedStatement p = null;
	          ResultSet rs = null;
	          
				String email1=req.getParameter("email");
				String password1=req.getParameter("password");
				System.out.println(email1+" "+password1);
		        Connection conn=null;
		        int flag=0;
		        try {
		        	conn=Connector.getConnection();
	        	System.out.println("Successs!!");
	        	 String sql = "select * from login_details";
		          p = conn.prepareStatement(sql);
		          rs = p.executeQuery();
		          res.setContentType("application/json");
                  PrintWriter out = res.getWriter();
                  Map<String, String> responseData = new HashMap<String, String>();
                  responseData.put("success","false");
		          while(rs.next())
		          {
		        	  String email2=rs.getString("email");
		        	  String password2=rs.getString("password");
		        	  if(email1.equals(email2) )
		        	  {
		        		  System.out.println("email  present");
		        		  
		                  responseData.put("value1", email1);
		                  responseData.put("value2", password1);
		                  responseData.put("success","true");
		                  
		        	  }
		          }
		          Gson gson = new Gson();
                  String json = gson.toJson(responseData);
                  System.out.println(json);
                  out.print(json);
		          
		          
		        }
		        catch(Exception e)
		        {
		        	e.printStackTrace();
		        }
		        	
		}


}
