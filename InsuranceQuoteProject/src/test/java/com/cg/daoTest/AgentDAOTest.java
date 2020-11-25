package com.cg.daoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.dao.AgentDAO;
import com.cg.exceptions.InsuranceException;

public class AgentDAOTest {

	@Test
	public void testUserExist() throws InsuranceException {
		AgentDAO obj=new AgentDAO();
		boolean f=obj.isUserExists("tommy1234");
		assertEquals(true,f);
		
		
	}
	@Test
	public void testAccountValidation()throws InsuranceException
	{
		AgentDAO obj=new AgentDAO();
		boolean f=obj.accountValidation("tommy1234");
		assertEquals(true,f);
	}
	@Test
	public void testAccountExist()throws InsuranceException
	{
		AgentDAO obj=new AgentDAO();
		boolean f=obj.isAccountExists(10000000);
		assertEquals(true,f);
	}

}
