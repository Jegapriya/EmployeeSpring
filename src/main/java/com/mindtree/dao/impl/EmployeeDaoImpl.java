package com.mindtree.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.mindtree.dao.EmployeeDao;
import com.mindtree.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

	private HibernateTemplate template;
	
	
	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	public String addEmployee(Employee employee) throws Exception{
		
		Session session=template.getSessionFactory().openSession();
		session.save(employee);
		session.beginTransaction().commit();
		return "Successfully added";
	}

	@SuppressWarnings("deprecation")
	@Override
	public String deleteEmployee(String username) throws Exception{
		Session session=template.getSessionFactory().openSession();
		session.delete(template.get(Employee.class, username));
		session.beginTransaction().commit();
		return "Successfully deleted";
	}

	@Override
	public List<Employee> getAllEmployees() throws Exception{
		List<Employee> list=template.loadAll(Employee.class);
		return list;
	}

}
