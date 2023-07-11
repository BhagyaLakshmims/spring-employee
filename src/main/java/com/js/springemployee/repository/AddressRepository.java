package com.js.springemployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.js.springemployee.dto.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
