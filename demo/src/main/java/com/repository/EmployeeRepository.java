package com.repository;

import java.util.List;
import java.util.Optional;

import com.pojo.Employee;

public interface EmployeeRepository {
	
	public Optional<Employee> findById(int id);
	
	public int save(Employee e);

	List<Employee> findAllEmployee();
}