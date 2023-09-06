package com.dakr.service;

import java.util.List;

import com.dakr.model.Employee;

public interface EmployeeService {

public Employee saveEmployee(Employee employee);
	
	public void deleteEmployee(Integer id);
	
	public Employee getEmployee(Integer id);
	
	public List<Employee> geAlltEmployee();
	
	public Employee updateEmployee(Employee employee,Integer id);
	
}
