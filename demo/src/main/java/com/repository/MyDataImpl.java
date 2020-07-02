package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pojo.Employee;

@Repository
public class MyDataImpl implements EmployeeRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int getCount() {
		int count = 0;
		count = jdbcTemplate.queryForObject("select count(*) from all_tables", Integer.class);
		return count;
	}
	
	@Override
	public int save(Employee employee) {
		// TODO Auto-generated method stub

		int saved = jdbcTemplate.update("insert into emp1 values(?,?,?,?)", employee.getEmpId(), employee.getEmpName(),
				employee.getEmpAddress(), employee.getSalary());
		return saved;
	}

	@Override
	public Optional<Employee> findById(int id) {
		// TODO Auto-generated method stub
		String SQL_FIND = "select * from emp1 where empId=?";

		Optional<Employee> optional = jdbcTemplate.queryForObject(SQL_FIND, new Object[] { id },
				(rs, rownum) -> Optional.of(new Employee(rs.getInt("empId"), 
											rs.getString("empName"),
											rs.getString("empAddress"), 
											rs.getLong("salary"))));
		return optional;
	}
	

	@Override
	public List<Employee> findAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
