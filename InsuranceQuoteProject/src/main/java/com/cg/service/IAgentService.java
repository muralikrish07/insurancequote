package com.cg.service;

import java.sql.ResultSet;
import java.util.List;

import com.cg.exceptions.InsuranceException;
import com.cg.model.Accounts;
import com.cg.model.Policy;
import com.cg.model.PolicyQuestions;

public interface IAgentService {

	

	public boolean isUserExists(String userName) throws InsuranceException;

	public int accountCreation(Accounts account, String userName) throws InsuranceException;

	public boolean accountValidation(String userName) throws InsuranceException;

	public boolean isAccountExists(int accNumber) throws InsuranceException;

	

	public Accounts getAccountDetails(int accNumber) throws InsuranceException;

}
