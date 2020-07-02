package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pojo.Employee;	

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>  {
	List<Employee> findByEmpName(String empName);
	
	@Query(value="SELECT * FROM employee e where e.emp_address=?1", nativeQuery=true)
	List<Employee> findByEmpAddress(String empAddress);
	
}
