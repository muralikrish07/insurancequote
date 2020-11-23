package com.cg.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.exceptions.InsuranceException;
import com.cg.service.AdminService;
import com.cg.service.IAdminService;
import com.cg.service.IInsuredService;
import com.cg.service.InsuredService;


@WebServlet("/LoginServlet")

//This Servlet is used to validate the user and redirect them to the respective homepage  
 public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IAdminService adminService = new AdminService();
		HttpSession session = request.getSession();
		boolean isFound = false;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		session.setAttribute("username", username);
		//System.out.println(username);
		try {
			
			
			isFound = adminService.loginValidation(username,password);
			
			if(isFound == true) {
				System.out.println("user exist");
				
			}else {
				System.out.println("Account not exist create your account");
				RequestDispatcher rd=request.getRequestDispatcher("UserCreation.jsp");
				rd.forward(request, response);
				
			}
						
		}catch (InsuranceException e) {
		
			//throw new LoginException("Error occured while validating"+e.getMessage());
			System.out.println(e.getMessage());
		
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}