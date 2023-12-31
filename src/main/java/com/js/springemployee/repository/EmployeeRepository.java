package com.js.springemployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.js.springemployee.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	
	@Query("select e from Employee e where e.name=:ename")
    public Employee findByName(@Param("ename") String name);
}
