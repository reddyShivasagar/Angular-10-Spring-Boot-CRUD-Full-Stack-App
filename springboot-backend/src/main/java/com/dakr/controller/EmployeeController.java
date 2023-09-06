package com.dakr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dakr.model.Employee;
import com.dakr.service.EmployeeServiceImplements;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImplements service;
	
	//Save Employee
	@PostMapping("/employees")
	public String save(@RequestBody Employee employee) {
		Employee employee2=service.saveEmployee(employee);
		if(employee2!=null) {
			return "Data Saved sucessfully";
		}
		return "Data not Saved";
		
	}
	
	//Delete Employee by id
	@DeleteMapping("/employees/{Id}")
	public void delete(@PathVariable Integer Id) {
		service.deleteEmployee(Id);
		
	}
	
	//get Employee by Id
	@GetMapping("/employees/{Id}")
	public Employee get(@PathVariable Integer Id) {
		return service.getEmployee(Id);
	}
	//GetAll Employee
	@GetMapping("/employees")
	public List<Employee> getAll(){
		return service.geAlltEmployee();
	}
	
	//Update the employee data by id
	@PutMapping("/employees/{Id}")
	public Employee update(@RequestBody Employee employee,@PathVariable Integer Id) {
		return service.updateEmployee(employee, Id);
		
	}
}
