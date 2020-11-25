package com.cg.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.cg.exceptions.InsuranceException;
import com.cg.model.Policy;
import com.cg.service.AdminService;
import com.cg.service.AgentService;
import com.cg.service.IAdminService;
import com.cg.service.IAgentService;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import java.util.logging.Logger.*;

@WebServlet("/AgentViewPolicy")
public class AgentViewPolicy extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IAgentService service = new AgentService();
		Logger logger=LogManager.getLogger();
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();
		try {
			String username = (String)session.getAttribute("username");
			List<Policy> policies = service.getPolicies(username);
			System.out.println("Result set:"+policies);
			request.setAttribute("policies", policies);
			dispatcher = request.getRequestDispatcher("agentviewpolicy.jsp");
			dispatcher.include(request, response);
		} catch (InsuranceException e) {
			logger.error(e.getMessage());// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

}
