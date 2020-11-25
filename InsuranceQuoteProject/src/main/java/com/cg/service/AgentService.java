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
	
	
	@Override
	public int accountCreation(Accounts account, String userName) throws InsuranceException {
		// TODO Auto-generated method stub
		return agentDao.accountCreation(account, userName);
	}

	@Override
	public boolean accountValidation(String userName) throws InsuranceException {
		// TODO Auto-generated method stub
		return agentDao.accountValidation(userName);
	}

	@Override
	public boolean isAccountExists(int accNumber) throws InsuranceException {
		// TODO Auto-generated method stub
		return agentDao.isAccountExists(accNumber);
	}

	@Override
	public String getBusSegId(int accNumber) throws InsuranceException {
		// TODO Auto-generated method stub
		return agentDao.getBusSegId(accNumber);
	}

	@Override
	public List<PolicyQuestions> getPolicyQuestions(String busSegId) throws InsuranceException {
		// TODO Auto-generated method stub
		return agentDao.getPolicyQuestions(busSegId);
	}

	@Override
	public int getPolicyPremiumAmount(int sumOfWeightages) throws InsuranceException {
		// TODO Auto-generated method stub
		return agentDao.getPolicyPremiumAmount(sumOfWeightages);
	}

	@Override
	public int createPolicy(Policy policy) throws InsuranceException {
		// TODO Auto-generated method stub
		return agentDao.createPolicy(policy);
	}

	@Override
	public int getPolicyNumber() throws InsuranceException {
		// TODO Auto-generated method stub
		return agentDao.getPolicyNumber();
	}

	@Override
	public void addPolicyDetails(int polNumber, List<String> questionIds, List<String> selectedAnswers) throws InsuranceException {
		// TODO Auto-generated method stub
		agentDao.addPolicyDetails(polNumber,questionIds,selectedAnswers);
	}

	@Override
	public List<Policy> getPolicies(String username) throws InsuranceException {
		// TODO Auto-generated method stub
		
		return agentDao.getPolicies(username);
	}

	@Override
	public Accounts getAccountDetails(int accNumber) throws InsuranceException {
		
		return agentDao.getAccountDetails(accNumber);
	}

	@Override
	public String getBusSegName(String lineOfBusiness) throws InsuranceException {
		// TODO Auto-generated method stub
		return agentDao.getBusSegName(lineOfBusiness);
	}

	@Override
	public Double getPolicyPremium(int polNum) throws InsuranceException {
		// TODO Auto-generated method stub
		return agentDao.getPolicyPremium(polNum);
	}

	@Override
	public List<String> getSelectedAnswers(int polNum) throws InsuranceException {
		// TODO Auto-generated method stub
		return agentDao.getSelectedAnswers(polNum);
	}

	@Override
	public void addPolicyCreator(int polNumber, String username) throws InsuranceException {
		// TODO Auto-generated method stub
	     agentDao.addPolicyCreator(polNumber,username);
	}

	
	@Override
	public String getLineOfBusinessIdByName(String busSegName) throws InsuranceException {
		// TODO Auto-generated method stub
		return agentDao.getLineOfBusinessIdByName(busSegName);
	}

	@Override
	public boolean isUserExists(String userName) throws InsuranceException {
		// TODO Auto-generated method stub
		return agentDao.isUserExists(userName);
	}

}
