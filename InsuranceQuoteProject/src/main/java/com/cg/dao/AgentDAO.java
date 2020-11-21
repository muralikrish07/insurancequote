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

	
}	
	
	
	

