package com.asl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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
		String firstName = req.getParameter("firstName");
		String middleName = req.getParameter("middleName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String city = req.getParameter("city");
		String dob = (String)req.getParameter("dob");
		Part part = req.getPart("photo");
		Part partResume=req.getPart("resume");
		PrintWriter out = res.getWriter();

		
		

		try {
			Connection con = Connector.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO EmployeesDetails (FirstName,MiddleName,LastName,email,city,dob,userid,photo,resume)"
							+ " values (?,?,?,?,?,?,?,?,?);");
			ps.setString(1,firstName);
			ps.setString(2,middleName);
			ps.setString(3,lastName);
			ps.setString(4,email);
			ps.setString(5,city);
			ps.setString(6,dob);
			ps.setString(7,"not set yet");
			ps.setString(8,email);
			ps.setString(9,email);
			
//			int i=ps.executeUpdate();
//			
//			if(i==1)
			{
//				
				String path= "/home/chirag/eclipse-workspace/ASL/";
				
				saveFile(path+"photos",part);
				saveFile(path+"resume",partResume);
				
				out.print("upload success");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private String getFileName(final Part part) {
	    final String partHeader = part.getHeader("content-disposition");
	    for (String content : partHeader.split(";")) {
	      if (content.trim().startsWith("filename")) {
	        return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
	      }
	    }
	    return null;
	  }
	
	private String saveFile(String uploadPath,Part part) throws Exception
	{
		File uploadDir = new File(uploadPath);
	    if (!uploadDir.exists()) {
	      uploadDir.mkdir();
	    }

	      String fileName = getFileName(part);
	      OutputStream out1 = new FileOutputStream(new File(uploadPath + File.separator + fileName));
	      InputStream fileContent = part.getInputStream();
	      int read = 0;
	      final byte[] bytes = new byte[1024];
	      while ((read = fileContent.read(bytes)) != -1) {
	        out1.write(bytes, 0, read);
	      }
	      out1.flush();
	      out1.close();
	      fileContent.close();
		
		return "";
	}

}