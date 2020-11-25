package com.cg.service;
import java.util.*;
import com.cg.model.*;
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
		
		@Override
		public int accountCreation(Accounts account, String userName) throws InsuranceException {
			// TODO Auto-generated method stub
			return adminDao.accountCreation(account,userName);
		}

		@Override
		public String getLineOfBusinessIdByName(String busSegName) throws InsuranceException {
			// TODO Auto-generated method stub
			return adminDao.getLineOfBusinessIdByName(busSegName);
		}

		@Override
		public boolean isUserExists(String userName) throws InsuranceException {
			// TODO Auto-generated method stub
			return adminDao.isUserExists(userName);
		}

		@Override
		public String getBusSegId(int accNumber) throws InsuranceException {
			// TODO Auto-generated method stub
			return adminDao.getBusSegId(accNumber);
		}

		@Override
		public List<PolicyQuestions> getPolicyQuestions(String busSegId) throws InsuranceException {
			// TODO Auto-generated method stub
			return adminDao.getPolicyQuestions(busSegId);
		}

		@Override
		public int getPolicyPremiumAmount(int sumOfWeightages) throws InsuranceException {
			// TODO Auto-generated method stub
			return adminDao.getPolicyPremiumAmount(sumOfWeightages);
		}

		@Override
		public int createPolicy(Policy policy) throws InsuranceException {
			// TODO Auto-generated method stub
			return adminDao.createPolicy(policy);
		}

		@Override
		public int getPolicyNumber() throws InsuranceException {
			// TODO Auto-generated method stub
			return adminDao.getPolicyNumber();
		}

		@Override
		public void addPolicyDetails(int polNumber, List<String> questionIds, List<String> selectedAnswers)
				throws InsuranceException {
			// TODO Auto-generated method stub
			adminDao.addPolicyDetails(polNumber, questionIds, selectedAnswers);
		}

		@Override
		public List<Policy> getPolicies() throws InsuranceException {
			// TODO Auto-generated method stub
			return adminDao.getPolicies();
		}

		@Override
		public Accounts getAccountDetails(int accNumber) throws InsuranceException {
			// TODO Auto-generated method stub
			return adminDao.getAccountDetails(accNumber);
		}

		@Override
		public String getBusSegName(String lineOfBusiness) throws InsuranceException {
			// TODO Auto-generated method stub
			return adminDao.getBusSegName(lineOfBusiness);
		}

		@Override
		public Double getPolicyPremium(int polNum) throws InsuranceException {
			// TODO Auto-generated method stub
			return adminDao.getPolicyPremium(polNum);
		}

		@Override
		public List<String> getSelectedAnswers(int polNum) throws InsuranceException {
			// TODO Auto-generated method stub
			return adminDao.getSelectedAnswers(polNum);
		}
		@Override
		public boolean loginValidation(String username, String password) throws InsuranceException {
			// TODO Auto-generated method stub
			return adminDao.loginValidation(username, password);
		}

		@Override
		public String getRoleCode(String username, String password) throws InsuranceException {
			// TODO Auto-generated method stub
			return adminDao.getRoleCode(username, password);
		}

		@Override
		public int addUser(UserRole userRole) throws InsuranceException {
			// TODO Auto-generated method stub
			return adminDao.addUser(userRole);
		}
	}

	
	
	

