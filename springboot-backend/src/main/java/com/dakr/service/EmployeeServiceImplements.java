package com.dakr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dakr.model.Employee;
import com.dakr.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplements implements  EmployeeService{
	
	@Autowired
	private EmployeeRepository repository;

	@Override
	public Employee saveEmployee(Employee employee) {
		Employee employee2=repository.save(employee);
		
		return employee2;
	}

	@Override
	public void deleteEmployee(Integer id) {
		repository.deleteById(id);
		
	}
	
	
	@Override
	public Employee getEmployee(Integer id) {
		Employee employee=repository.findById(id).get();
		return employee;
	}

	@Override
	public List<Employee> geAlltEmployee() {
		List<Employee> list=repository.findAll();
		return list;
	}

	@Override
	public Employee updateEmployee(Employee employee, Integer id) {
		
		Employee employee2=repository.findById(id).get();
		employee2.setId(id);
		employee2.setFirstName(employee.getFirstName());
		employee2.setLastName(employee.getLastName());
		employee2.setEmailId(employee.getEmailId());
		return repository.save(employee2);
	}
	

}
