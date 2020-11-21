package com.cg.dao;
import java.sql.ResultSet;
import java.util.List;

import com.cg.exceptions.InsuranceException;
import com.cg.model.Accounts;
import com.cg.model.Policy;
import com.cg.model.PolicyQuestions;
public interface IAgentDAO {

	//public String getLineOfBusinessIdByName(String busSegName) throws QGSException;

	public boolean isUserExists(String userName) throws InsuranceException;

	public int accountCreation(Accounts account, String userName) throws InsuranceException;
	
	public boolean accountValidation(String userName) throws InsuranceException;

	public boolean isAccountExists(int accNumber) throws InsuranceException;

	//public String getBusSegId(int accNumber) throws QGSException;

	//public List<PolicyQuestions> getPolicyQuestions(String busSegId) throws QGSException;

	//public int getPolicyPremiumAmount(int sumOfWeightages) throws QGSException;

	//public int createPolicy(Policy policy) throws QGSException;

	//public int getPolicyNumber() throws QGSException;

	//public void addPolicyDetails(int polNumber, List<String> questionIds, List<String> selectedAnswers) throws QGSException;


	public Accounts getAccountDetails(int accNumber) throws InsuranceException;

	//public String getBusSegName(String lineOfBusiness) throws QGSException;

	//public Double getPolicyPremium(int polNum) throws QGSException;

	//public List<String> getSelectedAnswers(int polNum) throws QGSException;

	//public void addPolicyCreator(int polNumber, String username) throws QGSException;
	
	//public List<Policy> getPolicies(String username) throws QGSException;
	
}
