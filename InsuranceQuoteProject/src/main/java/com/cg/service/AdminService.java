package com.cg.service;


//import java.util.List;
import com.cg.dao.AdminDAO;
import com.cg.dao.IAdminDAO;
import com.cg.exceptions.InsuranceException;
import com.cg.model.Accounts;
//import com.cg.model.Policy;
//import com.cg.model.PolicyQuestions;
import com.cg.model.UserRole;

	public class AdminService implements IAdminService {

		IAdminDAO adminDao = new AdminDAO();
		
		public boolean loginValidation(String username, String password) throws InsuranceException {
			// TODO Auto-generated method stub
			return adminDao.loginValidation(username, password);
		}

	
		
		public int addUser(UserRole userRole) throws InsuranceException {
			// TODO Auto-generated method stub
			return adminDao.addUser(userRole);
		}
		
		
		public int accountCreation(Accounts account, String userName) throws InsuranceException {
			// TODO Auto-generated method stub
			return adminDao.accountCreation(account,userName);
		}

	

		
		public boolean isUserExists(String userName) throws InsuranceException {
			// TODO Auto-generated method stub
			return adminDao.isUserExists(userName);
		}

		
		
		
		
		

		
		public Accounts getAccountDetails(int accNumber) throws InsuranceException {
			// TODO Auto-generated method stub
			return adminDao.getAccountDetails(accNumber);
		}



	}

	
	
	

