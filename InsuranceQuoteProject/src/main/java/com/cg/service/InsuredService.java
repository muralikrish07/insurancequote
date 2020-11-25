package com.cg.service;
import com.cg.model.*;
import java.util.*;
//import java.util.List;

import com.cg.dao.IInsuredDAO;
import com.cg.dao.InsuredDAO;
import com.cg.exceptions.InsuranceException;
import com.cg.model.Accounts;
//import com.cg.model.Policy;
//import com.cg.model.PolicyQuestions;

public class InsuredService implements IInsuredService{

	IInsuredDAO insuredDao = new InsuredDAO();
	@Override
	public int getAccountNumber(String username) throws InsuranceException {
		// TODO Auto-generated method stub
		return insuredDao.getAccountNumber(username);
	}


	@Override
	public List<Policy> getInsuredPolicies(int accNo) throws InsuranceException {
		// TODO Auto-generated method stub
		return insuredDao.getInsuredPolicies(accNo);
	}


	@Override
	public Accounts getAccountDetails(int accNo) throws InsuranceException {
		// TODO Auto-generated method stub
		return insuredDao.getAccountDetails(accNo);
	}


	@Override
	public String getBusSegName(String lineOfBusiness) throws InsuranceException {
		// TODO Auto-generated method stub
		return insuredDao.getBusSegName(lineOfBusiness);
	}


	@Override
	public Double getPolicyPremium(int polNum) throws InsuranceException {
		// TODO Auto-generated method stub
		return insuredDao.getPolicyPremium(polNum);
	}


	@Override
	public List<PolicyQuestions> getPolicyQuestions(String lineOfBusiness) throws InsuranceException {
		// TODO Auto-generated method stub
		return insuredDao.getPolicyQuestions(lineOfBusiness);
	}


	@Override
	public List<String> getSelectedAnswers(int polNum) throws InsuranceException {
		// TODO Auto-generated method stub
		return insuredDao.getSelectedAnswers(polNum);
	}

	@Override
	public String getLineOfBusinessIdByName(String busSegName) throws InsuranceException {
		// TODO Auto-generated method stub
		return insuredDao.getLineOfBusinessIdByName(busSegName);
	}

	
	@Override
	public boolean isUserExists(String userName) throws InsuranceException {
		// TODO Auto-generated method stub
		return insuredDao.isUserExists(userName);
	}

	@Override
	public int accountCreation(Accounts account, String userName) throws InsuranceException {
		// TODO Auto-generated method stub
		return insuredDao.accountCreation(account, userName);
	}


	@Override
	public boolean accountValidation(String username) throws InsuranceException {
		// TODO Auto-generated method stub
		return insuredDao.accountValidation(username);
	}

	

	
	

}
