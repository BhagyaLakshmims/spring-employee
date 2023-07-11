package com.js.springemployee.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.js.springemployee.dto.Address;
import com.js.springemployee.repository.AddressRepository;

@Repository
public class AddressCRUD {
	
	@Autowired
	AddressRepository repository;
	
	public Address insertAddress(Address a) {
		return repository.save(a);
		
	}

}
