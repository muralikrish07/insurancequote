package com.cg.dao;
import java.util.List;

import com.cg.exceptions.InsuranceException;
import com.cg.model.Accounts;
import com.cg.model.Policy;
import com.cg.model.PolicyQuestions;
public interface IInsuredDAO {
public boolean accountValidation(String username) throws InsuranceException;
	
	//public String getLineOfBusinessIdByName(String lineOfBusinessName) throws QGSException;

	public boolean isUserExists(String userName) throws InsuranceException;
	
	public int accountCreation(Accounts account, String userName) throws InsuranceException;
	
//	public List<Policy> getInsuredPolicies(int accNo) throws QGSException;
	
	public int getAccountNumber(String username) throws InsuranceException;
	
	public Accounts getAccountDetails(Integer accNo) throws InsuranceException;
	
	//public String getBusSegName(String lineOfBusiness) throws QGSException;
	
//	public Double getPolicyPremium(Integer polNum) throws QGSException;
	
	//public List<PolicyQuestions> getPolicyQuestions(String lineOfBusiness) throws QGSException;
	
	//public List<String> getSelectedAnswers(Integer polNum) throws QGSException;
}
