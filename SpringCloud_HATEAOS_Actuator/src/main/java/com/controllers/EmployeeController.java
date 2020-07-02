package com.controllers;

import java.util.ArrayList;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pojo.Employee;
import com.pojo.Project;

@RestController
public class EmployeeController {

	@GetMapping("/employees/{id}")
	public Employee getEmpById(@PathVariable int id) {
		return new Employee(1, "emp name", "address mumbai", 123l, null);

	}

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(1, "empName", "Mumbai", 1234, null));
		employees.add(new Employee(2, "empName", "Pune", 100, null));
		employees.add(new Employee(123, "emsjcb", "Mumbai", 1, null));
		return employees;
	}

	@GetMapping("/employees/{empid}/projects/{id}")
	public Project getProjectById(@PathVariable int empid, int id) {
		return new Project(1, "project1", "Java");

	}

	@GetMapping("/employees/{empid}/projects")
	public List<Project> getProjectsByEmployeeId(@PathVariable int empid) {
		List<Project> projects = new ArrayList<>();
		projects.add(new Project(1, "Banking app", "JAVA"));
		projects.add(new Project(2, "Employee app", "JAVA"));
		projects.add(new Project(7, "Library app", "SPRING"));
		return projects;

	}

	@GetMapping("/employees-hateaos/{id}")
	public ResponseEntity<Employee> getEmployee_hateaos(@PathVariable int id) {

		Employee employee = new Employee(1, "emp name", "address mumbai", 123l, null);
		employee.add(WebMvcLinkBuilder.linkTo(EmployeeController.class).slash("employees").slash(id).withSelfRel());
		// employee.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).getEmployees())
		// .withSelfRel());
		ResponseEntity<Employee> entity = new ResponseEntity<Employee>(employee, HttpStatus.OK);
		return entity;
	}

	@GetMapping("/employees-hateaos-methods/{empid}")
	public Employee getEmployees_hateaos_methods(@PathVariable int empid) {
		Link projectsLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).getProjectsByEmployeeId(empid))
				.withRel("allProjects");

		Employee employees = new Employee(1, "empName", "empAddress", 1234, null);
		employees.add(projectsLink);
		return employees;

	}


}
