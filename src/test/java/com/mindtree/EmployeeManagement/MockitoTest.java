package com.mindtree.EmployeeManagement;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mindtree.dao.impl.EmployeeDaoImpl;
import com.mindtree.entity.Employee;
import com.mindtree.service.impl.EmployeeServiceImpl;


@RunWith(MockitoJUnitRunner.Silent.class)
public class MockitoTest{

	private ApplicationContext con=new ClassPathXmlApplicationContext("Beans.xml");
	
	private Employee emp;
	
	private List<Employee> empList;
	
	@Mock
	private EmployeeDaoImpl empDao;
	
	@InjectMocks
	private EmployeeServiceImpl empService=con.getBean("objEmployeeService",EmployeeServiceImpl.class);;
	
	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
		empList=new ArrayList<>();
		emp=new Employee();
		emp.setUsername("kamal");
		emp.setPassword("Kamal");
		emp.setEmailId("kamal@gmail.com");
		emp.setFullName("Kamal");
		emp.setDateOfBirth("2/12/1990");
		emp.setGender("Male");
		emp.setSecurityQuestion("Which place you like most?");
		emp.setSecurityAnswer("temple");
		empList.add(emp);
		System.out.println(empList);
	}
	
	@Test
	public void testSelect()
	{
		try {
			org.mockito.Mockito.when(empDao.getAllEmployees()).thenReturn(empList);
			System.out.println(empDao.getAllEmployees().get(0));
			assertEquals("kamala@gmail.com",empService.getAllEmployee(con).get(0).getEmailId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
}
