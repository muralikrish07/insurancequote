package com.cg.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.cg.dao.AdminDAO;
import com.cg.dao.IAdminDAO;
import com.cg.exceptions.InsuranceException;
import com.cg.model.Policy;
import com.cg.service.IInsuredService;
import com.cg.service.InsuredService;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import java.util.logging.Logger.*;
@WebServlet("/InsuredViewPolicy")
public class InsuredViewPolicy extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IInsuredService service = new InsuredService();
		PrintWriter out = response.getWriter();
		Logger logger=LogManager.getLogger();
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();
		try {
			String username = (String)session.getAttribute("username");
			System.out.println(username);
			int accNo = service.getAccountNumber(username);
			List<Policy> policies = service.getInsuredPolicies(accNo);
			
			/*if(policies.size() == 0) {
				out.println("Policies does not exists.. ");
				dispatcher = request.getRequestDispatcher("insuredhome.html");
				dispatcher.include(request, response);
			}
			*/
			System.out.println("policies size : "+policies.size());
			if(policies.size() > 0) {
				request.setAttribute("policies", policies);
			
				dispatcher = request.getRequestDispatcher("InsuredViewPolicies.jsp");
				dispatcher.include(request, response);
		
			}
			
			else {
				logger.info("Policies does not exists.. ");
				/*dispatcher = request.getRequestDispatcher("insurerhome.html");
				dispatcher.include(request, response);*/
							
			}
		}catch (InsuranceException e) {
			logger.error(e.getMessage());// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}

