package com.cg.dao;
import java.util.List;
import com.cg.exceptions.InsuranceException;
import com.cg.model.Accounts;
import com.cg.model.Policy;
import com.cg.model.PolicyQuestions;
import com.cg.model.UserRole;
		
public interface IAdminDAO {

		public int accountCreation(Accounts account, String userName) throws InsuranceException;

		public String getBusSegId(int accNumber) throws InsuranceException;
		
		public List<PolicyQuestions> getPolicyQuestions(String busSegId) throws InsuranceException;
		
		public Integer createPolicy(Policy policy) throws InsuranceException;
		
		public void addPolicyDetails(int polNumber, List<String> questionIds, List<String> selectedAnswers) throws InsuranceException;
		
		public List<Policy> getPolicies() throws InsuranceException;
		
		public Accounts getAccountDetails(Integer accNumber) throws InsuranceException;
		
		public String getBusSegName(String busSegId) throws InsuranceException;

		public Double getPolicyPremium(Integer polNum) throws InsuranceException;

		public List<String> getSelectedAnswers(int polNum) throws InsuranceException;

		public Integer getPolicyPremiumAmount(Integer sumOfWeightages) throws InsuranceException;
		
public boolean loginValidation(String userName, String password) throws InsuranceException;
		
		public String getRoleCode(String userName, String password) throws InsuranceException;
		
		public int addUser(UserRole userRole) throws InsuranceException;
		
		public String getLineOfBusinessIdByName(String lineOfBusinessName) throws InsuranceException;

		public boolean isUserExists(String userName) throws InsuranceException;
		public Integer getPolicyNumber() throws InsuranceException;
	}



