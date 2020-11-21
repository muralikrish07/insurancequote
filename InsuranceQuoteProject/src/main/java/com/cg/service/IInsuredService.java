package com.cg.service;

import java.util.List;

import com.cg.exceptions.InsuranceException;
import com.cg.model.Accounts;
import com.cg.model.Policy;
import com.cg.model.PolicyQuestions;

public interface IInsuredService {

	
	boolean isUserExists(String userName) throws InsuranceException;

	int accountCreation(Accounts account, String userName) throws InsuranceException;

	public boolean accountValidation(String username) throws InsuranceException;

	public int getAccountNumber(String username) throws InsuranceException;

	

	public Accounts getAccountDetails(int accNo) throws InsuranceException;

	
	
	

}
