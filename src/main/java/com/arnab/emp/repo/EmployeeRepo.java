package com.arnab.emp.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.arnab.emp.entity.Employee;

@Repository
public class EmployeeRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void save(Employee e) {
		String sql = "INSERT INTO EMPLOYEE(ID, NAME, CITY) VALUES(" + e.getId() + ", '" + e.getName() + "', '" + e.getCity() + "')";
		jdbcTemplate.update(sql);
	}
	
	public Employee getEmployee(int id) {
		String sql = "SELECT ID, NAME, CITY FROM EMPLOYEE WHERE ID = " + id;	
		List<Employee> list = jdbcTemplate.query(sql, new RowMapper<Employee>() {
			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Employee(rs.getInt("ID"), rs.getString("NAME"), rs.getString("CITY"));
			}			
		});
		return list.get(0);
	}
	
}
