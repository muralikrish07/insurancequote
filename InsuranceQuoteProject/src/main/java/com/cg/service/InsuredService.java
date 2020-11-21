package com.cg.service;

//import java.util.List;

import com.cg.dao.IInsuredDAO;
import com.cg.dao.InsuredDAO;
import com.cg.exceptions.InsuranceException;
import com.cg.model.Accounts;
//import com.cg.model.Policy;
//import com.cg.model.PolicyQuestions;

public class InsuredService implements IInsuredService{

	IInsuredDAO insuredDao = new InsuredDAO();
	
	

	public boolean isUserExists(String userName) throws InsuranceException {
		// TODO Auto-generated method stub
		return insuredDao.isUserExists(userName);
	}

	
	public int accountCreation(Accounts account, String userName) throws InsuranceException {
		// TODO Auto-generated method stub
		return insuredDao.accountCreation(account, userName);
	}



	public boolean accountValidation(String username) throws InsuranceException {
		// TODO Auto-generated method stub
		return insuredDao.accountValidation(username);
	}



	public int getAccountNumber(String username) throws InsuranceException {
		// TODO Auto-generated method stub
		return insuredDao.getAccountNumber(username);
	}




	
	public Accounts getAccountDetails(int accNo) throws InsuranceException {
		// TODO Auto-generated method stub
		return insuredDao.getAccountDetails(accNo);
	}


	

}
