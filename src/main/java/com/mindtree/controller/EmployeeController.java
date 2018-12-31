package com.mindtree.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.entity.Employee;
import com.mindtree.service.impl.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	private ApplicationContext con=new ClassPathXmlApplicationContext("Beans.xml");
	private EmployeeServiceImpl empService=con.getBean("objEmployeeService",EmployeeServiceImpl.class);
	
	
	@RequestMapping("/Sample")
	public String sampleNew()
	{
		return "Sample";
	}
	
	@RequestMapping("/GetAll")
	public List<Employee> getAllEmployees()
	{
		return empService.getAllEmployee(con);
	}

	@RequestMapping("/AddEmployee")
	public String addEmployee(@RequestBody Employee employee)
	{
		return empService.addEmployee(con, employee);
	}
	
	@RequestMapping("/DeleteEmployee/{username}")
	public String deleteEmployee(@PathVariable String username)
	{
		return empService.deleteEmployee(con, username);
	}
	
	@RequestMapping("/GetEmployeeByUsername/{username}")
	public Employee getEmployeeByUsername(@PathVariable String username)
	{
		return empService.getEmployeeByUsername(con, username);
	}
	
	@RequestMapping("/CheckValidEmployee")
	public String checkValidEmployee(@RequestBody Employee employee)
	{
		return empService.checkLogin(con, employee);
	}
}
