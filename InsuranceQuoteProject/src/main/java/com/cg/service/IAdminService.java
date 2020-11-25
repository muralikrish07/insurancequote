package com.cg.service;
import java.util.List;

import com.cg.exceptions.InsuranceException;
import com.cg.model.Accounts;
import com.cg.model.Policy;
import com.cg.model.PolicyQuestions;
import com.cg.model.UserRole;
public interface IAdminService {

	
	
	public void addPolicyDetails(int polNumber, List<String> questionIds, List<String> selectedAnswers) throws InsuranceException;

	public List<Policy> getPolicies() throws InsuranceException;

	public Accounts getAccountDetails(int accNumber) throws InsuranceException;

	public String getBusSegName(String lineOfBusiness) throws InsuranceException;

	public Double getPolicyPremium(int polNum) throws InsuranceException;

	public List<String> getSelectedAnswers(int polNum) throws InsuranceException;
public boolean loginValidation(String userName, String password) throws InsuranceException;
	
	public String getRoleCode(String userName, String password) throws InsuranceException;
	
	public int addUser(UserRole userRole) throws InsuranceException;

	public int accountCreation(Accounts account, String userName) throws InsuranceException;

	public String getLineOfBusinessIdByName(String busSegName) throws InsuranceException;

	public boolean isUserExists(String userName) throws InsuranceException;

	public String getBusSegId(int accNumber) throws InsuranceException;

	public List<PolicyQuestions> getPolicyQuestions(String busSegId) throws InsuranceException;

	public int getPolicyPremiumAmount(int sumOfWeightages) throws InsuranceException;

	public int createPolicy(Policy policy) throws InsuranceException;

	public int getPolicyNumber() throws InsuranceException;
}
