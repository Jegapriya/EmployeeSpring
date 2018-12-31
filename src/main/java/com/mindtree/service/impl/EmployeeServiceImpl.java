package com.mindtree.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;

import com.mindtree.dao.impl.EmployeeDaoImpl;
import com.mindtree.entity.Employee;
import com.mindtree.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{

	EmployeeDaoImpl daoImpl;
	
	@Override
	public String deleteEmployee(ApplicationContext con, String username) {
		
		daoImpl=con.getBean("objEmployeeDao",EmployeeDaoImpl.class);
		try
		{
			return daoImpl.deleteEmployee(username);
		}
		catch(Exception e)
		{
			return "No such data found";
		}
	}

	@Override
	public String addEmployee(ApplicationContext con, Employee employee) {
		daoImpl=con.getBean("objEmployeeDao",EmployeeDaoImpl.class);
		
		try
		{
			return daoImpl.addEmployee(employee);
		}
		catch(Exception e)
		{
			return "No data added";
		}
	}

	@Override
	public List<Employee> getAllEmployee(ApplicationContext con) {
		
		try
		{
			return daoImpl.getAllEmployees();
		}
		catch(Exception e)
		{
			return new ArrayList<Employee>();
		}
	}

	@Override
	public Employee getEmployeeByUsername(ApplicationContext con, String username) {
		
		daoImpl=con.getBean("objEmployeeDao",EmployeeDaoImpl.class);
		try
		{
			return daoImpl.getAllEmployees().stream().filter(e->e.getUsername().equalsIgnoreCase(username)).collect(Collectors.toList()).get(0);
		}
		catch(Exception e)
		{
			return new Employee();
		}
	}

	@Override
	public String checkLogin(ApplicationContext con,Employee employee) {
		daoImpl=con.getBean("objEmployeeDao",EmployeeDaoImpl.class);
		try
		{
			Employee emp=daoImpl.getAllEmployees().stream().filter(e->e.getUsername().equals(employee.getUsername() ) && e.getPassword().equals(employee.getPassword())).collect(Collectors.toList()).get(0);
			return "Successfully login";
		}
		catch(Exception e)
		{
			return "Invalid username or password";
		}
	}

}
