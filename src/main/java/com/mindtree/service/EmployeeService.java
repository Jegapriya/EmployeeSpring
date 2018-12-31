package com.mindtree.service;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.mindtree.entity.Employee;

public interface EmployeeService {

	public String deleteEmployee(ApplicationContext con,String username);
	public String addEmployee(ApplicationContext con,Employee employee);
	public List<Employee> getAllEmployee(ApplicationContext con);
	public Employee getEmployeeByUsername(ApplicationContext con,String username);
	public String checkLogin(ApplicationContext con,Employee employee);
}
