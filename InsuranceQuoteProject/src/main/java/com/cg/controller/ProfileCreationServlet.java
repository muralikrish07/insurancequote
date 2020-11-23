package com.cg.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cg.dao.AdminDAO;
import com.cg.dao.IAdminDAO;
import com.cg.exceptions.InsuranceException;
import com.cg.model.UserRole;
import com.cg.service.AdminService;
import com.cg.service.IAdminService;

@WebServlet("/ProfileCreationServlet")
public class ProfileCreationServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int isInserted = 0;
		PrintWriter out = response.getWriter();
		RequestDispatcher dispatcher = null;
		
		IAdminService service = new AdminService();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rolecode = request.getParameter("rolecode");
		
		//System.out.println(username + " " + password + " " + rolecode);
		
		UserRole userRole = new UserRole(username, password, rolecode);
		try {

			isInserted = service.addUser(userRole);
			if (isInserted > 0) {
				out.println("User Role created successfully!!!!");
				/*dispatcher = request.getRequestDispatcher("adminhome.html");
				dispatcher.include(request, response);
		*/	} else {
				out.println("Username already exists!! Enter a different Username");
		/*		dispatcher = request.getRequestDispatcher("profilecreation.html");
				dispatcher.include(request, response);
		*/	}
		} catch (InsuranceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
