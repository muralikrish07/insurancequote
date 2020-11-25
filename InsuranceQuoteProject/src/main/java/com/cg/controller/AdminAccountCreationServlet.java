package com.cg.controller;
import com.cg.utility.*;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.dao.AdminDAO;
import com.cg.exceptions.InsuranceException;
import com.cg.model.Accounts;
import com.cg.service.AdminService;
import com.cg.service.IAdminService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.logging.Logger.*;
@WebServlet("/AccountCreationServlet")
public class AdminAccountCreationServlet extends HttpServlet{
	Logger logger=LogManager.getLogger();
	//static Logger log = Logger.getLogger("Admin");
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IAdminService service = new AdminService();
		
		int isCreated = 0;
		
		PrintWriter out = response.getWriter();
		RequestDispatcher dispatcher = null;
		boolean isUserExists = false;
		String userName = request.getParameter("userName");
		String insuredName = request.getParameter("insuredName");
		String insuredStreet = request.getParameter("insuredStreet");
		System.out.println(insuredStreet);
		String insuredCity = request.getParameter("insuredCity");
		String insuredState = request.getParameter("insuredState");
		int insuredZip = Integer.parseInt(request.getParameter("insuredZip"));
		String busSegName = request.getParameter("busSegName");
		System.out.println("hello");
		//int accNumber = Integer.parseInt(request.getParameter("accnumber"));
		
		System.out.println("line 38");
		try {
						
			String bussinessSegmentId = service.getLineOfBusinessIdByName(busSegName);
			Accounts account = new Accounts(insuredName, insuredStreet, insuredCity, insuredState, insuredZip, bussinessSegmentId);
			
			isUserExists = service.isUserExists(userName);
			if (isUserExists) {

				isCreated = service.accountCreation(account, userName);
				if (isCreated == 1) {
					logger.info("Account Created Successfully!!");
					/*dispatcher = request.getRequestDispatcher("adminhome.html");
					dispatcher.include(request, response);
			*/	}
			} else {
				logger.info("User does not exists! First register as user");
			/*	dispatcher = request.getRequestDispatcher("adminhome.html");
				dispatcher.include(request, response);
			*/}
		} catch (InsuranceException e) {
			logger.error(e.getMessage());
		}

	}
}
