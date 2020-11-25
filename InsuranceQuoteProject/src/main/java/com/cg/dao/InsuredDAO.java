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

public class InsuredDAO implements IInsuredDAO{
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet=null;

		@Override
		public int accountCreation(Accounts account,String userName) throws InsuranceException {
			// TODO Auto-generated method stub
int accountNumber=10000000;
account.setAccountNumber(accountNumber);
			connection = JdbcConnect.getConnection();
			int isInserted = 0;
			try {
				prepareStatement = connection.prepareStatement(InsuredQueryValues.ACCOUNT_CREATION);
				prepareStatement.setInt(1,account.getAccountNumber());
				prepareStatement.setString(2, account.getInsuredName());
				prepareStatement.setString(3, account.getInsuredStreet());
				prepareStatement.setString(4, account.getInsuredCity());
				prepareStatement.setString(5, account.getInsuredState());
				prepareStatement.setInt(6, account.getInsuredZip());
				prepareStatement.setString(7, account.getLineOfBusiness());
				prepareStatement.setString(8, userName);
				
				isInserted = prepareStatement.executeUpdate();
				accountNumber++;
				

			} catch (SQLException e) {
				throw new InsuranceException("problem while creating PS object0");
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
		public List<Policy> getInsuredPolicies(int accNo) throws InsuranceException {
			// TODO Auto-generated method stub
			List<Policy> policies = new ArrayList<Policy>();
			Policy policy;
			try {
				connection = JdbcConnect.getConnection();
				prepareStatement = connection.prepareStatement(InsuredQueryValues.GET_INSURED_POLICY);	
				prepareStatement.setInt(1, accNo);
				resultSet = prepareStatement.executeQuery();
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
		public int getAccountNumber(String username) throws InsuranceException {
			// TODO Auto-generated method stub
			int accNo = 0;
			try {
				connection = JdbcConnect.getConnection();

				prepareStatement = connection.prepareStatement(InsuredQueryValues.GET_ACCOUNT_NUMBER);
				prepareStatement.setString(1, username);
				
				resultSet = prepareStatement.executeQuery();
				if(resultSet.next()) {
					
					accNo = resultSet.getInt(1);
					
				}
				else {
					System.out.println("No Account so please create one");
				}
			} catch (SQLException e) {
				throw new InsuranceException("problem while creating PS object 1");
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new InsuranceException("problem while closing");
				}

			}
	        return accNo;

		}


		@Override
		public Accounts getAccountDetails(Integer accNumber) throws InsuranceException {
			// TODO Auto-generated method stub
			Accounts account = new Accounts();
			try {
				connection = JdbcConnect.getConnection();
				prepareStatement = connection.prepareStatement(InsuredQueryValues.GET_ACCOUNT_DETAILS);	
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
		public String getBusSegName(String busSegId) throws InsuranceException {
			// TODO Auto-generated method stub
			String busSegName = null;
			try {
				connection = JdbcConnect.getConnection();

				prepareStatement = connection.prepareStatement(InsuredQueryValues.GET_BUS_SEG_NAME);
				prepareStatement.setString(1, busSegId);
				resultSet = prepareStatement.executeQuery();
				if(resultSet.next()) {
					busSegName = resultSet.getString(1);
					System.out.println("Getting business segment id :" + busSegName);
				}
			} catch (SQLException e) {
				throw new InsuranceException("problem while creating PS object2"+e.getMessage());
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
		/*public static void main(String[] args) throws InsuranceException {
			System.out.println(getBusSegName("R02"));
		}*/
		@Override
		public Double getPolicyPremium(Integer polNum) throws InsuranceException {
			// TODO Auto-generated method stub
			Double polPremium = 0.0;
			try {
				connection = JdbcConnect.getConnection();

				prepareStatement = connection.prepareStatement(InsuredQueryValues.GET_POLICY_PREMIUM);
				prepareStatement.setInt(1, polNum);
				resultSet = prepareStatement.executeQuery();
				if(resultSet.next()) {
					polPremium = resultSet.getDouble(1);
					System.out.println("Getting policy premium: " + polPremium);
				}
			} catch (SQLException e) {
				throw new InsuranceException("problem while creating PS object3"+e.getMessage());
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
		public  List<String> getSelectedAnswers(Integer polNum) throws InsuranceException {
			// TODO Auto-generated method stub
			List<String> selectedAns = new ArrayList<String>();
			PolicyDetails details = null;
			boolean isFound = false;
			connection = JdbcConnect.getConnection();
			try {
				
				prepareStatement = connection.prepareStatement(InsuredQueryValues.GET_SELECTED_ANSWERS);
				prepareStatement.setInt(1, polNum);
				resultSet = prepareStatement.executeQuery();
				//System.out.println("policy number : "+polNum);
				while(resultSet.next()) {
					selectedAns.add(resultSet.getString(1));
				}
			} catch (SQLException e) {
				throw new InsuranceException("problem while creating PS object4 "+e.getMessage());
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
		public List<PolicyQuestions> getPolicyQuestions(String lineOfBusinessId) throws InsuranceException {
			// TODO Auto-generated method stub
			List<PolicyQuestions> policyQuestions = new ArrayList<PolicyQuestions>();
			PolicyQuestions polQues = null;
			try {
				connection = JdbcConnect.getConnection();
				System.out.println(lineOfBusinessId);
				prepareStatement = connection.prepareStatement(AdminQueryValues.GET_POLICY_QUESTIONS);
				prepareStatement.setString(1, lineOfBusinessId);
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
				throw new InsuranceException("problem while creating PS object5"+e.getMessage());
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
		public boolean accountValidation(String username) throws InsuranceException {
			// TODO Auto-generated method stub
			boolean found = false;
			try {
				connection = JdbcConnect.getConnection();

				prepareStatement = connection.prepareStatement(InsuredQueryValues.VALIDATE_ACCOUNT_QUERY);
				prepareStatement.setString(1, username);
				
				resultSet = prepareStatement.executeQuery();
				found = resultSet.next();
			} catch (SQLException e) {
				throw new InsuranceException("problem while creating PS object6");
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
		public String getLineOfBusinessIdByName(String lineOfBusinessName) throws InsuranceException {
			// TODO Auto-generated method stub
			String businessSegmentId = null;
			boolean found = false;
			try {
				connection = JdbcConnect.getConnection();

				prepareStatement = connection.prepareStatement(InsuredQueryValues.GET_LOB_NAME);
				prepareStatement.setString(1, lineOfBusinessName);
				
				resultSet = prepareStatement.executeQuery();
				found = resultSet.next();
				if(found == true) {
					businessSegmentId = resultSet.getString(1);
					//System.out.println(name + " " + pwd);
				}
			} catch (SQLException e) {
				throw new InsuranceException("problem while creating PS object7");
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

				prepareStatement = connection.prepareStatement(InsuredQueryValues.USER_EXISTS);
				prepareStatement.setString(1, userName);
				resultSet = prepareStatement.executeQuery();
				if(resultSet.next()) {
					found = true;
				}
			} catch (SQLException e) {
				throw new InsuranceException("problem while creating PS object8");
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




