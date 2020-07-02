package com.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.repository.EmployeeRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pojo.Employee;
import com.repository.*;

@RestController
public class EmployeeControllers {
	
	@Autowired
	// @Qualifier()
	EmployeeRepository repo;

	@GetMapping("/myemployees")
	public String myEmployee() {
		return "emp";
	}

	@GetMapping("/employees/{myid}")
	public Employee getEmployee(@PathVariable("myid") int id) {
		Employee employee = new Employee();
		employee.setEmpId(id);

		return employee;
	}

	@GetMapping("/employees/id/{myid}/name/{name}")
	public Employee getEmployee(@PathVariable("myid") int id, @PathVariable String name) {
		Employee employee = new Employee();
		employee.setEmpId(id);
		employee.setEmpName(name);
		return employee;
	}

	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee) {
		employee.setEmpName(employee.getEmpName().toUpperCase());

		if (repo.save(employee) > 0) {
			return employee;
		}
		return new Employee();
	}

	@PostMapping(path = "/employees-form", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public Employee saveEmployeeForm(Employee employee) {
		employee.setEmpName(employee.getEmpName().toUpperCase());
		return employee;
	}

	@GetMapping("/employees-entity/{myid}")
	public ResponseEntity<Employee> getEmployee_entity(@PathVariable("myid") int id) {
		Employee employee = new Employee();
		employee.setEmpId(id);

		return new ResponseEntity<Employee>(employee, HttpStatus.NO_CONTENT);
	}

	@GetMapping("/employees-headers/{myid}")
	public ResponseEntity<Employee> getEmployee_headers(@PathVariable("myid") int id) {
		// Employee employee = new Employee();
		// employee.setEmpId(id);

		Optional<Employee> optional = repo.findById(id);
		System.out.println(optional.get());
		HttpHeaders headers = new HttpHeaders();
		headers.add("value1", "myvalue123");
		headers.add("authorized", "YES");

		return new ResponseEntity<Employee>(optional.get(), headers, HttpStatus.FOUND);
	}
	
}
