package com.cg.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cg.exceptions.InsuranceException;
import com.cg.model.Accounts;
import com.cg.service.AgentService;
import com.cg.service.IAgentService;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import java.util.logging.Logger.*;

@WebServlet("/AgentAccountCreationServlet")
public class AgentAccountCreationServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger logger=LogManager.getLogger();
        IAgentService service = new AgentService();
        
        int isCreated = 0;
        boolean isAccountExists = false;
		
		PrintWriter out = response.getWriter();
		RequestDispatcher dispatcher = null;
		boolean isUserExists = false;
		String userName = request.getParameter("userName");
		String insuredName = request.getParameter("insuredName");
		String insuredStreet = request.getParameter("insuredStreet");
		//System.out.println(insuredStreet);
		String insuredCity = request.getParameter("insuredCity");
		String insuredState = request.getParameter("insuredState");
		int insuredZip = Integer.parseInt(request.getParameter("insuredZip"));
		String busSegName = request.getParameter("busSegName");
		//System.out.println("hello");
		//int accNumber = Integer.parseInt(request.getParameter("accnumber"));
		
		//System.out.println("line 38");
		try {
						
			String bussinessSegmentId = service.getLineOfBusinessIdByName(busSegName);
			Accounts account = new Accounts(insuredName, insuredStreet, insuredCity, insuredState, insuredZip, bussinessSegmentId);
			
			isUserExists = service.isUserExists(userName);
			if (isUserExists) {
                
				isAccountExists = service.accountValidation(userName);
				if(isAccountExists) {
					logger.info("Account already exists");
					dispatcher = request.getRequestDispatcher("agenthome.jsp");
					dispatcher.include(request, response);
				} else {
				    isCreated = service.accountCreation(account, userName);
				    if (isCreated == 1) {
					logger.info("Account Created Successfully!!");
					dispatcher = request.getRequestDispatcher("agenthome.jsp");
					dispatcher.include(request, response);
				   }
				}
			} else {
				logger.info("User does not exists! First register as user");
				dispatcher = request.getRequestDispatcher("agenthome.jsp");
				dispatcher.include(request, response);
			}
		} catch (InsuranceException e) {
			logger.error(e.getMessage());
		}

	}

}
