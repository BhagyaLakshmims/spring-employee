package com.js.springemployee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.js.springemployee.dto.Employee;
import com.js.springemployee.dto.ResponseStructure;
import com.js.springemployee.service.EmployeeService;


@RestController
public class EmployeeController {
    
	
	@Autowired
	EmployeeService service;
	
	
	@PostMapping("/employees")
	public ResponseStructure<Employee>  insertEmployee(@RequestBody Employee e) {
		return service.insertEmployee(e);
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return service.getEmployees();
	}
	
	
	@GetMapping("/employees/{id}")
	public ResponseStructure<Employee> getEmployeeById(@PathVariable int id) {
		return service.getEmployeeById(id);
	}
	
	@DeleteMapping("/employees")
	public ResponseStructure<Employee> deleteEmployeeById(@RequestParam int id) {
		
		return service.deleteEmployeeById(id);
		
	}
	
	@PutMapping("/employees")
	public ResponseStructure<Employee> updateEmployeeById(@RequestBody Employee e) {
		return service.updateEmployeeById(e);
	}
	
	@GetMapping("/employees/name")
	public ResponseStructure<Employee> GetEmployeeByName(@RequestParam String name) {
		return service.GetEmployeeByName(name);
	}
}
