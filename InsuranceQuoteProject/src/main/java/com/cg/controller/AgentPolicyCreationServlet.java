package com.cg.controller;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.cg.exceptions.InsuranceException;
import com.cg.model.PolicyQuestions;
import com.cg.service.AgentService;
import com.cg.service.IAgentService;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import java.util.logging.Logger.*;


@WebServlet("/AgentPolicyCreationServlet")
public class AgentPolicyCreationServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int accNumber = Integer.parseInt(request.getParameter("accNo"));
		ServletContext context = request.getServletContext();
		context.setAttribute("accNumber", accNumber);
		PrintWriter out = response.getWriter();
	    
		IAgentService service = new AgentService();
		Logger logger=LogManager.getLogger();
		List<PolicyQuestions> policyQuestions = new ArrayList<PolicyQuestions>();
		RequestDispatcher dispatcher = null;
		
		boolean isAccountExists = false;
		
		try {
			
			isAccountExists = service.isAccountExists(accNumber);
			if(isAccountExists) {
				String busSegId = service.getBusSegId(accNumber);
				System.out.println(busSegId);
				context.setAttribute("busSegId", busSegId);
				policyQuestions = service.getPolicyQuestions(busSegId);
				//out.println(policyQuestions);
				System.out.println(policyQuestions);
				dispatcher = request.getRequestDispatcher("agentpolicyquestions.jsp");
				System.out.println("Question : "+policyQuestions);
				request.setAttribute("questions", policyQuestions);
				dispatcher.forward(request, response);
			} else {
				logger.info("Account does not exists, so create an account");
				dispatcher = request.getRequestDispatcher("agenthome.jsp");
				dispatcher.include(request, response);

			}
		} catch (InsuranceException e) {
			logger.error(e.getMessage());// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
