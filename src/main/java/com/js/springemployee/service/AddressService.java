package com.js.springemployee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.js.springemployee.dao.AddressCRUD;
import com.js.springemployee.dao.EmployeeCRUD;
import com.js.springemployee.dto.Address;
import com.js.springemployee.dto.Employee;

@Service
public class AddressService {

	@Autowired
	AddressCRUD crud;
	
	@Autowired
	EmployeeCRUD employeeCRUD;
	
	public Address insertAddress(int id,Address a) {
		Employee e = employeeCRUD.getEmployeeById(id);
		a.setEmployee(e);
		return crud.insertAddress(a);
	}
}
