package com.asl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	          
				PrintWriter out = res.getWriter();
				
				String email1=req.getParameter("email");
				System.out.println(email1);
		        Connection conn=null;
		        int flag=0;
		        try {
		        	conn=Connector.getConnection();
		        	System.out.println("Successs!!");
		        	 String sql = "select * from employees_details";
			            p = conn.prepareStatement(sql);
			            rs = p.executeQuery();
			           
			 
			           
			            while (rs.next()) {
			 
			                String firstname1=rs.getString("FirstName");
			                String middlename1=rs.getString("MiddleName");
			                String lastname1=rs.getString("LastName");
			                String email2 = rs.getString("email");
			                String city1 = rs.getString("city");
			                String dob1 = rs.getString("dob");
			                String userid1=rs.getString("userid");
			                
			               
			                if(email1.equals(email2))
			                {
			                	/*HttpSession ses=req.getSession();
			                	ses.setAttribute("firstname", firstname1);
			                	ses.setAttribute("lastname", lastname1);
			                	ses.setAttribute("email", email2);
			                	ses.setAttribute("city", city1);
			                	ses.setAttribute("dob", dob1);
			                	
			                	res.sendRedirect("Profile");*/
			                	
			                	flag=1;
			                	
			                	 out.println("<html>");
			                     out.println("<head><title>User Details</title></head>");
			                     out.println("<body style='background-color: powderblue;'>");
			                     out.println("<tr>");
			                     out.print("<td><h1>FirstName:</td>");
			                     out.print("<td>"+firstname1+"</h1></td>");
			                     out.println("</tr>");
			                    
			                     if(middlename1!=null) {
			                     out.println("<tr>");
			                     out.print("<td><h1>MiddleName:</td>");
			                     out.print("<td>"+middlename1+"</h1></td>");
			                     out.println("</tr>");
			                     }
			                     
			                     out.println("<tr>");
			                     out.print("<td><h1>LastName:</td>");
			                     out.print("<td>"+lastname1+"</h1></td>");
			                     out.println("</tr>");
			                     
			                     
			                     
			                     
			                     
			                     out.println("<tr>");
			                     out.println("<td><h1>email:</td>");
			                     out.println("<td>"+email2+"</h1></td>");
			                     out.println("</tr>");
			                     
			                     out.println("<tr>");
			                     out.println("<td><h1>city:</td>");
			                     out.println("<td>"+city1+"</h1></td>");
			                     out.println("</tr>");
			                     
			                     
			                     out.println("<tr>");
			                     out.println("<td><h1>DOB:</td>");
			                     out.println("<td>"+dob1+"</h1></td>");
			                     out.println("</tr>");
			                     
			                     
			                     out.println("<tr>");
			                     out.println("<td><h1>UserId:</td>");
			                     out.println("<td>"+userid1+"</h1></td>");
			                     out.println("</tr>");
			                     out.println("</body></html>");
			                     
			                     
			                     
			                     
			                     
			                     
			                     
			       

			                }
			            }
		        	
		        	 
		        	
		        }catch(Exception e)
		        {
		        	e.printStackTrace();
		        }
		        
		        if(flag==0) {
		        	RequestDispatcher rd=req.getRequestDispatcher("notpresent.html");
		        	rd.include(req, res);
		        	RequestDispatcher rd2=req.getRequestDispatcher("Login.html");
		        	rd2.include(req, res);
		        	
		        	
		        }
		        	
		}


}
