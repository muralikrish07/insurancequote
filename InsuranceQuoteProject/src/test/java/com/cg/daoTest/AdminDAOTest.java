package com.cg.daoTest;
import com.cg.dao.*;

import static org.junit.Assert.*;
import com.cg.exceptions.*;
import org.junit.Test;
import com.cg.service.*;
public class AdminDAOTest {

	@Test
	public void testUserExists() throws InsuranceException{
		AdminDAO obj=new AdminDAO();
		boolean f=obj.isUserExists("krish1234");
		assertEquals(true, f);
		
		
		
	}
	@Test
	public void testLogin()throws InsuranceException
	{
		AdminDAO obj =new AdminDAO();
		boolean f=obj.loginValidation("krish1234", "India1234");
		assertEquals(true,f);
	}
   @Test
   public void testGetRoleCode() throws InsuranceException
   {
	   AdminDAO obj=new AdminDAO();
	   String ans=obj.getRoleCode("krish1234", "India1234");
	   assertEquals("I",ans);
   }
   

}
