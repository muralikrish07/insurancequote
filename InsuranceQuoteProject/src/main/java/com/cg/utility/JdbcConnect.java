package com.cg.utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.cg.exceptions.InsuranceException;
import oracle.jdbc.OracleDriver;

	
public class JdbcConnect {
		
		private static Connection connection = null;

		static String url = "jdbc:oracle:thin:@localhost:1521:xe";
		public static Connection getConnection() throws InsuranceException {
			
			try {
				DriverManager.registerDriver(new OracleDriver());
				connection = DriverManager.getConnection(url, "system", "msdhoni1");
				System.out.println("connected");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new InsuranceException("Error occurred in connecting to database"+e.getMessage());
			}
			return connection;
		}
	}

	
	
	

