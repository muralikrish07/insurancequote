package com.cg.daoTest;

import static org.junit.Assert.*;

import org.junit.Test;
import com.cg.dao.*;
import com.cg.exceptions.*;
public class InsuredDAOTest {

	@Test
	public void testUserExist() throws InsuranceException {
		InsuredDAO obj=new InsuredDAO();
		boolean f=obj.isUserExists("krish1234");
		assertEquals(true,f);
		
		
	}
	@Test
	public void testAccountValidation()throws InsuranceException
	{
		InsuredDAO obj=new InsuredDAO();
		boolean f=obj.accountValidation("krish1234");
		assertEquals(true,f);
	}
	@Test
	public void testGetAccountNumber()throws InsuranceException
	{
		InsuredDAO obj=new InsuredDAO();
		int ans=obj.getAccountNumber("krish1234");
		assertEquals(10000001,ans);
	}
}
