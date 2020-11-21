package com.cg.service;

import java.sql.ResultSet;
import java.util.List;
import com.cg.dao.AgentDAO;
import com.cg.dao.IAgentDAO;
import com.cg.exceptions.InsuranceException;
import com.cg.model.Accounts;
import com.cg.model.Policy;
import com.cg.model.PolicyQuestions;

public class AgentService implements IAgentService {

	IAgentDAO agentDao = new AgentDAO();
	
	
	public boolean isUserExists(String userName) throws InsuranceException {
		// TODO Auto-generated method stub
		return agentDao.isUserExists(userName);
	}

	
	public int accountCreation(Accounts account, String userName) throws InsuranceException {
		// TODO Auto-generated method stub
		return agentDao.accountCreation(account, userName);
	}

	
	public boolean accountValidation(String userName) throws InsuranceException {
		// TODO Auto-generated method stub
		return agentDao.accountValidation(userName);
	}

	
	public boolean isAccountExists(int accNumber) throws InsuranceException {
		// TODO Auto-generated method stub
		return agentDao.isAccountExists(accNumber);
	}


	
	public Accounts getAccountDetails(int accNumber) throws InsuranceException {
		
		return agentDao.getAccountDetails(accNumber);
	}


}
