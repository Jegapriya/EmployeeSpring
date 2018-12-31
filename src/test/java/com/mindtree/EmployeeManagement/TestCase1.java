package com.mindtree.EmployeeManagement;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mindtree.entity.Employee;
import com.mindtree.service.impl.EmployeeServiceImpl;

public class TestCase1 {

	private ApplicationContext con=new ClassPathXmlApplicationContext("Beans.xml");
	private EmployeeServiceImpl empService=con.getBean("objEmployeeService",EmployeeServiceImpl.class);
	private Employee emp;
	
	@Before
	public void testBefore()
	{
		emp=new Employee();
		emp.setEmailId("jegapriyamunieswaran@gmail.com");
		emp.setUsername("jegapriyanew");
		emp.setPassword("jpriya");
		emp.setGender("female");
		emp.setDateOfBirth("9/12/1994");
		emp.setFullName("jegapriya");
		emp.setSecurityQuestion("Which you like most?");
		emp.setSecurityAnswer("Icecream");
	}
	
	@Test
	public void test()
	{
		assertEquals("Successfully added",empService.addEmployee(con, emp));
	}
	
	@After
	public void testAfter()
	{
		System.out.println("Test done...");
	}
}

