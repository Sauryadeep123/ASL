package com.asl.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.asl.connector.TestClass;
import com.asl.db.entity.EmployeeDetails;
import com.asl.db.operations.InsertQuery;
import com.asl.db.operations.SelectQuery;
import com.asl.resources.Constant;
import com.asl.utility.FileHandling;
import com.google.gson.Gson;

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
		System.out.print("aya re");
		EmployeeDetails emp=new EmployeeDetails();
		
		emp.setFirstName(req.getParameter("firstName"));
		emp.setMiddleName(req.getParameter("middleName"));
		emp.setLastName(req.getParameter("lastName"));
		emp.setEmail(req.getParameter("email"));
		emp.setPassword(req.getParameter("password"));
		emp.setCity(req.getParameter("city"));
		emp.setDob(req.getParameter("dob"));
		emp.setPassword("default");
		PrintWriter out = res.getWriter();
		
//		Part part = req.getPart("photo");
//		System.out.println(part.getContentType().substring(part.getContentType().indexOf('/')+1));
//		System.out.println(req.getPart("resume").getContentType());
		
		SelectQuery sq=new SelectQuery();
		if(sq.alreadyUser(emp.getEmail())) {
//			RequestDispatcher rd=req.getRequestDispatcher("AlreadyUser.html");
//        	rd.include(req, res);
//        	RequestDispatcher rd2=req.getRequestDispatcher("index.html");
//        	rd2.include(req, res);
			System.out.print("already present");
        	
			Map<String,String> map=new HashMap<>();
			map.put("success", "alreadyuser");
			Gson gson = new Gson();
			String json = gson.toJson(map);
			out.print(json);
			
			
		}
		else {
//			Part partPhoto = req.getPart("photo");
//			Part partResume = req.getPart("resume");
//			Properties p=new Properties();
//			TestClass ob= new TestClass();
//			p.load(ob.getFileFromResourceAsStream(Constant.propFilePath));
//			String path=(String)p.getProperty("projectPath");
//			try {
//				FileHandling fh=new FileHandling();
//				emp.setPhoto(fh.saveFile(path + "photo", partPhoto,emp.getEmail()));
//				emp.setResume(fh.saveFile(path + "resume", partResume,emp.getEmail()));
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			System.out.print("helooooooooooi "+ req.getParameter("email"));
			
			
			InsertQuery iq=new InsertQuery();
			int a=iq.insertIntoEmployees(emp);
			
			String id=sq.getId(emp.getEmail());
			
			if(parseFilePart("photo",req, emp,id)) {
				if(parseFilePart("resume",req,emp, id)) {
					int b=iq.insertIntoEmployeeDetails(emp,sq.getId(emp.getEmail()));
					HttpSession session=req.getSession();
					if(a==0 || b==0)
					{
				          
				        session.setAttribute("success","false");
					}
					else session.setAttribute("success","true");
					session.setAttribute("email", "ram@gmail.com");
					session.setAttribute("password", "ram");
					RequestDispatcher rd=req.getRequestDispatcher("Login");
					rd.forward(req, res);
				}
				else {
					//TODO
					//ERROR HANDLING
				}
			}
			else {
				//TODO
				//ERROR HANDLING
			}
			
			
			
		}
		
		
				
	}
	
	private boolean parseFilePart(String reqParam,HttpServletRequest req,EmployeeDetails emp,String id) throws IOException, ServletException {
		System.out.print("heloooooooooo "+ req.getParameter("email"));
		Part part = req.getPart(reqParam);
		boolean result=false;
		
		Properties p=new Properties();
		TestClass ob= new TestClass();
		p.load(ob.getFileFromResourceAsStream(Constant.propFilePath));
		String path=(String)p.getProperty("projectPath");
		try {
			FileHandling fh=new FileHandling();
			String fileName=fh.saveFile(path + reqParam, part,id);
			if(fileName!= null) {
				result=true;
			
			if(reqParam=="photo")
			emp.setPhoto(fileName);
			if(reqParam=="resume")
				emp.setResume(fileName);
			}
			
			
			//emp.setResume(fh.saveFile(path + "resume", partResume,emp.getEmail()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}