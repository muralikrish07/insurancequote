package com.cg.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.cg.exceptions.InsuranceException;
import com.cg.model.Accounts;
import com.cg.model.Policy;
import com.cg.model.PolicyDetails;
import com.cg.model.PolicyQuestions;
import com.cg.model.UserRole;
import java.util.*;
import com.cg.utility.JdbcConnect;


public class AdminDAO implements IAdminDAO{

	
	static Connection connection = null;
	static PreparedStatement prepareStatement = null;
	static ResultSet resultSet = null;

	
	

	public Integer createPolicy(Policy policy) throws InsuranceException {
		// TODO Auto-generated method stub
		
		int isInserted = 0;
		try
		{
			connection = JdbcConnect.getConnection();
			prepareStatement = connection.prepareStatement(AdminQueryValues.CREATE_POLICY);
			prepareStatement.setDouble(1, policy.getPolicyPremium());
			prepareStatement.setInt(2, policy.getAccNumber());
			//prepareStatement.setString(3, userRole.getRoleCode());
			
			isInserted = prepareStatement.executeUpdate();
			System.out.println(policy);
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		finally {
			try
			{
				prepareStatement.close();
				connection.close();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return isInserted;
	}

		
		
		
	




	public Integer getPolicyNumber() throws InsuranceException {
		// TODO Auto-generated method stub
		int polNumber = 0;
		boolean found = false;
		try
		{
			connection = JdbcConnect.getConnection();
			prepareStatement = connection.prepareStatement(AdminQueryValues.GET_POLICY_NUMBER);	
			resultSet = prepareStatement.executeQuery();
			found = resultSet.next();
			System.out.println(found);
			if(found == true) {
				polNumber = resultSet.getInt(1);
				//System.out.println(name + " " + pwd);
			}
			System.out.println(polNumber);
					
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		finally {
			try
			{
				prepareStatement.close();
				connection.close();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return polNumber;
	}




	public void addPolicyDetails(int polNumber, com.sun.xml.internal.bind.v2.schemagen.xmlschema.List questionIds,
			com.sun.xml.internal.bind.v2.schemagen.xmlschema.List selectedAnswers) throws InsuranceException {
		// TODO Auto-generated method stub
		
	}




	public List<String> getPolicies() throws InsuranceException {
		// TODO Auto-generated method stub
		return null;
	}




	public Accounts getAccountDetails(Integer accNumber) throws InsuranceException {
		// TODO Auto-generated method stub
		return null;
	}




	public String getBusSegName(String busSegId) throws InsuranceException {
		// TODO Auto-generated method stub
		return null;
	}




	public Double getPolicyPremium(Integer polNum) throws InsuranceException {
		// TODO Auto-generated method stub
		return null;
	}




	public List<String> getSelectedAnswers(int polNum)throws InsuranceException {
		// TODO Auto-generated method stub
		return null;
	}




	public Integer getPolicyPremiumAmount(Integer sumOfWeightages) throws InsuranceException {
		// TODO Auto-generated method stub
		return null;
	}
	

	public boolean loginValidation(String username, String password) throws InsuranceException {
		return false;
	
	}




	public String getRoleCode(String userName, String password) throws InsuranceException {
		// TODO Auto-generated method stub
		return null;
	}




	public int addUser(UserRole userRole) throws InsuranceException {
		// TODO Auto-generated method stub
		return 0;
	}




	public String getLineOfBusinessIdByName(String lineOfBusinessName) throws InsuranceException {
		// TODO Auto-generated method stub
		return null;
	}




	public boolean isUserExists(String userName) throws InsuranceException {
		// TODO Auto-generated method stub
		return false;
	}




	public int accountCreation(Accounts account, String userName) throws InsuranceException {
		// TODO Auto-generated method stub
		return 0;
	}




	public String getBusSegId(int accNumber) throws InsuranceException {
		// TODO Auto-generated method stub
		return null;
	}




	public List<String> getPolicyQuestions(String busSegId)
			throws InsuranceException {
		// TODO Auto-generated method stub
		return null;
	}
}
	