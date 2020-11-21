package com.cg.service;
import java.util.List;

import com.cg.exceptions.InsuranceException;
import com.cg.model.Accounts;
import com.cg.model.Policy;
import com.cg.model.PolicyQuestions;
import com.cg.model.UserRole;
public interface IAdminService {

	
	
public boolean loginValidation(String userName, String password) throws InsuranceException;
	
	
	
	public int addUser(UserRole userRole) throws InsuranceException;

	public int accountCreation(Accounts account, String userName) throws InsuranceException;

	
	public boolean isUserExists(String userName) throws InsuranceException;

	
}
