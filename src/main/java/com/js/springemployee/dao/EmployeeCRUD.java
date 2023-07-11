package com.js.springemployee.dao;

import java.net.http.HttpResponse.ResponseInfo;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.js.springemployee.dto.Employee;
import com.js.springemployee.repository.EmployeeRepository;


@Repository
public class EmployeeCRUD {

	@Autowired
	EmployeeRepository repository;
	
	public Employee insertEmployee(Employee e) {
		return repository.save(e);
		
	}
	
	public List<Employee> getEmployees(){
		return repository.findAll();
	}
	
	public Employee getEmployeeById(int id) {
		Optional<Employee> op = repository.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		else {
			return null;
		}
	}
	
	public boolean deleteEmployeeById(int id) {
		Optional<Employee> op = repository.findById(id);
		if(op.isPresent()) {
			Employee e = op.get();
			repository.delete(e);
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public Employee updateEmployeeById(Employee e) {
		return repository.save(e);
	}
	
	public Employee GetEmployeeByName(String name) {
		return repository.findByName(name);
	}
}
