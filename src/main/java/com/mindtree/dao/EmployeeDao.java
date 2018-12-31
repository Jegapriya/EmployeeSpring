package com.mindtree.dao;

import java.util.List;

import com.mindtree.entity.Employee;

public interface EmployeeDao {

	public String addEmployee(Employee employee) throws Exception;
	public String deleteEmployee(String username) throws Exception;
	public List<Employee> getAllEmployees() throws Exception;
}
