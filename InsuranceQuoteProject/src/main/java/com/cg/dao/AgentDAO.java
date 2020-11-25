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
import com.cg.utility.JdbcConnect;


public class AgentDAO implements IAgentDAO {
		

		static Connection connection = null;
		static PreparedStatement prepareStatement = null;
		static ResultSet resultSet = null;

		
		@Override
		public boolean isAccountExists(int accNumber) throws InsuranceException {
			// TODO Auto-generated method stub
			boolean found = false;
			try {
				connection = JdbcConnect.getConnection();

				prepareStatement = connection.prepareStatement(AgentQueryValues.VALIDATE_ACCOUNT);
				prepareStatement.setInt(1, accNumber);
				
				resultSet = prepareStatement.executeQuery();
				found = resultSet.next();
			} catch (SQLException e) {
				throw new InsuranceException("problem while creating PS object");
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new InsuranceException("problem while closing");
				}

			}
	        return found;

		}

		@Override
		public String getBusSegId(int accNumber) throws InsuranceException {
			String busSegId = null;
			try {
				connection = JdbcConnect.getConnection();

				prepareStatement = connection.prepareStatement(AgentQueryValues.GET_BUS_SEG_ID);
				prepareStatement.setInt(1, accNumber);
				resultSet = prepareStatement.executeQuery();
				if(resultSet.next()) {
					busSegId = resultSet.getString(1);
					System.out.println("Getting business segment id :" + busSegId);
				}
			} catch (SQLException e) {
				throw new InsuranceException("problem while creating PS object"+e.getMessage());
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new InsuranceException("problem while closing");
				}

			}
	        return busSegId;
		
		
		
		}

		@Override
		public List<PolicyQuestions> getPolicyQuestions(String busSegId) throws InsuranceException {
			// TODO Auto-generated method stub
			
			List<PolicyQuestions> policyQuestions = new ArrayList<PolicyQuestions>();
			PolicyQuestions polQues = null;
			try {
				connection = JdbcConnect.getConnection();
				System.out.println(busSegId);
				prepareStatement = connection.prepareStatement(AgentQueryValues.GET_POLICY_QUESTIONS);
				prepareStatement.setString(1, busSegId);
				resultSet = prepareStatement.executeQuery();
				while(resultSet.next()) {
					polQues = new PolicyQuestions();
					polQues.setPolQuesId(resultSet.getString(1));
					polQues.setPolQuesSeq(resultSet.getInt(2));
					polQues.setBusSegId(resultSet.getString(3));
					polQues.setPolQuesDesc(resultSet.getString(4));
					polQues.setPolQuesAns1(resultSet.getString(5));
					polQues.setPolQuesAns1Weightage(resultSet.getInt(6));
					polQues.setPolQuesAns2(resultSet.getString(7));
					polQues.setPolQuesAns2Weightage(resultSet.getInt(8));
					polQues.setPolQuesAns3(resultSet.getString(9));
					polQues.setPolQuesAns3Weightage(resultSet.getInt(10));
					//System.out.println("Im in limelight : "+polQues);
					policyQuestions.add(polQues);
				}
			} catch (SQLException e) {
				throw new InsuranceException("problem while creating PS object"+e.getMessage());
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new InsuranceException("problem while closing");
				}

			}
			System.out.println(policyQuestions);
			return policyQuestions;
		}

		@Override
		public int getPolicyPremiumAmount(int sumOfWeightages) throws InsuranceException {
			// TODO Auto-generated method stub
			int preAmt = 0;
			boolean found = false;
			try {
				connection = JdbcConnect.getConnection();
				System.out.println(sumOfWeightages);
				prepareStatement = connection.prepareStatement(AgentQueryValues.GET_POLICY_PREMIUM_AMOUNT);
				prepareStatement.setDouble(1, sumOfWeightages);
				resultSet = prepareStatement.executeQuery();
				System.out.println(sumOfWeightages);
				found = resultSet.next();
				System.out.println(found);
				if(found == true) {
					preAmt = resultSet.getInt(1);
					//System.out.println(name + " " + pwd);
				}
				
				if(resultSet.next()) {
					System.out.println(sumOfWeightages);
					preAmt = resultSet.getInt(4);
				}
				System.out.println("Premium Amount :" + preAmt);
				
			} catch (SQLException e) {
				throw new InsuranceException("problem while creating PS object"+e.getMessage());
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new InsuranceException("problem while closing");
				}

			}

			return preAmt;

		}

		@Override
		public int createPolicy(Policy policy) throws InsuranceException {
			// TODO Auto-generated method stub
			int isInserted = 0;
			try
			{
				connection = JdbcConnect.getConnection();
				prepareStatement = connection.prepareStatement(AgentQueryValues.CREATE_POLICY);
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

		@Override
		public int getPolicyNumber() throws InsuranceException {
			// TODO Auto-generated method stub
			int polNumber = 0;
			boolean found = false;
			try
			{
				connection = JdbcConnect.getConnection();
				prepareStatement = connection.prepareStatement(AgentQueryValues.GET_POLICY_NUMBER);	
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

		@Override
		public void addPolicyDetails(int polNumber, List<String> questionIds, List<String> selectedAnswers)
				throws InsuranceException {
		
			// TODO Auto-generated method stub
			try
			{
				connection = JdbcConnect.getConnection();
				prepareStatement = connection.prepareStatement(AgentQueryValues.ADD_POLICY_DETAILS);	
				for(int i = 0; i < questionIds.size(); i++) {
					prepareStatement.setInt(1, polNumber);
					prepareStatement.setString(2, questionIds.get(i));
					prepareStatement.setString(3, selectedAnswers.get(i));
					prepareStatement.executeUpdate();
				}		
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

		}

		@Override
		public List<Policy> getPolicies(String username) throws InsuranceException {
			
			List<Policy> policies = new ArrayList<Policy>();
			Policy policy;
			try {
				connection = JdbcConnect.getConnection();
				prepareStatement = connection.prepareStatement(AgentQueryValues.VIEW_POLICY);
				//System.out.println("Hiiiiiii");
				prepareStatement.setString(1,username);
				resultSet = prepareStatement.executeQuery();
				//System.out.println("Result set in dao"+resultSet);
				while(resultSet.next()) {
					policy = new Policy();
					policy.setPolicyNumber(resultSet.getInt(1));
					policy.setPolicyPremium(resultSet.getDouble(2));
					policy.setAccNumber(resultSet.getInt(3));
					policies.add(policy);
				}
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
			return policies;
		}

		@Override
		public Accounts getAccountDetails(int accNumber) throws InsuranceException {
			// TODO Auto-generated method stub
			Accounts account = new Accounts();
			try {
				connection = JdbcConnect.getConnection();
				prepareStatement = connection.prepareStatement(AgentQueryValues.GET_ACCOUNT_DETAILS);	
				prepareStatement.setInt(1, accNumber);
				resultSet = prepareStatement.executeQuery();

				if(resultSet.next()) {
					account.setAccountNumber(resultSet.getInt(1));
					account.setInsuredName(resultSet.getString(2));
					account.setInsuredStreet(resultSet.getString(3));
					account.setInsuredCity(resultSet.getString(4));
					account.setInsuredState(resultSet.getString(5));
					account.setInsuredZip(resultSet.getInt(6));
					account.setLineOfBusiness(resultSet.getString(7));
					
				}
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
			
			return account;
		}

		@Override
		public String getBusSegName(String lineOfBusiness) throws InsuranceException {
			// TODO Auto-generated method stub
			String busSegName = null;
			try {
				connection = JdbcConnect.getConnection();

				prepareStatement = connection.prepareStatement(AgentQueryValues.GET_BUS_SEG_NAME);
				prepareStatement.setString(1, lineOfBusiness);
				resultSet = prepareStatement.executeQuery();
				if(resultSet.next()) {
					busSegName = resultSet.getString(1);
					System.out.println("Getting business segment id :" + busSegName);
				}
			} catch (SQLException e) {
				throw new InsuranceException("problem while creating PS object"+e.getMessage());
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new InsuranceException("problem while closing");
				}

			}
			//System.out.println(busSegName);
			return busSegName;

		}

		@Override
		public Double getPolicyPremium(int polNum) throws InsuranceException {
			// TODO Auto-generated method stub
			Double polPremium = 0.0;
			try {
				connection = JdbcConnect.getConnection();

				prepareStatement = connection.prepareStatement(AgentQueryValues.GET_POLICY_PREMIUM);
				prepareStatement.setInt(1, polNum);
				resultSet = prepareStatement.executeQuery();
				if(resultSet.next()) {
					polPremium = resultSet.getDouble(1);
					System.out.println("Getting policy premium: " + polPremium);
				}
			} catch (SQLException e) {
				throw new InsuranceException("problem while creating PS object"+e.getMessage());
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new InsuranceException("problem while closing");
				}

			}
			System.out.println("policy premium in dao is : " + polPremium);
			return polPremium;

		}

		@Override
		public List<String> getSelectedAnswers(int polNum) throws InsuranceException {
			// TODO Auto-generated method stub
			List<String> selectedAns = new ArrayList<String>();
			PolicyDetails details = null;
			boolean isFound = false;
			connection = JdbcConnect.getConnection();
			try {
				
				prepareStatement = connection.prepareStatement(AgentQueryValues.GET_SELECTED_ANSWERS);
				prepareStatement.setInt(1, polNum);
				resultSet = prepareStatement.executeQuery();
				//System.out.println("policy number : "+polNum);
				while(resultSet.next()) {
					selectedAns.add(resultSet.getString(1));
				}
			} catch (SQLException e) {
				throw new InsuranceException("problem while creating PS object "+e.getMessage());
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new InsuranceException("problem while closing");
				}

			}
			System.out.println("Inside dao answers are:"+selectedAns);
			return selectedAns;

		}

		@Override
		public void addPolicyCreator(int polNumber, String username) throws InsuranceException {
			// TODO Auto-generated method stub
			int isInserted = 0;
			try
			{
				connection = JdbcConnect.getConnection();
				prepareStatement = connection.prepareStatement(AgentQueryValues.ADD_POLICY_CREATOR);
				prepareStatement.setInt(1, polNumber);
				prepareStatement.setString(2,username);
				//prepareStatement.setString(3, userRole.getRoleCode());
				
				isInserted = prepareStatement.executeUpdate();
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
		}
		@Override
		public String getLineOfBusinessIdByName(String busSegName) throws InsuranceException {
			// TODO Auto-generated method stub
			String businessSegmentId = null;
			boolean found = false;
			try {
				connection = JdbcConnect.getConnection();

				prepareStatement = connection.prepareStatement(AgentQueryValues.GET_LOB_NAME);
				prepareStatement.setString(1, busSegName);
				
				resultSet = prepareStatement.executeQuery();
				found = resultSet.next();
				if(found == true) {
					businessSegmentId = resultSet.getString(1);
					//System.out.println(name + " " + pwd);
				}
			} catch (SQLException e) {
				throw new InsuranceException("problem while creating PS object");
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new InsuranceException("problem while closing");
				}

			}
			return businessSegmentId;
		}

		@Override
		public boolean isUserExists(String userName) throws InsuranceException {
			// TODO Auto-generated method stub
			boolean found = false;
			try {
				connection = JdbcConnect.getConnection();

				prepareStatement = connection.prepareStatement(AdminQueryValues.USER_EXISTS);
				prepareStatement.setString(1, userName);
				resultSet = prepareStatement.executeQuery();
				if(resultSet.next()) {
					found = true;
				}
			} catch (SQLException e) {
				throw new InsuranceException("problem while creating PS object");
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new InsuranceException("problem while closing");
				}

			}
	        return found;
		}

		@Override
		public int accountCreation(Accounts account, String userName) throws InsuranceException {
			// TODO Auto-generated method stub
			connection = JdbcConnect.getConnection();
			int isInserted = 0;
			try {
				prepareStatement = connection.prepareStatement(AdminQueryValues.ACCOUNT_CREATION);
				prepareStatement.setString(1, account.getInsuredName());
				prepareStatement.setString(2, account.getInsuredStreet());
				prepareStatement.setString(3, account.getInsuredCity());
				prepareStatement.setString(4, account.getInsuredState());
				prepareStatement.setInt(5, account.getInsuredZip());
				prepareStatement.setString(6, account.getLineOfBusiness());
				prepareStatement.setString(7, userName);
				
				isInserted = prepareStatement.executeUpdate();
				

			} catch (SQLException e) {
				throw new InsuranceException("problem while creating PS object");
			} finally {
				try {
					resultSet.close();
					prepareStatement.close();
					connection.close();
				} catch (SQLException e) {
					throw new InsuranceException("problem while closing");
				}

			}
			
			return isInserted;

		}

		@Override
		public boolean accountValidation(String userName) throws InsuranceException {
			// TODO Auto-generated method stub
			boolean found = false;
			try {
				connection = JdbcConnect.getConnection();

				prepareStatement = connection.prepareStatement(AgentQueryValues.VALIDATE_ACCOUNT_QUERY);
				prepareStatement.setString(1, userName);
				
				resultSet = prepareStatement.executeQuery();
				found = resultSet.next();
			} catch (SQLException e) {
				throw new InsuranceException("problem while creating PS object");
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new InsuranceException("problem while closing");
				}

			}
	        return found;

		}
	
}	
	
	
	

