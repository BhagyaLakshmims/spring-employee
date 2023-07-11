package com.js.springemployee.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.js.springemployee.dao.EmployeeCRUD;
import com.js.springemployee.dto.Employee;
import com.js.springemployee.dto.ResponseStructure;
import com.js.springemployee.exception.NoIdFoundException;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeCRUD crud;
	
	public ResponseStructure<Employee> insertEmployee(Employee e) {
		ResponseStructure<Employee> response = new ResponseStructure<Employee>();
		e.setDoj(LocalDate.now());
		Employee em = crud.insertEmployee(e);
		if(em!=null) {
			response.setData(em);
			response.setMessage("Inserted Successfully");
			response.setStatuscode(HttpStatus.CREATED.value());
		}
		
		else {
		response.setData(null);
		response.setMessage("Failed to insert");
		response.setStatuscode(HttpStatus.NOT_FOUND.value());
		}
		return response;
	}
	
	public List<Employee> getEmployees(){
		return crud.getEmployees();
	}
	
	public ResponseStructure<Employee> getEmployeeById(int id) {
		ResponseStructure<Employee> response = new ResponseStructure<Employee>();
		Employee emp = crud.getEmployeeById(id);
		if(emp!=null) {
			response.setData(emp);
			response.setMessage("Found");
			response.setStatuscode(HttpStatus.CREATED.value());
			return response;
		}
		
		else {
			throw new NoIdFoundException("Employee not Found");
		}
		
	}
	
	public ResponseStructure<Employee> deleteEmployeeById(int id) {
		ResponseStructure<Employee> response = new ResponseStructure<Employee>();
		boolean b = crud.deleteEmployeeById(id);
		if(b) {
			response.setData(null);
			response.setMessage("Deleted Successfully");
			response.setStatuscode(HttpStatus.CREATED.value());
		}
		else {
			
			response.setData(null);
			response.setMessage("Not Found");
			response.setStatuscode(HttpStatus.NOT_FOUND.value());
			
		}
		return response;
	}

	public ResponseStructure<Employee> updateEmployeeById(Employee e) {
		ResponseStructure<Employee> response = new ResponseStructure<Employee>();
		Employee empl = crud.updateEmployeeById(e);
		if(empl!=null) {
			response.setData(empl);
			response.setMessage("Found");
			response.setStatuscode(HttpStatus.CREATED.value());
		}
       else {
			
			response.setData(null);
			response.setMessage("Not Found");
			response.setStatuscode(HttpStatus.NOT_FOUND.value());
			
		}
		return response;
		
	}
	
	public ResponseStructure<Employee> GetEmployeeByName(String name) {
		ResponseStructure<Employee> response = new ResponseStructure<Employee>();
		Employee e = crud.GetEmployeeByName(name);
		
		if(e!=null) {
			response.setData(e);
			response.setMessage("Found");
			response.setStatuscode(HttpStatus.CREATED.value());
		}
		 else {
				
				response.setData(null);
				response.setMessage("Not Found");
				response.setStatuscode(HttpStatus.NOT_FOUND.value());
				
			}
			return response;
		
	}
	
}
	
