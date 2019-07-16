package com.arnab.emp.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arnab.emp.entity.Employee;
import com.arnab.emp.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping(value = "/get/{id}")
	public Employee getEmployee(@PathVariable int id) throws InterruptedException, ExecutionException {
		return service.getEmployee(id).get();
	}
	
	@GetMapping(value = "/save")
	public void saveEmployee(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("city") String city) {
		Employee e = new Employee();
		e.setId(Integer.parseInt(id));
		e.setName(name);
		e.setCity(city);
		service.saveEmployee(e);
	}
	
}
