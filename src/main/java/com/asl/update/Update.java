package com.asl.update;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asl.db.entity.EmployeeDetails;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		EmployeeDetails emp = new EmployeeDetails();

		emp.setFirstName(req.getParameter("firstName"));
		emp.setMiddleName(req.getParameter("middleName"));
		emp.setLastName(req.getParameter("lastName"));
		//emp.setEmail(req.getParameter("email"));
		emp.setPassword(req.getParameter("password"));
		emp.setCity(req.getParameter("city"));
		emp.setDob(req.getParameter("dob"));
		emp.setPassword(req.getParameter("password"));
		
		
	}

}
