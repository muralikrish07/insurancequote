package com.cg.service;

import java.util.List;

import com.cg.exceptions.InsuranceException;
import com.cg.model.Accounts;
import com.cg.model.Policy;
import com.cg.model.PolicyQuestions;

public interface IInsuredService {

	public List<Policy> getInsuredPolicies(int accNo) throws InsuranceException;

	public Accounts getAccountDetails(int accNo) throws InsuranceException;

	public String getBusSegName(String lineOfBusiness) throws InsuranceException;

	public Double getPolicyPremium(int polNum) throws InsuranceException;

	public List<PolicyQuestions> getPolicyQuestions(String lineOfBusiness) throws InsuranceException;

	public List<String> getSelectedAnswers(int polNum) throws InsuranceException;

	public String getLineOfBusinessIdByName(String busSegName) throws InsuranceException;

	boolean isUserExists(String userName) throws InsuranceException;

	int accountCreation(Accounts account, String userName) throws InsuranceException;

	public boolean accountValidation(String username) throws InsuranceException;

	public int getAccountNumber(String username) throws InsuranceException;

	

}
