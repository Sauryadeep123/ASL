package com.asl.registration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class OpenRegister
 */
@WebServlet("/openRegister")
public class OpenRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print("in open register");
		HttpSession session=req.getSession();
		PrintWriter out=res.getWriter();
		if(session.getAttribute("user")=="admin") {
			out.print("success");
			System.out.println("success");
		}
		else out.print("fail");
	}

}
